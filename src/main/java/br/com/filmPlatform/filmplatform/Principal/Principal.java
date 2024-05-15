package br.com.filmPlatform.filmplatform.Principal;

import br.com.filmPlatform.filmplatform.modal.DadosSerie;
import br.com.filmPlatform.filmplatform.modal.DadosTemporada;
import br.com.filmPlatform.filmplatform.modal.Episodio;
import br.com.filmPlatform.filmplatform.modal.Serie;
import br.com.filmPlatform.filmplatform.repository.SerieRepository;
import br.com.filmPlatform.filmplatform.service.ConverterDados;
import br.com.filmPlatform.filmplatform.service.Requisicao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    Scanner entrada = new Scanner(System.in);
    Requisicao requisicao = new Requisicao();
    ConverterDados dados = new ConverterDados();
    List<DadosTemporada> listaDeTemporada = new ArrayList<>();
    List<Serie> serieList = new ArrayList<>();

    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=f6239180";

    @Autowired
    private SerieRepository repository;

    public void menuPrincipal() {
        var opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    1 - Buscar séries
                    2 - Buscar episódios
                    3 - Listar séries
                    
                    0 - Sair
                    Opção:""");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    buscarSerie();
                    break;
                case 2:
                    buscarEpisodio();
                    break;
                case 3:
                    listarSeries();
                    break;
                case 0:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public Principal(SerieRepository repository) {
        this.repository = repository;
    }

    private DadosSerie getSerie(){
        System.out.println("Digite o nome da série para buscar: ");
        var nomeDaSerie = entrada.nextLine().toLowerCase().replace(" ", "%20");

        var json = requisicao.obterDados(ENDERECO+nomeDaSerie+API_KEY);
        DadosSerie serie = dados.converterDados(json, DadosSerie.class);

        return  serie;
    }

    private void buscarSerie(){
        DadosSerie serie = getSerie();
        Serie dadoSerie = new Serie(serie);
        repository.save(dadoSerie);
        System.out.println(serie);
    }

    private void buscarEpisodio() {
        listarSeries();
        System.out.println("Informe a série que deseja ver os episódios: ");
        var nomeDaSerie = entrada.nextLine().toLowerCase();

        Optional<Serie> serie = serieList.stream()
                .filter(d -> d.getTitulo().toLowerCase().contains(nomeDaSerie))
                .findFirst();

        if (serie.isPresent()){
            for (int i = 1; i <= serie.get().getTotalDeTemporadas() ; i++) {
                var json = requisicao.obterDados(ENDERECO+serie.get().getTitulo()+"&season="+i+API_KEY);
                DadosTemporada temporada = dados.converterDados(json, DadosTemporada.class);
                listaDeTemporada.add(temporada);
            }
        }else {
            System.out.println("Não encontramos essa série.");
        }

        List<Episodio> episodios = listaDeTemporada.stream()
                .flatMap(d -> d.episodios().stream()
                        .map(e -> new Episodio(d.temporada(), e)))
                .collect(Collectors.toList());

        serie.get().setEpisodios(episodios);
        repository.save(serie.get());
        episodios.forEach(System.out::println);
    }

    private void listarSeries(){
        serieList = repository.findAll();
        serieList.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }
}

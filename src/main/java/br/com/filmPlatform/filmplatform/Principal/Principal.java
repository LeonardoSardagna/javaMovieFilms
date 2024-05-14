package br.com.filmPlatform.filmplatform.Principal;

import br.com.filmPlatform.filmplatform.modal.DadosSerie;
import br.com.filmPlatform.filmplatform.modal.DadosTemporada;
import br.com.filmPlatform.filmplatform.modal.Episodio;
import br.com.filmPlatform.filmplatform.modal.Serie;
import br.com.filmPlatform.filmplatform.service.ConverterDados;
import br.com.filmPlatform.filmplatform.service.Requisicao;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    Scanner entrada = new Scanner(System.in);
    Requisicao requisicao = new Requisicao();
    ConverterDados dados = new ConverterDados();
    List<DadosTemporada> listaDeTemporada = new ArrayList<>();
    List<DadosSerie> listaDeSeries = new ArrayList<>();

    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=f6239180";

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
    private DadosSerie getSerie(){
        System.out.println("Digite o nome da série para buscar: ");
        var nomeDaSerie = entrada.nextLine().toLowerCase().replace(" ", "%20");

        var json = requisicao.obterDados(ENDERECO+nomeDaSerie+API_KEY);
        DadosSerie serie = dados.converterDados(json, DadosSerie.class);

        return  serie;
    }

    private void buscarSerie(){
        DadosSerie serie = getSerie();
        listaDeSeries.add(serie);
        System.out.println(serie);
    }

    private void buscarEpisodio(){
        DadosSerie serie = getSerie();

        for (int i = 1; i <= serie.totalDeTemporadas(); i++) {
            var json = requisicao.obterDados(ENDERECO+serie.titulo()+"&season="+i+API_KEY);

            DadosTemporada temporada = dados.converterDados(json, DadosTemporada.class);
            listaDeTemporada.add(temporada);
        }

        List<Episodio> episodios = listaDeTemporada.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(e -> new Episodio(t.temporada(), e)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);
    }

    private void listarSeries(){
        List<Serie> serieList = new ArrayList<>();

        serieList = listaDeSeries.stream()
                .map(d -> new Serie(d))
                .collect(Collectors.toList());

        serieList.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }
}

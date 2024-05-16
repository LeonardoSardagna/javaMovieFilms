package br.com.filmPlatform.filmplatform.Principal;

import br.com.filmPlatform.filmplatform.modal.*;
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
    List<Serie> serieList = new ArrayList<>();

    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=f6239180";

    @Autowired
    private SerieRepository repository;

    public void menuPrincipal() {
        var opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    1 - Buscar Séries
                    2 - Buscar Episódios
                    3 - Listar Séries
                    4 - Buscar Por Título
                    5 - Buscar Por Ator
                    6 - Buscar Top 5 Séries
                    7 - Buscar Por Categoria
                    8 - Para Maratonar
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
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarPorAutores();
                    break;
                case 6:
                    buscarTop5Melhores();
                    break;
                case 7:
                    buscarCategoria();
                    break;
                case 8:
                    buscarSeriesParaMaratonar();
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

        Optional<Serie> verificador = repository.verificaBanco(serie.titulo());

        if(verificador.isEmpty()){
            repository.save(dadoSerie);
        }

        System.out.println(serie);
    }

    private void buscarEpisodio() {
        listarSeries();
        System.out.println("Informe a série que deseja ver os episódios: ");
        var nomeDaSerie = entrada.nextLine();

        Optional<Serie> serie = repository.findByTituloContainingIgnoreCase(nomeDaSerie);

        if (serie.isPresent()){
            List<DadosTemporada> listaDeTemporada = new ArrayList<>();

            for (int i = 1; i <= serie.get().getTotalDeTemporadas(); i++) {
                var json = requisicao.obterDados(ENDERECO+serie.get().getTitulo().toLowerCase().replace(" ", "+")+"&season="+i+API_KEY);
                DadosTemporada temporada = dados.converterDados(json, DadosTemporada.class);
                listaDeTemporada.add(temporada);
            }

            List<Episodio> episodios = listaDeTemporada.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.temporada(), e)))
                    .collect(Collectors.toList());

            serie.get().setEpisodios(episodios);
            repository.save(serie.get());


        }else {
            System.out.println("Não encontramos os episódios dessa série.");
        }
    }

    private void listarSeries(){
        serieList = repository.findAll();
        serieList.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    private void buscarSeriePorTitulo(){
        System.out.println("Insira um titulo para buscar:");
        var tituloSerie = entrada.nextLine();

        Optional<Serie> serieBuscada = repository.findByTituloContainingIgnoreCase(tituloSerie);
        System.out.println(serieBuscada.get());
    }

    public void buscarPorAutores(){
        System.out.println("Informe um ator para buscar séries relacionadas:");
        var ator = entrada.nextLine();

        List<Serie> series = repository.findByAtoresContainingIgnoreCase(ator);

        series.forEach(s ->
                System.out.println(s.getTitulo()+" Avaliação: "+s.getAvaliacao()+ " Atores: "+ s.getAtores()));
    }

    public void buscarTop5Melhores(){
        List<Serie> top5 = repository.findTop5ByOrderByAvaliacaoDesc();
        top5.forEach(s ->
                System.out.println(s.getTitulo() + " Avaliação: "+ s.getAvaliacao()));
    }

    public void buscarCategoria(){
        System.out.println("Informe a categoria/genero da série");
        var genero = entrada.nextLine();
        Categoria categoria = Categoria.fromStringPorgues(genero);
        List<Serie> listaGenero = repository.findByGenero(categoria);
        listaGenero.forEach(System.out::println);
    }

    public void buscarSeriesParaMaratonar(){
        System.out.println("Bora maratonar?");
        System.out.println("Informe o número de temporadas:");
        var numeroTemporadas = entrada.nextInt();
        System.out.println("Informe a avaliação:");
        var avaliacao = entrada.nextDouble();

        List<Serie> maratona = repository.serieMaratona(numeroTemporadas, avaliacao);

        maratona.forEach(s ->
                System.out.println("Temporada: "+s.getTitulo()+
                        " Total de temporada: "+ s.getTotalDeTemporadas()+
                        " Avaliação: "+ s.getAvaliacao()));
    }
}

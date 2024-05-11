package br.com.filmPlatform.filmplatform.Principal;

import br.com.filmPlatform.filmplatform.modal.DadosSerie;
import br.com.filmPlatform.filmplatform.modal.DadosTemporada;
import br.com.filmPlatform.filmplatform.modal.Episodio;
import br.com.filmPlatform.filmplatform.service.ConverterDados;
import br.com.filmPlatform.filmplatform.service.Requisicao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    Scanner entrada = new Scanner(System.in);
    Requisicao requisicao = new Requisicao();
    ConverterDados dados = new ConverterDados();
    List<DadosTemporada> listaDeTemporada = new ArrayList<>();

    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=f6239180";

    public void menuPrincipal() {
        System.out.println("Digite o nome da série: ");
        String nomeDaserie = entrada.nextLine().replace(" ", "%20");

        var json = requisicao.obterDados(ENDERECO + nomeDaserie + API_KEY);
        DadosSerie serie = dados.converterDados(json, DadosSerie.class);
        System.out.println(serie);

        for (int i = 1; i <= serie.totalDeTemporadas(); i++) {
            json = requisicao.obterDados(ENDERECO + nomeDaserie + "&season=" + i + API_KEY);
            DadosTemporada temporada = dados.converterDados(json, DadosTemporada.class);
            listaDeTemporada.add(temporada);
        }

        //lista de todos os episódios
        List<Episodio> episodios = listaDeTemporada.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(e -> new Episodio(t.temporada(), e)))
                .collect(Collectors.toList());
        episodios.forEach(System.out::println);

        //5 melhores avaliados
        System.out.println("\n5 episódios bem avaliados: ");
        episodios.stream()
                .sorted(Comparator.comparing(Episodio::getAvaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

        //Filtrar episódio pelo ano
        System.out.println("\nInforme o ano dos episódios que deseja ver: ");
        var ano = entrada.nextInt();
        LocalDate anoBusca = LocalDate.of(ano, 1, 1);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        episodios.stream()
                .filter(e -> e.getDataDeLancamento().isAfter(anoBusca))
                .forEach(e -> {
                    System.out.println(
                            "Temporada: " + e.getTemporada() +
                                    " Episódio: " + e.getNumeroEpisodio() +
                                    " Data de lançamento: " + e.getDataDeLancamento().format(formatador));
                });

        //Filtrar episódio pelo titulo
        System.out.println("\nInforme o título do episódio: ");
        var busca = entrada.nextLine();

        Optional<Episodio> episodio = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(busca.toUpperCase()))
                .findFirst();

        if (episodio.isPresent()) {
            System.out.println("Episódio encontrado: ");
            System.out.println(episodio.get());
        } else {
            System.out.println("Episódio não encontrado");
        }

        //avaliação geral por episódio usando map
        Map<Integer, Double> mediasTemporadas = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada
                        , Collectors.averagingDouble(Episodio::getAvaliacao)));
        System.out.println(mediasTemporadas);

        //avaliação geral por episódio usando DoubleSummaryStatistics
        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
        System.out.println(
                "Quantidade de episódios: " + est.getCount() +
                        " Episódio melhor avaliado: " + Math.pow(est.getMax(), 2) +
                        " Episódio menor avaliado: " + Math.pow(est.getMin(), 2) +
                        " Média total: " + est.getAverage());
    }
}

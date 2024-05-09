package br.com.filmPlatform.filmplatform.Principal;

import br.com.filmPlatform.filmplatform.modal.DadosSerie;
import br.com.filmPlatform.filmplatform.modal.DadosTemporada;
import br.com.filmPlatform.filmplatform.service.ConverterDados;
import br.com.filmPlatform.filmplatform.service.Requisicao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    Scanner entrada = new Scanner(System.in);
    Requisicao requisicao = new Requisicao();
    ConverterDados dados = new ConverterDados();
    List<DadosTemporada> listaDeTemporada = new ArrayList<>();

    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=f6239180";

    public void menuPrincipal(){
        System.out.println("Digite o nome da série: ");
        String nomeDaserie = entrada.nextLine().replace(" ", "%20");

        var json = requisicao.obterDados(ENDERECO+nomeDaserie+API_KEY);
        DadosSerie serie = dados.converterDados(json, DadosSerie.class);
        System.out.println(serie);

        for (int i = 1; i <= serie.totalDeTemporadas(); i++) {
            json = requisicao.obterDados(ENDERECO+nomeDaserie+"&season="+ i +API_KEY);
            DadosTemporada temporada = dados.converterDados(json, DadosTemporada.class);
            listaDeTemporada.add(temporada);
        }

        listaDeTemporada.forEach(t -> t.episodios().forEach(System.out::println));
    }
}

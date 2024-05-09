package br.com.filmPlatform.filmplatform.Principal;

import br.com.filmPlatform.filmplatform.modal.DadosSerie;
import br.com.filmPlatform.filmplatform.modal.DadosTemporada;
import br.com.filmPlatform.filmplatform.service.ConverterDados;
import br.com.filmPlatform.filmplatform.service.RequestAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    Scanner entrada = new Scanner(System.in);
    RequestAddress address = new RequestAddress();
    ConverterDados dados = new ConverterDados();
    List<DadosTemporada>listaDeTemporada = new ArrayList<>();

    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=f6239180";

    public void exibiMenu(){
        System.out.println("Digite o nome da série: ");
        String nome = entrada.nextLine().replace(" ", "%20");
        var json = address.obterendereco(ENDERECO+nome+API_KEY);

        DadosSerie serie = dados.obterDados(json, DadosSerie.class);
        System.out.println(serie);

        for (int i = 1; i <= serie.totalDeTemporada(); i++) {
			json = address.obterendereco(ENDERECO+nome+"&season="+ i +API_KEY);
			DadosTemporada todasAsTemporadas = dados.obterDados(json, DadosTemporada.class);
			listaDeTemporada.add(todasAsTemporadas);
		}

        listaDeTemporada.forEach(t-> t.episodios().forEach(System.out::println));
    }
}

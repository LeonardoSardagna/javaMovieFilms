package br.com.filmPlatform.filmplatform.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requisicao {

    public String obterDados(String enderecoUrl){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(enderecoUrl.replace(" ", "%20")))
                .build();
        HttpResponse<String> response = null;
        try {
             response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        };

        return response.body();
    }
}

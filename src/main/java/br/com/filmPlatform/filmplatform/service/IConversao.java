package br.com.filmPlatform.filmplatform.service;

public interface IConversao {
    <T> T obterDados(String json, Class<T> classe);

}

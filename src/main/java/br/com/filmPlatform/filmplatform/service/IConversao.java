package br.com.filmPlatform.filmplatform.service;

public interface IConversao {
    <T> T converterDados(String json, Class<T> classe);
}

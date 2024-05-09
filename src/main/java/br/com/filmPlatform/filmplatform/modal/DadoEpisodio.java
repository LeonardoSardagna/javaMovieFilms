package br.com.filmPlatform.filmplatform.modal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadoEpisodio(@JsonAlias("Title") String titulo,
                           @JsonAlias("Season") String temporada,
                           @JsonAlias("Episode") String episodio,
                           @JsonAlias("imdbRating") String avaliacao
                           ) {
    @Override
    public String toString() {
        return "Dados do Episodio: " +
                " Título: " + titulo +
                ", Temporada: " + temporada +
                ", Episódio: " + episodio +
                ", Avaliação: " + avaliacao;
    }
}

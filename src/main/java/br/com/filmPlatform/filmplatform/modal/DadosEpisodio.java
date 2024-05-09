package br.com.filmPlatform.filmplatform.modal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Season") String temporada,
                            @JsonAlias("Episode") String episodio,
                            @JsonAlias("Title") String titulo,
                            @JsonAlias("imdbRating") String avaliacao) {
    @Override
    public String toString() {
        return "Dados do Episodio: " +
                "Temporada: "+ temporada +
                ", Episódio: " + episodio +
                ", Título: " + titulo +
                ", Avaliação: " + avaliacao;
    }
}

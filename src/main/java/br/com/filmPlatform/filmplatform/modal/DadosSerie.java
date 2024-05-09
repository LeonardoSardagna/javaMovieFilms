package br.com.filmPlatform.filmplatform.modal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("Year") String ano,
                         @JsonAlias("Genre") String genero,
                         @JsonAlias("totalSeasons") int totalDeTemporadas,
                         @JsonAlias("imdbRating") String avaliacao) {
    @Override
    public String toString() {
        return "Dados do Série: " +
                "Título: " + titulo +
                ", Ano: " + ano +
                ", Genêro: " + genero +
                ", Total De Temporadas: " + totalDeTemporadas +
                ", Avaliação: " + avaliacao;
    }
}

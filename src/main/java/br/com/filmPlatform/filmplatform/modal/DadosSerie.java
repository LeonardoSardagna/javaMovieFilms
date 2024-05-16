package br.com.filmPlatform.filmplatform.modal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("Year") String ano,
                         @JsonAlias("Genre") String genero,
                         @JsonAlias("totalSeasons") int totalDeTemporadas,
                         @JsonAlias("imdbRating") String avaliacao,
                         @JsonAlias("Plot") String descicao,
                         @JsonAlias("Actors") String atores,
                         @JsonAlias("Poster") String imagem) {
    @Override
    public String toString() {
        return "Título: " + titulo +
                ", Ano: " + ano +
                ", Gênero: " + genero +
                ", Total De Temporadas: " + totalDeTemporadas +
                ", Avaliação: " + avaliacao +
                ", Descrição: " + descicao +
                ", Atores: "+ atores;
    }
}

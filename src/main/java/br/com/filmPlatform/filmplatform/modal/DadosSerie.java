package br.com.filmPlatform.filmplatform.modal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("Year") String ano,
                         @JsonAlias("Genre") String genero,
                         @JsonAlias("Type") String tipo,
                         @JsonAlias("totalSeasons") int totalDeTemporada,
                         @JsonAlias("imdbRating") String avaliacao) {
    @Override
    public String toString() {
        return "Dados Série: "+
                "Título: " + titulo +
                ", Ano: " + ano +
                ", Gênero: " + genero +
                ", Tipo: " + tipo +
                ", Total De Temporada: " + totalDeTemporada +
                ", Avaliação: " + avaliacao;
    }
}

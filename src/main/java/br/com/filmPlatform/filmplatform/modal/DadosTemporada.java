package br.com.filmPlatform.filmplatform.modal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(@JsonAlias("Title") String titulo,
                             @JsonAlias({"Season", "Seasons"}) String temporada,
                             @JsonAlias("Episodes") List<DadosEpisodio> episodios) {
    @Override
    public String toString() {
        return "Dados do Temporada: " +
                "Título: " + titulo +
                ", Temporada: " + temporada +
                ", Episódios: " + episodios;
    }
}

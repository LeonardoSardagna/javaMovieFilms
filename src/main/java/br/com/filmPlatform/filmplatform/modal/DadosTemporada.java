package br.com.filmPlatform.filmplatform.modal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(@JsonAlias("Season") String temporada,
                             @JsonAlias("Episodes") List<DadoEpisodio> episodios) {

    @Override
    public String toString() {
        return "Dados da Temporada: " +
                ", Temporada: " + temporada +
                ", Episódios: " + episodios;
    }
}

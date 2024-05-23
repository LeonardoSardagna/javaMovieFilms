package br.com.filmPlatform.filmplatform.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Entity
@Table(name = "episodios")
@Getter
@Setter
@NoArgsConstructor
public class Episodio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int temporada;
    private int numeroEpisodio;
    private String titulo;
    private double avaliacao;
    private LocalDate dataDeLancamento;
    @ManyToOne
    private Serie serie;

    public Episodio(int temporada, DadosEpisodio dadosEpisodio) {
        this.temporada = temporada;
        this.numeroEpisodio = Integer.parseInt(dadosEpisodio.episodio());
        this.titulo = dadosEpisodio.titulo();

        try {
            this.avaliacao = Double.parseDouble(dadosEpisodio.avaliacao());
        }catch (NumberFormatException e){
            this.avaliacao = 0;
        }

        try{
            this.dataDeLancamento = LocalDate.parse(dadosEpisodio.dataDeLancamento());
        }catch (DateTimeParseException e){
            this.dataDeLancamento = null;
        }
    }

    @Override
    public String toString() {
        return "Temporada: " + temporada +
                ", Número do episódio: " + numeroEpisodio +
                ", Título: " + titulo +
                ", Avaliação: " + avaliacao +
                ", Data de lançamento: "+  dataDeLancamento;
    }
}

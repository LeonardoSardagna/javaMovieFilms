package br.com.filmPlatform.filmplatform.modal;

import jakarta.persistence.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

@Entity
@Table(name = "episodios")
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

    public Episodio() {}

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
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

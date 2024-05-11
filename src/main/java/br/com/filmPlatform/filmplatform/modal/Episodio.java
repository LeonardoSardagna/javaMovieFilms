package br.com.filmPlatform.filmplatform.modal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Episodio {
    private int temporada;
    private int numeroEpisodio;
    private String titulo;
    private double avaliacao;
    private LocalDate dataDeLancamento;

    public Episodio(int temporada, DadosEpisodio dadosEpisodio) {

        this.temporada = temporada;
        this.numeroEpisodio = Integer.parseInt(dadosEpisodio.episodio());
        this.titulo = dadosEpisodio.titulo();

        try {
            this.avaliacao = Double.parseDouble(dadosEpisodio.avaliacao());
        }catch (NumberFormatException e){
            this.avaliacao = 0;
        }

        this.dataDeLancamento = LocalDate.parse(dadosEpisodio.dataDeLancamento());
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
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Temporada: " + temporada +
                ", Número do episódio: " + numeroEpisodio +
                ", Título: " + titulo +
                ", Avaliação: " + avaliacao +
                ", Data de lançamento: "+ dataDeLancamento.format(formatador);
    }
}

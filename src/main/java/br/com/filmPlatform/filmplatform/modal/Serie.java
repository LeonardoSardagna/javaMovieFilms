package br.com.filmPlatform.filmplatform.modal;

import java.util.Optional;

public class Serie {
    private String titulo;
    private String ano;
    private Categoria genero;
    private Integer totalDeTemporadas;
    private Double avaliacao;
    private String descicao;
    private String atores;
    private String imagem;

    public Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.ano = dadosSerie.ano();
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.totalDeTemporadas = dadosSerie.totalDeTemporadas();
        this.avaliacao = Optional.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0.0);
        this.descicao = dadosSerie.descicao();
        this.atores = dadosSerie.atores();
        this.imagem = dadosSerie.imagem();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = Categoria.valueOf(genero);
    }

    public int getTotalDeTemporadas() {
        return totalDeTemporadas;
    }

    public void setTotalDeTemporadas(int totalDeTemporadas) {
        this.totalDeTemporadas = totalDeTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = Double.valueOf(avaliacao);
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                ", Ano: " + ano +
                ", Genêro: " + genero +
                ", Total De Temporadas: " + totalDeTemporadas +
                ", Avaliação: " + avaliacao +
                ", Descição: " + descicao +
                ", Atores: " + atores +
                ", Imagem: " + imagem;
    }
}

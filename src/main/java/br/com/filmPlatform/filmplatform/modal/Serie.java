package br.com.filmPlatform.filmplatform.modal;

import br.com.filmPlatform.filmplatform.service.ConsultaIA;
import jakarta.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String ano;
    @Enumerated(EnumType.STRING)
    private Categoria genero;
    private Integer totalDeTemporadas;
    private Double avaliacao;
    private String descicao;
    private String atores;
    private String imagem;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episodio> episodios = new ArrayList<>();

    public Serie(){}

    public Serie(DadosSerie dadosSerie) throws IOException {
        this.titulo = dadosSerie.titulo();
        this.ano = dadosSerie.ano();
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.totalDeTemporadas = dadosSerie.totalDeTemporadas();
        this.avaliacao = Optional.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0.0);
        this.descicao = ConsultaIA.obterTraducao(dadosSerie.descicao()).trim();
        this.atores = dadosSerie.atores();
        this.imagem = dadosSerie.imagem();
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        episodios.forEach(e -> e.setSerie(this));
        this.episodios = episodios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public void setTotalDeTemporadas(Integer totalDeTemporadas) {
        this.totalDeTemporadas = totalDeTemporadas;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
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
                ", Gênero: " + genero +
                ", Total De Temporadas: " + totalDeTemporadas +
                ", Avaliação: " + avaliacao +
                ", Descição: " + descicao +
                ", Atores: " + atores +
                ", Imagem: " + imagem +
                ", Episódios: " + episodios;
    }
}

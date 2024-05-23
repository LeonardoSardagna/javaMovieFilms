package br.com.filmPlatform.filmplatform.modal;

import br.com.filmPlatform.filmplatform.service.ConsultaIA;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "series")
@Getter
@Setter
@NoArgsConstructor
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

    public void setEpisodios(List<Episodio> episodios) {
        episodios.forEach(e -> e.setSerie(this));
        this.episodios = episodios;
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

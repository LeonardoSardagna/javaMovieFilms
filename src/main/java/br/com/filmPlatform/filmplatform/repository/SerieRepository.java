package br.com.filmPlatform.filmplatform.repository;

import br.com.filmPlatform.filmplatform.modal.Categoria;
import br.com.filmPlatform.filmplatform.modal.Episodio;
import br.com.filmPlatform.filmplatform.modal.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    @Query("SELECT s FROM Serie s WHERE s.titulo = :titulo")
    Optional<Serie> buscarPorTitulo(String titulo);

    @Query("SELECT s FROM Serie s WHERE LOWER(s.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))")
    List<Serie> serieTitulo(String titulo);

    List<Serie> findByAtoresContainingIgnoreCase(String titulo);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria genero);

    @Query("SELECT s FROM Serie s WHERE s.totalDeTemporadas >= :numeroTemporada AND s.avaliacao >= :avaliacao")
    List<Serie> serieMaratona(Integer numeroTemporada, Double avaliacao);

    @Query("SELECT s FROM Serie s WHERE s.titulo = :serie")
    Optional<Serie> verificaSerieBanco(String serie);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:trechoDoEpisodio%")
    List<Episodio> buscarEpisodio(String trechoDoEpisodio);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie ORDER BY e.avaliacao DESC LIMIT 5")
    List<Episodio> top5Episodio(Serie serie);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie AND YEAR(e.dataDeLancamento) >= :anoDosEpisodio")
    List<Episodio>EpisodiosPorAno(Serie serie, Integer anoDosEpisodio);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie")
    List<Episodio> verificaEpisodioBanco(Serie serie);

    @Query("SELECT s FROM Serie s " +
            "JOIN s.episodios e " +
            "GROUP BY s " +
            "ORDER BY MAX(e.dataDeLancamento) DESC LIMIT 5")
    List<Serie> encontrarEpisodiosRecentes();

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s.id = :id AND e.temporada = :numero")
    List<Episodio> obterEpisodiosSeries(Long id, Long numero);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s.id = :id ORDER BY e.avaliacao DESC LIMIT 5")
    List<Episodio> top5EpisodioSerie(Long id);
}
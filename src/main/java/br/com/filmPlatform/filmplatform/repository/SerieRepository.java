package br.com.filmPlatform.filmplatform.repository;

import br.com.filmPlatform.filmplatform.modal.Categoria;
import br.com.filmPlatform.filmplatform.modal.Episodio;
import br.com.filmPlatform.filmplatform.modal.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainingIgnoreCase(String titulo);

    List<Serie> findByAtoresContainingIgnoreCase(String titulo);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria genero);

    List<Serie> findByTotalDeTemporadasLessThanEqualAndAvaliacaoLessThanEqualOrderByAvaliacaoDesc(Integer numeroTemporada, Double avaliacao);

    //@Query(value = "select * from series where series.total_de_temporadas >= 5 and series.avaliacao >= 8.0", nativeQuery = true)
    @Query("select s from Serie s where s.totalDeTemporadas >= :numeroTemporada and s.avaliacao >= :avaliacao")
    List<Serie> serieMaratona(Integer numeroTemporada, Double avaliacao);

    @Query("select s from Serie s where s.titulo = :serie")
    Optional<Serie> verificaBanco(String serie);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:trechoDoEpisodio%")
    List<Episodio> buscarEpisodio(String trechoDoEpisodio);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie ORDER BY e.avaliacao DESC LIMIT 5")
    List<Episodio> top5Episodio(Serie serie);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie AND YEAR(e.dataDeLancamento) >= :anoDosEpisodio")
    List<Episodio>EpisodiosPorAno(Serie serie, Integer anoDosEpisodio);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie")
    List<Episodio> verificaEpisodio(Serie serie);
}
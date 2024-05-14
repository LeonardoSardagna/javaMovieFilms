package br.com.filmPlatform.filmplatform.repository;

import br.com.filmPlatform.filmplatform.modal.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}

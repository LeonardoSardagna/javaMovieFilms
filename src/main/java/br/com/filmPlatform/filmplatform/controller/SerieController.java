package br.com.filmPlatform.filmplatform.controller;

import br.com.filmPlatform.filmplatform.dto.EpisodioDTO;
import br.com.filmPlatform.filmplatform.dto.SerieDTO;
import br.com.filmPlatform.filmplatform.modal.Episodio;
import br.com.filmPlatform.filmplatform.modal.Serie;
import br.com.filmPlatform.filmplatform.repository.SerieRepository;
import br.com.filmPlatform.filmplatform.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService service;

    @GetMapping
    public List<SerieDTO> obterSeries() {
        return service.obterSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obterTop5() {
        return service.obterTop5();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> obterLancamentos() {
        return service.obterLancamento();
    }

    @GetMapping("/{id}")
    public SerieDTO obterEpisodio(@PathVariable Long id) {
        return service.obterEpisodio(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obterEpisodios(@PathVariable Long id) {
        return service.obterTodosEpisodios(id);
    }

    @GetMapping("/{id}/temporadas/{numero}")
    public List<EpisodioDTO> obterEpisodioNumero(@PathVariable Long id, @PathVariable Long numero) {
        return service.obterEpisodioSerie(id, numero);
    }

    @GetMapping("/categoria/{nomeCategoria}")
    public List<SerieDTO> obterSarieCategoria(@PathVariable String nomeCategoria){
        return service.obterSerieCategoria(nomeCategoria);
    }

    @GetMapping("/{id}/temporadas/top")
    public List<EpisodioDTO> obterTop5(@PathVariable Long id){
        return service.obterMelhoresEpisodios(id);
    }
}

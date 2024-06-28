package br.com.filmPlatform.filmplatform.controller;

import br.com.filmPlatform.filmplatform.dto.EpisodioDTO;
import br.com.filmPlatform.filmplatform.dto.SerieDTO;
import br.com.filmPlatform.filmplatform.modal.Episodio;
import br.com.filmPlatform.filmplatform.modal.Serie;
import br.com.filmPlatform.filmplatform.repository.SerieRepository;
import br.com.filmPlatform.filmplatform.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService service;

    @GetMapping
    public ResponseEntity<List<SerieDTO>> obterSeries() {
        var serie = service.obterSeries();
        return ResponseEntity.ok(serie);
    }

    @GetMapping("/top5")
    public ResponseEntity<List<SerieDTO>> obterTop5() {
        var top5 = service.obterTop5();
        return ResponseEntity.ok(top5);
    }

    @GetMapping("/lancamentos")
    public ResponseEntity<List<SerieDTO>> obterLancamentos() {
        var lancamento = service.obterLancamento();
        return ResponseEntity.ok(lancamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity obterEpisodio(@PathVariable Long id) {
        var episodio = service.obterEpisodio(id);
        return ResponseEntity.ok(episodio);
    }

    @GetMapping("/{id}/temporadas/todas")
    public ResponseEntity<List<EpisodioDTO>> obterEpisodios(@PathVariable Long id) {
        var episodios = service.obterTodosEpisodios(id);
        return ResponseEntity.ok(episodios);
    }

    @GetMapping("/{id}/temporadas/{numero}")
    public ResponseEntity<List<EpisodioDTO>> obterEpisodioNumero(@PathVariable Long id, @PathVariable Long numero) {
        var unicoEpisodio = service.obterEpisodioSerie(id, numero);
        return ResponseEntity.ok(unicoEpisodio);
    }

    @GetMapping("/categoria/{nomeCategoria}")
    public ResponseEntity<List<SerieDTO>> obterSarieCategoria(@PathVariable String nomeCategoria){
        var serieCategoria = service.obterSerieCategoria(nomeCategoria);
        return ResponseEntity.ok(serieCategoria);
    }

    @GetMapping("/{id}/temporadas/top")
    public ResponseEntity<List<EpisodioDTO>> obterTop5(@PathVariable Long id){
        var top = service.obterMelhoresEpisodios(id);
        return ResponseEntity.ok(top);
    }

    @GetMapping("/busca")
    public ResponseEntity<List<SerieDTO>> obterSeriePorTitulo(@RequestParam("q") String busca){
        var pesquisa = service.seriePorTitulo(busca);
        return ResponseEntity.ok(pesquisa);
    }
}

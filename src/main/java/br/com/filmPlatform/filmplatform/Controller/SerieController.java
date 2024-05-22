package br.com.filmPlatform.filmplatform.Controller;

import br.com.filmPlatform.filmplatform.Dto.SeriesDTO;
import br.com.filmPlatform.filmplatform.modal.Serie;
import br.com.filmPlatform.filmplatform.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService service;

    @GetMapping
    public List<SeriesDTO> obterSeries(){
        return service.obterSeries();
    }

    @GetMapping("/top5")
    public List<SeriesDTO> obterTop5Series(){
        return service.obterTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SeriesDTO> obterSeriesLancamento(){
        return service.obterSeriesLancamento();
    }

    @GetMapping("/{id}")
    public SeriesDTO obterEpisodio(@PathVariable Long id){
        return service.obterIdEpisodio(id);
    }
}

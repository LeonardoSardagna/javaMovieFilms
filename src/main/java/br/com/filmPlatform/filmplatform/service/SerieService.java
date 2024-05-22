package br.com.filmPlatform.filmplatform.service;

import br.com.filmPlatform.filmplatform.Dto.SeriesDTO;
import br.com.filmPlatform.filmplatform.modal.Serie;
import br.com.filmPlatform.filmplatform.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<SeriesDTO> converteDados(List<Serie> series){
        return series
                .stream()
                .map(s-> new SeriesDTO(s.getId()
                        ,s.getTitulo()
                        ,s.getAno()
                        ,s.getGenero()
                        ,s.getTotalDeTemporadas()
                        ,s.getAvaliacao()
                        ,s.getDescicao()
                        ,s.getAtores()
                        ,s.getImagem()))
                .collect(Collectors.toList());
    }

    public List<SeriesDTO> obterSeries(){
        return converteDados(repository.findAll());
    }

    public List<SeriesDTO> obterTop5Series() {
        return converteDados(repository.findTop5ByOrderByAvaliacaoDesc());
    }

    public List<SeriesDTO> obterSeriesLancamento() {
        return converteDados(repository.encontrarEpisodiosRecentes());
    }

    public SeriesDTO obterIdEpisodio(Long id) {
        Optional<Serie> serie = repository.findById(id);

        if(serie.isPresent()){
            Serie s = serie.get();
            return new SeriesDTO(s.getId()
                    ,s.getTitulo()
                    ,s.getAno()
                    ,s.getGenero()
                    ,s.getTotalDeTemporadas()
                    ,s.getAvaliacao()
                    ,s.getDescicao()
                    ,s.getAtores()
                    ,s.getImagem());
        }else {
            return null;
        }
    }
}

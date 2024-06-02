package br.com.filmPlatform.filmplatform.service;

import br.com.filmPlatform.filmplatform.dto.EpisodioDTO;
import br.com.filmPlatform.filmplatform.dto.SerieDTO;
import br.com.filmPlatform.filmplatform.modal.Categoria;
import br.com.filmPlatform.filmplatform.modal.Episodio;
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
    SerieRepository repository;

    public List<SerieDTO> converteDados(List<Serie> series){
        List<SerieDTO> serie = series.stream()
                .map(s -> new SerieDTO(s.getId(),
                        s.getTitulo(),
                        s.getAno(),
                        s.getGenero(),
                        s.getTotalDeTemporadas(),
                        s.getAvaliacao(),
                        s.getDescicao(),
                        s.getAtores(),
                        s.getImagem())).collect(Collectors.toList());

        return serie;
    }

    public List<SerieDTO> obterSeries(){
        return converteDados(repository.findAll());
    }

    public List<SerieDTO> obterTop5(){
        return converteDados(repository.findTop5ByOrderByAvaliacaoDesc());
    }

    public List<SerieDTO> obterLancamento(){
        return converteDados(repository.encontrarEpisodiosRecentes());
    }

    public SerieDTO obterEpisodio(Long id){
        Optional<Serie> serie = repository.findById(id);

        if (serie.isPresent()){
            Serie s = serie.get();
            return new SerieDTO(s.getId(),
                    s.getTitulo(),
                    s.getAno(),
                    s.getGenero(),
                    s.getTotalDeTemporadas(),
                    s.getAvaliacao(),
                    s.getDescicao(),
                    s.getAtores(),
                    s.getImagem());
        }else{
            return null;
        }
    }

    public List<EpisodioDTO> obterTodosEpisodios(Long id) {
        Optional<Serie> serie = repository.findById(id);

        if (serie.isPresent()){
            Serie s = serie.get();
            return s.getEpisodios().stream()
                    .map(e-> new EpisodioDTO(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                    .collect(Collectors.toList());

        }else{
            return null;
        }
    }

    public List<EpisodioDTO> obterEpisodioSerie(Long id, Long numero) {
        List<Episodio> episodioList = repository.obterEpisodiosSeries(id, numero);

        return episodioList.stream()
                .map(e-> new EpisodioDTO(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> obterSerieCategoria(String nomeCategoria) {
        Categoria categoria = Categoria.fromStringPorgues(nomeCategoria);

        List<Serie> series = repository.findByGenero(categoria);

        return series.stream().map(s -> new SerieDTO(s.getId(),
                s.getTitulo(),
                s.getAno(),
                s.getGenero(),
                s.getTotalDeTemporadas(),
                s.getAvaliacao(),
                s.getDescicao(),
                s.getAtores(),
                s.getImagem()))
                .collect(Collectors.toList());
    }

    public List<EpisodioDTO> obterMelhoresEpisodios(Long id) {
        List<Episodio> episodios = repository.top5EpisodioSerie(id);

        return episodios.stream()
                .map(e -> new EpisodioDTO(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> seriePorTitulo(String busca){
        List<Serie> series = repository.serieTitulo(busca);

        return  series.stream()
                .map(s -> new SerieDTO(s.getId(),
                        s.getTitulo(),
                        s.getAno(),
                        s.getGenero(),
                        s.getTotalDeTemporadas(),
                        s.getAvaliacao(),
                        s.getDescicao(),
                        s.getAtores(),
                        s.getImagem()))
                .collect(Collectors.toList());
    }
}

package br.com.filmPlatform.filmplatform.Dto;

import br.com.filmPlatform.filmplatform.modal.Categoria;

public record SeriesDTO(Long id,
                        String titulo,
                        String ano,
                        Categoria genero,
                        Integer totalDeTemporadas,
                        Double avaliacao,
                        String descicao,
                        String atores,
                        String imagem) {
}

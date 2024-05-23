package br.com.filmPlatform.filmplatform.dto;

import br.com.filmPlatform.filmplatform.modal.Categoria;

public record SerieDTO(Long id,
                         String titulo,
                         String ano,
                         Categoria genero,
                         Integer totalDeTemporadas,
                         Double avaliacao,
                         String descicao,
                         String atores,
                         String imagem) {
}

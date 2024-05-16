package br.com.filmPlatform.filmplatform.modal;

public enum Categoria {
    COMEDIA("Comedy", "Comédia"),
    TERROR("Horror", "Terror"),
    ROMANCE("Romance", "Romance"),
    FANTASIA("Fantasy", "Fantasia"),
    ANIMACAO("Animation", "Animação"),
    DOCUMENTARIO("Documentary", "Documentário"),
    CRIME("Crime", "Crime"),
    AVENTURA("Adventure", "Aventura"),
    MISTERIO("Mystery", "Mistério"),
    HISTORICO("Historical", "Histórico"),
    BIOGRAFIA("Biography", "Biografia"),
    MUSICAL("Musical", "Musical"),
    GUERRA("War", "Guerra"),
    ESPORTE("Sports", "Esporte"),
    FAMILIA("Family", "Família"),
    ACAO("Action", "Ação"),
    POLICIAL("Police", "Policial");

    private String categoriasOmdb;
    private String categoriaOmdbPortugues;

    Categoria(String categoriasOmdb, String categoriaomdbPortugues) {
        this.categoriasOmdb = categoriasOmdb;
        this.categoriaOmdbPortugues = categoriaomdbPortugues;
    }

    public static Categoria fromString(String valor){
        for (Categoria categoria : Categoria.values()){
            if (categoria.categoriasOmdb.equalsIgnoreCase(valor)){
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada " + valor);
    }

    public static Categoria fromStringPorgues(String valor){
        for (Categoria categoria : Categoria.values()){
            if (categoria.categoriaOmdbPortugues.equalsIgnoreCase(valor)){
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada " + valor);
    }

}

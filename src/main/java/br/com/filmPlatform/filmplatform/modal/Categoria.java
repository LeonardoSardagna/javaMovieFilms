package br.com.filmPlatform.filmplatform.modal;

public enum Categoria {
    COMEDIA("Comedy"),
    TERROR("Horror"),
    ROMANCE("Romance"),
    FANTASIA("Fantasy"),
    ANIMACAO("Animation"),
    DOCUMENTARIO("Documentary"),
    CRIME("Crime"),
    AVENTURA("Adventure"),
    MISTERIO("Mystery"),
    HISTORICO("Historical"),
    BIOGRAFIA("Biography"),
    MUSICAL("Musical"),
    GUERRA("War"),
    ESPORTE("Sports"),
    FAMILIA("Family"),
    ACAO("Action"),
    POLICIAL("Police");

    private String categoriasOmdb;

    Categoria(String categoriasOmdb) {
        this.categoriasOmdb = categoriasOmdb;
    }

    public static Categoria fromString(String valor){
        for (Categoria categoria : Categoria.values()){
            if (categoria.categoriasOmdb.equalsIgnoreCase(valor)){
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada");
    }
}

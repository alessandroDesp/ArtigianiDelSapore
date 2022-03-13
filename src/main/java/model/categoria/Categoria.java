package model.categoria;

public class Categoria {
    private int idCategoria;
    private String nome;

    public Categoria(int id, String nome) {
        this.idCategoria = id;
        this.nome = nome;
    }

    public int getId() {
        return idCategoria;
    }

    public void setId(int id) {
        this.idCategoria = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

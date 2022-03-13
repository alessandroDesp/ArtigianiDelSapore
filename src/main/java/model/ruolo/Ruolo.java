package model.ruolo;

public class Ruolo {
    private int idRuolo;
    private String nome;

    public Ruolo(int idRuolo, String nome) {
        this.idRuolo = idRuolo;
        this.nome = nome;
    }

    public int getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(int idRuolo) {
        this.idRuolo = idRuolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

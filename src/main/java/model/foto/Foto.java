package model.foto;

public class Foto {
    private int idFoto;
    private int ksProdotti;
    private String percorso;

    public Foto(int idFoto, int ksProdotti, String percorso) {
        this.idFoto = idFoto;
        this.ksProdotti = ksProdotti;
        this.percorso = percorso;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public int getKsProdotti() {
        return ksProdotti;
    }

    public void setKsProdotti(int ksProdotti) {
        this.ksProdotti = ksProdotti;
    }

    public String getPercorso() {
        return percorso;
    }

    public void setPercorso(String percorso) {
        this.percorso = percorso;
    }
}

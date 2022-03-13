package model.prodottiCategoria;

public class ProdottiCategoria {
    private int idProdottiCategoria;
    private int ksProdotti;
    private int ksCategoria;

    public ProdottiCategoria(int idProdottiCategoria, int ksProdotti, int ksCategoria) {
        this.idProdottiCategoria = idProdottiCategoria;
        this.ksProdotti = ksProdotti;
        this.ksCategoria = ksCategoria;
    }

    public int getIdProdottiCategoria() {
        return idProdottiCategoria;
    }

    public void setIdProdottiCategoria(int idProdottiCategoria) {
        this.idProdottiCategoria = idProdottiCategoria;
    }

    public int getKsProdotti() {
        return ksProdotti;
    }

    public void setKsProdotti(int ksProdotti) {
        this.ksProdotti = ksProdotti;
    }

    public int getKsCategoria() {
        return ksCategoria;
    }

    public void setKsCategoria(int ksCategoria) {
        this.ksCategoria = ksCategoria;
    }
}

package model.listaDesideriProdotti;

public class ListaDesideriProdotti {
    private int idListaDesideriProdotti;
    private int ksListaDesideri;
    private int ksProdotti;

    public ListaDesideriProdotti(int idListaDesideriProdotti, int ksListaDesideri, int ksProdotti) {
        this.idListaDesideriProdotti = idListaDesideriProdotti;
        this.ksListaDesideri = ksListaDesideri;
        this.ksProdotti = ksProdotti;
    }

    public int getIdListaDesideriProdotti() {
        return idListaDesideriProdotti;
    }

    public void setIdListaDesideriProdotti(int idListaDesideriProdotti) {
        this.idListaDesideriProdotti = idListaDesideriProdotti;
    }

    public int getKsListaDeideri() {
        return ksListaDesideri;
    }

    public void setKsListaDeideri(int ksListaDeideri) {
        this.ksListaDesideri = ksListaDeideri;
    }

    public int getKsProdotti() {
        return ksProdotti;
    }

    public void setKsProdotti(int ksProdotti) {
        this.ksProdotti = ksProdotti;
    }
}

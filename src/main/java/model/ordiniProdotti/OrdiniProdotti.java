package model.ordiniProdotti;

public class OrdiniProdotti {
    private int idOrdiniProdotti;
    private int quantita;
    private int ksOrdini;
    private int ksProdotti;

    public OrdiniProdotti(int idOrdiniProdotti, int quantita, int ksOrdini, int ksProdotti) {
        this.idOrdiniProdotti = idOrdiniProdotti;
        this.quantita = quantita;
        this.ksOrdini = ksOrdini;
        this.ksProdotti = ksProdotti;
    }

    public int getIdOrdiniProdotti() {
        return idOrdiniProdotti;
    }

    public void setIdOrdiniProdotti(int idOrdiniProdotti) {
        this.idOrdiniProdotti = idOrdiniProdotti;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getKsOrdini() {
        return ksOrdini;
    }

    public void setKsOrdini(int ksOrdini) {
        this.ksOrdini = ksOrdini;
    }

    public int getKsProdotti() {
        return ksProdotti;
    }

    public void setKsProdotti(int ksProdotti) {
        this.ksProdotti = ksProdotti;
    }
}

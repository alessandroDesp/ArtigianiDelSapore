package model.prodotti;

public class Prodotti {
    private int idProdotti;
    private String nome;
    private float prezzo;
    private int quantitaAttuale;
    private int quantitaVenduta;
    private float sconto;
    private String descrizione;
    private int quantitaDaAcquistare;

    public Prodotti(int idProdotti, String nome, float prezzo, int quantitaAttuale, int quantitaVenduta, float sconto, String descrizione) {
        this.idProdotti = idProdotti;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantitaAttuale = quantitaAttuale;
        this.quantitaVenduta = quantitaVenduta;
        this.sconto = sconto;
        this.descrizione = descrizione;
    }

    public int getIdProdotti() {
        return idProdotti;
    }

    public void setIdProdotti(int idProdotti) {
        this.idProdotti = idProdotti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantitaAttuale() {
        return quantitaAttuale;
    }

    public void setQuantitaAttuale(int quantitaAttuale) {
        this.quantitaAttuale = quantitaAttuale;
    }

    public int getQuantitaVenduta() {
        return quantitaVenduta;
    }

    public void setQuantitaVenduta(int quantitaVenduta) {
        this.quantitaVenduta = quantitaVenduta;
    }

    public float getSconto() {
        return sconto;
    }

    public void setSconto(float sconto) {
        this.sconto = sconto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getQuantitaDaAcquistare() { return quantitaDaAcquistare;}

    public void setQuantitaDaAcquistare(int quantitaDaAcquistare) { this.quantitaDaAcquistare = quantitaDaAcquistare;}
}

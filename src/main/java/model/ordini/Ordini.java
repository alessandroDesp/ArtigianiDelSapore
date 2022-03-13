package model.ordini;

import java.sql.Date;

public class Ordini {
    private int idOrdini;
    private float prezzoTotale;
    private Date data;
    private int ksUtente;
    private int ksStatoOrdini;

    public Ordini(int idOrdini, float prezzoTotale, Date data, int ksUtente, int ksStatoOrdini) {
        this.idOrdini = idOrdini;
        this.prezzoTotale = prezzoTotale;
        this.data = data;
        this.ksUtente = ksUtente;
        this.ksStatoOrdini = ksStatoOrdini;
    }

    public int getIdOrdini() {
        return idOrdini;
    }

    public void setIdOrdini(int idOrdini) {
        this.idOrdini = idOrdini;
    }

    public float getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(float prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getKsUtente() {
        return ksUtente;
    }

    public void setKsUtente(int ksUtente) {
        this.ksUtente = ksUtente;
    }

    public int getKsStatoOrdini() {
        return ksStatoOrdini;
    }

    public void setKsStatoOrdini(int ksStatoOrdini) {
        this.ksStatoOrdini = ksStatoOrdini;
    }
}


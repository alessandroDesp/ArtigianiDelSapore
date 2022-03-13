package model.statoOrdini;

public class StatoOrdini {
    private int idStatoOrdini;
    private String stato;

    public StatoOrdini(int idStatoOrdini, String stato) {
        this.idStatoOrdini = idStatoOrdini;
        this.stato = stato;
    }

    public int getIdStatoOrdini() {
        return idStatoOrdini;
    }

    public void setIdStatoOrdini(int idStatoOrdini) {
        this.idStatoOrdini = idStatoOrdini;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
}

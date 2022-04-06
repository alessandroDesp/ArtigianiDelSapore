package model.pagamentoOrdine;

public class PagamentoOrdine {
    private int idPagamentoOrdine;
    private int ksOrdini;
    private String indirizzoEmail;
    private String indirizzo;
    private String citta;
    private String nazione;
    private String codicePostale;

    public PagamentoOrdine(int idPagamentoOrdine, int ksOrdini, String indirizzoEmail, String indirizzo, String citta, String nazione, String codicePostale) {
        this.idPagamentoOrdine = idPagamentoOrdine;
        this.ksOrdini = ksOrdini;
        this.indirizzoEmail = indirizzoEmail;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.nazione = nazione;
        this.codicePostale = codicePostale;
    }

    public int getIdPagamentoOrdine() {
        return idPagamentoOrdine;
    }

    public void setIdPagamentoOrdine(int idPagamentoOrdine) {
        this.idPagamentoOrdine = idPagamentoOrdine;
    }

    public int getKsOrdini() {
        return ksOrdini;
    }

    public void setKsOrdini(int ksOrdini) {
        this.ksOrdini = ksOrdini;
    }

    public String getIndirizzoEmail() {
        return indirizzoEmail;
    }

    public void setIndirizzoEmail(String indirizzoEmail) {
        this.indirizzoEmail = indirizzoEmail;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String getCodicePostale() {
        return codicePostale;
    }

    public void setCodicePostale(String codicePostale) {
        this.codicePostale = codicePostale;
    }
}

package model.utente;

import java.sql.Date;

public class Utente {
    private int idUtente;
    private String cf;
    private String email;
    private String nome;
    private String cognome;
    private Date dataNascita;
    private String tokenAuth;
    private int ksRuolo;
    private int ksListaDesideri;

    public Utente(int idUtente, String cf, String email, String nome, String cognome, Date dataNascita, String tokenAuth, int ksRuolo, int ksListaDesideri) {
        this.idUtente = idUtente;
        this.cf = cf;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.tokenAuth = tokenAuth;
        this.ksRuolo = ksRuolo;
        this.ksListaDesideri = ksListaDesideri;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getTokenAuth() {
        return tokenAuth;
    }

    public void setTokenAuth(String tokenAuth) {
        this.tokenAuth = tokenAuth;
    }

    public int getKsRuolo() {
        return ksRuolo;
    }

    public void setKsRuolo(int ksRuolo) {
        this.ksRuolo = ksRuolo;
    }

    public int getKsListaDesideri() {
        return ksListaDesideri;
    }

    public void setKsListaDesideri(int ksListaDesideri) {
        this.ksListaDesideri = ksListaDesideri;
    }


}

package model.prodotti;

import model.prodotti.prodottiException.ProdottiNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface ProdottiDao {
    List<Prodotti> getAllProdotti() throws SQLException;
    Prodotti getProdottoById(int idProdotto) throws SQLException, ProdottiNotFoundException;
    Prodotti insertProdotto(String nome,float prezzo,float sconto,int quantitaAttuale,int quantitaVenduta,String descrizione) throws SQLException;
    void modificaProdotto(int id,String nome,float prezzo,float sconto,int quantitaAttuale,int quantitaVenduta,String descrizione) throws SQLException;
    List<Prodotti> getProdottoByName(String nProdotto, int numeroPagina) throws SQLException;
    List<Prodotti> getProdottoBySconto(int numeroPagina) throws SQLException;
    int getNumeroProdottiByName(String nProdotto) throws SQLException;
    int getNumeroProdottiBySconto() throws SQLException;
    void aggiungiQuantita(int idProdotto, int quantitaDaAggiungere) throws SQLException, ProdottiNotFoundException;
    void aggiungiSottraiQuantita(int idProdotto, int quantitaAcquistata) throws SQLException, ProdottiNotFoundException;
}

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
    ArrayList<Prodotti> getProdottoByName(String nProdotto) throws SQLException;

}

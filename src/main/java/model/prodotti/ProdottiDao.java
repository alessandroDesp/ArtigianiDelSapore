package model.prodotti;

import model.prodotti.prodottiException.ProdottiNotFoundException;

import java.sql.*;
import java.util.List;

public interface ProdottiDao {
    List<Prodotti> getAllProdotti() throws SQLException;
    Prodotti getProdottoById(int idProdotto) throws SQLException, ProdottiNotFoundException;

}

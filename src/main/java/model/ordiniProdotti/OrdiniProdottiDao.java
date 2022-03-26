package model.ordiniProdotti;

import model.ordini.Ordini;

import java.sql.SQLException;
import java.util.List;

public interface OrdiniProdottiDao {
    OrdiniProdotti aggiungiOrdiniProdotti(int idOrdine,int idProdotto,int quantita) throws SQLException;
}

package model.ordiniProdotti;

import model.ordini.Ordini;
import model.prodotti.Prodotti;

import java.sql.SQLException;
import java.util.List;

public interface OrdiniProdottiDao {
    OrdiniProdotti aggiungiOrdiniProdotti(int idOrdine,int idProdotto,int quantita) throws SQLException;
    List<Prodotti> getProdottiDaOrdiniProdotti(int idOrdine)  throws SQLException;
}

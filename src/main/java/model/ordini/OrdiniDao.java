package model.ordini;

import java.sql.SQLException;
import java.util.List;

public interface OrdiniDao {
    List<Ordini> getAll() throws SQLException;
    List<Ordini> getOrdiniByUtente(int id) throws SQLException;
    Ordini aggiungiOrdine(int idUtente,int ksStatoOrdini,float prezzoTotale) throws SQLException;
    void consegnaOrdine(int idOrdine,int ksStatoOrdini) throws SQLException;
}

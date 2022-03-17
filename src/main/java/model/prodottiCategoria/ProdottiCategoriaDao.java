package model.prodottiCategoria;

import model.prodotti.Prodotti;

import java.sql.SQLException;
import java.util.List;

public interface ProdottiCategoriaDao {
    List<Prodotti> getProdottiByCategoriaId(int idCategoria) throws SQLException;
    void addProdottiCategoria(int idCategoria,int idProdotto) throws SQLException;
}

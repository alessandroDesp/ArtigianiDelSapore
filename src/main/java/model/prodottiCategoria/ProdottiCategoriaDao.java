package model.prodottiCategoria;

import model.prodotti.Prodotti;

import java.sql.SQLException;
import java.util.List;

public interface ProdottiCategoriaDao {
    List<Prodotti> getProdottiByCategoriaId(int idCategoria, int numeroPagina) throws SQLException;
    void addProdottiCategoria(int idCategoria,int idProdotto) throws SQLException;
    int getNumeroProdottiByCategoriaId(int idCategoria) throws SQLException;
}

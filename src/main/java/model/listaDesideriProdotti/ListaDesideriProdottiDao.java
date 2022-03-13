package model.listaDesideriProdotti;

import model.listaDesideriProdotti.listaDesideriProdottiException.ListaDesideriProdottiAlreadyExstistException;
import model.prodotti.Prodotti;

import java.sql.SQLException;
import java.util.List;

public interface ListaDesideriProdottiDao {
    boolean alreadyExsist(int idProdotto,int idListaDesideri) throws SQLException, ListaDesideriProdottiAlreadyExstistException;
    ListaDesideriProdotti insert(int idProdotto,int idListaDesideri) throws SQLException;
    List<Prodotti> getFromListaDesideri(int idListaDesideri) throws SQLException;
    void remove(int idProdotto,int idListaDesideri) throws SQLException;
}

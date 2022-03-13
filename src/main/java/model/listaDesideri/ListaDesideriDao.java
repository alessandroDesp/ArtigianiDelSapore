package model.listaDesideri;

import model.listaDesideri.listaDesideriException.ListaDesideriNotFoundException;

import java.sql.SQLException;

public interface ListaDesideriDao {
    ListaDesideri insert() throws SQLException;
    ListaDesideri getByUtenteId(int idUtente)  throws SQLException, ListaDesideriNotFoundException;
}

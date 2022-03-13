package model.listaDesideri;

import model.listaDesideri.listaDesideriException.ListaDesideriNotFoundException;
import model.utente.Utente;
import utility.Connect;

import java.sql.*;

public class SqlListaDesideriDao implements ListaDesideriDao{
    @Override
    public ListaDesideri insert() throws SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO ListaDesideri () VALUES ()",
                            Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int id;
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                return null;
            }
            return new ListaDesideri(id);
        }
    }

    @Override
    public ListaDesideri getByUtenteId(int idUtente) throws SQLException,ListaDesideriNotFoundException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("SELECT ld.* FROM ListaDesideri as ld, Utente as ut WHERE ut.idUtente=? AND ut.ksListaDesideri = ld.idListaDesideri",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,idUtente);
            ResultSet rs = ps.executeQuery();
            int idListaDesideri;
            if (rs.next()) {
                idListaDesideri = rs.getInt(1);
            } else {
                throw new ListaDesideriNotFoundException();
            }
            return new ListaDesideri(idListaDesideri);
        }
    }
}

package model.utente;

import model.utente.utenteException.EmailAlreadyExistingException;
import model.utente.utenteException.PasswordNotValidException;
import model.utente.utenteException.UtenteNotFoundException;
import utility.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlUtenteDao implements UtenteDAO{

    @Override
    public Utente doInsert(int ksRuolo,int ksListaDesideri, String cf, String nome, String cognome,
                           String email, Date dataNascita, String tokenAuth, String password) throws SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO Utente (ksRuolo, ksListaDesideri ,cf, nome, cognome, email, password," +
                                    " dataNascita, tokenAuth) VALUES(?,?,?,?,?,?,MD5(?),?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ksRuolo);
            ps.setInt(2, ksListaDesideri);
            ps.setString(3, cf);
            ps.setString(4, nome);
            ps.setString(5, cognome);
            ps.setString(6, email);
            ps.setString(7, password);
            ps.setDate(8, dataNascita);
            ps.setString(9, tokenAuth);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int id;
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                return null;
            }
            return new Utente(id,cf,email, nome, cognome, dataNascita, tokenAuth, ksRuolo, ksListaDesideri);
        }

    }
    @Override
    public boolean isEmailInDatabase(String email) throws SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Utente WHERE email=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    @Override
    public Utente doLogin(String email,String password) throws SQLException,PasswordNotValidException {
        try (Connection con = Connect.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Utente WHERE email=? AND password=MD5(?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return createUtente(rs);
            } else {
                throw new PasswordNotValidException();
            }
        }
    }
    @Override
    public Utente doLogin( int idUtente, String tokenAuth) throws UtenteNotFoundException, SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Utente WHERE idUtente=? AND tokenAuth=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idUtente);
            ps.setString(2, tokenAuth);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return createUtente(rs);
            } else {
                throw new UtenteNotFoundException();
            }
        }
    }

    @Override
    public boolean isEmailOld(int idUtente, String email) throws SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Utente WHERE idUtente=? AND email=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idUtente);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    @Override
    public List<Utente> getAll() throws SQLException {
        ArrayList<Utente> listaUtenti = new ArrayList<>();
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Utente",
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaUtenti.add(createUtente(rs));
            }
            return listaUtenti;
        }
    }

    @Override
    public boolean isPasswordValid( int idUtente, String password) throws SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("SELECT * FROM Utente WHERE idUtente=? AND password=MD5(?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idUtente);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    @Override
    public void doChangePassword( int idUtente, String newPassword) throws SQLException
    {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("UPDATE Utente SET password=MD5(?) WHERE idUtente=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, newPassword);
            ps.setInt(2, idUtente);
            ps.executeUpdate();
        }
    }

    @Override
    public void doChangeAnagrafica(int idUtente, String nome, String cognome, String cf, Date dataNascita, String email) throws SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("UPDATE Utente SET nome=?, cognome=?, cf=?, dataNascita=?, email=? WHERE idUtente=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nome);
            ps.setString(2, cognome);
            ps.setString(3, cf);
            ps.setDate(4, dataNascita);
            ps.setString(5, email);
            ps.setInt(6, idUtente);
            ps.executeUpdate();
        }
    }


    private Utente createUtente(ResultSet rs) throws SQLException {
        int idUtente = rs.getInt("idUtente");
        String cf = rs.getString("cf");
        String nome = rs.getString("nome");
        String cognome = rs.getString("cognome");
        String email = rs.getString("email");
        Date dataNascita = rs.getDate("dataNascita");
        String tokenAuth = rs.getString("tokenAuth");
        int ksRuolo = rs.getInt("ksRuolo");
        int ksListaDesideri = rs.getInt("ksListaDesideri");
        return new Utente(idUtente, cf,email, nome, cognome,  dataNascita, tokenAuth,ksRuolo,ksListaDesideri);
    }
}



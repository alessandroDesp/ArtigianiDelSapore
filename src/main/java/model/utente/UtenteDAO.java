package model.utente;

import model.utente.utenteException.EmailAlreadyExistingException;
import model.utente.utenteException.PasswordNotValidException;
import model.utente.utenteException.UtenteNotFoundException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface UtenteDAO {
    Utente doInsert(int ksRuolo,int ksListaDesideri, String cf, String nome, String cognome,
                    String email, Date dataNascita, String tokenAuth, String password) throws SQLException;
    boolean isEmailInDatabase(String email) throws SQLException;
    Utente doLogin(String email,String password) throws SQLException, PasswordNotValidException;
    Utente doLogin(int idUtente,String tokenAuth) throws SQLException, UtenteNotFoundException;
    List<Utente> getAll() throws SQLException;
    boolean isPasswordValid( int idUtente, String password) throws SQLException;
    void doChangePassword( int idUtente, String newPassword) throws SQLException;
    boolean isEmailOld(int idUtente, String email) throws SQLException;
    void doChangeAnagrafica(int idUtente, String nome, String cognome, String cf, Date dataNascita, String email) throws SQLException;
}

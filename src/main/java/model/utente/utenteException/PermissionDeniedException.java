package model.utente.utenteException;


import model.utente.Utente;

/**
 * Segnala che l'email di un oggetto {@link Utente} è già presente nel database.
 */
public class PermissionDeniedException extends Exception {

    /**
     * Costruisce una EmailAlreadyExistingException senza un messaggio di dettagli.
     */
    public PermissionDeniedException() {}

    /**
     * Costruisce una EmailAlreadyExistingException con il messaggio di dettagli specificato.
     * @param msg Il messaggio di dettagli
     */
    public PermissionDeniedException(String msg) { super(msg); }

}
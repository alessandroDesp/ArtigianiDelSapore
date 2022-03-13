package model.listaDesideri.listaDesideriException;

public class ListaDesideriNotFoundException extends Exception{
    /**
     * Costruisce una ListaDesideriNotFoundException senza un messaggio di dettagli.
     */
    public ListaDesideriNotFoundException() {}

    /**
     * Costruisce una ListaDesideriNotFoundException con il messaggio di dettagli specificato.
     * @param msg Il messaggio di dettagli
     */
    public ListaDesideriNotFoundException(String msg) { super(msg); }
}

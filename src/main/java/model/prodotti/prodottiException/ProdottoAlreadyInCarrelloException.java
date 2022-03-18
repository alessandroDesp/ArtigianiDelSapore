package model.prodotti.prodottiException;

public class ProdottoAlreadyInCarrelloException extends Exception {

    public ProdottoAlreadyInCarrelloException(){}

    public ProdottoAlreadyInCarrelloException(String msg){super(msg);}
}

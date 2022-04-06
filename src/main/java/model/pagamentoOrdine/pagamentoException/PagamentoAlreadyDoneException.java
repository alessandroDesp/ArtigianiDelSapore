package model.pagamentoOrdine.pagamentoException;

public class PagamentoAlreadyDoneException extends Exception{

    public PagamentoAlreadyDoneException(){}

    public PagamentoAlreadyDoneException(String msg){super(msg);}
}

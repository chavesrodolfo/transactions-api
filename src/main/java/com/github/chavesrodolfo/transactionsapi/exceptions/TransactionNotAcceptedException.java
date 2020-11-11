package com.github.chavesrodolfo.transactionsapi.exceptions;

public class TransactionNotAcceptedException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public TransactionNotAcceptedException(String messageDetail) {
        super(String.format("Transaction not accepted. %s", messageDetail)); 
    }
}

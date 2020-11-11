package com.github.chavesrodolfo.transactionsapi.exceptions;

public class TransactionNotAcceptedException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public TransactionNotAcceptedException() {
        super(String.format("Transaction not accepted")); 
    }
}

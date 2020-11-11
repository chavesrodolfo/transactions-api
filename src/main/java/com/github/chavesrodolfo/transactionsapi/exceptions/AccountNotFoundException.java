package com.github.chavesrodolfo.transactionsapi.exceptions;

public class AccountNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public AccountNotFoundException(Long id) {
        super(String.format("Could not find Account id %d", id)); 
    }
}
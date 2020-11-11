package com.github.chavesrodolfo.transactionsapi.exceptions;

public class AccountNotAcceptedException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public AccountNotAcceptedException(String messageDetail) {
        super(String.format("Account not accepted. %s", messageDetail)); 
    }
}
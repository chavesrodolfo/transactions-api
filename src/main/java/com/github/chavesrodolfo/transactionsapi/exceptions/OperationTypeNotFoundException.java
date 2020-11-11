package com.github.chavesrodolfo.transactionsapi.exceptions;

public class OperationTypeNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public OperationTypeNotFoundException(Long id) {
        super(String.format("Could not find operation_type_id = %d", id)); 
    }
}

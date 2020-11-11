package com.github.chavesrodolfo.transactionsapi.exceptions;

import com.github.chavesrodolfo.transactionsapi.model.representations.MessageResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvice {
    
    @ResponseBody
    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    MessageResponse accountNotFoundExceptionHandler(AccountNotFoundException e) {
        return new MessageResponse(HttpStatus.NOT_FOUND.toString(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(OperationTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    MessageResponse operationTypeNotFoundExceptionHandler(OperationTypeNotFoundException e) {
        return new MessageResponse(HttpStatus.NOT_FOUND.toString(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(TransactionNotAcceptedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    MessageResponse transactionNotAcceptedExceptionHandler(TransactionNotAcceptedException e) {
        return new MessageResponse(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
    }
    
}

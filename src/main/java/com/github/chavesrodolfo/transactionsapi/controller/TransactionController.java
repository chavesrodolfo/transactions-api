package com.github.chavesrodolfo.transactionsapi.controller;

import com.github.chavesrodolfo.transactionsapi.model.representations.TransactionRequest;
import com.github.chavesrodolfo.transactionsapi.model.representations.TransactionVO;
import com.github.chavesrodolfo.transactionsapi.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/transactions")
    public TransactionVO createTransaction(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.createTransaction(transactionRequest);
    }
}

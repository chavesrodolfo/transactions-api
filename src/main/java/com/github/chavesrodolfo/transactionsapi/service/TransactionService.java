package com.github.chavesrodolfo.transactionsapi.service;

import com.github.chavesrodolfo.transactionsapi.model.representations.TransactionRequest;
import com.github.chavesrodolfo.transactionsapi.model.representations.TransactionVO;

public interface TransactionService {

    TransactionVO createTransaction(TransactionRequest transactionRequest);
    
}

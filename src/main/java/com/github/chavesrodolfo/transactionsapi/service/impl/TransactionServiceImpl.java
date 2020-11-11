package com.github.chavesrodolfo.transactionsapi.service.impl;

import java.util.Date;

import com.github.chavesrodolfo.transactionsapi.exceptions.AccountNotFoundException;
import com.github.chavesrodolfo.transactionsapi.exceptions.OperationTypeNotFoundException;
import com.github.chavesrodolfo.transactionsapi.exceptions.TransactionNotAcceptedException;
import com.github.chavesrodolfo.transactionsapi.model.Account;
import com.github.chavesrodolfo.transactionsapi.model.OperationType;
import com.github.chavesrodolfo.transactionsapi.model.Transaction;
import com.github.chavesrodolfo.transactionsapi.model.representations.TransactionRequest;
import com.github.chavesrodolfo.transactionsapi.model.representations.TransactionVO;
import com.github.chavesrodolfo.transactionsapi.repository.AccountRepository;
import com.github.chavesrodolfo.transactionsapi.repository.OperationTypeRepository;
import com.github.chavesrodolfo.transactionsapi.repository.TransactionRepository;
import com.github.chavesrodolfo.transactionsapi.service.TransactionService;
import com.github.chavesrodolfo.transactionsapi.util.TransactionConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    OperationTypeRepository operationTypeRepository;

    @Override
    public TransactionVO createTransaction(TransactionRequest transactionRequest) {
        log.info("Creating a new Transaction with amount {}", transactionRequest.getAmount());

        validateTransaction(transactionRequest);

        Account account = accountRepository.findById(transactionRequest.getAccount_id())
                .orElseThrow(() -> new AccountNotFoundException(transactionRequest.getAccount_id()));

        OperationType operationType = operationTypeRepository.findById(transactionRequest.getOperation_type_id())
                .orElseThrow(() -> new OperationTypeNotFoundException(transactionRequest.getOperation_type_id()));

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setEventDate(new Date());
        transaction.setOperationType(operationType);

        transaction = transactionRepository.save(transaction);

        return transaction.transform();
    }

    private void validateTransaction(TransactionRequest transaction) {

        if (transaction.getAmount() == null) {
            throw new TransactionNotAcceptedException(String.format("Amount is required"));
        }

        if (transaction.getAmount() > 0
                && (transaction.getOperation_type_id().equals(TransactionConstants.COMPRA_A_VISTA)
                        || transaction.getOperation_type_id().equals(TransactionConstants.COMPRA_PARCELADA)
                        || transaction.getOperation_type_id().equals(TransactionConstants.SAQUE))) {
            throw new TransactionNotAcceptedException(
                    String.format("Amount must be < 0 for operation_type_id = %d", transaction.getOperation_type_id()));
        }

        if (transaction.getAmount() < 0 && transaction.getOperation_type_id().equals(TransactionConstants.PAGAMENTO)) {
            throw new TransactionNotAcceptedException(
                    String.format("Amount must be > 0 for operation_type_id = %d", transaction.getOperation_type_id()));
        }
    }

}

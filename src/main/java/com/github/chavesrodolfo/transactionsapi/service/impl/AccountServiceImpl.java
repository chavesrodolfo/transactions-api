package com.github.chavesrodolfo.transactionsapi.service.impl;

import com.github.chavesrodolfo.transactionsapi.exceptions.AccountNotFoundException;
import com.github.chavesrodolfo.transactionsapi.model.Account;
import com.github.chavesrodolfo.transactionsapi.model.representations.AccountVO;
import com.github.chavesrodolfo.transactionsapi.repository.AccountRepository;
import com.github.chavesrodolfo.transactionsapi.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public AccountVO createAccount(AccountVO accountVO) {
        log.info("Creating Account for document {}", accountVO.getDocument_number());

        Account account = accountRepository.save(new Account(accountVO));
        return account.transform();
    }

    @Override
    public AccountVO findAccount(Long id) throws AccountNotFoundException {
        log.info("Fetching Account for id {}", id);

        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
        return account.transform();
    }
    
}

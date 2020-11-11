package com.github.chavesrodolfo.transactionsapi.service;

import com.github.chavesrodolfo.transactionsapi.exceptions.AccountNotFoundException;
import com.github.chavesrodolfo.transactionsapi.model.representations.AccountVO;

public interface AccountService {

    AccountVO createAccount(AccountVO accountVO);
	AccountVO findAccount(Long id) throws AccountNotFoundException;
    
}

package com.github.chavesrodolfo.transactionsapi.repository;

import com.github.chavesrodolfo.transactionsapi.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    
}

package com.github.chavesrodolfo.transactionsapi.controller;

import com.github.chavesrodolfo.transactionsapi.model.representations.AccountVO;
import com.github.chavesrodolfo.transactionsapi.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountController {
    
    @Autowired
    AccountService accountService;

    @PostMapping("/accounts")
    public AccountVO createAccount(@RequestBody AccountVO accountVO) {
        return accountService.createAccount(accountVO);
    }

    @GetMapping("/accounts/{id}")
    public AccountVO findAccount(@PathVariable("id") Long id) {
        return accountService.findAccount(id);
    }
}

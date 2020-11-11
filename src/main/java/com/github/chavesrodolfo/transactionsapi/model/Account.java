package com.github.chavesrodolfo.transactionsapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.github.chavesrodolfo.transactionsapi.model.representations.AccountVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Account {
	@Id
    @GeneratedValue
    private Long id;
    private Long document;

    public Account(AccountVO accountVO) {
        this.id = accountVO.getAccount_id();
        this.document = accountVO.getDocument_number();
	}

	public AccountVO transform() {
        AccountVO accountVO = new AccountVO();
        accountVO.setAccount_id(this.id);
        accountVO.setDocument_number(this.document);
		return accountVO;
	}
}

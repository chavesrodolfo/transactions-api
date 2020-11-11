package com.github.chavesrodolfo.transactionsapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.github.chavesrodolfo.transactionsapi.model.representations.TransactionVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    Account account;

    @OneToOne
    OperationType operationType;

    Date eventDate;
    Double amount;

    public Transaction(TransactionVO transactionVO) {
        this.id = transactionVO.getId();
        this.account = new Account(transactionVO.getAccountVO());
        this.operationType = new OperationType(transactionVO.getOperationTypeVO());
        this.eventDate = transactionVO.getEventDate();
        this.amount = transactionVO.getAmount();
    }

	public TransactionVO transform() {
        TransactionVO transactionVO = new TransactionVO();
        transactionVO.setId(this.id);
        transactionVO.setAccountVO(this.account.transform());
        transactionVO.setEventDate(this.eventDate);
        transactionVO.setAmount(this.amount);
        transactionVO.setOperationTypeVO(this.operationType.transform());
		return transactionVO;
	}
}

package com.github.chavesrodolfo.transactionsapi.model.representations;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TransactionVO {
    private Long id;
    AccountVO accountVO;
    OperationTypeVO operationTypeVO;
    Date eventDate;
    Double amount;
}

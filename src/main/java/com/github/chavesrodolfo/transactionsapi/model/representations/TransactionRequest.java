package com.github.chavesrodolfo.transactionsapi.model.representations;

import lombok.Getter;

@Getter
public class TransactionRequest {
    private Long account_id;
    private Long operation_type_id;
    private Double amount;
}

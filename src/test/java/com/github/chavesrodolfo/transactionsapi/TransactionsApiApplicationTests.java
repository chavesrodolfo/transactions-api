package com.github.chavesrodolfo.transactionsapi;


import static org.assertj.core.api.Assertions.assertThat;

import com.github.chavesrodolfo.transactionsapi.controller.AccountController;
import com.github.chavesrodolfo.transactionsapi.controller.TransactionController;
import com.github.chavesrodolfo.transactionsapi.model.representations.AccountVO;
import com.github.chavesrodolfo.transactionsapi.model.representations.TransactionRequest;
import com.github.chavesrodolfo.transactionsapi.model.representations.TransactionVO;
import com.github.chavesrodolfo.transactionsapi.util.TransactionConstants;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TransactionsApiApplicationTests {

	@Autowired
	AccountController accountController;

	@Autowired
	TransactionController transactionController;

	@Test
	void testCreateAndFetchAccount_RegisterTransaction() {
		AccountVO accountVO = new AccountVO();
		accountVO.setDocument_number(12345678L);
		accountVO = accountController.createAccount(accountVO);

		assertThat(accountVO.getDocument_number()).isEqualTo(12345678L);

		accountVO = accountController.findAccount(accountVO.getAccount_id());

		assertThat(accountVO.getDocument_number()).isEqualTo(12345678L);

		TransactionRequest transactionRequest = new TransactionRequest();

		transactionRequest.setAmount(Double.parseDouble("10.99"));
		transactionRequest.setOperation_type_id(TransactionConstants.PAGAMENTO);
		transactionRequest.setAccount_id(accountVO.getAccount_id());

		TransactionVO transactionVO = transactionController.createTransaction(transactionRequest);

		assertThat(transactionVO.getAmount()).isEqualTo(Double.parseDouble("10.99"));

	}
}

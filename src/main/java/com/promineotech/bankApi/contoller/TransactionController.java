package com.promineotech.bankApi.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.bankApi.entity.Transaction;
import com.promineotech.bankApi.service.TransactionService;

@RestController
@RequestMapping("/customers/{customerId}/account/{accountId}/transactions")
public class TransactionController {

	@Autowired
	private TransactionService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createTransaction(@RequestBody Transaction transaction, @PathVariable Long customerId,
			@PathVariable Long accountId) {
		try {
			return new ResponseEntity<Object>(service.createTransaction(transaction, customerId, accountId),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAllTransactions() {
		return new ResponseEntity<Object>(service.getAllTransactions(), HttpStatus.OK);
	}


}

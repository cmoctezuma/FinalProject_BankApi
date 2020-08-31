package com.promineotech.bankApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.bankApi.entity.Account;
import com.promineotech.bankApi.entity.Customer;
import com.promineotech.bankApi.entity.Transaction;
import com.promineotech.bankApi.repository.AccountRepository;
import com.promineotech.bankApi.repository.CustomerRepository;
import com.promineotech.bankApi.repository.TransactionRepository;

@Service
public class TransactionService {

	private Transaction transaction;

	private Account account;

	@Autowired
	private TransactionRepository repo;

	@Autowired
	private AccountRepository accountrepo;

	@Autowired
	private CustomerRepository customerrepo;

	public Transaction createTransaction(Transaction transaction, Long customerId, Long accountId) throws Exception {
		// calculateBalance(amount, transactionType);
		Customer customer = customerrepo.findOne(customerId);
		Account account = accountrepo.findOne(accountId);
		if (customer == null || account == null) {
			throw new Exception("Customer or account does not exist");
		}
		transaction.setCustomer(customer);
		transaction.setAccount(account);
		return repo.save(transaction);
	}

	public Long calculateBalance(long amount, String transactionType) {
		long total = 0;
		if (transaction.getTransactionType().equals("deposit")) {
			total = account.getBalance() + amount;
			account.setBalance(total);
		} else if (transaction.getTransactionType().equals("withdrawal")) {
			total = account.getBalance() - amount;
			account.setBalance(total);

		} else {
			System.out.println("Plese enter deposit or withdrawal");
		}
		return total;
	}

	public Iterable<Transaction> getAllTransactions() {
		return repo.findAll();
	}

}
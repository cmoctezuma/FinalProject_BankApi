package com.promineotech.bankApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.bankApi.entity.Account;
import com.promineotech.bankApi.entity.Customer;
import com.promineotech.bankApi.repository.AccountRepository;
import com.promineotech.bankApi.repository.CustomerRepository;



@Service
public class AccountService {



	@Autowired
	private AccountRepository repo;

	@Autowired
	private CustomerRepository customerRepo;

	public Iterable<Account> getAllAccounts() {
		return repo.findAll();
	}

	public Account getAccount(Long id) {
		return repo.findOne(id);
	}

	public Account updateAccount(Account account, Long id) throws Exception {
		Account foundAccount = repo.findOne(id);
		if (foundAccount == null) {
			throw new Exception("Account not found.");
		}
		foundAccount.setAccountType(account.getAccountType());
		return repo.save(foundAccount);
	}

	public Account createAccount(Account account, Long id) throws Exception {
		Customer customer = customerRepo.findOne(id);
		if (customer== null) {
			throw new Exception("User not found.");
		}
		account.setAccountType(account.getAccountType());
		account.setAccount(account.getAccount());
		account.setBank(account.getBank());
		account.setCustomer(customer);
		return repo.save(account);
	}

}
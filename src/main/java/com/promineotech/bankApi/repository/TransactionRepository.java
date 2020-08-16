package com.promineotech.bankApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.bankApi.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	// public Transaction findByAccountId(Long accountId);

}

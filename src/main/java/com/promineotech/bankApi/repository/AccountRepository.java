package com.promineotech.bankApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.bankApi.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	// public Iterable<Account> findAllAccountsByCustomerId(Long customerId);

	// public Iterable<Account> findAllById(Long customerId);

}

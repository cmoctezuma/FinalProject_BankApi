package com.promineotech.bankApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.bankApi.entity.Bank;

public interface BankRepository extends CrudRepository<Bank, Long> {

}

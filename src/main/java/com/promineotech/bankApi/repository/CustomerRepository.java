package com.promineotech.bankApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.bankApi.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

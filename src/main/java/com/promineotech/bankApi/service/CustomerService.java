package com.promineotech.bankApi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.bankApi.entity.Customer;
import com.promineotech.bankApi.repository.CustomerRepository;

@Service
public class CustomerService {

	private static final Logger Logger = LogManager.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository repo;

	public Customer getCustomerById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			Logger.error("Exception occured whle trying to retreive customer", id, e);
			throw e;
		}

	}

	public Iterable<Customer> getCustomers() {
		return repo.findAll();
	}

	public Customer createCustomer(Customer customer) {
		return repo.save(customer);
	}

	public Customer updateCustomer(Customer customer, Long id) throws Exception {
		try {

			Customer oldCustomer = repo.findOne(id);
			oldCustomer.setAddress(customer.getAddress());
			oldCustomer.setFirstName(customer.getFirstName());
			oldCustomer.setLastName(customer.getLastName());
			return repo.save(oldCustomer);
		} catch (Exception e) {
			Logger.error("Exception occurred while trying to update customer: ", id, e);
			throw new Exception("Unable to update customer.");
		}
	}

	public void deleteCustomer(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			Logger.error("EXception occurred whle trying to delete customer: ", id, e);
			throw new Exception("Unable to delete customer.");
		}
	}

}

package com.promineotech.bankApi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.bankApi.entity.Bank;
import com.promineotech.bankApi.repository.BankRepository;

@Service
public class BankService {

	private static final Logger logger = LogManager.getLogger(BankService.class);

	@Autowired
	private BankRepository repo;

	public Bank getBankById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occured while trying to retrieve bank: " + id, e);
			throw e;
		}
	}

	public Iterable<Bank> getBanks() {
		return repo.findAll();
	}

	public Bank createBank(Bank bank) {
		return repo.save(bank);
	}

	public Bank updateBank(Bank bank, Long id) throws Exception {
		try {
			Bank oldBank = repo.findOne(id);
			oldBank.setLocation(bank.getLocation());
			return repo.save(oldBank);
		} catch (Exception e) {
			logger.error("Exeption occured while trying to update bank: " + id, e);
			throw new Exception("Unable to update bank.");
		}
	}

	public void deleteBank(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete bank: " + id, e);
			throw new Exception("Unable to delete customer.");
		}
	}
}

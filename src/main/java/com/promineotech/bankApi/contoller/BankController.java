package com.promineotech.bankApi.contoller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.bankApi.entity.Bank;
import com.promineotech.bankApi.service.BankService;

@RestController
@RequestMapping("/banks")
public class BankController {

	private static final Logger logger = LogManager.getLogger(BankController.class);

	@Autowired
	private BankService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getBank(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.getBankById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getBanks() {
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, this is a warning!");
		logger.error("Oops!We have an error");
		logger.fatal("Something really went wrong!");
		return new ResponseEntity<Object>(service.getBanks(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createBank(@RequestBody Bank bank) {
		return new ResponseEntity<Object>(service.createBank(bank), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateBank(@RequestBody Bank bank, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateBank(bank, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteBank(@PathVariable Long id) {
		try {
			service.deleteBank(id);
			return new ResponseEntity<Object>("Successfully removed bank with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}

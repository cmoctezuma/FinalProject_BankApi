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

import com.promineotech.bankApi.entity.Account;
import com.promineotech.bankApi.service.AccountService;

@RestController
@RequestMapping("/customers/{id}/accounts")
public class AccountController {

	private static final Logger logger = LogManager.getLogger(AccountController.class);

	@Autowired
	private AccountService service;

	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAccount(@PathVariable Long accountId) {
		try {
			return new ResponseEntity<Object>(service.getAccount(accountId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAccounts() {
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, this is a warning!");
		logger.error("Oops!We have an error");
		logger.fatal("Something really went wrong!");
		return new ResponseEntity<Object>(service.getAllAccounts(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createAccount(@RequestBody Account account,
			@PathVariable Long id)
			throws Exception {
		return new ResponseEntity<Object>(service.createAccount(account, id), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{accountId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateAccount(@RequestBody Account account, @PathVariable Long accountId) {
		try {
			return new ResponseEntity<Object>(service.updateAccount(account, accountId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
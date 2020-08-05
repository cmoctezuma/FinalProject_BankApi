package com.promineotech.bankApi.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

	private Long id;
	private LocalTime completed;
	private Long account;
	private String transactionType;
	private Long amount;




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getCompleted() {
		return completed;
	}

	public void setCompleted(LocalTime completed) {
		this.completed = completed;
	}

	@ManyToOne
	@JoinColumn(name = "accountId")
	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}

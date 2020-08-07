package com.promineotech.bankApi.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {

	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private User user;
	/*
	 * private Long userId; private Long customerId;
	 */

	@JsonIgnore
	private Set<Account> account;

	@JsonIgnore
	private Set<Transaction> transactions;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(mappedBy = "customer")
	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}

	@OneToOne
	@JoinColumn(name = "id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(mappedBy = "customer")
	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	/*
	 * public Long getCustomerId() { return customerId; }
	 *
	 * public void setCustomerId(Long customerId) { this.customerId = customerId; }
	 *
	 * public Long getUserId() { return userId; }
	 *
	 * public void setUserId(Long userId) { this.userId = userId; }
	 */

}

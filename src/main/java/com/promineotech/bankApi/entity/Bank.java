package com.promineotech.bankApi.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {

	private Long id;
	private String location;
	private Set<Account> accounts;



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@OneToMany(mappedBy = "bank")
	public Set<Account> getAccount() {
		return accounts;
	}

	public void setAccount(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
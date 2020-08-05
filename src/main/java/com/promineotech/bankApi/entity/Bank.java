package com.promineotech.bankApi.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Bank {

	private Long id;
	private String location;
	private Long account;



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

	@OneToMany(mappedBy = "accountId")
	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

}

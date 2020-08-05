package com.promineotech.bankApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.bankApi.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);

}

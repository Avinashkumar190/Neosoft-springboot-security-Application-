package com.neosoft.lara.springsecurity.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.lara.entity.UserPerson;
import com.neosoft.lara.springsecurity.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	//UserPerson findByUsername(String username);

}

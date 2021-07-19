package com.neosoft.lara.springsecurity.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neosoft.lara.entity.UserPerson;
import com.neosoft.lara.springsecurity.api.model.User;
import com.neosoft.lara.springsecurity.api.repository.UserRepository;
import com.neosoft.lara.springsecurity.api.repository.UserpersonRepository;

@Service
public class CustomUserdetailsService implements UserDetailsService{
	
	@Autowired
	private UserpersonRepository repository;

	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { User user = repository.findByUsername(username);
	 * CustomUserDetails userDetails = null; if(user!=null) { userDetails = new
	 * CustomUserDetails(); userDetails.setUser(user);
	 * 
	 * }else { throw new UsernameNotFoundException("user not exist with name :" +
	 * username); } return userDetails; }
	 */
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserPerson user = repository.findByUserName(username);
		//return new org.springframework.security.core.userdetails.UserPerson(user.getUserName(), user.getPassword(), new ArrayList<>());
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), 
				new ArrayList<>());
	}

}

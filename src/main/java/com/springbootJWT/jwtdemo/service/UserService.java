package com.springbootJWT.jwtdemo.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/**
		 * logic to get the user from the database. I am using random data here for
		 * test. Returning a user with random name,password and blank roles.User used
		 * here is of type spring security.
		 * 
		 * When user is fetched from DB, in that case also it should be converted to User model of 
		 * Spring Security Type.
		 **/
		return new User("admin", "password", new ArrayList<>());

	}

}

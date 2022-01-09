package com.springbootJWT.jwtdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootJWT.jwtdemo.entity.JwtRequest;
import com.springbootJWT.jwtdemo.entity.JwtResponse;
import com.springbootJWT.jwtdemo.service.UserService;
import com.springbootJWT.jwtdemo.utility.JWTUtility;

@RestController
public class HomeController {

	@Autowired(required = true)
	private JWTUtility utility;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private UserService service;

	@GetMapping("/")
	public String home() {
		return "Welcome to JWT DEMO";
	}

	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		final UserDetails userDetails = service.loadUserByUsername(jwtRequest.getUsername());
		final String token = utility.generateToken(userDetails);
		return new JwtResponse(token);
	}
}

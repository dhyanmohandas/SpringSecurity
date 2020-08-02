package com.app.SpringSecurity.controller;

import org.springframework.web.bind.annotation.RestController;

import com.app.SpringSecurity.model.AuthRequest;
import com.app.SpringSecurity.service.UserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
class HomeController
{
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	UserDetailService UserDetailsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "Success";	
	}
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public void auth(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		}catch (Exception e) {
			
		}
		final UserDetails userDetails = UserDetailsService.loadUserByUsername(authRequest.getUserName());
		System.out.println("User" + userDetails.getPassword());
		
	}
}
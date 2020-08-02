package com.app.SpringSecurity.model;

public class AuthResponse {
	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public AuthResponse(String jwt) {
		super();
		this.jwt = jwt;
	} 
	
}

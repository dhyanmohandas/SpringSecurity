package com.app.SpringSecurity.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
	
	private String SECRET_KEY = "secret";
	
	public String generateToken(UserDetails userdetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userdetails.getUsername());
	}

	private String createToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 *10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

}

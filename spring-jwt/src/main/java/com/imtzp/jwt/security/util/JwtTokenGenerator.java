package com.imtzp.jwt.security.util;

import com.imtzp.jwt.security.transfer.JwtUserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

public class JwtTokenGenerator {

	public static String generateToken(JwtUserDto u, String secret) {
		Claims claims = Jwts.claims().setSubject(u.getUsername());

		claims.put("userId", u.getId());
		claims.put("role", u.getRole());

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public static void main(String[] args) {

		JwtUserDto user = new JwtUserDto();
		user.setId(123L);
		user.setUsername("Pascal");
		user.setRole("admin");

		System.out.println("**************************************\n\n" + generateToken(user, "my-very-secret-key")
				+ "\n\n**************************************");

		/**
		 * header和body是明文？？？
		 */
		System.out.println(TextCodec.BASE64URL.decodeToString("eyJhbGciOiJIUzUxMiJ9"));
		System.out.println(
				TextCodec.BASE64URL.decodeToString("eyJzdWIiOiJQYXNjYWwiLCJ1c2VySWQiOjEyMywicm9sZSI6ImFkbWluIn0"));
		System.out.println(TextCodec.BASE64URL.decodeToString(
				"tYfIzDTJBB7Nt8zZZUXzarbvHqKAB2-WQk_tlVyd0g9GwrpRVzEX4V5A91dd7-TcMmOPXTco8ysJncwHNk70AQ"));
	}
}

package com.imtzp.jwt.security.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.imtzp.jwt.security.transfer.JwtUserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenValidator {

	@Value("${jwt.secret}")
	private String secret;

	public JwtUserDto parseToken(String token) {

		JwtUserDto u = null;

		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

			u = new JwtUserDto();
			u.setUsername(body.getSubject());
			u.setId(((Integer) body.get("userId")).longValue());
			u.setRole((String) body.get("role"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}
}

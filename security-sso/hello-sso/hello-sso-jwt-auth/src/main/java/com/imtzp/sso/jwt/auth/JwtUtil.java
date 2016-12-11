package com.imtzp.sso.jwt.auth;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	public static String generateToken(String signingKey, String subject) {
		long nowMills = System.currentTimeMillis();
		Date now = new Date(nowMills);

		JwtBuilder builder = Jwts.builder().setSubject(subject).setIssuedAt(now).signWith(SignatureAlgorithm.HS256,
				signingKey);

		return builder.compact();
	}

	public static String getSubject(HttpServletRequest httpServletRequest, String jwtTokenCookieName,
			String signingKey) {
		String token = CookieUtil.getValue(httpServletRequest, jwtTokenCookieName);

		if (token == null) {
			return null;
		}

		return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody().getSubject();
	}
}

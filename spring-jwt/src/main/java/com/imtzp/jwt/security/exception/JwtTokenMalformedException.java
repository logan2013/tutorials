package com.imtzp.jwt.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Thrown when token cannot be parsed
 * 
 * @author pascal alma
 */
@SuppressWarnings("serial")
public class JwtTokenMalformedException extends AuthenticationException {

	public JwtTokenMalformedException(String msg) {
		super(msg);
	}
}

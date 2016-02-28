package it.clefra.spring.security;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {
	
	private static final long serialVersionUID = 2605753663515189901L;

	public InvalidJwtAuthenticationException(String msg) {
		super(msg);
	}	

}

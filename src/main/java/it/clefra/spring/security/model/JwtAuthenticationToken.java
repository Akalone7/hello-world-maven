package it.clefra.spring.security.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {
	private static final long serialVersionUID = -1084924233897925869L;
	
	private String token;
	private final Object principal;

	public JwtAuthenticationToken(String token) {
		super(null, null);
		this.token = token;
		principal = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Object getCredentials() {
		return "";
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

}

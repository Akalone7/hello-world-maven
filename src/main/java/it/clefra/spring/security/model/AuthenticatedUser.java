package it.clefra.spring.security.model;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class AuthenticatedUser extends JwtUser {

	private static final long serialVersionUID = -3756565843998775274L;
	
	private List<GrantedAuthority> authorities;

	private String token;

	public AuthenticatedUser(Long id, String username, String token, List<GrantedAuthority> authorities) {
		super(username);
		super.setId(id);
		this.token = token;
		this.authorities = authorities;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	

}

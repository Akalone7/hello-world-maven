package it.clefra.spring.security.model;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class AuthenticatedUser extends JwtUser {

	private static final long serialVersionUID = -3756565843998775274L;
	
	private Collection<GrantedAuthority> authorities;

	private String token;

	public AuthenticatedUser(Long id, String username, String token, Collection<GrantedAuthority> authorities) {
		super(username, "", authorities);
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
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	

}

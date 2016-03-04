package it.clefra.spring.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class JwtUser extends User{
	private static final long serialVersionUID = -4323498767711763037L;
	protected Long id;
	protected String role;
	
	public JwtUser(String username, String password, Collection<GrantedAuthority> authorityList){
		super(username, password, authorityList);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

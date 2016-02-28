package it.clefra.spring.security.model;

import org.springframework.security.core.userdetails.User;

public class JwtUser extends User{
	private static final long serialVersionUID = -4323498767711763037L;
	protected String username;
	protected Long id;
	protected String role;
	
	public JwtUser(String username){
		super(username, null, null);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

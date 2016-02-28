package it.clefra.spring.security;

import it.clefra.spring.security.model.AuthenticatedUser;
import it.clefra.spring.security.model.JwtAuthenticationToken;
import it.clefra.spring.security.model.JwtUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	@Autowired 
	private JwtUtil jwtUtil;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(JwtAuthenticationToken.class);
	}
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
		String token = jwtAuthenticationToken.getToken();
		JwtUser user = jwtUtil.parseToken(token);
		if(user == null) {
			//TODO lanciare eccenzione
		}
		List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
		return new AuthenticatedUser(user.getId(), user.getUsername(), token, authorityList);
	}

}

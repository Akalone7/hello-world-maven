package it.clefra.spring.security;

import static org.springframework.http.HttpMethod.OPTIONS;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import it.clefra.spring.security.model.AuthenticatedUser;
import it.clefra.spring.security.model.ClefraHttpServletRequestWrapper;
import it.clefra.spring.security.model.JwtAuthenticationToken;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	
	public static final String AUTHORIZATION_HEADER_NAME = "Authorization";
	public static final String JWT_HEADER_PREFIX = "Bearer";
	public static final Integer JWT_HEADER_LENGTH = 7;
	

	public JwtAuthenticationFilter() {
        super("/**");
    }
	
    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return isProtected(request);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String header = request.getHeader(AUTHORIZATION_HEADER_NAME);

        if (header == null || !header.startsWith(JWT_HEADER_PREFIX)) {
            throw new InvalidJwtAuthenticationException("No JWT token found in request headers"); //TODO Custom Exception.
        }

        String authToken = header.substring(JWT_HEADER_LENGTH);
        

        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

        return getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        // As this authentication is in HTTP header, after success we need to continue the request normally
        // and return the response as if the resource was not secured at all
        
        if(AuthenticatedUser.class.isAssignableFrom(authResult.getPrincipal().getClass())){
        	AuthenticatedUser user = AuthenticatedUser.class.cast(authResult.getPrincipal());
        	ClefraHttpServletRequestWrapper requestWrapper = new ClefraHttpServletRequestWrapper(request, user.getUsername());
        	chain.doFilter(requestWrapper, response);
		} else {
			chain.doFilter(request, response);
		}
    }
    
    private Boolean isProtected(HttpServletRequest request){
    	Boolean out = true;
    	
    	if(request != null){
    		HttpMethod requestMethod =  HttpMethod.valueOf(request.getMethod());
    		
    		if(OPTIONS.equals(requestMethod)){
    			out = false;
    		}
    	}
    	
    	return out;
    }
}
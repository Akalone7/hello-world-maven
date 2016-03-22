package it.clefra.spring.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;

import it.clefra.spring.security.model.ClefraHttpServletRequestWrapper;

/**
 * @author <a href="mailto:francesco.mirenda@finconsgroup.com">Francesco L Mirenda</a>
 *
 */
public class UserHeaderJwtFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request instanceof SecurityContextHolderAwareRequestWrapper) {
			SecurityContextHolderAwareRequestWrapper unwrappedRequest = (SecurityContextHolderAwareRequestWrapper) request;
			if(unwrappedRequest.getRequest() instanceof ClefraHttpServletRequestWrapper){
				ClefraHttpServletRequestWrapper req = (ClefraHttpServletRequestWrapper) unwrappedRequest.getRequest();
				req.addHeader("UserId", "admin");
				chain.doFilter(req, response);
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

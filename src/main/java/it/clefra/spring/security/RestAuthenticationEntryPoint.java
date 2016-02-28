package it.clefra.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * 
 * @author Francesco
 *
 */

public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// Metodo invocato quando l'utente cerca di accedere ad una risorsa
		// senza fornire le credenziali.
		// Si restituisce semplicemente una response con codice 401 (non
		// autorizzato), in quanto non c'è alcuna redirect a una pagina di login.
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		
	}
	
	

}

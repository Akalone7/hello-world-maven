package it.clefra.web.controllers;

import it.clefra.persistence.model.CredentialsModel;
import it.clefra.persistence.model.DummyModel;
import it.clefra.persistence.repositories.CredentialsRepository;
import it.clefra.spring.security.JwtTokenGenerator;
import it.clefra.web.dto.AuthenticationDto;
import it.clefra.web.dto.CredentialsDto;
import it.clefra.web.dto.DummyDto;

import org.opensaml.xml.security.credential.CredentialResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(LoginController.API_ROOT_URI )
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	public static final String API_ROOT_URI = "/authentication";

	@Autowired
	private CredentialsRepository credentialsRepository;
	/**
	 * 
	 * @param credentialDto
	 * @return
	 */

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AuthenticationDto> authenticate(@RequestBody(required = true) CredentialsDto credentialDto) {
		LOGGER.debug("Start check authentication");
		CredentialsModel credentialsModel = null;
		AuthenticationDto output = new AuthenticationDto();
		//TODO Web<->Persistence Mapper
		try{
			credentialsModel = credentialsRepository.findByUsernameAndPassword(credentialDto.getUsername(), credentialDto.getPassword());
			if(credentialsModel != null) {
				String token = JwtTokenGenerator.createJWT("1", "test", "", "{\"user\": \"" + credentialsModel.getUsername() + "\", \"password\" : \"" + credentialsModel.getUsername() + "\", \"role\": \"USER\"}", 1000000);
				output.setJwt(token);
			}
		} catch (final Exception e){
			LOGGER.error(e.getMessage(), e);
		}

		ResponseEntity<AuthenticationDto> response = new  ResponseEntity<AuthenticationDto>(output, HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}



}

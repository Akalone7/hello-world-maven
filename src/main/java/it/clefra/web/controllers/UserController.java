package it.clefra.web.controllers;

import it.clefra.persistence.model.CredentialsModel;
import it.clefra.persistence.model.DummyModel;
import it.clefra.persistence.repositories.CredentialsRepository;
import it.clefra.spring.security.JwtTokenGenerator;
import it.clefra.spring.security.JwtUtil;
import it.clefra.spring.security.model.JwtUser;
import it.clefra.web.dto.AuthenticationDto;
import it.clefra.web.dto.CredentialsDto;
import it.clefra.web.dto.DummyDto;
import it.clefra.web.dto.UserDetailDto;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RepositoryRestController @RequestMapping (UserController.API_ROOT_URI)	
public class UserController {
	
	public static final String API_ROOT_URI = "/user";
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private CredentialsRepository credentialRepository;
	@Autowired
	private JwtUtil jwtUtil;

	@RequestMapping(value = "/{jwt}", method = RequestMethod.GET)
	public ResponseEntity<UserDetailDto> get(@PathVariable String jwt) {
		LOGGER.debug("Start getting user");
		String username = null;
		//determino l'user a partire dal jwt
		JwtUser jwtUser = jwtUtil.parseToken(jwt); 
		if(jwtUser != null) {
			username = jwtUser.getUsername();
		}
		UserDetailDto userDetailDto = new UserDetailDto();
		CredentialsModel crendentialModel = credentialRepository.findByUsername(username);
		if(crendentialModel != null) {
			userDetailDto.setUsername(username);
		}
		
		
		ResponseEntity<UserDetailDto> response = new  ResponseEntity<UserDetailDto>(userDetailDto, HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}

}

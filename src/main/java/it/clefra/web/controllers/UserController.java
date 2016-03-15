package it.clefra.web.controllers;

import it.clefra.persistence.model.UserModel;
import it.clefra.persistence.repositories.CredentialsRepository;
import it.clefra.persistence.repositories.UsersRepository;
import it.clefra.spring.security.InvalidJwtAuthenticationException;
import it.clefra.spring.security.JwtUtil;
import it.clefra.spring.security.model.JwtUser;
import it.clefra.web.dto.UserDetailDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RepositoryRestController @RequestMapping (UserController.API_ROOT_URI)	
public class UserController {

	public static final String API_ROOT_URI = "/user";
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	public static final String AUTHORIZATION_HEADER_NAME = "Authorization";
	public static final String JWT_HEADER_PREFIX = "Bearer";
	public static final Integer JWT_HEADER_LENGTH = 7;
	
	@Autowired
	private CredentialsRepository credentialRepository;
	
	@Autowired
    private UsersRepository usersRepository;
	
	@Autowired
	private JwtUtil jwtUtil;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<UserDetailDto> get(@RequestHeader(AUTHORIZATION_HEADER_NAME) String authorizationHeader) {
		LOGGER.debug("Start getting user");
		String username = null;
		//determino l'user a partire dal jwt
		if (authorizationHeader == null || !authorizationHeader.startsWith(JWT_HEADER_PREFIX)) {
			throw new InvalidJwtAuthenticationException("No JWT token found in request headers"); //TODO Custom Exception.
		}
		String jwtToken = authorizationHeader.substring(JWT_HEADER_LENGTH);

		JwtUser jwtUser = jwtUtil.parseToken(jwtToken); 
		if(jwtUser != null) {
			username = jwtUser.getUsername();
		}
		UserDetailDto userDetailDto = new UserDetailDto();
		UserModel userModel = usersRepository.findByUsername(username);
	    userDetailDto = UserDetailDto.from(userModel);
		ResponseEntity<UserDetailDto> response = new  ResponseEntity<UserDetailDto>(userDetailDto, HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDetailDto> insert(@RequestHeader(AUTHORIZATION_HEADER_NAME) String authorizationHeader, @RequestBody UserDetailDto userDetailDto) {
		LOGGER.debug("Start getting user");
		//determino l'user a partire dal jwt
		if (authorizationHeader == null || !authorizationHeader.startsWith(JWT_HEADER_PREFIX)) {
			throw new InvalidJwtAuthenticationException("No JWT token found in request headers"); //TODO Custom Exception.
		}
		String jwtToken = authorizationHeader.substring(JWT_HEADER_LENGTH);

		JwtUser jwtUser = jwtUtil.parseToken(jwtToken); 
		UserModel savedUserModel = null;
		if(jwtUser != null && userDetailDto != null) {
			savedUserModel = usersRepository.insert(UserDetailDto.toUserModel(userDetailDto));
		}
		ResponseEntity<UserDetailDto> response = new  ResponseEntity<UserDetailDto>(UserDetailDto.from(savedUserModel), HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}
}

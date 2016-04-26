package it.clefra.web.controllers;

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

import it.clefra.persistence.model.UserModel;
import it.clefra.persistence.repositories.UsersRepository;
import it.clefra.web.dto.UserDetailDto;

@RepositoryRestController @RequestMapping (SignUpController.API_ROOT_URI)	
public class SignUpController {

	public static final String API_ROOT_URI = "/signup";
	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class);
	
	@Autowired
    private UsersRepository usersRepository;
	
	@RequestMapping(value="/checkUsername/{username}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> get(@PathVariable String username) {
		LOGGER.debug("Start getting user");

		Boolean usernamePresent = usersRepository.findByUsername(username) != null;
		ResponseEntity<Boolean> response = new  ResponseEntity<Boolean>(usernamePresent, HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDetailDto> insert(@RequestBody UserDetailDto userDetailDto) {
		LOGGER.debug("Start saving user");
		UserModel savedUserModel = null;
		if(userDetailDto != null) {
			savedUserModel = usersRepository.insert(UserDetailDto.toUserModel(userDetailDto));
		}
		ResponseEntity<UserDetailDto> response = new  ResponseEntity<>(UserDetailDto.from(savedUserModel), HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}
}

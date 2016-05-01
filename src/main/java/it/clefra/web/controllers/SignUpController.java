package it.clefra.web.controllers;

import java.util.Optional;

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

import it.clefra.persistence.model.CredentialsModel;
import it.clefra.persistence.model.UserModel;
import it.clefra.persistence.repositories.CredentialsRepository;
import it.clefra.persistence.repositories.UsersRepository;
import it.clefra.service.interfaces.SignUpService;
import it.clefra.web.dto.CredentialsDto;
import it.clefra.web.dto.UserDetailDto;

@RepositoryRestController @RequestMapping (SignUpController.API_ROOT_URI)	
public class SignUpController {

	public static final String API_ROOT_URI = "/signup";
	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class);
	
	@Autowired
    private UsersRepository usersRepository;
	
	@Autowired
    private SignUpService signUpService;
	
	@RequestMapping(value="/checkUsername/{username}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> get(@PathVariable String username) {
		LOGGER.debug("Start getting user");

		Boolean usernamePresent = usersRepository.findByUsername(username) != null;
		ResponseEntity<Boolean> response = new  ResponseEntity<>(usernamePresent, HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}
	
	/*	TODO
	 *	Gestire rollback manuale nel caso in cui uno dei due salvataggi dovesse fallire.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDetailDto> insert(@RequestBody SignUpDataRequest signUpDataRequest) {
		LOGGER.debug("Start saving user");
		UserDetailDto userDetailDto = null;
		try{
		Optional<UserDetailDto> optional = signUpService.register(signUpDataRequest);
		if(optional.isPresent()) {
			userDetailDto = optional.get();
		}
		} catch (final Exception e){
			
		}
		ResponseEntity<UserDetailDto> response = new  ResponseEntity<>(userDetailDto, HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}
	
	public static class SignUpDataRequest {
		private UserDetailDto userDetails;
		private CredentialsDto credentials;
		/**
		 * @return the userDetails
		 */
		public UserDetailDto getUserDetails() {
			return userDetails;
		}
		/**
		 * @param userDetails the userDetails to set
		 */
		public void setUserDetails(UserDetailDto userDetails) {
			this.userDetails = userDetails;
		}
		/**
		 * @return the credentials
		 */
		public CredentialsDto getCredentials() {
			return credentials;
		}
		/**
		 * @param credentials the credentials to set
		 */
		public void setCredentials(CredentialsDto credentials) {
			this.credentials = credentials;
		}
	}
}

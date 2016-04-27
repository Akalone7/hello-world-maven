package it.clefra.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.clefra.persistence.model.CredentialsModel;
import it.clefra.persistence.model.UserModel;
import it.clefra.persistence.repositories.CredentialsRepository;
import it.clefra.persistence.repositories.UsersRepository;
import it.clefra.service.interfaces.SignUpService;
import it.clefra.web.controllers.SignUpController.SignUpDataRequest;
import it.clefra.web.dto.CredentialsDto;
import it.clefra.web.dto.UserDetailDto;

@Service
public class SignUpServiceBean implements SignUpService{

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private CredentialsRepository credentialRepository;

	@Override
	public Optional<UserDetailDto> register(SignUpDataRequest signUpDataRequest) {
		UserModel savedUserModel = null;
		if(signUpDataRequest != null) {
			savedUserModel = usersRepository.insert(UserDetailDto.toUserModel(signUpDataRequest.getUserDetails()));
			CredentialsModel credentialModel = CredentialsDto.toCredentialsModel(signUpDataRequest.getCredentials());
			credentialRepository.insert(credentialModel);
		}
		return Optional.ofNullable(UserDetailDto.from(savedUserModel));
	}


}

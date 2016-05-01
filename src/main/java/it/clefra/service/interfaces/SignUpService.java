package it.clefra.service.interfaces;

import java.util.Optional;

import it.clefra.web.controllers.SignUpController.SignUpDataRequest;
import it.clefra.web.dto.UserDetailDto;

public interface SignUpService {
    public Optional<UserDetailDto> register(SignUpDataRequest signUpDataRequest) throws Exception;
}

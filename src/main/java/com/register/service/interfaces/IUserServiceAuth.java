package com.register.service.interfaces;

import com.register.service.auth.app.JwtResponse;
import com.register.service.auth.app.LoginRequest;
import com.register.service.auth.app.SignUpRequestDto;
import com.register.service.dto.UserDTO;

public interface IUserServiceAuth {

	
	UserDTO signUp(SignUpRequestDto signUpRequestDto);
	
	JwtResponse login (LoginRequest loginRequest);
	
	
}

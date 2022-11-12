package com.register.service.auth.app;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {

	private Long id;

	private String name;
	
	private String lastName;
	
	private String secondLastName;

	private String email;

	private List<String> roles;

	private String jwt;

	

}

package com.register.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(info = @Info(title = "Registro de usurios ", version = "2.0", description = "Recopila toda la info de los usuarios "))
@SpringBootApplication
public class RegisterMain {

	public static void main(String[] args) {
		SpringApplication.run(RegisterMain.class, args);


	}

}

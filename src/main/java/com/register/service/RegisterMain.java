package com.register.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(info = @Info(title = "proyecto en blanco", version = "2.0", description = "Information"))
@SpringBootApplication
public class RegisterMain {

	public static void main(String[] args) {
		SpringApplication.run(RegisterMain.class, args);

		// test develop
	}

}

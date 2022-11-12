package com.register.service.auth.app;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignUpRequestDto {
	
  @NotBlank
  @Size(min = 3, max = 245)
  private String name;
  
  @NotBlank
  @Size(min = 3, max = 45)
  private String lastName;
  
  @NotBlank
  @Size(min = 3, max = 45)
  private String secondLastName;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  
  @Size(max = 8)
  @NotBlank
  private String postCode;
  
  @Size(max = 8)
  @NotBlank
  private int  townCode;


  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  
}

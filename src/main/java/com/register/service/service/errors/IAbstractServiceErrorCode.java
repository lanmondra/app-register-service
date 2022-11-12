package com.register.service.service.errors;

import com.register.service.exceptions.IRegisterExcepcionsCode;

public interface IAbstractServiceErrorCode extends IRegisterExcepcionsCode {
	
	String SERVICE_ERROR_CODE = ERROR + SERVICE;
	
	String SERVICE_VALIDATOR_ERROR_CODE = SERVICE_ERROR_CODE + "001"; 						// 1001001
	String SERVICE_BASE_USER_ERROR_CODE = SERVICE_ERROR_CODE + "002"; 						// 1002002
	String SERVICE_PROVINCE_TOWN_ERROR_CODE = SERVICE_ERROR_CODE + "003"; 					// 1002003
	

}


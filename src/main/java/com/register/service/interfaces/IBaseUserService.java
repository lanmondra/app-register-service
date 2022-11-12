package com.register.service.interfaces;

import com.register.service.entities.BaseUser;

public interface IBaseUserService {

	BaseUser findUserByEmail(String userEmail);



}

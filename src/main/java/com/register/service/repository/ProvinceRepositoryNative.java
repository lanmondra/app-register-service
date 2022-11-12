package com.register.service.repository;

import com.register.service.dto.ProvinceDTO;

public interface ProvinceRepositoryNative {
	
	
	ProvinceDTO findByName(String name);
	
	ProvinceDTO findByProvinceId(int provinceId);

}

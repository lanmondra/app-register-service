package com.register.service.repository;


import com.register.service.dto.TownDTO;

import java.util.List;


public interface TownRepositoryNative {

	
	List<TownDTO> findByProvinceId(Integer provinceId);
	
	List<TownDTO> findByProvinceName(String provinceName);
	
	TownDTO findByName(String name);
	
	
}

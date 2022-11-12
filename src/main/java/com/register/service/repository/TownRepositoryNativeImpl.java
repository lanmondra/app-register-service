package com.register.service.repository;

import com.register.service.dto.TownDTO;
import com.register.service.entities.Town;

import java.util.List;


public class TownRepositoryNativeImpl  extends AbstractRepository<Town, Integer> implements TownRepositoryNative{
	
	String TOWN_FIELD="t.id AS id, "+
					  "t.name AS name, "+
					  "t.province_id AS provinceId ";
	
	String PROVINCE_FIELD="p.id AS id, "+
			  			"p.name AS name ";

	@Override
	public List<TownDTO> findByProvinceId(Integer provinceId) {
		String sql = "SELECT "+ TOWN_FIELD +
				"FROM town t "+
				"LEFT JOIN province p ON p.id = t.province_id "+
				"WHERE t.province_id = "+provinceId +"";

	return listDTO(sql, TownDTO.class);
	}

	@Override
	public List<TownDTO> findByProvinceName(String provinceName) {
		String sql = "SELECT "+ TOWN_FIELD +
				"FROM town t "+
				"LEFT JOIN province p ON p.id = t.province_id "+
				"WHERE p.name = "+provinceName +"";
		
		return listDTO(sql, TownDTO.class);
	}

	@Override
	public TownDTO findByName(String name) {
		
		String sql = "SELECT "+ TOWN_FIELD +
				"FROM town t "+
				"WHERE t.name ='"+name+"'";
		
		return (TownDTO) uniqueDTO(sql, TownDTO.class);
	}
	


}




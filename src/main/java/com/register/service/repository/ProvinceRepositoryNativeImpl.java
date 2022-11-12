
package com.register.service.repository;

import com.register.service.dto.ProvinceDTO;
import com.register.service.entities.Province;

public class ProvinceRepositoryNativeImpl extends AbstractRepository<Province, Integer>
		implements ProvinceRepositoryNative {

	String PROVINCE_FIELD = "p.id AS id, " + "p.name AS name ";

	@Override
	public ProvinceDTO findByName(String name) {

		String sql = "SELECT " + PROVINCE_FIELD + "FROM province p " + "WHERE p.name = " + name + "";

		return (ProvinceDTO) uniqueDTO(sql, ProvinceDTO.class);
	}

	@Override
	public ProvinceDTO findByProvinceId(int provinceId) {

		String sql = "SELECT " + PROVINCE_FIELD + "FROM province p " + "WHERE p.id = " + provinceId + "";

		return (ProvinceDTO) uniqueDTO(sql, ProvinceDTO.class);
	}

}

package com.register.service.service;

import com.register.service.dto.ProvinceDTO;
import com.register.service.dto.TownDTO;
import com.register.service.entities.Town;
import com.register.service.repository.ProvinceRepository;
import com.register.service.repository.TownRepository;
import com.register.service.service.errors.IProvinceTownServiceErrorCode;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProvinceTownService extends AbstractService {
	
	private ProvinceRepository provinceRepository ;
	
	private TownRepository townRepository;

	public ProvinceTownService(ProvinceRepository provinceRepository, TownRepository townRepository) {
		super();
		this.provinceRepository = provinceRepository;
		this.townRepository = townRepository;
	}

	/**
	 * Busca una provincia por town province id
	 * @param provinceId
	 * @return
	 */
	public ProvinceDTO findProvinceByTownProvinceId(int provinceId) {

		ProvinceDTO provinceDTO =  provinceRepository.findByProvinceId(provinceId);
		if(provinceDTO == null) {
			notifyError(IProvinceTownServiceErrorCode.PROVINCE_NOT_FOUND);
		}

		return provinceDTO;

	}
	
	/**
	 * Busca una ciudad por nombre 
	 * @param name
	 * @return
	 */
	public TownDTO findTownByName (String name ) {
		
		TownDTO townDTO = townRepository.findByName(name);
		if(townDTO == null) {
			notifyError(IProvinceTownServiceErrorCode.TOWN_NOT_FOUND);
		}
		
	return 	townDTO;
		
	}

	public Town findTownByid(int townId){

		Optional<Town> townOpt = townRepository.findById(townId);
		if(townOpt.isEmpty()){
			notifyError(IProvinceTownServiceErrorCode.TOWN_NOT_FOUND);
		}
		return townOpt.get();

	}
	


}

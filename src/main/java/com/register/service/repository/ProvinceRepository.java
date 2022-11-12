package com.register.service.repository;

import com.register.service.entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface ProvinceRepository  extends JpaRepository<Province, Integer> , ProvinceRepositoryNative {
	
	//Optional<Province> findByName(String name);

}

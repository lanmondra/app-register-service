package com.register.service.repository;

import com.register.service.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TownRepository  extends JpaRepository<Town, Integer>  , TownRepositoryNative {
	
	//Optional<Town> findByName(String name);
	

	

}

package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.TransitCodes;

@Repository
public interface TransitCodeRepository extends JpaRepository<TransitCodes, String>{
	
	public List<TransitCodes> findByServiceCode(String code);	
	
}
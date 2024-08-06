package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.FeeType;

@Repository
public interface FeeTypeRepository extends JpaRepository<FeeType, String> {

	public FeeType findByName(String label);

}

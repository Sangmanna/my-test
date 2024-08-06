package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.SubTier;

@Repository
public interface SubTierRepository extends JpaRepository<SubTier, String> {

	public SubTier findByName(String name);
	
	public List<SubTier> findByIdNot(String id);
}

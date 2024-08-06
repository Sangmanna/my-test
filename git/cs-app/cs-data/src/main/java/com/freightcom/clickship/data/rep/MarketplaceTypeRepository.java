package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.MarketplaceType;

@Repository
public interface MarketplaceTypeRepository extends JpaRepository<MarketplaceType, String> {

	public MarketplaceType findByName(String name);
	
	public List<MarketplaceType> findAllByOrderBySeq();
	
	public List<MarketplaceType> findByOrderImportType(String orderImportType);
	
}
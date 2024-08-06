package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.MarketplaceProduct;
import com.freightcom.clickship.data.entity.MarketplaceProductMultiBox;

@Repository
public interface MarketplaceProductMultiBoxRepository extends JpaRepository<MarketplaceProductMultiBox, String> {
	
	public void deleteAllByMarketplaceProduct(MarketplaceProduct obj);
	
	public List<MarketplaceProductMultiBox> findAllByMarketplaceProduct(MarketplaceProduct obj);
	
}
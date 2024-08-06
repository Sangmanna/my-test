package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceSetting;

@Repository
public interface MarketplaceSettingRepository extends JpaRepository<MarketplaceSetting, String> {
	
	public MarketplaceSetting findByMarketplace(Marketplace marketplace);

	public List<MarketplaceSetting> findAllByMarketplaceIn(List<Marketplace> list);
	
	public List<MarketplaceSetting> findAllByMarketplaceInAndLocationSplitIsTrue(List<Marketplace> list);
	
}
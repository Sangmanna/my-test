package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Box;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceSetting;
import com.freightcom.clickship.data.entity.PalletContingencyRates;

@Repository
public interface PalletContingencyRatesRepository extends JpaRepository<PalletContingencyRates, String> {
	
	public void deleteByBox(Box box);
	
	public List<PalletContingencyRates> findAllByBox(Box box);

	public List<PalletContingencyRates> findAllByMarketplace(Marketplace marketplace);
	
	public PalletContingencyRates findByMarketplaceSettingIdAndBoxId(String settingId, String boxId);
	
	public List<PalletContingencyRates> findAllByMarketplaceSetting(MarketplaceSetting marketplaceSetting);
	
	public PalletContingencyRates findByMarketplaceSettingAndBox(MarketplaceSetting marketplaceSetting, Box box);
	
}
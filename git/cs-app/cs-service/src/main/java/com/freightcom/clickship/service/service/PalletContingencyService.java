package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.MarketplaceSetting;
import com.freightcom.clickship.model.rates.PalletContingencyRatesDTO;

public interface PalletContingencyService {
	
	public void savePalletContingencyRates(List<PalletContingencyRatesDTO> list);
	
	public PalletContingencyRatesDTO getByMarketplaceSettingAndBox(MarketplaceSetting setting, String boxId);
	
	public List<PalletContingencyRatesDTO> getByMarketplaceSetting(Customer cutomer, MarketplaceSetting setting);
	
}

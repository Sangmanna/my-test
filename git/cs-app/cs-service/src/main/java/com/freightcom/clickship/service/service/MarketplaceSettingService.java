package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceSetting;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.model.marketplace.MarketplaceSettingDTO;

public interface MarketplaceSettingService {
	
	public MarketplaceSetting getMarketplaceSettingById(String id);
	
	public List<MarketplaceSettingDTO> getMarketplaceSettingByCustomer(Customer customer);
	
	public MarketplaceSetting getMarketplaceSettingByMarketplace(Marketplace marketplace);
	
	public MarketplaceSetting getMarketplaceSettingByMarketplaceId(String marketplaceId);
	
	public MarketplaceSettingDTO getMarketplaceSettingDTOByMarketplaceId(String marketplaceId, User user);

}

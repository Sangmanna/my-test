package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.MarketplaceType;

public interface MarketplaceTypeService {
	
	public List<MarketplaceType> getAllMarketplaceTypes();

	public MarketplaceType getMarketplaceTypeByName(String name);
	
}

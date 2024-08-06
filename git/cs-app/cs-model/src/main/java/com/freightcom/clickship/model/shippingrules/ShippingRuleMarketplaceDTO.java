package com.freightcom.clickship.model.shippingrules;

import com.freightcom.clickship.model.marketplace.MarketplaceDTO;

public class ShippingRuleMarketplaceDTO {
	private String id; 
	private MarketplaceDTO marketplaceDTO;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MarketplaceDTO getMarketplaceDTO() {
		return marketplaceDTO;
	}
	public void setMarketplaceDTO(MarketplaceDTO marketplaceDTO) {
		this.marketplaceDTO = marketplaceDTO;
	}
}

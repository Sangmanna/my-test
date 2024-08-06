package com.freightcom.clickship.model.marketplace;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.CommonDTO;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketplaceFulfilmentRequest extends CommonDTO implements Serializable {

	private static final long serialVersionUID = 7213844772908172333L;

	private String type;
	
	private String orderId;
	
	private String marketplaceId;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getMarketplaceId() {
		return marketplaceId;
	}

	public void setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
	}
	
}
package com.freightcom.clickship.model.marketplace.amazon.products;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MarketplaceASIN")
@XmlAccessorType(XmlAccessType.FIELD)
public class MarketplaceASIN implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="MarketplaceId")
	private String marketplaceId;
	@XmlElement(name="ASIN")
	private String asin;
	
	public MarketplaceASIN() {
		super();
	}
	
	public MarketplaceASIN(String marketplaceId, String asin) {
		super();
		this.marketplaceId = marketplaceId;
		this.asin = asin;
	}

	public String getMarketplaceId() {
		return marketplaceId;
	}

	public void setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

}

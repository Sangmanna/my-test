package com.freightcom.clickship.model.marketplace.amazon.products;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Identifiers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Identifiers implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="MarketplaceASIN")
	private MarketplaceASIN marketplaceASIN;
	
	public Identifiers() {
		super();
	}
	
	public Identifiers(MarketplaceASIN marketplaceASIN) {
		this.marketplaceASIN = marketplaceASIN;
	}

	public MarketplaceASIN getMarketplaceASIN() {
		return marketplaceASIN;
	}

	public void setMarketplaceASIN(MarketplaceASIN marketplaceASIN) {
		this.marketplaceASIN = marketplaceASIN;
	}
}

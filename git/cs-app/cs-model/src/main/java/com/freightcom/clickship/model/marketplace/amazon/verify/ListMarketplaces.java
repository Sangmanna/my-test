package com.freightcom.clickship.model.marketplace.amazon.verify;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ListMarketplaces")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListMarketplaces implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="Marketplace")	
	private List<AmazonMarketplace> marketplaces;
	
	public ListMarketplaces() {
		super();
	}
	
	public ListMarketplaces(List<AmazonMarketplace> marketplaces) {
		super();
		this.marketplaces = marketplaces;
	}

	public List<AmazonMarketplace> getMarketplaces() {
		return marketplaces;
	}

	public void setMarketplaces(List<AmazonMarketplace> marketplaces) {
		this.marketplaces = marketplaces;
	}
	
}

package com.freightcom.clickship.model.marketplace.amazon;

public enum AmazonMarketplaceEnum {
	
	AMAZON_CA("A2EUQ1WTGCTBG2", "www.amazon.ca", "CA"),
	AMAZON_COM("ATVPDKIKX0DER", "www.amazon.com", "US");
	
	AmazonMarketplaceEnum(String id, String domain, String code) {
		this.id = id;
		this.domain = domain;
		this.countryCode = code;
	}
	
	private String id;
	
	private String domain;
	
	private String countryCode;

	public String getId() {
		return id;
	}

	public String getDomain() {
		return domain;
	}

	public String getCountryCode() {
		return countryCode;
	}
}

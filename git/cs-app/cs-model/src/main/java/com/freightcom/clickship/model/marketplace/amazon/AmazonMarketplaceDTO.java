package com.freightcom.clickship.model.marketplace.amazon;

import java.io.Serializable;

public class AmazonMarketplaceDTO implements Serializable{
	
	private static final long serialVersionUID = -7206207461391015490L;
	
	private String name;
	
	private String domainName;
	
	private String marketplaceId;
	
	private String defaultCountryCode;
	
	private String defaultCurrencyCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarketplaceId() {
		return marketplaceId;
	}

	public void setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
	}

	public String getDefaultCountryCode() {
		return defaultCountryCode;
	}

	public void setDefaultCountryCode(String defaultCountryCode) {
		this.defaultCountryCode = defaultCountryCode;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getDefaultCurrencyCode() {
		return defaultCurrencyCode;
	}

	public void setDefaultCurrencyCode(String defaultCurrencyCode) {
		this.defaultCurrencyCode = defaultCurrencyCode;
	}

}
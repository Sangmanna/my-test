package com.freightcom.clickship.model.marketplace.amazon.verify;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Marketplace")
@XmlAccessorType(XmlAccessType.FIELD)
public class AmazonMarketplace implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="MarketplaceId")
	private String MarketplaceId;
	
	@XmlElement(name="DefaultCountryCode")
	private String DefaultCountryCode;
	
	@XmlElement(name="DomainName")
	private String DomainName;
	
	@XmlElement(name="Name")
	private String Name;
	
	@XmlElement(name="DefaultCurrencyCode")
	private String DefaultCurrencyCode;

	@XmlElement(name="DefaultLanguageCode")
	private String DefaultLanguageCode;
	
	public AmazonMarketplace() {
		super();
	}
	
	public AmazonMarketplace(String MarketplaceId, String DefaultCountryCode,
			String DomainName, String Name, String DefaultCurrencyCode,
			String DefaultLanguageCode) {
		super();
		this.MarketplaceId = MarketplaceId;
		this.DefaultCountryCode = DefaultCountryCode;
		this.DomainName = DomainName;
		this.DefaultCurrencyCode = DefaultCurrencyCode;
		this.DefaultLanguageCode = DefaultLanguageCode;
	}

	public String getMarketplaceId() {
		return MarketplaceId;
	}

	public void setMarketplaceId(String MarketplaceId) {
		this.MarketplaceId = MarketplaceId;
	}

	public String getDefaultCountryCode() {
		return DefaultCountryCode;
	}

	public void setDefaultCountryCode(String DefaultCountryCode) {
		this.DefaultCountryCode = DefaultCountryCode;
	}

	public String getDomainName() {
		return DomainName;
	}

	public void setDomainName(String DomainName) {
		this.DomainName = DomainName;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getDefaultCurrencyCode() {
		return DefaultCurrencyCode;
	}

	public void setDefaultCurrencyCode(String DefaultCurrencyCode) {
		this.DefaultCurrencyCode = DefaultCurrencyCode;
	}

	public String getDefaultLanguageCode() {
		return DefaultLanguageCode;
	}

	public void setDefaultLanguageCode(String DefaultLanguageCode) {
		this.DefaultLanguageCode = DefaultLanguageCode;
	}
	
	@Override
	public String toString() {
		return "Marketplace [MarketplaceId="+MarketplaceId+",DefaultCountryCode="+DefaultCountryCode+", "
				+ "DomainName="+DomainName+", Name="+Name+", DefaultCurrencyCode="+DefaultCurrencyCode+","
						+ "DefaultLanguageCode="+DefaultLanguageCode+"]";
	}

}

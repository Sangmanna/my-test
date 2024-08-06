package com.freightcom.clickship.model.marketplace.amazon.verify;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Participation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Participation implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name="MarketplaceId")
	private String MarketplaceId;
	@XmlElement(name="SellerId")
	private String SellerId;
	@XmlElement(name="HasSellerSuspendedListings")
	private String HasSellerSuspendedListings;

	public Participation() {
		super();
	}

	public Participation(String MarketplaceId, String SellerId, String HasSellerSuspendedListings) {
		super();
		this.MarketplaceId = MarketplaceId;
		this.SellerId = SellerId;
		this.HasSellerSuspendedListings = HasSellerSuspendedListings;
	}

	public String getMarketplaceId() {
		return MarketplaceId;
	}

	public void setMarketplaceId(String MarketplaceId) {
		this.MarketplaceId = MarketplaceId;
	}

	public String getSellerId() {
		return SellerId;
	}

	public void setSellerId(String SellerId) {
		this.SellerId = SellerId;
	}

	public String getHasSellerSuspendedListings() {
		return HasSellerSuspendedListings;
	}

	public void setHasSellerSuspendedListings(String HasSellerSuspendedListings) {
		this.HasSellerSuspendedListings = HasSellerSuspendedListings;
	}

	@Override
	public String toString() {
		return "Participation [MarketplaceId=" + MarketplaceId + ", SellerId=" + SellerId
				+ ",HasSellerSuspendedListings=" + HasSellerSuspendedListings + "]";
	}

}

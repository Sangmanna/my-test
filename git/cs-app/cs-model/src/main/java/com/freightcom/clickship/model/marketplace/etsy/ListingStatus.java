package com.freightcom.clickship.model.marketplace.etsy;

public enum ListingStatus {

	DRAFT("draft"),
	ACTIVE("active"),
	EXPIRED("expired"),
	INACTIVE("inactive"),
	TRENDING("trending"),
	INTERESTING("interesting");

	private String status;

	ListingStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}

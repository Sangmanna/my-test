package com.freightcom.clickship.model.marketplace.etsy.v3;

public enum EtsyListingState {

	DRAFT("draft"),
	ACTIVE("active"),
	EXPIRED("expired"),
	INACTIVE("inactive"),
	SOLD_OUT("sold_out");

	private String state;

	EtsyListingState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

}

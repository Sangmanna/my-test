package com.freightcom.clickship.model.marketplace.bestbuy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BestBuyProducts {

	private BestBuyOffers offers;

	public BestBuyOffers getOffers() {
		return offers;
	}

	public void setOffers(BestBuyOffers offers) {
		this.offers = offers;
	}
	
}

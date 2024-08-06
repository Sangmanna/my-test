package com.freightcom.clickship.model.marketplace.bestbuy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BestBuyProduct {

	private List<BestBuyOffers> offers;

	public List<BestBuyOffers> getOffers() {
		return offers;
	}

	public void setOffers(List<BestBuyOffers> offers) {
		this.offers = offers;
	}
	
}

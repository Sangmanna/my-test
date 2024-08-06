package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReverbShopLinks {
	@JsonProperty("listings")
	public ReverbLinksDetails listings;
	
	@JsonProperty("follow")
	public ReverbLinksDetails follow;
	
	@JsonProperty("feedback")
	public ReverbLinksDetails feedback;
	
	@JsonProperty("shops")
	public ReverbLinksDetails shops;
	
	@JsonProperty("self")
	public ReverbSelfLinksDetails self;
	
	@JsonProperty("vacation")
	public ReverbLinksDetails vacation;
	
	@JsonProperty("listing_conditions")
	public ReverbLinksDetails listingConditions;

	public ReverbLinksDetails getListings() {
		return listings;
	}

	public void setListings(ReverbLinksDetails listings) {
		this.listings = listings;
	}

	public ReverbLinksDetails getFollow() {
		return follow;
	}

	public void setFollow(ReverbLinksDetails follow) {
		this.follow = follow;
	}

	public ReverbLinksDetails getFeedback() {
		return feedback;
	}

	public void setFeedback(ReverbLinksDetails feedback) {
		this.feedback = feedback;
	}

	public ReverbLinksDetails getShops() {
		return shops;
	}

	public void setShops(ReverbLinksDetails shops) {
		this.shops = shops;
	}

	public ReverbSelfLinksDetails getSelf() {
		return self;
	}

	public void setSelf(ReverbSelfLinksDetails self) {
		this.self = self;
	}

	public ReverbLinksDetails getVacation() {
		return vacation;
	}

	public void setVacation(ReverbLinksDetails vacation) {
		this.vacation = vacation;
	}

	public ReverbLinksDetails getListingConditions() {
		return listingConditions;
	}

	public void setListingConditions(ReverbLinksDetails listingConditions) {
		this.listingConditions = listingConditions;
	}
	
	
	
}

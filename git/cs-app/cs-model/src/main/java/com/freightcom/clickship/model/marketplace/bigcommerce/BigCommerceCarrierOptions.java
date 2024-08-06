package com.freightcom.clickship.model.marketplace.bigcommerce;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceCarrierOptions implements Serializable {
	
	private static final long serialVersionUID = 4238307133921746940L;

	@JsonProperty("show_transit_time")
	private String showTransitTime;
	
	@JsonProperty("packaging")
	private List<String> packaging = new ArrayList<>();
	
	public BigCommerceCarrierOptions() {
		super();
	}

	public BigCommerceCarrierOptions(String showTransitTime) {
		super();
		this.showTransitTime = showTransitTime;
	}

	public String getShowTransitTime() {
		return showTransitTime;
	}

	public BigCommerceCarrierOptions setShowTransitTime(String showTransitTime) {
		this.showTransitTime = showTransitTime;
		return this;
	}

	public List<String> getPackaging() {
		return packaging;
	}

	public BigCommerceCarrierOptions setPackaging(List<String> packaging) {
		this.packaging = packaging;
		return this;
	}
	
}

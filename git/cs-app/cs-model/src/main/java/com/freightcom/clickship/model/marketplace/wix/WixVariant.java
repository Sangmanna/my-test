package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixVariant {

	@JsonProperty("weight")
	private Double weight;

	@JsonProperty("sku")
	private String sku;

	@JsonProperty("visible")
	private Boolean visible;

	@JsonProperty("priceData")
	private WixPriceData priceData;

	@JsonProperty("convertedPriceData")
	private WixPriceData convertedPriceData;

	public Double getWeight() {
		return weight;
	}

	public WixVariant setWeight(Double weight) {
		this.weight = weight;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public WixVariant setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public Boolean getVisible() {
		return visible;
	}

	public WixVariant setVisible(Boolean visible) {
		this.visible = visible;
		return this;
	}

	public WixPriceData getPriceData() {
		return priceData;
	}

	public WixVariant setPriceData(WixPriceData priceData) {
		this.priceData = priceData;
		return this;
	}

	public WixPriceData getConvertedPriceData() {
		return convertedPriceData;
	}

	public WixVariant setConvertedPriceData(WixPriceData convertedPriceData) {
		this.convertedPriceData = convertedPriceData;
		return this;
	}

}

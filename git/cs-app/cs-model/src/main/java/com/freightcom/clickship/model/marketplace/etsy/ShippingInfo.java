package com.freightcom.clickship.model.marketplace.etsy;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingInfo implements Serializable {

	private static final long serialVersionUID = -6894304177244278327L;

	@JsonProperty("shipping_info_id")
	private Integer shippingInfoId;

	@JsonProperty("origin_country_id")
	private Integer originCountryId;

	@JsonProperty("destination_country_id")
	private Integer destinationCountryId;

	@JsonProperty("currency_code")
	private String currencyCode;

	@JsonProperty("primary_cost")
	private Float primaryCost;

	@JsonProperty("secondary_cost")
	private Float secondaryCost;

	@JsonProperty("listing_id")
	private Integer listingId;

	@JsonProperty("region_id")
	private Integer regionId;

	@JsonProperty("origin_country_name")
	private String originCountryName;

	@JsonProperty("destination_country_name")
	private String destinationCountryName;

	public Integer getShippingInfoId() {
		return shippingInfoId;
	}

	public void setShippingInfoId(Integer shippingInfoId) {
		this.shippingInfoId = shippingInfoId;
	}

	public Integer getOriginCountryId() {
		return originCountryId;
	}

	public void setOriginCountryId(Integer originCountryId) {
		this.originCountryId = originCountryId;
	}

	public Integer getDestinationCountryId() {
		return destinationCountryId;
	}

	public void setDestinationCountryId(Integer destinationCountryId) {
		this.destinationCountryId = destinationCountryId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Float getPrimaryCost() {
		return primaryCost;
	}

	public void setPrimaryCost(Float primaryCost) {
		this.primaryCost = primaryCost;
	}

	public Float getSecondaryCost() {
		return secondaryCost;
	}

	public void setSecondaryCost(Float secondaryCost) {
		this.secondaryCost = secondaryCost;
	}

	public Integer getListingId() {
		return listingId;
	}

	public void setListingId(Integer listingId) {
		this.listingId = listingId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getOriginCountryName() {
		return originCountryName;
	}

	public void setOriginCountryName(String originCountryName) {
		this.originCountryName = originCountryName;
	}

	public String getDestinationCountryName() {
		return destinationCountryName;
	}

	public void setDestinationCountryName(String destinationCountryName) {
		this.destinationCountryName = destinationCountryName;
	}

	@Override
	public String toString() {
		return "ShippingInfo{" + "shippingInfoId=" + shippingInfoId + ", originCountryId=" + originCountryId
				+ ", destinationCountryId=" + destinationCountryId + ", currencyCode='" + currencyCode + '\''
				+ ", primaryCost=" + primaryCost + ", secondaryCost=" + secondaryCost + ", listingId=" + listingId
				+ ", regionId=" + regionId + ", originCountryName='" + originCountryName + '\''
				+ ", destinationCountryName='" + destinationCountryName + '\'' + '}';
	}
}

package com.freightcom.clickship.model.marketplace.etsy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingProduct implements Serializable {

	private static final long serialVersionUID = 6535041732008566906L;

	@JsonProperty("property_values")
	List<PropertyValue> propertyValues;

	@JsonProperty("product_id")
	private Long productId;

	@JsonProperty("sku")
	private String sku;

	@JsonProperty("offerings")
	private List<ListingOffering> offerings;

	@JsonProperty("isDeleted")
	private boolean deleted;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public List<PropertyValue> getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(List<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public List<ListingOffering> getOfferings() {
		return offerings;
	}

	public void setOfferings(List<ListingOffering> offerings) {
		this.offerings = offerings;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}

package com.freightcom.clickship.model.marketplace.etsy.v3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtsyVariantProduct implements Serializable {

	private static final long serialVersionUID = -8724088186876709226L;

	@JsonProperty("product_id")
	private Long productId;
	
	@JsonProperty("sku")
	private String sku;	
	
	@JsonProperty("is_deleted")
	private Boolean deleted;
	
	@JsonProperty("offerings")
	private List<ListingOffering> offerings;
	
	@JsonProperty("property_values")
	private List<EtsyVariantProperty> properties;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public List<EtsyVariantProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<EtsyVariantProperty> properties) {
		this.properties = properties;
	}
	
}

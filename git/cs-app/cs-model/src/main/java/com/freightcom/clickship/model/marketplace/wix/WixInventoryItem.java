package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixInventoryItem {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("externalId")
	private String externalId;
	
	@JsonProperty("productId")
	private String productId;
	
	@JsonProperty("trackQuantity")
	private Boolean trackQuantity;
	
	@JsonProperty("variants")
	private WixVariants variants;

	public String getId() {
		return id;
	}

	public WixInventoryItem setId(String id) {
		this.id = id;
		return this;
	}

	public String getExternalId() {
		return externalId;
	}

	public WixInventoryItem setExternalId(String externalId) {
		this.externalId = externalId;
		return this;
	}

	public String getProductId() {
		return productId;
	}

	public WixInventoryItem setProductId(String productId) {
		this.productId = productId;
		return this;
	}

	public Boolean getTrackQuantity() {
		return trackQuantity;
	}

	public WixInventoryItem setTrackQuantity(Boolean trackQuantity) {
		this.trackQuantity = trackQuantity;
		return this;
	}

	public WixVariants getVariants() {
		return variants;
	}

	public WixInventoryItem setVariants(WixVariants variants) {
		this.variants = variants;
		return this;
	}
	
}

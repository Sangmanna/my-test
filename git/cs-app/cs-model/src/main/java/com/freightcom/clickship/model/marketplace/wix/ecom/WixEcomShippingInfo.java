package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomShippingInfo {

	@JsonProperty("carrierId")
	private String carrierId;

	@JsonProperty("code")
	private String code;

	@JsonProperty("title")
	private String title;

	@JsonProperty("logistics")
	private WixEcomLogistics logistics;

	@JsonProperty("cost")
	private WixEcomCost cost;

	@JsonProperty("region")
	private WixEcomRegion region;

	public String getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public WixEcomLogistics getLogistics() {
		return logistics;
	}

	public void setLogistics(WixEcomLogistics logistics) {
		this.logistics = logistics;
	}

	public WixEcomCost getCost() {
		return cost;
	}

	public void setCost(WixEcomCost cost) {
		this.cost = cost;
	}

	public WixEcomRegion getRegion() {
		return region;
	}

	public void setRegion(WixEcomRegion region) {
		this.region = region;
	}

}

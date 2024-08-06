package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixSiteProperties {

	@JsonProperty("businessName")
	private String businessName;
	
	@JsonProperty("siteDisplayName")
	private String siteDisplayName;

	@JsonProperty("email")
	private String email;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("address")
	private WixAddress address;

	public String getBusinessName() {
		return businessName;
	}

	public WixSiteProperties setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}
	
	public String getSiteDisplayName() {
		return siteDisplayName;
	}

	public WixSiteProperties setSiteDisplayName(String siteDisplayName) {
		this.siteDisplayName = siteDisplayName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public WixSiteProperties setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public WixSiteProperties setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public WixAddress getAddress() {
		return address;
	}

	public WixSiteProperties setAddress(WixAddress address) {
		this.address = address;
		return this;
	}
	
}

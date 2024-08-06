package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomBillingInfo {

	@JsonProperty("address")
	private WixEcomAddress address;

	@JsonProperty("contactDetails")
	private WixEcomContactDetails contactDetails;

	public WixEcomAddress getAddress() {
		return address;
	}

	public void setAddress(WixEcomAddress address) {
		this.address = address;
	}

	public WixEcomContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(WixEcomContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
}

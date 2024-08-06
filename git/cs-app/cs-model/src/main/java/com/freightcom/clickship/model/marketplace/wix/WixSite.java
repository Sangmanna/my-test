package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixSite {

	@JsonProperty("siteDisplayName")
	private String siteDisplayName;

	@JsonProperty("url")
	private String url;
	
	@JsonProperty("paymentCurrency")
	private String paymentCurrency;
	
	public String getSiteDisplayName() {
		return siteDisplayName;
	}

	public WixSite setSiteDisplayName(String siteDisplayName) {
		this.siteDisplayName = siteDisplayName;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public WixSite setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public WixSite setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
		return this;
	}

}

package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedShop extends LightSpeedBaseEntity{

	@JsonProperty("status")
	public String status;

	@JsonProperty("isB2B")
	public boolean isB2b;

	@JsonProperty("isRetail")
	public boolean isRetail;

	@JsonProperty("subDomain")
	public String subDomain;

	@JsonProperty("mainDomain")
	public String mainDomain;

	@JsonProperty("email")
	public String email;

	@JsonProperty("currency")
	public LightSpeedCurrency currency;

	public String getStatus() {
		return status;
	}

	public LightSpeedShop setStatus(String status) {
		this.status = status;
		return this;
	}

	public boolean isB2b() {
		return isB2b;
	}

	public LightSpeedShop setB2b(boolean isB2b) {
		this.isB2b = isB2b;
		return this;
	}

	public boolean isRetail() {
		return isRetail;
	}

	public LightSpeedShop setRetail(boolean isRetail) {
		this.isRetail = isRetail;
		return this;
	}

	public String getSubDomain() {
		return subDomain;
	}

	public LightSpeedShop setSubDomain(String subDomain) {
		this.subDomain = subDomain;
		return this;
	}

	public String getMainDomain() {
		return mainDomain;
	}

	public LightSpeedShop setMainDomain(String mainDomain) {
		this.mainDomain = mainDomain;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public LightSpeedShop setEmail(String email) {
		this.email = email;
		return this;
	}

	public LightSpeedCurrency getCurrency() {
		return currency;
	}

	public LightSpeedShop setCurrency(LightSpeedCurrency currency) {
		this.currency = currency;
		return this;
	}
}

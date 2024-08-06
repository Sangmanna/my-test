package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsShipperAccount implements Serializable {
	
	private static final long serialVersionUID = -5550062284497559702L;

	@JsonProperty("AccountNumber")
	private String accountNumber;
	
	@JsonProperty("AccountCountryCode")
	private String accountCountryCode;

	public String getAccountNumber() {
		return accountNumber;
	}

	public UpsShipperAccount setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
		return this;
	}

	public String getAccountCountryCode() {
		return accountCountryCode;
	}

	public UpsShipperAccount setAccountCountryCode(String accountCountryCode) {
		this.accountCountryCode = accountCountryCode;
		return this;
	}

}

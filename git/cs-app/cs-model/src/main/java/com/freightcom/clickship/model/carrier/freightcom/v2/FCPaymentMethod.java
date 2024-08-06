package com.freightcom.clickship.model.carrier.freightcom.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FCPaymentMethod {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("label")
	private String label;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("number")
	private String number;
	
	@JsonProperty("expiry_month")
	private Integer expiryMonth;
	
	@JsonProperty("expiry_year")
	private Integer expiryYear;
	
	@JsonProperty("cvd")
	private String cvd;
	
	@JsonProperty("last_four_digits")
	private String lastFour;

	@JsonProperty("account_ids")
	private FCAccountIds accountIds;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public Integer getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getCvd() {
		return cvd;
	}

	public void setCvd(String cvd) {
		this.cvd = cvd;
	}

	public String getLastFour() {
		return lastFour;
	}

	public void setLastFour(String lastFour) {
		this.lastFour = lastFour;
	}

	public FCAccountIds getAccountIds() {
		return accountIds;
	}

	public void setAccountIds(FCAccountIds accountIds) {
		this.accountIds = accountIds;
	}
}

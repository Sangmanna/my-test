package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodsPostRequestV2 {
	
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
	
	@JsonProperty("last_four")
	private String lastFour;

	@JsonProperty("is_primary")
	private Boolean isPrimary = false;
	
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

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
}

package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChargesTaxesDTO {

	@JsonProperty("type")
	private String type;

	@JsonProperty("amount")
	private CostDTO amount;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CostDTO getAmount() {
		return amount;
	}

	public void setAmount(CostDTO amount) {
		this.amount = amount;
	}

}

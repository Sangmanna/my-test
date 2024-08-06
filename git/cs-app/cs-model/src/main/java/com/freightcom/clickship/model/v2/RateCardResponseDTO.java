package com.freightcom.clickship.model.v2;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RateCardResponseDTO {

	@JsonProperty("status")
	private StatusDTO status;

	@JsonProperty("rates")
	private List<RatesResponseDTO> rates;

	public StatusDTO getStatus() {
		return status;
	}

	public void setStatus(StatusDTO status) {
		this.status = status;
	}

	public List<RatesResponseDTO> getRates() {
		return rates;
	}

	public void setRates(List<RatesResponseDTO> rates) {
		this.rates = rates;
	}

}

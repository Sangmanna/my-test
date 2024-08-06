package com.freightcom.clickship.model.carrier.midland;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseWrapper {

	@JsonProperty("RateQuote")
	private List<RateQuote> rateQuotes;

	@JsonProperty("ErrorMessage")
	private List<String> errorMessages;

	public ResponseWrapper() {
	}

	public ResponseWrapper(List<RateQuote> rateQuote) {
		this.rateQuotes = rateQuote;
	}

	public List<RateQuote> getRateQuotes() {
		return rateQuotes;
	}

	public void setRateQuotes(List<RateQuote> rateQuotes) {
		this.rateQuotes = rateQuotes;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}
}

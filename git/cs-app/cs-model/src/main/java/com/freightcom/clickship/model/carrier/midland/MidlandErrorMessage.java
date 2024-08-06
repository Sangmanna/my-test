package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
public class MidlandErrorMessage {
	
	@JsonProperty("ErrorMessage")
	private String errorMessage;

	@JsonProperty("ErrorMessageTranslated")
	private String errorMessageTranslated;
	
	@JsonProperty("ErrorNumber")
	private String errorNumber;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessageTranslated() {
		return errorMessageTranslated;
	}

	public void setErrorMessageTranslated(String errorMessageTranslated) {
		this.errorMessageTranslated = errorMessageTranslated;
	}

	public String getErrorNumber() {
		return errorNumber;
	}

	public void setErrorNumber(String errorNumber) {
		this.errorNumber = errorNumber;
	}
}

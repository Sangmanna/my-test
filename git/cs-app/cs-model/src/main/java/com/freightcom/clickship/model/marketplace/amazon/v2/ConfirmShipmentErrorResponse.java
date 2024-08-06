package com.freightcom.clickship.model.marketplace.amazon.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ConfirmShipmentErrorResponse {
	private List<AmazonError> errors;

	public List<AmazonError> getErrors() {
		return errors;
	}

	public void setErrors(List<AmazonError> errors) {
		this.errors = errors;
	}
	
	
}

package com.freightcom.clickship.model.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends RuntimeException {
	private static final long serialVersionUID = -6950863177244518733L;
	public static final String ADDITIONAL_ERROR_CODE = "ADDITIONAL_ERROR_CODE";

	// will be sent to frontend and used there
	private final List<String> additionalErrorCodes = new ArrayList<>();

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(String message, List<String> errorCodes) {
		super(message);
		this.additionalErrorCodes.addAll(errorCodes);
	}

	public List<String> getAdditionalErrorCodes() {
		return additionalErrorCodes;
	}
}
package com.freightcom.clickship.model.exception;

public class CSInvalidAccessRuntimeException extends RuntimeException {
	
	private static final long serialVersionUID = 6079957968962447793L;

	public CSInvalidAccessRuntimeException() {
		super();
	}

	public CSInvalidAccessRuntimeException(String message) {
		super(message);
	}
	
}

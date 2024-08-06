package com.freightcom.clickship.model.exception;

public abstract class ServiceDenialException extends RuntimeException {
	private static final long serialVersionUID = -4944960531665084189L;

	public ServiceDenialException() {
        super();
    }

    public ServiceDenialException(String message) {
        super(message);
    }

	public abstract String getErrorType();
}

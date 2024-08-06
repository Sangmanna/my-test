package com.freightcom.clickship.model.exception;

public class UserDeactivatedException extends RuntimeException {

	private static final long serialVersionUID = 4244099773256981625L;

	public UserDeactivatedException() {
		super();
	}

	public UserDeactivatedException(String message) {
		super(message);
	}

}

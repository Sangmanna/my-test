package com.freightcom.clickship.model.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4244099773256981625L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message) {
		super(message);
	}

}

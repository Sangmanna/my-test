package com.freightcom.clickship.model.exception;

public class UserDeletedException extends RuntimeException {

	private static final long serialVersionUID = 4244099773256981625L;

	public UserDeletedException() {
		super();
	}

	public UserDeletedException(String message) {
		super(message);
	}

}

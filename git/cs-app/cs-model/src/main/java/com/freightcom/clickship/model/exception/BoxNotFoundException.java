package com.freightcom.clickship.model.exception;

public class BoxNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4244099773256981625L;

	public BoxNotFoundException() {
		super();
	}

	public BoxNotFoundException(String message) {
		super(message);
	}

}

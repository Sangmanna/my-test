package com.freightcom.clickship.model.exception;

public class AddressNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4244099773256981625L;

	public AddressNotFoundException() {
		super();
	}

	public AddressNotFoundException(String message) {
		super(message);
	}

}

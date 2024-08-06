package com.freightcom.clickship.model.exception;

public class OrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4244099773256981625L;

	public OrderNotFoundException() {
		super();
	}

	public OrderNotFoundException(String message) {
		super(message);
	}

}

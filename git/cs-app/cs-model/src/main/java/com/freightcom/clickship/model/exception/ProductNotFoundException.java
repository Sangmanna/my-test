package com.freightcom.clickship.model.exception;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4244099773256981625L;

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String message) {
		super(message);
	}

}

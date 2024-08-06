package com.freightcom.clickship.model.exception;

public class ShipmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4244099773256981625L;

	public ShipmentNotFoundException() {
		super();
	}

	public ShipmentNotFoundException(String message) {
		super(message);
	}

}

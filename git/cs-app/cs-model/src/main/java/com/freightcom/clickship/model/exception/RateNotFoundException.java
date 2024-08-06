package com.freightcom.clickship.model.exception;

public class RateNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 943460806264882687L;

	private static final String NO_RATE = "No rate found.";

	public RateNotFoundException() {
		super(NO_RATE);
	}

	public RateNotFoundException(String msg) {
		super(msg);
	}
}

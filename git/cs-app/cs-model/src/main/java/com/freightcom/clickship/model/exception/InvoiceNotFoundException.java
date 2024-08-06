package com.freightcom.clickship.model.exception;

public class InvoiceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4244099773256981625L;

	public InvoiceNotFoundException() {
		super();
	}

	public InvoiceNotFoundException(String message) {
		super(message);
	}

}

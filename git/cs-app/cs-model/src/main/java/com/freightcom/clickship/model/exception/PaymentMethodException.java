package com.freightcom.clickship.model.exception;

public class PaymentMethodException extends RuntimeException implements CustomExceptionInterface {

	private static final long serialVersionUID = -6935131333970489523L;

	public PaymentMethodException(String message) {
		super(message);
	}
}

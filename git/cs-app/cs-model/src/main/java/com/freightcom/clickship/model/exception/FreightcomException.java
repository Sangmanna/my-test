package com.freightcom.clickship.model.exception;

public class FreightcomException extends RuntimeException implements CustomExceptionInterface {

	private static final long serialVersionUID = -7875504569783543377L;

	public FreightcomException(String message) {
		super(message);
	}

}

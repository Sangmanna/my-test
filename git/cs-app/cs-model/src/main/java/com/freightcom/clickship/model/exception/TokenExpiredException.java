package com.freightcom.clickship.model.exception;

public class TokenExpiredException extends RuntimeException {

	private static final long serialVersionUID = 4244099773256981625L;

	public TokenExpiredException() {
		super();
	}

	public TokenExpiredException(String message) {
		super(message);
	}

}

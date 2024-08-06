package com.freightcom.clickship.model.exception.marketplace;

public class DuplicateStoreException extends RuntimeException {

	private static final long serialVersionUID = -7166625599158153529L;

	public DuplicateStoreException() {
		super();
	}

	public DuplicateStoreException(String message) {
		super(message);
	}

}

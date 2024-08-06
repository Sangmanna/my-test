package com.freightcom.clickship.model.exception.marketplace;

public class MarketplaceDoesNotExistException extends RuntimeException {

	private static final long serialVersionUID = -6728828498603695483L;

	public MarketplaceDoesNotExistException() {
		super();
	}

	public MarketplaceDoesNotExistException(String arg0) {
		super(arg0);
	}
}

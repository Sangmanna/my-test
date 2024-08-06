package com.freightcom.clickship.model.exception.marketplace;

public class MarketplaceImportException extends RuntimeException {

	private static final long serialVersionUID = -690205601085794960L;

	public MarketplaceImportException() {
		super();
	}

	public MarketplaceImportException(String message) {
		super(message);
	}

	public MarketplaceImportException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}

package com.freightcom.clickship.model.exception.marketplace;

public class MarketplaceRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -8865367890277448514L;

	public MarketplaceRuntimeException() {
		super();
	}

	public MarketplaceRuntimeException(String message) {
		super(message);
	}

	public MarketplaceRuntimeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}

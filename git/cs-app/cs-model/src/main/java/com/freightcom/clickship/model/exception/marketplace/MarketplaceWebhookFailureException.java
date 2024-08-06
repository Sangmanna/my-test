package com.freightcom.clickship.model.exception.marketplace;

public class MarketplaceWebhookFailureException extends RuntimeException {

	private static final long serialVersionUID = -8865367890277448514L;

	public MarketplaceWebhookFailureException() {
		super();
	}

	public MarketplaceWebhookFailureException(String message) {
		super(message);
	}

	public MarketplaceWebhookFailureException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}

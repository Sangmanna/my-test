package com.freightcom.clickship.client.ebay.digitalSignature;

public class EbayDigitalSignatureConfigException extends Exception {
	private static final long serialVersionUID = -693660653171765986L;

	public EbayDigitalSignatureConfigException() {
	}

	public EbayDigitalSignatureConfigException(String message) {
		super(message);
	}

	public EbayDigitalSignatureConfigException(String message, Throwable cause) {
		super(message, cause);
	}

	public EbayDigitalSignatureConfigException(Throwable cause) {
		super(cause);
	}

	public EbayDigitalSignatureConfigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
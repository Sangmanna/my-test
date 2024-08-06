package com.freightcom.clickship.client.ebay.digitalSignature;

public class EbayDigitalSignatureException extends Exception {
	private static final long serialVersionUID = 8182112260740627744L;

	public EbayDigitalSignatureException() {
	}

	public EbayDigitalSignatureException(String message) {
		super(message);
	}

	public EbayDigitalSignatureException(String message, Throwable cause) {
		super(message, cause);
	}

	public EbayDigitalSignatureException(Throwable cause) {
		super(cause);
	}

	public EbayDigitalSignatureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
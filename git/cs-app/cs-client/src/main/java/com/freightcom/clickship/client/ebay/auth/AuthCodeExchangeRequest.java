package com.freightcom.clickship.client.ebay.auth;

public class AuthCodeExchangeRequest {

	private String authCode;
	
	private String grantType;

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

}

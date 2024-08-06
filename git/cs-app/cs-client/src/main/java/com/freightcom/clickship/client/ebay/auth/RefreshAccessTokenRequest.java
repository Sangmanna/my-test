package com.freightcom.clickship.client.ebay.auth;

public class RefreshAccessTokenRequest {
	
	private String refreshToken;
	
	private String grantType;

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

}

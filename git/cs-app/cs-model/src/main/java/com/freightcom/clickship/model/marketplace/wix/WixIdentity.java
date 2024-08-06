package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WixIdentity {

	@JsonProperty("identityType")
	private String identityType;

	@JsonProperty("appId")
	private String appId;

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
}

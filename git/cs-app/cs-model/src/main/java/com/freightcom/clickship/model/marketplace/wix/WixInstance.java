package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixInstance {

	@JsonProperty("instanceId")
	private String instanceId;

	@JsonProperty("appName")
	private String appName;
	
	@JsonProperty("appVersion")
	private String appVersion;

	public String getInstanceId() {
		return instanceId;
	}

	public WixInstance setInstanceId(String instanceId) {
		this.instanceId = instanceId;
		return this;
	}

	public String getAppName() {
		return appName;
	}

	public WixInstance setAppName(String appName) {
		this.appName = appName;
		return this;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public WixInstance setAppVersion(String appVersion) {
		this.appVersion = appVersion;
		return this;
	}
	
	

}

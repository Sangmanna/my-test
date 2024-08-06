package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

	@JsonProperty("id")
	private String id;

	@JsonProperty("appId")
	private String appId;

	@JsonProperty("apiKey")
	private String apiKey;

	public String getId() {
		return id;
	}

	public Account setId(String id) {
		this.id = id;
		return this;
	}

	public String getAppId() {
		return appId;
	}

	public Account setAppId(String appId) {
		this.appId = appId;
		return this;
	}

	public String getApiKey() {
		return apiKey;
	}

	public Account setApiKey(String apiKey) {
		this.apiKey = apiKey;
		return this;
	}
}

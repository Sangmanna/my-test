package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixMetadata {

	@JsonProperty("items")
	private Integer items;

	@JsonProperty("offset")
	private Integer offset;

	@JsonProperty("instanceId")
	private String instanceId;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("requestId")
	private String requestId;

	@JsonProperty("identity")
	private WixIdentity identity;

	public Integer getItems() {
		return items;
	}

	public WixMetadata setItems(Integer items) {
		this.items = items;
		return this;
	}

	public Integer getOffset() {
		return offset;
	}

	public WixMetadata setOffset(Integer offset) {
		this.offset = offset;
		return this;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public WixIdentity getIdentity() {
		return identity;
	}

	public void setIdentity(WixIdentity identity) {
		this.identity = identity;
	}

}

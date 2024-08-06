package com.freightcom.clickship.model.marketplace.wix;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixWebhooksData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3368280151721633193L;

	@JsonProperty("eventType")
	private String eventType;

	@JsonProperty("instanceId")
	private String instanceId;

	@JsonProperty("data")
	private String data;

	public WixWebhooksData() {
		super();
	}

	public WixWebhooksData(String eventType, String instanceId, String data) {
		super();
		this.eventType = eventType;
		this.instanceId = instanceId;
		this.data = data;
	}

	public String getEventType() {
		return eventType;
	}

	public WixWebhooksData setEventType(String eventType) {
		this.eventType = eventType;
		return this;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public WixWebhooksData setInstanceId(String instanceId) {
		this.instanceId = instanceId;
		return this;
	}

	public String getData() {
		return data;
	}

	public WixWebhooksData setData(String data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return "WixWebhooksData [eventType=" + eventType + ", instanceId=" + instanceId + ", data=" + data + "]";
	}

}

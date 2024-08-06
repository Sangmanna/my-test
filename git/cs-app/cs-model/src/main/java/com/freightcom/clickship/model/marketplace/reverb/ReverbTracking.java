package com.freightcom.clickship.model.marketplace.reverb;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReverbTracking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("provider")
	private String provider;
	
	@JsonProperty("tracking_number")
	private String trackingNumber;
	
	@JsonProperty("send_notification")
	private boolean sendNotification;

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public boolean isSendNotification() {
		return sendNotification;
	}

	public void setSendNotification(boolean sendNotification) {
		this.sendNotification = sendNotification;
	}


	
	
	
	
}

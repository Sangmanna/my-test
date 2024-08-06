package com.freightcom.clickship.model.marketplace.etsy;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubmitTracking implements Serializable {

	private static final long serialVersionUID = -2185704761657208923L;

	@JsonProperty("tracking_code")
	private String trackingCode;

	@JsonProperty("carrier_name")
	private String carrierName;

	@JsonProperty("send_bcc")
	private boolean sendBcc;

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public boolean isSendBcc() {
		return sendBcc;
	}

	public void setSendBcc(boolean sendBcc) {
		this.sendBcc = sendBcc;
	}
}

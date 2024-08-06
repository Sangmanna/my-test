package com.freightcom.clickship.model.marketplace.etsy.v3;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtsyReceiptShipment implements Serializable {

	private static final long serialVersionUID = -4681148936617276851L;

	@JsonProperty("carrier_name")
	private String carrierName;

	@JsonProperty("receipt_shipping_id")
	private Long receiptShippingId;

	@JsonProperty("tracking_code")
	private String trackingCode;

	@JsonProperty("tracking_url")
	private String trackingUrl;

	@JsonProperty("buyer_note")
	private String buyerNote;

	@JsonProperty("notification_date")
	private Long notificationDate;

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public Long getReceiptShippingId() {
		return receiptShippingId;
	}

	public void setReceiptShippingId(Long receiptShippingId) {
		this.receiptShippingId = receiptShippingId;
	}

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public String getTrackingUrl() {
		return trackingUrl;
	}

	public void setTrackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
	}

	public String getBuyerNote() {
		return buyerNote;
	}

	public void setBuyerNote(String buyerNote) {
		this.buyerNote = buyerNote;
	}

	public Long getNotificationDate() {
		return notificationDate;
	}

	public void setNotificationDate(Long notificationDate) {
		this.notificationDate = notificationDate;
	}

}

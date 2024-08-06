package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetShipmentResponseDTO {

	@JsonProperty("id")
	private String id;

	@JsonProperty("state")
	private String state;

	@JsonProperty("transaction_number")
	private String transactionNumber;

	@JsonProperty("tracking_number")
	private String trackingNumber;

	@JsonProperty("tracking_numbers")
	private List<String> trackingNumbers;

	@JsonProperty("tracking_url")
	private String trackingURL;

	@JsonProperty("bolnumber")
	private String bloNumber;
	
	@JsonProperty("pickup_confirmation_number")
	private String pickupConfirmationNumber;
	
	@JsonProperty("details")
	private ShippingDetailsResponse details;

	@JsonProperty("labels")
	private List<ShippingResponseLabels> labels;

	@JsonProperty("rate")
	private RatesResponseDTO rate;
	
	@JsonProperty("order_source")
	private String orderSource;
	
	@JsonProperty("group_id")
	private V2TypeDetail groupDetails;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
	public String getTrackingURL() {
		return trackingURL;
	}

	public void setTrackingURL(String trackingURL) {
		this.trackingURL = trackingURL;
	}

	public String getBloNumber() {
		return bloNumber;
	}

	public void setBloNumber(String bloNumber) {
		this.bloNumber = bloNumber;
	}

	public String getPickupConfirmationNumber() {
		return pickupConfirmationNumber;
	}

	public void setPickupConfirmationNumber(String pickupConfirmationNumber) {
		this.pickupConfirmationNumber = pickupConfirmationNumber;
	}

	public RatesResponseDTO getRate() {
		return rate;
	}

	public void setRate(RatesResponseDTO rate) {
		this.rate = rate;
	}

	public List<ShippingResponseLabels> getLabels() {
		return labels;
	}

	public void setLabels(List<ShippingResponseLabels> labels) {
		this.labels = labels;
	}

	public ShippingDetailsResponse getDetails() {
		return details;
	}

	public void setDetails(ShippingDetailsResponse details) {
		this.details = details;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public V2TypeDetail getGroupDetails() {
		return groupDetails;
	}

	public void setGroupDetails(V2TypeDetail groupDetails) {
		this.groupDetails = groupDetails;
	}

	public List<String> getTrackingNumbers() {
		return trackingNumbers;
	}

	public void setTrackingNumbers(List<String> trackingNumbers) {
		this.trackingNumbers = trackingNumbers;
	}
}

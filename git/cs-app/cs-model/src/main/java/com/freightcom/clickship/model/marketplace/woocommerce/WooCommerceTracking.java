package com.freightcom.clickship.model.marketplace.woocommerce;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceTracking implements Serializable {

	private static final long serialVersionUID = 6614582838936048645L;
	
	@JsonProperty("tracking_id")
	private String Id;
	
	@JsonProperty("tracking_number")
	private String trackingNumber;
	
	@JsonProperty("tracking_provider")
	private String provider;

	@JsonProperty("tracking_link")
	private String trackingLink;
	
	@JsonProperty("date_shipped")
	private String dateShipped;

	public String getId() {
		return Id;
	}

	public WooCommerceTracking setId(String id) {
		Id = id;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public WooCommerceTracking setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public String getProvider() {
		return provider;
	}

	public WooCommerceTracking setProvider(String provider) {
		this.provider = provider;
		return this;
	}

	public String getTrackingLink() {
		return trackingLink;
	}

	public WooCommerceTracking setTrackingLink(String trackingLink) {
		this.trackingLink = trackingLink;
		return this;
	}

	public String getDateShipped() {
		return dateShipped;
	}

	public WooCommerceTracking setDateShipped(String dateShipped) {
		this.dateShipped = dateShipped;
		return this;
	}
	
}

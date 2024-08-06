package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyFulfillment implements Serializable {

	private static final long serialVersionUID = -1693661095755170148L;

	@JsonProperty("id")
	private long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("order_id")
	private long orderId;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("service")
	private String service;
	
	@JsonProperty("location_id")
	private Long locationId;
	
	@JsonProperty("tracking_url")
	private String trackingUrl;
	
	@JsonProperty("tracking_number")
	private String trackingNumber;
	
	@JsonProperty("tracking_company")
	private String trackingCompany;
	
	@JsonProperty("tracking_urls")
	private List<String> trackingUrls;
	
	@JsonProperty("tracking_numbers")
	private List<String> trackingNumbers;
	
	@JsonProperty("shipment_status")
	private String shipmentStatus;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("notify_customer")
	private boolean notifyCustomer = false;
	
	@JsonProperty("tracking_info")
	private ShopifyTrackingInfo trackingInfo;

	@JsonProperty("line_items")
	private List<ShopifyOrderLineItem> orderLines;
	
	@JsonProperty("line_items_by_fulfillment_order")
	private List<ShopifyOrderLineItem> lineItmes;
	
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdDate;
	
	@JsonProperty("updated_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date updatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getTrackingUrl() {
		return trackingUrl;
	}

	public void setTrackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getTrackingCompany() {
		return trackingCompany;
	}

	public void setTrackingCompany(String trackingCompany) {
		this.trackingCompany = trackingCompany;
	}

	public List<String> getTrackingUrls() {
		return trackingUrls;
	}

	public void setTrackingUrls(List<String> trackingUrls) {
		this.trackingUrls = trackingUrls;
	}

	public List<String> getTrackingNumbers() {
		return trackingNumbers;
	}

	public void setTrackingNumbers(List<String> trackingNumbers) {
		this.trackingNumbers = trackingNumbers;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public List<ShopifyOrderLineItem> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<ShopifyOrderLineItem> orderLines) {
		this.orderLines = orderLines;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isNotifyCustomer() {
		return notifyCustomer;
	}

	public void setNotifyCustomer(boolean notifyCustomer) {
		this.notifyCustomer = notifyCustomer;
	}

	public ShopifyTrackingInfo getTrackingInfo() {
		return trackingInfo;
	}

	public void setTrackingInfo(ShopifyTrackingInfo trackingInfo) {
		this.trackingInfo = trackingInfo;
	}

	public List<ShopifyOrderLineItem> getLineItmes() {
		return lineItmes;
	}

	public void setLineItmes(List<ShopifyOrderLineItem> lineItmes) {
		this.lineItmes = lineItmes;
	}

	@Override
	public String toString() {
		return "ShopifyFulfillment [id=" + id + ", name=" + name + ", orderId=" + orderId + ", status=" + status
				+ ", service=" + service + ", locationId=" + locationId + ", trackingUrl=" + trackingUrl
				+ ", trackingNumber=" + trackingNumber + ", trackingCompany=" + trackingCompany + ", orderLines="
				+ orderLines + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
}

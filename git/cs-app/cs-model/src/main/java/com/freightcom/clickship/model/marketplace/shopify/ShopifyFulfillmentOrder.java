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

public class ShopifyFulfillmentOrder implements Serializable {
	
	private static final long serialVersionUID = -1693661095755170148L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("shop_id")
	private Long shopId;
	
	@JsonProperty("order_id")
	private Long orderId;
	
	@JsonProperty("assigned_location_id")
	private Long assignedLocationId;
	
	@JsonProperty("request_status")
	private String requestStatus;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("supported_actions")
	private List<String> supportedActions;
	
	@JsonProperty("destination")
	private ShopifyAddress destination;
	
	@JsonProperty("line_items")
	private List<ShopifyOrderLineItem> orderLines;
	
	@JsonProperty("fulfillment_order_line_items")
	private List<ShopifyOrderLineItem> fulfillmentOrderLines;
	
	@JsonProperty("fulfill_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date fulfillAt;
	
	@JsonProperty("fulfill_by")
	private String fulfillBy;
	
	@JsonProperty("delivery_method")
	private ShopifyDeliveryMethod deliveryMethod;
	
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdDate;
	
	@JsonProperty("updated_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date updatedDate;

	@JsonProperty("assigned_location")
	private ShopifyAddress assignedLocation;

	public Long getId() {
		return id;
	}

	public ShopifyFulfillmentOrder setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public ShopifyFulfillmentOrder setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Long getOrderId() {
		return orderId;
	}

	public ShopifyFulfillmentOrder setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public Long getAssignedLocationId() {
		return assignedLocationId;
	}

	public ShopifyFulfillmentOrder setAssignedLocationId(Long assignedLocationId) {
		this.assignedLocationId = assignedLocationId;
		return this;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public ShopifyFulfillmentOrder setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public ShopifyFulfillmentOrder setStatus(String status) {
		this.status = status;
		return this;
	}

	public List<String> getSupportedActions() {
		return supportedActions;
	}

	public ShopifyFulfillmentOrder setSupportedActions(List<String> supportedActions) {
		this.supportedActions = supportedActions;
		return this;
	}

	public ShopifyAddress getDestination() {
		return destination;
	}

	public ShopifyFulfillmentOrder setDestination(ShopifyAddress destination) {
		this.destination = destination;
		return this;
	}

	public List<ShopifyOrderLineItem> getOrderLines() {
		return orderLines;
	}

	public ShopifyFulfillmentOrder setOrderLines(List<ShopifyOrderLineItem> orderLines) {
		this.orderLines = orderLines;
		return this;
	}

	public List<ShopifyOrderLineItem> getFulfillmentOrderLines() {
		return fulfillmentOrderLines;
	}

	public ShopifyFulfillmentOrder setFulfillmentOrderLines(List<ShopifyOrderLineItem> fulfillmentOrderLines) {
		this.fulfillmentOrderLines = fulfillmentOrderLines;
		return this;
	}

	public Date getFulfillAt() {
		return fulfillAt;
	}

	public ShopifyFulfillmentOrder setFulfillAt(Date fulfillAt) {
		this.fulfillAt = fulfillAt;
		return this;
	}

	public String getFulfillBy() {
		return fulfillBy;
	}

	public ShopifyFulfillmentOrder setFulfillBy(String fulfillBy) {
		this.fulfillBy = fulfillBy;
		return this;
	}

	public ShopifyDeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}

	public ShopifyFulfillmentOrder setDeliveryMethod(ShopifyDeliveryMethod deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
		return this;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public ShopifyFulfillmentOrder setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public ShopifyFulfillmentOrder setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}

	public ShopifyAddress getAssignedLocation() {
		return assignedLocation;
	}

	public ShopifyFulfillmentOrder setAssignedLocation(ShopifyAddress assignedLocation) {
		this.assignedLocation = assignedLocation;
		return this;
	}

}

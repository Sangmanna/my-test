package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoShipping implements Serializable {

	private static final long serialVersionUID = 4073536287565081899L;

	@JsonProperty("billing_address_id")
	private Integer billingAddressId;
	
	@JsonProperty("customer_id")
	private Integer customerId;
	
	@JsonProperty("entity_id")
	private Integer entityId;
	
	@JsonProperty("increment_id")
	private String incrementId;
	
	@JsonProperty("order_id")
	private Integer orderId;
	
	@JsonProperty("shipping_address_id")
	private Integer shippingAddressId;
	
	@JsonProperty("store_id")
	private Integer storeId;
	
	@JsonProperty("total_qty")
	private Integer quantity;
	
	@JsonProperty("method")
	private String method;
	
	@JsonProperty("items")
	private List<MagentoOrderItem> itemsList; 
	
	@JsonProperty("tracks")
	private List<MagentoShipmentTracking> tracks;

	@JsonProperty("comments")
	private List<MagentoComment> comments;
	
	private boolean notify;
	
	private boolean appendCommnet;

	@JsonProperty("address")
	private MagentoAddress address;

	public Integer getBillingAddressId() {
		return billingAddressId;
	}

	public MagentoShipping setBillingAddressId(Integer billingAddressId) {
		this.billingAddressId = billingAddressId;
		return this;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public MagentoShipping setCustomerId(Integer customerId) {
		this.customerId = customerId;
		return this;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public MagentoShipping setEntityId(Integer entityId) {
		this.entityId = entityId;
		return this;
	}

	public String getIncrementId() {
		return incrementId;
	}

	public MagentoShipping setIncrementId(String incrementId) {
		this.incrementId = incrementId;
		return this;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public MagentoShipping setOrderId(Integer orderId) {
		this.orderId = orderId;
		return this;
	}

	public Integer getShippingAddressId() {
		return shippingAddressId;
	}

	public MagentoShipping setShippingAddressId(Integer shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
		return this;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public MagentoShipping setStoreId(Integer storeId) {
		this.storeId = storeId;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public MagentoShipping setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public String getMethod() {
		return method;
	}

	public MagentoShipping setMethod(String method) {
		this.method = method;
		return this;
	}

	public List<MagentoOrderItem> getItemsList() {
		return itemsList;
	}

	public MagentoShipping setItemsList(List<MagentoOrderItem> itemsList) {
		this.itemsList = itemsList;
		return this;
	}

	public List<MagentoShipmentTracking> getTracks() {
		return tracks;
	}

	public MagentoShipping setTracks(List<MagentoShipmentTracking> tracks) {
		this.tracks = tracks;
		return this;
	}

	public List<MagentoComment> getComments() {
		return comments;
	}

	public MagentoShipping setComments(List<MagentoComment> comments) {
		this.comments = comments;
		return this;
	}

	public boolean isNotify() {
		return notify;
	}

	public MagentoShipping setNotify(boolean notify) {
		this.notify = notify;
		return this;
	}

	public boolean isAppendCommnet() {
		return appendCommnet;
	}

	public MagentoShipping setAppendCommnet(boolean appendCommnet) {
		this.appendCommnet = appendCommnet;
		return this;
	}

	public MagentoAddress getAddress() {
		return address;
	}

	public MagentoShipping setAddress(MagentoAddress address) {
		this.address = address;
		return this;
	}

}

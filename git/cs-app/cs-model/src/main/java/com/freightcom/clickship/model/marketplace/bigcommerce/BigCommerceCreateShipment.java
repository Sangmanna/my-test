package com.freightcom.clickship.model.marketplace.bigcommerce;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceCreateShipment {

	@JsonProperty("order_address_id")
	private Long orderAddressId;
	
	@JsonProperty("shipping_method")
	private String shippingMethod;
	
	@JsonProperty("shipping_provider")
	private String shippingProvider;
	
	@JsonProperty("tracking_carrier")
	private String trackingCarrier;

	@JsonProperty("tracking_link")
	private String trackingLink;
	
	@JsonProperty("tracking_number")
	private String trackingNumber;
	
	@JsonProperty("items")
	private List<BigCommerceCreateShipment.Items> items;
	
	public List<BigCommerceCreateShipment.Items> getItems() {
		return items;
	}

	public BigCommerceCreateShipment setItems(List<BigCommerceCreateShipment.Items> items) {
		this.items = items;
		return this;
	}
	
	public BigCommerceCreateShipment addItems(String orderProductId, int quantity) {
		if(items == null) {
			items = new ArrayList<>();
		}
		
		items.add(new Items(Integer.parseInt(orderProductId), quantity));
		return this;
	}

	public Long getOrderAddressId() {
		return orderAddressId;
	}

	public BigCommerceCreateShipment setOrderAddressId(Long orderAddressId) {
		this.orderAddressId = orderAddressId;
		return this;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public BigCommerceCreateShipment setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
		return this;
	}

	public String getTrackingCarrier() {
		return trackingCarrier;
	}

	public BigCommerceCreateShipment setTrackingCarrier(String trackingCarrier) {
		this.trackingCarrier = trackingCarrier;
		return this;
	}

	public String getTrackingLink() {
		return trackingLink;
	}

	public BigCommerceCreateShipment setTrackingLink(String trackingLink) {
		this.trackingLink = trackingLink;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public BigCommerceCreateShipment setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}
	
	public String getShippingProvider() {
		return shippingProvider;
	}

	public BigCommerceCreateShipment setShippingProvider(String shippingProvider) {
		this.shippingProvider = shippingProvider;
		return this;
	}

	private static class Items {
		
		@JsonProperty("order_product_id")
		private Integer orderProductId;
		
		@JsonProperty("quantity")
		private Integer quantity;
		
		Items(Integer orderProductId, Integer quantity) {
			super();
			this.orderProductId = orderProductId;
			this.quantity = quantity;
		}
		
	}
	
}

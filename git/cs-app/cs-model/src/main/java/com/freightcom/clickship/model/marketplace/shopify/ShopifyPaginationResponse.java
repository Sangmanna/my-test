package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyPaginationResponse implements Serializable {

	private static final long serialVersionUID = -4303584960782195902L;
	
	@JsonProperty("shop")
	private ShopifyStore shop;
	
	@JsonProperty("order")
	private ShopifyOrder order;
	
	@JsonProperty("product")
	private ShopifyProduct product;
	
	@JsonProperty("variant")
	private ShopifyVariant variant;
	
	@JsonProperty("location")
	private ShopifyAddress location;
	
	@JsonProperty("orders")
	private List<ShopifyOrder> orders;
	
	@JsonProperty("products")
	private List<ShopifyProduct> products;
	
	@JsonProperty("webhooks")
	private List<ShopifyWebhook> webhooks;
	
	@JsonProperty("fulfillment")
	private ShopifyFulfillment fulfillment;
	
	@JsonProperty("locations")
	private List<ShopifyAddress> locations;
	
	@JsonProperty("carrier_services")
	private List<ShopifyCarrierService> carrierServices;
	
	@JsonProperty("fulfillment_order")
	private ShopifyFulfillmentOrder shopifyFulfillmentOrder;
	
	@JsonProperty("fulfillment_orders")
	private List<ShopifyFulfillmentOrder> fulfillmentOrders;
	
	@JsonProperty("errors")
	private List<String> errors;

	public ShopifyStore getShop() {
		return shop;
	}

	public void setShop(ShopifyStore shop) {
		this.shop = shop;
	}

	public ShopifyOrder getOrder() {
		return order;
	}

	public void setOrder(ShopifyOrder order) {
		this.order = order;
	}

	public ShopifyProduct getProduct() {
		return product;
	}

	public void setProduct(ShopifyProduct product) {
		this.product = product;
	}
	
	public ShopifyAddress getLocation() {
		return location;
	}

	public void setLocation(ShopifyAddress location) {
		this.location = location;
	}

	public List<ShopifyOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<ShopifyOrder> orders) {
		this.orders = orders;
	}

	public List<ShopifyProduct> getProducts() {
		return products;
	}

	public void setProducts(List<ShopifyProduct> products) {
		this.products = products;
	}

	public List<ShopifyWebhook> getWebhooks() {
		return webhooks;
	}

	public void setWebhooks(List<ShopifyWebhook> webhooks) {
		this.webhooks = webhooks;
	}

	public ShopifyFulfillment getFulfillment() {
		return fulfillment;
	}

	public void setFulfillment(ShopifyFulfillment fulfillment) {
		this.fulfillment = fulfillment;
	}

	public List<ShopifyAddress> getLocations() {
		return locations;
	}

	public void setLocations(List<ShopifyAddress> locations) {
		this.locations = locations;
	}

	public List<ShopifyCarrierService> getCarrierServices() {
		return carrierServices;
	}

	public void setCarrierServices(List<ShopifyCarrierService> carrierServices) {
		this.carrierServices = carrierServices;
	}

	public List<ShopifyFulfillmentOrder> getFulfillmentOrders() {
		return fulfillmentOrders;
	}

	public void setFulfillmentOrders(List<ShopifyFulfillmentOrder> fulfillmentOrders) {
		this.fulfillmentOrders = fulfillmentOrders;
	}

	public ShopifyFulfillmentOrder getShopifyFulfillmentOrder() {
		return shopifyFulfillmentOrder;
	}

	public void setShopifyFulfillmentOrder(ShopifyFulfillmentOrder shopifyFulfillmentOrder) {
		this.shopifyFulfillmentOrder = shopifyFulfillmentOrder;
	}

	public ShopifyVariant getVariant() {
		return variant;
	}

	public void setVariant(ShopifyVariant variant) {
		this.variant = variant;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
}

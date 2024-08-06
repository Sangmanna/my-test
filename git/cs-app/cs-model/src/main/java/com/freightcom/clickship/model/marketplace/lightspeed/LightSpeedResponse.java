package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedResponse {

	@JsonProperty("count")
	private Integer count;

	@JsonProperty("webhook")
	private LightSpeedWebhooks webhook;

	@JsonProperty("webhooks")
	private List<LightSpeedWebhooks> webhooks;

	@JsonProperty("product")
	private LightSpeedProduct product;

	@JsonProperty("products")
	private List<LightSpeedProduct> products;

	@JsonProperty("variant")
	private LightSpeedVariant variant;

	@JsonProperty("variants")
	private List<LightSpeedVariant> variants;

	@JsonProperty("shop")
	private LightSpeedShop lightSpeedShop;

	@JsonProperty("shopCompany")
	private LightSpeedCompany shopCompany;

	@JsonProperty("orders")
	private List<LightSpeedOrder> orders;

	@JsonProperty("order")
	private LightSpeedOrder order;

	@JsonProperty("orderProducts")
	private List<EmbeddedResource> orderProducts;

	@JsonProperty("shipments")
	private List<LightSpeedShipment> shipments;

	@JsonProperty("shipment")
	private LightSpeedShipment shipment;

	@JsonProperty("externalService")
	private LightSpeedExternalService externalService;

	@JsonProperty("externalServices")
	private List<LightSpeedExternalService> externalServices;

	public Integer getCount() {
		return count;
	}

	public LightSpeedResponse setCount(Integer count) {
		this.count = count;
		return this;
	}

	public LightSpeedWebhooks getWebhook() {
		return webhook;
	}

	public LightSpeedResponse setWebhook(LightSpeedWebhooks webhook) {
		this.webhook = webhook;
		return this;
	}

	public List<LightSpeedWebhooks> getWebhooks() {
		return webhooks;
	}

	public LightSpeedResponse setWebhooks(List<LightSpeedWebhooks> webhooks) {
		this.webhooks = webhooks;
		return this;
	}

	public LightSpeedProduct getProduct() {
		return product;
	}

	public LightSpeedResponse setProduct(LightSpeedProduct product) {
		this.product = product;
		return this;
	}

	public List<LightSpeedProduct> getProducts() {
		return products;
	}

	public LightSpeedResponse setProducts(List<LightSpeedProduct> products) {
		this.products = products;
		return this;
	}

	public LightSpeedVariant getVariant() {
		return variant;
	}

	public LightSpeedResponse setVariant(LightSpeedVariant variant) {
		this.variant = variant;
		return this;
	}

	public List<LightSpeedVariant> getVariants() {
		return variants;
	}

	public LightSpeedResponse setVariants(List<LightSpeedVariant> variants) {
		this.variants = variants;
		return this;
	}

	public LightSpeedShop getLightSpeedShop() {
		return lightSpeedShop;
	}

	public void setLightSpeedShop(LightSpeedShop lightSpeedShop) {
		this.lightSpeedShop = lightSpeedShop;
	}

	public LightSpeedCompany getShopCompany() {
		return shopCompany;
	}

	public LightSpeedResponse setShopCompany(LightSpeedCompany shopCompany) {
		this.shopCompany = shopCompany;
		return this;
	}

	public List<LightSpeedOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<LightSpeedOrder> orders) {
		this.orders = orders;
	}

	public LightSpeedOrder getOrder() {
		return order;
	}

	public void setOrder(LightSpeedOrder order) {
		this.order = order;
	}

	public List<EmbeddedResource> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<EmbeddedResource> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public LightSpeedShipment getShipment() {
		return shipment;
	}

	public void setShipment(LightSpeedShipment shipment) {
		this.shipment = shipment;
	}

	public List<LightSpeedShipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<LightSpeedShipment> shipments) {
		this.shipments = shipments;
	}

	public LightSpeedExternalService getExternalService() {
		return externalService;
	}

	public void setExternalService(LightSpeedExternalService externalService) {
		this.externalService = externalService;
	}

	public List<LightSpeedExternalService> getExternalServices() {
		return externalServices;
	}

	public void setExternalServices(List<LightSpeedExternalService> externalServices) {
		this.externalServices = externalServices;
	}
}

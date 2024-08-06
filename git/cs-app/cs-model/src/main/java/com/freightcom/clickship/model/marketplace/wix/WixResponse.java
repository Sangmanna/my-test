package com.freightcom.clickship.model.marketplace.wix;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixResponse {
	
	@JsonProperty("id")
	private String id;

	@JsonProperty("site")
	private WixSite site;
	
	@JsonProperty("instance")
	private WixInstance instance;
	
	@JsonProperty("properties")
	private WixSiteProperties properties;
	
	@JsonProperty("product")
	private WixProduct product;

	@JsonProperty("variants")
	List<WixVariants> variants;

	@JsonProperty("products")
	private List<WixProduct> products;

	@JsonProperty("order")
	private WixOrder order;

	@JsonProperty("orders")
	private List<WixOrder> orders;

	@JsonProperty("metadata")
	private WixMetadata metadata;

	@JsonProperty("totalResults")
	private Integer totalResults;

	public String getId() {
		return id;
	}

	public WixResponse setId(String id) {
		this.id = id;
		return this;
	}

	public WixSite getSite() {
		return site;
	}

	public WixResponse setSite(WixSite site) {
		this.site = site;
		return this;
	}

	public WixInstance getInstance() {
		return instance;
	}

	public WixResponse setInstance(WixInstance instance) {
		this.instance = instance;
		return this;
	}

	public WixSiteProperties getProperties() {
		return properties;
	}

	public WixResponse setProperties(WixSiteProperties properties) {
		this.properties = properties;
		return this;
	}

	public WixProduct getProduct() {
		return product;
	}

	public WixResponse setProduct(WixProduct product) {
		this.product = product;
		return this;
	}

	public List<WixVariants> getVariants() {
		return variants;
	}

	public WixResponse setVariants(List<WixVariants> variants) {
		this.variants = variants;
		return this;
	}

	public List<WixProduct> getProducts() {
		return products;
	}

	public WixResponse setProducts(List<WixProduct> products) {
		this.products = products;
		return this;
	}

	public WixOrder getOrder() {
		return order;
	}

	public WixResponse setOrder(WixOrder order) {
		this.order = order;
		return this;
	}

	public List<WixOrder> getOrders() {
		return orders;
	}

	public WixResponse setOrders(List<WixOrder> orders) {
		this.orders = orders;
		return this;
	}

	public WixMetadata getMetadata() {
		return metadata;
	}

	public WixResponse setMetadata(WixMetadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public WixResponse setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
		return this;
	}

}

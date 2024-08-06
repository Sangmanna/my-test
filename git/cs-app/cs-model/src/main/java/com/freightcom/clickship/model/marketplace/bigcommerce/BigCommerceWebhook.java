package com.freightcom.clickship.model.marketplace.bigcommerce;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceWebhook {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("hash")
	private String hash;
	
	@JsonProperty("store_id")
	private String storeId;
	
	@JsonProperty("producer")
	private String producer;
	
	@JsonProperty("client_id")
	private String clientId;

	@JsonProperty("store_hash")
	private String storeHash;

	@JsonProperty("scope")
	private String scope;

	@JsonProperty("destination")
	private String destination;

	@JsonProperty("is_active")
	private boolean isActive;

	@JsonProperty("created_at")
	private int createdAt;

	@JsonProperty("updated_at")
	private int updatedAt;
	
	@JsonProperty("headers")
	private Map<String, String> headers = new HashMap<>();
	
	@JsonProperty("data")
	private BigCommerceWebhookData data;

	public int getId() {
		return id;
	}

	public BigCommerceWebhook setId(int id) {
		this.id = id;
		return this;
	}

	public String getHash() {
		return hash;
	}

	public BigCommerceWebhook setHash(String hash) {
		this.hash = hash;
		return this;
	}

	public String getStoreId() {
		return storeId;
	}

	public BigCommerceWebhook setStoreId(String storeId) {
		this.storeId = storeId;
		return this;
	}

	public String getProducer() {
		return producer;
	}

	public BigCommerceWebhook setProducer(String producer) {
		this.producer = producer;
		return this;
	}

	public String getClientId() {
		return clientId;
	}

	public BigCommerceWebhook setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}

	public String getStoreHash() {
		return storeHash;
	}

	public BigCommerceWebhook setStoreHash(String storeHash) {
		this.storeHash = storeHash;
		return this;
	}

	public String getScope() {
		return scope;
	}

	public BigCommerceWebhook setScope(String scope) {
		this.scope = scope;
		return this;
	}

	public String getDestination() {
		return destination;
	}

	public BigCommerceWebhook setDestination(String destination) {
		this.destination = destination;
		return this;
	}

	public boolean isActive() {
		return isActive;
	}

	public BigCommerceWebhook setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public int getCreatedAt() {
		return createdAt;
	}

	public BigCommerceWebhook setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public int getUpdatedAt() {
		return updatedAt;
	}

	public BigCommerceWebhook setUpdatedAt(int updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public BigCommerceWebhook setHeaders(Map<String, String> headers) {
		this.headers = headers;
		return this;
	}
	
	public BigCommerceWebhookData getData() {
		return data;
	}

	public BigCommerceWebhook setData(BigCommerceWebhookData data) {
		this.data = data;
		return this;
	}

	@JsonIgnore
	public BigCommerceWebhook addHeader(String key, String value) {
		headers.put(key, value);
		return this;
	}
	
}
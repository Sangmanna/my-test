package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyCarrierService implements Serializable {

	private static final long serialVersionUID = -2080696048886381415L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("active")
	private boolean active;
	
	@JsonProperty("service_discovery")
	private boolean serviceDiscovery = true;
	
	@JsonProperty("carrier_service_type")
	private String serviceType;
	
	@JsonProperty("format")
	private String format = "json";
	
	@JsonProperty("callback_url")
	private String callbackUrl;
	
	public ShopifyCarrierService() {
		super();
	}

	public ShopifyCarrierService(String callbackUrl) {
		super();
		this.active = true;
		this.name = "Clickship Rates";
		this.callbackUrl = callbackUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isServiceDiscovery() {
		return serviceDiscovery;
	}

	public void setServiceDiscovery(boolean serviceDiscovery) {
		this.serviceDiscovery = serviceDiscovery;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	
}

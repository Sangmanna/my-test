package com.freightcom.clickship.model.marketplace.bigcommerce;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceShippingMethod implements Serializable {
	
	private static final long serialVersionUID = -7090163573637197982L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("enabled")
	private Boolean enabled;
	
	@JsonProperty("is_fallback")
	private Boolean isFallback;
	
	@JsonProperty("settings")
	private BigCommerceShippingMethodSetting setting;
	
	public BigCommerceShippingMethod() {
		super();
	}

	public BigCommerceShippingMethod(String type) {
		super();
		this.name = "ClickShip";
		this.type = type;
		this.setting = new BigCommerceShippingMethodSetting(new BigCommerceCarrierOptions("1"));
	}

	public Long getId() {
		return id;
	}

	public BigCommerceShippingMethod setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public BigCommerceShippingMethod setName(String name) {
		this.name = name;
		return this;
	}

	public String getType() {
		return type;
	}

	public BigCommerceShippingMethod setType(String type) {
		this.type = type;
		return this;
	}

	public BigCommerceShippingMethodSetting getSetting() {
		return setting;
	}

	public BigCommerceShippingMethod setSetting(BigCommerceShippingMethodSetting setting) {
		this.setting = setting;
		return this;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public BigCommerceShippingMethod setEnabled(Boolean enabled) {
		this.enabled = enabled;
		return this;
	}

	public Boolean getIsFallback() {
		return isFallback;
	}

	public BigCommerceShippingMethod setIsFallback(Boolean isFallback) {
		this.isFallback = isFallback;
		return this;
	}
	
}

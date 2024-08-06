package com.freightcom.clickship.model.marketplace.bigcommerce;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceShippingZone implements Serializable {
	
	private static final long serialVersionUID = -7090163573637197982L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("locations")
	private List<BigCommerceShippingAddress> locations;
	
	@JsonProperty("enabled")
	private Boolean enabled;

	public Long getId() {
		return id;
	}

	public BigCommerceShippingZone setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public BigCommerceShippingZone setName(String name) {
		this.name = name;
		return this;
	}

	public String getType() {
		return type;
	}

	public BigCommerceShippingZone setType(String type) {
		this.type = type;
		return this;
	}

	public List<BigCommerceShippingAddress> getLocations() {
		return locations;
	}

	public BigCommerceShippingZone setLocations(List<BigCommerceShippingAddress> locations) {
		this.locations = locations;
		return this;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public BigCommerceShippingZone setEnabled(Boolean enabled) {
		this.enabled = enabled;
		return this;
	}
	
}

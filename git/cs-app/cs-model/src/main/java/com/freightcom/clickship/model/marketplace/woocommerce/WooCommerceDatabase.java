package com.freightcom.clickship.model.marketplace.woocommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceDatabase {

	@JsonProperty("database_prefix")
	private String prefix;
	
	@JsonProperty("wc_database_version")
	private String version;

	public String getPrefix() {
		return prefix;
	}

	public WooCommerceDatabase setPrefix(String prefix) {
		this.prefix = prefix;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public WooCommerceDatabase setVersion(String version) {
		this.version = version;
		return this;
	}
	
}

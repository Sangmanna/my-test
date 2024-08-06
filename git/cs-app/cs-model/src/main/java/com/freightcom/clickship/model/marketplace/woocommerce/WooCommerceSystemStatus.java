package com.freightcom.clickship.model.marketplace.woocommerce;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceSystemStatus implements Serializable {

	private static final long serialVersionUID = -1341048041161816912L;
	
	@JsonProperty("environment")
	private WooCommerceEnvironment environment;
	
	@JsonProperty("database")
	private WooCommerceDatabase database;
	
	@JsonProperty("active_plugins")
	private List<WooCommercePlugins> plugins;

	public WooCommerceEnvironment getEnvironment() {
		return environment;
	}

	public WooCommerceSystemStatus setEnvironment(WooCommerceEnvironment environment) {
		this.environment = environment;
		return this;
	}

	public WooCommerceDatabase getDatabase() {
		return database;
	}

	public WooCommerceSystemStatus setDatabase(WooCommerceDatabase database) {
		this.database = database;
		return this;
	}

	public List<WooCommercePlugins> getPlugins() {
		return plugins;
	}

	public WooCommerceSystemStatus setPlugins(List<WooCommercePlugins> plugins) {
		this.plugins = plugins;
		return this;
	}
	
}


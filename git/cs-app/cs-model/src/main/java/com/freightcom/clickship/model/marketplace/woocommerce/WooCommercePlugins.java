package com.freightcom.clickship.model.marketplace.woocommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommercePlugins {
	
	@JsonProperty("plugin")
	private String plugin;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("version")
	private String version;
	
	@JsonProperty("url")
	private String url;

	@JsonProperty("author_name")
	private String authorName;
	
	@JsonProperty("author_url")
	private String authorUrl;

	public String getPlugin() {
		return plugin;
	}

	public WooCommercePlugins setPlugin(String plugin) {
		this.plugin = plugin;
		return this;
	}

	public String getName() {
		return name;
	}

	public WooCommercePlugins setName(String name) {
		this.name = name;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public WooCommercePlugins setVersion(String version) {
		this.version = version;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public WooCommercePlugins setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getAuthorName() {
		return authorName;
	}

	public WooCommercePlugins setAuthorName(String authorName) {
		this.authorName = authorName;
		return this;
	}

	public String getAuthorUrl() {
		return authorUrl;
	}

	public WooCommercePlugins setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
		return this;
	}
}

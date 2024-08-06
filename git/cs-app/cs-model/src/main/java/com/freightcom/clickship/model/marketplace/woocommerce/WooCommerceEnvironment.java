package com.freightcom.clickship.model.marketplace.woocommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceEnvironment {

	@JsonProperty("home_url")
	private String homeUrl;
	
	@JsonProperty("site_url")
	private String storeUrl;
	
	@JsonProperty("version")
	private String version;
	
	@JsonProperty("wp_version")
	private String wpVersion;
	
	@JsonProperty("mysql_version")
	private String mysqlVersion;
	
	@JsonProperty("language")
	private String language;

	public String getHomeUrl() {
		return homeUrl;
	}

	public WooCommerceEnvironment setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
		return this;
	}

	public String getStoreUrl() {
		return storeUrl;
	}

	public WooCommerceEnvironment setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public WooCommerceEnvironment setVersion(String version) {
		this.version = version;
		return this;
	}

	public String getWpVersion() {
		return wpVersion;
	}

	public WooCommerceEnvironment setWpVersion(String wpVersion) {
		this.wpVersion = wpVersion;
		return this;
	}

	public String getMysqlVersion() {
		return mysqlVersion;
	}

	public WooCommerceEnvironment setMysqlVersion(String mysqlVersion) {
		this.mysqlVersion = mysqlVersion;
		return this;
	}

	public String getLanguage() {
		return language;
	}

	public WooCommerceEnvironment setLanguage(String language) {
		this.language = language;
		return this;
	}
	
}

package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoStoreConfig implements Serializable {

	private static final long serialVersionUID = 3037670150472587358L;
	
	private String id;
	
	private String code;
	
	private String locale;

	private String timezone;
	
	@JsonProperty("weight_unit")
	private String weightUnit;
	
	@JsonProperty("base_currency_code")
	private String currencyCode;

	public String getId() {
		return id;
	}

	public MagentoStoreConfig setId(String id) {
		this.id = id;
		return this;
	}

	public String getCode() {
		return code;
	}

	public MagentoStoreConfig setCode(String code) {
		this.code = code;
		return this;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public MagentoStoreConfig setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}

	public String getLocale() {
		return locale;
	}

	public MagentoStoreConfig setLocale(String locale) {
		this.locale = locale;
		return this;
	}

	public String getTimezone() {
		return timezone;
	}

	public MagentoStoreConfig setTimezone(String timezone) {
		this.timezone = timezone;
		return this;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public MagentoStoreConfig setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
		return this;
	}
	
}

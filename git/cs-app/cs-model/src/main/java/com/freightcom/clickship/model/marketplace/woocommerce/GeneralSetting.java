package com.freightcom.clickship.model.marketplace.woocommerce;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneralSetting {
	
	private Object value;
	
	@JsonProperty("default")
	private String defaultValue;
	
	@JsonProperty("id")
	private GeneralSettingsLabel label;
	
	private Map<String, String> options;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public GeneralSettingsLabel getLabel() {
		return label;
	}

	public void setLabel(GeneralSettingsLabel label) {
		this.label = label;
	}

	public Map<String, String> getOptions() {
		return options;
	}

	public void setOptions(Map<String, String> options) {
		this.options = options;
	}
}

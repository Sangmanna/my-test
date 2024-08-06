package com.freightcom.clickship.model.marketplace.woocommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductSetting {
	
	private Object value;
	
	@JsonProperty("id")
	private ProductSettingLabel label;
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ProductSettingLabel getLabel() {
		return label;
	}

	public void setLabel(ProductSettingLabel id) {
		this.label = id;
	}

}

package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoProductAttributes implements Serializable {

	private static final long serialVersionUID = -7139802858657553717L;

	@JsonProperty("attribute_code")
	private String code;
	
	private Object value;

	public String getCode() {
		return code;
	}

	public MagentoProductAttributes setCode(String code) {
		this.code = code;
		return this;
	}

	public Object getValue() {
		return value;
	}

	public MagentoProductAttributes setValue(Object value) {
		this.value = value;
		return this;
	}

}

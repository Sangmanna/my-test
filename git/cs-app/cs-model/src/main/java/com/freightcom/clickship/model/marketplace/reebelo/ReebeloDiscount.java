package com.freightcom.clickship.model.marketplace.reebelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReebeloDiscount implements Serializable {

	private static final long serialVersionUID = -5958736132942999337L;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("value")
	private double value;
	
	@JsonProperty("value_type")
	private String valueType;
	
	@JsonProperty("target_type")
	private String targetType;
	
	@JsonProperty("target_selection")
	private String targetSelection;
	
	@JsonProperty("allocation_method")
	private String allocationMethod;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public String getTargetSelection() {
		return targetSelection;
	}

	public void setTargetSelection(String targetSelection) {
		this.targetSelection = targetSelection;
	}

	public String getAllocationMethod() {
		return allocationMethod;
	}

	public void setAllocationMethod(String allocationMethod) {
		this.allocationMethod = allocationMethod;
	}

}

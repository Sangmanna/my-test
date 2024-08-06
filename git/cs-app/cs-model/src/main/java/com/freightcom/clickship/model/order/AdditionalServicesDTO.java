package com.freightcom.clickship.model.order;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class AdditionalServicesDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -3016340344256233545L;
	
	private String displayName;
	private String fieldName;
	private String value;


	public String getFieldName() {
		return fieldName;
	}

	public AdditionalServicesDTO setFieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}

	public String getValue() {
		return value;
	}

	public AdditionalServicesDTO setValue(String value) {
		this.value = value;
		return this;
	}

	public String getDisplayName() {
		return displayName;
	}

	public AdditionalServicesDTO setDisplayName(String displayName) {
		this.displayName = displayName;
		return this;
	}

}

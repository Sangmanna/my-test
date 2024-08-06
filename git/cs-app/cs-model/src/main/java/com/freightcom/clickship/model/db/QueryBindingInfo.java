package com.freightcom.clickship.model.db;

import com.freightcom.clickship.model.enums.QUERY_BINDING_TYPE;

import lombok.ToString;

@ToString
public class QueryBindingInfo {
	
	private Object value;
	
	private QUERY_BINDING_TYPE queryBindingType = QUERY_BINDING_TYPE.EQUAL;
	
	public QueryBindingInfo(Object value) {
		this.value = value;
	}
	
	public QueryBindingInfo(Object value, QUERY_BINDING_TYPE queryBindingType) {
		super();
		this.value = value;
		this.queryBindingType = queryBindingType;
	}

	public boolean isEqualBinding() {
		return QUERY_BINDING_TYPE.EQUAL.equals(queryBindingType);
	}

	public Object getValue() {
		return value;
	}

	public QueryBindingInfo setValue(Object value) {
		this.value = value;
		return this;
	}

	public QUERY_BINDING_TYPE getQueryBindingType() {
		return queryBindingType;
	}

	public QueryBindingInfo setQueryBindingType(QUERY_BINDING_TYPE queryBindingType) {
		this.queryBindingType = queryBindingType;
		return this;
	}
	
}

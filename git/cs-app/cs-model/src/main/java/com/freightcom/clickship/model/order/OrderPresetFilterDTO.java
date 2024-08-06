package com.freightcom.clickship.model.order;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class OrderPresetFilterDTO implements Serializable {
	
	private static final long serialVersionUID = -5968924418620196373L;

	private String customerId;
	
	private Map<String, String> filter = new HashMap<>();
	
	private transient Map<String, Object> condition = new HashMap<>();

	public Map<String, String> getFilter() {
		return filter;
	}

	public OrderPresetFilterDTO setFilter(Map<String, String> filter) {
		this.filter = filter;
		return this;
	}
	
	public void setFilter(String key, String value) {
		this.filter.put(key, value);
	}
	
	public Map<String, Object> getCondition() {
		return condition;
	}

	public OrderPresetFilterDTO setCondition(Map<String, Object> condition) {
		this.condition = condition;
		return this;
	}
	
	public void setCondition(String key, Object value) {
		this.condition.put(key, value);
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}

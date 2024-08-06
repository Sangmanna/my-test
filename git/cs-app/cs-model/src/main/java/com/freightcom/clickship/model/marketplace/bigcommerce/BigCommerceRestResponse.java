package com.freightcom.clickship.model.marketplace.bigcommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceRestResponse<T> {
	
	private T data;
	
	@JsonProperty("meta")
	private BigCommerceMeta meta;
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BigCommerceMeta getMeta() {
		return meta;
	}

	public void setMeta(BigCommerceMeta meta) {
		this.meta = meta;
	}
	
}

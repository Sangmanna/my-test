package com.freightcom.clickship.model.marketplace.etsy.v3;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtsyResponse<T extends EtsyBaseDTO> implements Serializable {

	private static final long serialVersionUID = 4647179106393328236L;

	private Integer count;

	private T results;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public T getResults() {
		return results;
	}

	public void setResults(T results) {
		this.results = results;
	}

}
package com.freightcom.clickship.model.marketplace.etsy;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> implements Serializable {

	private static final long serialVersionUID = 4647179106393328236L;

	@JsonIgnoreProperties(ignoreUnknown = true)
	private Integer count;

	private T results;

	@JsonProperty("pagination")
	private Pagination pagination;

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

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}
package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixQueryParams {

	@JsonProperty("sort")
	private String sort;
	
	@JsonProperty("paging")
	private WixPaging paging;

	@JsonProperty("filter")
	private String filter;

	public WixPaging getPaging() {
		return paging;
	}

	public WixQueryParams setPaging(WixPaging paging) {
		this.paging = paging;
		return this;
	}

	public String getSort() {
		return sort;
	}

	public WixQueryParams setSort(String sort) {
		this.sort = sort;
		return this;
	}

	public String getFilter() {
		return filter;
	}

	public WixQueryParams setFilter(String filter) {
		this.filter = filter;
		return this;
	}

}

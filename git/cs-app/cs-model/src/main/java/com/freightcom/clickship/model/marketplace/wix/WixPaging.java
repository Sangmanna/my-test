package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixPaging {

	@JsonProperty("limit")
	private Integer limit;

	@JsonProperty("offset")
	private Integer offset;

	public Integer getLimit() {
		return limit;
	}

	public WixPaging setLimit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public Integer getOffset() {
		return offset;
	}

	public WixPaging setOffset(Integer offset) {
		this.offset = offset;
		return this;
	}

}

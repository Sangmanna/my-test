package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixOrderQuery {

	@JsonProperty("query")
	private WixQueryParams query;

	public WixQueryParams getQuery() {
		return query;
	}

	public WixOrderQuery setQuery(WixQueryParams query) {
		this.query = query;
		return this;
	}

}

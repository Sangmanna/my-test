package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixProductQuery {

	@JsonProperty("query")
	private WixQueryParams query;
	
	@JsonProperty("includeVariants")
	private boolean includeVariants = true;

	public WixQueryParams getQuery() {
		return query;
	}

	public WixProductQuery setQuery(WixQueryParams query) {
		this.query = query;
		return this;
	}

	public boolean isIncludeVariants() {
		return includeVariants;
	}

	public void setIncludeVariants(boolean includeVariants) {
		this.includeVariants = includeVariants;
	}

}

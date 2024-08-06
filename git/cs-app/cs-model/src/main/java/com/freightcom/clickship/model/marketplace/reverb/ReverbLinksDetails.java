package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReverbLinksDetails {
	@JsonProperty("href")
	private String href;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
}

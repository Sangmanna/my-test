package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixHint {

	@JsonProperty("text")
	private String text;
	
	@JsonProperty("placement")
	private String placement;

	public String getText() {
		return text;
	}

	public WixHint setText(String text) {
		this.text = text;
		return this;
	}

	public String getPlacement() {
		return placement;
	}

	public WixHint setPlacement(String placement) {
		this.placement = placement;
		return this;
	}
	
}

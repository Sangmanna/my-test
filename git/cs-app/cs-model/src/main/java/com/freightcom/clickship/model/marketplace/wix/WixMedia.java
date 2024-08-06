package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixMedia {

	@JsonProperty("mainMedia")
	private WixMainMedia mainMedia;

	public WixMainMedia getMainMedia() {
		return mainMedia;
	}

	public WixMedia setMainMedia(WixMainMedia mainMedia) {
		this.mainMedia = mainMedia;
		return this;
	}

}

package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReverbLinks {
	@JsonProperty("self")
	private ReverbSelf self;

	public ReverbSelf getSelf() {
		return self;
	}

	public void setSelf(ReverbSelf self) {
		this.self = self;
	}
	
}

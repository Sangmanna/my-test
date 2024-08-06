package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class ReverbProductStats {
	@JsonProperty("views")
	private boolean views;
	@JsonProperty("watches")
	private boolean watches;
	public boolean isViews() {
		return views;
	}
	public void setViews(boolean views) {
		this.views = views;
	}
	public boolean isWatches() {
		return watches;
	}
	public void setWatches(boolean watches) {
		this.watches = watches;
	}
	
}

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
public class ReverbProductShipping {
	@JsonProperty("local")
	private boolean local;
	@JsonProperty("slug")
	private boolean us;
	@JsonProperty("us_rate")
	private String usRate;
	public boolean isLocal() {
		return local;
	}
	public void setLocal(boolean local) {
		this.local = local;
	}
	public boolean isUs() {
		return us;
	}
	public void setUs(boolean us) {
		this.us = us;
	}
	public String getUsRate() {
		return usRate;
	}
	public void setUsRate(String usRate) {
		this.usRate = usRate;
	}
	
}

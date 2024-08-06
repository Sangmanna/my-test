package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReverbReturnsPolicy {
	@JsonProperty("days")
	private String days;
	@JsonProperty("description")
	private String description;
	@JsonProperty("restocking_fee")
	private ReverbRestocking restockingFee;
}

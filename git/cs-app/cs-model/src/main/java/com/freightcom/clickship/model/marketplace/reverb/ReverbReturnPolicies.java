package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReverbReturnPolicies {

	@JsonProperty("summary_description")
	private String summaryDescription;
	
	@JsonProperty("special_conditions")
	private String specialConditions;
	
	@JsonProperty("used")
	private ReverbReturnsPolicy usedItem;
	
	@JsonProperty("new")
	private ReverbReturnsPolicy newItem;
	
}

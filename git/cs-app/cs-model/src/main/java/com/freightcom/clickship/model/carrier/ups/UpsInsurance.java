package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsInsurance implements Serializable {
	
	private static final long serialVersionUID = 6117068665622941184L;
	
	@JsonProperty("BasicFlexibleParcelIndicator")
	private UpsMoney basicFlexibleParcelIndicator;
	
	@JsonProperty("ExtendedFlexibleParcelIndicator")
	private UpsMoney extendedFlexibleParcelIndicator;
	
	@JsonProperty("TimeInTransitFlexibleParcelIndicator")
	private UpsMoney timeInTransitFlexibleParcelIndicator;

	public UpsMoney getBasicFlexibleParcelIndicator() {
		return basicFlexibleParcelIndicator;
	}

	public void setBasicFlexibleParcelIndicator(UpsMoney basicFlexibleParcelIndicator) {
		this.basicFlexibleParcelIndicator = basicFlexibleParcelIndicator;
	}

	public UpsMoney getExtendedFlexibleParcelIndicator() {
		return extendedFlexibleParcelIndicator;
	}

	public void setExtendedFlexibleParcelIndicator(UpsMoney extendedFlexibleParcelIndicator) {
		this.extendedFlexibleParcelIndicator = extendedFlexibleParcelIndicator;
	}

	public UpsMoney getTimeInTransitFlexibleParcelIndicator() {
		return timeInTransitFlexibleParcelIndicator;
	}

	public void setTimeInTransitFlexibleParcelIndicator(UpsMoney timeInTransitFlexibleParcelIndicator) {
		this.timeInTransitFlexibleParcelIndicator = timeInTransitFlexibleParcelIndicator;
	}
	
}

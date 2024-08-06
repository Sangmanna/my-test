package com.freightcom.clickship.model.marketplace.woocommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceStoreMeasurements {
	
	private String weigthUnit;
	
	private String dimensionsUnit;

	public String getWeigthUnit() {
		return weigthUnit;
	}

	public void setWeigthUnit(String weigthUnit) {
		this.weigthUnit = weigthUnit;
	}

	public String getDimensionsUnit() {
		return dimensionsUnit;
	}

	public void setDimensionsUnit(String dimensionsUnit) {
		this.dimensionsUnit = dimensionsUnit;
	}
	
}

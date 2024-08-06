package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixPricePerUnitData {

	@JsonProperty("totalQuantity")
	private Integer totalQuantity;

	@JsonProperty("totalMeasurementUnit")
	private String totalMeasurementUnit;

	@JsonProperty("baseQuantity")
	private Integer baseQuantity;

	@JsonProperty("baseMeasurementUnit")
	private String baseMeasurementUnit;

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public WixPricePerUnitData setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
		return this;
	}

	public String getTotalMeasurementUnit() {
		return totalMeasurementUnit;
	}

	public WixPricePerUnitData setTotalMeasurementUnit(String totalMeasurementUnit) {
		this.totalMeasurementUnit = totalMeasurementUnit;
		return this;
	}

	public Integer getBaseQuantity() {
		return baseQuantity;
	}

	public WixPricePerUnitData setBaseQuantity(Integer baseQuantity) {
		this.baseQuantity = baseQuantity;
		return this;
	}

	public String getBaseMeasurementUnit() {
		return baseMeasurementUnit;
	}

	public WixPricePerUnitData setBaseMeasurementUnit(String baseMeasurementUnit) {
		this.baseMeasurementUnit = baseMeasurementUnit;
		return this;
	}
}

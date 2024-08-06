package com.freightcom.clickship.model.shippingrules;

import javax.validation.constraints.NotNull;

import com.freightcom.clickship.model.box.BoxDTO;

public class ShippingRuleBoxDTO {
	
	private String id;
	private BoxDTO boxDTO;
	@NotNull
    @EnumValidate(value = ShippingRuleBoxWeightType.class, enumMethod = "getType")
	private String weightType;
	private String weightUnits;
	private double weightImperial;
	private double weightMetric;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BoxDTO getBoxDTO() {
		return boxDTO;
	}
	public void setBoxDTO(BoxDTO boxDTO) {
		this.boxDTO = boxDTO;
	}
	public String getWeightType() {
		return weightType;
	}
	public void setWeightType(String weightType) {
		this.weightType = weightType;
	}
	public String getWeightUnits() {
		return weightUnits;
	}
	public void setWeightUnits(String weightUnits) {
		this.weightUnits = weightUnits;
	}
	public double getWeightImperial() {
		return weightImperial;
	}
	public void setWeightImperial(double weightImperial) {
		this.weightImperial = weightImperial;
	}
	public double getWeightMetric() {
		return weightMetric;
	}
	public void setWeightMetric(double weightMetric) {
		this.weightMetric = weightMetric;
	}	
	
}

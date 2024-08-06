package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PackagingPropertiesDTO {
	
	@JsonProperty("measurements")
	private Box measurements = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("special_handling_required")
	private Boolean specialHandlingRequired = null;

	public Box getMeasurements() {
		return measurements;
	}

	public void setMeasurements(Box measurements) {
		this.measurements = measurements;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getSpecialHandlingRequired() {
		return specialHandlingRequired;
	}

	public void setSpecialHandlingRequired(Boolean specialHandlingRequired) {
		this.specialHandlingRequired = specialHandlingRequired;
	}

}

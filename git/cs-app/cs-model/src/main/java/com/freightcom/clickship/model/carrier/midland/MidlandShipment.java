package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MidlandShipment {
	
	@JsonProperty("Pronumber")
	private String proNumber;
	
	private String bolNumber;
	
	private String labelFormat;
	
	private String labelData;

	public String getProNumber() {
		return proNumber;
	}

	public void setProNumber(String proNumber) {
		this.proNumber = proNumber;
	}

	public String getBolNumber() {
		return bolNumber;
	}

	public void setBolNumber(String bolNumber) {
		this.bolNumber = bolNumber;
	}

	public String getLabelFormat() {
		return labelFormat;
	}

	public void setLabelFormat(String labelFormat) {
		this.labelFormat = labelFormat;
	}

	public String getLabelData() {
		return labelData;
	}

	public void setLabelData(String labelData) {
		this.labelData = labelData;
	}

}

package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PalletsDTO {

	@JsonProperty("measurements")
	private Box measurements = null;

	@JsonProperty("description")
	private String description;

	@JsonProperty("freight_class")
	private String freightClass;

	@JsonProperty("nmfc")
	private String nmfc;

	@JsonProperty("contents_type")
	private String contentsType;

	@JsonProperty("num_pieces")
	private int numPieces;

	@JsonProperty("num_pallets")
	private int numPallets;
	
	

	public int getNumPallets() {
		return numPallets;
	}

	public void setNumPallets(int numPallets) {
		this.numPallets = numPallets;
	}

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

	public String getFreightClass() {
		return freightClass;
	}

	public void setFreightClass(String freightClass) {
		this.freightClass = freightClass;
	}

	public String getNmfc() {
		return nmfc;
	}

	public void setNmfc(String nmfc) {
		this.nmfc = nmfc;
	}

	public String getContentsType() {
		return contentsType;
	}

	public void setContentsType(String contentsType) {
		this.contentsType = contentsType;
	}

	public int getNumPieces() {
		return numPieces;
	}

	public void setNumPieces(int numPieces) {
		this.numPieces = numPieces;
	}

}

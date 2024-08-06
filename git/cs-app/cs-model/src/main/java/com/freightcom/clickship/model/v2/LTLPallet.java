package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LTLPallet implements OneOfPackagingPalletPalletsItems {
	@JsonProperty("measurements")
	private Box measurements = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("freight_class")
	private String freightClass = null;

	@JsonProperty("nmfc")
	private String nmfc = null;

	@JsonProperty("contents_type")
	private String contentsType = null;

	@JsonProperty("num_pieces")
	private Integer numPieces = null;

	public LTLPallet measurements(Box measurements) {
		this.measurements = measurements;
		return this;
	}

	public Box getMeasurements() {
		return measurements;
	}

	public void setMeasurements(Box measurements) {
		this.measurements = measurements;
	}

	public LTLPallet description(String description) {
		this.description = description;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LTLPallet freightClass(String freightClass) {
		this.freightClass = freightClass;
		return this;
	}

	public String getFreightClass() {
		return freightClass;
	}

	public void setFreightClass(String freightClass) {
		this.freightClass = freightClass;
	}

	public LTLPallet nmfc(String nmfc) {
		this.nmfc = nmfc;
		return this;
	}

	public String getNmfc() {
		return nmfc;
	}

	public void setNmfc(String nmfc) {
		this.nmfc = nmfc;
	}

	public LTLPallet contentsType(String contentsType) {
		this.contentsType = contentsType;
		return this;
	}

	public String getContentsType() {
		return contentsType;
	}

	public void setContentsType(String contentsType) {
		this.contentsType = contentsType;
	}

	public LTLPallet numPieces(Integer numPieces) {
		this.numPieces = numPieces;
		return this;
	}

	public Integer getNumPieces() {
		return numPieces;
	}

	public void setNumPieces(Integer numPieces) {
		this.numPieces = numPieces;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LTLPallet ltLPallet = (LTLPallet) o;
		return Objects.equals(this.measurements, ltLPallet.measurements)
				&& Objects.equals(this.description, ltLPallet.description)
				&& Objects.equals(this.freightClass, ltLPallet.freightClass)
				&& Objects.equals(this.nmfc, ltLPallet.nmfc)
				&& Objects.equals(this.contentsType, ltLPallet.contentsType)
				&& Objects.equals(this.numPieces, ltLPallet.numPieces);
	}

	@Override
	public int hashCode() {
		return Objects.hash(measurements, description, freightClass, nmfc, contentsType, numPieces);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class LTLPallet {\n");

		sb.append("    measurements: ").append(toIndentedString(measurements)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    freightClass: ").append(toIndentedString(freightClass)).append("\n");
		sb.append("    nmfc: ").append(toIndentedString(nmfc)).append("\n");
		sb.append("    contentsType: ").append(toIndentedString(contentsType)).append("\n");
		sb.append("    numPieces: ").append(toIndentedString(numPieces)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

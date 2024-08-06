package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PackagingPackagePackages {
	@JsonProperty("measurements")
	private Box measurements = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("special_handling_required")
	private Boolean specialHandlingRequired = null;

	public PackagingPackagePackages measurements(Box measurements) {
		this.measurements = measurements;
		return this;
	}

	public Box getMeasurements() {
		return measurements;
	}

	public void setMeasurements(Box measurements) {
		this.measurements = measurements;
	}

	public PackagingPackagePackages description(String description) {
		this.description = description;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PackagingPackagePackages specialHandlingRequired(Boolean specialHandlingRequired) {
		this.specialHandlingRequired = specialHandlingRequired;
		return this;
	}

	public Boolean isSpecialHandlingRequired() {
		return specialHandlingRequired;
	}

	public void setSpecialHandlingRequired(Boolean specialHandlingRequired) {
		this.specialHandlingRequired = specialHandlingRequired;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PackagingPackagePackages packagingPackagePackages = (PackagingPackagePackages) o;
		return Objects.equals(this.measurements, packagingPackagePackages.measurements)
				&& Objects.equals(this.description, packagingPackagePackages.description)
				&& Objects.equals(this.specialHandlingRequired, packagingPackagePackages.specialHandlingRequired);
	}

	@Override
	public int hashCode() {
		return Objects.hash(measurements, description, specialHandlingRequired);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PackagingPackagePackages {\n");

		sb.append("    measurements: ").append(toIndentedString(measurements)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    specialHandlingRequired: ").append(toIndentedString(specialHandlingRequired)).append("\n");
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

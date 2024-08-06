package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PackagingCourierPakCourierPaks {
	@JsonProperty("weight")
	private Weight weight = null;

	@JsonProperty("description")
	private String description = null;

	public PackagingCourierPakCourierPaks weight(Weight weight) {
		this.weight = weight;
		return this;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public PackagingCourierPakCourierPaks description(String description) {
		this.description = description;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PackagingCourierPakCourierPaks packagingCourierPakCourierPaks = (PackagingCourierPakCourierPaks) o;
		return Objects.equals(this.weight, packagingCourierPakCourierPaks.weight)
				&& Objects.equals(this.description, packagingCourierPakCourierPaks.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(weight, description);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PackagingCourierPakCourierPaks {\n");

		sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

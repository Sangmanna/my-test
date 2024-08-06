package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Box {
	@JsonProperty("weight")
	private Weight weight = null;

	@JsonProperty("cuboid")
	private Cuboid cuboid = null;

	public Box weight(Weight weight) {
		this.weight = weight;
		return this;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public Box cuboid(Cuboid cuboid) {
		this.cuboid = cuboid;
		return this;
	}

	public Cuboid getCuboid() {
		return cuboid;
	}

	public void setCuboid(Cuboid cuboid) {
		this.cuboid = cuboid;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Box box = (Box) o;
		return Objects.equals(this.weight, box.weight) && Objects.equals(this.cuboid, box.cuboid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(weight, cuboid);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Box {\n");

		sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
		sb.append("    cuboid: ").append(toIndentedString(cuboid)).append("\n");
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

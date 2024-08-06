package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class ShippingDetailsInsurance {
	/**
	 * Gets or Sets type
	 */
	public enum TypeEnum {
		INTERNAL("internal"),

		CARRIER("carrier");

		private String value;

		TypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static TypeEnum fromValue(String text) {
			for (TypeEnum b : TypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("type")
	private TypeEnum type = null;

	@JsonProperty("total_cost")
	private Money totalCost = null;

	public ShippingDetailsInsurance type(TypeEnum type) {
		this.type = type;
		return this;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public ShippingDetailsInsurance totalCost(Money totalCost) {
		this.totalCost = totalCost;
		return this;
	}

	public Money getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Money totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ShippingDetailsInsurance shippingDetailsInsurance = (ShippingDetailsInsurance) o;
		return Objects.equals(this.type, shippingDetailsInsurance.type)
				&& Objects.equals(this.totalCost, shippingDetailsInsurance.totalCost);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, totalCost);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ShippingDetailsInsurance {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    totalCost: ").append(toIndentedString(totalCost)).append("\n");
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

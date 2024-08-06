package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * RateSurcharges
 */

public class RateSurcharges {
	@JsonProperty("type")
	private String type = null;

	@JsonProperty("amount")
	private Money amount = null;

	public RateSurcharges type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * The surcharge type.
	 * 
	 * @return type
	 **/

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public RateSurcharges amount(Money amount) {
		this.amount = amount;
		return this;
	}

	/**
	 * Get amount
	 * 
	 * @return amount
	 **/

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RateSurcharges rateSurcharges = (RateSurcharges) o;
		return Objects.equals(this.type, rateSurcharges.type) && Objects.equals(this.amount, rateSurcharges.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, amount);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RateSurcharges {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

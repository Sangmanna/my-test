package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Money {
	@JsonProperty("currency")
	private String currency = null;

	@JsonProperty("value")
	private String value = null;

	public Money currency(String currency) {
		this.currency = currency;
		return this;
	}

	/**
	 * ISO 4217 alpha code of the currency such as: CAD, USD, EUR, INR, etc.
	 * 
	 * @return currency
	 **/

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Money value(String value) {
		this.value = value;
		return this;
	}

	/**
	 * Value in the lowest common indivisible unit of the currency. 42.50 CAD would
	 * be represented as 4250.
	 * 
	 * @return value
	 **/

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Money money = (Money) o;
		return Objects.equals(this.currency, money.currency) && Objects.equals(this.value, money.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(currency, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Money {\n");

		sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

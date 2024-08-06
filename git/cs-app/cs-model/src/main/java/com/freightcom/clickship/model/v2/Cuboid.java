package com.freightcom.clickship.model.v2;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Cuboid {
	/**
	 * Unit that the dimension is in.
	 */
	public enum UnitEnum {
		MM("mm"),

		CM("cm"),

		M("m"),

		IN("in"),

		FT("ft");

		private String value;

		UnitEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static UnitEnum fromValue(String text) {
			for (UnitEnum b : UnitEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("unit")
	private UnitEnum unit = null;

	@JsonProperty("l")
	private BigDecimal l = null;

	@JsonProperty("w")
	private BigDecimal w = null;

	@JsonProperty("h")
	private BigDecimal h = null;

	public Cuboid unit(UnitEnum unit) {
		this.unit = unit;
		return this;
	}

	public UnitEnum getUnit() {
		return unit;
	}

	public void setUnit(UnitEnum unit) {
		this.unit = unit;
	}

	public Cuboid l(BigDecimal l) {
		this.l = l;
		return this;
	}

	public BigDecimal getL() {
		return l;
	}

	public void setL(BigDecimal l) {
		this.l = l;
	}

	public Cuboid w(BigDecimal w) {
		this.w = w;
		return this;
	}

	public BigDecimal getW() {
		return w;
	}

	public void setW(BigDecimal w) {
		this.w = w;
	}

	public Cuboid h(BigDecimal h) {
		this.h = h;
		return this;
	}

	public BigDecimal getH() {
		return h;
	}

	public void setH(BigDecimal h) {
		this.h = h;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Cuboid cuboid = (Cuboid) o;
		return Objects.equals(this.unit, cuboid.unit) && Objects.equals(this.l, cuboid.l)
				&& Objects.equals(this.w, cuboid.w) && Objects.equals(this.h, cuboid.h);
	}

	@Override
	public int hashCode() {
		return Objects.hash(unit, l, w, h);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Cuboid {\n");

		sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
		sb.append("    l: ").append(toIndentedString(l)).append("\n");
		sb.append("    w: ").append(toIndentedString(w)).append("\n");
		sb.append("    h: ").append(toIndentedString(h)).append("\n");
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

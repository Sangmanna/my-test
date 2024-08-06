package com.freightcom.clickship.model.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PackagingCourierPak implements OneOfShippingDetailsPackagingProperties {
	@JsonProperty("includes_return_label")
	private Boolean includesReturnLabel = null;

	@JsonProperty("has_dangerous_goods")
	private Boolean hasDangerousGoods = null;

	@JsonProperty("courier_paks")
	private List<PackagingCourierPakCourierPaks> courierPaks = new ArrayList<PackagingCourierPakCourierPaks>();

	public PackagingCourierPak includesReturnLabel(Boolean includesReturnLabel) {
		this.includesReturnLabel = includesReturnLabel;
		return this;
	}

	public Boolean isIncludesReturnLabel() {
		return includesReturnLabel;
	}

	public void setIncludesReturnLabel(Boolean includesReturnLabel) {
		this.includesReturnLabel = includesReturnLabel;
	}

	public PackagingCourierPak hasDangerousGoods(Boolean hasDangerousGoods) {
		this.hasDangerousGoods = hasDangerousGoods;
		return this;
	}

	public Boolean isHasDangerousGoods() {
		return hasDangerousGoods;
	}

	public void setHasDangerousGoods(Boolean hasDangerousGoods) {
		this.hasDangerousGoods = hasDangerousGoods;
	}

	public PackagingCourierPak courierPaks(List<PackagingCourierPakCourierPaks> courierPaks) {
		this.courierPaks = courierPaks;
		return this;
	}

	public PackagingCourierPak addCourierPaksItem(PackagingCourierPakCourierPaks courierPaksItem) {
		this.courierPaks.add(courierPaksItem);
		return this;
	}

	public List<PackagingCourierPakCourierPaks> getCourierPaks() {
		return courierPaks;
	}

	public void setCourierPaks(List<PackagingCourierPakCourierPaks> courierPaks) {
		this.courierPaks = courierPaks;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PackagingCourierPak packagingCourierPak = (PackagingCourierPak) o;
		return Objects.equals(this.includesReturnLabel, packagingCourierPak.includesReturnLabel)
				&& Objects.equals(this.hasDangerousGoods, packagingCourierPak.hasDangerousGoods)
				&& Objects.equals(this.courierPaks, packagingCourierPak.courierPaks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(includesReturnLabel, hasDangerousGoods, courierPaks);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PackagingCourierPak {\n");

		sb.append("    includesReturnLabel: ").append(toIndentedString(includesReturnLabel)).append("\n");
		sb.append("    hasDangerousGoods: ").append(toIndentedString(hasDangerousGoods)).append("\n");
		sb.append("    courierPaks: ").append(toIndentedString(courierPaks)).append("\n");
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

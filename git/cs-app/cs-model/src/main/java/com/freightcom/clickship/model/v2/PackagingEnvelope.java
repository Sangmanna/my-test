package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("PackagingEnvelope")
public class PackagingEnvelope implements OneOfShippingDetailsPackagingProperties {
	@JsonProperty("includes_return_label")
	private Boolean includesReturnLabel = null;

	public PackagingEnvelope includesReturnLabel(Boolean includesReturnLabel) {
		this.includesReturnLabel = includesReturnLabel;
		return this;
	}

	public Boolean isIncludesReturnLabel() {
		return includesReturnLabel;
	}

	public void setIncludesReturnLabel(Boolean includesReturnLabel) {
		this.includesReturnLabel = includesReturnLabel;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PackagingEnvelope packagingEnvelope = (PackagingEnvelope) o;
		return Objects.equals(this.includesReturnLabel, packagingEnvelope.includesReturnLabel);
	}

	@Override
	public int hashCode() {
		return Objects.hash(includesReturnLabel);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PackagingEnvelope {\n");

		sb.append("    includesReturnLabel: ").append(toIndentedString(includesReturnLabel)).append("\n");
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

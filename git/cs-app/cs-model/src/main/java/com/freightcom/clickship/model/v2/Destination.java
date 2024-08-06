package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Destination extends Establishment {
	@JsonProperty("ready_at")
	private TimeOfDay readyAt = null;

	@JsonProperty("ready_until")
	private TimeOfDay readyUntil = null;

	/**
	 * Whether a signature is required for delivery.
	 */
	public enum SignatureRequirementEnum {
		NOT_REQUIRED("not-required"),

		REQUIRED("required"),

		ADULT_REQUIRED("adult-required");

		private String value;

		SignatureRequirementEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static SignatureRequirementEnum fromValue(String text) {
			for (SignatureRequirementEnum b : SignatureRequirementEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("signature_requirement")
	private SignatureRequirementEnum signatureRequirement = SignatureRequirementEnum.NOT_REQUIRED;

	public Destination readyAt(TimeOfDay readyAt) {
		this.readyAt = readyAt;
		return this;
	}

	public TimeOfDay getReadyAt() {
		return readyAt;
	}

	public void setReadyAt(TimeOfDay readyAt) {
		this.readyAt = readyAt;
	}

	public Destination readyUntil(TimeOfDay readyUntil) {
		this.readyUntil = readyUntil;
		return this;
	}

	public TimeOfDay getReadyUntil() {
		return readyUntil;
	}

	public void setReadyUntil(TimeOfDay readyUntil) {
		this.readyUntil = readyUntil;
	}

	public Destination signatureRequirement(SignatureRequirementEnum signatureRequirement) {
		this.signatureRequirement = signatureRequirement;
		return this;
	}

	public SignatureRequirementEnum getSignatureRequirement() {
		return signatureRequirement;
	}

	public void setSignatureRequirement(SignatureRequirementEnum signatureRequirement) {
		this.signatureRequirement = signatureRequirement;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Destination destination = (Destination) o;
		return Objects.equals(this.readyAt, destination.readyAt)
				&& Objects.equals(this.readyUntil, destination.readyUntil)
				&& Objects.equals(this.signatureRequirement, destination.signatureRequirement) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(readyAt, readyUntil, signatureRequirement, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Destination {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    readyAt: ").append(toIndentedString(readyAt)).append("\n");
		sb.append("    readyUntil: ").append(toIndentedString(readyUntil)).append("\n");
		sb.append("    signatureRequirement: ").append(toIndentedString(signatureRequirement)).append("\n");
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

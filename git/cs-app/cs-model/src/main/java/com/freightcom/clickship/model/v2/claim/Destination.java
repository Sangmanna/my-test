package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.freightcom.clickship.model.v2.Establishment;

import lombok.Data;

@Data
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
}

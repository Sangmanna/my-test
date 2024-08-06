package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.freightcom.clickship.model.v2.EntityIdDTO;
import com.freightcom.clickship.model.v2.Money;

import lombok.Data;

@Data
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
	private TypeEnum type;

	@JsonProperty("total_cost")
	private Money totalCost;
	
	@JsonProperty("terms_accepted")
	private boolean termsAccepted;
	
	@JsonProperty("terms_accepted_by")
	private EntityIdDTO termsAcceptedBy;
}

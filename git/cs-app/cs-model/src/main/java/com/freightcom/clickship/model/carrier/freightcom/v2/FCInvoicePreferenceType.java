package com.freightcom.clickship.model.carrier.freightcom.v2;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FCInvoicePreferenceType {

	@JsonProperty("per-shipment")
	PER_SHIPMENT("per-shipment"),

	@JsonProperty("end-of-day")
	END_OF_DAY("end-of-day");

	private String value;

	FCInvoicePreferenceType(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

	public static FCInvoicePreferenceType fromValue(String v) {
		for (FCInvoicePreferenceType c : FCInvoicePreferenceType.values()) {
			if (c.value.equalsIgnoreCase(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}

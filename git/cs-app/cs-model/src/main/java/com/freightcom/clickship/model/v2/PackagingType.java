package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets PackagingType
 */
public enum PackagingType {
	PALLET("pallet"), PACKAGE("package"), COURIER_PAK("courier-pak"), ENVELOPE("envelope");

	private String value;

	PackagingType(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static PackagingType fromValue(String text) {
		for (PackagingType b : PackagingType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}

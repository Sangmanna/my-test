package com.freightcom.clickship.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PackageType {

	ENVELOPE("Envelope"), 
	PAK("Courier Pak"),
	PALLET("Pallet"), 
	PACKAGE("Package");

	private String value;

	private PackageType() {
		this.value = name();
	}

	private PackageType(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

}

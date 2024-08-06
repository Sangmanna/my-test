package com.freightcom.clickship.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChargebeeAddons {

	CUSTOM_BRANDING("cs-custom-branding"),
	UPS_CARRIER_ADDON("ups-carrier-addon"),
	ADDITIONAL_CS_USERS("additional-cs-user"),
	CANPAR_CARRIER_ADDON("canpar-carrier-addon"),
	MIDLAND_CARRIER_ADDON("midland-carrier-addon"),
	ADVANCED_SHIPPING_RULE("cs-advanced-shipping-rule"),
	CANADAPOST_CARRIER_ADDON("canadapost-carrier-addon"),
	ADVANCED_SHIPPING_RULE_PALLET("cs-advanced-shipping-rule-pallet");

	private String value;

	private ChargebeeAddons() {
		this.value = name();
	}

	private ChargebeeAddons(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

}

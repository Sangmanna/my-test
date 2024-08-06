package com.freightcom.clickship.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChargebeePlans {
 
	CS_CANPAR_PLAN("canpar-plan"),
	CLICKSHIP_PRO("clickship-pro"),
	CLICKSHIP_LITE("clickship-lite"),
	CLICKSHIP_PLUS("clickship-plus"),
	CLICKSHIP_PREMIUM("clickship-premium"),
	CLICKSHIP_STARTER("clickship-starter"), 
	CLICKSHIP_ENTERPRISE("clickship-enterprise");

	private String value;

	private ChargebeePlans() {
		this.value = name();
	}

	private ChargebeePlans(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public String toString() {
		return value;
	}

}

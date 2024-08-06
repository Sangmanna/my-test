package com.freightcom.clickship.data.entity.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NotificationIconEnum {
	
	PRODUCT("fa-tshirt"),
	SHIPPING("fa-truck"),
	ORDER("fa-shopping-cart"),
	CHARGEBEE("fa-file-spreadsheet"),
	IMPORT("fa-store-alt"),
	EMAIL("fa-envelope");

	private String value;

	private NotificationIconEnum(){
			this.value = name();
		}

	private NotificationIconEnum(String value) {
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

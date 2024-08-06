package com.freightcom.clickship.data.entity.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NotificationAlertEnum {
	
    ORDER_NEW("alert-success"),
    ORDER_CANCEL("alert-danger"),
    PRODUCT_NEW("alert-success"),
    IMPORT_ERROR("alert-danger"),
    PRODUCT_DELETE("alert-danger"),
    SHIPPING_CANCELLED("alert-danger"),
    CHARGEBEE_NEW_INVOICE("alert-success"),
    CHARGEBEE_NO_CARD_PLAN("alert-warning"),
    CHARGEBEE_PAYMENT_FAILED("alert-danger"),
    CHARGEBEE_CHANGE_OF_PLAN("alert-success"),
    CHARGEBEE_ACCEPTED_PAYMENT("alert-success"),
    SHIPPING_INVOICE_GENERATED("alert-success"),
    DANGER("alert-danger"),
    WARNING("alert-warning"),
    SUCCESS("alert-success");
	
	private String value;

	private NotificationAlertEnum(){
			this.value = name();
		}

	private NotificationAlertEnum(String value) {
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

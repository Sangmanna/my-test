package com.freightcom.clickship.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VendastaActivityType {
    CLICKSHIP_ACCOUNT_INACTIVE("Inactivity on Clickship account"),
    CLICKSHIP_ACCOUNT_DISABLED("Clickship account disabled");

    private String value;

    private VendastaActivityType(String value) {
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

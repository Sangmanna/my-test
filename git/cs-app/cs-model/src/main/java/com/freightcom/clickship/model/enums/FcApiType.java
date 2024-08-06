package com.freightcom.clickship.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FcApiType {

    V1("V1"),
    V2("V2");

    private String value;

    private FcApiType(){
        this.value = name();
    }

    private FcApiType(String value) {
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

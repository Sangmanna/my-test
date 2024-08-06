package com.freightcom.clickship.model.marketplace.vendasta;

public enum VendastaEndPoint {
    GET_ACCESS_ID_TOKEN("/oauth2/token"),
    GET_ACCESS_BEARER_TOKEN("/api/v1/oauth/token"),
    ACTIVATE_ACCOUNT("/api/v1/activation/resolve/"),
    USER_INFO("/oauth2/user-info"),
    USER_ACCESS("/api/v1/user/%s/permissions/%s"),
    GET_CERTS("/oauth2/v1/certs"),
    ACTIVITY_STREAM("/api/v1/activity/");

    private String value;

    private VendastaEndPoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

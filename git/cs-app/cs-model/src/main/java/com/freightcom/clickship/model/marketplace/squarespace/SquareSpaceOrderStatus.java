package com.freightcom.clickship.model.marketplace.squarespace;

public enum SquareSpaceOrderStatus {

    PENDING("PENDING"),
    FULFILLED("FULFILLED"),
    CANCELED("CANCELED");

    private String value;

    private SquareSpaceOrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

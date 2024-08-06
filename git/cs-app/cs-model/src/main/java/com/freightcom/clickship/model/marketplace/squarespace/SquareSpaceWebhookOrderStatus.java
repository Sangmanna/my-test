package com.freightcom.clickship.model.marketplace.squarespace;

public enum SquareSpaceWebhookOrderStatus {

    FULFILLED("FULFILLED"),
    REFUNDED("REFUNDED"),
    CANCELED("CANCELED"),
    MARKED_PENDING("MARKED_PENDING"),
    EMAIL_UPDATED("EMAIL_UPDATED");

    private String value;

    private SquareSpaceWebhookOrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

package com.freightcom.clickship.model.enums;

public enum CarrierName {
    AB_COURIER("A&B Courier"),
    KINDERSLEY_TRANSPORT("Kindersley Transport"),
    LOOMIS("Loomis"),
    DHL_ECOMMERCE("DHL eCommerce");

    private final String displayName;

    CarrierName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
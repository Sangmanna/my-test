package com.freightcom.clickship.model.marketplace.ebay;

public enum  CancelReasonEnum {
    ADDRESS_ISSUES("ADDRESS_ISSUES"),
    OUT_OF_STOCK_OR_CANNOT_FULFILL("OUT_OF_STOCK_OR_CANNOT_FULFILL"),
    OTHER ("OTHER");
    private String value;

    CancelReasonEnum (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

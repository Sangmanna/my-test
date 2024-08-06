package com.freightcom.clickship.model.exception;

public class ShippingRuleException extends RuntimeException {
    private static final long serialVersionUID = -7958706180126773882L;

    public ShippingRuleException(String msg) {
        super(msg);
    }
}

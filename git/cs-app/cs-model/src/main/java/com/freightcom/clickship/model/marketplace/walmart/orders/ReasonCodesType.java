
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "reasonCodesType")
@XmlEnum
public enum ReasonCodesType {

    @XmlEnumValue("BillingError")
    BILLING_ERROR("BillingError"),
    @XmlEnumValue("TaxExemptCustomer")
    TAX_EXEMPT_CUSTOMER("TaxExemptCustomer"),
    @XmlEnumValue("ItemNotAsAdvertised")
    ITEM_NOT_AS_ADVERTISED("ItemNotAsAdvertised"),
    @XmlEnumValue("IncorrectItemReceived")
    INCORRECT_ITEM_RECEIVED("IncorrectItemReceived"),
    @XmlEnumValue("CancelledYetShipped")
    CANCELLED_YET_SHIPPED("CancelledYetShipped"),
    @XmlEnumValue("ItemNotReceivedByCustomer")
    ITEM_NOT_RECEIVED_BY_CUSTOMER("ItemNotReceivedByCustomer"),
    @XmlEnumValue("IncorrectShippingPrice")
    INCORRECT_SHIPPING_PRICE("IncorrectShippingPrice"),
    @XmlEnumValue("DamagedItem")
    DAMAGED_ITEM("DamagedItem"),
    @XmlEnumValue("DefectiveItem")
    DEFECTIVE_ITEM("DefectiveItem"),
    @XmlEnumValue("CustomerChangedMind")
    CUSTOMER_CHANGED_MIND("CustomerChangedMind"),
    @XmlEnumValue("CustomerReceivedItemLate")
    CUSTOMER_RECEIVED_ITEM_LATE("CustomerReceivedItemLate"),
    @XmlEnumValue("Finance -> Goodwill")
    FINANCE_GOODWILL("Finance -> Goodwill"),
    @XmlEnumValue("Finance -> Rollback")
    FINANCE_ROLLBACK("Finance -> Rollback"),
    @XmlEnumValue("Missing Parts / Instructions")
    MISSING_PARTS_INSTRUCTIONS("Missing Parts / Instructions"),
    @XmlEnumValue("Buyer canceled")
    BUYER_CANCELED("Buyer canceled"),
    @XmlEnumValue("Customer returned item")
    CUSTOMER_RETURNED_ITEM("Customer returned item"),
    @XmlEnumValue("General adjustment")
    GENERAL_ADJUSTMENT("General adjustment"),
    @XmlEnumValue("Merchandise not received")
    MERCHANDISE_NOT_RECEIVED("Merchandise not received"),
    @XmlEnumValue("Quality -> Missing Parts / Instructions")
    QUALITY_MISSING_PARTS_INSTRUCTIONS("Quality -> Missing Parts / Instructions"),
    @XmlEnumValue("Shipping & Delivery -> Damaged")
    SHIPPING_DELIVERY_DAMAGED("Shipping & Delivery -> Damaged"),
    @XmlEnumValue("Shipping & Delivery -> Shipping Price Discrepancy")
    SHIPPING_DELIVERY_SHIPPING_PRICE_DISCREPANCY("Shipping & Delivery -> Shipping Price Discrepancy"),
    @XmlEnumValue("Others")
    OTHERS("Others");
    private final String value;

    ReasonCodesType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReasonCodesType fromValue(String v) {
        for (ReasonCodesType c: ReasonCodesType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

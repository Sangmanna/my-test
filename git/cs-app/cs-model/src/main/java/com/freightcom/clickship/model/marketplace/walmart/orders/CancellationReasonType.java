
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(name = "cancellationReasonType")
@XmlEnum
public enum CancellationReasonType {

    CANCEL_BY_SELLER,
    CUSTOMER_REQUESTED_SELLER_TO_CANCEL,
    SUPPLIER_CANCEL,
    SUPPLIER_CANCEL_CUSTOMER_REQUEST,
    SUPPLIER_CANCEL_BACKORDER,
    SUPPLIER_CANCEL_DISCONTINUE,
    SUPPLIER_CANCEL_UNRECOGNIZED;

    public String value() {
        return name();
    }

    public static CancellationReasonType fromValue(String v) {
        return valueOf(v);
    }

}

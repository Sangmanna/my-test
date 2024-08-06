package com.freightcom.clickship.model.marketplace.amazon.v2;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum OrderStatusEnum {
    PENDING("Pending"),

    UNSHIPPED("Unshipped"),

    PARTIALLY_SHIPPED("PartiallyShipped"),

    SHIPPED("Shipped"),

    CANCELED("Canceled"),

    UNFULFILLABLE("Unfulfillable"),

    INVOICE_UNCONFIRMED("InvoiceUnconfirmed"),

    PENDING_AVAILABILITY("PendingAvailability");

    private String value;

    OrderStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    private static Map<String, OrderStatusEnum> formatMap = Stream
            .of(OrderStatusEnum.values())
            .collect(Collectors.toMap(s -> s.value, Function.identity()));

    @JsonCreator 
    public static OrderStatusEnum fromString(String type) {
        return Optional
            .ofNullable(formatMap.get(type))
            .orElseThrow(() -> new IllegalArgumentException(type));
    }
}

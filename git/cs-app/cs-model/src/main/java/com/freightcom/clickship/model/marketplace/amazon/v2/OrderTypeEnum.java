package com.freightcom.clickship.model.marketplace.amazon.v2;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum OrderTypeEnum {
    STANDARD_ORDER("StandardOrder"),

    LONG_LEAD_TIME_ORDER("LongLeadTimeOrder"),

    PREORDER("Preorder"),

    BACKORDER("BackOrder"),

    SOURCING_ON_DEMAND_ORDER("SourcingOnDemandOrder");

    private final String value;

    OrderTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    private static Map<String, OrderTypeEnum> formatMap = Stream
            .of(OrderTypeEnum.values())
            .collect(Collectors.toMap(s -> s.value, Function.identity()));

    @JsonCreator 
    public static OrderTypeEnum fromString(String type) {
        return Optional
            .ofNullable(formatMap.get(type))
            .orElseThrow(() -> new IllegalArgumentException(type));
    }
}

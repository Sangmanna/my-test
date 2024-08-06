package com.freightcom.clickship.model.marketplace.amazon.v2;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FulfillmentChannelEnum {
    MFN("MFN"),

    AFN("AFN");

    private String value;

    FulfillmentChannelEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    private static Map<String, FulfillmentChannelEnum> formatMap = Stream
            .of(FulfillmentChannelEnum.values())
            .collect(Collectors.toMap(s -> s.value, Function.identity()));

    @JsonCreator 
    public static FulfillmentChannelEnum fromString(String type) {
        return Optional
            .ofNullable(formatMap.get(type))
            .orElseThrow(() -> new IllegalArgumentException(type));
    }
}

package com.freightcom.clickship.model.marketplace.amazon.v2;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PaymentMethodEnum {
    COD("COD"),

    CVS("CVS"),

    OTHER("Other");

    private String value;

    PaymentMethodEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    private static Map<String, PaymentMethodEnum> formatMap = Stream
            .of(PaymentMethodEnum.values())
            .collect(Collectors.toMap(s -> s.value, Function.identity()));

    @JsonCreator 
    public static PaymentMethodEnum fromString(String type) {
        return Optional
            .ofNullable(formatMap.get(type))
            .orElseThrow(() -> new IllegalArgumentException(type));
    }
}

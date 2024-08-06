package com.freightcom.clickship.model.marketplace.amazon.v2;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ProcessingStatus {
    CANCELLED("CANCELLED"),
    DONE("DONE"),
    FATAL("FATAL"),
    IN_PROGRESS("IN_PROGRESS"),
    IN_QUEUE("IN_QUEUE");

    private String value;

    public String getValue() {
        return this.value;
    }

    private ProcessingStatus (String value) {
        this.value = value;
    }
    
    private static Map<String, ProcessingStatus> formatMap = Stream
            .of(ProcessingStatus.values())
            .collect(Collectors.toMap(s -> s.value, Function.identity()));

    @JsonCreator 
    public static ProcessingStatus fromString(String type) {
        return Optional
            .ofNullable(formatMap.get(type))
            .orElseThrow(() -> new IllegalArgumentException(type));
    }
}

package com.freightcom.clickship.model.v2.claim;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class FCCustomerPreferences {

    @JsonIgnore
    private Map<String, String> fields = new HashMap<>();

    @JsonAnyGetter
    public Map<String, String> getFields() {
        return fields;
    }

    @JsonAnySetter
    public void setField(String key, String value) {
        fields.put(key, value);
    }
}
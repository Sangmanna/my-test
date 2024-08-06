package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceVariantOptions {

    @JsonProperty("value")
    private String value;

    @JsonProperty("optionName")
    private String optionName;

    public String getValue() {
        return value;
    }

    public SquareSpaceVariantOptions setValue(String value) {
        this.value = value;
        return this;
    }

    public String getOptionName() {
        return optionName;
    }

    public SquareSpaceVariantOptions setOptionName(String optionName) {
        this.optionName = optionName;
        return this;
    }
}

package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonV2ProductInfo {

    @JsonProperty("NumberOfItems")
    private Integer numberOfItems;

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public AmazonV2ProductInfo setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
        return this;
    }
}

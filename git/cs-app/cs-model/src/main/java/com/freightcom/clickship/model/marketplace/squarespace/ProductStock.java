package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductStock {

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("unlimited")
    private Boolean unlimited;

    public Integer getQuantity() {
        return quantity;
    }

    public ProductStock setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Boolean getUnlimited() {
        return unlimited;
    }

    public ProductStock setUnlimited(Boolean unlimited) {
        this.unlimited = unlimited;
        return this;
    }
}

package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceInventoryUpdate {

    @JsonProperty("variantId")
    private String variantId;

    @JsonProperty("quantity")
    private String quantity;

    public String getVariantId() {
        return variantId;
    }

    public SquareSpaceInventoryUpdate setVariantId(String variantId) {
        this.variantId = variantId;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public SquareSpaceInventoryUpdate setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }
}

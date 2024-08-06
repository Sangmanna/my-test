package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LineItemReference {

    @JsonProperty("lineItemId")
    private String lineItemId;

    @JsonProperty("quantity")
    private Integer quantity;

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

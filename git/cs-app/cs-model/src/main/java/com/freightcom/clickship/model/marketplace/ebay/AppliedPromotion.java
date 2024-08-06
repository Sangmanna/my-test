package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppliedPromotion {

    @JsonProperty("description")
    private String description;

    @JsonProperty("discountAmount")
    private Amount discountAmount;

    @JsonProperty("promotionId")
    private String promotionId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Amount getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Amount discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }
}

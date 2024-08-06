package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonV2BuyerInfo {

    @JsonProperty("BuyerEmail")
    private String BuyerEmail;

    @JsonProperty("BuyerName")
    private String BuyerName;

    @JsonProperty("BuyerCounty")
    private String BuyerCounty;

    @JsonProperty("PurchaseOrderNumber")
    private String PurchaseOrderNumber;

    public String getBuyerEmail() {
        return BuyerEmail;
    }

    public AmazonV2BuyerInfo setBuyerEmail(String buyerEmail) {
        BuyerEmail = buyerEmail;
        return this;
    }

    public String getBuyerName() {
        return BuyerName;
    }

    public AmazonV2BuyerInfo setBuyerName(String buyerName) {
        BuyerName = buyerName;
        return this;
    }

    public String getBuyerCounty() {
        return BuyerCounty;
    }

    public AmazonV2BuyerInfo setBuyerCounty(String buyerCounty) {
        BuyerCounty = buyerCounty;
        return this;
    }

    public String getPurchaseOrderNumber() {
        return PurchaseOrderNumber;
    }

    public AmazonV2BuyerInfo setPurchaseOrderNumber(String purchaseOrderNumber) {
        PurchaseOrderNumber = purchaseOrderNumber;
        return this;
    }
}

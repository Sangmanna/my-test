package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixShipmentDetails {

    @JsonProperty("address")
    private WixAddress address;

    @JsonProperty("discount")
    private String discount;

    @JsonProperty("tax")
    private String tax;

    @JsonProperty("priceData")
    private WixPriceData priceData;

    public WixAddress getAddress() {
        return address;
    }

    public void setAddress(WixAddress address) {
        this.address = address;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public WixPriceData getPriceData() {
        return priceData;
    }

    public void setPriceData(WixPriceData priceData) {
        this.priceData = priceData;
    }
}

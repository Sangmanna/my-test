package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingFulfillmentDetails {

    @JsonProperty("lineItems")
    private List<LineItemReference> lineItems;

    @JsonProperty("shippedDate")
    private String shippedDate;

    @JsonProperty("shippingCarrierCode")
    private String shippingCarrierCode;

    @JsonProperty("trackingNumber")
    private String trackingNumber;

    public List<LineItemReference> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItemReference> lineItems) {
        this.lineItems = lineItems;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getShippingCarrierCode() {
        return shippingCarrierCode;
    }

    public void setShippingCarrierCode(String shippingCarrierCode) {
        this.shippingCarrierCode = shippingCarrierCode;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}

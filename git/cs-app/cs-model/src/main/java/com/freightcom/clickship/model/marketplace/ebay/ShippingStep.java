package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingStep {

    @JsonProperty("shippingCarrierCode")
    private String shippingCarrierCode;

    @JsonProperty("shippingServiceCode")
    private String shippingServiceCode;

    @JsonProperty("shipTo")
    private ExtendedContact shipTo;

    @JsonProperty("shipToReferenceId")
    private String shipToReferenceId;

    public String getShippingCarrierCode() {
        return shippingCarrierCode;
    }

    public void setShippingCarrierCode(String shippingCarrierCode) {
        this.shippingCarrierCode = shippingCarrierCode;
    }

    public String getShippingServiceCode() {
        return shippingServiceCode;
    }

    public void setShippingServiceCode(String shippingServiceCode) {
        this.shippingServiceCode = shippingServiceCode;
    }

    public ExtendedContact getShipTo() {
        return shipTo;
    }

    public void setShipTo(ExtendedContact shipTo) {
        this.shipTo = shipTo;
    }

    public String getShipToReferenceId() {
        return shipToReferenceId;
    }

    public void setShipToReferenceId(String shipToReferenceId) {
        this.shipToReferenceId = shipToReferenceId;
    }
}

package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceFulfillment {

    @JsonProperty("shipDate")
    private String shipDate;

    @JsonProperty("carrierName")
    private String carrierName;

    @JsonProperty("service")
    private String service;

    @JsonProperty("trackingNumber")
    private String trackingNumber;

    @JsonProperty("trackingUrl")
    private String trackingUrl;

    public String getShipDate() {
        return shipDate;
    }

    public SquareSpaceFulfillment setShipDate(String shipDate) {
        this.shipDate = shipDate;
        return this;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public SquareSpaceFulfillment setCarrierName(String carrierName) {
        this.carrierName = carrierName;
        return this;
    }

    public String getService() {
        return service;
    }

    public SquareSpaceFulfillment setService(String service) {
        this.service = service;
        return this;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public SquareSpaceFulfillment setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }

    public String getTrackingUrl() {
        return trackingUrl;
    }

    public SquareSpaceFulfillment setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
        return this;
    }
}

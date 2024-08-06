package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixShippingInfo {

    @JsonProperty("deliveryOption")
    private String deliveryOption;
    
    @JsonProperty("estimatedDeliveryTime")
    private String estimatedDeliveryTime;

    @JsonProperty("shippingRegion")
    private String shippingRegion;
    
    @JsonProperty("code")
    private String code;
    
    @JsonProperty("deliverByDate")
    private String deliverByDate;
    
    @JsonProperty("shipmentDetails")
    private WixShipmentDetails shipmentDetails;
    
    @JsonProperty("priceData")
    private WixPriceData priceData;

	public String getDeliverByDate() {
		return deliverByDate;
	}

	public WixShippingInfo setDeliverByDate(String deliverByDate) {
		this.deliverByDate = deliverByDate;
		return this;
	}

	public String getDeliveryOption() {
		return deliveryOption;
	}

	public WixShippingInfo setDeliveryOption(String deliveryOption) {
		this.deliveryOption = deliveryOption;
		return this;
	}

	public String getShippingRegion() {
		return shippingRegion;
	}

	public WixShippingInfo setShippingRegion(String shippingRegion) {
		this.shippingRegion = shippingRegion;
		return this;
	}

	public WixShipmentDetails getShipmentDetails() {
		return shipmentDetails;
	}

	public WixShippingInfo setShipmentDetails(WixShipmentDetails shipmentDetails) {
		this.shipmentDetails = shipmentDetails;
		return this;
	}

	public String getEstimatedDeliveryTime() {
		return estimatedDeliveryTime;
	}

	public WixShippingInfo setEstimatedDeliveryTime(String estimatedDeliveryTime) {
		this.estimatedDeliveryTime = estimatedDeliveryTime;
		return this;
	}

	public WixPriceData getPriceData() {
		return priceData;
	}

	public WixShippingInfo setPriceData(WixPriceData priceData) {
		this.priceData = priceData;
		return this;
	}

	public String getCode() {
		return code;
	}

	public WixShippingInfo setCode(String code) {
		this.code = code;
		return this;
	}
    
}

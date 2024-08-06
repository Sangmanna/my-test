package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "ShipFrom",
    "ShipTo",
    "Shipper",
    "ShipmentRatingOptions",
    "ShipmentTotalWeight",
    "DeliveryTimeInformation",
    "InvoiceLineTotal",
    "Package",
    "Description"
})
public class UpsShipment implements Serializable {
	
	private static final long serialVersionUID = 6123110033432558591L;

    @JsonProperty("ShipFrom")
    private UpsShipper shipFrom;
    
    @JsonProperty("ShipTo")
    private UpsShipper shipTo;
    
    @JsonProperty("Shipper")
    private UpsShipper shipper;
    
    @JsonProperty("ShipmentRatingOptions")
    private ServiceOptions shipmentRatingOptions;
    
    @JsonProperty("ShipmentTotalWeight")
    private UpsWeight totalWeight;
    
    @JsonProperty("DeliveryTimeInformation")
    private DeliveryTimeInformation deliveryInfo;
    
    @JsonProperty("InvoiceLineTotal")
    private UpsMoney totalValue;
    	
    @JsonProperty("Package")
    private List<UpsPackage> upsPackage;
    
    @JsonProperty("Description")
    private List<String> description;

	public UpsShipper getShipper() {
		return shipper;
	}

	public UpsShipment setShipper(UpsShipper shipper) {
		this.shipper = shipper;
		return this;
	}

	public UpsShipper getShipFrom() {
		return shipFrom;
	}

	public UpsShipment setShipFrom(UpsShipper shipFrom) {
		this.shipFrom = shipFrom;
		return this;
	}

	public UpsShipper getShipTo() {
		return shipTo;
	}

	public UpsShipment setShipTo(UpsShipper shipTo) {
		this.shipTo = shipTo;
		return this;
	}

	public List<UpsPackage> getUpsPackage() {
		return upsPackage;
	}

	public UpsShipment setUpsPackage(List<UpsPackage> upsPackage) {
		this.upsPackage = upsPackage;
		return this;
	}

	public List<String> getDescription() {
		return description;
	}

	public UpsShipment setDescription(List<String> description) {
		this.description = description;
		return this;
	}

	public ServiceOptions getShipmentRatingOptions() {
		return shipmentRatingOptions;
	}

	public UpsShipment setShipmentRatingOptions(ServiceOptions shipmentRatingOptions) {
		this.shipmentRatingOptions = shipmentRatingOptions;
		return this;
	}

	public UpsWeight getTotalWeight() {
		return totalWeight;
	}

	public UpsShipment setTotalWeight(UpsWeight totalWeight) {
		this.totalWeight = totalWeight;
		return this;
	}

	public UpsMoney getTotalValue() {
		return totalValue;
	}

	public UpsShipment setTotalValue(UpsMoney totalValue) {
		this.totalValue = totalValue;
		return this;
	}

	public DeliveryTimeInformation getDeliveryInfo() {
		return deliveryInfo;
	}

	public UpsShipment setDeliveryInfo(DeliveryTimeInformation deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
		return this;
	}

}

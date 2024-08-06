
package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "Request", "ShipFrom", "ShipTo", "Pickup", "ShipmentWeight", "InvoiceLineTotal" })
public class TimeInTransitRequest implements Serializable {

	private static final long serialVersionUID = -8602359548305421657L;
	
	@JsonProperty("Request")
	private RequestOption requestOption;
	
    @JsonProperty("ShipFrom")
    private UpsShipper shipFrom;
    
    @JsonProperty("ShipTo")
    private UpsShipper shipTo;

    @JsonProperty("Pickup")
    private UpsPickup pickup;
    
    @JsonProperty("ShipmentWeight")
    private UpsWeight weight;    

    @JsonProperty("InvoiceLineTotal")
    private UpsMoney money;

	public RequestOption getRequestOption() {
		return requestOption;
	}

	public TimeInTransitRequest setRequestOption(RequestOption requestOption) {
		this.requestOption = requestOption;
		return this;
	}

	public UpsShipper getShipFrom() {
		return shipFrom;
	}

	public TimeInTransitRequest setShipFrom(UpsShipper shipFrom) {
		this.shipFrom = shipFrom;
		return this;
	}

	public UpsShipper getShipTo() {
		return shipTo;
	}

	public TimeInTransitRequest setShipTo(UpsShipper shipTo) {
		this.shipTo = shipTo;
		return this;
	}

	public UpsPickup getPickup() {
		return pickup;
	}

	public TimeInTransitRequest setPickup(UpsPickup pickup) {
		this.pickup = pickup;
		return this;
	}

	public UpsWeight getWeight() {
		return weight;
	}

	public TimeInTransitRequest setWeight(UpsWeight weight) {
		this.weight = weight;
		return this;
	}

	public UpsMoney getMoney() {
		return money;
	}

	public TimeInTransitRequest setMoney(UpsMoney money) {
		this.money = money;
		return this;
	}
    
}

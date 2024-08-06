
package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsTrackingResponse implements Serializable {

	private static final long serialVersionUID = 4364236345166318330L;

	@JsonProperty("shipment")
	private List<UpsShipment> shipment;

	public List<UpsShipment> getShipment() {
		return shipment;
	}

	public UpsTrackingResponse setShipment(List<UpsShipment> shipment) {
		this.shipment = shipment;
		return this;
	}
	
}

package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryTimeInformation  implements Serializable {

	private static final long serialVersionUID = 1351620490887790535L;

	/**
	 *   Valid values are:
	 *	 	02 - Document only
	 *		03 - Non-Document
	 *		04 - WWEF Pallet
	 *		07 - Domestic Pallet
	 *		
	 *	If 04 is included, Worldwide Express Freight and UPS
	 *	Worldwide Express Freight Midday services (if applicable)
	 *	will be included in the response.
	 * 
	 */
	@JsonProperty("PackageBillType")
	private String packageType = "03";
	
    @JsonProperty("Pickup")
    private UpsPickup pickup;

	public String getPackageType() {
		return packageType;
	}

	public DeliveryTimeInformation setPackageType(String packageType) {
		this.packageType = packageType;
		return this;
	}

	public UpsPickup getPickup() {
		return pickup;
	}

	public DeliveryTimeInformation setPickup(UpsPickup pickup) {
		this.pickup = pickup;
		return this;
	}
		
}

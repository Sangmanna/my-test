package com.freightcom.clickship.model.v2.claim;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.freightcom.clickship.model.v2.Date;
import com.freightcom.clickship.model.v2.Origin;
import com.freightcom.clickship.model.v2.PackagingType;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingDetails {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("origin")
	private Origin origin;

	@JsonProperty("destination")
	private Destination destination;
	
	@JsonProperty("alternate_destination")
	private Destination alternativeDestination;

	@JsonProperty("expected_ship_date")
	private Date expectedShipDate;
	
	@JsonProperty("payment_id")
	private String payment_id;

	@JsonProperty("packaging_type")
	private PackagingType packagingType;

	@JsonProperty("packaging_properties")
	public OneOfShippingDetailsPackagingProperties packagingProperties;
	
	@JsonProperty("reference_codes")
	private String[] referenceCodes;

	@JsonProperty("insurance")
	private ShippingDetailsInsurance insurance;
	
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "packaging_type")
	@JsonSubTypes({
			@JsonSubTypes.Type(value = PackagingPallet.class, name = "pallet"),
			@JsonSubTypes.Type(value = PackagingPackage.class, name = "package"),
			@JsonSubTypes.Type(value = PackagingCourierPak.class, name = "courier-pak"),
			@JsonSubTypes.Type(value = PackagingEnvelope.class, name = "envelope")
	})
	public void setPackagingProperties(OneOfShippingDetailsPackagingProperties packagingProperties) {
		this.packagingProperties = packagingProperties;
	}
}

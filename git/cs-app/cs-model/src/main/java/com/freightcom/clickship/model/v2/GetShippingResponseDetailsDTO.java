package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetShippingResponseDetailsDTO {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("expected_ship_date")
	private ExpectedShipDateDTO expectedShipDate;
	
	@JsonProperty("origin")
	private Origin origin;
	
	@JsonProperty("destination")
	private Destination destination;
	
	@JsonProperty("alternate_destination")
	private String alternateDestination;
	
	@JsonProperty("reference_codes")
	private String referenceCodes;
	
	@JsonProperty("packaging_type")
	private String packingType;
	
	@JsonProperty("packaging_properties")
	private OneOfShippingDetailsPackagingProperties packagingProperties;
	
	@JsonProperty("insurance")
	private ShippingDetailsInsurance insurance;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ExpectedShipDateDTO getExpectedShipDate() {
		return expectedShipDate;
	}

	public void setExpectedShipDate(ExpectedShipDateDTO expectedShipDate) {
		this.expectedShipDate = expectedShipDate;
	}

	public String getAlternateDestination() {
		return alternateDestination;
	}

	public void setAlternateDestination(String alternateDestination) {
		this.alternateDestination = alternateDestination;
	}

	public String getReferenceCodes() {
		return referenceCodes;
	}

	public void setReferenceCodes(String referenceCodes) {
		this.referenceCodes = referenceCodes;
	}

	public String getPackingType() {
		return packingType;
	}

	public void setPackingType(String packingType) {
		this.packingType = packingType;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public OneOfShippingDetailsPackagingProperties getPackagingProperties() {
		return packagingProperties;
	}

	public void setPackagingProperties(OneOfShippingDetailsPackagingProperties packagingProperties) {
		this.packagingProperties = packagingProperties;
	}

	public ShippingDetailsInsurance getInsurance() {
		return insurance;
	}

	public void setInsurance(ShippingDetailsInsurance insurance) {
		this.insurance = insurance;
	}
}

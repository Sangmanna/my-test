package com.freightcom.clickship.model.v2;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShippingDetails {
	@JsonProperty("origin")
	private Origin origin = null;

	@JsonProperty("destination")
	private Destination destination = null;

	@JsonProperty("expected_ship_date")
	private Date expectedShipDate = null;

	@JsonProperty("packaging_type")
	private PackagingType packagingType = null;

	@JsonProperty("packaging_properties")
	private OneOfShippingDetailsPackagingProperties packagingProperties = null;
	
	@JsonProperty("reference_codes")
	private String[] referenceCodes;

	@JsonProperty("insurance")
	private ShippingDetailsInsurance insurance = null;

	public ShippingDetails origin(Origin origin) {
		this.origin = origin;
		return this;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public ShippingDetails destination(Destination destination) {
		this.destination = destination;
		return this;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public ShippingDetails expectedShipDate(Date expectedShipDate) {
		this.expectedShipDate = expectedShipDate;
		return this;
	}

	public Date getExpectedShipDate() {
		return expectedShipDate;
	}

	public void setExpectedShipDate(Date expectedShipDate) {
		this.expectedShipDate = expectedShipDate;
	}

	public ShippingDetails packagingType(PackagingType packagingType) {
		this.packagingType = packagingType;
		return this;
	}

	public PackagingType getPackagingType() {
		return packagingType;
	}

	public void setPackagingType(PackagingType packagingType) {
		this.packagingType = packagingType;
	}

	public ShippingDetails packagingProperties(OneOfShippingDetailsPackagingProperties packagingProperties) {
		this.packagingProperties = packagingProperties;
		return this;
	}

	public OneOfShippingDetailsPackagingProperties getPackagingProperties() {
		return packagingProperties;
	}

	public void setPackagingProperties(OneOfShippingDetailsPackagingProperties packagingProperties) {
		this.packagingProperties = packagingProperties;
	}

	public ShippingDetails insurance(ShippingDetailsInsurance insurance) {
		this.insurance = insurance;
		return this;
	}

	public ShippingDetailsInsurance getInsurance() {
		return insurance;
	}

	public void setInsurance(ShippingDetailsInsurance insurance) {
		this.insurance = insurance;
	}
	
	

	public String[] getReferenceCodes() {
		return referenceCodes;
	}

	public void setReferenceCodes(String[] referenceCodes) {
		this.referenceCodes = referenceCodes;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ShippingDetails shippingDetails = (ShippingDetails) o;
		return Objects.equals(this.origin, shippingDetails.origin)
				&& Objects.equals(this.destination, shippingDetails.destination)
				&& Objects.equals(this.expectedShipDate, shippingDetails.expectedShipDate)
				&& Objects.equals(this.packagingType, shippingDetails.packagingType)
				&& Objects.equals(this.packagingProperties, shippingDetails.packagingProperties)
				&& Objects.equals(this.insurance, shippingDetails.insurance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(origin, destination, expectedShipDate, packagingType, packagingProperties, insurance);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ShippingDetails {\n");

		sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
		sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
		sb.append("    expectedShipDate: ").append(toIndentedString(expectedShipDate)).append("\n");
		sb.append("    packagingType: ").append(toIndentedString(packagingType)).append("\n");
		sb.append("    packagingProperties: ").append(toIndentedString(packagingProperties)).append("\n");
		sb.append("    insurance: ").append(toIndentedString(insurance)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

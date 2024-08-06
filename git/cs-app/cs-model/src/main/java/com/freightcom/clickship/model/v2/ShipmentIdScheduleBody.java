package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShipmentIdScheduleBody {
	@JsonProperty("pickup_details")
	private PickupDetails pickupDetails = null;

	@JsonProperty("dispatch_details")
	private DispatchDetails dispatchDetails = null;

	public ShipmentIdScheduleBody pickupDetails(PickupDetails pickupDetails) {
		this.pickupDetails = pickupDetails;
		return this;
	}

	public PickupDetails getPickupDetails() {
		return pickupDetails;
	}

	public void setPickupDetails(PickupDetails pickupDetails) {
		this.pickupDetails = pickupDetails;
	}

	public ShipmentIdScheduleBody dispatchDetails(DispatchDetails dispatchDetails) {
		this.dispatchDetails = dispatchDetails;
		return this;
	}

	public DispatchDetails getDispatchDetails() {
		return dispatchDetails;
	}

	public void setDispatchDetails(DispatchDetails dispatchDetails) {
		this.dispatchDetails = dispatchDetails;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ShipmentIdScheduleBody shipmentIdScheduleBody = (ShipmentIdScheduleBody) o;
		return Objects.equals(this.pickupDetails, shipmentIdScheduleBody.pickupDetails)
				&& Objects.equals(this.dispatchDetails, shipmentIdScheduleBody.dispatchDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pickupDetails, dispatchDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ShipmentIdScheduleBody {\n");

		sb.append("    pickupDetails: ").append(toIndentedString(pickupDetails)).append("\n");
		sb.append("    dispatchDetails: ").append(toIndentedString(dispatchDetails)).append("\n");
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

package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PickupAvailabilityReq extends PickupAvailability {

	@JsonProperty("carrier_id")
	private String carrierId;

	@JsonProperty("service_id")
	private String serviceId;

	@JsonProperty("current_date")
	private Date currentDate;

	@JsonProperty("current_time")
	private TimeOfDay currentTime;

	@JsonProperty("origin_address")
	private Address originAddress;

	public String getCarrierId() {
		return carrierId;
	}

	public PickupAvailabilityReq setCarrierId(String carrierId) {
		this.carrierId = carrierId;
		return this;
	}

	public String getServiceId() {
		return serviceId;
	}

	public PickupAvailabilityReq setServiceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public PickupAvailabilityReq setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
		return this;
	}

	public TimeOfDay getCurrentTime() {
		return currentTime;
	}

	public PickupAvailabilityReq setCurrentTime(TimeOfDay currentTime) {
		this.currentTime = currentTime;
		return this;
	}

	public Address getOriginAddress() {
		return originAddress;
	}

	public PickupAvailabilityReq setOriginAddress(Address originAddress) {
		this.originAddress = originAddress;
		return this;
	}

}

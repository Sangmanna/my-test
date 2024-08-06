package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarrierServiceResponseDTO {

	@JsonProperty("")
	private List<CarrierService> carrierServices;

	public List<CarrierService> getCarrierServices() {
		return carrierServices;
	}

	public void setCarrierServices(List<CarrierService> carrierServices) {
		this.carrierServices = carrierServices;
	}
	
	
}

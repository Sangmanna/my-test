package com.freightcom.clickship.model.shippingrules;

import com.freightcom.clickship.model.carrier.CustomerCarrierPreferenceDTO;

public class ShippingRuleCarrierDTO {
	private String id; 
    private CustomerCarrierPreferenceDTO customerCarrierPreferenceDTO;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CustomerCarrierPreferenceDTO getCustomerCarrierPreferenceDTO() {
		return customerCarrierPreferenceDTO;
	}
	public void setCustomerCarrierPreferenceDTO(CustomerCarrierPreferenceDTO customerCarrierPreferenceDTO) {
		this.customerCarrierPreferenceDTO = customerCarrierPreferenceDTO;
	}
    
}

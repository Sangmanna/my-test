package com.freightcom.clickship.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UpdateCustomerDTO extends UpdateUserDTO {
	
	private String customerId;
	
	private String businessName;

	public String getCustomerId() {
		return customerId;
	}

	public UpdateCustomerDTO setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getBusinessName() {
		return businessName;
	}

	public UpdateCustomerDTO setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}
	
}

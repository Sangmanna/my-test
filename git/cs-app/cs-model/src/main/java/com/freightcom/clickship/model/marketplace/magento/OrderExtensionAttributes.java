package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderExtensionAttributes implements Serializable {

	private static final long serialVersionUID = -7255485888984255146L;
	
	@JsonProperty("shipping_assignments")
	private List<ShippingAssignments> shipping_assignments;

	public List<ShippingAssignments> getShipping_assignments() {
		return shipping_assignments;
	}

	public OrderExtensionAttributes setShipping_assignments(List<ShippingAssignments> shipping_assignments) {
		this.shipping_assignments = shipping_assignments;
		return this;
	}
	
}

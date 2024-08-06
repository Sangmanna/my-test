package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCardRefundProperties {
	
	String payment_method_id;

	public String getPayment_method_id() {
		return payment_method_id;
	}

	public CreditCardRefundProperties setPayment_method_id(String payment_method_id) {
		this.payment_method_id = payment_method_id;
		return this;
	}
	
}

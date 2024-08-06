package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodResponse {

	PaymentMethod payment_method;
	
	@Data
	@EqualsAndHashCode(callSuper = false)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class PaymentMethod {
		String last_four_digits;
		String id;
	}
}

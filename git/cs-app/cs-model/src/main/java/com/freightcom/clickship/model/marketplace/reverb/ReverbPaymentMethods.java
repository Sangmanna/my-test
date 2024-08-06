package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReverbPaymentMethods {
	@JsonProperty("paypal")
	private ReverbPaymentMethod paypal;
	@JsonProperty("direct_checkout")
	private ReverbPaymentMethod directCheckout;
}

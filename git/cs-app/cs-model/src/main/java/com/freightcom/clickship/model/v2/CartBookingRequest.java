package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartBookingRequest {
	
	@JsonProperty("currency_payment_methods")
	private List<PaymentMethodCurrency> paymentMethodCurrencies;

	public List<PaymentMethodCurrency> getPaymentMethodCurrencies() {
		return paymentMethodCurrencies;
	}

	public void setPaymentMethodCurrencies(List<PaymentMethodCurrency> paymentMethodCurrencies) {
		this.paymentMethodCurrencies = paymentMethodCurrencies;
	}

}

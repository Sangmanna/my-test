package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentMethodCurrency {

	@JsonProperty("payment_method_id")
	private String paymentMethodId;
	
	@JsonProperty("billing_currency_code")
	private String billingCurrencyCode;
	
	public PaymentMethodCurrency(String paymentMethodId, String billingCurrencyCode) {
		super();
		this.paymentMethodId = paymentMethodId;
		this.billingCurrencyCode = billingCurrencyCode;
	}

	public String getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getBillingCurrencyCode() {
		return billingCurrencyCode;
	}

	public void setBillingCurrencyCode(String billingCurrencyCode) {
		this.billingCurrencyCode = billingCurrencyCode;
	}	
	
}

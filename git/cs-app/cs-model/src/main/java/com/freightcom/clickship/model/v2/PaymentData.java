package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentData {

    @JsonProperty("credit_card_auth")
    private String creditCardAuth;

    @JsonProperty("credit_card_number")
    private String creditCardNumber;

    @JsonProperty("credit_card_reference")
    private String creditCardReference;

    // Invoice fields
    @JsonProperty("credit_card_type")
    private String creditCardType;

    @JsonProperty("paid_by")
    private String paidBy;

    @JsonProperty("paid_on_v1")
    private boolean paidOnV1;

    public String getCreditCardAuth() {
        return creditCardAuth;
    }

    public PaymentData setCreditCardAuth(String creditCardAuth) {
        this.creditCardAuth = creditCardAuth;
        return this;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public PaymentData setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
        return this;
    }

    public String getCreditCardReference() {
        return creditCardReference;
    }

    public PaymentData setCreditCardReference(String creditCardReference) {
        this.creditCardReference = creditCardReference;
        return this;
    }

	public String getCreditCardType() {
		return creditCardType;
	}

	public PaymentData setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
		 return this;
	}

	public String getPaidBy() {
		return paidBy;
	}

	public PaymentData setPaidBy(String paidBy) {
		this.paidBy = paidBy;
		 return this;
	}

	public boolean isPaidOnV1() {
		return paidOnV1;
	}

	public PaymentData setPaidOnV1(boolean paidOnV1) {
		this.paidOnV1 = paidOnV1;
		 return this;
	}
    
}

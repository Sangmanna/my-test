package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixBillingInfo {

    @JsonProperty("paymentMethod")
    private String paymentMethod;

    @JsonProperty("paymentProviderTransactionId")
    private String paymentProviderTransactionId;

    @JsonProperty("paymentGatewayTransactionId")
    private String paymentGatewayTransactionId;

    @JsonProperty("address")
    private WixAddress address;

    @JsonProperty("paidDate")
    private String paidDate;

    @JsonProperty("refundableByPaymentProvider")
    private Boolean refundableByPaymentProvider;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentProviderTransactionId() {
        return paymentProviderTransactionId;
    }

    public void setPaymentProviderTransactionId(String paymentProviderTransactionId) {
        this.paymentProviderTransactionId = paymentProviderTransactionId;
    }

    public String getPaymentGatewayTransactionId() {
        return paymentGatewayTransactionId;
    }

    public void setPaymentGatewayTransactionId(String paymentGatewayTransactionId) {
        this.paymentGatewayTransactionId = paymentGatewayTransactionId;
    }

    public WixAddress getAddress() {
        return address;
    }

    public void setAddress(WixAddress address) {
        this.address = address;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public Boolean getRefundableByPaymentProvider() {
        return refundableByPaymentProvider;
    }

    public void setRefundableByPaymentProvider(Boolean refundableByPaymentProvider) {
        this.refundableByPaymentProvider = refundableByPaymentProvider;
    }
}

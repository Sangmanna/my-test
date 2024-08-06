package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixRefunds {

    @JsonProperty("dateCreated")
    private String dateCreated;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("paymentProviderTransactionId")
    private String paymentProviderTransactionId;

    @JsonProperty("id")
    private String id;

    @JsonProperty("externalRefund")
    private Boolean externalRefund;

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPaymentProviderTransactionId() {
        return paymentProviderTransactionId;
    }

    public void setPaymentProviderTransactionId(String paymentProviderTransactionId) {
        this.paymentProviderTransactionId = paymentProviderTransactionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getExternalRefund() {
        return externalRefund;
    }

    public void setExternalRefund(Boolean externalRefund) {
        this.externalRefund = externalRefund;
    }
}

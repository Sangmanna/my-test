package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoicePayment {
    private String invoiceId;
    private String paymentId;
    private Amount amount;
}
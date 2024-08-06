package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class V2LineItems {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("sub_type")
    private String subType;

    @JsonProperty("payment_id")
    private String paymentId;

    @JsonProperty("amount")
    private Money amount;

    @JsonProperty("message")
    private String message;

	// invoice fields
	@JsonProperty("document_id")
	private String documentId;

	@JsonProperty("shipment_id")
	private String shipmentId;

	@JsonProperty("charge_type")
	private String chargeType;

    public String getId() {
        return id;
    }

    public V2LineItems setId(String id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public V2LineItems setType(String type) {
        this.type = type;
        return this;
    }

    public String getSubType() {
        return subType;
    }

    public V2LineItems setSubType(String subType) {
        this.subType = subType;
        return this;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public V2LineItems setPaymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public Money getAmount() {
        return amount;
    }

    public V2LineItems setAmount(Money amount) {
        this.amount = amount;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public V2LineItems setMessage(String message) {
        this.message = message;
        return this;
    }

	public String getDocumentId() {
		return documentId;
	}

	public V2LineItems setDocumentId(String documentId) {
		this.documentId = documentId;
		 return this;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public V2LineItems setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
		 return this;
	}

	public String getChargeType() {
		return chargeType;
	}

	public V2LineItems setChargeType(String chargeType) {
		this.chargeType = chargeType;
		 return this;
	}
}

package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsRateRequest implements Serializable {

	private static final long serialVersionUID = 1375968075218868509L;

	@JsonProperty("RequestOption")
	private String requestOption;

	@JsonProperty("TransactionReference")
	private TransactionReference transactionReference;

	@JsonProperty("Shipment")
	private UpsShipment shipment;

	public String getRequestOption() {
		return requestOption;
	}

	public UpsRateRequest setRequestOption(String requestOption) {
		this.requestOption = requestOption;
		return this;
	}

	public TransactionReference getTransactionReference() {
		return transactionReference;
	}

	public UpsRateRequest setTransactionReference(TransactionReference transactionReference) {
		this.transactionReference = transactionReference;
		return this;
	}

	public UpsShipment getShipment() {
		return shipment;
	}

	public UpsRateRequest setShipment(UpsShipment shipment) {
		this.shipment = shipment;
		return this;
	}

}

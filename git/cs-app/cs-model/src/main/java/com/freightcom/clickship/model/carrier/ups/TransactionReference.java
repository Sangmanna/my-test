package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionReference implements Serializable {

	private static final long serialVersionUID = 8692610265199122067L;

	@JsonProperty("CustomerContext")
	private String customerContext;

	@JsonProperty("TransactionIdentifier")
	private String transactionIdentifier;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getCustomerContext() {
		return customerContext;
	}

	public TransactionReference setCustomerContext(String customerContext) {
		this.customerContext = customerContext;
		return this;
	}

	public String getTransactionIdentifier() {
		return transactionIdentifier;
	}

	public TransactionReference setTransactionIdentifier(String transactionIdentifier) {
		this.transactionIdentifier = transactionIdentifier;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public TransactionReference setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}

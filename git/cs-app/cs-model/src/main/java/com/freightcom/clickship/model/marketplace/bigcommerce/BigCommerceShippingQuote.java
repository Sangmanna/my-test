package com.freightcom.clickship.model.marketplace.bigcommerce;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceShippingQuote implements Serializable {
	
	private static final long serialVersionUID = -7090163573637197982L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("uuid")
	private String uuid;
	
	@JsonProperty("rate_id")
	private String rateId;
	
	@JsonProperty("method_id")
	private String methodId;

	@JsonProperty("rate_code")
	private String rateCode;
	
	@JsonProperty("timestamp")
	private String timeStamp;
	
	@JsonProperty("carrier_code")
	private String carrierCode;
	
	@JsonProperty("provider_code")
	private String providerCode;
	
	@JsonProperty("shipping_provider_id")
	private String shippingProviderId;

	public Long getId() {
		return id;
	}

	public BigCommerceShippingQuote setId(Long id) {
		this.id = id;
		return this;
	}

	public String getUuid() {
		return uuid;
	}

	public BigCommerceShippingQuote setUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	public String getRateId() {
		return rateId;
	}

	public BigCommerceShippingQuote setRateId(String rateId) {
		this.rateId = rateId;
		return this;
	}

	public String getMethodId() {
		return methodId;
	}

	public BigCommerceShippingQuote setMethodId(String methodId) {
		this.methodId = methodId;
		return this;
	}

	public String getRateCode() {
		return rateCode;
	}

	public BigCommerceShippingQuote setRateCode(String rateCode) {
		this.rateCode = rateCode;
		return this;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public BigCommerceShippingQuote setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public BigCommerceShippingQuote setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
		return this;
	}

	public String getProviderCode() {
		return providerCode;
	}

	public BigCommerceShippingQuote setProviderCode(String providerCode) {
		this.providerCode = providerCode;
		return this;
	}

	public String getShippingProviderId() {
		return shippingProviderId;
	}

	public BigCommerceShippingQuote setShippingProviderId(String shippingProviderId) {
		this.shippingProviderId = shippingProviderId;
		return this;
	}
	
}

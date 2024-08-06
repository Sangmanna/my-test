package com.freightcom.clickship.model.marketplace.wix;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixWebhooksEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8016914077996741354L;

	@JsonProperty("data")
	private String data;

	@JsonProperty("iat")
	private Long iat;

	@JsonProperty("exp")
	private String exp;

	public String getData() {
		return data;
	}

	public WixWebhooksEvent setData(String data) {
		this.data = data;
		return this;
	}

	public Long getIat() {
		return iat;
	}

	public WixWebhooksEvent setIat(Long iat) {
		this.iat = iat;
		return this;
	}

	public String getExp() {
		return exp;
	}

	public WixWebhooksEvent setExp(String exp) {
		this.exp = exp;
		return this;
	}

	@Override
	public String toString() {
		return "WixWebhooksEvent [data=" + data + ", iat=" + iat + ", exp=" + exp + "]";
	}

}

package com.freightcom.clickship.model.marketplace.ebay;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EbayPublicKey implements Serializable {

	private static final long serialVersionUID = 2223831294239975879L;

	private String key;
	
	private String digest;
	
	private String algorithm;

	public String getKey() {
		return key;
	}

	public EbayPublicKey setKey(String key) {
		this.key = key;
		return this;
	}

	public String getDigest() {
		return digest;
	}

	public EbayPublicKey setDigest(String digest) {
		this.digest = digest;
		return this;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public EbayPublicKey setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
		return this;
	}
	
}

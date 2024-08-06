package com.freightcom.clickship.model.marketplace.ebay;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EbaySignature {
    
	private String alg;
	
	private String kid;
	
	private String digest;
    
	private String signature;

    public String getKid() {
        return kid;
    }

    public EbaySignature setKid(String kid) {
        this.kid = kid;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public EbaySignature setSignature(String signature) {
        this.signature = signature;
        return this;
    }

	public String getAlg() {
		return alg;
	}

	public EbaySignature setAlg(String alg) {
		this.alg = alg;
		return this;
	}

	public String getDigest() {
		return digest;
	}

	public EbaySignature setDigest(String digest) {
		this.digest = digest;
		return this;
	}
    
}

package com.freightcom.clickship.model.marketplace.ebay;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EbayChallengeResponseDTO implements Serializable {

	private static final long serialVersionUID = -126839956703674685L;
	
	private String challengeResponse;

	public String getChallengeResponse() {
		return challengeResponse;
	}

	public EbayChallengeResponseDTO setChallengeResponse(String challengeResponse) {
		this.challengeResponse = challengeResponse;
		return this;
	}

}

package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.CommonDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClaimSearchResponseDTO extends CommonDTO {
	
	@JsonProperty("claims")
    ClaimDTO[] claims;

	public ClaimDTO[] getClaims() {
		return claims;
	}

	public ClaimSearchResponseDTO setClaims(ClaimDTO[] claims) {
		this.claims = claims;
		return this;
	}
	
}

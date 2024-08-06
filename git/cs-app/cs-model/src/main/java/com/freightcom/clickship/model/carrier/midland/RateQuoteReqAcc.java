package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
public class RateQuoteReqAcc {

	@JsonProperty("AccKeyword")
	private String accKeyword;

	public RateQuoteReqAcc(String accKeyword) {
		this.accKeyword = accKeyword;
	}

	public String getAccKeyword() {
		return accKeyword;
	}

	public void setAccKeyword(String accKeyword) {
		this.accKeyword = accKeyword;
	}
}

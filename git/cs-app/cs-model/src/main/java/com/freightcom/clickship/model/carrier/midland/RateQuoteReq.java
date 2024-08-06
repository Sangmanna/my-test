package com.freightcom.clickship.model.carrier.midland;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
public class RateQuoteReq {

	@JsonProperty("RateQuoteReqAcc")
	private List<RateQuoteReqAcc> rateQuoteReqAccs;

	@JsonProperty("RateQuoteRequest")
	private List<RateQuoteRequest> rateQuoteRequests;

	@JsonProperty("RateQuoteReqLine")
	private List<RateQuoteReqLine> rateQuoteReqLines;

	@JsonProperty("RateQuoteReqLineDim")
	private List<RateQuoteReqLineDim> rateQuoteReqLineDims;

	public List<RateQuoteRequest> getRateQuoteRequests() {
		return rateQuoteRequests;
	}

	public void setRateQuoteRequests(List<RateQuoteRequest> rateQuoteRequests) {
		this.rateQuoteRequests = rateQuoteRequests;
	}

	public void setRateQuoteRequests(RateQuoteRequest rateQuoteRequest) {
		if (this.rateQuoteRequests == null) {
			this.rateQuoteRequests = new ArrayList<>();
		}

		this.rateQuoteRequests.add(rateQuoteRequest);
	}

	public List<RateQuoteReqLine> getRateQuoteReqLines() {
		return rateQuoteReqLines;
	}

	public void setRateQuoteReqLines(List<RateQuoteReqLine> rateQuoteReqLines) {
		this.rateQuoteReqLines = rateQuoteReqLines;
	}

	public void setRateQuoteReqLines(RateQuoteReqLine rateQuoteReqLine) {
		if (this.rateQuoteReqLines == null) {
			this.rateQuoteReqLines = new ArrayList<>();
		}

		this.rateQuoteReqLines.add(rateQuoteReqLine);
	}

	public List<RateQuoteReqLineDim> getRateQuoteReqLineDims() {
		return rateQuoteReqLineDims;
	}

	public void setRateQuoteReqLineDims(List<RateQuoteReqLineDim> rateQuoteReqLineDims) {
		this.rateQuoteReqLineDims = rateQuoteReqLineDims;
	}

	public void setRateQuoteReqLineDims(RateQuoteReqLineDim rateQuoteReqLineDim) {
		if (this.rateQuoteReqLineDims == null) {
			this.rateQuoteReqLineDims = new ArrayList<>();
		}

		this.rateQuoteReqLineDims.add(rateQuoteReqLineDim);
	}

	public List<RateQuoteReqAcc> getRateQuoteReqAccs() {
		return rateQuoteReqAccs;
	}

	public void setRateQuoteReqAccs(List<RateQuoteReqAcc> rateQuoteReqAccs) {
		this.rateQuoteReqAccs = rateQuoteReqAccs;
	}

	public void setRateQuoteReqAccs(RateQuoteReqAcc rateQuoteReqAcc) {
		if (this.rateQuoteReqAccs == null) {
			this.rateQuoteReqAccs = new ArrayList<>();
		}

		this.rateQuoteReqAccs.add(rateQuoteReqAcc);
	}
}

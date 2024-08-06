package com.freightcom.clickship.model.marketplace.amazon;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.freightcom.clickship.model.marketplace.amazon.products.MatchingProductResult;

@XmlRootElement(name = "GetMatchingProductResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class MatchingProductResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="GetMatchingProductResult")
	private MatchingProductResult matchingProductResult;
	
	@XmlElement(name="ResponseMetadata")
	private ResponseMetadata respose;
	
	public MatchingProductResponse() {
		super();
	}
	
	public MatchingProductResponse(MatchingProductResult matchingProductResult,	ResponseMetadata response) {
		super();
		this.matchingProductResult = matchingProductResult;
		this.respose = response;
	}

	public MatchingProductResult getMatchingProductResult() {
		return matchingProductResult;
	}

	public void setMatchingProductResult(MatchingProductResult matchingProductResult) {
		this.matchingProductResult = matchingProductResult;
	}

	public ResponseMetadata getRespose() {
		return respose;
	}

	public void setRespose(ResponseMetadata respose) {
		this.respose = respose;
	}

}

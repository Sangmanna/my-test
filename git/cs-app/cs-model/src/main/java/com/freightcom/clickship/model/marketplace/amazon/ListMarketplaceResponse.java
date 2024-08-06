package com.freightcom.clickship.model.marketplace.amazon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.freightcom.clickship.model.marketplace.amazon.verify.ListMarketplaceParticipationsResult;

@XmlRootElement(name = "ListMarketplaceParticipationsResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListMarketplaceResponse implements Serializable {
	
	private static final long serialVersionUID = 6200435771838459443L;

	@XmlElement(name = "ListMarketplaceParticipationsResult")
	private ArrayList<ListMarketplaceParticipationsResult> listMarketplaceParticipationsResult;
	
	@XmlElement(name = "ResponseMetadata")	
	private ArrayList<ResponseMetadata> responseMetadata;
	
	public ListMarketplaceResponse() {
		super();
	}
	
	public ListMarketplaceResponse(ArrayList<ListMarketplaceParticipationsResult> listMarketplaceParticipationsResult,
			ArrayList<ResponseMetadata> responseMetadata) {
		super();
		this.listMarketplaceParticipationsResult = listMarketplaceParticipationsResult;
		this.responseMetadata = responseMetadata;
	}

	public ArrayList<ListMarketplaceParticipationsResult> getListMarketplaceParticipationsResult() {
		return listMarketplaceParticipationsResult;
	}

	public void setListMarketplaceParticipationsResult(
			ArrayList<ListMarketplaceParticipationsResult> listMarketplaceParticipationsResult) {
		this.listMarketplaceParticipationsResult = listMarketplaceParticipationsResult;
	}

	public List<ResponseMetadata> getResponseMetadata() {
		return responseMetadata;
	}
			
	public void setResponseMetadata(ArrayList<ResponseMetadata> responseMetadata) {
		this.responseMetadata = responseMetadata;
	}

}

package com.freightcom.clickship.model.marketplace.amazon.verify;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ListMarketplaceParticipationsResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListMarketplaceParticipationsResult implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="ListParticipations")	
	private List<ListParticipations> listParticipations;
	
	@XmlElement(name="ListMarketplaces")	
	private List<ListMarketplaces> listMarketplaces;
	
	public ListMarketplaceParticipationsResult() {
		super();
	}
	
	public ListMarketplaceParticipationsResult(List<ListParticipations> listParticipations,
			List<ListMarketplaces> listMarketplaces) {
		super();
		this.listParticipations = listParticipations;
		this.listMarketplaces = listMarketplaces;		
	}

	public List<ListParticipations> getListParticipations() {
		return listParticipations;
	}

	public void setListParticipations(List<ListParticipations> listParticipations) {
		this.listParticipations = listParticipations;
	}

	public List<ListMarketplaces> getListMarketplaces() {
		return listMarketplaces;
	}

	public void setListMarketplaces(List<ListMarketplaces> listMarketplaces) {
		this.listMarketplaces = listMarketplaces;
	}
	
	@Override
	public String toString() {
		return "ListMarketplaceParticipationsResult[listParticipations="+listParticipations+","
				+ "listMarketplaces="+listMarketplaces+"]";
		
	}
}

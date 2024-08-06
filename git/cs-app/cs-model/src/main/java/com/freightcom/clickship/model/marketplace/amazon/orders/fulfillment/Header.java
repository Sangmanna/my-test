package com.freightcom.clickship.model.marketplace.amazon.orders.fulfillment;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Header")
@XmlAccessorType(XmlAccessType.FIELD)
public class Header {
	
	@XmlElement(name="DocumentVersion")
	private String documentVersion;
	
	@XmlElement(name="MerchantIdentifier")
	private String merchantIdentifier;
	
	public Header() {
		
	}

	public String getDocumentVersion() {
		return documentVersion;
	}

	public void setDocumentVersion(String documentVersion) {
		this.documentVersion = documentVersion;
	}

	public String getMerchantIdentifier() {
		return merchantIdentifier;
	}

	public void setMerchantIdentifier(String merchantIdentifier) {
		this.merchantIdentifier = merchantIdentifier;
	}
	
	

}

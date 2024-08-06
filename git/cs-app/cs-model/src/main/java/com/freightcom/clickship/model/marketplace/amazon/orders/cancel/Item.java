package com.freightcom.clickship.model.marketplace.amazon.orders.cancel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
	
	@XmlElement(name="AmazonOrderItemCode")
	private String amazonOrderItemCode;
	
	@XmlElement(name="CancelReason")
	private String cancelReason;
	/**
	 * Valid reason codes:
	 * NoInventory
		ShippingAddressUndeliverable
		CustomerExchange
		BuyerCanceled
		GeneralAdjustment
		CarrierCreditDecision
		RiskAssessmentInformationNotValid
		CarrierCoverageFailure
		CustomerReturn
		MerchandiseNotReceived
	 * 
	 */
	
	public Item() {
		
	}
	public String getAmazonOrderItemCode() {
		return amazonOrderItemCode;
	}
	public void setAmazonOrderItemCode(String amazonOrderItemCode) {
		this.amazonOrderItemCode = amazonOrderItemCode;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

}

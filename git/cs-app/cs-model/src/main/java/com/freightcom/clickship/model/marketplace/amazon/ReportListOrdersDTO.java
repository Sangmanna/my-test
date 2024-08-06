package com.freightcom.clickship.model.marketplace.amazon;

public class ReportListOrdersDTO {
	
	private String orderId;
	private String buyerEmail;
	private String buyerName;
	private String buyerPhoneNumber;
	private String recipientName;
	private String shipAddress1;
	private String shipAddress2;
	private String shipAddress3;
	private String shipCity;
	private String shipState;
	private String shipPostalCode;
	private String shipCountry;
	
	public ReportListOrdersDTO() {
		
	}
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String getBuyerEmail() {
		return buyerEmail;
	}
	
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	
	public String getBuyerName() {
		return buyerName;
	}
	
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	public String getBuyerPhoneNumber() {
		return buyerPhoneNumber;
	}
	
	public void setBuyerPhoneNumber(String buyerPhoneNumber) {
		this.buyerPhoneNumber = buyerPhoneNumber;
	}
	
	public String getRecipientName() {
		return recipientName;
	}
	
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	
	public String getShipAddress1() {
		return shipAddress1;
	}
	
	public void setShipAddress1(String shipAddress1) {
		this.shipAddress1 = shipAddress1;
	}
	
	public String getShipAddress2() {
		return shipAddress2;
	}
	
	public void setShipAddress2(String shipAddress2) {
		this.shipAddress2 = shipAddress2;
	}
	
	public String getShipAddress3() {
		return shipAddress3;
	}
	
	public void setShipAddress3(String shipAddress3) {
		this.shipAddress3 = shipAddress3;
	}
	
	public String getShipCity() {
		return shipCity;
	}
	
	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}
	
	public String getShipState() {
		return shipState;
	}
	
	public void setShipState(String shipState) {
		this.shipState = shipState;
	}
	
	public String getShipPostalCode() {
		return shipPostalCode;
	}
	
	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}
	
	public String getShipCountry() {
		return shipCountry;
	}
	
	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

}

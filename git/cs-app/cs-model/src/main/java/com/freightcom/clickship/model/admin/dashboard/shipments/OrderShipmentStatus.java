package com.freightcom.clickship.model.admin.dashboard.shipments;

public class OrderShipmentStatus {
	private String orderId;
	private String shipmentId;
	private String orderNumber;
	private String orderStatus;
	private boolean shipmentStatus;
	private String trackingNumber;
	private String marketplaceId;
	public OrderShipmentStatus() {
		super();
	}
	
	public OrderShipmentStatus(Object[] cols) {
		super();
		this.orderId = (String)cols[0];
		this.shipmentId = (String)cols[1];
		this.orderNumber = (String)cols[2];
		this.orderStatus = (String)cols[3];
		this.shipmentStatus = (Byte)cols[4] != 0;
		this.trackingNumber = (String)cols[5];
		this.marketplaceId = (String)cols[6];
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public boolean isShipmentStatus() {
		return shipmentStatus;
	}
	public void setShipmentStatus(boolean shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public String getMarketplaceId() {
		return marketplaceId;
	}
	public void setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
	}
	

}

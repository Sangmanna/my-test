package com.freightcom.clickship.model.v2.claim;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The DTO used in Clickship UI and application. Including claimDto from Freightcom
 * 
 * @author sangmann
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CSClaimDTO {
	
	@JsonProperty("claim")
	ClaimDTO claimDto;
	
	Order order;
	
	public static class Order {
		String orderId;
		
		String orderNumber;
		
		String storeName;
		
		String trackingNumber;
		
		String trackingUrl;
		
		String shipmentState;
		
		String shipmentId;
		
		Date shipDate;
		
		double insuranceAmount;
		
		int insuranceType;
		
		String carrier;
		
		String service;
		
		double totalPrice = 0d;
		
		String totalPriceCurrency;
		
		String bookedBy;
		
		String packageType;

		public String getOrderId() {
			return orderId;
		}

		public Order setOrderId(String orderId) {
			this.orderId = orderId;
			return this;
		}

		public String getOrderNumber() {
			return orderNumber;
		}

		public Order setOrderNumber(String orderNumber) {
			this.orderNumber = orderNumber;
			return this;
		}

		public String getStoreName() {
			return storeName;
		}

		public Order setStoreName(String storeName) {
			this.storeName = storeName;
			return this;
		}

		public String getTrackingNumber() {
			return trackingNumber;
		}

		public Order setTrackingNumber(String trackingNumber) {
			this.trackingNumber = trackingNumber;
			return this;
		}

		public String getTrackingUrl() {
			return trackingUrl;
		}

		public Order setTrackingUrl(String trackingUrl) {
			this.trackingUrl = trackingUrl;
			return this;
		}

		public String getShipmentState() {
			return shipmentState;
		}

		public Order setShipmentState(String shipmentState) {
			this.shipmentState = shipmentState;
			return this;
		}

		public String getShipmentId() {
			return shipmentId;
		}

		public Order setShipmentId(String shipmentId) {
			this.shipmentId = shipmentId;
			return this;
		}

		public Date getShipDate() {
			return shipDate;
		}

		public Order setShipDate(Date shipDate) {
			this.shipDate = shipDate;
			return this;
		}

		public double getInsuranceAmount() {
			return insuranceAmount;
		}

		public Order setInsuranceAmount(double insuranceAmount) {
			this.insuranceAmount = insuranceAmount;
			return this;
		}

		public int getInsuranceType() {
			return insuranceType;
		}

		public Order setInsuranceType(int insuranceType) {
			this.insuranceType = insuranceType;
			return this;
		}

		public String getCarrier() {
			return carrier;
		}

		public Order setCarrier(String carrier) {
			this.carrier = carrier;
			return this;
		}

		public String getService() {
			return service;
		}

		public Order setService(String service) {
			this.service = service;
			return this;
		}

		public double getTotalPrice() {
			return totalPrice;
		}

		public Order setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
			return this;
		}

		public String getTotalPriceCurrency() {
			return totalPriceCurrency;
		}

		public Order setTotalPriceCurrency(String totalPriceCurrency) {
			this.totalPriceCurrency = totalPriceCurrency;
			return this;
		}

		public String getBookedBy() {
			return bookedBy;
		}

		public Order setBookedBy(String bookedBy) {
			this.bookedBy = bookedBy;
			return this;
		}

		public String getPackageType() {
			return packageType;
		}

		public Order setPackageType(String packageType) {
			this.packageType = packageType;
			return this;
		}
	}

	public ClaimDTO getClaimDto() {
		return claimDto;
	}

	public CSClaimDTO setClaimDto(ClaimDTO claimDto) {
		this.claimDto = claimDto;
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public CSClaimDTO setOrder(Order order) {
		this.order = order;
		return this;
	}
	
}

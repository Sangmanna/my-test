package com.freightcom.clickship.model.dashboard;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.CommonDTO;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CsDashboardDataDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = 4917019555656266793L;
	
	private String orderId;
	
	private String shipmentId;
	
	private String orderNumber;
	
	private String size;
	
	private Date shipDate;
	
	private Float shippingCost;
	
	private String serviceType;
	
	private String trackingURL;
	
	private String packageStatus;
	
	private String trackingNumber;
	
	private String shipmentStatus;
	
	private String shiptoAttention;
	
	private Boolean isActiveShipment;
	
	private String storeType;
	
	private String storeAlias;
	
	private String marketplaceId;
	
	private boolean useBrandingTracking;

	private String shipmentType;

	public String getOrderId() {
		return orderId;
	}

	public CsDashboardDataDTO setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public CsDashboardDataDTO setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public CsDashboardDataDTO setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public String getSize() {
		return size;
	}

	public CsDashboardDataDTO setSize(String size) {
		this.size = size;
		return this;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public CsDashboardDataDTO setShipDate(Date shipDate) {
		this.shipDate = shipDate;
		return this;
	}

	public Float getShippingCost() {
		return shippingCost;
	}

	public CsDashboardDataDTO setShippingCost(Float shippingCost) {
		this.shippingCost = shippingCost;
		return this;
	}

	public String getServiceType() {
		return serviceType;
	}

	public CsDashboardDataDTO setServiceType(String serviceType) {
		this.serviceType = serviceType;
		return this;
	}

	public String getTrackingURL() {
		return trackingURL;
	}

	public CsDashboardDataDTO setTrackingURL(String trackingURL) {
		this.trackingURL = trackingURL;
		return this;
	}

	public String getPackageStatus() {
		return packageStatus;
	}

	public CsDashboardDataDTO setPackageStatus(String packageStatus) {
		this.packageStatus = packageStatus;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public CsDashboardDataDTO setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public CsDashboardDataDTO setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
		return this;
	}

	public String getShiptoAttention() {
		return shiptoAttention;
	}

	public CsDashboardDataDTO setShiptoAttention(String shiptoAttention) {
		this.shiptoAttention = shiptoAttention;
		return this;
	}

	public Boolean getIsActiveShipment() {
		return isActiveShipment;
	}

	public CsDashboardDataDTO setIsActiveShipment(Boolean isActiveShipment) {
		this.isActiveShipment = isActiveShipment;
		return this;
	}

	public String getStoreType() {
		return storeType;
	}

	public CsDashboardDataDTO setStoreType(String storeType) {
		this.storeType = storeType;
		return this;
	}

	public String getStoreAlias() {
		return storeAlias;
	}

	public CsDashboardDataDTO setStoreAlias(String storeAlias) {
		this.storeAlias = storeAlias;
		return this;
	}

	public String getMarketplaceId() {
		return marketplaceId;
	}

	public CsDashboardDataDTO setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
		return this;
	}

	public boolean isUseBrandingTracking() {
		return useBrandingTracking;
	}

	public CsDashboardDataDTO setUseBrandingTracking(boolean useBrandingTracking) {
		this.useBrandingTracking = useBrandingTracking;
		return this;
	}

	public String getShipmentType() {
		return shipmentType;
	}

	public CsDashboardDataDTO setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
		return this;
	}
	
}

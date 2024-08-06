package com.freightcom.clickship.model.marketplace.amazon.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PackageDetail {
	private String packageReferenceId;
    private String carrierCode;
    private String carrierName;
    private String shippingMethod;
    private String trackingNumber;
    private String shipDate;
    private String shipFromSupplySourceId;
    private List<ConfirmShipmentOrderItem> orderItems;
    
	public String getPackageReferenceId() {
		return packageReferenceId;
	}
	public void setPackageReferenceId(String packageReferenceId) {
		this.packageReferenceId = packageReferenceId;
	}
	public String getCarrierCode() {
		return carrierCode;
	}
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public String getShipFromSupplySourceId() {
		return shipFromSupplySourceId;
	}
	public void setShipFromSupplySourceId(String shipFromSupplySourceId) {
		this.shipFromSupplySourceId = shipFromSupplySourceId;
	}
	public List<ConfirmShipmentOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<ConfirmShipmentOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
    
    
}

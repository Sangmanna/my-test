package com.freightcom.clickship.model.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.tag.TagDTO;

public class MyOrderDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = -4140171033336005924L;
	
	private String orderId;
	
	private String customerId;

	private String parentOrderId;
	
	private String marketplaceName;
	
	private String aliasName;
	
	private String orderNumber;
	
	private Date orderDate;

	private Date shipDate;
	
	private String pickupId;
	
	private Date pickupDate;
	
	private Date pickupTime;
	
	private Date closingTime;
	
	private String pickupLocation;
	
	private String confirmationNumber;
	
	private String serviceType;
	
	private String shippingCurrency;
	
	private String costCurrency;
	
	private String shiptoEmail;
	
	private boolean isFreightcomShipping;
	
	private Integer isInternationalShipment;
	
	private boolean hasReturnLabel;
	
	private boolean hasManifestId;
	
	private String manifestId;
	
	private String businessName;
	
	private Integer insuranceType;
	
	private Double insuranceAmount;
	
	private String freightcomOrderId;
	
	private boolean allowPendingFulfillment = false;

	//////////////////////////////////////////////////////////////////////////////////////////

	private String marketplaceId;
	
	private String toName;
	
	private String toAttention;
	
	private String toAddress1;
	
	private String toAddress2;
	
	private String toPostalCode;
	
	private String toPhone;
	
	private String toEmail;
	
	private String toCity;
	
	private String toProvinceState;
	
	private String toCountry;
	
	private String fromName;
	
	private String fromAttention;
	
	private String fromAddress1;
	
	private String fromAddress2;
	
	private String fromPostalCode;
	
	private String fromPhone;
	
	private String fromEmail;
	
	private String fromCity;
	
	private String fromProvinceState;
	
	private String fromCountry;
	
	private Integer productCnt;
	
	private double orderTotal;
	
	private String carrierId;
	
	private String carrierServiceId;
	
	private String trackingNumber;
	
	private String trackingURL;
	
	private double shippingCost;

	private String shipmentId;
	
	private String status;
	
	private String orderRelType;
	
	private boolean showPickupOption;
	
	private boolean isAmazonShipmentIntervalExpired;
	
	private String notes;
	
	private boolean hasComments;
	
	private boolean palletOrder = false;
	
	private String shipmentStatus;
	
	private String shipmentStatusDescription;
	
	private boolean reshcedulePickUp;

	private String batchId;

	private String batchNumber;
	
	private List<TagDTO> tagDtoList = new ArrayList<>();

	private String sku;
	
	private String title;
	
	private String quantity;
	
	private Double gst;
	
	private Double hst;
	
	private Double other;
	
	private boolean signatureRequired;
	
	private boolean adultSignatureRequired;
	
	private boolean residentialDelivery;
	
	private String fromCompany;
	
	private boolean isActive;
	
	private String referenceCode1;
	
	private String referenceCode2;
	
	private String referenceCode3;
	
	private boolean rtrFetched;
	
	private String csNotes;
	
	private Date externallyFulfilledDate;
	
	private String marketplaceTypeId;
	
	private boolean autoFulfilled;
	
	private Boolean isShippingRuleInProgress = false;

	public Date getExternallyFulfilledDate() {
		return externallyFulfilledDate;
	}

	public MyOrderDTO setExternallyFulfilledDate(Date externallyFulfilledDate) {
		this.externallyFulfilledDate = externallyFulfilledDate;
		return this;
	}

	public String getCsNotes() {
		return csNotes;
	}

	public MyOrderDTO setCsNotes(String csNotes) {
		this.csNotes = csNotes;
		return this;
	}

	public boolean isRtrFetched() {
		return rtrFetched;
	}

	public MyOrderDTO setRtrFetched(boolean rtrFetched) {
		this.rtrFetched = rtrFetched;
		return this;
	}

	public String getReferenceCode1() {
		return referenceCode1;
	}

	public MyOrderDTO setReferenceCode1(String referenceCode1) {
		this.referenceCode1 = referenceCode1;
		return this;
	}

	public String getReferenceCode2() {
		return referenceCode2;
	}

	public MyOrderDTO setReferenceCode2(String referenceCode2) {
		this.referenceCode2 = referenceCode2;
		return this;
	}

	public String getReferenceCode3() {
		return referenceCode3;
	}

	public MyOrderDTO setReferenceCode3(String referenceCode3) {
		this.referenceCode3 = referenceCode3;
		return this;
	}

	public boolean isActive() {
		return isActive;
	}

	public MyOrderDTO setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public String getFromCompany() {
		return fromCompany;
	}

	public MyOrderDTO setFromCompany(String fromCompany) {
		this.fromCompany = fromCompany;
		return this;
	}

	public boolean isSignatureRequired() {
		return signatureRequired;
	}

	public MyOrderDTO setSignatureRequired(boolean signatureRequired) {
		this.signatureRequired = signatureRequired;
		return this;
	}

	public boolean isAdultSignatureRequired() {
		return adultSignatureRequired;
	}

	public MyOrderDTO setAdultSignatureRequired(boolean adultSignatureRequired) {
		this.adultSignatureRequired = adultSignatureRequired;
		return this;
	}

	public boolean isResidentialDelivery() {
		return residentialDelivery;
	}

	public MyOrderDTO setResidentialDelivery(boolean residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
		return this;
	}

	public Double getGst() {
		return gst;
	}

	public MyOrderDTO setGst(Double gst) {
		this.gst = gst;
		return this;
	}

	public Double getHst() {
		return hst;
	}

	public MyOrderDTO setHst(Double hst) {
		this.hst = hst;
		return this;
	}

	public Double getOther() {
		return other;
	}

	public MyOrderDTO setOther(Double other) {
		this.other = other;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public MyOrderDTO setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public MyOrderDTO setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getQuantity() {
		return quantity;
	}

	public MyOrderDTO setQuantity(String quantity) {
		this.quantity = quantity;
		return this;
	}

	public String getManifestId() {
		return manifestId;
	}

	public MyOrderDTO setManifestId(String manifestId) {
		this.manifestId = manifestId;
		return this;
	}

	public String getOrderId() {
		return orderId;
	}

	public MyOrderDTO setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getParentOrderId() {
		return parentOrderId;
	}

	public MyOrderDTO setParentOrderId(String parentOrderId) {
		this.parentOrderId = parentOrderId;
		return this;
	}

	public String getCustomerId() {
		return customerId;
	}

	public MyOrderDTO setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public MyOrderDTO setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public MyOrderDTO setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public String getToName() {
		return toName;
	}

	public MyOrderDTO setToName(String toName) {
		this.toName = toName;
		return this;
	}

	public String getToCity() {
		return toCity;
	}

	public MyOrderDTO setToCity(String toCity) {
		this.toCity = toCity;
		return this;
	}

	public Integer getProductCnt() {
		return productCnt;
	}

	public MyOrderDTO setProductCnt(Integer productCnt) {
		this.productCnt = productCnt;
		return this;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public MyOrderDTO setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
		return this;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public MyOrderDTO setShipDate(Date shipDate) {
		this.shipDate = shipDate;
		return this;
	}

	public String getCarrierId() {
		return carrierId;
	}

	public MyOrderDTO setCarrierId(String carrierId) {
		this.carrierId = carrierId;
		return this;
	}

	public String getCarrierServiceId() {
		return carrierServiceId;
	}

	public MyOrderDTO setCarrierServiceId(String carrierServiceId) {
		this.carrierServiceId = carrierServiceId;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public MyOrderDTO setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public String getTrackingURL() {
		return trackingURL;
	}

	public MyOrderDTO setTrackingURL(String trackingURL) {
		this.trackingURL = trackingURL;
		return this;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public MyOrderDTO setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public MyOrderDTO setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getMarketplaceId() {
		return marketplaceId;
	}

	public MyOrderDTO setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
		return this;
	}

	public String getToAddress1() {
		return toAddress1;
	}

	public MyOrderDTO setToAddress1(String toAddress1) {
		this.toAddress1 = toAddress1;
		return this;
	}

	public String getToAddress2() {
		return toAddress2;
	}

	public MyOrderDTO setToAddress2(String toAddress2) {
		this.toAddress2 = toAddress2;
		return this;
	}

	public String getToPostalCode() {
		return toPostalCode;
	}

	public MyOrderDTO setToPostalCode(String toPostalCode) {
		this.toPostalCode = toPostalCode;
		return this;
	}

	public String getToPhone() {
		return toPhone;
	}

	public MyOrderDTO setToPhone(String toPhone) {
		this.toPhone = toPhone;
		return this;
	}

	public String getToEmail() {
		return toEmail;
	}

	public MyOrderDTO setToEmail(String toEmail) {
		this.toEmail = toEmail;
		return this;
	}

	public String getToAttention() {
		return toAttention;
	}

	public MyOrderDTO setToAttention(String toAttention) {
		this.toAttention = toAttention;
		return this;
	}

	public String getToProvinceState() {
		return toProvinceState;
	}

	public MyOrderDTO setToProvinceState(String toProvinceState) {
		this.toProvinceState = toProvinceState;
		return this;
	}

	public String getToCountry() {
		return toCountry;
	}

	public MyOrderDTO setToCountry(String toCountry) {
		this.toCountry = toCountry;
		return this;
	}

	public String getFromName() {
		return fromName;
	}

	public MyOrderDTO setFromName(String fromName) {
		this.fromName = fromName;
		return this;
	}

	public String getFromAttention() {
		return fromAttention;
	}

	public MyOrderDTO setFromAttention(String fromAttention) {
		this.fromAttention = fromAttention;
		return this;
	}

	public String getFromAddress1() {
		return fromAddress1;
	}

	public MyOrderDTO setFromAddress1(String fromAddress1) {
		this.fromAddress1 = fromAddress1;
		return this;
	}

	public String getFromAddress2() {
		return fromAddress2;
	}

	public MyOrderDTO setFromAddress2(String fromAddress2) {
		this.fromAddress2 = fromAddress2;
		return this;
	}

	public String getFromPostalCode() {
		return fromPostalCode;
	}

	public MyOrderDTO setFromPostalCode(String fromPostalCode) {
		this.fromPostalCode = fromPostalCode;
		return this;
	}

	public String getFromPhone() {
		return fromPhone;
	}

	public MyOrderDTO setFromPhone(String fromPhone) {
		this.fromPhone = fromPhone;
		return this;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public MyOrderDTO setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
		return this;
	}

	public String getFromCity() {
		return fromCity;
	}

	public MyOrderDTO setFromCity(String fromCity) {
		this.fromCity = fromCity;
		return this;
	}

	public String getFromProvinceState() {
		return fromProvinceState;
	}

	public MyOrderDTO setFromProvinceState(String fromProvinceState) {
		this.fromProvinceState = fromProvinceState;
		return this;
	}

	public String getFromCountry() {
		return fromCountry;
	}

	public MyOrderDTO setFromCountry(String fromCountry) {
		this.fromCountry = fromCountry;
		return this;
	}

	public String getMarketplaceName() {
		return marketplaceName;
	}

	public MyOrderDTO setMarketplaceName(String marketplaceName) {
		this.marketplaceName = marketplaceName;
		return this;
	}

	public String getAliasName() {
		return aliasName;
	}

	public MyOrderDTO setAliasName(String aliasName) {
		this.aliasName = aliasName;
		return this;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public MyOrderDTO setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
		return this;
	}

	public String getPickupId() {
		return pickupId;
	}

	public MyOrderDTO setPickupId(String pickupId) {
		this.pickupId = pickupId;
		return this;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public MyOrderDTO setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
		return this;
	}

	public Date getPickupTime() {
		return pickupTime;
	}

	public MyOrderDTO setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
		return this;
	}

	public Date getClosingTime() {
		return closingTime;
	}

	public MyOrderDTO setClosingTime(Date closingTime) {
		this.closingTime = closingTime;
		return this;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public MyOrderDTO setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
		return this;
	}

	public String getShippingCurrency() {
		return shippingCurrency;
	}

	public MyOrderDTO setShippingCurrency(String shippingCurrency) {
		this.shippingCurrency = shippingCurrency;
		return this;
	}

	public String getCostCurrency() {
		return costCurrency;
	}

	public MyOrderDTO setCostCurrency(String costCurrency) {
		this.costCurrency = costCurrency;
		return this;
	}

	public String getServiceType() {
		return serviceType;
	}

	public MyOrderDTO setServiceType(String serviceType) {
		this.serviceType = serviceType;
		return this;
	}

	public String getShiptoEmail() {
		return shiptoEmail;
	}

	public MyOrderDTO setShiptoEmail(String shiptoEmail) {
		this.shiptoEmail = shiptoEmail;
		return this;
	}

	public boolean isFreightcomShipping() {
		return isFreightcomShipping;
	}

	public MyOrderDTO setFreightcomShipping(boolean isFreightcomShipping) {
		this.isFreightcomShipping = isFreightcomShipping;
		return this;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public MyOrderDTO setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
		return this;
	}

	public Integer getIsInternationalShipment() {
		return isInternationalShipment;
	}

	public MyOrderDTO setIsInternationalShipment(Integer isInternationalShipment) {
		this.isInternationalShipment = isInternationalShipment;
		return this;
	}

	public boolean isHasReturnLabel() {
		return hasReturnLabel;
	}

	public MyOrderDTO setHasReturnLabel(boolean hasReturnLabel) {
		this.hasReturnLabel = hasReturnLabel;
		return this;
	}

	public Boolean getHasManifestId() {
		return hasManifestId;
	}

	public MyOrderDTO setHasManifestId(Boolean hasManifestId) {
		this.hasManifestId = hasManifestId;
		return this;
	}

	public String getBusinessName() {
		return businessName;
	}

	public MyOrderDTO setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}

	public Integer getInsuranceType() {
		return insuranceType;
	}

	public MyOrderDTO setInsuranceType(Integer insuranceType) {
		this.insuranceType = insuranceType;
		return this;
	}

	public Double getInsuranceAmount() {
		return insuranceAmount;
	}

	public MyOrderDTO setInsuranceAmount(Double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
		return this;
	}

	public String getFreightcomOrderId() {
		return freightcomOrderId;
	}

	public MyOrderDTO setFreightcomOrderId(String freightcomOrderId) {
		this.freightcomOrderId = freightcomOrderId;
		if (!StringUtils.isEmpty(freightcomOrderId))
			this.isFreightcomShipping = true;
		return this;
	}

	public boolean isAllowPendingFulfillment() {
		return allowPendingFulfillment;
	}

	public MyOrderDTO setAllowPendingFulfillment(boolean allowPendingFulfillment) {
		this.allowPendingFulfillment = allowPendingFulfillment;
		return this;
	}

	public String getOrderRelType() {
		return orderRelType;
	}

	public MyOrderDTO setOrderRelType(String orderRelType) {
		this.orderRelType = orderRelType;
		return this;
	}

	public boolean isShowPickupOption() {
		return showPickupOption;
	}

	public MyOrderDTO setShowPickupOption(boolean showPickupOption) {
		this.showPickupOption = showPickupOption;
		return this;
	}

	public boolean isAmazonShipmentIntervalExpired() {
		return isAmazonShipmentIntervalExpired;
	}

	public MyOrderDTO setAmazonShipmentIntervalExpired(boolean isAmazonShipmentIntervalExpired) {
		this.isAmazonShipmentIntervalExpired = isAmazonShipmentIntervalExpired;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public MyOrderDTO setNotes(String notes) {
		this.notes = notes;
		return this;
	}
	public boolean isHasComments() {
		return hasComments;
	}

	public MyOrderDTO setHasComments(boolean hasComments) {
		this.hasComments = hasComments;
		return this;
	}

	public boolean isPalletOrder() {
		return palletOrder;
	}

	public void setPalletOrder(boolean palletOrder) {
		this.palletOrder = palletOrder;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public MyOrderDTO setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
		return this;
	}

	public String getShtipmentStatusDescripttion() {
		return shipmentStatusDescription;
	}

	public MyOrderDTO shipmentStatusDescription(String shipmentStatusDescription) {
		this.shipmentStatusDescription = shipmentStatusDescription;
		return this;
	}

	public boolean isReshcedulePickUp() {
		return reshcedulePickUp;
	}

	public MyOrderDTO setReshcedulePickUp(boolean reshcedulePickUp) {
		this.reshcedulePickUp = reshcedulePickUp;
		return this;
	}

	public String getBatchId() {
		return batchId;
	}

	public MyOrderDTO setBatchId(String batchId) {
		this.batchId = batchId;
		return this;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public MyOrderDTO setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
		return this;
	}

	public List<TagDTO> getTagDtoList() {
		return tagDtoList;
	}

	public void setTagDtoList(List<TagDTO> tagDtoList) {
		this.tagDtoList = tagDtoList;
	}

	public String getMarketplaceTypeId() {
		return marketplaceTypeId;
	}

	public MyOrderDTO setMarketplaceTypeId(String marketplaceTypeId) {
		this.marketplaceTypeId = marketplaceTypeId;
		return this;
	}

	public boolean isAutoFulfilled() {
		return autoFulfilled;
	}

	public MyOrderDTO setAutoFulfilled(boolean autoFulfilled) {
		this.autoFulfilled = autoFulfilled;
		return this;
	}

	public Boolean getIsShippingRuleInProgress() {
		return isShippingRuleInProgress;
	}

	public MyOrderDTO setIsShippingRuleInProgress(Boolean isShippingRuleInProgress) {
		this.isShippingRuleInProgress = isShippingRuleInProgress;
		return this;
	}
	
}
package com.freightcom.clickship.model.custombranding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.enums.TrackingShipmentStatus;
import com.freightcom.clickship.model.shipment.TrackingInformationDTO;

public class BrandingV2TrackingPageDTO extends CommonDTO {
	
	private String shipmentStatus;
	
	private String trackingNumber;
	
	private String carrierShortName;
	
	private String carrierServiceName;
	
	private String originalTrackingUrl;
	
	private Date estimatedDeliveryDate;
	
	private BrandingV2DTO customBrandingDTO;
	
	private String shipmentStatusDescription;
	
	private List<Map<String, String>> orderLines = new ArrayList<>();
	
	private List<TrackingInformationDTO> shipmentTrackings = new ArrayList<>();
	
	private TrackingShipmentStatus trackingShipmentStatus = TrackingShipmentStatus.ORDER_PLACED;

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public BrandingV2TrackingPageDTO setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public BrandingV2TrackingPageDTO setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public String getCarrierShortName() {
		return carrierShortName;
	}

	public BrandingV2TrackingPageDTO setCarrierShortName(String carrierShortName) {
		this.carrierShortName = carrierShortName;
		return this;
	}

	public String getCarrierServiceName() {
		return carrierServiceName;
	}

	public BrandingV2TrackingPageDTO setCarrierServiceName(String carrierServiceName) {
		this.carrierServiceName = carrierServiceName;
		return this;
	}

	public String getOriginalTrackingUrl() {
		return originalTrackingUrl;
	}

	public BrandingV2TrackingPageDTO setOriginalTrackingUrl(String originalTrackingUrl) {
		this.originalTrackingUrl = originalTrackingUrl;
		return this;
	}

	public Date getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}

	public BrandingV2TrackingPageDTO setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
		return this;
	}

	public BrandingV2DTO getCustomBrandingDTO() {
		return customBrandingDTO;
	}

	public BrandingV2TrackingPageDTO setCustomBrandingDTO(BrandingV2DTO customBrandingDTO) {
		this.customBrandingDTO = customBrandingDTO;
		return this;
	}

	public String getShipmentStatusDescription() {
		return shipmentStatusDescription;
	}

	public BrandingV2TrackingPageDTO setShipmentStatusDescription(String shipmentStatusDescription) {
		this.shipmentStatusDescription = shipmentStatusDescription;
		return this;
	}

	public List<Map<String, String>> getOrderLines() {
		return orderLines;
	}

	public BrandingV2TrackingPageDTO setOrderLines(List<Map<String, String>> orderLines) {
		this.orderLines = orderLines;
		return this;
	}

	public List<TrackingInformationDTO> getShipmentTrackings() {
		return shipmentTrackings;
	}

	public BrandingV2TrackingPageDTO setShipmentTrackings(List<TrackingInformationDTO> shipmentTrackings) {
		this.shipmentTrackings = shipmentTrackings;
		return this;
	}

	public TrackingShipmentStatus getTrackingShipmentStatus() {
		return trackingShipmentStatus;
	}

	public BrandingV2TrackingPageDTO setTrackingShipmentStatus(TrackingShipmentStatus trackingShipmentStatus) {
		this.trackingShipmentStatus = trackingShipmentStatus;
		return this;
	}

}
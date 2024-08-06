package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsPackage implements Serializable {

	private static final long serialVersionUID = -55378186319086128L;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Dimensions")
	private UpsDimensions dimensions;

	@JsonProperty("PackageWeight")
	private UpsWeight packageWeight;

	@JsonProperty("Packaging")
	private CodeDescription packaging;

	@JsonProperty("PackageServiceOptions")
	private ServiceOptions serviceOptions;
	
	@JsonProperty("PackagingType")
	private CodeDescription packagingType;
	
	@JsonProperty("trackingNumber")
	private String trackingNumber;
	
	@JsonProperty("deliveryTime")
	private UpsDateAndTime deliveryTime;
	
	@JsonProperty("deliveryDate")
	private List<UpsDateAndTime> deliveryDate;
	
	@JsonProperty("activity")
	private List<UpsTrackingActivity> tracking;

	public String getDescription() {
		return description;
	}

	public UpsPackage setDescription(String description) {
		this.description = description;
		return this;
	}

	public UpsDimensions getDimensions() {
		return dimensions;
	}

	public UpsPackage setDimensions(UpsDimensions dimensions) {
		this.dimensions = dimensions;
		return this;
	}

	public UpsWeight getPackageWeight() {
		return packageWeight;
	}

	public UpsPackage setPackageWeight(UpsWeight packageWeight) {
		this.packageWeight = packageWeight;
		return this;
	}

	public CodeDescription getPackaging() {
		return packaging;
	}

	public UpsPackage setPackaging(CodeDescription packaging) {
		this.packaging = packaging;
		return this;
	}

	public CodeDescription getPackagingType() {
		return packagingType;
	}

	public UpsPackage setPackagingType(CodeDescription packagingType) {
		this.packagingType = packagingType;
		return this;
	}

	public ServiceOptions getServiceOptions() {
		return serviceOptions;
	}

	public UpsPackage setServiceOptions(ServiceOptions serviceOptions) {
		this.serviceOptions = serviceOptions;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public UpsPackage setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public UpsDateAndTime getDeliveryTime() {
		return deliveryTime;
	}

	public UpsPackage setDeliveryTime(UpsDateAndTime deliveryTime) {
		this.deliveryTime = deliveryTime;
		return this;
	}

	public List<UpsDateAndTime> getDeliveryDate() {
		return deliveryDate;
	}

	public UpsPackage setDeliveryDate(List<UpsDateAndTime> deliveryDate) {
		this.deliveryDate = deliveryDate;
		return this;
	}

	public List<UpsTrackingActivity> getTracking() {
		return tracking;
	}

	public UpsPackage setTracking(List<UpsTrackingActivity> tracking) {
		this.tracking = tracking;
		return this;
	}

}

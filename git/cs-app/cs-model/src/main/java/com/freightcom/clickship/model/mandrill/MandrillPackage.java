package com.freightcom.clickship.model.mandrill;

import java.io.Serializable;

public class MandrillPackage implements Serializable {
	
	private static final long serialVersionUID = -1680776006566090293L;

	private Integer boxNumber;
	
	private String boxDimensions;
	
	private String boxWeight;
	
	private String trackingURL;
	
	private String imageAltName;
	
	private String trackingNumber;
	
	private String carrierLabelUrl;

	public Integer getBoxNumber() {
		return boxNumber;
	}

	public MandrillPackage setBoxNumber(Integer boxNumber) {
		this.boxNumber = boxNumber;
		return this;
	}

	public String getBoxDimensions() {
		return boxDimensions;
	}

	public MandrillPackage setBoxDimensions(String boxDimensions) {
		this.boxDimensions = boxDimensions;
		return this;
	}

	public String getBoxWeight() {
		return boxWeight;
	}

	public MandrillPackage setBoxWeight(String boxWeight) {
		this.boxWeight = boxWeight;
		return this;
	}

	public String getTrackingURL() {
		return trackingURL;
	}

	public MandrillPackage setTrackingURL(String trackingURL) {
		this.trackingURL = trackingURL;
		return this;
	}

	public String getImageAltName() {
		return imageAltName;
	}

	public MandrillPackage setImageAltName(String imageAltName) {
		this.imageAltName = imageAltName;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public MandrillPackage setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public String getCarrierLabelUrl() {
		return carrierLabelUrl;
	}

	public MandrillPackage setCarrierLabelUrl(String carrierLabelUrl) {
		this.carrierLabelUrl = carrierLabelUrl;
		return this;
	}

}

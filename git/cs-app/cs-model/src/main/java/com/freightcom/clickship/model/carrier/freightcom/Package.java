package com.freightcom.clickship.model.carrier.freightcom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
public class Package {

	@XmlAttribute(name = "description")
	private String description;

	@XmlAttribute(name = "freightClass")
	private String freightClass;
	
	@XmlAttribute(name = "insuranceType")
	private String insuranceType;
	
	@XmlAttribute(name = "insuranceCurrency")
	private String insuranceCurrency;
	
	@XmlAttribute(name = "insuranceAmount")
	private String insuranceAmount;
	
	@XmlAttribute(name = "nmfcCode")
	private String nmfcCode;

	@XmlAttribute(name = "type")
	private String type;
	
	@XmlAttribute(name = "length")
	private String length;
	
	@XmlAttribute(name = "width")
	private String width;
	
	@XmlAttribute(name = "height")
	private String height;

	@XmlAttribute(name = "weight")
	private String weight;
	
	@XmlAttribute(name = "trackingNumber")
	private String trackingNumber;

	public String getDescription() {
		return description;
	}

	public Package setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getFreightClass() {
		return freightClass;
	}

	public Package setFreightClass(String freightClass) {
		this.freightClass = freightClass;
		return this;
	}
	
	public String getInsuranceType() {
		return insuranceType;
	}

	public Package setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
		return this;
	}
	
	public String getInsuranceCurrency() {
		return insuranceCurrency;
	}

	public Package setInsuranceCurrency(String insuranceCurrency) {
		this.insuranceCurrency = insuranceCurrency;
		return this;
	}

	public String getInsuranceAmount() {
		return insuranceAmount;
	}

	public Package setInsuranceAmount(String insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
		return this;
	}

	public String getNmfcCode() {
		return nmfcCode;
	}

	public Package setNmfcCode(String nmfcCode) {
		this.nmfcCode = nmfcCode;
		return this;
	}

	public String getType() {
		return type;
	}

	public Package setType(String type) {
		this.type = type;
		return this;
	}

	public String getLength() {
		return length;
	}

	public Package setLength(String length) {
		this.length = length;
		return this;
	}

	public String getWidth() {
		return width;
	}

	public Package setWidth(String width) {
		this.width = width;
		return this;
	}

	public String getHeight() {
		return height;
	}

	public Package setHeight(String height) {
		this.height = height;
		return this;
	}

	public String getWeight() {
		return weight;
	}

	public Package setWeight(String weight) {
		this.weight = weight;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public Package setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	@Override
	public String toString() {
		return "Package [trackingNumber=" + trackingNumber + "]";
	}
	
}

package com.freightcom.clickship.model.mandrill;

import java.io.Serializable;

public class MandrillPackageDetails implements Serializable {

	private static final long serialVersionUID = 8761855371703709294L;
	
	private String length;
	private String width;
	private String height;
	private String weight;
	private String freightClass;
	private String nmfcCode;
	private String type;
	private String pieces;
	private String description;
	
	public String getLength() {
		return length;
	}
	public MandrillPackageDetails setLength(String length) {
		this.length = length;
		return this;
	}
	public String getWidth() {
		return width;
	}
	public MandrillPackageDetails setWidth(String width) {
		this.width = width;
		return this;
	}
	public String getHeight() {
		return height;
	}
	public MandrillPackageDetails setHeight(String height) {
		this.height = height;
		return this;
	}
	public String getWeight() {
		return weight;
	}
	public MandrillPackageDetails setWeight(String weight) {
		this.weight = weight;
		return this;
	}
	public String getFreightClass() {
		return freightClass;
	}
	public MandrillPackageDetails setFreightClass(String freightClass) {
		this.freightClass = freightClass;
		return this;
	}
	public String getNmfcCode() {
		return nmfcCode;
	}
	public MandrillPackageDetails setNmfcCode(String nmfcCode) {
		this.nmfcCode = nmfcCode;
		return this;
	}
	public String getType() {
		return type;
	}
	public MandrillPackageDetails setType(String type) {
		this.type = type;
		return this;
	}
	public String getPieces() {
		return pieces;
	}
	public MandrillPackageDetails setPieces(String pieces) {
		this.pieces = pieces;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public MandrillPackageDetails setDescription(String description) {
		this.description = description;
		return this;
	}
	
}

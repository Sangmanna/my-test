package com.freightcom.clickship.model.orderscsv;

import java.util.ArrayList;
import java.util.List;

import com.freightcom.clickship.model.KeyValue;

public class CSVBoxesDTO {

	private String unitOfMeasurement;

	private String length;

	private String width;

	private String height;

	private String weight;

	private List<KeyValue> errorMsgs = new ArrayList<>();

	public List<KeyValue> getErrorMsgs() {
		return errorMsgs;
	}

	public CSVBoxesDTO setErrorMsgs(List<KeyValue> errorMsgs) {
		this.errorMsgs = errorMsgs;
		return this;
	}

	public void addErrorMsg(KeyValue errorMsg) {
		this.errorMsgs.add(errorMsg);
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}

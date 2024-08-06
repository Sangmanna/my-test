package com.freightcom.clickship.model.orderscsv;

import java.util.ArrayList;
import java.util.List;

import com.freightcom.clickship.model.KeyValue;

public class CSVOrderlineDTO {

	private String productName;

	private String description;

	private String SKU;

	private String quantity;

	private String price;

	private String currency;

	private String HSCode;

	private String countryOfOrigin;

	private String orderNotes;

	private List<KeyValue> errorMsgs = new ArrayList<>();

	public List<KeyValue> getErrorMsgs() {
		return errorMsgs;
	}

	public CSVOrderlineDTO setErrorMsgs(List<KeyValue> errorMsgs) {
		this.errorMsgs = errorMsgs;
		return this;
	}

	public void addErrorMsg(KeyValue errorMsg) {
		this.errorMsgs.add(errorMsg);
	}

	private List<CSVBoxesDTO> boxesDTO = new ArrayList<>();

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getHSCode() {
		return HSCode;
	}

	public void setHSCode(String hSCode) {
		HSCode = hSCode;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getOrderNotes() {
		return orderNotes;
	}

	public void setOrderNotes(String orderNotes) {
		this.orderNotes = orderNotes;
	}

	public List<CSVBoxesDTO> getBoxesDTO() {
		return boxesDTO;
	}

	public void setBoxesDTO(List<CSVBoxesDTO> boxesDTO) {
		this.boxesDTO = boxesDTO;
	}

}

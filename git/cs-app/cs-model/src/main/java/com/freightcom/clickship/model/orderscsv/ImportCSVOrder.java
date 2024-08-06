package com.freightcom.clickship.model.orderscsv;

import java.util.List;

public class ImportCSVOrder {

	private String orderId;
	private CSVAddressDTO addressDto;
	private List<CSVOrderlineDTO> orderLineDTO;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public CSVAddressDTO getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(CSVAddressDTO addressDto) {
		this.addressDto = addressDto;
	}

	public List<CSVOrderlineDTO> getOrderLineDTO() {
		return orderLineDTO;
	}

	public void setOrderLineDTO(List<CSVOrderlineDTO> orderLineDTO) {
		this.orderLineDTO = orderLineDTO;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}

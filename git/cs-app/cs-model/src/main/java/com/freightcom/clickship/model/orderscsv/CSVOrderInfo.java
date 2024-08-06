package com.freightcom.clickship.model.orderscsv;

import java.util.ArrayList;
import java.util.List;

public class CSVOrderInfo {

	private CSVAddressDTO addressDto;

	private List<CSVOrderlineDTO> orderLineDto = new ArrayList<CSVOrderlineDTO>();

	public CSVAddressDTO getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(CSVAddressDTO addressDto) {
		this.addressDto = addressDto;
	}

	public List<CSVOrderlineDTO> getOrderLineDto() {
		return orderLineDto;
	}

	public void setOrderLineDto(List<CSVOrderlineDTO> orderLineDto) {
		this.orderLineDto = orderLineDto;
	}

	

}

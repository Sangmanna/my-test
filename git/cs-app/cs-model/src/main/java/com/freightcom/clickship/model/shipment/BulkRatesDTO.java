package com.freightcom.clickship.model.shipment;

import java.util.List;

import com.freightcom.clickship.model.box.BoxDTO;
import com.freightcom.clickship.model.rates.RateDTO;

public class BulkRatesDTO {

	private String orderId;
	
	private List<BoxDTO> boxes;
	
	private List<RateDTO> rateList;

	public String getOrderId() {
		return orderId;
	}

	public BulkRatesDTO setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}

	public List<RateDTO> getRateList() {
		return rateList;
	}

	public BulkRatesDTO setRateList(List<RateDTO> rateList) {
		this.rateList = rateList;
		return this;
	}

	public List<BoxDTO> getBoxes() {
		return boxes;
	}

	public BulkRatesDTO setBoxes(List<BoxDTO> boxes) {
		this.boxes = boxes;
		return this;
	}

}

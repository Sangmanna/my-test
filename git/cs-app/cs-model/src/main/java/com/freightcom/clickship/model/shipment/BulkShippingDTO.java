package com.freightcom.clickship.model.shipment;

import java.util.ArrayList;
import java.util.List;

import com.freightcom.clickship.model.customer.CustomerAddressDTO;
import com.freightcom.clickship.model.order.OrderDTO;
import com.freightcom.clickship.model.order.OrderlineDTO;
import com.freightcom.clickship.model.rates.RateDTO;

public class BulkShippingDTO {

	private OrderDTO orderDTO;
	
	private List<RateDTO> rateList;
	
	private List<OrderlineDTO> orderlines;

	private String batchId;
	
	private String batchNumber;
	
	private RateDTO ratesAtCheckout;
	
	private List<OrderDTO> ordersDto;

	// old bulk shipping fields
	private RateDTO preSelectedRate;
	
	private CustomerAddressDTO defaultShipFormAddress;

	public OrderDTO getOrderDTO() {
		return orderDTO;
	}

	public BulkShippingDTO setOrderDTO(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
		return this;
	}

	public List<RateDTO> getRateList() {
		return rateList;
	}

	public BulkShippingDTO setRateList(List<RateDTO> rateList) {
		this.rateList = rateList;
		return this;
	}

	public List<OrderlineDTO> getOrderlines() {
		return orderlines;
	}

	public BulkShippingDTO setOrderlines(List<OrderlineDTO> orderlines) {
		this.orderlines = orderlines;
		return this;
	}

	public String getBatchId() {
		return batchId;
	}

	public BulkShippingDTO setBatchId(String batchId) {
		this.batchId = batchId;
		return this;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public BulkShippingDTO setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
		return this;
	}

	public RateDTO getRatesAtCheckout() {
		return ratesAtCheckout;
	}

	public BulkShippingDTO setRatesAtCheckout(RateDTO ratesAtCheckout) {
		this.ratesAtCheckout = ratesAtCheckout;
		return this;
	}

	public List<OrderDTO> getOrdersDto() {
		return ordersDto;
	}

	public BulkShippingDTO setOrdersDto(List<OrderDTO> ordersDto) {
		this.ordersDto = ordersDto;
		return this;
	}

	public RateDTO getPreSelectedRate() {
		return preSelectedRate;
	}

	public BulkShippingDTO setPreSelectedRate(RateDTO preSelectedRate) {
		this.preSelectedRate = preSelectedRate;
		return this;
	}

	public CustomerAddressDTO getDefaultShipFormAddress() {
		return defaultShipFormAddress;
	}

	public BulkShippingDTO setDefaultShipFormAddress(CustomerAddressDTO defaultShipFormAddress) {
		this.defaultShipFormAddress = defaultShipFormAddress;
		return this;
	}
	
	public void addRate(RateDTO rateDTO) {
		if(rateList == null) {
			rateList =  new ArrayList<>(); 		
		}
		
		this.rateList.add(rateDTO);
	}
}

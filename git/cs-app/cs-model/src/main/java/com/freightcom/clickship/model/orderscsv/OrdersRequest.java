package com.freightcom.clickship.model.orderscsv;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class OrdersRequest extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = 2970228996741741726L;

	private Boolean includeShiptoShipment = true;
	private Boolean includeShiptoOrder = true;
	private Boolean includeBilltoOrder = true;
	private Boolean includeShipfromShipment = true;
	private Boolean includeOrderLines = false;
	private Boolean includeShippingOptions = true; 
	private Boolean includeShippingDetails = true; 
	private Boolean includePrices = true; 
	private Boolean includeDates = true; 
	
	private String fromDate;
	private String toDate;
	private String status;
	private String customerId;
	private String carrierName;
	private String carrierAccount;
	private String carrierService;
	
	public Boolean includesShiptoShipment() {
		return includeShiptoShipment;
	}
	public OrdersRequest setIncludeShiptoShipment(Boolean includeShiptoShipment) {
		this.includeShiptoShipment = includeShiptoShipment;
		return this;
	}
	public Boolean includesShiptoOrder() {
		return includeShiptoOrder;
	}
	public OrdersRequest setIncludeShiptoOrder(Boolean includeShiptoOrder) {
		this.includeShiptoOrder = includeShiptoOrder;
		return this;
	}
	public Boolean includesBilltoOrder() {
		return includeBilltoOrder;
	}
	public OrdersRequest setIncludeBilltoOrder(Boolean includeBilltoOrder) {
		this.includeBilltoOrder = includeBilltoOrder;
		return this;
	}
	public Boolean includesShipfromShipment() {
		return includeShipfromShipment;
	}
	public OrdersRequest setIncludeShipfromShipment(Boolean includeShipfromShipment) {
		this.includeShipfromShipment = includeShipfromShipment;
		return this;
	}
	public Boolean includesOrderLines() {
		return includeOrderLines;
	}
	public OrdersRequest setIncludeOrderLines(Boolean includeOrderLines) {
		this.includeOrderLines = includeOrderLines;
		return this;
	}
	public Boolean includesShippingOptions() {
		return includeShippingOptions;
	}
	public OrdersRequest setIncludeShippingOptions(Boolean includeShippingOptions) {
		this.includeShippingOptions = includeShippingOptions;
		return this;
	}
	public Boolean includesShippingDetails() {
		return includeShippingDetails;
	}
	public OrdersRequest setIncludeShippingDetails(Boolean includeShippingDetails) {
		this.includeShippingDetails = includeShippingDetails;
		return this;
	}
	public Boolean includesPrices() {
		return includePrices;
	}
	public OrdersRequest setIncludePrices(Boolean includePrices) {
		this.includePrices = includePrices;
		return this;
	}
	public Boolean includesDates() {
		return includeDates;
	}
	public OrdersRequest setIncludeDates(Boolean includeDates) {
		this.includeDates = includeDates;
		return this;
	}
	public String getFromDate() {
		return fromDate;
	}
	public OrdersRequest setFromDate(String fromDate) {
		this.fromDate = fromDate;
		return this;
	}
	public String getToDate() {
		return toDate;
	}
	public OrdersRequest setToDate(String toDate) {
		this.toDate = toDate;
		return this;
	}
	public String getStatus() {
		return status;
	}
	public OrdersRequest setStatus(String status) {
		this.status = status;
		return this;
	}
	public String getCustomerId() {
		return customerId;
	}
	public OrdersRequest setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public OrdersRequest setCarrierName(String carrierName) {
		this.carrierName = carrierName;
		return this;
	}
	public String getCarrierAccount() {
		return carrierAccount;
	}
	public OrdersRequest setCarrierAccount(String carrierAccount) {
		this.carrierAccount = carrierAccount;
		return this;
	}
	public String getCarrierService() {
		return carrierService;
	}
	public OrdersRequest setCarrierService(String carrierService) {
		this.carrierService = carrierService;
		return this;
	}	
}


package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "ShipFrom",
    "ShipTo",
    "PickupDate",
    "ShipmentWeight",
    "InvoiceLineTotal",
    "MaximumListSize",
    "ServiceSummary",
    "AutoDutyCode",
    "Disclaimer"
})
public class TransitResponse implements Serializable {

	private static final long serialVersionUID = -5733813698845701784L;

	@JsonProperty("PickupDate")
    private String pickupDate;
	
	@JsonProperty("PackageBillType")
    private String packageBillType;
	
	@JsonProperty("AutoDutyCode")
    private String autoDutyCode;
	
	@JsonProperty("Disclaimer")
    private String disclaimer;
	
	@JsonProperty("ServiceSummary")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<ServiceSummary> serviceSummary = null;
	
	@JsonProperty("ShipFrom")
    private UpsShipper shipFrom;
    
	@JsonProperty("ShipTo")
    private UpsShipper shipTo;
    
	@JsonProperty("ShipmentWeight")
    private UpsWeight shipmentWeight;
    
	@JsonProperty("InvoiceLineTotal")
    private UpsMoney invoiceLineTotal;
    
	@JsonProperty("MaximumListSize")
    private String maximumListSize;
  
	public UpsShipper getShipFrom() {
		return shipFrom;
	}

	public TransitResponse setShipFrom(UpsShipper shipFrom) {
		this.shipFrom = shipFrom;
		return this;
	}

	public UpsShipper getShipTo() {
		return shipTo;
	}

	public TransitResponse setShipTo(UpsShipper shipTo) {
		this.shipTo = shipTo;
		return this;
	}

	public String getPickupDate() {
		return pickupDate;
	}

	public TransitResponse setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
		return this;
	}

	public UpsWeight getShipmentWeight() {
		return shipmentWeight;
	}

	public TransitResponse setShipmentWeight(UpsWeight shipmentWeight) {
		this.shipmentWeight = shipmentWeight;
		return this;
	}

	public UpsMoney getInvoiceLineTotal() {
		return invoiceLineTotal;
	}

	public TransitResponse setInvoiceLineTotal(UpsMoney invoiceLineTotal) {
		this.invoiceLineTotal = invoiceLineTotal;
		return this;
	}

	public String getMaximumListSize() {
		return maximumListSize;
	}

	public TransitResponse setMaximumListSize(String maximumListSize) {
		this.maximumListSize = maximumListSize;
		return this;
	}

	public List<ServiceSummary> getServiceSummary() {
		return serviceSummary;
	}

	public TransitResponse setServiceSummary(List<ServiceSummary> serviceSummary) {
		this.serviceSummary = serviceSummary;
		return this;
	}

	public String getAutoDutyCode() {
		return autoDutyCode;
	}

	public TransitResponse setAutoDutyCode(String autoDutyCode) {
		this.autoDutyCode = autoDutyCode;
		return this;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public TransitResponse setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
		return this;
	}
	
}

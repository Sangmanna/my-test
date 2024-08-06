package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)@JsonPropertyOrder({
    "Name",
    "AttentionName",
    "ShipperNumber",
    "Address"
})
public class UpsShipper implements Serializable {

	private static final long serialVersionUID = -5914597781342473627L;

	@JsonProperty("Name")
	private String name;
	
    @JsonProperty("AttentionName")
    private String attentionName;
    
  @JsonProperty("ShipperNumber")
    private String shipperNumber;
  
/*	@JsonProperty("Account")
	private UpsShipperAccount account;

    @JsonProperty("Phone")
    private UpsPhone phone;

    @JsonProperty("FaxNumber")
    private String faxNumber; */
    
	@JsonProperty("Address")
    private UpsAddress address;
	
//    @JsonProperty("TaxIdentificationNumber")
//    private String taxIdentificationNumber;

	public String getName() {
		return name;
	}

	public UpsShipper setName(String name) {
		this.name = name;
		return this;
	}

	public String getAttentionName() {
		return attentionName;
	}

	public UpsShipper setAttentionName(String attentionName) {
		this.attentionName = attentionName;
		return this;
	}
	
	public String getShipperNumber() {
		return shipperNumber;
	}

	public UpsShipper setShipperNumber(String shipperNumber) {
		this.shipperNumber = shipperNumber;
		return this;
	}

/*	public String getTaxIdentificationNumber() {
		return taxIdentificationNumber;
	}

	public UpsShipper setTaxIdentificationNumber(String taxIdentificationNumber) {
		this.taxIdentificationNumber = taxIdentificationNumber;
		return this;
	}
	
	public UpsPhone getPhone() {
		return phone;
	}

	public UpsShipper setPhone(UpsPhone phone) {
		this.phone = phone;
		return this;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public UpsShipper setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
		return this;
	} */

	public UpsAddress getAddress() {
		return address;
	}

	public UpsShipper setAddress(UpsAddress address) {
		this.address = address;
		return this;
	}

}

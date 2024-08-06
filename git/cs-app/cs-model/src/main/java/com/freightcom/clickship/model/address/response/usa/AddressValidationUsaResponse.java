
package com.freightcom.clickship.model.address.response.usa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.freightcom.clickship.model.CommonDTO;

import java.io.Serializable;


@JsonPropertyOrder({ "input_id", "input_index", "candidate_index", "delivery_line_1", "last_line",
		"delivery_point_barcode", "components", "metadata", "analysis", "addressee" })
public class AddressValidationUsaResponse extends CommonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6914859135354566727L;

	@JsonProperty("input_id")
	private String inputId;
	@JsonProperty("input_index")
	private Integer inputIndex;
	@JsonProperty("candidate_index")
	private Integer candidateIndex;
	@JsonProperty("delivery_line_1")
	private String deliveryLine1;
	@JsonProperty("delivery_line_2")
	private String deliveryLine2;
	@JsonProperty("last_line")
	private String lastLine;
	@JsonProperty("delivery_point_barcode")
	private String deliveryPointBarcode;
	@JsonProperty("components")
	private Components components;
	@JsonProperty("metadata")
	private Metadata metadata;
	@JsonProperty("analysis")
	private Analysis analysis;
	@JsonProperty("addressee")
	private String addressee;

	public Integer getInputIndex() {
		return inputIndex;
	}

	public AddressValidationUsaResponse setInputIndex(Integer inputIndex) {
		this.inputIndex = inputIndex;
		return this;
	}

	public String getInputId() {
		return inputId;
	}

	public AddressValidationUsaResponse setInputId(String inputId) {
		this.inputId = inputId;
		return this;
	}

	public Integer getCandidateIndex() {
		return candidateIndex;
	}

	public AddressValidationUsaResponse setCandidateIndex(Integer candidateIndex) {
		this.candidateIndex = candidateIndex;
		return this;
	}

	public String getDeliveryLine1() {
		return deliveryLine1;
	}

	public AddressValidationUsaResponse setDeliveryLine1(String deliveryLine1) {
		this.deliveryLine1 = deliveryLine1;
		return this;
	}

	public String getDeliveryLine2() {
		return deliveryLine2;
	}

	public AddressValidationUsaResponse setDeliveryLine2(String deliveryLine2) {
		this.deliveryLine2 = deliveryLine2;
		return this;
	}

	public String getLastLine() {
		return lastLine;
	}

	public AddressValidationUsaResponse setLastLine(String lastLine) {
		this.lastLine = lastLine;
		return this;
	}

	public String getDeliveryPointBarcode() {
		return deliveryPointBarcode;
	}

	public AddressValidationUsaResponse setDeliveryPointBarcode(String deliveryPointBarcode) {
		this.deliveryPointBarcode = deliveryPointBarcode;
		return this;
	}

	public Components getComponents() {
		return components;
	}

	public AddressValidationUsaResponse setComponents(Components components) {
		this.components = components;
		return this;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public AddressValidationUsaResponse setMetadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public Analysis getAnalysis() {
		return analysis;
	}

	public AddressValidationUsaResponse setAnalysis(Analysis analysis) {
		this.analysis = analysis;
		return this;
	}

	public String getAddressee() {
		return addressee;
	}

	public AddressValidationUsaResponse setAddressee(String addressee) {
		this.addressee = addressee;
		return this;
	}



}

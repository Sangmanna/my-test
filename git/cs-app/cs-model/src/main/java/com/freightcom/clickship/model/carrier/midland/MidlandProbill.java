package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
public class MidlandProbill {

	@JsonProperty("Pronumber")
	private String proNumber;
	
	@JsonProperty("EstDeliveryDate")
	private String estDeliveryDate;
	
	@JsonProperty("ShipmentDate")
	private String shipmentDate;
	
	@JsonProperty("BOLNumber")
	private String bolNumber;
	
	@JsonProperty("ServiceTypeDescTranslated")
	private String serviceTypeDescTranslated;
	
	@JsonProperty("OrigCityName")
	private String origCityName;
	
	@JsonProperty("OrigStateCode")
	private String origStateCode;

	@JsonProperty("OrigZipCode")
	private String origZipCode;
	
	@JsonProperty("DestCityName")
	private String destCityName;
	
	@JsonProperty("DestStateCode")
	private String destStateCode;
	
	@JsonProperty("DestZipCode")
	private String destZipCode;
	
	@JsonProperty("LifeCycleStatusDescTranslated")
	private String lifeCycleStatusDescTranslated;
	
	@JsonProperty("LifeCycleStatusDate")
	private String lifeCycleStatusDate;
	
	@JsonProperty("LifeCycleStatusTime")
	private String lifeCycleStatusTime;
	
	@JsonProperty("ExceptionStatus")
	private String exceptionStatus;
	
	@JsonProperty("ExceptionDate")
	private String exceptionDate;
	
	@JsonProperty("ExceptionTime")
	private String exceptionTime;
	
	@JsonProperty("ExceptionDescTranslated")
	private String exceptionDescTranslated;
	
	@JsonProperty("TotalWeightLbs")
	private double totalWeightLbs;
	
	@JsonProperty("TotalPieces")
	private int totalPieces;
	
	@JsonProperty("TrackingDetails")
	private List<TrackingDetails> trackingDetails;
	
	@JsonProperty("ProReference")
	private List<ProReference> proReferences;

	public String getProNumber() {
		return proNumber;
	}

	public void setProNumber(String proNumber) {
		this.proNumber = proNumber;
	}

	public String getEstDeliveryDate() {
		return estDeliveryDate;
	}

	public void setEstDeliveryDate(String estDeliveryDate) {
		this.estDeliveryDate = estDeliveryDate;
	}

	public String getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getBolNumber() {
		return bolNumber;
	}

	public void setBolNumber(String bolNumber) {
		this.bolNumber = bolNumber;
	}

	public String getServiceTypeDescTranslated() {
		return serviceTypeDescTranslated;
	}

	public void setServiceTypeDescTranslated(String serviceTypeDescTranslated) {
		this.serviceTypeDescTranslated = serviceTypeDescTranslated;
	}

	public String getOrigCityName() {
		return origCityName;
	}

	public void setOrigCityName(String origCityName) {
		this.origCityName = origCityName;
	}

	public String getOrigStateCode() {
		return origStateCode;
	}

	public void setOrigStateCode(String origStateCode) {
		this.origStateCode = origStateCode;
	}

	public String getOrigZipCode() {
		return origZipCode;
	}

	public void setOrigZipCode(String origZipCode) {
		this.origZipCode = origZipCode;
	}

	public String getDestCityName() {
		return destCityName;
	}

	public void setDestCityName(String destCityName) {
		this.destCityName = destCityName;
	}

	public String getDestStateCode() {
		return destStateCode;
	}

	public void setDestStateCode(String destStateCode) {
		this.destStateCode = destStateCode;
	}

	public String getDestZipCode() {
		return destZipCode;
	}

	public void setDestZipCode(String destZipCode) {
		this.destZipCode = destZipCode;
	}

	public String getLifeCycleStatusDescTranslated() {
		return lifeCycleStatusDescTranslated;
	}

	public void setLifeCycleStatusDescTranslated(String lifeCycleStatusDescTranslated) {
		this.lifeCycleStatusDescTranslated = lifeCycleStatusDescTranslated;
	}

	public String getLifeCycleStatusDate() {
		return lifeCycleStatusDate;
	}

	public void setLifeCycleStatusDate(String lifeCycleStatusDate) {
		this.lifeCycleStatusDate = lifeCycleStatusDate;
	}

	public String getLifeCycleStatusTime() {
		return lifeCycleStatusTime;
	}

	public void setLifeCycleStatusTime(String lifeCycleStatusTime) {
		this.lifeCycleStatusTime = lifeCycleStatusTime;
	}

	public String getExceptionStatus() {
		return exceptionStatus;
	}

	public void setExceptionStatus(String exceptionStatus) {
		this.exceptionStatus = exceptionStatus;
	}

	public String getExceptionDate() {
		return exceptionDate;
	}

	public void setExceptionDate(String exceptionDate) {
		this.exceptionDate = exceptionDate;
	}

	public String getExceptionTime() {
		return exceptionTime;
	}

	public void setExceptionTime(String exceptionTime) {
		this.exceptionTime = exceptionTime;
	}

	public String getExceptionDescTranslated() {
		return exceptionDescTranslated;
	}

	public void setExceptionDescTranslated(String exceptionDescTranslated) {
		this.exceptionDescTranslated = exceptionDescTranslated;
	}

	public double getTotalWeightLbs() {
		return totalWeightLbs;
	}

	public void setTotalWeightLbs(double totalWeightLbs) {
		this.totalWeightLbs = totalWeightLbs;
	}

	public int getTotalPieces() {
		return totalPieces;
	}

	public void setTotalPieces(int totalPieces) {
		this.totalPieces = totalPieces;
	}

	public List<TrackingDetails> getTrackingDetails() {
		return trackingDetails;
	}

	public void setTrackingDetails(List<TrackingDetails> trackingDetails) {
		this.trackingDetails = trackingDetails;
	}

	public List<ProReference> getProReferences() {
		return proReferences;
	}

	public void setProReferences(List<ProReference> proReferences) {
		this.proReferences = proReferences;
	}
}

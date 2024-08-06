package com.freightcom.clickship.model.v2.invoice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.v2.claim.DateRange;
import com.freightcom.clickship.model.v2.claim.SearchClaimRequest.CarrierService;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceSearchCriteria {

	@JsonProperty("category")
	private String category;

	@JsonProperty("date_range")
	private DateRange dateRange;

	@JsonProperty("paid_date_range")
	private DateRange paidDateRange;

	@JsonProperty("text")
	private String text;

	@JsonProperty("urgent_only")
	private Boolean urgentOnly = false;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("status")
	private String status;

	@JsonProperty("packaging_type")
	private String packagingType;

	@JsonProperty("user_id")
	private String userId;
	
	private List<CarrierService> carrierServiceIdsArray;

	public String getCategory() {
		return category;
	}

	public InvoiceSearchCriteria setCategory(String category) {
		this.category = category;
		return this;
	}

	public DateRange getDateRange() {
		return dateRange;
	}

	public InvoiceSearchCriteria setDateRange(DateRange dateRange) {
		this.dateRange = dateRange;
		return this;
	}

	public DateRange getPaidDateRange() {
		return paidDateRange;
	}

	public InvoiceSearchCriteria setPaidDateRange(DateRange paidDateRange) {
		this.paidDateRange = paidDateRange;
		return this;
	}

	public String getText() {
		return text;
	}

	public InvoiceSearchCriteria setText(String text) {
		this.text = text;
		return this;
	}

	public Boolean getUrgentOnly() {
		return urgentOnly;
	}

	public InvoiceSearchCriteria setUrgentOnly(Boolean urgentOnly) {
		this.urgentOnly = urgentOnly;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public InvoiceSearchCriteria setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public InvoiceSearchCriteria setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getPackagingType() {
		return packagingType;
	}

	public InvoiceSearchCriteria setPackagingType(String packagingType) {
		this.packagingType = packagingType;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public InvoiceSearchCriteria setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public List<CarrierService> getCarrierServiceIdsArray() {
		return carrierServiceIdsArray;
	}

	public InvoiceSearchCriteria setCarrierServiceIdsArray(List<CarrierService> carrierServiceIdsArray) {
		this.carrierServiceIdsArray = carrierServiceIdsArray;
		return this;
	}
	
}

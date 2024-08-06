package com.freightcom.clickship.data.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "prefetch_quote")
public class PrefetchQuotes extends BaseEntity {

	private static final long serialVersionUID = -1840353449059081011L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "order_id", nullable = true)
	@JsonIgnore
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prefetch_quote_request_id")
	@JsonIgnore
	private PrefetchQuoteRequest prefetchQuoteRequest;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prefetchQuotes", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PrefetchQuotesCharges> prefetchQuotesCharges;

	@Column(name = "service_id")
	private String serviceId;

	@Column(name = "short_name")
	private String shortName;
	
	@Column(name = "valid_until")
	private Date validUntil;
	
	@Column(name = "image_name")
	private String imageName;

	@Column(name = "estimated_date")
	private int estimatedDate;

	@Column(name = "carrier_rate")
	private boolean carrierRate = false;

	@Column(name = "carrier_name")
	private String carrierName;

	@Column(name = "carrier_service_name")
	private String carrierServiceName;

	@Column(name = "carrier_account_id")
	private String carrierAccountId;

	@Column(name = "carrier_account_number")
	private String carrierAccountNumber;

	@Column(name = "total_charge")
	private double totalCharge;

	@Column(name = "canadian_total_charge")
	private double canadianTotalCharge;

	@Column(name = "currency")
	private String currency;

	@Column(name = "note")
	private String note;

	@Column(name = "show_pickup_option")
	private boolean showPickupOption = true;

	@Column(name = "show_insurance_option")
	private boolean showInsuranceOption = true;

	@Column(name = "is_paperless_customs_invoice")
	private boolean isPaperlessCustomsInvoice = false;

	public String getId() {
		return id;
	}

	public PrefetchQuotes setId(String id) {
		this.id = id;
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public PrefetchQuotes setOrder(Order order) {
		this.order = order;
		return this;
	}

	public PrefetchQuoteRequest getPrefetchQuoteRequest() {
		return prefetchQuoteRequest;
	}

	public PrefetchQuotes setPrefetchQuoteRequest(PrefetchQuoteRequest prefetchQuoteRequest) {
		this.prefetchQuoteRequest = prefetchQuoteRequest;
		return this;
	}

	public List<PrefetchQuotesCharges> getPrefetchQuotesCharges() {
		return prefetchQuotesCharges;
	}

	public PrefetchQuotes setPrefetchQuotesCharges(List<PrefetchQuotesCharges> prefetchQuotesCharges) {
		this.prefetchQuotesCharges = prefetchQuotesCharges;
		return this;
	}

	public String getServiceId() {
		return serviceId;
	}

	public PrefetchQuotes setServiceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}
	
	public Date getValidUntil() {
		return validUntil;
	}

	public PrefetchQuotes setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
		return this;
	}

	public String getShortName() {
		return shortName;
	}

	public PrefetchQuotes setShortName(String shortName) {
		this.shortName = shortName;
		return this;
	}

	public String getImageName() {
		return imageName;
	}

	public PrefetchQuotes setImageName(String imageName) {
		this.imageName = imageName;
		return this;
	}

	public int getEstimatedDate() {
		return estimatedDate;
	}

	public PrefetchQuotes setEstimatedDate(int estimatedDate) {
		this.estimatedDate = estimatedDate;
		return this;
	}

	public boolean isCarrierRate() {
		return carrierRate;
	}

	public PrefetchQuotes setCarrierRate(boolean carrierRate) {
		this.carrierRate = carrierRate;
		return this;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public PrefetchQuotes setCarrierName(String carrierName) {
		this.carrierName = carrierName;
		return this;
	}

	public String getCarrierServiceName() {
		return carrierServiceName;
	}

	public PrefetchQuotes setCarrierServiceName(String carrierServiceName) {
		this.carrierServiceName = carrierServiceName;
		return this;
	}

	public String getCarrierAccountId() {
		return carrierAccountId;
	}

	public PrefetchQuotes setCarrierAccountId(String carrierAccountId) {
		this.carrierAccountId = carrierAccountId;
		return this;
	}

	public String getCarrierAccountNumber() {
		return carrierAccountNumber;
	}

	public PrefetchQuotes setCarrierAccountNumber(String carrierAccountNumber) {
		this.carrierAccountNumber = carrierAccountNumber;
		return this;
	}

	public double getTotalCharge() {
		return totalCharge;
	}

	public PrefetchQuotes setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
		return this;
	}

	public double getCanadianTotalCharge() {
		return canadianTotalCharge;
	}

	public PrefetchQuotes setCanadianTotalCharge(double canadianTotalCharge) {
		this.canadianTotalCharge = canadianTotalCharge;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public PrefetchQuotes setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getNote() {
		return note;
	}

	public PrefetchQuotes setNote(String note) {
		this.note = note;
		return this;
	}

	public boolean isShowPickupOption() {
		return showPickupOption;
	}

	public PrefetchQuotes setShowPickupOption(boolean showPickupOption) {
		this.showPickupOption = showPickupOption;
		return this;
	}

	public boolean isShowInsuranceOption() {
		return showInsuranceOption;
	}

	public PrefetchQuotes setShowInsuranceOption(boolean showInsuranceOption) {
		this.showInsuranceOption = showInsuranceOption;
		return this;
	}

	public boolean isPaperlessCustomsInvoice() {
		return isPaperlessCustomsInvoice;
	}

	public PrefetchQuotes setPaperlessCustomsInvoice(boolean isPaperlessCustomsInvoice) {
		this.isPaperlessCustomsInvoice = isPaperlessCustomsInvoice;
		return this;
	}

}

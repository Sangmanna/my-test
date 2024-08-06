package com.freightcom.clickship.data.entity;

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
@Table(name = "prefetch_quote_request")
public class PrefetchQuoteRequest extends BaseEntity {

	private static final long serialVersionUID = -3574491223368126178L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "order_id", nullable = true, updatable = false)
	@JsonIgnore
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "marketplace_id", nullable = true, updatable = false)
	@JsonIgnore
	private Marketplace marketplace;
	
	@Column(name = "rate_request_id")
	private String rateRequestId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prefetchQuoteRequest", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PrefetchQuotes> prefetchQuotes;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prefetchQuoteRequest", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PrefetchQuotePackages> quotePackages;

	@Column(name = "shipto_company")
	private String shiptoCompany;

	@Column(name = "shipto_contact")
	private String shiptoContact;

	@Column(name = "shipto_email")
	private String shiptoEmail;

	@Column(name = "shipto_phone")
	private String shiptoPhone;

	@Column(name = "shipto_phone_ext")
	private String shiptoPhoneExt;

	@Column(name = "shipto_address1")
	private String shiptoAddress1;

	@Column(name = "shipto_address2")
	private String shiptoAddress2;

	@Column(name = "shipto_postalcode")
	private String shiptoPostalcode;

	@Column(name = "shipto_city")
	private String shiptoCity;

	@Column(name = "shipto_province_state")
	private String shiptoProvinceState;

	@Column(name = "shipto_country")
	private String shiptoCountry;

	@Column(name = "shipfrom_company")
	private String shipfromCompany;

	@Column(name = "shipfrom_contact")
	private String shipfromContact;

	@Column(name = "shipfrom_email")
	private String shipfromEmail;

	@Column(name = "shipfrom_phone")
	private String shipfromPhone;

	@Column(name = "shipfrom_phone_ext")
	private String shipfromPhoneExt;

	@Column(name = "shipfrom_address1")
	private String shipfromAddress1;

	@Column(name = "shipfrom_address2")
	private String shipfromAddress2;

	@Column(name = "shipfrom_postalcode")
	private String shipfromPostalcode;

	@Column(name = "shipfrom_city")
	private String shipfromCity;

	@Column(name = "shipfrom_province_state")
	private String shipfromProvinceState;

	@Column(name = "shipfrom_country")
	private String shipfromCountry;

	@Column(name = "residential_delivery")
	private Boolean residentialDelivery;

	@Column(name = "signature_required")
	private Boolean signatureRequired;

	@Column(name = "adult_signature_required")
	private Boolean adultSignatureRequired;

	@Column(name = "insurance_type")
	private String insuranceType;

	@Column(name = "insurance_amount")
	private Double insuranceAmount;
	
	@Column(name = "insurance_currency")
	private String insuranceCurrency;
	
	@Column(name = "validation_error")
	private String validationError;

	@Column(name = "api_error")
	private String apiError;

	@Column(name = "failed_attempts")
	private Integer failedAttempts = 0;

	public String getId() {
		return id;
	}

	public PrefetchQuoteRequest setId(String id) {
		this.id = id;
		return this;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public PrefetchQuoteRequest setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}
	public Order getOrder() {
		return order;
	}

	public PrefetchQuoteRequest setOrder(Order order) {
		this.order = order;
		return this;
	}
	
	public Marketplace getMarketplace() {
		return marketplace;
	}

	public PrefetchQuoteRequest setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		return this;
	}
	
	public String getRateRequestId() {
		return rateRequestId;
	}

	public PrefetchQuoteRequest setRateRequestId(String rateRequestId) {
		this.rateRequestId = rateRequestId;
		return this;
	}

	public List<PrefetchQuotes> getPrefetchQuotes() {
		return prefetchQuotes;
	}

	public PrefetchQuoteRequest setPrefetchQuotes(List<PrefetchQuotes> prefetchQuotes) {
		this.prefetchQuotes = prefetchQuotes;
		return this;
	}

	public List<PrefetchQuotePackages> getQuotePackages() {
		return quotePackages;
	}

	public PrefetchQuoteRequest setQuotePackages(List<PrefetchQuotePackages> quotePackages) {
		this.quotePackages = quotePackages;
		return this;
	}

	public String getShiptoCompany() {
		return shiptoCompany;
	}

	public PrefetchQuoteRequest setShiptoCompany(String shiptoCompany) {
		this.shiptoCompany = shiptoCompany;
		return this;
	}

	public String getShiptoContact() {
		return shiptoContact;
	}

	public PrefetchQuoteRequest setShiptoContact(String shiptoContact) {
		this.shiptoContact = shiptoContact;
		return this;
	}

	public String getShiptoEmail() {
		return shiptoEmail;
	}

	public PrefetchQuoteRequest setShiptoEmail(String shiptoEmail) {
		this.shiptoEmail = shiptoEmail;
		return this;
	}

	public String getShiptoPhone() {
		return shiptoPhone;
	}

	public PrefetchQuoteRequest setShiptoPhone(String shiptoPhone) {
		this.shiptoPhone = shiptoPhone;
		return this;
	}

	public String getShiptoPhoneExt() {
		return shiptoPhoneExt;
	}

	public PrefetchQuoteRequest setShiptoPhoneExt(String shiptoPhoneExt) {
		this.shiptoPhoneExt = shiptoPhoneExt;
		return this;
	}

	public String getShiptoAddress1() {
		return shiptoAddress1;
	}

	public PrefetchQuoteRequest setShiptoAddress1(String shiptoAddress1) {
		this.shiptoAddress1 = shiptoAddress1;
		return this;
	}

	public String getShiptoAddress2() {
		return shiptoAddress2;
	}

	public PrefetchQuoteRequest setShiptoAddress2(String shiptoAddress2) {
		this.shiptoAddress2 = shiptoAddress2;
		return this;
	}

	public String getShiptoPostalcode() {
		return shiptoPostalcode;
	}

	public PrefetchQuoteRequest setShiptoPostalcode(String shiptoPostalcode) {
		this.shiptoPostalcode = shiptoPostalcode;
		return this;
	}

	public String getShiptoCity() {
		return shiptoCity;
	}

	public PrefetchQuoteRequest setShiptoCity(String shiptoCity) {
		this.shiptoCity = shiptoCity;
		return this;
	}

	public String getShiptoProvinceState() {
		return shiptoProvinceState;
	}

	public PrefetchQuoteRequest setShiptoProvinceState(String shiptoProvinceState) {
		this.shiptoProvinceState = shiptoProvinceState;
		return this;
	}

	public String getShiptoCountry() {
		return shiptoCountry;
	}

	public PrefetchQuoteRequest setShiptoCountry(String shiptoCountry) {
		this.shiptoCountry = shiptoCountry;
		return this;
	}

	public String getShipfromCompany() {
		return shipfromCompany;
	}

	public PrefetchQuoteRequest setShipfromCompany(String shipfromCompany) {
		this.shipfromCompany = shipfromCompany;
		return this;
	}

	public String getShipfromContact() {
		return shipfromContact;
	}

	public PrefetchQuoteRequest setShipfromContact(String shipfromContact) {
		this.shipfromContact = shipfromContact;
		return this;
	}

	public String getShipfromEmail() {
		return shipfromEmail;
	}

	public PrefetchQuoteRequest setShipfromEmail(String shipfromEmail) {
		this.shipfromEmail = shipfromEmail;
		return this;
	}

	public String getShipfromPhone() {
		return shipfromPhone;
	}

	public PrefetchQuoteRequest setShipfromPhone(String shipfromPhone) {
		this.shipfromPhone = shipfromPhone;
		return this;
	}

	public String getShipfromPhoneExt() {
		return shipfromPhoneExt;
	}

	public PrefetchQuoteRequest setShipfromPhoneExt(String shipfromPhoneExt) {
		this.shipfromPhoneExt = shipfromPhoneExt;
		return this;
	}

	public String getShipfromAddress1() {
		return shipfromAddress1;
	}

	public PrefetchQuoteRequest setShipfromAddress1(String shipfromAddress1) {
		this.shipfromAddress1 = shipfromAddress1;
		return this;
	}

	public String getShipfromAddress2() {
		return shipfromAddress2;
	}

	public PrefetchQuoteRequest setShipfromAddress2(String shipfromAddress2) {
		this.shipfromAddress2 = shipfromAddress2;
		return this;
	}

	public String getShipfromPostalcode() {
		return shipfromPostalcode;
	}

	public PrefetchQuoteRequest setShipfromPostalcode(String shipfromPostalcode) {
		this.shipfromPostalcode = shipfromPostalcode;
		return this;
	}

	public String getShipfromCity() {
		return shipfromCity;
	}

	public PrefetchQuoteRequest setShipfromCity(String shipfromCity) {
		this.shipfromCity = shipfromCity;
		return this;
	}

	public String getShipfromProvinceState() {
		return shipfromProvinceState;
	}

	public PrefetchQuoteRequest setShipfromProvinceState(String shipfromProvinceState) {
		this.shipfromProvinceState = shipfromProvinceState;
		return this;
	}

	public String getShipfromCountry() {
		return shipfromCountry;
	}

	public PrefetchQuoteRequest setShipfromCountry(String shipfromCountry) {
		this.shipfromCountry = shipfromCountry;
		return this;
	}

	public Boolean getResidentialDelivery() {
		return residentialDelivery;
	}

	public PrefetchQuoteRequest setResidentialDelivery(Boolean residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
		return this;
	}

	public Boolean getSignatureRequired() {
		return signatureRequired;
	}

	public PrefetchQuoteRequest setSignatureRequired(Boolean signatureRequired) {
		this.signatureRequired = signatureRequired;
		return this;
	}

	public Boolean getAdultSignatureRequired() {
		return adultSignatureRequired;
	}

	public PrefetchQuoteRequest setAdultSignatureRequired(Boolean adultSignatureRequired) {
		this.adultSignatureRequired = adultSignatureRequired;
		return this;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public PrefetchQuoteRequest setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
		return this;
	}

	public Double getInsuranceAmount() {
		return insuranceAmount;
	}

	public PrefetchQuoteRequest setInsuranceAmount(Double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
		return this;
	}

	public String getInsuranceCurrency() {
		return insuranceCurrency;
	}

	public PrefetchQuoteRequest setInsuranceCurrency(String insuranceCurrency) {
		this.insuranceCurrency = insuranceCurrency;
		return this;
	}

	public String getValidationError() {
		return validationError;
	}

	public PrefetchQuoteRequest setValidationError(String validationError) {
		this.validationError = validationError;
		return this;
	}

	public String getApiError() {
		return apiError;
	}

	public PrefetchQuoteRequest setApiError(String apiError) {
		this.apiError = apiError;
		return this;
	}

	public Integer getFailedAttempts() {
		return failedAttempts;
	}

	public PrefetchQuoteRequest setFailedAttempts(Integer failedAttempts) {
		this.failedAttempts = failedAttempts;
		return this;
	}
}

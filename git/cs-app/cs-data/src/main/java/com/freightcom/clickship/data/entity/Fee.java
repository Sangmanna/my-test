package com.freightcom.clickship.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "fee")
public class Fee extends BaseEntity {

	private static final long serialVersionUID = -1367710877327466299L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id", nullable = true)
	@JsonIgnore
	private Invoice invoice;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "promo_id", nullable = true, updatable = false)
	@JsonIgnore
	private Promo promo;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = true, updatable = false)
	@JsonIgnore
	private Order order;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "marketplace_id", nullable = true, updatable = false)
	@JsonIgnore
	private Marketplace marketplace;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fee_type_id", nullable = true, updatable = false)
	@JsonIgnore
	private FeeType feeType;

	@Column(name = "order_number")
	private String orderNumber;

	@Column(name = "marketplace")
	private String marketplaceName;

	@Column(name = "fee_type_name")
	private String feeTypeName;

	@Column(name = "fee_type_description")
	private String feeTypeDescription;

	@Column(name = "fee_type_amount")
	private Double feeTypeAmount;

	@Column(name = "notes")
	private String notes;

	@Column(name = "discount")
	private Double discount;

	@Column(name = "fee_total")
	private Double feeTotal;

	@Column(name = "discount_code")
	private String discountCode;

	@Column(name = "status")
	private String status;
	
	public Fee() {
		super();
	}

	public Fee(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Fee setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public Fee setInvoice(Invoice invoice) {
		this.invoice = invoice;
		return this;
	}

	public Promo getPromo() {
		return promo;
	}

	public Fee setPromo(Promo promo) {
		this.promo = promo;
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public Fee setOrder(Order order) {
		this.order = order;
		return this;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public Fee setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		return this;
	}

	public FeeType getFeeType() {
		return feeType;
	}

	public Fee setFeeType(FeeType feeType) {
		this.feeType = feeType;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public Fee setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public String getMarketplaceName() {
		return marketplaceName;
	}

	public Fee setMarketplaceName(String marketplaceName) {
		this.marketplaceName = marketplaceName;
		return this;
	}

	public String getFeeTypeName() {
		return feeTypeName;
	}

	public Fee setFeeTypeName(String feeTypeName) {
		this.feeTypeName = feeTypeName;
		return this;
	}

	public String getFeeTypeDescription() {
		return feeTypeDescription;
	}

	public Fee setFeeTypeDescription(String feeTypeDescription) {
		this.feeTypeDescription = feeTypeDescription;
		return this;
	}

	public Double getFeeTypeAmount() {
		return feeTypeAmount;
	}

	public Fee setFeeTypeAmount(Double feeTypeAmount) {
		this.feeTypeAmount = feeTypeAmount;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public Fee setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public Double getDiscount() {
		return discount;
	}

	public Fee setDiscount(Double discount) {
		this.discount = discount;
		return this;
	}

	public Double getFeeTotal() {
		return feeTotal;
	}

	public Fee setFeeTotal(Double feeTotal) {
		this.feeTotal = feeTotal;
		return this;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public Fee setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Fee setStatus(String status) {
		this.status = status;
		return this;
	}

}

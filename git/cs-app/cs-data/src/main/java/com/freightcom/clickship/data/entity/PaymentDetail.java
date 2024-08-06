package com.freightcom.clickship.data.entity;

import java.util.Date;

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
@Table(name = "payment_detail")
public class PaymentDetail extends BaseEntity {
	
	private static final long serialVersionUID = 8400886461277668227L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;
	
	@Column(name = "payment_details_nickname")
	private String paymentDetailsNickname;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "card_type")
	private String cardType;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "expiry_date")
	private Date expiryDate;
	
	@Column(name = "cvv")
	private Integer cvv;
	
	@Column(name = "next_billing_date")
	private Date nextBillingDate;
	
	@Column(name = "last_payment_date")
	private Date lastPaymentDate;
	
	@Column(name = "last_payment_amount")
	private Double lastPaymentAmount;

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public PaymentDetail setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public String getPaymentDetailsNickname() {
		return paymentDetailsNickname;
	}

	public PaymentDetail setPaymentDetailsNickname(String paymentDetailsNickname) {
		this.paymentDetailsNickname = paymentDetailsNickname;
		return this;
	}

	public String getName() {
		return name;
	}

	public PaymentDetail setName(String name) {
		this.name = name;
		return this;
	}

	public String getCardType() {
		return cardType;
	}

	public PaymentDetail setCardType(String cardType) {
		this.cardType = cardType;
		return this;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public PaymentDetail setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
		return this;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public PaymentDetail setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
		return this;
	}

	public Integer getCvv() {
		return cvv;
	}

	public PaymentDetail setCvv(Integer cvv) {
		this.cvv = cvv;
		return this;
	}

	public Date getNextBillingDate() {
		return nextBillingDate;
	}

	public PaymentDetail setNextBillingDate(Date nextBillingDate) {
		this.nextBillingDate = nextBillingDate;
		return this;
	}

	public Date getLastPaymentDate() {
		return lastPaymentDate;
	}

	public PaymentDetail setLastPaymentDate(Date lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
		return this;
	}

	public Double getLastPaymentAmount() {
		return lastPaymentAmount;
	}

	public PaymentDetail setLastPaymentAmount(Double lastPaymentAmount) {
		this.lastPaymentAmount = lastPaymentAmount;
		return this;
	}
}
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
import jakarta.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerIdAssociateEntity;

@Entity
@Table(name = "invoice")
public class Invoice extends BaseEntity implements CustomerIdAssociateEntity {

	private static final long serialVersionUID = 7186939127324976891L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class )
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@Column(name = "customer_id")
	private String customerId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", updatable = false)
	@JsonIgnore
	private Order order;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "promo_id", updatable = false)
	@JsonIgnore
	private Promo promo;

	@Column(name = "chargebee_invoice_id")
	private String chargebeeId;
	
	@Column(name = "invoice_path")
	private String invoicePath;

	@Column(name = "total_discount")
	private Double totalDiscount;

	@Column(name = "subtotal")
	private Double subtotal;

	@Column(name = "taxes")
	private Double taxes;

	@Column(name = "total")
	private Double total;

	@Column(name = "status")
	private String status;

	@Transient
	private byte[] invoice;

	@Column(name = "chargebee_webhook_id")
	private String chargebeeWebhookId;
	
	@Column(name = "freightcom_invoice_id")
	private String freightcomInvoiceId;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "freightcom_v2_invoice_id")
	private String freightcomV2InvoiceId;
	
	public Invoice() {

	}

	public Invoice(byte[] invoice) {
		this.invoice = invoice;
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

	public String getCustomerId() {
		return customerId;
	}

	public Invoice setCustomer(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public Promo getPromo() {
		return promo;
	}

	public Invoice setPromo(Promo promo) {
		this.promo = promo;
		return this;
	}

	public String getInvoicePath() {
		return invoicePath;
	}

	public Invoice setInvoicePath(String invoicePath) {
		this.invoicePath = invoicePath;
		return this;
	}

	public Double getTotalDiscount() {
		return totalDiscount;
	}

	public Invoice setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
		return this;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public Invoice setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
		return this;
	}

	public Double getTaxes() {
		return taxes;
	}

	public Invoice setTaxes(Double taxes) {
		this.taxes = taxes;
		return this;
	}

	public Double getTotal() {
		return total;
	}

	public Invoice setTotal(Double total) {
		this.total = total;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Invoice setStatus(String status) {
		this.status = status;
		return this;
	}

	public byte[] getInvoice() {
		return invoice;
	}

	public Order getOrder() {
		return order;
	}

	public Invoice setOrder(Order order) {
		this.order = order;
		return this;
	}

	public Invoice setInvoice(byte[] invoice) {
		this.invoice = invoice;
		return this;
	}

	public String getChargebeeId() {
		return chargebeeId;
	}

	public Invoice setChargebeeId(String chargebeeId) {
		this.chargebeeId = chargebeeId;
		return this;
	}

	public String getChargebeeWebhookId() {
		return chargebeeWebhookId;
	}

	public Invoice setChargebeeWebhookId(String chargebeeWebhookId) {
		this.chargebeeWebhookId = chargebeeWebhookId;
		return this;
	}
	
	public String getFreightcomInvoiceId() {
		return freightcomInvoiceId;
	}

	public Invoice setFreightcomInvoiceId(String freightcomInvoiceId) {
		this.freightcomInvoiceId = freightcomInvoiceId;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public Invoice setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getFreightcomV2InvoiceId() {
		return freightcomV2InvoiceId;
	}

	public void setFreightcomV2InvoiceId(String freightcomV2InvoiceId) {
		this.freightcomV2InvoiceId = freightcomV2InvoiceId;
	}
}

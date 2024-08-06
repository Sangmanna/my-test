package com.freightcom.clickship.model.invoice;

import java.io.Serializable;
import java.util.Date;

import com.freightcom.clickship.model.CommonDTO;

public class InvoiceDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = 8929989595264453029L;
	
	private String invoiceId;
	private String orderNumber;
	private float total;
	private String status;
	private Date date;
	private String currency;
	private String invoiceNumber;

	public String getInvoiceId() {
		return invoiceId;
	}

	public InvoiceDTO setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public InvoiceDTO setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public float getTotal() {
		return total;
	}

	public InvoiceDTO setTotal(float total) {
		this.total = total;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public InvoiceDTO setStatus(String status) {
		this.status = status;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public InvoiceDTO setDate(Date date) {
		this.date = date;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public InvoiceDTO setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public InvoiceDTO setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
		return this;
	}
}

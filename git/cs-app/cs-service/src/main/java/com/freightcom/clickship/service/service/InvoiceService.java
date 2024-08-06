package com.freightcom.clickship.service.service;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Invoice;

public interface InvoiceService {
	
	public Invoice save(Invoice invoice);
	
	public Invoice getMostRecentInvoice(String customerId);
	
	public Invoice getInvoice(Customer customer, String invoiceId);
	
	public Invoice findByFreightcomInvoiceId(String customerId, String fcInvoiceId);
	
	public Invoice getChargebeeInvoice(String customerId, String chargebeeInvoiceId);
	
}
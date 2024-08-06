package com.freightcom.clickship.service.service;

import com.freightcom.clickship.data.entity.CustomInvoiceDetail;
import com.freightcom.clickship.data.entity.Invoice;

public interface CustomInvoiceDetailService {
	public void save(CustomInvoiceDetail customInvoiceDetail);

	public CustomInvoiceDetail getByInvoice(Invoice invoice);
}

package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.CustomInvoiceDetail;
import com.freightcom.clickship.data.entity.Invoice;

@Repository
public interface CustomInvoiceDetailRepository extends JpaRepository<CustomInvoiceDetail, String> {
	
	public CustomInvoiceDetail findByInvoice(Invoice invoiceId);
}
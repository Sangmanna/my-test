package com.freightcom.clickship.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.CustomInvoiceDetail;
import com.freightcom.clickship.data.entity.Invoice;
import com.freightcom.clickship.data.rep.CustomInvoiceDetailRepository;
import com.freightcom.clickship.service.service.CustomInvoiceDetailService;

@Service
public class CustomInvoiceDetailServiceImpl implements CustomInvoiceDetailService{
		
	@Autowired
	CustomInvoiceDetailRepository customInvoiceDetailRepository;

	@Override
	@Transactional
	public void save(CustomInvoiceDetail customInvoiceDetail) {
		customInvoiceDetailRepository.save(customInvoiceDetail);		
	}

	@Override
	public CustomInvoiceDetail getByInvoice(Invoice invoice) {
		return customInvoiceDetailRepository.findByInvoice(invoice);
	}
	

}

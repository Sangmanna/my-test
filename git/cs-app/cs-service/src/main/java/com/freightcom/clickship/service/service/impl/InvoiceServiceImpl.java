package com.freightcom.clickship.service.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Invoice;
import com.freightcom.clickship.data.rep.InvoiceRepository;
import com.freightcom.clickship.service.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Value("${file.storage.path}")
	private String fileStoragePath;
	
	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Invoice save(Invoice invoice) {
		invoice = invoiceRepository.save(invoice);

		if (StringUtils.isEmpty(invoice.getChargebeeId())) {
			saveFile(invoice);
		}

		return invoiceRepository.save(invoice);
	}

	@Override
	public Invoice getChargebeeInvoice(String customerId, String chargebeeInvoiceId) {
		return invoiceRepository.findByCustomerIdAndChargebeeId(customerId, chargebeeInvoiceId);
	}

	@Override
	public Invoice getInvoice(Customer customer, String invoiceId) {
		if (StringUtils.isNotBlank(invoiceId)) {
			return invoiceRepository.findByCustomerIdAndId(customer.getId(), invoiceId);
		}
		return null;
	}
	
	@Override
	public Invoice getMostRecentInvoice(String customerId) {
		return invoiceRepository.findFirstByCustomerIdOrderByCreatedDatetime(customerId);
	}
	
	@Override
	public Invoice findByFreightcomInvoiceId(String customerId, String fcInvoiceId) {
		return invoiceRepository.findByCustomerIdAndFreightcomInvoiceId(customerId, fcInvoiceId);
	}
	
	private void saveFile(Invoice invoice) {
		String fileName = invoice.getId() + ".pdf";
		byte[] bytes = Base64.decodeBase64(invoice.getInvoice());
		String path = fileStoragePath + File.separator + "invoice" + File.separator;
		
		try {
			File dir = new File(path);
			if (!dir.exists()) dir.mkdirs();
			
			Files.write(Paths.get(path + fileName), bytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			invoice.setInvoicePath(path + fileName);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception while creating FC invoice - customer:{}, order:{}", 
					invoice.getCustomerId(), invoice.getOrder().getOrderNumber(), e);
		}
	}

}
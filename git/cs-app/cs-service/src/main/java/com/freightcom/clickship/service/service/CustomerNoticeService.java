package com.freightcom.clickship.service.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerNotice;
import com.freightcom.clickship.data.rep.CustomerNoticeRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerNoticeService {
	
	@Autowired
	private CustomerNoticeRepository customerNoticeRepository;
	
	@Transactional
	public void save(String key, String value, Customer customer) {
		if (Boolean.valueOf(value)) {
			List<CustomerNotice> list = get(customer);
			Optional<CustomerNotice> noticeToUpdate = list.stream()
				.filter(cn -> StringUtils.equalsAnyIgnoreCase(key, cn.getName()))
				.findFirst();

			if (noticeToUpdate.isPresent()) {
	            CustomerNotice cn = noticeToUpdate.get();
	            cn.setChecked(true);
	            customerNoticeRepository.save(cn);
	        } else {
	            try {
	            	CustomerNotice newNotice = new CustomerNotice();
		            newNotice.setName(key);
		            newNotice.setChecked(true);
		            newNotice.setCustomer(customer);
		            customerNoticeRepository.save(newNotice);
	            }catch(Exception e) {
	            	e.printStackTrace();
	            	throw e;
	            }
	        }
			
		// originally this should not accept once it is set true, 
		// but Mahesh decides to track shipping rule edit status in this table so adding this part for only shipping rule 
		} else {
			if ("APPLIED_SHIPPING_RULES".equals(key)) {
				List<CustomerNotice> list = get(customer);
				Optional<CustomerNotice> noticeToUpdate = list.stream()
					.filter(cn -> StringUtils.equalsAnyIgnoreCase(key, cn.getName()))
					.findFirst();

				if (noticeToUpdate.isPresent()) {
		            CustomerNotice cn = noticeToUpdate.get();
		            cn.setChecked(false);
		            customerNoticeRepository.save(cn);
		        } else {
		            try {
		            	CustomerNotice newNotice = new CustomerNotice();
			            newNotice.setName(key);
			            newNotice.setChecked(false);
			            newNotice.setCustomer(customer);
			            customerNoticeRepository.save(newNotice);
		            }catch(Exception e) {
		            	e.printStackTrace();
		            	throw e;
		            }
		        }
			}
		}
	}
	
	public List<CustomerNotice> get(Customer customer) {
		return customerNoticeRepository.findByCustomer(customer);
	}
}

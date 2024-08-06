package com.freightcom.clickship.service.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerHistory;
import com.freightcom.clickship.data.rep.CustomerHistoryRepository;
import com.freightcom.clickship.model.enums.CustomerHistoryCategory;
import com.freightcom.clickship.service.service.CustomerHistoryService;

@Service
public class CustomerHistoryServiceImpl implements CustomerHistoryService {
	
	@Autowired
	private CustomerHistoryRepository customerHistoryRepository;
	
	@Transactional
	public void save(Customer customer, CustomerHistoryCategory category, String subCategory, String action, String description) {
		CustomerHistory customerHistory = new CustomerHistory();
		
		customerHistory.setCustomer(customer);
		customerHistory.setCategory(category.toString());
		customerHistory.setSubCategory(subCategory);
		customerHistory.setAction(action);
		customerHistory.setDescription(description);
		
		customerHistoryRepository.save(customerHistory);
	}
}

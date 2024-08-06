package com.freightcom.clickship.service.service;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.model.enums.CustomerHistoryCategory;

public interface CustomerHistoryService {
	
	public void save(Customer customer, CustomerHistoryCategory category, String subCategory, String action, String desc);
}

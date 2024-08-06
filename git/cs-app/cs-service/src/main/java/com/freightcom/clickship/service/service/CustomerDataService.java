package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.model.admin.dashboard.NewSignedUpCustomerDto;
import com.freightcom.clickship.model.admin.dashboard.NewSignedUpCustomersCountsDto;
import com.freightcom.clickship.model.admin.dashboard.TopCustomersDto;

public interface CustomerDataService {
	
	public void save(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(String customerId);

	public Customer getCustomerByFCV2Id(String customerId);
	
	public List<Customer> searchAllByBusinessName(String searchStr);
	
	public Customer getCustomerByChargebeeId(String chargebeeCustomerId);
	
	public List<NewSignedUpCustomerDto> getNewSignedUpCustomersDetails(String from, String to, String agentName);

	public List<NewSignedUpCustomersCountsDto> getNewSignedUpCustomersCounts(String from, String to, String agentName);
	
	public List<String> getAllBusinessNamesofCustomers(String agentName);

	public List<TopCustomersDto> getTopCustomersByRevenue(String fromDate, String toDate, Integer limit, String agentName);

	public List<TopCustomersDto> getTopCustomersByVolume(String fromDate, String toDate, Integer limit, String agentName);

	public void activateCustomer(String customerId, Boolean status, String loginUser);
}

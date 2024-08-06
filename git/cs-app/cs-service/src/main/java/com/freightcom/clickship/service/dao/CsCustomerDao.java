package com.freightcom.clickship.service.dao;

import java.util.List;

import com.freightcom.clickship.model.admin.dashboard.NewSignedUpCustomerDto;
import com.freightcom.clickship.model.admin.dashboard.NewSignedUpCustomersCountsDto;
import com.freightcom.clickship.model.admin.dashboard.TopCustomersDto;

public interface CsCustomerDao {

	public List<NewSignedUpCustomerDto> newSignedUpCustomers(String from, String to, String agentName);

	public List<NewSignedUpCustomersCountsDto> newSignedUpCustomersCounts(String from, String to, String agentName);

	public List<String> getAllBusinessNames(String agentName);

	public List<TopCustomersDto> getTopCustomersByRevenue(String from, String to, Integer limit, String agentName);

	public List<TopCustomersDto> getTopCustomersByVolume(String from, String to, Integer limit, String agentName);

	List<String> searchCutomers(String agentName, String businessName);
}

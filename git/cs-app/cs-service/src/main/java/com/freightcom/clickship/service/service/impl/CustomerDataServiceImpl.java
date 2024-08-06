package com.freightcom.clickship.service.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.rep.CustomerRepository;
import com.freightcom.clickship.model.admin.dashboard.NewSignedUpCustomerDto;
import com.freightcom.clickship.model.admin.dashboard.NewSignedUpCustomersCountsDto;
import com.freightcom.clickship.model.admin.dashboard.TopCustomersDto;
import com.freightcom.clickship.service.dao.CsCustomerDao;
import com.freightcom.clickship.service.service.CustomerDataService;

@Service
public class CustomerDataServiceImpl implements CustomerDataService {

	private Logger logger = LogManager.getLogger(CustomerDataServiceImpl.class);
	
	@Autowired
	private CsCustomerDao csCustomerDao;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public List<Customer> searchAllByBusinessName(String businessName) {
	    List<Customer> list1 = customerRepository.findByUsername(businessName);
	    List<Customer> list2 = customerRepository.findByBusinessNameContainingIgnoreCaseOrEmailContainingIgnoreCase(businessName, businessName);

	    List<Customer> combinedList = new ArrayList<>(list1);
	    combinedList.addAll(list2);

	    Set<Customer> uniqueCustomers = new HashSet<>(combinedList);

	    List<Customer> result = new ArrayList<>(uniqueCustomers);

	    return result;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(String customerId) {
		Optional<Customer> optional = customerRepository.findById(customerId);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public Customer getCustomerByFCV2Id(String fcCustomerId) {
		return customerRepository.findByFcCustomerId(fcCustomerId);
	}

	@Override
	public Customer getCustomerByChargebeeId(String chargebeeCustomerId) {
		return customerRepository.findByChargebeeId(chargebeeCustomerId);
	}

	@Override
	public List<NewSignedUpCustomerDto> getNewSignedUpCustomersDetails(String from, String to, String agentName) {
		try {
			return csCustomerDao.newSignedUpCustomers(from, to, agentName);
		} catch (Exception e) {
			logger.error("Error retreiving new sign up Customer", e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<NewSignedUpCustomersCountsDto> getNewSignedUpCustomersCounts(String from, String to, String agentName) {
		try {
			return csCustomerDao.newSignedUpCustomersCounts(from, to, agentName);
		} catch (Exception e) {
			logger.error("Error retreiving new sign up Customers Chart - {}", e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<String> getAllBusinessNamesofCustomers(String agentName) {
		try {
			return csCustomerDao.getAllBusinessNames(agentName);
		}catch (Exception e) {
			logger.error("Error retreiving business names.", e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<TopCustomersDto> getTopCustomersByRevenue(String from, String to, Integer limit, String agentName) {
		try {
			return csCustomerDao.getTopCustomersByRevenue(from,to,limit, agentName);
		}catch (Exception e) {
			logger.error("Error getting top customers by revenue.", e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<TopCustomersDto> getTopCustomersByVolume(String from, String to, Integer limit, String agentName) {
		try {
			return csCustomerDao.getTopCustomersByVolume(from,to,limit, agentName);
		}catch (Exception e) {
			logger.error("Error getting top customers by volume  ", e);
		}
		return Collections.emptyList();
	}

	@Override
	@Transactional
	public void activateCustomer(String customerId, Boolean status,String agentName){
		Customer customer = getCustomerById(customerId);
		try {
			customer.setActive(status);
			customer.setUpdateDatetime(new Date());
			customer.setUpdatedBy(agentName);
			save(customer);
		} catch (Exception e) {
			String msg  = String.format("Error saving entity customer for customer id %s to status %s",customerId,status);
			logger.error(msg, e);
		}
		String message = String.format("Setting  %s status to %s", customer.getBusinessName(), status);
		logger.info(message);
	}
}

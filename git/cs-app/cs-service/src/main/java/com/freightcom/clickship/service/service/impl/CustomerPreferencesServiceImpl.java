package com.freightcom.clickship.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerPreferences;
import com.freightcom.clickship.data.entity.ShippingPreferences;
import com.freightcom.clickship.data.rep.CustomerPreferencesRepository;
import com.freightcom.clickship.data.rep.ShippingPreferencesRepository;
import com.freightcom.clickship.service.service.CustomerPreferencesService;

@Service
public class CustomerPreferencesServiceImpl implements CustomerPreferencesService {
	
	@Autowired
	private CustomerPreferencesRepository repository;
	
	@Autowired
	private ShippingPreferencesRepository shippingPreferencesRepository;
	
	@Override
	@Transactional
	public CustomerPreferences save(CustomerPreferences obj) {
		return repository.save(obj);
	}
	
	@Override
	@Transactional  // get method with @Transactional????
	public ShippingPreferences save(ShippingPreferences shippingPreference) {
		return shippingPreferencesRepository.save(shippingPreference);
	}	
	
	@Override
	@Transactional
	public CustomerPreferences getCustomerPreferencesByCustomer(Customer customer) {
		return repository.getCustomerPreferencesByCustomer(customer);
	}
	
	@Override
	public ShippingPreferences getCustomerShippingPreferences(Customer customer) {
		return shippingPreferencesRepository.getShippingPreferencesByCustomer(customer);
	}

}

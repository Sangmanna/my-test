package com.freightcom.clickship.service.service;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerPreferences;
import com.freightcom.clickship.data.entity.ShippingPreferences;

public interface CustomerPreferencesService {
	
	public CustomerPreferences save(CustomerPreferences obj);
	
	public ShippingPreferences save(ShippingPreferences shippingPreference);
	
	public CustomerPreferences getCustomerPreferencesByCustomer(Customer customer);
	
	public ShippingPreferences getCustomerShippingPreferences(Customer customer);

}

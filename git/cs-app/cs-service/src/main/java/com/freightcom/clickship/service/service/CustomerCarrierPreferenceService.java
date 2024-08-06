package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerCarrierPreference;
import com.freightcom.clickship.model.carrier.CustomerCarrierPreferenceDTO;

public interface CustomerCarrierPreferenceService {
	
	public void savePalletPrefrences(Customer customer);
	
	public void saveAll(List<CustomerCarrierPreference> list);
	
	public List<CustomerCarrierPreference> getActivePalletCarriers(Customer customer);
	
	public List<CustomerCarrierPreference> getActivePackageCarriers(Customer customer);
	
	public List<CustomerCarrierPreference> findCarrierServicesByCustomer(Customer customer);
	
	public CustomerCarrierPreferenceDTO save(CustomerCarrierPreference customerCarrierPreference);
	
	public CustomerCarrierPreferenceDTO getCustomerCarrierPreferenceDTO(CustomerCarrierPreference obj);

	public CustomerCarrierPreference getCustomerCarrierPreferenceByServiceGroupIdAndServiceId(Customer customer, String serviceGroupId, String serviceId);
	
	public CustomerCarrierPreference getCustomerCarrierPreferenceByServiceGroupIdAndServiceId(String customerId, String serviceGroupId, String serviceId);

	List<CustomerCarrierPreference> findCarrierServicesPreferenceByCustomer(Customer customer);
	
}
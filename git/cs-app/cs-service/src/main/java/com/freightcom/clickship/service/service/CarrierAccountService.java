package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.CarrierAccount;
import com.freightcom.clickship.data.entity.Customer;

public interface CarrierAccountService {
	
	public CarrierAccount save(CarrierAccount account);
	
	public List<CarrierAccount> getCarrierAccountByCustomer(Customer customer);
	
	public List<CarrierAccount> getActiveCarrierAccountsByCustomer(Customer customer);
	
	public List<CarrierAccount> getInActiveCarrierAccountsByCustomer(Customer customer);

}

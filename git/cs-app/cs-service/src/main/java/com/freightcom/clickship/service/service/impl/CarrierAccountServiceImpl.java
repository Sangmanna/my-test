package com.freightcom.clickship.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.CarrierAccount;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.rep.CarrierAccountRepository;
import com.freightcom.clickship.service.service.CarrierAccountService;

@Service
public class CarrierAccountServiceImpl implements CarrierAccountService {
	
	@Autowired
	private CarrierAccountRepository carrierAccountRepository;

	@Override
	@Transactional
	public CarrierAccount save(CarrierAccount account) {
		return carrierAccountRepository.save(account);
	}

	@Override
	public List<CarrierAccount> getCarrierAccountByCustomer(Customer customer) {
		return carrierAccountRepository.findByCustomerId(customer.getId());
	}
	
	@Override
	public List<CarrierAccount> getActiveCarrierAccountsByCustomer(Customer customer) {
		return carrierAccountRepository.findByCustomerIdAndIsSubscribedIsTrueAndActiveIsTrue(customer.getId());
	}
	
	@Override
	public List<CarrierAccount> getInActiveCarrierAccountsByCustomer(Customer customer) {
		return carrierAccountRepository.findByCustomerIdAndActiveIsFalse(customer.getId());
	}

}

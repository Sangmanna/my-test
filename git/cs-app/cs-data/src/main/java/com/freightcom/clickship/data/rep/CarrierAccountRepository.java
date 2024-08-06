package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.CarrierAccount;

@Repository
public interface CarrierAccountRepository extends JpaRepository<CarrierAccount, String> {

	public CarrierAccount findCarrierAccountById(String id);

	public List<CarrierAccount> findByCustomerId(String customerId);
	
	public List<CarrierAccount> findByCustomerIdAndActiveIsTrue(String id);

	public List<CarrierAccount> findByCustomerIdAndActiveIsFalse(String id);

	public List<CarrierAccount> findByCustomerIdAndIsSubscribedIsTrueAndActiveIsTrue(String customerId);
	
	public CarrierAccount findByCustomerIdAndCarrierName(String customerId, String shortName);

	public CarrierAccount findByCustomerIdAndCarrierAccountNumber(String customerId, String carrierAccountNumber);

	public CarrierAccount findByCustomerIdAndCarrierNameAndActiveIsTrue(String customerId, String shortName);

}

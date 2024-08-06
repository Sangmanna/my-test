package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.entity.projection.customer.address.CustomerAddressProjection;

public interface CustomerAddressService {
	
	public CustomerAddress getAddress(String addressId);
	
	public void deleteAddress(String customerAddressId, User user);
	
	public void deleteAddressWithoutUserCheck(String customerAddressId);
	
	public CustomerAddress save(CustomerAddress customerAddress);
	
	public CustomerAddress getCustomerRegAddress(Customer customer);
	
	public List<CustomerAddress> listAllAddressByCustomer(Customer loginCustomer);
	
	public List<CustomerAddress> listAllAddressByCustomerAndType(Customer loginCustomer, String type);

	public List<CustomerAddressProjection> findByProductId(String productId, User user);
}

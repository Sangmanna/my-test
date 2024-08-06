package com.freightcom.clickship.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.MarketplaceProduct;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.entity.projection.customer.address.CustomerAddressProjection;
import com.freightcom.clickship.data.rep.CustomerAddressRepository;
import com.freightcom.clickship.data.rep.MarketplaceAddressRepository;
import com.freightcom.clickship.data.rep.MarketplaceProductRepository;
import com.freightcom.clickship.model.enums.AddressType;
import com.freightcom.clickship.model.exception.AddressNotFoundException;
import com.freightcom.clickship.service.service.CustomerAddressService;
import com.freightcom.clickship.service.service.ICheckAccess;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService, ICheckAccess {
	
	@Autowired
	private CustomerAddressRepository customerAddressRepository;

	@Autowired
	private MarketplaceAddressRepository marketplaceAddressRepository;
	
	@Autowired
	private MarketplaceProductRepository marketplaceProductRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CustomerAddress save(CustomerAddress customerAddress) {
		return customerAddressRepository.save(customerAddress);
	}
	
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public CustomerAddress getAddress(String addressId) {
		Optional<CustomerAddress> optional = customerAddressRepository.findById(addressId);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		throw new AddressNotFoundException("Invalid addressId provided");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAddress(String customerAddressId, User user) {
		CustomerAddress address = getAddress(customerAddressId);
		
		checkAccess(user, address);

		deleteAddress(address);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAddressWithoutUserCheck(String customerAddressId) {
		deleteAddress(getAddress(customerAddressId));
	}
	
	private void deleteAddress(CustomerAddress address) {
		if (!AddressType.REG.toString().equals(address.getAddressType())) {
			marketplaceAddressRepository.deleteByCustomerAddress(address);
			customerAddressRepository.delete(address);
		}
	}
	
	@Override
	public CustomerAddress getCustomerRegAddress(Customer customer) {
		List<CustomerAddress> list = customerAddressRepository.findAllByCustomerAndAddressType(customer, AddressType.REG.toString());
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
	}

	@Override
	public List<CustomerAddress> listAllAddressByCustomer(Customer customer) {
		return customerAddressRepository.findAllByCustomer(customer);
	}

	@Override
	public List<CustomerAddress> listAllAddressByCustomerAndType(Customer customer, String type) {
		return customerAddressRepository.findAllByCustomerAndAddressType(customer, type);
	}

	@Override
	public List<CustomerAddressProjection> findByProductId(String prodId, User user) {
		Optional<MarketplaceProduct> oMarketplaceProdut = marketplaceProductRepository.findById(prodId);

		if (oMarketplaceProdut.isPresent()) {
			MarketplaceProduct marketplaceProduct = oMarketplaceProdut.get();
			checkAccess(user, marketplaceProduct);
			return customerAddressRepository.findByProductId(prodId);
		} else {
			return new ArrayList<>();
		}
	}
}

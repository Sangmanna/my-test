package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.OrderPresetFilter;

@Repository
public interface OrderPresetFilterRepository extends JpaRepository<OrderPresetFilter, String> {
	
	public List<OrderPresetFilter> findByCustomer(Customer customer);
	
	public void deleteByCustomerAndPresetName(Customer customer,String filterName);

}

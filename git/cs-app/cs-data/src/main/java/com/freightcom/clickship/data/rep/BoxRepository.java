package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Box;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.projection.box.BoxNameProjection;

@Repository
public interface BoxRepository extends JpaRepository<Box, String> {

	public List<Box> findAllByCustomer(Customer customer);
	
	public List<Box> findAllByCustomerAndPackageType(Customer customer, String packageType);

	public List<BoxNameProjection> findByCustomer(Customer customer);
}
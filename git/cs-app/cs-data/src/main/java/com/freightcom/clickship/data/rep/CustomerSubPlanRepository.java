package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerSubPlan;
import com.freightcom.clickship.data.entity.SubTier;

@Repository
public interface CustomerSubPlanRepository extends JpaRepository<CustomerSubPlan, String> {

	public CustomerSubPlan findByCustomerAndStatusIsTrue(Customer customer);
	
	public List<CustomerSubPlan> findByCustomerAndSubTireIn(Customer customer, List<SubTier> list);

}

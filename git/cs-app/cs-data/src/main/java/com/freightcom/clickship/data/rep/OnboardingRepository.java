package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Onboarding;

@Repository
public interface OnboardingRepository extends JpaRepository<Onboarding, String> {
	
	public Onboarding findByCustomer(Customer customer);
	
}

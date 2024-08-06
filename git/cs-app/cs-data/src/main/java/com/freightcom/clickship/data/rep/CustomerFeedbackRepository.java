package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freightcom.clickship.data.entity.CustomerFeedback;

public interface CustomerFeedbackRepository  extends JpaRepository<CustomerFeedback, String> {
	
}

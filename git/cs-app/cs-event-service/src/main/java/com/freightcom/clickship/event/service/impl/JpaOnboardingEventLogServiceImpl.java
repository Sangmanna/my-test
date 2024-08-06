package com.freightcom.clickship.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.CsJpaEvent;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.rep.CsJpaEventRepository;
import com.freightcom.clickship.event.service.JpaOnboardingEventLogService;
import com.freightcom.clickship.model.enums.CSSignupTypes;

@Service
public class JpaOnboardingEventLogServiceImpl implements JpaOnboardingEventLogService {

	@Autowired
	private CsJpaEventRepository rep;
	
	@Override
	@Transactional
	@Async("jpaEventsTaskExecutor")
	public void saveOnboardingEvent(Customer obj, CSSignupTypes eventType) {
		if (CSSignupTypes.CLICKSHIP == eventType) {
			rep.save(getCsJpaEvent(obj, "Signup"));
		}

		rep.save(getCsJpaEvent(obj, "StepAway"));
	}

	private CsJpaEvent getCsJpaEvent(Customer customer, String action) {
		CsJpaEvent event = new CsJpaEvent();
		event.setAction(action);
		event.setType("Onboarding");
		event.setRefKey1(customer.getId());
		
		return event;
	}

}

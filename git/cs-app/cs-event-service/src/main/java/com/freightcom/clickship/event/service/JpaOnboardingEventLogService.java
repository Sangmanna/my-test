package com.freightcom.clickship.event.service;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.model.enums.CSSignupTypes;

public interface JpaOnboardingEventLogService {
	
	public void saveOnboardingEvent(Customer obj, CSSignupTypes eventType);
	
}

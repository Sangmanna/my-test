package com.freightcom.clickship.event.service;

import com.freightcom.clickship.data.entity.Order;

public interface JpaOrderEventLogService {
	
	public void saveOrderEvent(Order oldObj, Order updatedObj, String action);
	
}

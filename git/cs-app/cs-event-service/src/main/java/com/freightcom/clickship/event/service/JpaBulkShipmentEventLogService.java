package com.freightcom.clickship.event.service;

import com.freightcom.clickship.data.entity.BulkShipment;

public interface JpaBulkShipmentEventLogService {
	
	public void saveBulkShipmentEvent(BulkShipment updatedObj, String action);
	
}

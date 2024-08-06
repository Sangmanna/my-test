package com.freightcom.clickship.event.service;

import com.freightcom.clickship.data.entity.Shipment;

public interface JpaShipmentEventLogService {
	
	public void saveShipmentEvent(Shipment oldObj, Shipment updatedObj, String action);
	
}

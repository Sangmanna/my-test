package com.freightcom.clickship.event.service;

import com.freightcom.clickship.data.entity.BatchShipment;

public interface JpaBatchShipmentEventLogService {
	
	public void saveBatchShipmentEvent(BatchShipment obj, String action);
	
	public void saveAllBatchShipmentEvent(Iterable<BatchShipment> iterable);

}

package com.freightcom.clickship.event.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.freightcom.clickship.data.entity.CsJpaEvent;
import com.freightcom.clickship.data.entity.Shipment;
import com.freightcom.clickship.data.rep.CsJpaEventRepository;
import com.freightcom.clickship.event.service.JpaShipmentEventLogService;

@Service
public class JpaShipmentEventLogServiceImpl implements JpaShipmentEventLogService {
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private CsJpaEventRepository rep;

	@Override
	@Async("jpaShipmentEventsTaskExecutor")
	public void saveShipmentEvent(Shipment oldObj, Shipment updatedObj, String action) {
		try {
//			logger.debug("JPA Shipment {} event recived - id:{}", action, updatedObj.getId());
			
			/*** DB level unique CONSTRAINT already set for (type, action, reference_key_1, status)
			 but safer side using synchronized block to make sure no duplicate event saved.
			 So we can avoid duplicate notifications/E-mails trigger from topic/queue */
			synchronized (this) {
				CsJpaEvent jpaEvent = rep.findByTypeAndActionAndRefKey1("Shipment", action, updatedObj.getId());
				
				if(jpaEvent == null) {
					jpaEvent = new CsJpaEvent();
					
					jpaEvent.setType("Shipment");
					jpaEvent.setAction(action);
					jpaEvent.setRefKey1(updatedObj.getId());
				} else {
					jpaEvent.setStatus("scheduled");
				}
				
				rep.save(jpaEvent);
			}
			
//			logger.debug("JPA Shipment {} event completed - id:{}", action, updatedObj.getId());
		} catch(Exception e) {
			logger.error("JPA Shipment {} event logging failed - id:{}", action, updatedObj.getId(), e);
		}
	}


}

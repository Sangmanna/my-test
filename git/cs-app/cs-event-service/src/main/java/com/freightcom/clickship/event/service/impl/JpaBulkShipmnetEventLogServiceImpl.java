package com.freightcom.clickship.event.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.BulkShipment;
import com.freightcom.clickship.data.entity.CsJpaEvent;
import com.freightcom.clickship.data.rep.CsJpaEventRepository;
import com.freightcom.clickship.event.service.JpaBulkShipmentEventLogService;

@Service
public class JpaBulkShipmnetEventLogServiceImpl implements JpaBulkShipmentEventLogService {
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private CsJpaEventRepository rep;

	@Override
	@Transactional
	@Async("jpaEventsTaskExecutor")
	public void saveBulkShipmentEvent(BulkShipment obj, String action) {
		try {
			synchronized (this) {
				CsJpaEvent jpaEvent = rep.findByTypeAndActionAndRefKey1("BulkShipment", "created", obj.getId());
				
				if(jpaEvent == null) {
					jpaEvent = new CsJpaEvent();
					
					jpaEvent.setType("BulkShipment");
					jpaEvent.setAction("created");
					jpaEvent.setRefKey1(obj.getId());
					
					rep.save(jpaEvent);
				}
			}
		} catch(Exception e) {
			logger.error("JPA BulkShipment {} event logging failed - id:{}", action, obj.getId(), e);
		}
	}

}

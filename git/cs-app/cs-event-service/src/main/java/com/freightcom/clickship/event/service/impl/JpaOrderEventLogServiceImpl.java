package com.freightcom.clickship.event.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.CsJpaEvent;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.rep.CsJpaEventRepository;
import com.freightcom.clickship.event.service.JpaOrderEventLogService;

@Service
public class JpaOrderEventLogServiceImpl implements JpaOrderEventLogService {
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private CsJpaEventRepository rep;

	@Override
	@Transactional
	@Async("jpaOrderEventsTaskExecutor")
	public void saveOrderEvent(Order oldObj, Order updatedObj, String action) {
		try {
//			logger.debug("JPA Order {} event recived - id:{}", action, updatedObj.getId());
			
			/*** DB level unique CONSTRAINT already set for (type, action, reference_key_1, status)
			 but safer side using synchronized block to make sure no duplicate event saved.
			 So we can avoid duplicate notifications/E-mails trigger from topic/queue */
			synchronized (this) {
				CsJpaEvent jpaEvent = rep.findByTypeAndActionAndRefKey1("Order", action, updatedObj.getId());
				
				if(jpaEvent == null) {
					jpaEvent = new CsJpaEvent();
					
					jpaEvent.setType("Order");
					jpaEvent.setAction(action);
					jpaEvent.setRefKey1(updatedObj.getId());
				} else {
					jpaEvent.setStatus("scheduled");
				}
				
				rep.save(jpaEvent);
			}
			
//			logger.debug("JPA Order {} event completed - id:{}", action, updatedObj.getId());
		} catch(Exception e) {
			logger.error("JPA Order {} event logging failed - id:{}", action, updatedObj.getId(), e);
		}
	}

}

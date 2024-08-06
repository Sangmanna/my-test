package com.freightcom.clickship.event.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.BatchShipment;
import com.freightcom.clickship.data.entity.CsJpaEvent;
import com.freightcom.clickship.data.rep.CsJpaEventRepository;
import com.freightcom.clickship.event.service.JpaBatchShipmentEventLogService;

@Service
public class JpaBatchShipmnetEventLogServiceImpl implements JpaBatchShipmentEventLogService {
	
	private Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private CsJpaEventRepository rep;

	@Override
	@Transactional
	@Async("jpaEventsTaskExecutor")
	public void saveBatchShipmentEvent(BatchShipment shipment, String action) {
		try {
			synchronized (this) {
				saveCsJpaEvent(shipment.getId());
			}
		} catch (Exception e) {
			logger.error("JPA BatchShipment {} event logging failed - id:{}", action, shipment.getId(), e);
		}
	}

	@Override
	@Transactional
	@Async("jpaEventsTaskExecutor")
	public void saveAllBatchShipmentEvent(Iterable<BatchShipment> iterable) {
		try {
			if (iterable != null) {
				synchronized (this) {
					for (BatchShipment bs : iterable) {
						saveCsJpaEvent(bs.getId());
					}
				}
			}
		} catch (Exception e) {
			logger.error("JPA BatchShipment saveAll event logging failed", e);
		}
	}
	
	@Transactional
	public synchronized void saveCsJpaEvent(String refId) {
		CsJpaEvent jpaEvent = rep.findByTypeAndActionAndRefKey1("BatchShipment", "created", refId);

		if (jpaEvent == null) {
			jpaEvent = new CsJpaEvent();

			jpaEvent.setType("BatchShipment");
			jpaEvent.setAction("created");
			jpaEvent.setRefKey1(refId);

			rep.save(jpaEvent);
		}
	}

}

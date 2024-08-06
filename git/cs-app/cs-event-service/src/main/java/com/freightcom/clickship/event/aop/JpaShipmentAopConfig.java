package com.freightcom.clickship.event.aop;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.freightcom.clickship.data.entity.Shipment;
import com.freightcom.clickship.event.service.JpaShipmentEventLogService;

@Aspect
@Configuration
public class JpaShipmentAopConfig {
	
	private static final String[] DELIVERED_STATUS = { "DELIVERED" };
	private static final String[] FAILED_DELIVERY_STATUS = { "CANCELLED", "EXCEPTION" };
	
	@Autowired
	private JpaShipmentEventLogService service;
	
	@Around("execution(* com.freightcom.clickship.data.rep.ShipmentRepository.save(..))")
	public Object saveAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Shipment oldObj = null;
		String action = "created";
		Object[] params = joinPoint.getArgs();
		
		if (params.length == 1 && params[0] instanceof Shipment) {
			Shipment shipment = ((Shipment) params[0]);
			
			if(StringUtils.isNotEmpty(shipment.getId())) {
				action = "updated";
				
				// For now not pulling existing shipment from repository as it will be one extra call and will impact the performance. 
				// In future if required pull the existing shipment and send it to service.
				// oldObj always null for now
			}
		}
		
		Object returnObj = joinPoint.proceed();
		service.saveShipmentEvent(oldObj, (Shipment)returnObj, action);

		return returnObj;
	}
	
	@Around("execution(* com.freightcom.clickship.data.rep.ShipmentRepository.saveAll(..))")
	public Object saveAllAround(ProceedingJoinPoint joinPoint) throws Throwable {
		return joinPoint.proceed();
	}
	
	@After("@annotation(com.freightcom.clickship.event.aop.LogTrackingUpdate)")
	public void afterLogTrackingUpdate(JoinPoint joinPoint) throws Throwable {
		Object[] params = joinPoint.getArgs();
		
		if (params.length == 3 && params[0] instanceof Shipment) {
			String status = (String) params[1];

			if (Arrays.stream(DELIVERED_STATUS).anyMatch(status::equals)) {
				service.saveShipmentEvent(null, (Shipment)params[0], "shipment_delivered");
			} else if (Arrays.stream(FAILED_DELIVERY_STATUS).anyMatch(status::equals)) { 
				service.saveShipmentEvent(null, (Shipment)params[0], "shipment_exception");
			}
		}
	}
	
}

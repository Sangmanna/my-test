package com.freightcom.clickship.event.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.freightcom.clickship.data.entity.BatchShipment;
import com.freightcom.clickship.event.service.JpaBatchShipmentEventLogService;

@Aspect
@Configuration
public class JpaBatchShippingAopConfig {
	
	@Autowired
	private JpaBatchShipmentEventLogService service;
	
	@Around("execution(* com.freightcom.clickship.data.rep.BatchShipmentRepository.save(..))")
	public Object saveAround(ProceedingJoinPoint joinPoint) throws Throwable {
		String action = "created";
		Object[] params = joinPoint.getArgs();
		
		if (params.length == 1 && params[0] instanceof BatchShipment) {
			BatchShipment shipment = ((BatchShipment) params[0]);
			
			if(StringUtils.isNotEmpty(shipment.getId())) {
				action = "updated";
			}
		}
		
		Object returnObj = joinPoint.proceed();
		service.saveBatchShipmentEvent((BatchShipment)returnObj, action);

		return returnObj;
	}
	
	@SuppressWarnings("unchecked")
	@Around("execution(* com.freightcom.clickship.data.rep.BatchShipmentRepository.saveAll(..))")
	public Object saveAllAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] params = joinPoint.getArgs();
		Iterable<BatchShipment> iterable = null;
		
		if (params.length == 1 && params[0] instanceof Iterable<?>) {
			iterable = ((Iterable<BatchShipment>) params[0]);
		}
		
		Object returnObj = joinPoint.proceed();
		service.saveAllBatchShipmentEvent(iterable);
		
		return returnObj;
	}
	

}

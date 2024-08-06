package com.freightcom.clickship.event.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.freightcom.clickship.data.entity.BulkShipment;
import com.freightcom.clickship.event.service.JpaBulkShipmentEventLogService;

@Aspect
@Configuration
public class JpaBulkShippingAopConfig {
	
	@Autowired
	private JpaBulkShipmentEventLogService service;
	
	@Around("execution(* com.freightcom.clickship.data.rep.BulkShipmentRepository.save(..))")
	public Object saveAround(ProceedingJoinPoint joinPoint) throws Throwable {
		String action = "created";
		Object[] params = joinPoint.getArgs();
		
		if (params.length == 1 && params[0] instanceof BulkShipment) {
			BulkShipment bulkShipment = ((BulkShipment) params[0]);
			
			if(StringUtils.isNotEmpty(bulkShipment.getId())) {
				action = "updated";
			}
		}
		
		Object returnObj = joinPoint.proceed();
		service.saveBulkShipmentEvent((BulkShipment)returnObj, action);

		return returnObj;
	}
	
	@Around("execution(* com.freightcom.clickship.data.rep.BulkShipmentRepository.saveAll(..))")
	public Object saveAllAround(ProceedingJoinPoint joinPoint) throws Throwable {
		return joinPoint.proceed();
	}
	
}

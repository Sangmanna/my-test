package com.freightcom.clickship.event.aop;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.freightcom.clickship.data.entity.AdvancedShippingRule;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.rep.AdvancedShippingRuleRepository;
import com.freightcom.clickship.event.service.JpaOrderEventLogService;

@Aspect
@Configuration
public class JpaOrderAopConfig {
	
	@Autowired
	private JpaOrderEventLogService service;
	
	@Autowired
	private AdvancedShippingRuleRepository advShippingRuleRepository;
	
	@Around("execution(* com.freightcom.clickship.data.rep.OrderRepository.save(..))")
	public Object saveAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Order oldObj = null;
		String action = "created";
		Object[] params = joinPoint.getArgs();
		
		if (params.length == 1 && params[0] instanceof Order) {
			Order order = ((Order) params[0]);
			
			if(StringUtils.isNotEmpty(order.getId())) {
				action = "updated";
				
				// For now not pulling existing order from repository as it will be one extra call and will impact the performance. 
				// In future if required pull the existing order and send it to service. 
				// oldObj always null for now
			}else {				
				Customer customer = order.getCustomer();
				List<AdvancedShippingRule> shippingRuleCount = advShippingRuleRepository.findByCustomerAndActive(customer, true);
				if(customer.isAdvancedShippingRuleActive() && shippingRuleCount != null && !shippingRuleCount.isEmpty()) {
					order.setShippingRuleInProgress(true);
				}
			}
		}		
		Object returnObj = joinPoint.proceed();		
		service.saveOrderEvent(oldObj, (Order)returnObj, action);

		return returnObj;
	}
	
	@Around("execution(* com.freightcom.clickship.data.rep.OrderRepository.saveAll(..))")
	public Object saveAllAround(ProceedingJoinPoint joinPoint) throws Throwable {
		return joinPoint.proceed();
	}
	
}

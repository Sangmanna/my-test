package com.freightcom.clickship.event.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.event.service.JpaOnboardingEventLogService;
import com.freightcom.clickship.model.enums.CSSignupTypes;

@Aspect
@Configuration
public class JpaOnboardingAopConfig {
	
	@Autowired
	private JpaOnboardingEventLogService service;
	
	@Around(value="@annotation(Onboarding)", argNames="Onboarding")
	public Object around(ProceedingJoinPoint joinPoint, Onboarding event) throws Throwable {
		CSSignupTypes type = event.signup();
		Object object = joinPoint.proceed();
		service.saveOnboardingEvent((Customer) object, type);
		
		return object; 
	}
}

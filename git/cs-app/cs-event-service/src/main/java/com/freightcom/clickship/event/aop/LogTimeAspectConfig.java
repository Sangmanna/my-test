package com.freightcom.clickship.event.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogTimeAspectConfig {
	
	private Logger logger = LogManager.getLogger(this.getClass());

	@Around(value="@annotation(LogTime)", argNames="LogTime")
	public Object around(ProceedingJoinPoint joinPoint, LogTime logTime) throws Throwable {
		String message = String.format("{} - %s", logTime.logMessage());
		return logTime(joinPoint, message);
	}

	Object logTime(ProceedingJoinPoint joinPoint, String message) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object resultObject = joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		
		logger.info(message, joinPoint.getKind(), timeTaken);
		return resultObject;
	}
}


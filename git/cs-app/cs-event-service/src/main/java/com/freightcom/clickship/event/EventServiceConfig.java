package com.freightcom.clickship.event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
public class EventServiceConfig {

	@Bean(name = "jpaOrderEventsTaskExecutor")
	public ExecutorService jpaOrderEventCachedThreadPool() {
		return new ThreadPoolExecutor(1, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
	}
	
	@Bean(name = "jpaShipmentEventsTaskExecutor")
	public ExecutorService jpaShipmentEventCachedThreadPool() {
		return new ThreadPoolExecutor(1, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
	}
	
	@Bean(name = "jpaEventsTaskExecutor")
	public ExecutorService jpaEventCachedThreadPool() {
		return new ThreadPoolExecutor(1, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
	}

}

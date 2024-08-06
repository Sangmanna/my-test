package com.freightcom.clickship.service.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Shipment;
import com.freightcom.clickship.model.util.Security;

@Aspect
@Component
public class SecurityAspect {

	@Around("execution(* org.springframework.data.repository.CrudRepository.save(..))")
	public Object encrypt(ProceedingJoinPoint joinPoint) throws Throwable {
		Object param = joinPoint.proceed();
		if (param instanceof Order) {			
			Order order = (Order) param;
			if (order.isEncrypted()) {
				order.setShiptoContact(Security.encryptPII(order.getShiptoContact()))
				.setShiptoAddress1(Security.encryptPII(order.getShiptoAddress1()))
				.setShiptoCompany(Security.encryptPII(order.getShiptoCompany()))
				.setShiptoEmail(Security.encryptPII(order.getShiptoEmail()))
				.setShiptoPhone(Security.encryptPII(order.getShiptoPhone()))
				.setShiptoZip(Security.encryptPII(order.getShiptoZip()));

				return order;
			}

		}else if(param instanceof Shipment){
			Shipment shipment = (Shipment) param;
			if (shipment.isEncrypted()) {
				shipment.setShiptoContact(Security.encryptPII(shipment.getShiptoContact()))
				.setShiptoAddress1(Security.encryptPII(shipment.getShiptoAddress1()))
				.setShiptoCompany(Security.encryptPII(shipment.getShiptoCompany()))
				.setShiptoEmail(Security.encryptPII(shipment.getShiptoEmail()))
				.setShiptoPhone(Security.encryptPII(shipment.getShiptoPhone()))
				.setShiptoPostalcode(Security.encryptPII(shipment.getShiptoPostalcode()));
				return shipment;
			}
		}
		return param;
	}

}

package com.freightcom.clickship.data.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.model.util.Security;

@Component
public class EncryptionHelper {
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	public void encryptOrder(Order order) {
		try {
			if (order != null && !order.isEncrypted()) {
				
				if(StringUtils.isNotEmpty(order.getShiptoContact())) {
					order.setShiptoContactEnc(order.getShiptoContact());
				}				
				order.setShiptoContact(Security.encryptPII(order.getShiptoContact()))
						.setShiptoAddress1(Security.encryptPII(order.getShiptoAddress1()))
						.setShiptoCompany(Security.encryptPII(order.getShiptoCompany()))
						.setShiptoZip(Security.encryptPII(order.getShiptoZip()))
						.setShiptoEmail(Security.encryptPII(order.getShiptoEmail()))
						.setShiptoPhone(Security.encryptPII(order.getShiptoPhone()))
						.setBilltoContact(Security.encryptPII(order.getBilltoContact()))
						.setBilltoAddress1(Security.encryptPII(order.getBilltoAddress1()))
						.setBilltoPostalcode(Security.encryptPII(order.getBilltoPostalcode()))
						.setBilltoEmail(Security.encryptPII(order.getBilltoEmail()))
						.setBilltoPhone(Security.encryptPII(order.getBilltoPhone()))
						.setEncrypted(true);
			}
		} catch (Exception e) {
			logger.error("Error while encrypting Order Number : [{}] ; Customer : [{}] ; Marketplace Id : [{}] ", order.getOrderNumber(),order.getCustomer().getBusinessName(), order.getMarketplace().getId(), e);
		}
		
	}
	

}

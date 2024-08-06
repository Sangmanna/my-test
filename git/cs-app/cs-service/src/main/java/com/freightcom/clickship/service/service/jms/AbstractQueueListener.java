package com.freightcom.clickship.service.service.jms;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.service.service.MarketplaceService;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

public abstract class AbstractQueueListener implements MessageListener {

	protected static final Logger logger = LogManager.getLogger(AbstractQueueListener.class);
	
	@Autowired
	protected MarketplaceService marketplaceService;
	
	protected String getProperty(final Message message, final String propertyName) {
		String propertyVal = null;
		try {
			propertyVal = message.getStringProperty(propertyName);
		} catch (JMSException e) {
			logger.warn("Error while getting property from message - {} ", e.getMessage());
		}
		return propertyVal;
	}

	protected String getMessage(final Message message) {

		String strMessage;

		if (message instanceof TextMessage) {
			final TextMessage tm = (TextMessage) message;
			try {
				strMessage = tm.getText();
				logger.debug("[{}] - message:{}", message.getJMSDestination(), strMessage);
			} catch (JMSException e) {
				String errorMessage = "Unable to get the message";
				throw new RuntimeException(errorMessage);
			}
		} else {
			final String errorMessage = "Invalid data " + message;
			throw new RuntimeException(errorMessage);
		}
		return strMessage;
	}

	protected boolean containsStringHeader(Message message, String headerKey, String headerValue) {
		return StringUtils.equals(headerValue, getProperty(message, headerKey));
	}

	protected boolean containsStringHeaders(Message message, String headerKey, List<String> headerValues) {
		String value = getProperty(message, headerKey);
		return StringUtils.isNotBlank(value) && headerValues.contains(value);
	}
	
	/*
	 * 
	 * Since saving with new transaction then always need to take latest one 
     *	otherwise data will be override which saved on other transaction
	 * 
	 */
	protected void setImportingFlag(String marketplaceId, boolean importFlag) {
		Marketplace marketplace = marketplaceService.findById(marketplaceId);
		marketplace.setIsImporting(importFlag);
		marketplaceService.save(marketplace);
	}
	
	/*
	 * 
	 * Since saving with new transaction then always need to take latest one 
     *	otherwise data will be override which saved on other transaction
	 * 
	 */
	protected void setImportingFlag(String marketplaceId, boolean importFlag, boolean importSuccess) {
		Marketplace marketplace = marketplaceService.findById(marketplaceId);
		marketplace.setIsImporting(importFlag);
		marketplace.setImportSuccess(importSuccess);
		marketplaceService.save(marketplace);
	}

}

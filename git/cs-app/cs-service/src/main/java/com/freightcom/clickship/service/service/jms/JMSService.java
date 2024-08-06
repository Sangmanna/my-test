package com.freightcom.clickship.service.service.jms;

import java.io.Serializable;
import java.util.Map;

import org.apache.activemq.ScheduledMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.freightcom.clickship.model.util.ClickshipStringUtil;
import com.freightcom.clickship.service.util.JsonTransformer;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

@Service
public class JMSService {
	
	private static final Logger LOG = LogManager.getLogger(JMSService.class);

	@Autowired
	private JmsTemplate jmsQueueTemplate;
	
	@Autowired
	private JmsTemplate jmsTopicTemplate;
	
	@Autowired
	private JsonTransformer jsonTransformer;
	
	public void send(String queueName, Object message) {
		sendToQueue(queueName, null, message, -1);
	}
	
	public void send(String queueName, Map<String, String> headers, Object message) {
		sendToQueue(queueName, headers, message, -1);
	}
	
	public void sendToQueue(String queueName, Map<String, String> headers, Object message, long scheduledDelay) {
		String json = message instanceof String ? (String) message : jsonTransformer.toJson(message);
		postToQueue(queueName, headers, json, scheduledDelay);
	}
	
	public void sendToTopic(String topicName, Object message) {
		sendToTopic(topicName, null, message, -1);
	}
	
	public void sendToTopic(String topicName, Map<String, String> headers, Object message) {
		sendToTopic(topicName, headers, message, -1);
	}

	public void sendToTopic(String topicName, Map<String, String> headers, Object message, long scheduledDelay) {
		String json = message instanceof String ? (String) message : jsonTransformer.toJson(message);
		postToTopic(topicName, headers, json, scheduledDelay);
	}
	
	public void sendJMS(String queueName, Serializable param) throws Exception {
		jmsQueueTemplate.convertAndSend(queueName, ClickshipStringUtil.getStringObject(param));
	}
	
	private void postToQueue(final String queueName, Map<String,String> headers, final String message, long scheduledDelay) {
		jmsQueueTemplate.send(queueName, getMessageCreator(headers, message, scheduledDelay));
	}
	
	public void postToTopic(final String topicName, Map<String,String> headers, final String message, long scheduledDelay) {
		jmsTopicTemplate.send(topicName, getMessageCreator(headers, message, scheduledDelay));
	}

	private MessageCreator getMessageCreator(Map<String, String> headers, final String message, long scheduledDelay) {
		return new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage(message);

				if (headers != null) {
					headers.forEach((k, v) -> {
						try {
							msg.setStringProperty(k, v);
						} catch (JMSException e) {
							LOG.warn(String.format("JMS fails to set the Header value '%s' to property '%s'", v, k));
						}
					});
				}

				if (scheduledDelay > 0) {
					msg.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, scheduledDelay);
				}
				
				return msg;
			}
		};
	}
}
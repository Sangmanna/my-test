package com.freightcom.clickship.service.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.Notification;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.entity.common.NotificationAlertEnum;
import com.freightcom.clickship.data.entity.common.NotificationIconEnum;
import com.freightcom.clickship.data.rep.NotificationRepository;
import com.freightcom.clickship.model.constants.ClickShipJMS;
import com.freightcom.clickship.model.notification.NotifictionDTO;
import com.freightcom.clickship.service.service.ICheckAccess;
import com.freightcom.clickship.service.service.NotificationService;
import com.freightcom.clickship.service.service.UserDetailsService;
import com.freightcom.clickship.service.service.jms.JMSService;

@Service
public class NotificationServiceImpl implements NotificationService, ICheckAccess {
	private Logger logger = LogManager.getLogger(NotificationServiceImpl.class);
	
	private static final String CANCEL_ORDER_DESCRIPTION = "%s order #%s has been cancelled";
	private static final String SHIPPING_CANCELLED = "%s Order #%s shipment has been cancelled";

	private static final String CHARGEBEE_NO_CARD_ON_FILE = "There is no card on file for your subscription plan";
	private static final String EMAIL_FAILURE_DESCRIPTION = "Your %s email to %s has failed%s";
	public static final String AUTO_FULFILL_ERROR = "%s order#%s auto fulfillment failed due to %s";
	private static final String SHIPPING_CANCELLATION_FAILURE_DESCRIPTION = "The cancellation of shipment #%s has failed, please contact %s to cancel";
	
	@Autowired
	private JMSService jmsService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Override
	public void notifyCustomer(Customer customer) {
		sendNotification(customer);
	}
	
	@Override
	@Transactional
	public void removeNotification(String notificationId, User user) throws Exception {
		Optional<Notification> oNotification = notificationRepository.findById(notificationId);
		if (oNotification.isPresent()) {
			Notification notification = oNotification.get();
			checkAccess(user, notification);
			notificationRepository.delete(notification);
		}
	}
	
	@Override
	@Transactional
	public void removeNotificationWithoutCheckingUser(String notificationId) throws Exception {
		notificationRepository.deleteById(notificationId);
	}

	@Override
	@Transactional
	public void removeNotifications(List<Notification> notifications, User user) throws Exception {
		List<String> notificationIds = notifications.stream().map(Notification::getId).collect(Collectors.toList());

		List<Notification> deleteList = new ArrayList<>();
		for (String id : notificationIds) {
			Optional<Notification> oNotification = notificationRepository.findById(id);
			if (oNotification.isPresent()) {
				Notification notification = oNotification.get();
				checkAccess(user, notification);
				deleteList.add(notification);

			}
		}
		notificationRepository.deleteAll(deleteList);
	}
	
	@Override
	public Map<String, Object> getAllNotifications(Customer customer) throws Exception {
		List<Notification> notificationList = notificationRepository.findAllByCustomer(customer);
		
		List<NotifictionDTO> dtoList = notificationList.stream().map(this::tranformToDTO).sorted().collect(Collectors.toList());
		Map<String, Object> result = new HashMap<>();
		
		result.put("list", dtoList);
		result.put("size", dtoList.size());
		
		return result;
	}
	
	@Override
	public int getCountOfAllNotifications(Customer customer) throws Exception {
		return notificationRepository.countByCustomer(customer);
	}
	
	@Override
	public Notification getNoCardOnFileNotification(Customer customer) {
		return notificationRepository.findByCustomerAndDescription(customer, CHARGEBEE_NO_CARD_ON_FILE);
	}
	
	@Override
	public List<Notification> getAllNotificationsByMarketplace(Marketplace marketplace) throws Exception {
		return notificationRepository.findAllByMarketplace(marketplace);
	}
	
	@Override
	public void saveImportMarketplaceErrorNotification(Marketplace marketplace, String description) {
		Customer customer = marketplace.getCustomer();
		saveNotification(customer, getNotification(customer, marketplace, NotificationIconEnum.IMPORT, NotificationAlertEnum.IMPORT_ERROR, description));
	}

	@Override
	public void saveCancelOrderNotification(Marketplace marketplace, String orderId) {
		if(marketplace.getActive()) {
			Customer customer = marketplace.getCustomer();
			String description = String.format(CANCEL_ORDER_DESCRIPTION, marketplace.getAliasName(), orderId);
			saveNotification(customer, getNotification(customer, marketplace, NotificationIconEnum.ORDER, NotificationAlertEnum.ORDER_CANCEL, description));
		}
	}

	@Override
	public void saveNoCardOnFileNotification(Customer customer) {
		saveNotification(customer, getNotification(customer, null, NotificationIconEnum.CHARGEBEE, NotificationAlertEnum.CHARGEBEE_NO_CARD_PLAN, CHARGEBEE_NO_CARD_ON_FILE));
	}

	@Override
	public void saveShippingCancelNotification(Marketplace marketplace, String orderId) {
		if(marketplace.getActive()) {
			Customer customer = marketplace.getCustomer();
			String description =String.format(SHIPPING_CANCELLED, marketplace.getAliasName(), orderId);
			saveNotification(customer, getNotification(customer, marketplace, NotificationIconEnum.SHIPPING, NotificationAlertEnum.SHIPPING_CANCELLED, description));
		}
	}

	@Override
	public void emailFailureNotification(Marketplace marketplace, String emailType, String emailTo, String reasonFail) {
		if(marketplace.getActive()) {
			Customer customer = marketplace.getCustomer();
			String description =String.format(EMAIL_FAILURE_DESCRIPTION, emailType, emailTo, reasonFail);
			saveNotification(customer, getNotification(customer, marketplace, NotificationIconEnum.EMAIL, NotificationAlertEnum.DANGER, description));
		}
	}
	
	@Override
	public void saveAutoFullfillOrderFailNotification(Marketplace marketplace, String orderId, String description) {
		if(marketplace.getActive()) {
			Customer customer = marketplace.getCustomer();
			saveNotification(customer, getNotification(customer, marketplace, NotificationIconEnum.ORDER, NotificationAlertEnum.DANGER, description));
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveNotification(Customer customer, Notification notification) {
		Notification result = notificationRepository.findByCustomerAndDescription(customer, notification.getDescription());
		
		//Don't Save duplicate notifications
		if(result == null) {
			notificationRepository.save(notification);
			sendNotification(customer);
		}
	}

	@Override
	public void shipmentCancellationFailure(Marketplace marketplace, String shipmentId, String carrier) {
		if(marketplace.getActive() || marketplace == null) {
			Customer customer = marketplace.getCustomer();
			String description = String.format(SHIPPING_CANCELLATION_FAILURE_DESCRIPTION, shipmentId, carrier);
			saveNotification(customer, getNotification(customer, marketplace, NotificationIconEnum.SHIPPING, NotificationAlertEnum.DANGER, description));
		}		
	}
	
	private void sendNotification(Customer customer) {
		User user = userDetailsService.findByCustomer(customer);

		try {
			jmsService.send(ClickShipJMS.SEND_NOTIFICATION_UPDATE_EVENT, user.getUsername());
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
	
	private NotifictionDTO tranformToDTO(Notification notification) {
		return new NotifictionDTO().setId(notification.getId())
				.setDescription(notification.getDescription())
				.setCreatedDate(notification.getCreatedDatetime())
				.setAlert(notification.getSubnotificationType().getValue())
				.setIcon(notification.getNotificationType().getValue());
	}
	
	private Notification getNotification(Customer customer, Marketplace marketplace, NotificationIconEnum icon, NotificationAlertEnum alert, String description) {
		return new Notification().setCustomer(customer).setMarketplace(marketplace).setDescription(description).setNotificationType(icon)
				.setSubnotificationType(alert).setUpdateDatetime(new Date()).setCreatedDatetime(new Date());
	}
	
}

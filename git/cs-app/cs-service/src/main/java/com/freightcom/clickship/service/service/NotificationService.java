package com.freightcom.clickship.service.service;

import java.util.List;
import java.util.Map;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.Notification;
import com.freightcom.clickship.data.entity.User;

public interface NotificationService {

	public void notifyCustomer(Customer customer);
	
	public void saveNoCardOnFileNotification(Customer customer);
	
	public Notification getNoCardOnFileNotification(Customer customer);
	
	public void removeNotification(String notificationId, User user) throws Exception;
	
	public void removeNotificationWithoutCheckingUser(String notificationId) throws Exception;
	
	public int getCountOfAllNotifications(Customer customer) throws Exception;
	
	public void saveNotification(Customer customer, Notification notification);
	
	public void saveCancelOrderNotification(Marketplace marketplace, String orderId);
	
	public void removeNotifications(List<Notification> notifications, User user) throws Exception;
	
	public Map<String, Object> getAllNotifications(Customer customer) throws Exception;
	
	public void saveShippingCancelNotification(Marketplace marketplace, String orderId);
	
	public void saveImportMarketplaceErrorNotification(Marketplace marketplace, String description);
	
	public void shipmentCancellationFailure(Marketplace marketplace, String shipmentId, String carrier);
	
	public List<Notification> getAllNotificationsByMarketplace(Marketplace marketplace) throws Exception;
	
	public void saveAutoFullfillOrderFailNotification(Marketplace marketplace, String orderId, String description);
	
	public void emailFailureNotification(Marketplace marketplace, String emailType, String emailTo, String reasonFail);
	
}

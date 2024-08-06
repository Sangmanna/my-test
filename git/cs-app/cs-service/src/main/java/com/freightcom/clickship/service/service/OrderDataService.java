package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.Order;

public interface OrderDataService {
	
	public Order save(Order order);

	public Order getOrderById(String orderId);
	
	public Order findByOrderById(String orderId);

	public String getOrderUrl(String orderNumber);
	
	public List<Order> getByParentOrder(Order order);
	
	public void cancelSplit(String orderId) throws Exception;
	
	public List<Order> getOrdersByMarketplace(Marketplace marketplace);
	
	public void cancelOrderCombination(String orderId) throws Exception;
	
	public void cancelSplitAndCancelOrderInCs(Order order) throws Exception;
	
	public void cancelCombineAndCancelOrderInCs(Order order) throws Exception;
	
	public void sendNewOrderImportEmail(Marketplace marketplace, Order order);
	
	public Order getByMarketplaceAndExternalOrderId(Marketplace marketplace, String externalOrderId);
	
	public List<Order> getByMarketplaceAndOrderNumbers(Marketplace marketplace, List<String> orderNumbers);

	public List<String> getOrdersByCustomer(String customerId, List<String> statuses);

	public List<Order> getCustomerUnfulfilledOrders(Customer c, List<String> unfulfilledOrders);
	
	public List<Order> getByMarketplaceAndExternalOrderIds(Marketplace marketplace, List<String> externalOrderIds);

}

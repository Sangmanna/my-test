package com.freightcom.clickship.service.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Code;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceSetting;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Orderline;
import com.freightcom.clickship.data.entity.common.ClickShipOrderStatus;
import com.freightcom.clickship.data.rep.CodeRepository;
import com.freightcom.clickship.data.rep.OrderRepository;
import com.freightcom.clickship.model.util.CopyUtil;
import com.freightcom.clickship.service.service.CustomBrandingService;
import com.freightcom.clickship.service.service.MarketplaceSettingService;
import com.freightcom.clickship.service.service.OrderDataService;
import com.freightcom.clickship.service.service.email.MailChimpEmailUtil;
import com.freightcom.clickship.service.service.email.SendEmailUtil;

@Service
public class OrderDataServiceImpl implements OrderDataService {
	
	private Logger logger = LogManager.getLogger(OrderDataServiceImpl.class);
	
	@Value("${server.domain}")
	private String clickshipDomain;
	
	@Value("${new.order.imported.tmpl.name}")
	private String newOrderImportedTmpl;
	
	@Autowired
	private SendEmailUtil sendEmailUtil;
	
	@Autowired
	private CodeRepository codeRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private MailChimpEmailUtil mailChipEmailUtil;
	
	@Autowired
	private MarketplaceSettingService settingService;
	
	@Autowired
	private CustomBrandingService customerPreferencesService;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order getOrderById(String orderId) {
		return orderRepository.getReferenceById(orderId);
	}
	
	@Override
	public Order findByOrderById(String orderId) {
		Optional<Order> optional = orderRepository.findById(orderId);
		
		if (optional.isPresent()) {
			return optional.get();
		}
		
		throw new RuntimeException(String.format("Invalid orderId : %s", orderId));
	}
	
	@Override
	public String getOrderUrl(String orderNumber) {
		return clickshipDomain + "/app-frame/my-orders?searchKey=" + orderNumber;
	}
	
	@Override
	public Order getByMarketplaceAndExternalOrderId(Marketplace marketplace, String externalOrderId) {
		return orderRepository.findByMarketplaceAndExternalOrderId(marketplace, externalOrderId);
	}
	
	@Override
	public List<Order> getByMarketplaceAndExternalOrderIds(Marketplace marketplace, List<String> externalOrderIds) {
		return orderRepository.findByMarketplaceAndExternalOrderIdIn(marketplace, externalOrderIds);
	}

	@Override
	public List<Order> getByParentOrder(Order order) {
		return orderRepository.findAllByParentOrder(order);
	}
	
	@Override
	public List<Order> getOrdersByMarketplace(Marketplace marketplace) {
		return orderRepository.findAllByMarketplace(marketplace);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void sendNewOrderImportEmail(Marketplace marketplace, Order order) {
		try {
			MarketplaceSetting marketplaceSetting = settingService.getMarketplaceSettingByMarketplace(marketplace);
			
			if (marketplaceSetting != null) {
				String email = marketplaceSetting.getEmailAddressNewOrderImported();
				
				if (StringUtils.isNotEmpty(email)) {
					String subject = "New Order - Imported " +  marketplace.getAliasName() + " Order #" + order.getOrderNumber();
					
					Code shipToCountryCode = codeRepository.findByGroupNameAndValue("COUNTRY", order.getShiptoCountry());
					
					Map<String, Object> param = new HashMap<>();
					setProductsForNewOrderEmail(order, param);
					
					Map<String, String> orderMap = CopyUtil.copyObjectToMap(order);
					orderMap.put("shiptoCountryName", shipToCountryCode != null ? shipToCountryCode.getName() : order.getShiptoCountry());
					param.put("order", orderMap);
					param.put("deliveryMethod", order.getCarrier() != null ? order.getCarrier().getService() : "Not yet.");
					param.put("marketplace", CopyUtil.copyObjectToMap(order.getMarketplace()));
					param.put("orderUrl", getOrderUrl(order.getOrderNumber()));
					param.putAll(customerPreferencesService.getBrandingEmbeddedDetails(marketplace.getCustomer()));
					
					mailChipEmailUtil.sendEmail(email, subject, newOrderImportedTmpl, true, param, null);
				}
			}
		} catch (Exception e) { 
			logger.error("Error while sending new order import email - marketplace:[{}], order:[{}]", marketplace.getStoreUrl(), order.getOrderNumber(), e);
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	private void setProductsForNewOrderEmail(Order order, Map<String, Object> param) {
		List<Map<String, String>> list = new ArrayList<>();
		List<Orderline> orderlines = order.getOrderlines();
		for (int i = 0; i < orderlines.size(); i++) {
			Orderline orderline = orderlines.get(i);
			Map<String, String> map = new HashMap<>();
			map.put("quantity", String.valueOf(orderline.getQuantity()));
			map.put("productName", orderline.getTitle());
			map.put("sku", orderline.getSku());
			map.put("unitPrice", String.valueOf(orderline.getUnitPrice()));
			
			if(orderline.getMarketplaceProduct() != null) {
				map.put("imgUrl", orderline.getMarketplaceProduct().getImageUrl());	
			}
			
			list.add(map);
		}
		
		param.put("products", list);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void cancelSplit(String orderId) throws Exception {
		Order childOrder = orderRepository.findById(orderId).get();
		Order parentOrder = childOrder.getParentOrder();
		parentOrder.setOrderRelType(null);
		orderRepository.save(parentOrder);

		List<Order> siblings = orderRepository.findAllByParentOrder(parentOrder);
		siblings.forEach(child -> child.setParentOrder(null));

		if (siblings.stream().anyMatch(x -> !StringUtils.equals(ClickShipOrderStatus.UnFulfilled.toString(), x.getStatus()))) {
			throw new Exception("You cannot cancel this order, becuase some of split orders are already fulfilled.");
		} else {
			orderRepository.deleteAll(siblings);
		}
	}
	
	@Override
	@Transactional
	public void cancelOrderCombination(String orderId) throws Exception {
		Order order = getOrderById(orderId);
		
		List<Order> list = orderRepository.findAllByParentOrder(order).stream()
				.map(child -> child.setOrderRelType(null).setParentOrder(null))
				.collect(Collectors.toList());
		
		list.forEach(orderRepository::save);
		orderRepository.delete(order);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void cancelSplitAndCancelOrderInCs(Order order) throws Exception {
		List<Order> list = orderRepository.findAllByParentOrder(order);
		
		Optional<Order> fulfilledOrder = list.stream()
				.filter(o -> StringUtils.equals(o.getStatus(), ClickShipOrderStatus.Fulfilled.getValue()))
				.findFirst();
		
		if(fulfilledOrder.isPresent()) {
			logger.info("Cannot cancel the order since one of the child order fulfilled from split order:{}", order.getId());
		} else {
			order.setStatus(ClickShipOrderStatus.Cancelled).setOrderRelType(null);
			orderRepository.save(order);
			
			List<Order> siblings = orderRepository.findAllByParentOrder(order);
			siblings.forEach(child -> child.setParentOrder(null));
			
			orderRepository.deleteAll(siblings);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void cancelCombineAndCancelOrderInCs(Order order) throws Exception {
		if(StringUtils.equals(order.getStatus(), ClickShipOrderStatus.Fulfilled.getValue()) 
			|| StringUtils.equals(order.getParentOrder().getStatus(), ClickShipOrderStatus.Fulfilled.getValue())) {
			logger.info("Cannot cancel the order since combine order:{} is already fulfilled.", order.getId());
		} else {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("updatedOrder", order.getOrderNumber());
			param.put("orderNumber", order.getParentOrder().getOrderNumber());
			param.put("marketplaceName", order.getMarketplace().getAliasName());
			
			order.setStatus(ClickShipOrderStatus.Cancelled);
			orderRepository.save(order);
			
			List<Order> siblings = orderRepository.findAllByParentOrder(order.getParentOrder());
			
			siblings.forEach(child -> {
				child.setOrderRelType(null).setParentOrder(null);
				orderRepository.save(child);
			});
			
			orderRepository.delete(order.getParentOrder());
			sendEmailUtil.sendCancelCombineOrderNotificationEmail(order.getMarketplace(), param);
		}
	}

	@Override
	public List<Order> getByMarketplaceAndOrderNumbers(Marketplace marketplace, List<String> orderNumbers) {
		return orderRepository.findByMarketplaceAndOrderNumberIn(marketplace, orderNumbers);
	}

	@Override
	public List<String> getOrdersByCustomer(String customerId, List<String> statuses) {
		return orderRepository.getAllOrdersForCustomer(customerId, statuses);
	}

	@Override
	public List<Order> getCustomerUnfulfilledOrders(Customer c, List<String> status) {
		return orderRepository.getCustomerUnfulfilledOrders(c.getId(), status);
	}
}

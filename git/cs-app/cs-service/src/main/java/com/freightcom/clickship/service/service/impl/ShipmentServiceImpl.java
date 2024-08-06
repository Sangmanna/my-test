package com.freightcom.clickship.service.service.impl;

import static com.freightcom.clickship.service.service.impl.NotificationServiceImpl.AUTO_FULFILL_ERROR;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.AdvancedShippingRule;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Shipment;
import com.freightcom.clickship.data.entity.common.ClickShipOrderStatus;
import com.freightcom.clickship.data.rep.CarrierRepository;
import com.freightcom.clickship.data.rep.OrderRepository;
import com.freightcom.clickship.data.rep.ShipmentRepository;
import com.freightcom.clickship.event.aop.LogTrackingUpdate;
import com.freightcom.clickship.model.admin.dashboard.ActiveCustomerCountsDTO;
import com.freightcom.clickship.model.admin.dashboard.ActiveCustomerTableDto;
import com.freightcom.clickship.model.admin.dashboard.InActiveCustomerTableDto;
import com.freightcom.clickship.model.admin.dashboard.carriers.CarriersDTO;
import com.freightcom.clickship.model.admin.dashboard.csEarnings.ShipmentsEarningsDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.LabelProcessedTableDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentTrackingDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentTypeCountDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByCountryDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByDayDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByMonthDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByWeekDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByYearDTO;
import com.freightcom.clickship.model.constants.ClickShipJMS;
import com.freightcom.clickship.service.dao.ShipmentDao;
import com.freightcom.clickship.service.service.NotificationService;
import com.freightcom.clickship.service.service.ShipmentService;
import com.freightcom.clickship.service.service.email.ClickShipSupportEmails;
import com.freightcom.clickship.service.service.jms.JMSService;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	private static final String PATTERN_YYYY_M_D_T = "yyyy-M-d HH:mm:ss";

	private static final DateTimeFormatter DTF_YYYY_M_D_T = DateTimeFormatter.ofPattern(PATTERN_YYYY_M_D_T);

	private Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private JMSService jmsService;

	@Autowired
	private ShipmentDao shipmentDao;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CarrierRepository carrierRepository;

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private ClickShipSupportEmails supportEmailUtil;

	@Override
	@Transactional
	@LogTrackingUpdate
	public void updateShipmentTracking(Shipment shipment, String status, String description) {
		shipment.setStatus(status);
		shipment.setStatusDescription(description);

		shipmentRepository.save(shipment);
	}

	@Override
	public void autoFulfillment(Order order, AdvancedShippingRule advancedShippingRule) {
		Marketplace marketplace = order.getMarketplace();
		JSONObject sendToQueue = new JSONObject();
		sendToQueue.put("order_id", order.getId());
		sendToQueue.put("auto_fulfillment_type", "");
		sendToQueue.put("shipping_rule_id", "");
		try {
			if (advancedShippingRule == null) {
				if (!StringUtils.equalsIgnoreCase(order.getShiptoCountry(),
						marketplace.getDefaultAddress().getCountry())) {
					String desc = String.format(AUTO_FULFILL_ERROR, marketplace.getAliasName(), order.getOrderNumber(),
							"international orders should process manually.");
					notificationService.saveAutoFullfillOrderFailNotification(marketplace, order.getOrderNumber(),
							desc);
					order.setStatus(ClickShipOrderStatus.UnFulfilled);
				} else if (StringUtils.isEmpty(order.getServiceTypeCode())
						|| carrierRepository.findByServiceId(order.getServiceTypeCode()) == null) {
					String desc = String.format(AUTO_FULFILL_ERROR, marketplace.getAliasName(), order.getOrderNumber(),
							"order didn't place using clickship rates.");
					notificationService.saveAutoFullfillOrderFailNotification(marketplace, order.getOrderNumber(),
							desc);
					order.setStatus(ClickShipOrderStatus.UnFulfilled);
				} else {
					sendToQueue.put("auto_fulfillment_type", "MarketplaceSetting");
					order.setStatus(ClickShipOrderStatus.AutoFulfill);
					jmsService.send(ClickShipJMS.AUTO_FULFILL_ORDERS, sendToQueue.toString());
					logger.info("Marketplace Setting : Auto filfulment in progress, OrderId : [{}],Customer: [{}]",
							order.getId(), order.getCustomer().getBusinessName());
				}
			} else {
				if (!StringUtils.equalsIgnoreCase(order.getShiptoCountry(),
						marketplace.getDefaultAddress().getCountry())) {
					String desc = String.format(AUTO_FULFILL_ERROR, marketplace.getAliasName(), order.getOrderNumber(),
							"international orders should process manually.");
					notificationService.saveAutoFullfillOrderFailNotification(marketplace, order.getOrderNumber(),
							desc);
					order.setStatus(ClickShipOrderStatus.UnFulfilled);
				} else {
					sendToQueue.put("auto_fulfillment_type", "ShippingRule");
					sendToQueue.put("shipping_rule_id", advancedShippingRule.getId());
					order.setStatus(ClickShipOrderStatus.AutoFulfill);
					jmsService.send(ClickShipJMS.AUTO_FULFILL_ORDERS, sendToQueue.toString());
					logger.info(
							"Shiping Rule : Autofilfulment in progress, OrderId : [{}], Shipping Rule Id : [{}], Customer: [{}]",
							order.getId(), advancedShippingRule.getId(), order.getCustomer().getBusinessName());
				}
			}
			
			orderRepository.save(order);
		} catch (Exception e) {
			logger.error("AUTO Fulfillment failed - Exception while posting message to {} queue, Order Id:[{}]",
					ClickShipJMS.AUTO_FULFILL_ORDERS, order.getId(), e);
			supportEmailUtil.sendEmailToDevelopersForExceptionRecievedByCustomer(order.getId(), e);
		}
	}

	@Override
	public List<ShipmentsCountByWeekDTO> getShipmentsCountByWeek(String from, String to, String agentName) {
		String week1to = (LocalDateTime.parse(to, DTF_YYYY_M_D_T).minusDays(7)).format(DTF_YYYY_M_D_T);
		String week1From = from;

		String week2From = (LocalDateTime.parse(from, DTF_YYYY_M_D_T).plusDays(7)).format(DTF_YYYY_M_D_T);
		String week2To = to;

		return shipmentDao.getShipmentsCountByWeek(week1From, week1to, week2From, week2To, agentName);
	}

	@Override
	public List<ShipmentsCountByMonthDTO> getShipmentsCountByMonth(String from, String to, String agentName) {
		String month2from = (LocalDateTime.parse(from, DTF_YYYY_M_D_T).plusMonths(1)).format(DTF_YYYY_M_D_T);
		String month2To = to;

		String month1From = from;
		String month1to = (LocalDateTime.parse(to, DTF_YYYY_M_D_T).minusMonths(1)).format(DTF_YYYY_M_D_T);

		return shipmentDao.getShipmentsCountByMonth(month1From, month1to, month2from, month2To, agentName);
	}

	@Override
	public List<ShipmentsCountByYearDTO> getShipmentsCountByYear(String from, String to, String agentName) {
		try {
			String from1 = (LocalDateTime.parse(from, DTF_YYYY_M_D_T).minusMonths(6)).format(DTF_YYYY_M_D_T);
			String to1 = (LocalDateTime.parse(from, DTF_YYYY_M_D_T).minusDays(1)).format(DTF_YYYY_M_D_T);

			return shipmentDao.getShipmentsCountByYear(from1, to1, from, to, agentName);
		} catch (Exception e) {
			logger.error("Exception while querying data for 6 months shipments. Error:[{}]", e.getMessage(), e);
		}

		return Collections.emptyList();
	}

	@Override
	public List<ShipmentsCountByDayDTO> getShipmentsCountByDayAndHour(String from, String to, String agentName) {
		try {
			return shipmentDao.getShipmentsCountByDayAndHour(from, to, agentName);
		} catch (Exception e) {
			logger.error("Exception while querying Day: Shipments. Error:[{}]", e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<ShipmentsCountByDayDTO> getExternalOrdersCountByDayAndHour(String from, String to, String agentName) {
		try {
			return shipmentDao.getExternalOrdersCountByDayAndHour(from, to, agentName);
		} catch (Exception e) {
			logger.error("Exception while querying Day: External Orders. Error:[{}]", e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<ShipmentsCountByWeekDTO> getExternalOrdersCountByWeek(String from, String to, String agentName) {
		String week1to = (LocalDateTime.parse(to, DTF_YYYY_M_D_T).minusDays(7)).format(DTF_YYYY_M_D_T);
		String week1From = from;

		String week2From = (LocalDateTime.parse(from, DTF_YYYY_M_D_T).plusDays(7)).format(DTF_YYYY_M_D_T);
		String week2To = to;

		return shipmentDao.getExternalOrdersCountByWeek(week1From, week1to, week2From, week2To, agentName);
	}

	@Override
	public List<ShipmentsCountByMonthDTO> getExternalOrdersCountByMonth(String from, String to, String agentName) {
		String month2from = (LocalDateTime.parse(from, DTF_YYYY_M_D_T).plusMonths(1)).format(DTF_YYYY_M_D_T);
		String month2To = to;

		String month1From = from;
		String month1to = (LocalDateTime.parse(to, DTF_YYYY_M_D_T).minusMonths(1)).format(DTF_YYYY_M_D_T);

		return shipmentDao.getExternalOrdersCountByMonth(month1From, month1to, month2from, month2To, agentName);
	}

	@Override
	public List<ShipmentsCountByYearDTO> getExternalOrdersCountByYear(String from, String to, String agentName) {
		try {
			String from1 = (LocalDateTime.parse(from, DTF_YYYY_M_D_T).minusMonths(6)).format(DTF_YYYY_M_D_T);
			String to1 = (LocalDateTime.parse(from, DTF_YYYY_M_D_T).minusDays(1)).format(DTF_YYYY_M_D_T);

			return shipmentDao.getExternalOrdersCountByYear(from1, to1, from, to, agentName);
		} catch (Exception e) {
			logger.error("Exception while queryinh data for 6 months external orders. Error:[{}]", e.getMessage(), e);
		}

		return Collections.emptyList();
	}

	@Override
	public int getExternalOrdersCountByDateRange(String from, String to, String agentName) {
		try {
			return shipmentDao.getExternalOrdersDateRange(from, to, agentName);

		} catch (Exception e) {
			logger.error("Exception while getting external orders for custom date range. Error:[{}]", e.getMessage(),
					e);
		}
		return 0;
	}

	@Override
	public ShipmentTypeCountDTO getAllShipmentTypesCountByDateRange(String from, String to, String agentName, String serviceType) {
		try {
			return shipmentDao.getAllShipmentTypesCountByDateRange(from, to, agentName, serviceType);

		} catch (Exception e) {
			logger.error("Exception while getting bulkshipments count for custom date range. Error:[{}]",
					e.getMessage(), e);
		}
		return null;
	}

	@Override
	public List<ShipmentsCountByCountryDTO> getShipmentsCountByCountry(String from, String to, String agentName) {
		try {
			Date toDate = new SimpleDateFormat(PATTERN_YYYY_M_D_T).parse(to);
			Date fromDate = new SimpleDateFormat(PATTERN_YYYY_M_D_T).parse(from);

			return shipmentRepository.getShipmentsCountByCountry(fromDate, toDate);

		} catch (ParseException e) {
			logger.error("Exception while parsing date. Error:[{}]", e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	@Override
	public int getShipmentsCountByDateRange(String from, String to, String agentName) {
		try {
			return shipmentDao.getShipmentsCountByDateRange(from, to, agentName);

		} catch (Exception e) {
			logger.error("Exception while getting shipment for custom date range. Error:[{}]", e.getMessage(), e);
		}
		return 0;
	}

	/*
	 * Implementation methods for labels processed charts OCShipments : Own Carrier
	 * Shipments
	 */

	@Override
	public List<ShipmentsCountByDayDTO> getOCShipmentsCountByDayAndHour(String from, String to, String agentName) {
		try {
			return shipmentDao.getOCShipmentsCountByDay(from, to, agentName);
		} catch (Exception e) {
			logger.error(" Error getting OC Shipments query results by day:[{}]", e.getMessage(), e);
		}

		return Collections.emptyList();
	}

	@Override
	public List<ShipmentsCountByWeekDTO> getOCShipmentsCountByWeek(String from, String to, String agentName) {
		String week1to = (LocalDateTime.parse(to, DTF_YYYY_M_D_T).minusDays(7)).format(DTF_YYYY_M_D_T);
		String week1From = from;

		String week2From = (LocalDateTime.parse(from, DTF_YYYY_M_D_T).plusDays(7)).format(DTF_YYYY_M_D_T);
		String week2To = to;
		try {
			return shipmentDao.getOCShipmentsCountByWeek(week1From, week1to, week2From, week2To, agentName);
		} catch (Exception e) {
			logger.error(" Error getting OC Shipments query results by Week:[{}]", e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<ShipmentsCountByMonthDTO> getOCShipmentsCountByMonth(String from, String to, String agentName) {
		String month2from = (LocalDateTime.parse(from, DTF_YYYY_M_D_T).plusMonths(1)).format(DTF_YYYY_M_D_T);
		String month2To = to;

		String month1From = from;
		String month1to = (LocalDateTime.parse(to, DTF_YYYY_M_D_T).minusMonths(1)).format(DTF_YYYY_M_D_T);

		try {
			return shipmentDao.getOCShipmentsCountByMonth(month1From, month1to, month2from, month2To, agentName);
		} catch (Exception e) {
			logger.error(" Error getting OC Shipments query results by Month:[{}]", e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<ShipmentsCountByYearDTO> getOCShipmentsCountByYear(String from, String to, String agentName) {
		try {
			String from1 = (LocalDateTime.parse(from, DTF_YYYY_M_D_T).minusMonths(6)).format(DTF_YYYY_M_D_T);
			String to1 = (LocalDateTime.parse(from, DTF_YYYY_M_D_T).minusDays(1)).format(DTF_YYYY_M_D_T);

			return shipmentDao.getOCShipmentsCountByYear(from1, to1, from, to, agentName);
		} catch (Exception e) {
			logger.error(" Error getting OC Shipments query results by Month:[{}]", e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	@Override
	public int getOCShipmentsCountByDateRange(String from, String to, String agentName) {
		try {
			return shipmentDao.getOCShipmentsCountByDateRange(from, to, agentName);
		} catch (Exception e) {
			logger.error(" Error getting OC Shipments query results by day:[{}]", e.getMessage(), e);
		}

		return 0;
	}

	@Override
	public List<CarriersDTO> getCarriersByDay(String from, String to, String agentName, String type) {
		try {
			return shipmentDao.getCarriersByDay(from, to, agentName, type);
		} catch (Exception e) {
			String rangeStr = "Day: " + from + " to " + to;
			logger.error(" Error getting query results for Carrier Breakdown Chart [RANGE: {}]", rangeStr, e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<CarriersDTO> getCarriersBetweenDays(String from, String to, String agentName, String type) {
		try {
			return shipmentDao.getCarriersBetweenDays(from, to, agentName, type);
		} catch (Exception e) {
			String rangeStr = "Week/Month: " + from + " to " + to;
			logger.error(" Error getting query results for Carrier Breakdown Chart [RANGE: {}] ", rangeStr, e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<CarriersDTO> getCarriersByCustomDateRange(String from, String to, String agentName) {
		try {
			return shipmentDao.getCarriersByCustomDateRange(from, to, agentName);
		} catch (Exception e) {
			String rangeStr = "Week/Month: " + from + " to " + to;
			logger.error(" Error getting query results for Carrier Breakdown Custom range [RANGE: {}] ", rangeStr, e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<ShipmentTrackingDTO> getDataForOrderTable(String from, String to, String agentName,
			String businessName) {
		try {

			return shipmentDao.getOrdersDataForTable(from, to, agentName, businessName);
		} catch (Exception e) {
			logger.error(" Error getting Order Table query results (filter by [{}])", businessName, e);
		}
		return Collections.emptyList();
	}

	@Override
	public ActiveCustomerCountsDTO getActiveCustomerCountsForDashboard(String agentName) {
		try {
			return shipmentDao.getActiveCustomerCountsByShipments(agentName);
		} catch (Exception e) {
			logger.error("Error getting Counts for active Customers on dashboard", e);
		}
		return null;
	}

	@Override
	public List<LabelProcessedTableDTO> getDataForLabelProcessedTable(String from, String to, String agentName,
			String businessName) {
		try {
			return shipmentDao.getLabelProcessedDataForTable(from, to, agentName, businessName);
		} catch (Exception e) {
			logger.error(" Error getting Label Processed data :[{}]", e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<ActiveCustomerTableDto> getActiveCustomersData(String agentName, String from, String to) {
		try {
			return shipmentDao.getActiveCustomers(agentName, from, to);
		} catch (Exception e) {
			logger.error(" Error Getting Active Customer's data :[{}]", e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<InActiveCustomerTableDto> getInActiveCustomersData(String agentName, Integer interval) {
		try {
			return shipmentDao.getInActiveCustomers(agentName, interval);
		} catch (Exception e) {
			logger.error(" Error Getting Inactive Customer's data :[{}]", e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<ShipmentsEarningsDTO> getShipmentsEarnings(String from, String to) {
		try {
			return shipmentDao.getShipmentCostForDay(from, to);
		} catch (Exception e) {
			logger.error(" Error getting Earnings from Shipments query results by day:[{}]", e.getMessage(), e);
		}

		return Collections.emptyList();
	}

	@Override
	public List<ShipmentsEarningsDTO> getShipmentsEarningsForDateRange(String from, String to) {
		try {
			return shipmentDao.getShipmentCostBetweenDateRange(from, to);
		} catch (Exception e) {
			logger.error(" Error getting Earnings from Shipments query results by week/month:[{}]", e.getMessage(), e);
		}

		return Collections.emptyList();
	}

	@Override
	public Integer getActiveCustomerCountsInDateRange(String from, String to, String agentName) {
		try {
			return shipmentDao.getActiveCustomerCountsByShipmentsInDateRange(from, to, agentName);
		} catch (Exception e) {
			logger.error(" Error getting Counts for active Customers on dashboard :[{}]", e.getMessage(), e);
		}
		return null;
	}

	@Override
	public List<String[]> getShipmentCountsForMarketplace(String from, String to, String agentName, String type) {
		try {
			return shipmentDao.getShipmentsByMarketplace(from, to, agentName, type);
		} catch (Exception e) {
			logger.error(" Error getting Counts for active Customers on dashboard :[{}]", e.getMessage());
		}
		return Collections.emptyList();
	}

	/**
	 * @deprecated very slow method with query missing index
	 */
	/**
	 * @deprecated very slow method with query missing index
	 */
	@Override
	public Shipment getShipmentByFCShipmentId(String shipmentId) {
		return shipmentRepository.findByFreightcomOrderId(shipmentId);
	}
	
	@Override
	public Shipment findByFreightcomOrderIdByCustomer(String shipmentId, Customer customer) {
		return shipmentRepository.findByFreightcomOrderIdByCustomer(shipmentId, customer);
	}

	@Override
	public Shipment save(Shipment shipment) {
		return shipmentRepository.save(shipment);
	}

	@Override
	@Transactional
	public void setClaimRaised(String orderId, String claimId) {
		Optional<Order> oOrder = orderRepository.findById(orderId);
		if (oOrder.isPresent()) {
			Shipment shipment = oOrder.get().getShipment();
			if (shipment != null) {
				shipment.setIsClaimsRaised(true);
				shipmentRepository.save(shipment);
			}
		}
		updateClaimStatus(orderId, claimId, "draft");
	}

	@Override
	@Transactional
	public void updateClaimStatus(String orderId, String claimId, String status) {
		Optional<Order> oOrder = orderRepository.findById(orderId);
		if (oOrder.isPresent()) {
			Shipment shipment = oOrder.get().getShipment();
			if (shipment != null) {
				shipment.setClaimId(claimId);
				shipment.setClaimStatus(status);
				shipmentRepository.save(shipment);
			}
		}
	}
}

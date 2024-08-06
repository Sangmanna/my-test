package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.AdvancedShippingRule;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Shipment;
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

public interface ShipmentService {
	
	public void autoFulfillment(Order order, AdvancedShippingRule advancedShippingRule);

	public List<ShipmentsCountByWeekDTO> getShipmentsCountByWeek(String from, String to, String agentName);

	public List<ShipmentsCountByYearDTO> getShipmentsCountByYear(String from, String to, String agentName);

	public List<ShipmentsCountByMonthDTO> getShipmentsCountByMonth(String from, String to, String agentName);

	public List<ShipmentsCountByDayDTO> getShipmentsCountByDayAndHour(String from, String to, String agentName);
	
	public List<ShipmentsCountByDayDTO> getExternalOrdersCountByDayAndHour(String from, String to, String agentName);
	
	public List<ShipmentsCountByWeekDTO> getExternalOrdersCountByWeek(String from, String to, String agentName);

	public List<ShipmentsCountByMonthDTO> getExternalOrdersCountByMonth(String from, String to, String agentName);
	
	public List<ShipmentsCountByYearDTO> getExternalOrdersCountByYear(String from, String to, String agentName);

	public List<ShipmentsCountByCountryDTO> getShipmentsCountByCountry(String from, String to, String agentName);
	
	public int getShipmentsCountByDateRange(String from, String to, String agentName);

	/* [Own Carriers Shipments] Methods for labels processed charts */
	public List<ShipmentsCountByWeekDTO> getOCShipmentsCountByWeek(String from, String to, String agentName);

	public List<ShipmentsCountByYearDTO> getOCShipmentsCountByYear(String from, String to, String agentName);

	public List<ShipmentsCountByMonthDTO> getOCShipmentsCountByMonth(String from, String to, String agentName);

	public List<ShipmentsCountByDayDTO> getOCShipmentsCountByDayAndHour(String from, String to, String agentName);
	
	public int getOCShipmentsCountByDateRange(String from, String to, String agentName);

	/* Carriers Methods for Carrier breakdown charts */
	public List<CarriersDTO> getCarriersByDay(String from, String to, String agentName, String type);

	public List<CarriersDTO> getCarriersBetweenDays(String from, String to, String agentName, String type);

	/* Methods for Tracking page */

	public List<ShipmentTrackingDTO> getDataForOrderTable(String from, String to, String agentName, String string);

	public List<LabelProcessedTableDTO> getDataForLabelProcessedTable(String fromDate, String toDate, String agentName, String string);

	/* Methods for getting active customers based on shipments */
	public ActiveCustomerCountsDTO getActiveCustomerCountsForDashboard(String agentName);

	public List<ActiveCustomerTableDto> getActiveCustomersData(String agentName, String from, String to);

	public List<InActiveCustomerTableDto> getInActiveCustomersData(String agentName, Integer numberOfDays);

	public List<ShipmentsEarningsDTO> getShipmentsEarnings(String fromDate, String toDate);

	public List<ShipmentsEarningsDTO> getShipmentsEarningsForDateRange(String fromDate, String toDate);

//	public List<ShipmentsEarningsDTO> getSumOfShipmentCosts(String fromDate, String toDate);

	public Integer getActiveCustomerCountsInDateRange(String fromDate, String toDate, String agentName);

	public List<String[]> getShipmentCountsForMarketplace(String fromDate, String toDate, String agentName, String type);
	
	public List<CarriersDTO> getCarriersByCustomDateRange(String from, String to, String agentName);

	public int getExternalOrdersCountByDateRange(String from, String to, String agentName);
	
	public ShipmentTypeCountDTO getAllShipmentTypesCountByDateRange(String from, String to, String agentName, String serviceType);
	
	public void updateShipmentTracking(Shipment shipment, String status, String description);

	public Shipment getShipmentByFCShipmentId(String shipmentId);

	public Shipment save(Shipment shipment);
	
	void setClaimRaised(String orderId, String claimId);
	
	void updateClaimStatus(String orderId, String claimId, String status);
	
	Shipment findByFreightcomOrderIdByCustomer(String shipmentId, Customer customer);
}

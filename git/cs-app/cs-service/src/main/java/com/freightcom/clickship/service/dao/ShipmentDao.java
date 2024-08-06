package com.freightcom.clickship.service.dao;

import java.util.List;

import com.freightcom.clickship.model.admin.dashboard.ActiveCustomerCountsDTO;
import com.freightcom.clickship.model.admin.dashboard.ActiveCustomerTableDto;
import com.freightcom.clickship.model.admin.dashboard.InActiveCustomerTableDto;
import com.freightcom.clickship.model.admin.dashboard.carriers.CarriersDTO;
import com.freightcom.clickship.model.admin.dashboard.csEarnings.ShipmentsEarningsDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.LabelProcessedTableDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentTrackingDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentTypeCountDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByDayDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByMonthDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByWeekDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByYearDTO;

public interface ShipmentDao {

	public List<ShipmentsCountByWeekDTO> getShipmentsCountByWeek(String from1, String to1, String from2, String to2, String agentName);

	public List<ShipmentsCountByMonthDTO> getShipmentsCountByMonth(String from1, String to1, String from2, String to2, String agentName);

	public int getShipmentsCountByDateRange(String from, String to, String agentName);

	public List<ShipmentsCountByDayDTO> getOCShipmentsCountByDay(String from, String to, String agentName);

	public List<ShipmentsCountByWeekDTO> getOCShipmentsCountByWeek(String from1, String to1, String from2, String to2,String agentName);

	public List<ShipmentsCountByMonthDTO> getOCShipmentsCountByMonth(String from1, String to1, String from2,
			String to2,String agentName);

	public List<ShipmentsCountByYearDTO> getOCShipmentsCountByYear(String from1, String to1,String from2, String to2, String agentName);

	public int getOCShipmentsCountByDateRange(String from, String to, String agentName);

	public List<CarriersDTO> getCarriersByDay(String from, String to, String agentName, String type);

	public List<CarriersDTO> getCarriersBetweenDays(String from, String to, String agentName, String type);

	public List<ShipmentTrackingDTO> getOrdersDataForTable(String from, String to, String agentName, String businessName);

	public ActiveCustomerCountsDTO getActiveCustomerCountsByShipments(String agentName);

	public List<LabelProcessedTableDTO> getLabelProcessedDataForTable(String from, String to, String agentName, String businessName);

	public List<ShipmentsCountByDayDTO> getShipmentsCountByDayAndHour(String from, String to, String agentName);
	
	public List<ShipmentsCountByDayDTO> getExternalOrdersCountByDayAndHour(String from, String to, String agentName);

	public List<ShipmentsCountByWeekDTO> getExternalOrdersCountByWeek(String from1, String to1, String from2, String to2, String agentName);

	public List<ShipmentsCountByMonthDTO> getExternalOrdersCountByMonth(String from1, String to1, String from2, String to2, String agentName);

	public List<ShipmentsCountByYearDTO> getExternalOrdersCountByYear(String from1, String to1,String from2, String to2, String agentName);

	public List<ShipmentsCountByYearDTO> getShipmentsCountByYear(String from1, String to1,String from2, String to2, String agentName);

	public List<InActiveCustomerTableDto> getInActiveCustomers(String agentName, Integer interval);

	public List<ShipmentsEarningsDTO> getShipmentCostForDay(String from, String to);

	public List<ShipmentsEarningsDTO> getShipmentCostBetweenDateRange(String from, String to);

	public Integer getActiveCustomerCountsByShipmentsInDateRange(String from, String to, String agentName);

	public List<ActiveCustomerTableDto> getActiveCustomers(String agentName, String from, String to);

	public List<String[]> getShipmentsByMarketplace(String from, String to, String agentName, String type);

	public List<CarriersDTO> getCarriersByCustomDateRange(String from, String to, String agentName);

	public int getExternalOrdersDateRange(String from, String to, String agentName);

	public ShipmentTypeCountDTO getAllShipmentTypesCountByDateRange(String from, String to, String agentName, String serviceType);
	
}

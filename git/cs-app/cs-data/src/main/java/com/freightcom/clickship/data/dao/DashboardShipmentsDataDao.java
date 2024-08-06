package com.freightcom.clickship.data.dao;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.freightcom.clickship.data.entity.MarketplaceType;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.rep.MarketplaceTypeRepository;
import com.freightcom.clickship.model.dashboard.CsDashboardDataDTO;
import com.freightcom.clickship.model.db.QueryBindingInfo;
import com.freightcom.clickship.model.enums.CS_ROLE;
import com.freightcom.clickship.model.enums.QUERY_BINDING_TYPE;
import com.freightcom.clickship.model.util.NumberUtility;
import com.freightcom.clickship.model.util.Security;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Component
public class DashboardShipmentsDataDao {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	private static final String USERNAME_JOIN_CLAUSE = "$USERNAME_JOIN$";
	private static final String USERNAME_WHERE_CLAUSE = "$USERNAME_WHERE$";
	
	@PersistenceContext
	protected EntityManager em;
	
	private List<MarketplaceType> encryptedMarketplaceTypes;
	
	private static final String SHIPMENTS_TABLE_BASE_QUERY =
			" SELECT"
			+ " o.order_number,"
		    + " o.id orderId,"
			+ " s.shipto_contact,"
			+ " c.service,"
			+ " o.ship_date,"
		    + " o.shipping_cost,"
			+ " s.status AS shipment_status,"
			+ " s.tracking_number,"
			+ " s.tracking_url,"
			+ " IFNULL(m.alias_name, 'Manual Shipment') AS StoreName,"
			+ " IFNULL(mt.name, 'Manual') AS StoreType,"
			+ " IFNULL(bt.use_custom_branding_tracking, 0) as brandingTracking, "
			+ " s.id shipmentId,"
			+ " m.id,"
			+ " s.shipment_type AS shipmentType "
			+ " FROM shipment s" + USERNAME_JOIN_CLAUSE
			+ " INNER JOIN orders o ON o.id = s.order_id"
			+ " INNER JOIN carrier c ON c.id = s.carrier_code"
			+ " LEFT JOIN marketplace m ON m.id = o.marketplace_id AND m.active is true AND m.is_deleted = '0'"
			+ " LEFT JOIN marketplace_type mt ON mt.id = m.marketplace_type_id"
			+ " LEFT JOIN branding br ON m.id = br.marketplace_id"
			+ " LEFT JOIN branding_tracking_settings bt ON br.id = bt.branding_id"
			+ " WHERE s.customer_id = ?" + USERNAME_WHERE_CLAUSE
		    + " AND s.active = TRUE AND (o.marketplace_id is NULL OR o.marketplace_id=m.id) "
			+ " AND s.created_datetime > (CURDATE() + interval - 28 day)";
	
	

	private static final String USER_SHIPMENTS_WHERE = " AND us.username = ?";
	private static final String USER_SHIPMENTS_JOIN = " INNER JOIN user_shipments us ON s.id = us.shipment_id AND us.active = 1";	
	
	/* ======================== Query Variables Starts ============================== */
	private static final String SHIPMENT_STATUS_IN = " AND s.status IN ";
	private static final String SHIPMENT_STATUS_EQUQAL = " AND s.status = ? ";

	// shipments table
	private static final String MARKETPLACE_NULL_CLAUSE = " AND o.marketplace_id IS NULL";
	private static final String MARKETPLACE_CLAUSE = " AND o.marketplace_id = ? ";
	private static final String LIMIT_CLAUSE = " ORDER BY s.created_datetime DESC LIMIT ? ";
	/* ======================== Query Variables Ends ==============================*/

	/*======================= Data Variables Starts ==============================*/

	private static final String RETURNING = "Returning";
	private static final String WARNING = "Warning";
	private static final String ON_HOLD = "OnHold";

	// shipments table data
	private static final String ALL = "ALL";
	private static final String MANUAL = "manual";
	/* ======================= Data Variables Ends ============================== */
	
	@Autowired
	private MarketplaceTypeRepository marketplaceTypeRepository; 
	
	@PostConstruct
	public void init() {
		encryptedMarketplaceTypes = marketplaceTypeRepository.findAllByOrderBySeq().stream()
				.filter(MarketplaceType::isDataEncrypted).collect(Collectors.toList());
	}

	public List<CsDashboardDataDTO> getShipmentsTableData(User user, String customerId, CsDashboardDataDTO request) {
		StringBuilder queryString = new StringBuilder(SHIPMENTS_TABLE_BASE_QUERY);

		List<QueryBindingInfo> bindingValues = new ArrayList<>();
		bindingValues.add(new QueryBindingInfo(customerId, QUERY_BINDING_TYPE.EQUAL));
		
		addUserCondition(user, queryString, bindingValues);
		
		// SHIPMENT status conditions
		addShipmentStatusCondition(request.getPackageStatus(), queryString, bindingValues);
		// marketplace conditions
		addMarketplaceCondition(request.getMarketplaceId(), queryString, bindingValues);
		// limit clause
		addLimitCondition(request.getSize(), queryString, bindingValues);

		Query query = em.createNativeQuery(queryString.toString());

		bindValues(bindingValues, query);

		@SuppressWarnings("rawtypes")
		List originList = query.getResultList();
		
		return extractResult(originList);
	}
	
	public void bindValues(List<QueryBindingInfo> list, Query nativeQuery) {
		for (int i = 0; i < list.size(); i++) {
			QueryBindingInfo bindingInfo = list.get(i);
			Object value = bindingInfo.getValue();
			nativeQuery.setParameter(i + 1, bindingInfo.isEqualBinding() ? value : "%" + value + "%");
		}
	}

	@SuppressWarnings("rawtypes")
	private List<CsDashboardDataDTO> extractResult(List originList) {
		List<CsDashboardDataDTO> list = new ArrayList<>();
		try {
			for (int i = 0; i < originList.size(); i++) {
				Object[] results = (Object[]) originList.get(i);
				CsDashboardDataDTO shipment = new CsDashboardDataDTO();
				shipment.setOrderNumber((String) results[0]);
				shipment.setOrderId((String) results[1]);
				shipment.setServiceType((String) results[3]);
				shipment.setShipDate((Date) (results[4] instanceof Timestamp ? new Date(((Timestamp) results[4]).getTime()) : results[4]));
				shipment.setShippingCost(NumberUtility.getSafeCheckFloatValue((Float) results[5]));
				shipment.setShipmentStatus((String) results[6]);
				shipment.setTrackingNumber((String) results[7]);
				shipment.setTrackingURL((String) results[8]);
				shipment.setStoreAlias((String) results[9]);
				shipment.setStoreType((String) results[10]);
				shipment.setUseBrandingTracking(getUseBrandingTrackingValue(results[11]));
				shipment.setShipmentId((String) results[12]);
				shipment.setMarketplaceId((String) results[13]);
				shipment.setShipmentType((String) results[14]);
				
				shipment.setShiptoAttention(getShiptoAttention(shipment.getStoreType(), (String) results[2]));

				list.add(shipment);
			}
		} catch (Exception ex) {
			logger.debug("Error", ex);
		}
		return list;
	}

	private void addMarketplaceCondition(String marketplaceId, StringBuilder queryString, List<QueryBindingInfo> bindingValues) {
		if (!StringUtils.equalsIgnoreCase(ALL, marketplaceId)) {
			if (StringUtils.equalsIgnoreCase(MANUAL, marketplaceId)) {
				queryString.append(MARKETPLACE_NULL_CLAUSE);
			} else {
				queryString.append(MARKETPLACE_CLAUSE);
				bindingValues.add(new QueryBindingInfo(marketplaceId, QUERY_BINDING_TYPE.EQUAL));
			}
		}
	}

	private void addShipmentStatusCondition(String packageStatus, StringBuilder queryString, List<QueryBindingInfo> bindingValues) {
		if (!StringUtils.equalsAnyIgnoreCase(packageStatus, ALL)) {
			if (StringUtils.equalsAnyIgnoreCase(packageStatus, WARNING)) {
				queryString.append(SHIPMENT_STATUS_IN).append("(" + String.format("'%s','%s','%s'", ON_HOLD, WARNING, RETURNING) + ") ");
			} else {
				queryString.append(SHIPMENT_STATUS_EQUQAL);
				bindingValues.add(new QueryBindingInfo(packageStatus, QUERY_BINDING_TYPE.EQUAL));
			}
		}
	}

	private void addLimitCondition(String size, StringBuilder queryString, List<QueryBindingInfo> bindingValues) {
		queryString.append(LIMIT_CLAUSE);
		bindingValues.add(new QueryBindingInfo(NumberUtility.parseIntOrDefault(size, 10), QUERY_BINDING_TYPE.EQUAL));
	}
	
	private void addUserCondition(User user, StringBuilder query, List<QueryBindingInfo> bindingValues) {
		if (StringUtils.equalsIgnoreCase(CS_ROLE.CUSTOMER.toString(), user.getUserRole())
				|| StringUtils.equalsIgnoreCase(CS_ROLE.USER.toString(), user.getUserRole()) && StringUtils.equalsIgnoreCase("admin", user.getUserDefinedRole())) {
			query.replace(query.indexOf(USERNAME_JOIN_CLAUSE), query.indexOf(USERNAME_JOIN_CLAUSE) + USERNAME_JOIN_CLAUSE.length(), "");
			query.replace(query.indexOf(USERNAME_WHERE_CLAUSE), query.indexOf(USERNAME_WHERE_CLAUSE) + USERNAME_WHERE_CLAUSE.length(), "");
		} else {
			query.replace(query.indexOf(USERNAME_JOIN_CLAUSE), query.indexOf(USERNAME_JOIN_CLAUSE) + USERNAME_JOIN_CLAUSE.length(), USER_SHIPMENTS_JOIN);
			query.replace(query.indexOf(USERNAME_WHERE_CLAUSE), query.indexOf(USERNAME_WHERE_CLAUSE) + USERNAME_WHERE_CLAUSE.length(), USER_SHIPMENTS_WHERE);
			
			bindingValues.add(new QueryBindingInfo(user.getUsername(), QUERY_BINDING_TYPE.EQUAL));
		}
	}
	
	private boolean getUseBrandingTrackingValue(Object obj) {
		if (obj instanceof BigInteger) {
			return ((java.math.BigInteger) obj).intValue() == 1;
		} else {
			return (Long) obj == 1;
		}
	}
	
	private String getShiptoAttention(String marketplaceType, String value) {
		if (encryptedMarketplaceTypes.stream().anyMatch(mt -> mt.getName().equals(marketplaceType))) {
			return Security.decryptPII(value);
		}

		return value;
	}
}

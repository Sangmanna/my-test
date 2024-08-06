package com.freightcom.clickship.event.service.impl;

import static com.freightcom.clickship.model.constants.ClickShipConstants.UNIQUE_DATA_SEPERATOR;

import java.text.Normalizer;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freightcom.clickship.data.entity.AdvShippingRuleCondition;
import com.freightcom.clickship.data.entity.AdvancedShippingRule;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.OrderShippingRule;
import com.freightcom.clickship.data.entity.ShippingRuleMarketplace;
import com.freightcom.clickship.data.rep.AdvancedShippingRuleRepository;
import com.freightcom.clickship.data.rep.OrderShippingRuleRepository;
import com.freightcom.clickship.data.rep.ShippingRuleMarketplaceRepository;
import com.freightcom.clickship.event.service.AdvanceShippingRuleService;
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.exception.ShippingRuleException;
import com.freightcom.clickship.model.shippingrules.AdvShippingRuleType;
import com.freightcom.clickship.model.shippingrules.ShippingRuleFieldType;
import com.freightcom.clickship.model.shippingrules.ShippingRuleOperator;

@Service
public class AdvanceShippingRuleServiceImpl implements AdvanceShippingRuleService {

	private static final List<String> PO_BOX_STRINGS=Arrays.asList("P.O.","PO","PO.","P.O","P.O BOX","PO BOX","POBOX","P O BOX","P.O. BOX","BOÎTE POSTALE","BOÎTE AUX LETTRES");

	@Autowired
	AdvancedShippingRuleRepository advancedShippingRuleRepository;

	@Autowired
	OrderShippingRuleRepository orderShippingRuleRepository;

	@Autowired
	ShippingRuleMarketplaceRepository shippingRuleMarketplaceRepository;

	@Override
	public AdvancedShippingRule getFirstApplicableOrderShippingRule(Order order) {
		List<AdvancedShippingRule> advancedShippingRules = advancedShippingRuleRepository
				.findByCustomerAndRuleTypeAndActiveOrderByPriorityAsc(order.getCustomer(),
						AdvShippingRuleType.ORDER_RULE.toString(), true);
		if (advancedShippingRules != null && advancedShippingRules.isEmpty()) {
			return null;
		}
		for (AdvancedShippingRule advancedShippingRule : advancedShippingRules) {
			
			if(!isWithinDateRange(advancedShippingRule)) {
				continue;
			}
			if (advancedShippingRule.getShippingRuleAction() != null) {

				boolean allConditionsMatched = checkAllConditionMatch(advancedShippingRule.getShippingRuleConditions(),
						order);
				if (allConditionsMatched) {
					return advancedShippingRule;
				}
			}
		}
		return null;
	}

	private boolean checkAllConditionMatch(List<AdvShippingRuleCondition> advShippingRuleConditions, Order order) {
		for (AdvShippingRuleCondition condition : advShippingRuleConditions) {
			if (!validateCondition(condition, order)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isWithinDateRange(AdvancedShippingRule advancedShippingRule) {
		if(advancedShippingRule.startDate != null && advancedShippingRule.endDate !=null) {
			// Current time in UTC
			Instant currentTime = Instant.now();
			Instant ruleStartDate = advancedShippingRule.startDate.toInstant();
		    Instant ruleEndDate = advancedShippingRule.endDate.toInstant();
		    return currentTime.isAfter(ruleStartDate) && currentTime.isBefore(ruleEndDate);
		}
		return true;
	}

	private boolean validateCondition(AdvShippingRuleCondition condition, Order order) {
		ShippingRuleFieldType fieldType = ShippingRuleFieldType.valueOf(condition.getField());
		ShippingRuleOperator operatorType = ShippingRuleOperator.valueOf(condition.getOperator());
		String value1 = condition.getValue1();
		String value2 = condition.getValue2();
		String value3 = condition.getValue3();
		String units = condition.getUnits();

		switch (fieldType) {
		case ORDER_WEIGHT:
			return validateOrderWeight(operatorType, value1, value2, units, order);
		case ORDER_DATE:
			return validateDateField(operatorType, condition.getOrderDateStart(), condition.getOrderDateEnd(),
					order.getOrderDate());
		case MARKETPLACE:
			return validateMarketplace(operatorType,shippingRuleMarketplaceRepository.findByAdvShippingRuleCondition(condition), order);
		case CUSTOMER_NAME:
			return validateCustomerName(operatorType, value1, order);
		case PRODUCT_TITLE:
			return validateProductTitle(operatorType, value1, value2, order);
		case SKU:
			return validateProductSku(operatorType, value1, value2, order);
		case ORDER_VALUE:
			return validateOrderValue(operatorType, value1, value2, units, order);
		case SHIPPING_DESTINATION:
			return validateShippingDestination(operatorType, value1, value2, value3, order);
		default:
			return false;
		}
	}

	private boolean validateOrderWeight(ShippingRuleOperator operatorType, String value1, String value2, String units,
			Order order) {
		
		if(order.getOrderlines() == null || order.getOrderlines().isEmpty()) {
			return false;
		}
		double totalWeight = order.getOrderlines().stream().mapToDouble(orderline -> {
			Integer quantity = orderline.getQuantity();
        	int quantityValue = (quantity != null) ? quantity : 0;
		    if (ClickShipConstants.LBS.equalsIgnoreCase(units)) {
		        if (orderline.getMarketplaceProduct() != null) {		        	
		            return orderline.getMarketplaceProduct().getWeight() * quantityValue;
		        } else {
		            return orderline.getWeight() * quantityValue;
		        }
		    } else {
		        if (orderline.getMarketplaceProduct() != null) {
		            return orderline.getMarketplaceProduct().getWeightMetric() * quantityValue;
		        } else {
		            return orderline.getWeightMetric() * quantityValue;
		        }
		    }
		}).sum();
		return validateNumericField(operatorType, value1, value2, totalWeight);
	}

	private boolean validateMarketplace(ShippingRuleOperator operatorType,
			List<ShippingRuleMarketplace> shippingRuleMarketplaces, Order order) {
		return shippingRuleMarketplaces.stream().map(ShippingRuleMarketplace::getMarketplace).map(Marketplace::getId)
				.anyMatch(id -> validateStringField(operatorType, id, order.getMarketplace().getId()));
	}

	private boolean validateCustomerName(ShippingRuleOperator operatorType, String value1, Order order) {
		return value1 != null && validateStringArrayField(operatorType, value1.split(UNIQUE_DATA_SEPERATOR),
				order.getShiptoContact());
	}

	private boolean validateProductTitle(ShippingRuleOperator operatorType, String value1, String value2, Order order) {
		boolean valid = false;
		if(order.getOrderlines() == null || order.getOrderlines().isEmpty()) {
			return false;
		}
		if (ShippingRuleOperator.ONLY_PRODUCT_IN_AN_ORDER.equals(ShippingRuleOperator.valueOf(value2))) {
		    valid = order.getOrderlines().stream()
		        .map(orderline -> {
		            if (orderline.getMarketplaceProduct() != null) {
		                return orderline.getMarketplaceProduct().getTitle();
		            } else {
		                return orderline.getTitle();
		            }
		        })
		        .allMatch(title -> title != null && value1 != null
		            && validateStringArrayField(operatorType, value1.split(UNIQUE_DATA_SEPERATOR), title));
		} else if (ShippingRuleOperator.MULTIPLE_PRODUCTS_IN_AN_ORDER.equals(ShippingRuleOperator.valueOf(value2))) {
		    valid = order.getOrderlines().stream()
		        .map(orderline -> {
		            if (orderline.getMarketplaceProduct() != null) {
		                return orderline.getMarketplaceProduct().getTitle();
		            } else {
		                return orderline.getTitle();
		            }
		        })
		        .anyMatch(title -> title != null && value1 != null
		            && validateStringArrayField(operatorType, value1.split(UNIQUE_DATA_SEPERATOR), title));
		}
		return valid;
	}

	private boolean validateProductSku(ShippingRuleOperator operatorType, String value1, String value2, Order order) {
		boolean valid = false;
		if(order.getOrderlines() == null || order.getOrderlines().isEmpty()) {
			return false;
		}
		if (ShippingRuleOperator.ONLY_PRODUCT_IN_AN_ORDER.equals(ShippingRuleOperator.valueOf(value2))) {
		    valid = order.getOrderlines().stream()
		        .map(orderline -> {
		            if (orderline.getMarketplaceProduct() != null) {
		                return orderline.getMarketplaceProduct().getSku();
		            } else {
		                return orderline.getSku();
		            }
		        })
		        .allMatch(title -> title != null && value1 != null
		            && validateStringArrayField(operatorType, value1.split(UNIQUE_DATA_SEPERATOR), title));
		} else if (ShippingRuleOperator.MULTIPLE_PRODUCTS_IN_AN_ORDER.equals(ShippingRuleOperator.valueOf(value2))) {
		    valid = order.getOrderlines().stream()
		        .map(orderline -> {
		            if (orderline.getMarketplaceProduct() != null) {
		                return orderline.getMarketplaceProduct().getSku();
		            } else {
		                return orderline.getSku();
		            }
		        })
		        .anyMatch(sku -> sku != null && value1 != null
		            && validateStringArrayField(operatorType, value1.split(UNIQUE_DATA_SEPERATOR), sku));
		}
		return valid;
	}

	private boolean validateOrderValue(ShippingRuleOperator operatorType, String value1, String value2, String units,
			Order order) {
		if(order.getOrderlines() == null || order.getOrderlines().isEmpty()) {
			return false;
		}
		double totalPrice = order.getOrderlines().stream().mapToDouble(orderline -> {
			Integer quantity = orderline.getQuantity();
        	int quantityValue = (quantity != null) ? quantity : 0;
            return orderline.getMarketplaceProduct() != null && orderline.getMarketplaceProduct().getPrice() != null ? orderline.getMarketplaceProduct().getPrice() * quantityValue : 0.0d;
		}).sum();
		return validateNumericField(operatorType, value1, value2, totalPrice);
	}

	private boolean validateNumericField(ShippingRuleOperator operator, String conditionValue1, String conditionValue2,
			double actualValue) {
		double numericValue1 = Double.parseDouble(conditionValue1);
		switch (operator) {
		case EQUALS:
			return actualValue == numericValue1;
		case DOES_NOT_EQUALS:
			return actualValue != numericValue1;
		case IS_GREATER_THAN:
			return actualValue > numericValue1;
		case IS_LESS_THAN:
			return actualValue < numericValue1;
		case IS_GREATER_THAN_OR_EQUAL_TO:
			return actualValue >= numericValue1;
		case IS_LESS_THAN_OR_EQUAL_TO:
			return actualValue <= numericValue1;
		case IS_BETWEEN:
			double minValue = Double.parseDouble(conditionValue1);
			double maxValue = Double.parseDouble(conditionValue2);
			return actualValue >= minValue && actualValue <= maxValue;
		default:
			return false;
		}
	}

	private boolean validateDateField(ShippingRuleOperator operator, Date conditionOrderStartDate,
			Date conditionOrderEndDate, Date orderDate) {

		LocalDate startDate = null;
		LocalDate endDate = null;
		LocalDate actualOrderDate = orderDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if(conditionOrderStartDate != null) {
			startDate = conditionOrderStartDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		}else {
			return false;
		}
		if(conditionOrderEndDate != null) {
			endDate = conditionOrderEndDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		}
		switch (operator) {
		case EQUALS:			
			return actualOrderDate.isEqual(startDate);
		case DOES_NOT_EQUALS:
			return !actualOrderDate.isEqual(startDate);
		case IS_ON_OR_BEFORE:
			return actualOrderDate.isBefore(startDate) || actualOrderDate.isEqual(startDate);
		case IS_ON_OR_AFTER:
			return actualOrderDate.isAfter(startDate) || actualOrderDate.isEqual(startDate);
		case IS_BETWEEN:
			if(startDate == null || endDate == null) {
				return false;
			}
			return (actualOrderDate.isAfter(startDate) || actualOrderDate.isEqual(startDate)) 
					&& (actualOrderDate.isBefore(endDate) || actualOrderDate.isEqual(startDate));
		default:
			return false;
		}
	}

	private boolean validateStringField(ShippingRuleOperator operator, String conditionValue1, String actualValue) {
		if (StringUtils.isEmpty(actualValue) || StringUtils.isEmpty(conditionValue1)) {
			return false;
		}
		switch (operator) {
		case EQUALS:
			return actualValue.toLowerCase().equalsIgnoreCase(conditionValue1.toLowerCase());
		case DOES_NOT_EQUALS:
			return !actualValue.toLowerCase().equalsIgnoreCase(conditionValue1.toLowerCase());
		case STARTS_WITH:
			return actualValue.toLowerCase().startsWith(conditionValue1.toLowerCase());
		case DOES_NOT_STARTS_WITH:
			return !actualValue.toLowerCase().startsWith(conditionValue1.toLowerCase());
		case ENDS_WITH:
			return actualValue.toLowerCase().endsWith(conditionValue1.toLowerCase());
		case DOES_NOT_ENDS_WITH:
			return !actualValue.toLowerCase().endsWith(conditionValue1.toLowerCase());
		case CONTAINS:
			return actualValue.toLowerCase().contains(conditionValue1.toLowerCase());
		case INCLUDES:
			return actualValue.toLowerCase().indexOf(conditionValue1.toLowerCase()) >= 0;
		case DOES_NOT_INCLUDE:
			return actualValue.toLowerCase().indexOf(conditionValue1.toLowerCase()) < 0;
		default:
			return false;
		}
	}

	private boolean validateShippingDestination(ShippingRuleOperator operator, String conditionValue1, String conditionValue2, String conditionValue3, Order order) {
		List<String> conditionValuesList1 = (conditionValue1 != null) ? Arrays.asList(conditionValue1.split(UNIQUE_DATA_SEPERATOR)) : Collections.emptyList();
		List<String> conditionValuesList2 = (conditionValue2 != null) ? Arrays.asList(conditionValue2.split(UNIQUE_DATA_SEPERATOR)) : Collections.emptyList();
	    boolean isMatching = false;
	    switch (operator) {
	        case WITHIN_CANADA:
	        case WITHIN_US:
	            if (!conditionValuesList1.isEmpty() && conditionValuesList1.stream().anyMatch(condition -> condition.equalsIgnoreCase(order.getShiptoProvinceState()))) {
	            	isMatching = true;
	            }
	            if (!isMatching && !conditionValuesList2.isEmpty() && order.getShiptoZip() != null) {
	            	isMatching = conditionValuesList2.stream().anyMatch(condition -> {
	                    if (condition.endsWith("*")) {
	                        String prefix = condition.substring(0, condition.length() - 1);
	                        return order.getShiptoZip().replace(" ", "").startsWith(prefix.replace(" ", ""));
	                    } else {
	                        return order.getShiptoZip().replace(" ", "").equalsIgnoreCase(condition.replace(" ", ""));
	                    }
	                });
	            }
	            
	            if(isMatching && conditionValue3 != null && conditionValue3.equalsIgnoreCase("pobox")) {
	            	isMatching = PO_BOX_STRINGS.stream()
	                        .anyMatch(poString -> normalizeString(order.getShiptoAddress1()).contains(normalizeString(poString)) ||
	                        		normalizeString(order.getShiptoAddress2()).contains(normalizeString(poString)));
	            }
	            return isMatching;
	        case INTERNATIONAL:
	            return !conditionValuesList1.isEmpty() && conditionValuesList1.stream().anyMatch(condition -> condition.equalsIgnoreCase(order.getShiptoCountry()));
	        default:
	            return false;
	    }
	}
	
	// Helper method to normalize a string by removing accents
	private static String normalizeString(String input) {
		if(StringUtils.isEmpty(input)) {
			return "";
		}
	    return Normalizer.normalize(input, Normalizer.Form.NFD)
	            .replaceAll("[^\\p{ASCII}]", "") // Remove non-ASCII characters (including accents)
	            .toLowerCase()
	            .trim();
	}
	
	private boolean validateStringArrayField(ShippingRuleOperator operatorType, String[] conditionValues,
			String actualValue) {
		List<String> conditionValuesList = Arrays.asList(conditionValues);
		boolean allEmpty = conditionValuesList.stream().allMatch(String::isEmpty);
		if (allEmpty || StringUtils.isEmpty(actualValue)) {
			return false;
		}
		switch (operatorType) {
		case EQUALS:
			return conditionValuesList.stream().anyMatch(condition -> condition.equalsIgnoreCase(actualValue));
		case DOES_NOT_EQUALS:
			return conditionValuesList.stream().noneMatch(condition -> condition.equalsIgnoreCase(actualValue));
		case CONTAINS:
		case INCLUDES:
			return conditionValuesList.stream()
					.anyMatch(condition -> actualValue.toLowerCase().contains(condition.toLowerCase()));
		case DOES_NOT_INCLUDE:
			return conditionValuesList.stream()
					.noneMatch(condition -> actualValue.toLowerCase().contains(condition.toLowerCase()));
		case STARTS_WITH:
			return conditionValuesList.stream()
					.anyMatch(condition -> actualValue.toLowerCase().contains(condition.toLowerCase()));
		case DOES_NOT_STARTS_WITH:
			return conditionValuesList.stream()
					.noneMatch(condition -> actualValue.toLowerCase().contains(condition.toLowerCase()));
		case ENDS_WITH:
			return conditionValuesList.stream()
					.anyMatch(condition -> actualValue.toLowerCase().contains(condition.toLowerCase()));
		case DOES_NOT_ENDS_WITH:
			return conditionValuesList.stream()
					.noneMatch(condition -> actualValue.toLowerCase().contains(condition.toLowerCase()));
		default:
			return false;
		}
	}

	@Override
	public void checkAndCreateRTROrderShippingRule(Order order, String shippingRuleId) {
		Optional<AdvancedShippingRule> optionalValue = advancedShippingRuleRepository.findById(shippingRuleId);

	    if (!optionalValue.isPresent()) {
	        return;  
	    }

	    AdvancedShippingRule advancedShippingRule = optionalValue.get();

	    if (order.getOrderShippingRules() != null && order.getOrderShippingRules().stream()
	            .anyMatch(rule -> rule.getAdvancedShippingRule().getId().equals(advancedShippingRule.getId()))) {
	        return;  // Rule already exists, no need to add it again
	    }

	    OrderShippingRule orderShippingRule = new OrderShippingRule();
	    orderShippingRule.setAdvancedShippingRule(advancedShippingRule);
	    orderShippingRule.setOrder(order);
	    orderShippingRule.setActive(true);
	    if (order.getOrderShippingRules() == null) {
	        order.setOrderShippingRules(new ArrayList<>());
	    }
	    order.getOrderShippingRules().add(orderShippingRule);
	}

	@Override
	public AdvancedShippingRule getFirstApplicableRTRShippingRule(Order order) throws ShippingRuleException {
		List<AdvancedShippingRule> advancedShippingRules = advancedShippingRuleRepository
				.findByCustomerAndRuleTypeAndActiveOrderByPriorityAsc(order.getCustomer(),
						AdvShippingRuleType.REAL_TIME_RATE_RULE.toString(), true);
		if (advancedShippingRules != null && advancedShippingRules.isEmpty()) {
			return null;
		}
		for (AdvancedShippingRule advancedShippingRule : advancedShippingRules) {
			if(!isWithinDateRange(advancedShippingRule)) {
				continue;
			}
			boolean allConditionsMatched = checkAllConditionMatch(advancedShippingRule.getShippingRuleConditions(),
					order);
			if (allConditionsMatched) {
				return advancedShippingRule;
			}
		}
		return null;
	}

}

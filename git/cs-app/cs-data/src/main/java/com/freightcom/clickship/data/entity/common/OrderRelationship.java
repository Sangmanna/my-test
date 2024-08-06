package com.freightcom.clickship.data.entity.common;

import org.apache.commons.lang3.StringUtils;

import com.freightcom.clickship.data.entity.Order;

public enum OrderRelationship {
	
	SPLITTED_CHILD("SC"),
	SPLITTED_PARENT("SP"),
	COMBINED_CHILD("CC"),
	COMBINED_PARENT("CP"),
	FULFILLMENT_ORDER("FO"),
	FULFILLMENT_ORDER_PARENT("FOP");
	
	private String type;
	
	OrderRelationship(String type) {
		this.type = type;
	}

    public String getType() {
    	return type;
    }
    
	public static boolean isSplittedChild(Order order) {
		if (order == null) {
			return false;
		} else {
			return StringUtils.equals(order.getOrderRelType(), SPLITTED_CHILD.getType());
		}
	}
	
	public static boolean isSplittedParent(Order order) {
		if (order == null) {
			return false;
		} else {
			return StringUtils.equals(order.getOrderRelType(), SPLITTED_PARENT.getType());
		}
	}
	
	public static boolean isCombinedChild(Order order) {
		if (order == null) {
			return false;
		} else {
			return StringUtils.equals(order.getOrderRelType(), COMBINED_CHILD.getType());
		}
	}
	
	public static boolean isCombinedParent(Order order) {
		if (order == null) {
			return false;
		} else {
			return StringUtils.equals(order.getOrderRelType(), COMBINED_PARENT.getType());
		}
	}
	
	public static boolean isFulfillmentOrderParent(Order order) {
		if (order == null) {
			return false;
		} else {
			return StringUtils.equals(order.getOrderRelType(), FULFILLMENT_ORDER_PARENT.getType());
		}
	}
	
	public static boolean isFulfillmentOrder(Order order) {
		if (order == null) {
			return false;
		} else {
			return StringUtils.equals(order.getOrderRelType(), FULFILLMENT_ORDER.getType());
		}
	}
}

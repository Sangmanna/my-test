package com.freightcom.clickship.model.shippingrules;

public enum ShippingRuleOperator {
	EQUALS("Equals to"),
	DOES_NOT_EQUALS("Not equals to"),
	IS_GREATER_THAN("Greater than"),
	IS_GREATER_THAN_OR_EQUAL_TO("Greater than or equal to"),
	IS_LESS_THAN("Less Than"),
	IS_LESS_THAN_OR_EQUAL_TO("Less than or equal to"),
	IS_BETWEEN("Between"),
	IS_ON_OR_BEFORE("On or before"),
	IS_ON_OR_AFTER("On or after"),
	STARTS_WITH("Starts with"),
	DOES_NOT_STARTS_WITH("Do not starts with"),
	ENDS_WITH("Ends with"),
	DOES_NOT_ENDS_WITH("Does not end with"),
	CONTAINS("contains"),
	INCLUDES("includes"),
	DOES_NOT_INCLUDE("Does not include"),
	WITHIN_CANADA("With in Canada"),
	WITHIN_US("With in US"),
	INTERNATIONAL("International"),
	ONLY_PRODUCT_IN_AN_ORDER("Only Product in an Order"),
	MULTIPLE_PRODUCTS_IN_AN_ORDER("Multiple Products in an Order");

	private String type;

	ShippingRuleOperator(String s) {
		this.type = s;
	}

	public String getType() {
		return type;
	}
}

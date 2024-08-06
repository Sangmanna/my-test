package com.freightcom.clickship.model.shippingrules;

public class ShippingRuleConstants {
	
    private ShippingRuleConstants() {
		super();
	}
    
	public static final String SHIPPING_RULE_PROPERTY = "SHIPPING_RULE_PROPERTY";
    public static final String SHIPPING_RULE_ACTION = "SHIPPING_RULE_ACTION";
    public static final String SAME_AS_ORDER_VALUE = "Same as Order Value";
    public static final String WEIGHT_METRIC = "kg";
    public static final String WEIGHT_IMPERIAL = "lbs";
    public static final String CREATE_CUSTOM_PACKAGE = "Create Custom Package";
   
	public static final String SHIPPING_RULE_NOT_FOUND = "Shipping Rule Not Found";
    public static final String SHIPPING_RULE_ACTION_NOT_FOUND = "Shipping Rule Action Not Found";
    public static final String ACTION_VALUE_NOT_ACCEPTABLE = "Shipping Rule Action value not acceptable";
    public static final String APPLY_SHIPPING_RULE_EXCEPTION = "Exception during shipping rule action processing";
    public static final String ORDER_NOT_FOUND = "Order not found";
    public static final String SHIPPING_RULE_ALREADY_EXIST = "Shipping Rule Already exist";
    public static final String GET_ALL_SHIPPING_RULE_EXCEPTION = "Exception during getting all shipping rules.";
    public static final String DELETE_SHIPPING_RULE_EXCEPTION = "Shipping rule deletion is not successful";
    public static final String UPDATE_SHIPPING_RULE_EXCEPTION = "Shipping rule update is not successful";
    public static final String ADD_SHIPPING_RULE_EXCEPTION = "Something went wrong during new shipping rule addition";
    public static final String FINDING_MATCHING_RULE_EXCEPTION = "Something went wrong on finding first matching rule";
    public static final String SHIPPING_RULE_GENERAL_EXCEPTION = "Shipping Rule module not working as expected";
}

package com.freightcom.clickship.model.shippingrules;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ShippingRuleEligibleOrders {
	UNFULFILLED("Unfulfilled"),
	PENDING("Pending");
	// Add more statuses as needed

	private final String value;

	ShippingRuleEligibleOrders(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static List<String> getAllValues() {
		return Arrays.stream(ShippingRuleEligibleOrders.values())
				.map(ShippingRuleEligibleOrders::getValue)
				.collect(Collectors.toList());
	}
	
	public static boolean isValidOrderStatus(String status) {
        return Arrays.stream(ShippingRuleEligibleOrders.values())
                .anyMatch(enumStatus -> enumStatus.getValue().equals(status));
    }
}

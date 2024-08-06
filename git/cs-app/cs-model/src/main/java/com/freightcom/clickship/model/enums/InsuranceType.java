package com.freightcom.clickship.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum InsuranceType {
	
	FREIGHTCOM(1),
	OWN_CARRIER(2);

    private int value;
    private static Map<Integer, InsuranceType> map = new HashMap<>();

    private InsuranceType(int value) {
        this.value = value;
    }

    static {
        for (InsuranceType insuranceType : InsuranceType.values()) {
            map.put(insuranceType.value, insuranceType);
        }
    }

    public static InsuranceType valueOf(int insuranceType) {
        return (InsuranceType) map.get(insuranceType);
    }

    public int getValue() {
        return value;
    }
}

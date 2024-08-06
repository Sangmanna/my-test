package com.freightcom.clickship.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ShopifyWebhookFailureStatus {
	
	READY(0),
	SUCCESS(1),
	FAIL(2);

    private int value;
    private static Map<Integer, ShopifyWebhookFailureStatus> map = new HashMap<>();

    private ShopifyWebhookFailureStatus(int value) {
        this.value = value;
    }

    static {
        for (ShopifyWebhookFailureStatus shopifyWebhookFailureStatus : ShopifyWebhookFailureStatus.values()) {
            map.put(shopifyWebhookFailureStatus.value, shopifyWebhookFailureStatus);
        }
    }

    public static ShopifyWebhookFailureStatus valueOf(int shopifyWebhookFailureStatus) {
        return (ShopifyWebhookFailureStatus) map.get(shopifyWebhookFailureStatus);
    }

    public int getValue() {
        return value;
    }
}

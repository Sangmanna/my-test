package com.freightcom.clickship.model.marketplace.woocommerce;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum GeneralSettingsLabel {
	
	CITY("woocommerce_store_city"),
	CURRENCY("woocommerce_currency"),
	ADDRESS_LINE_1("woocommerce_store_address"),
	ADDRESS_LINE_2("woocommerce_store_address_2"),
	POSTCODE_OR_ZIP("woocommerce_store_postcode"),
	COUNTRY_OR_STATE("woocommerce_default_country");
	
    private String value;
    
	private GeneralSettingsLabel(){
		this.value = name();
	}

    private GeneralSettingsLabel(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
    
    @JsonCreator
    public static GeneralSettingsLabel forValue(String value) {
      return Arrays.stream(GeneralSettingsLabel.values())
    		  .filter(pt -> StringUtils.equals(pt.value, value))
    		  .findFirst()
    		  .orElse(null);
    }
    
	public String toString() {
		return value;
	}
}

package com.freightcom.clickship.model.marketplace.woocommerce;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductSettingLabel {
	
	WEIGHT_UNIT("woocommerce_weight_unit"),
	DIMENSION_UNIT("woocommerce_dimension_unit");
	
    private String value;
    
    private ProductSettingLabel(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
    
    @JsonCreator
    public static ProductSettingLabel forValue(String value) {
      return Arrays.stream(ProductSettingLabel.values())
    		  .filter(pt -> StringUtils.equals(pt.value, value))
    		  .findFirst()
    		  .orElse(null);
    }
    
	public String toString() {
		return value;
	}
}

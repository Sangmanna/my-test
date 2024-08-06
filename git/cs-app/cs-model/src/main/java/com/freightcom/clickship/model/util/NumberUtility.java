package com.freightcom.clickship.model.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.StringUtils;

public class NumberUtility {
	
	private NumberUtility() {
		super();
	}

	public static double getDouble2DecimalPoint(double value) {
		return Math.round(value * 100.0) / 100.0;
	}

	public static Double getDoubleDecimal(Double value, Integer scale) {
		return BigDecimal.valueOf(value).setScale(scale, RoundingMode.CEILING).doubleValue();
	}

	public static double getSafeCheckDoubleValue(String value) {
		return StringUtils.isNotBlank(value) ? Double.parseDouble(value) : 0.0;
	}
	
	public static double getSafeCheckDoubleValue(Double value) {
		return value != null ? value : 0.0;
	}
	
	public static float getSafeCheckFloatValue(Float value) {
		return value != null ? value : Float.valueOf(0);
	}

	public static double round(double number) {
		return round(number, 2);
	}
	
	public static double round(double number, int scale) {
		int pow = 10;
		for (int i = 1; i < scale; i++) {
			pow *= 10;
		}
		double tmp = number * pow;
		return ((double) ((int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp))) / pow;
	}	

	public static String addHyphenToPhoneNumber(String number) {
		return StringUtils.isNotBlank(number) ? number.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3"):"";
	}
	
	public static Long getSafeCheckLongValue(Long value) {
		return value != null ? value : 0;
	}
	
	public static Integer getSafeCheckIntegerValue(Integer value) {
		return value != null ? value : 0;
	}
	
	public static boolean checkDigitAfterDecimalPoint(double target, int numberOfDigit) {
		String[] splitted = ("" + target).split("\\.");
		return !(splitted.length > 1 && splitted[1].length() > numberOfDigit);
	}
	
	public static int parseIntOrDefault(String input, int defaultValue) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            return defaultValue;
        }
    }

	public static double parseDoubleOrDefault(String s) {
		try {
			return Double.valueOf(s);
		} catch (Exception e) {
			return 0.0;
		}
	}
}

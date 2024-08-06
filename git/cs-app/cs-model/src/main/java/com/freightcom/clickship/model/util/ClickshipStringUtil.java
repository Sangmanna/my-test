package com.freightcom.clickship.model.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClickshipStringUtil extends StringUtils {

	private static final String NOT_0_9 = "[^0-9]+";
	private static final String regex = "([a-z])([A-Z]+)";
	private static final String replacement = "$1_$2";
	

	public static String decapitalize(String string) {
		if (StringUtils.isBlank(string)) {
			return string;
		}
		char c[] = string.toCharArray();
		c[0] = Character.toLowerCase(c[0]);
		return new String(c);
	}

	public static String capitalize(String string) {
		if (StringUtils.isBlank(string)) {
			return string;
		}
		char c[] = string.toCharArray();
		c[0] = Character.toUpperCase(c[0]);
		return new String(c);
	}

	public static String firstCharLower(String string) {
		if (StringUtils.isBlank(string)) {
			return string;
		}
		char c[] = string.toCharArray();
		c[0] = Character.toLowerCase(c[0]);
		return new String(c);
	}

	public static String getStringObject(Object origin) throws Exception {
		return (new ObjectMapper()).writeValueAsString(origin);
	}

	public static String doubleToString(double value) {
		NumberFormat formatter = new DecimalFormat("#");
		return formatter.format(value);
	}

	/**
	 * Don't use this method for the purpose to truncate string with foreign
	 * languages and to store it to db Only 1 byetes language such as English are
	 * supposed to use this method.
	 * 
	 * @param value
	 * @param length
	 * @return
	 */
	public static String truncateString(String value, int length) {
		if (value != null && value.length() > length)
			value = value.substring(0, length);
		return value;
	}

	/**
	 * Don't use this method for the purpose to truncate string with foreign
	 * languages and to store it to db Only 1 byetes language such as English are
	 * supposed to use this method.
	 * 
	 * @param e
	 * @param length
	 * @return
	 */
	public static String truncateString(Exception e, int length) {
		String value = ExceptionUtils.getStackTrace(e);
		return truncateString(value, length);
	}

	public static String camelToUnderScore(String camelName) {
		return camelName.replaceAll(regex, replacement).toLowerCase();
	}

	public static String removeSpace(String param) {
		if (param == null)
			return "";
		else
			return param.replaceAll("\\s", "");
	}

	public static String firstCharUpper(String str) {
		if (StringUtils.isBlank(str))
			return "";
		str = str.toLowerCase();
		return Arrays.stream(str.split(" ")).map(ClickshipStringUtil::capitalize).collect(Collectors.joining(" "));
	}

	public static String nvl(String str, String alter) {
		return isEmpty(str) ? alter : str;
	}
	
	public static String nvl(String str) {
		return isEmpty(str) ? "" : str;
	}

	public static String removeSpecialChars(String txt) {
		if (txt == null)
			return "";
		else
			return txt.replaceAll(NOT_0_9, "");
	}

	public static String removeSpecialCharsAndAreaCode(String txt) {
		if (txt == null)
			return "";
		else {
			String numbers = txt.replaceAll(NOT_0_9, "");
			if (numbers.length() > 10 && numbers.startsWith("1")) {
				numbers = numbers.substring(1, numbers.length());
			}
			return numbers;
		}
	}

	/*
	 *
	 * This logic works only for US and Canada phone numbers.
	 * 
	 */
	public static String getTenDigitPhoneNumber(String phoneNumber) {

		if (StringUtils.isNotBlank(phoneNumber)) {
			phoneNumber = phoneNumber.replaceAll("[^\\d]", "");

			if (phoneNumber.charAt(0) == '1') {
				phoneNumber = phoneNumber.substring(1);
			}

			if (phoneNumber.length() > 10) {
				phoneNumber = phoneNumber.substring(0, 10);
			}
		}

		return phoneNumber;
	}

	public static String getStringStripAccents(String filed) {
		String filedValue = null;
		try {
			filedValue = URLDecoder.decode(new String(filed.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
			filedValue = StringUtils.stripAccents(filed);
		} catch (Exception e) {
			filedValue = filed;
		}
		return filedValue;

	}
	
	public static boolean isNotEquals(String str1, String str2) {
		return !equals(str1, str2);
	}
	
	public static String lineBreak(String origin, int length) {
		StringBuffer result = new StringBuffer();
		try {
			char[] chs = origin.toCharArray();
			int index = 0;
			while((index + 1) * length < origin.length()) {
				result.append(Arrays.copyOfRange(chs, index * length, (index + 1) * length)).append("\n");
				index++;
			}
			result.append(Arrays.copyOfRange(chs, index * length, chs.length));
		} catch (Exception e) {
			return origin;
		}
		
		return result.toString();
	}
	
	public static String getExceptionStrace(Exception exception) {
		StringWriter stringWriter = new StringWriter();
		exception.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}
	
	public static String removeSplCharsFromPostalCode(String postalCode) {
		if(postalCode.contains("-")) {
			return (postalCode.split("-")[0]).trim();
		}
		
		return postalCode;
	}
}

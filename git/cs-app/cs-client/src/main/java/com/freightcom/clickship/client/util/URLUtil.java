package com.freightcom.clickship.client.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLUtil {

	public static String urlEncode(String s) {
	    try {
	        return URLEncoder.encode(s, StandardCharsets.UTF_8.displayName());
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException(e);
	    }
	}

}

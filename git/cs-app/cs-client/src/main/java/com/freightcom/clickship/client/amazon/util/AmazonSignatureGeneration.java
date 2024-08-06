package com.freightcom.clickship.client.amazon.util;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AmazonSignatureGeneration {
	
	public static final String ALGORITHM = "HmacSHA256";
	private static final String DEFAULT_ENCODING = "UTF-8";
	
	
	public static String calculateStringToSignV2(Map<String, String> parameters, String...string1) throws Exception {
		return null;
	}

	public static String calculateStringToSignV2(String url, Map<String, String> parameters) throws Exception {
		StringBuilder data = new StringBuilder();
		data.append("POST");
		data.append("\n");
		URI endpoint = null;
		try {
			endpoint = new URI(url);
		} catch (URISyntaxException ex) {
			throw new RuntimeException("Invalid URI", ex);
		}
		data.append(endpoint.getHost());

		if (!usesAStandardPort(url)) {
			data.append(":");
			data.append(endpoint.getPort());
		}

		data.append("\n");
		String uri = endpoint.getPath();
		if (uri == null || uri.length() == 0) {
			uri = "/";
		}
		data.append(uri);
		data.append("\n");

		Map<String, String> sorted = new TreeMap<String, String>();
		sorted.putAll(parameters);

		Iterator<Map.Entry<String, String>> pairs = sorted.entrySet().iterator();
		while (pairs.hasNext()) {
			Map.Entry<String, String> pair = pairs.next();
			
			data.append(urlEncode(pair.getKey()));
			data.append("=");
			data.append(urlEncode(pair.getValue()));
			
			if (pairs.hasNext()) {
				data.append("&");
			}
		}
		return data.toString();
	}

	public static String sign(String data, String key) throws SignatureException {
		byte[] signature;
		try {
			Mac mac = Mac.getInstance(ALGORITHM);
			mac.init(new SecretKeySpec(key.getBytes(), ALGORITHM));
			signature = Base64.encodeBase64(mac.doFinal(data.getBytes(DEFAULT_ENCODING)));
		} catch (Exception e) {
			throw new SignatureException("Failed to generate signature: " + e.getMessage(), e);
		}

		return new String(signature);
	}
    
	public static String urlEncode(String rawValue) {
		String value = rawValue == null ? "" : rawValue;
		String encoded = null;
		try {
			encoded = URLEncoder.encode(value, DEFAULT_ENCODING).replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException(ex);
		}
		return encoded;
	}
	
	private static boolean usesAStandardPort(String url) {
		boolean usesHttps = usesHttps(url);
		int portNumber = extractPortNumber(url, usesHttps);
		return usesHttps && portNumber == 443 || !usesHttps && portNumber == 80;
	}
    
	private static boolean usesHttps(String url) {
		try {
			return URI.create(url).toURL().getProtocol().equals("https");
		} catch (MalformedURLException e) {
			return false;
		}
	}

	private static int extractPortNumber(String url, boolean usesHttps) {
		try {
			int portNumber = URI.create(url).toURL().getPort();
			return portNumber == -1 ? usesHttps ? 443 : 80 : portNumber; 
		} catch (MalformedURLException e) {
			throw new RuntimeException("Invalid URL", e);
		}
	}

}

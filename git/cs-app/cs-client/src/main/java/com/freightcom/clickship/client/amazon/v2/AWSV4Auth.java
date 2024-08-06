package com.freightcom.clickship.client.amazon.v2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.freightcom.clickship.model.marketplace.amazon.v2.AWSRequestBuilder;

public class AWSV4Auth {

	private Logger logger = LogManager.getLogger(this.getClass());

	private static final String UTC = "UTC";
	private static final String UTF8 = "UTF8";
	private static final String UTF_8 = "UTF-8";
	private static final String AWS4_REQ = "aws4_request";
	private static final String HMAC_SHA256 = "HmacSHA256";
    private static final String HMAC_ALOG = "AWS4-HMAC-SHA256";
    
    protected static final char[] hexArray = "0123456789ABCDEF".toCharArray();

	public Map<String, String> getHeaders(AWSRequestBuilder reqBuilder, String accessToken, String securityToken) {
		Map<String, String> map = reqBuilder.getAwsHeaders();
		String xAmzDate = getTimeStamp();
		map.put("x-amz-date", xAmzDate);

		if (accessToken != null && securityToken != null) {
			map.put("x-amz-access-token", accessToken);
			map.put("x-amz-security-token", securityToken);
		}

		/* Execute Task 1: Create a Canonical Request for Signature Version 4. */
		Map<String, String> canonicalReq = prepareCanonicalRequest(reqBuilder);
		String canonicalURL = canonicalReq.get("canonicalURL");
		String strSignedHeader = canonicalReq.get("strSignedHeader");

		/* Execute Task 2: Create a String to Sign for Signature Version 4. */
		String stringToSign = prepareStringToSign(canonicalURL, xAmzDate, reqBuilder.getRegionName(),  reqBuilder.getServiceName());

		/* Execute Task 3: Calculate the AWS Signature Version 4. */
		String signature = calculateSignature(stringToSign, reqBuilder);

		if (signature != null) {
			map.put("Authorization", buildAuthorizationString(reqBuilder, strSignedHeader, signature));

			if (logger.isDebugEnabled()) {
				logger.log(Level.DEBUG, "##Signature: {}", signature);
				logger.log(Level.DEBUG, "##Header:");
				logger.log(Level.DEBUG, "================================================================================================");
				for (Map.Entry<String, String> entrySet : map.entrySet()) {
					logger.log(Level.DEBUG, "{} -> {}", entrySet.getKey(), entrySet.getValue());
				}
				logger.log(Level.DEBUG, "================================================================================================");

			}
			return map;
		}

		return Collections.emptyMap();
	}

    private Map<String, String> prepareCanonicalRequest(AWSRequestBuilder awsRequestBuilder) {
        StringBuilder canonicalURL = new StringBuilder("");

        /* Step 1.1 Start with the HTTP request method (GET, PUT, POST, etc.), followed by a newline character. */
        canonicalURL.append(awsRequestBuilder.getHttpMethodName()).append("\n");

        /* Step 1.2 Add the canonical URI parameter, followed by a newline character. */
        String canonicalURI = awsRequestBuilder.getCanonicalURI();
        canonicalURI = canonicalURI == null || canonicalURI.trim().isEmpty() ? "/" : canonicalURI;
        canonicalURL.append(canonicalURI).append("\n");

        /* Step 1.3 Add the canonical query string, followed by a newline character. */
        StringBuilder queryString = new StringBuilder("");
        if (awsRequestBuilder.getQueryParameters() != null && !awsRequestBuilder.getQueryParameters().isEmpty()) {
            for (Map.Entry<String, String> entrySet : awsRequestBuilder.getQueryParameters().entrySet()) {
                String key = entrySet.getKey();
                String value = entrySet.getValue();
                queryString.append(key).append("=").append(encodeParameter(value)).append("&");
            }

            /* @co-author https://github.com/dotkebi @git #1 @date 16th March, 2017 */
            queryString.deleteCharAt(queryString.lastIndexOf("&"));

            queryString.append("\n");
        } else {
            queryString.append("\n");
        }
        canonicalURL.append(queryString);

        /* Step 1.4 Add the canonical headers, followed by a newline character. */
        StringBuilder signedHeaders = new StringBuilder("");
        if (awsRequestBuilder.getAwsHeaders() != null && !awsRequestBuilder.getAwsHeaders().isEmpty()) {
            for (Map.Entry<String, String> entrySet : awsRequestBuilder.getAwsHeaders().entrySet()) {
                String key = entrySet.getKey();
                String value = entrySet.getValue();
                signedHeaders.append(key).append(";");
                canonicalURL.append(key).append(":").append(value).append("\n");
            }

            /* Note: Each individual header is followed by a newline character, meaning the complete list ends with a newline character. */
            canonicalURL.append("\n");
        } else {
            canonicalURL.append("\n");
        }

        /* Step 1.5 Add the signed headers, followed by a newline character. */
        String strSignedHeader = signedHeaders.substring(0, signedHeaders.length() - 1); // Remove last ";"
        canonicalURL.append(strSignedHeader).append("\n");

        /* Step 1.6 Use a hash (digest) function like SHA256 to create a hashed value from the payload in the body of the HTTP or HTTPS. */
        String payload = awsRequestBuilder.getPayload();
        payload = payload == null ? "" : payload;
        canonicalURL.append(generateHex(payload));

        logger.log(Level.DEBUG, "##Canonical Request: {}", canonicalURL);
        Map<String, String> canonicalMap = new HashMap<>();
        canonicalMap.put("strSignedHeader", strSignedHeader);
        canonicalMap.put("canonicalURL", canonicalURL.toString());

        return canonicalMap;
    }

    private String prepareStringToSign(String canonicalURL, String xAmzDate, String regionName, String serviceName) {
        String stringToSign = "";

        stringToSign = HMAC_ALOG + "\n";
        stringToSign += xAmzDate + "\n";
        stringToSign += getDate() + "/" + regionName + "/" + serviceName + "/" + AWS4_REQ + "\n";
        stringToSign += generateHex(canonicalURL);

        logger.log(Level.DEBUG, "##String to sign: {}", stringToSign);

        return stringToSign;
    }

    private String calculateSignature(String str, AWSRequestBuilder req) {
        try {
            byte[] key = getSignatureKey(req.getSecretAccessKey(), getDate(), req.getRegionName(),  req.getServiceName());
            return bytesToHex(hmacSHA256(key, str));
        } catch (Exception ex) {
        	 logger.log(Level.ERROR, ex);
        }
        return null;
    }

    private String buildAuthorizationString(AWSRequestBuilder requestBuilder, String strSignedHeader, String strSignature) {
        return HMAC_ALOG + " "
                + "Credential=" + requestBuilder.getAccessKeyID() + "/" + getDate() + "/" + requestBuilder.getRegionName() + "/" +
                requestBuilder.getServiceName() + "/" + AWS4_REQ + "," + "SignedHeaders=" + strSignedHeader + ","
                + "Signature=" + strSignature;
    }

    private String generateHex(String data) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(data.getBytes(UTF_8));
            byte[] digest = messageDigest.digest();
            return String.format("%064x", new java.math.BigInteger(1, digest));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
        	 logger.log(Level.ERROR, e);
        }
        return null;
    }

    private byte[] hmacSHA256(byte[] key, String data) throws Exception {
        String algorithm = HMAC_SHA256;
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(key, algorithm));
        return mac.doFinal(data.getBytes(UTF8));
    }

    private byte[] getSignatureKey(String key, String date, String regionName, String serviceName) throws Exception {
        byte[] kSecret = ("AWS4" + key).getBytes(UTF8);
        byte[] kDate = hmacSHA256(kSecret, date);
        byte[] kRegion = hmacSHA256(kDate, regionName);
        byte[] kService = hmacSHA256(kRegion, serviceName);
        return hmacSHA256(kService, AWS4_REQ);
    }

    private String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars).toLowerCase();
    }

    private String getTimeStamp() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone(UTC));//server timezone
        return dateFormat.format(new Date());
    }

    private String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setTimeZone(TimeZone.getTimeZone(UTC));//server timezone
        return dateFormat.format(new Date());
    }

    @SuppressWarnings("deprecation")
	private String encodeParameter(String param) {
        try {
            return URLEncoder.encode(param, UTF_8);
        } catch (Exception e) {
            return URLEncoder.encode(param);
        }
    }
}

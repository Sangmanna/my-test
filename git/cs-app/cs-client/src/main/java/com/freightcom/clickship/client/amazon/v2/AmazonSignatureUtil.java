package com.freightcom.clickship.client.amazon.v2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.freightcom.clickship.model.marketplace.amazon.v2.AWSRequestBuilder;
import com.freightcom.clickship.model.marketplace.amazon.v2.AWSTempCredentials;
import com.freightcom.clickship.model.util.Security;

import java.util.Map;
import java.util.TreeMap;

@Component
public class AmazonSignatureUtil {

	private static final String HOST = "host";
	private Logger logger = LogManager.getLogger(AmazonSignatureUtil.class);

	@Value("${amazon.access.key_id}")
	private String amazonAccessKeyID;

	@Value("${amazon.secret.access_key}")
	private String amazonSecretAccessKey;

	@Value("${amazon.v2.domain:sellingpartnerapi-na.amazon.com}")
	private String amazonDomain;

	@Value("${amazon.v2.sts.domain:sts.amazonaws.com}")
	private String amazonStsDomain;

	@Autowired
	private Security security;

	public AWSRequestBuilder getTemporaryAwsSessionToken() {
		Map<String, String> headers = new TreeMap<>();
		headers.put(HOST, amazonStsDomain);

		Map<String, String> params = new TreeMap<>();
		params.put("Action", "AssumeRole");
		params.put("Version", "2011-06-15");
		params.put("RoleSessionName", "Test");
		params.put("DurationSeconds", "3600");
		params.put("RoleArn", "arn:aws:iam::695233055889:role/Clickship-test-role");
		AWSRequestBuilder requestBuilder = new AWSRequestBuilder();
		try {        
			requestBuilder.setAccessKeyID(security.decrypt(amazonAccessKeyID)).setSecretAccessKey(security.decrypt(amazonSecretAccessKey)).setPayload(null)
			.setRegionName("us-east-1").setServiceName("sts").setHttpMethodName("GET").setCanonicalURI("/")
			.setQueryParameters(params).setAwsHeaders(headers);

			AWSV4Auth awsv4Auth = new AWSV4Auth();
			headers.putAll(awsv4Auth.getHeaders(requestBuilder, null, null));
		}catch(Exception e) {
			logger.error("Exception while generating temporary credentials ",e);
		}

		return requestBuilder;
	}

	/**
	 * strings --> strings [0] = PayLoad,  [1] = accessToken, [2] = HttpMethod name, [3] = canonicalPath
	 * 
	 */
	public AWSRequestBuilder buildRequest(AWSTempCredentials credentials, Map<String, String> queryParams, String...strings) {
		Map<String, String> awsHeaders = new TreeMap<>();
		awsHeaders.put(HOST, amazonDomain);
		awsHeaders.put("content-type", "application/json");

		AWSRequestBuilder req = new AWSRequestBuilder();
		req.setAccessKeyID(credentials.getAccessKeyId()).setSecretAccessKey(credentials.getSecretAccessKey())
		.setRegionName("us-east-1").setServiceName("execute-api")
		.setHttpMethodName(strings[2]).setCanonicalURI(strings[3])
		.setQueryParameters(queryParams).setAwsHeaders(awsHeaders).setPayload(strings[0]);

		AWSV4Auth awsv4Auth = new AWSV4Auth();
		awsHeaders.putAll(awsv4Auth.getHeaders(req, strings[1], credentials.getSessionToken()));

		return req;
	}
}

package com.freightcom.clickship.model.marketplace.amazon.v2;

import java.util.Map;

public class AWSRequestBuilder {
	
	private String accessKeyID;
	
	private String secretAccessKey;
	
	private String regionName;
	
	private String serviceName;
	
	private String httpMethodName;
	
	private String canonicalURI;
	
	private Map<String, String> queryParameters;
	
	private Map<String, String> awsHeaders;
	
	private String payload;

	public String getAccessKeyID() {
		return accessKeyID;
	}

	public AWSRequestBuilder setAccessKeyID(String accessKeyID) {
		this.accessKeyID = accessKeyID;
		return this;
	}

	public String getSecretAccessKey() {
		return secretAccessKey;
	}

	public AWSRequestBuilder setSecretAccessKey(String secretAccessKey) {
		this.secretAccessKey = secretAccessKey;
		return this;
	}

	public String getRegionName() {
		return regionName;
	}

	public AWSRequestBuilder setRegionName(String regionName) {
		this.regionName = regionName;
		return this;
	}

	public String getServiceName() {
		return serviceName;
	}

	public AWSRequestBuilder setServiceName(String serviceName) {
		this.serviceName = serviceName;
		return this;
	}

	public String getHttpMethodName() {
		return httpMethodName;
	}

	public AWSRequestBuilder setHttpMethodName(String httpMethodName) {
		this.httpMethodName = httpMethodName;
		return this;
	}

	public String getCanonicalURI() {
		return canonicalURI;
	}

	public AWSRequestBuilder setCanonicalURI(String canonicalURI) {
		this.canonicalURI = canonicalURI;
		return this;
	}

	public Map<String, String> getQueryParameters() {
		return queryParameters;
	}

	public AWSRequestBuilder setQueryParameters(Map<String, String> queryParameters) {
		this.queryParameters = queryParameters;
		return this;
	}

	public Map<String, String> getAwsHeaders() {
		return awsHeaders;
	}

	public AWSRequestBuilder setAwsHeaders(Map<String, String> awsHeaders) {
		this.awsHeaders = awsHeaders;
		return this;
	}

	public String getPayload() {
		return payload;
	}

	public AWSRequestBuilder setPayload(String payload) {
		this.payload = payload;
		return this;
	}
}

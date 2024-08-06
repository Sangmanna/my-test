package com.freightcom.clickship.client.auth;

import org.apache.commons.lang3.StringUtils;

public class BasicAuthConfig {
	
	protected static String BASIC_AUTH = "Basic %s";

	protected String url;
	
	protected String basicAuth;
    
	public BasicAuthConfig(String url, String basicAuth) {
		
    	if ( StringUtils.isAnyBlank(url, basicAuth)) {
            throw new IllegalArgumentException("All arguments are required");
        }
		
		this.url = url;
		this.basicAuth = String.format(BASIC_AUTH, basicAuth);
	}

	public String getUrl() {
		return url;
	}

	public String getBasicAuth() {
		return basicAuth;
	}

}

package com.freightcom.clickship.client.auth;

import org.apache.commons.lang3.StringUtils;

public final class OAuthConfig {

    private final String url;
    private final String consumerKey;
    private final String consumerSecret;
    private final String accessToken;
    private final String tokenSecret;

    public OAuthConfig(String url, String consumerKey, String consumerSecret) {
        
    	if ( StringUtils.isAnyBlank(url, consumerKey, consumerSecret )) {
            throw new IllegalArgumentException("All arguments are required");
        }
        
        this.url = url;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessToken = null;
        this.tokenSecret = null;
    }

    public OAuthConfig(String url, String consumerKey, String consumerSecret, String accessToken, String tokenSecret) {

        if ( StringUtils.isAnyBlank(url, consumerKey, consumerSecret )) {
            throw new IllegalArgumentException("All arguments are required");
        }

        this.url = url;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessToken = accessToken;
        this.tokenSecret = tokenSecret;
    }

    public String getUrl() {
        return url;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }
}

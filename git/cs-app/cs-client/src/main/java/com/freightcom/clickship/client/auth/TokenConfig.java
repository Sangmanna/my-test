package com.freightcom.clickship.client.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class TokenConfig {
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String url;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String token;
	
	private String username;
	
	private String password;
	
	public TokenConfig(String url, String token) {
		super();
		this.url = url;
		this.token = token;
	}
	
	public TokenConfig(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public TokenConfig setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getToken() {
		return token;
	}

	public TokenConfig setToken(String token) {
		this.token = token;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public TokenConfig setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public TokenConfig setPassword(String password) {
		this.password = password;
		return this;
	}
}


package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UPSSecurity implements Serializable {

	private static final long serialVersionUID = 8021180626310746904L;

	@JsonProperty("UsernameToken")
	private UsernameToken token;

	@JsonProperty("ServiceAccessToken")
	private ServiceAccessToken serviceAccessToken;
	
	@JsonProperty("UPSServiceAccessToken")
	private ServiceAccessToken upsServiceAccessToken;
	
	public UPSSecurity(String serviceAccessToken) {
		super();
		this.serviceAccessToken = new ServiceAccessToken(serviceAccessToken);
	}
	
	public UPSSecurity(String username, String password) {
		super();
		this.token = new UsernameToken(username, password);
	}
	
	public UsernameToken getToken() {
		return token;
	}

	public UPSSecurity setToken(UsernameToken token) {
		this.token = token;
		return this;
	}

	public ServiceAccessToken getServiceAccessToken() {
		return serviceAccessToken;
	}

	public UPSSecurity setServiceAccessToken(String  serviceAccessToken) {
		this.serviceAccessToken = new ServiceAccessToken(serviceAccessToken);
		return this;
	}

	public ServiceAccessToken getUpsServiceAccessToken() {
		return upsServiceAccessToken;
	}

	public UPSSecurity setUpsServiceAccessToken(String upsServiceAccessToken) {
		this.upsServiceAccessToken = new ServiceAccessToken(upsServiceAccessToken);
		return this;
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class UsernameToken {
		
		@JsonProperty("Username")
		private String username;

		@JsonProperty("Password")
		private String password;

		private UsernameToken(String username, String password) {
			super();
			this.password = password;
			this.username = username;
		}

		public String getUsername() {
			return username;
		}

		public UsernameToken setUsername(String username) {
			this.username = username;
			return this;
		}

		public String getPassword() {
			return password;
		}

		public UsernameToken setPassword(String password) {
			this.password = password;
			return this;
		}
		
	}
	
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ServiceAccessToken {
		
		@JsonProperty("AccessLicenseNumber")
		private String accessLicenseNumber;
		
		private ServiceAccessToken(String accessLicenseNumber) {
			super();
			this.accessLicenseNumber = accessLicenseNumber;
		}

		public String getAccessLicenseNumber() {
			return accessLicenseNumber;
		}

		public ServiceAccessToken setAccessLicenseNumber(String accessLicenseNumber) {
			this.accessLicenseNumber = accessLicenseNumber;
			return this;
		}
		
	}

}

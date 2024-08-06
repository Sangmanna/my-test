package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixBuyerInfo {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("type")
	private String type;

	@JsonProperty("identityType")
	private String identityType;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("email")
	private String email;

	public String getId() {
		return id;
	}

	public WixBuyerInfo setId(String id) {
		this.id = id;
		return this;
	}

	public String getIdentityType() {
		return identityType;
	}

	public WixBuyerInfo setIdentityType(String identityType) {
		this.identityType = identityType;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public WixBuyerInfo setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public WixBuyerInfo setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public WixBuyerInfo setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public WixBuyerInfo setEmail(String email) {
		this.email = email;
		return this;
	}

}

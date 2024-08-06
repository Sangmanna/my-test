package com.freightcom.clickship.model.customer;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.CommonDTO;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = 8587686103284961067L;

	private String username;
	
	private String password;
	
	private String confirmPassword;
	
	public String getUsername() {
		return username;
	}

	public UserDTO setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UserDTO setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public UserDTO setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		return this;
	}

}

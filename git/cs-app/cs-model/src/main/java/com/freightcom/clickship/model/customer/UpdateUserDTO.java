package com.freightcom.clickship.model.customer;

import lombok.Data;

@Data
public class UpdateUserDTO {
	
	private String username;
	
	private String xUsername;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String role;
	
	private boolean usernameChanged;
	
	private String fcApiVersion;
	
	public UpdateUserDTO() {
		super(); 
	}

	public UpdateUserDTO(String username, String xUsername, String email, String firstName, String lastName,
			String role, boolean usernameChanged, String fcApiVersion) {
		super();
		this.username = username;
		this.xUsername = xUsername;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.usernameChanged = usernameChanged;
		this.fcApiVersion = fcApiVersion;
	}

	public String getUsername() {
		return username;
	}

	public UpdateUserDTO setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getxUsername() {
		return xUsername;
	}

	public UpdateUserDTO setxUsername(String xUsername) {
		this.xUsername = xUsername;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UpdateUserDTO setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public UpdateUserDTO setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public UpdateUserDTO setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getRole() {
		return role;
	}

	public UpdateUserDTO setRole(String role) {
		this.role = role;
		return this;
	}

	public boolean isUsernameChanged() {
		return usernameChanged;
	}

	public UpdateUserDTO setUsernameChanged(boolean usernameChanged) {
		this.usernameChanged = usernameChanged;
		return this;
	}

	public String getFcApiVersion() {
		return fcApiVersion;
	}

	public UpdateUserDTO setFcApiVersion(String fcApiVersion) {
		this.fcApiVersion = fcApiVersion;
		return this;
	}
	
}

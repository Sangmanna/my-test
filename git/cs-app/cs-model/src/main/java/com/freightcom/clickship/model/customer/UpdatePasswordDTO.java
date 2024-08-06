package com.freightcom.clickship.model.customer;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class UpdatePasswordDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -4681832745205010231L;

	private String oldPassword;
	
	private String newPassword;
	
	private String confirmNewPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public UpdatePasswordDTO setNewPassword(String newPassword) {
		this.newPassword = newPassword;
		return this;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public UpdatePasswordDTO setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
		return this;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public UpdatePasswordDTO setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
		return this;
	}
}

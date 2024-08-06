package com.freightcom.clickship.data.entity.common;

import com.freightcom.clickship.data.entity.Customer;

public interface CustomerAssociateEntity {
	default Customer getCustomer() {
		return null;
	}
}

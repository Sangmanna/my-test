package com.freightcom.clickship.service.service;

import java.util.Arrays;
import java.util.function.Supplier;

import org.apache.commons.lang3.StringUtils;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;
import com.freightcom.clickship.data.entity.common.CustomerIdAssociateEntity;
import com.freightcom.clickship.model.enums.CS_ROLE;
import com.freightcom.clickship.model.exception.CSInvalidAccessRuntimeException;

public interface ICheckAccess {
	public static final String[] ACCESS_ALLOWED_ROLES = { CS_ROLE.ADMIN.toString(), CS_ROLE.CUSTOMER_SUPPORT.toString() };

	/**
	 * The mothod to check if user is accessible to the entity object
	 * 
	 * 1. If the object is null object, it does not check
	 * 2. If the customer in the object is null, it does not produce exception, considering it as new object creation
	 * 3. If the user is null, it skips the check logic, assuming that the backend app runs the code e.g. job
	 * 4. If user has role 'ADMIN', 'CUSTOMER_SUPPORT', it ends without exception
	 * 5. If the customer id is not equal to customerAssociateEntity's customer_id, it produces CSInvalidAccessRuntimeException
	 * 
	 * Later this exception 'CSInvalidAccessRuntimeException' is handled in CustomExceptionHandler especially in API project
	 * 
	 * @param user
	 * @param customerAssociateEntity
	 */
	default void checkAccess(User user, CustomerAssociateEntity customerAssociateEntity) {

		if (customerAssociateEntity == null || customerAssociateEntity.getCustomer() == null) {
			return;
		}

		if (user == null) {
			return;
		}

		if (Arrays.stream(ACCESS_ALLOWED_ROLES).anyMatch(user.getUserRole()::equals)) {
			return;
		}

		String customerId = user.getCustomer().getId();
		
		Customer customer = customerAssociateEntity.getCustomer();
		
		if (customer != null && !StringUtils.equals(customer.getId(), customerId)) {
			throw new CSInvalidAccessRuntimeException();
			
		}
	}
	
	default void checkAccess(User user, CustomerIdAssociateEntity customerIdAssociateEntity) {

		if (customerIdAssociateEntity == null || customerIdAssociateEntity.getCustomerId() == null) {
			return;
		}

		if (Arrays.stream(ACCESS_ALLOWED_ROLES).anyMatch(user.getUserRole()::equals)) {
			return;
		}

		String customerId = user.getCustomer().getId();
		
		if (!StringUtils.equals(customerId, customerIdAssociateEntity.getCustomerId())) {
			throw new CSInvalidAccessRuntimeException();
		}
	}
	
	/**
	 * @param user
	 * @param isInvalidSupplier: If this return true, it means invalid and will cause CSInvalidAccessRuntimeException
	 */
	public static void checkAccess(User user, Supplier<Boolean> isInvalidSupplier) {
		if (Arrays.stream(ACCESS_ALLOWED_ROLES).anyMatch(user.getUserRole()::equals)) {
			return;
		}

		if (isInvalidSupplier.get()) {
			throw new CSInvalidAccessRuntimeException();
		}
	}
}

package com.freightcom.clickship.client.freightcom;

import com.freightcom.clickship.model.carrier.freightcom.CustomerDetails;
import com.freightcom.clickship.model.carrier.freightcom.CustomerDetailsRequest;
import com.freightcom.clickship.model.carrier.freightcom.FCCustomer;
import com.freightcom.clickship.model.carrier.freightcom.RegisterCustomerRequest;
import com.freightcom.clickship.model.carrier.freightcom.UpdateCustomerRequest;
import com.freightcom.clickship.model.onboarding.OnboardingDTO;

public class FreightcomV1Transformer {
	
	private FreightcomV1Transformer() {
		super();
	}

	public static final String CS_SIGNUP_SOURCE = "CS";
	public static final String FC_SIGNUP_SOURCE = "FC-CS";

	public static RegisterCustomerRequest getRegisterCustomerRequest(OnboardingDTO dto) {
		FCCustomer customer = new FCCustomer();

		customer.setBusinessName(dto.getBusinessName());
		customer.setUsername(dto.getSignupUserName());
		customer.setPassword(dto.getSignupPassword());
		customer.setEmail(dto.getEmailAddress());
		customer.setPhone(dto.getPhone());
		customer.setContact(dto.getContactName());
		customer.setAddress(dto.getAddress());	
		customer.setCity(dto.getCity());
		customer.setProvince(dto.getPostalCode());
		customer.setCountry(dto.getCountry());
		customer.setPostalCode(dto.getPostalCode());
		customer.setPromoCode(dto.getPromoCode());
		customer.setRegistrationSource(dto.getRegistrationSource());
		
		RegisterCustomerRequest req = new RegisterCustomerRequest();
		req.setRegisterCustomer(customer);
		
		return req;
	}
	
	public static CustomerDetailsRequest getCustomerDetailsRequest(String username, String password) {
		CustomerDetailsRequest request = new CustomerDetailsRequest(username, password);
		request.setCustomerDetails(new CustomerDetails());
		
		return request;
	}
	
	public static UpdateCustomerRequest getUpdateCustomerAddressRequest(OnboardingDTO address, String...strings) {
		FCCustomer fcAddress = new FCCustomer();
		fcAddress.setAddress(address.getAddress());
		fcAddress.setCity(address.getCity());
		fcAddress.setCountry(address.getCountry());
		fcAddress.setProvince(address.getProvinceState());
		fcAddress.setPostalCode(address.getPostalCode());
		fcAddress.setPhone(address.getPhone());
		fcAddress.setEmail(address.getEmailAddress());
		
		UpdateCustomerRequest fcAddressReq = new UpdateCustomerRequest(strings[0], strings[1]);
		fcAddressReq.setUpdateCustomer(fcAddress);
		
		return fcAddressReq;
	}
	
	public static UpdateCustomerRequest getUpdateFCSignUpSource(OnboardingDTO dto) {
		FCCustomer customer = new FCCustomer();
		customer.setRegistrationSource(FC_SIGNUP_SOURCE);
		
		UpdateCustomerRequest request = new UpdateCustomerRequest(dto.getSignupUserName(), dto.getSignupPassword());
		request.setUpdateCustomer(customer);
		
		return request;
	}
	
}

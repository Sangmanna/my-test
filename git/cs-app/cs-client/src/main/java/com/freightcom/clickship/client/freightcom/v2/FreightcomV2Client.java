package com.freightcom.clickship.client.freightcom.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.freightcom.clickship.model.carrier.freightcom.v2.FCPaymentMethod;
import com.freightcom.clickship.model.carrier.freightcom.v2.FreightcomApiEndpoints;
import com.freightcom.clickship.model.carrier.freightcom.v2.FreightcomCustomer;

@Component
public class FreightcomV2Client {
	
	@Value("${freightcomv2.apikey}")
	private String internalApiKey;
	
	@Value("${freightcomv2.url:https://clickship-api.ssd-test.freightcom.com}")
	private String v2URL;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public FreightcomCustomer getCustomerDetails(FreightcomCustomer dto) {
		return (FreightcomCustomer) post(FreightcomApiEndpoints.CUSTOMER_DETAILS.getValue(), dto, FreightcomCustomer.class).getBody();
	}
	
	public FreightcomCustomer registerAccount(FreightcomCustomer dto) {
		return (FreightcomCustomer) post(FreightcomApiEndpoints.CUSTOMER.getValue(), dto, FreightcomCustomer.class).getBody();
	}
	
	public FreightcomCustomer updateCustomer(String url, FreightcomCustomer dto) {
		return (FreightcomCustomer) post(url, dto, FreightcomCustomer.class).getBody();
	}
	
	public FreightcomCustomer updatePasssword(String url, FreightcomCustomer obj) {
		return (FreightcomCustomer) post(url, obj, FreightcomCustomer.class).getBody();
	}
	
	public void approveCustomer(String url) {
		post(url, null, void.class);
	}
	
	public void emailVerify(String url) {
		post(url, null, void.class);
	}
	
	public FCPaymentMethod updatePaymentMethod(String url, FCPaymentMethod obj) {
		return (FCPaymentMethod) post(url, obj, FCPaymentMethod.class).getBody();
	}
	
	private ResponseEntity<?> post(String url, Object req, Class<?> clazz) {
		return callFC(url, HttpMethod.POST, req, clazz);
	}
	
	private ResponseEntity<?> callFC(String url, HttpMethod method, Object req, Class<?> clazz) {
		return restTemplate.exchange(v2URL + url, method, getRequestEntity(req), clazz);
	}
	
	private HttpEntity<Object> getRequestEntity(Object requestBody) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, internalApiKey);
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		if (requestBody != null) {
			return new HttpEntity<>(requestBody, headers);
		} else {
			return new HttpEntity<>(headers);
		}
	}
	
}

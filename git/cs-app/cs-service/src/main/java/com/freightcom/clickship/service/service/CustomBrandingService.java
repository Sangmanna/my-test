package com.freightcom.clickship.service.service;

import java.util.Map;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.model.custombranding.BrandingV1DTO;

public interface CustomBrandingService {
	
	public BrandingV1DTO getCustPrefBrandingInfoDetails(Customer customer);
	
	public Map<String, Object> getBrandingEmbeddedDetails(Customer customer);
	
	public void setGenericClickshipDetails(Map<String, Object> content, String source);

}

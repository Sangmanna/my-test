package com.freightcom.clickship.service.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerPreferences;
import com.freightcom.clickship.model.custombranding.BrandingV1DTO;
import com.freightcom.clickship.service.service.CustomBrandingService;
import com.freightcom.clickship.service.service.CustomerPreferencesService;

@Service
public class CustomBrandingServiceImpl implements CustomBrandingService {
	
	@Value("${logo.shipping.label.width}")
	private String logoShippingLabelWidth;
	
	@Value("${logo.shipping.label.height}")
	private String logoShippingLabelHeight;
	
	@Value("${clickship.canpar.url}")
	private String clickshipCanparUrl;
	
	@Value("${clickship.canpar.login.url}")
	private String clickshipCanparLoginUrl;
	
	@Value("${clickship.canpar.mailchimp.logo}")
	private String clickshipCanparMailChimpLogo;
	
	@Autowired
	private CustomerPreferencesService customerPreferencesService;
	
	@Override
	public BrandingV1DTO getCustPrefBrandingInfoDetails(Customer customer) {
		BrandingV1DTO dto = new BrandingV1DTO();
		CustomerPreferences preferences = customerPreferencesService.getCustomerPreferencesByCustomer(customer);

		if(preferences != null) {
			dto.setLogoEnabled(preferences.isLogoEnabled());
			dto.setApplyToEmail(preferences.isApplyToEmail());
			dto.setApplyToLabels(preferences.isApplyToLabels());
			dto.setApplyToPackingSlips(preferences.isApplyToPackingSlips());
			
			dto.setBrandingImageUrl(preferences.getBrandingImageUrl());
	
			dto.setEmailSubject(preferences.getEmailSubject());
			dto.setEmailMessage(preferences.getEmailMessage());
			dto.setEmailHeadline(preferences.getEmailHeadline());
			dto.setEmailSettingsEnabled(preferences.isEmailSettingsEnabled());
			
			dto.setTwitterHandle(preferences.getTwitterHandle());
			dto.setLinkedinHandle(preferences.getLinkedinHandle());
			dto.setFacebookHandle(preferences.getFacebookHandle());
			dto.setInstagramHandle(preferences.getInstagramHandle());
		}
		
		return dto;
	}
	
	@Override
	public Map<String, Object> getBrandingEmbeddedDetails(Customer customer) {
		BrandingV1DTO dto = getCustPrefBrandingInfoDetails(customer);
		
		Map<String, Object> content = new HashMap<>();
		
		content.put("twitter", dto.getTwitterHandle());
		content.put("facebook", dto.getFacebookHandle());
		content.put("linkedin", dto.getLinkedinHandle());
		content.put("instagram", dto.getInstagramHandle());
		content.put("applyToEmail", dto.getApplyToEmail());
		content.put("showBrandingLogo", dto.getLogoEnabled());
		content.put("enableEmailSettings", dto.getEmailSettingsEnabled());
		content.put("removeClickship", false);
		
		if(dto.getLogoEnabled() && dto.getApplyToEmail()) {
			content.put("logoWidth", logoShippingLabelWidth);
			content.put("logoHeight", logoShippingLabelHeight);	
			content.put("storeLogoUrl", dto.getBrandingImageUrl());
		}else {
			content.put("logoWidth", "");
			content.put("logoHeight", "");
			content.put("storeLogoUrl", "");
		}

		if (dto.getEmailSettingsEnabled()) {
			content.put("customHeader", dto.getEmailHeadline());
			content.put("customMessage", dto.getEmailMessage());
		} else {
			content.put("customHeader", "");
			content.put("customMessage", "");
		}
		
		if (dto.getEmailSettingsEnabled() && dto.getApplyToEmail()) {
			content.put("subject", dto.getEmailSubject());
		}
		
		setGenericClickshipDetails(content, customer.getRegistrationSource());
		
		return content;
	}
	
	@Override
	public void setGenericClickshipDetails(Map<String, Object> content, String source) {
		if("canpar".equalsIgnoreCase(source)) {
			content.put("clickshipCanpar", true);
			content.put("clickshipSourceUrl", clickshipCanparUrl);
			content.put("clickshipLogo", clickshipCanparMailChimpLogo);
			content.put("clickshipSourceLoginUrl", clickshipCanparLoginUrl);
		}		
	}

}

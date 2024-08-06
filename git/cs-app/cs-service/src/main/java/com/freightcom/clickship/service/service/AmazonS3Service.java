package com.freightcom.clickship.service.service;

import org.springframework.web.multipart.MultipartFile;

import com.freightcom.clickship.data.entity.Customer;

public interface AmazonS3Service {

	public String copyS3ImageAndGetNewUrl(String s3Url, Customer customer);
	
	public String getNewS3FileName(MultipartFile file, String contentType, Customer customer, String existingBrandingImageUrl);
	
}

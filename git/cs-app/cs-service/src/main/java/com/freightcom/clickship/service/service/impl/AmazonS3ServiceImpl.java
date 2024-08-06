package com.freightcom.clickship.service.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.util.CSIdGenerator;
import com.freightcom.clickship.service.service.AmazonS3Service;

@Service
public class AmazonS3ServiceImpl implements AmazonS3Service {
	private Logger logger = LogManager.getLogger(this.getClass());

	@Value("${aws.s3.access.key.id}")
	private String awsS3AccessKeyId;

	@Value("${aws.s3.bucket.url}")
	private String awsS3BucketUrl;

	@Value("${aws.s3.bucket.location}")
	private String awsS3BucketLocation;

	@Value("${aws.s3.secret.access.key}")
	private String awsS3SecretAccessKey;

	@Value("${aws.s3.bucket.region}")
	private String awsS3BucketRegion;

	@Value("${image.content.type.key}")
	private String imageContentTypeKey;

	@Value("${image.content.type.jpeg}")
	private String imageTypeJpeg;

	@Value("${image.content.type.png}")
	private String imageTypePng;

	@Value("${image.jpeg.extension}")
	private String imageJpegExtension;

	@Value("${aws.s3.file.prefix}")
	private String awsS3FilePrefix;

	@Value("${image.png.extension}")
	private String imagePngExtension;

	@Autowired
	private CSIdGenerator clickshipIdGenerator;

	@Override
	public String getNewS3FileName(MultipartFile file, String contentType, Customer customer, String existingBrandingImageUrl) {
		AmazonS3 s3 = getAmazonS3();
		String fileName = getAmazonS3FileName(file, contentType, customer, s3);

		deleteS3(s3, existingBrandingImageUrl);

		return fileName;
	}

	private void deleteS3(AmazonS3 s3, String existingUrl) {
		if (existingUrl != null) {
			String oldFilename = existingUrl.replace(awsS3BucketUrl, "");
			logger.info("Deleting existing file on AWS bucket: {}", oldFilename);
			s3.deleteObject(awsS3BucketLocation, oldFilename);
			logger.info("Successfully deleted the file on AWS bucket.");
		}
	}

	private AmazonS3 getAmazonS3() {
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsS3AccessKeyId, awsS3SecretAccessKey);
		return AmazonS3ClientBuilder.standard().withRegion(awsS3BucketRegion).withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
	}

	private String getAmazonS3FileName(MultipartFile file, String contentType, Customer customer, AmazonS3 s3) {
		byte[] byteArray = null;
		try {
			byteArray = file.getBytes();
		} catch (IOException e) {
			logger.error("Error while fetching byte array: {}", e.getLocalizedMessage());
		}
		InputStream inputStream = new ByteArrayInputStream(byteArray);

		ObjectMetadata metadata = new ObjectMetadata();
		metadata.addUserMetadata(imageContentTypeKey, contentType);

		String filename = getNewFileName(contentType, customer);

		s3.putObject(new PutObjectRequest(awsS3BucketLocation, filename, inputStream, metadata));

		return awsS3BucketUrl + filename;
	}
	
	/**
	 * @param s3Url
	 * @param contentType  See the propeties, image.content.type.png, image.content.type.jpeg
	 * @param customer
	 * @return
	 */
	@Override
	public String copyS3ImageAndGetNewUrl(String s3Url, Customer customer) {
		String s3FileName = s3Url.replaceAll(awsS3BucketUrl, "");
		String contentType = s3FileName.toLowerCase().endsWith("png") ? imageTypePng : imageTypeJpeg;
		String copieFileName = getNewFileName(contentType, customer);
		getAmazonS3().copyObject(new CopyObjectRequest(awsS3BucketLocation, s3FileName, awsS3BucketLocation, copieFileName));
		return awsS3BucketUrl + copieFileName;
	}

	private String getNewFileName(String contentType, Customer customer) {
		String filename = customer.getId() + clickshipIdGenerator.getNextId(awsS3FilePrefix);
		if (contentType.equalsIgnoreCase(imageTypePng)) {
			filename = filename + imagePngExtension;
		} else if (contentType.equalsIgnoreCase(imageTypeJpeg)) {
			filename = filename + imageJpegExtension;
		}
		return filename;
	}
}

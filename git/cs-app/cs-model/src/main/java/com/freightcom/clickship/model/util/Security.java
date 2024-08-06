package com.freightcom.clickship.model.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;

import jakarta.annotation.PostConstruct;

/**
 * Class that encrypts and decrypts values
 * This will be used by 
 * 1. Authentication
 * 2. Registration
 * Any calls to Freightcom V1
 * 
 * @author maheshg
 *
 */
@Component
public class Security {
	
	private static Logger logger = LogManager.getLogger(Security.class);

	private static final String ALGO = "AES/ECB/PKCS5Padding";
	private static final String PIIALGORITHM = "AES/CBC/PKCS5Padding";
	private static final String ERROR_MSG = "Error creating Security object";
	
	private static String prefix = "AESenc:";

	private Key kmsConnectionKey; // decrypt kms connection info from DB 
	private Key key; // pw en/decrypt
	private static SecretKey piiSecretKey; // for pii data
	private String jwtSignKey; // for jwt signing

	@Value("${marketplace.cleanup.cron}")
	private String marketplaceCleanupCron;

	@Value("${aws.kms.access.key.id2}")
	private String piiAwsKMSAccessKeyId;

	@Value("${aws.kms.secret.access.key2}")
	private String piiAwsKMSSecretAccessKey;

	@Value("${aws.kms.secret.name2}")
	private String piiAwsKMSSecretName;

	@Value("${aws.kms.key.name2}") 
	private String piiAwsKMSKeyName;
	
	@Value("${key.name}")
	private String keyName;
	
	@Value("${sign.key.name}")
	private String signKeyName;
	
	@Value("${aws.region}")
	private String awsRegion;
	
	private String awsAccessKeyId;
	private String awsSecretAccessKey;
	
	/**
	 * Read the password from the file and create the security key
	 * @throws Exception 
	 */
	@PostConstruct
	public void init() throws Exception {
		try {
			// the key from DB to decrypt aws connection info
			kmsConnectionKey = getKMSConnectionKey();
			
			// pull key to decrypt key from aws
			key = getKeyForDecryptAWSKey(keyName);
			
			// pull the key for jwt 
			jwtSignKey = getJwtSignKey(signKeyName);
			
			// this should be after key
			setPIISecret();
		} catch (Exception e) {
			logger.error(ERROR_MSG, e);
			throw e;
		}
	}

	private Key getKMSConnectionKey() throws Exception {
		MessageDigest sha = null;
		try {
			byte[] b = marketplaceCleanupCron.getBytes(StandardCharsets.UTF_8);
			sha = MessageDigest.getInstance("SHA-1");
			b = sha.digest(b);
			b = Arrays.copyOf(b, 16);
			return new SecretKeySpec(b, "AES");

		} catch (Exception e) {
			logger.error(ERROR_MSG, e);
			throw e;
		}
	}
	
	public void setPIISecret() throws Exception {
		// AWS creds are  required to fetch the keys from KMS
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(decrypt(piiAwsKMSAccessKeyId, kmsConnectionKey),
				decrypt(piiAwsKMSSecretAccessKey, kmsConnectionKey));

		AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().withRegion(awsRegion)
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

		GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(decrypt(piiAwsKMSSecretName, kmsConnectionKey));
		GetSecretValueResult getSecretValueResult = null;

		getSecretValueResult = client.getSecretValue(getSecretValueRequest);

		// Decrypts secret using the associated KMS key.
		// Depending on whether the secret is a string or binary, one of these fields
		// will be populated.
		if (getSecretValueResult.getSecretString() != null) {
			String awsKMSSecretJson = getSecretValueResult.getSecretString();
			JSONObject jsonObject = new JSONObject(awsKMSSecretJson);
			String encryptedKey = jsonObject.getString(decrypt(piiAwsKMSKeyName, kmsConnectionKey));
			String secret = decrypt(encryptedKey);
			
			// Salt will add additional protection to secure keys
			byte[] salt = { 12, 12, 32, 11, 12, 33, 121, 22 };
			
			// This algorithm allows password to create a secret, password is encrypted and stored in KMS
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			
			// We are generating 256 bit encryption key
			KeySpec spec = new PBEKeySpec(secret.toCharArray(), salt, 65536, 256);
			setPIISecret(new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES"));
		} else {
			throw new Exception("Failed to GET Encryption Keys from AWS KMS");
		}
	}
	
	public SecretKey getKeyForDecryptAWSKey(String awsKMSKeyName) throws Exception {
		String awsKMSKeyNameDecrypted = decrypt(awsKMSKeyName, kmsConnectionKey);
		
		GetSecretValueResult getSecretValueResult = getSecretValueResult(awsKMSKeyNameDecrypted);

		// Decrypts secret using the associated KMS key.
		// Depending on whether the secret is a string or binary, one of these fields
		// will be populated.
		if (getSecretValueResult.getSecretString() != null) {
			String awsKMSSecretJson = getSecretValueResult.getSecretString();
			JSONObject jsonObject = new JSONObject(awsKMSSecretJson);
			String encryptedKey = jsonObject.getString(awsKMSKeyNameDecrypted);

			MessageDigest sha = null;
			try {
				String result = encryptedKey;
				byte[] b = result.getBytes(StandardCharsets.UTF_8);
				sha = MessageDigest.getInstance("SHA-1");
				b = sha.digest(b);
				b = Arrays.copyOf(b, 16);
				return new SecretKeySpec(b, "AES");
			} catch (Exception e) {
				logger.error(ERROR_MSG, e);
				throw e;
			}
		} else {
			throw new Exception("Failed to GET Encryption Keys from AWS KMS");
		}
	}
	
	
	public SecretKey getSecret(String awsKMSKeyName) throws Exception {
		String awsKMSKeyNameDecrypted = decrypt(awsKMSKeyName, kmsConnectionKey);
		
		GetSecretValueResult getSecretValueResult = getSecretValueResult(awsKMSKeyNameDecrypted);

		// Decrypts secret using the associated KMS key.
		// Depending on whether the secret is a string or binary, one of these fields
		// will be populated.
		if (getSecretValueResult.getSecretString() != null) {
			String awsKMSSecretJson = getSecretValueResult.getSecretString();
			JSONObject jsonObject = new JSONObject(awsKMSSecretJson);
			String encryptedKey = jsonObject.getString(awsKMSKeyNameDecrypted);
			String secret = encryptedKey;
			
			// Salt will add additional protection to secure keys
			byte[] salt = { 12, 12, 32, 11, 12, 33, 121, 22 };
			
			// This algorithm allows password to create a secret, password is encrypted and stored in KMS
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			
			// We are generating 256 bit encryption key
			KeySpec spec = new PBEKeySpec(secret.toCharArray(), salt, 65536, 256);
			return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
		} else {
			throw new Exception("Failed to GET Encryption Keys from AWS KMS");
		}
	}
	
	public String getJwtSignKey(String awsKMSKeyName) throws Exception {
		String keyNameDecrypted = decrypt(awsKMSKeyName, kmsConnectionKey);
		GetSecretValueResult getSecretValueResult = getSecretValueResult(keyNameDecrypted);

		// Decrypts secret using the associated KMS key.
		// Depending on whether the secret is a string or binary, one of these fields
		// will be populated.
		if (getSecretValueResult.getSecretString() != null) {
			String awsKMSSecretJson = getSecretValueResult.getSecretString();
			JSONObject jsonObject = new JSONObject(awsKMSSecretJson);
			return jsonObject.getString(keyNameDecrypted);
		} else {
			throw new Exception("Failed to GET Encryption Keys from AWS KMS");
		}
	}

	private GetSecretValueResult getSecretValueResult(String awsKMSSecretName) throws Exception {
		
		// AWS creds are  required to fetch the keys from KMS
		String awsAccessKeyId = decrypt(piiAwsKMSAccessKeyId, kmsConnectionKey);
		String awsSecretAccessKey = decrypt(piiAwsKMSSecretAccessKey, kmsConnectionKey);
		
		setTranslationServiceAWSKey(awsAccessKeyId, awsSecretAccessKey);
    	
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);

		AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().withRegion(awsRegion)
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

		GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(awsKMSSecretName);
		GetSecretValueResult getSecretValueResult = null;

		getSecretValueResult = client.getSecretValue(getSecretValueRequest);
		return getSecretValueResult;
	}

	private void setTranslationServiceAWSKey(String awsAccessKeyId, String awsSecretAccessKey) {
		this.awsAccessKeyId = awsAccessKeyId;
		this.awsSecretAccessKey = awsSecretAccessKey;
	}
	
	public String getAWSAccessKeyId() {
		return awsAccessKeyId;
	}
	
	public String getAWSSecretAccessKey() {
		return awsSecretAccessKey;
	}

	private static IvParameterSpec generateIv() {
		byte[] iv = new byte[16];
		new SecureRandom().nextBytes(iv);
		return new IvParameterSpec(iv);
	}

	/**
	 * Encrypt a value using the existing key
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String encrypt(String data) throws Exception {
		return encrypt(data, key);
	}
	
	public String encrypt(String data, Key key) throws Exception {
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(data.getBytes());
		return Base64.encodeBase64String(encVal);
	}

	/**
	 * Decrypt a value using the existing key
	 * 
	 * @param encryptedData
	 * @return
	 * @throws Exception
	 */
	public String decrypt(String encryptedData) throws Exception {
		return decrypt(encryptedData, key);
	}
	
	private String decrypt(String encryptedData, Key key) throws Exception {
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = Base64.decodeBase64(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		return new String(decValue);
	}

	public static String encryptPII(String input) {
		String encryptedText = input;
		try {
			if (StringUtils.isEmpty(input) || input.contains(prefix)) {
				return input;
			}
			Cipher cipher = Cipher.getInstance(PIIALGORITHM);
			IvParameterSpec iv = generateIv();
			byte[] ivB = iv.getIV();
			cipher.init(Cipher.ENCRYPT_MODE, piiSecretKey, iv);
			byte[] cipherText = cipher.doFinal(input.getBytes());
			
			// Randomly generated IV is concatenated to secret which is required to decrypt at later stage.
			byte[] encryptedBytes = new byte[ivB.length + cipherText.length];
			System.arraycopy(ivB, 0, encryptedBytes, 0, ivB.length);
			System.arraycopy(cipherText, 0, encryptedBytes, ivB.length, cipherText.length);
			encryptedText = java.util.Base64.getEncoder().encodeToString(encryptedBytes);
			encryptedText = prefix.concat(encryptedText);
		} catch (Exception e) {
			logger.error("Error while encrypting data : ", e);
		}
		return encryptedText;
	}

	public static String decryptPII(String cipherText) {
		Cipher cipher;
		String converted = cipherText;
		try {
			if (StringUtils.isEmpty(cipherText)) {
				return cipherText;
			}
			if(cipherText.contains(prefix)) {
				cipherText = cipherText.substring(prefix.length());
				cipher = Cipher.getInstance(PIIALGORITHM);
				byte[] decoded = java.util.Base64.getDecoder().decode(cipherText);
				byte[] iv = Arrays.copyOfRange(decoded, 0, 16);
				byte[] cipherBytes = Arrays.copyOfRange(decoded, 16, decoded.length);
				cipher.init(Cipher.DECRYPT_MODE, piiSecretKey, new IvParameterSpec(iv));
				byte[] plainText = cipher.doFinal(cipherBytes);
				converted = new String(plainText);
			}
		} catch (Exception e) {
			logger.error("Error while decrypting cipher text", e);
		}

		return converted;
	}
	
	public String getJwtSignKey() {
		return jwtSignKey;
	}
	
	private static void setPIISecret(SecretKey key) {
		Security.piiSecretKey = key;
	}
}
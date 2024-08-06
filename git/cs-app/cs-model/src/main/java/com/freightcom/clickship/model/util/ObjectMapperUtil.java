package com.freightcom.clickship.model.util;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {

	private static Logger logger = LogManager.getLogger(ObjectMapperUtil.class);

	private static ObjectMapper objectMapper = new ObjectMapper();

	private ObjectMapperUtil() {
		// should not create object for util class
	}

	public static <R> R fromJson(String json, Class<R> returnType) {
		try {
			return objectMapper.readValue(json, returnType);
		} catch (IOException e) {
			logger.error(String.format("IOException in ObjectMapperUtil, while converting string to Entity Error : %s",
					e.getMessage()));
		}
		return null;
	}
	
	public static <R> R fromJson(String json, TypeReference<R> typeReference) {
		try {
			return objectMapper.readValue(json, typeReference);
		} catch (IOException e) {
			logger.error(String.format("IOException in ObjectMapperUtil, while converting string to Entity Error : %s",
					e.getMessage()));
		}
		return null;
	}

	public static <T> String toJson(T object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.error(String.format(
					"JsonProcessingException in ObjectMapperUtil, while converting Entity into string Error : %s",
					e.getMessage()));
		}
		return null;
	}
}

package com.freightcom.clickship.service.util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

@Component
public class JsonTransformer {

	@Autowired
	private ObjectMapper objectMapper;
	
	private static Gson gson = new GsonBuilder()
			.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() { 
			       public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
			          return new Date(jsonElement.getAsJsonPrimitive().getAsLong()); 
			       } 
			    })
			    .disableHtmlEscaping().create();

	private JsonTransformer() {
		// should not create object for util class
	}

	public <R> R fromJson(String json, Class<R> returnType) {
		try {
			return objectMapper.readValue(json, returnType);
		} catch (IOException e) {
			String msg = String.format("Exception while converting string to Entity. Error: %s", e.getMessage());
			throw new RuntimeException(msg, e);
		}
	}
	
	public <R> R fromJson(String json, final Type returnType) {
		try {
			return gson.fromJson(json, returnType);
		} catch (Exception e) {
			String msg = String.format("Exception while converting string to Entity. Error: %s", e.getMessage());
			throw new RuntimeException(msg, e);
		}
	}
	
	public <R> R fromJson(String json, TypeReference<R> typeReference) {
		try {
			return objectMapper.readValue(json, typeReference);
		} catch (IOException e) {
			String msg = String.format("Exception while converting string to Entity. Error: %s", e.getMessage());
			throw new RuntimeException(msg, e);
		}
	}

	public <T> String toJson(T object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			String msg = String.format("Exception while converting string to Entity. Error: %s", e.getMessage());
			throw new RuntimeException(msg, e);
		}
	}
	
	public <T> String toJsonPrettyFromat(T data) {
		ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
		
		try {
			return ow.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			String msg = String.format("Exception while converting Entity into string. Error: %s", e.getMessage());
			throw new RuntimeException(msg, e);
		}
	}
}

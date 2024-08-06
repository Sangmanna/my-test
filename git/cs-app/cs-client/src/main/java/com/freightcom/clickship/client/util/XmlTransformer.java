package com.freightcom.clickship.client.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Component;

import com.freightcom.clickship.model.exception.JAXBRuntimeException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Component
public class XmlTransformer {

	private static final String JAXB_PACKAGES = "com.freightcom.clickship.model.marketplace.walmart";

	private static final JAXBContext context = initializeContext();

	private static JAXBContext initializeContext() {
		JAXBContext context = null;

		try {
			context = JAXBContext.newInstance(JAXB_PACKAGES);
		} catch (JAXBException e) {
			throw new JAXBRuntimeException("Error creating the JAXB context. " + e.getMessage());
			
		}
		return context;
	}

	public static <T> String toXml(T object) {
		StringWriter sw = new StringWriter();
		Marshaller marshaller;
		try {
			marshaller = context.createMarshaller();
			marshaller.marshal(object, sw);
		} catch (JAXBException e) {
			throw new JAXBRuntimeException("Error while converting Object to XML " + e.getMessage());
		}
		return sw.toString();
	}

	public static <R> R fromXml(String xml, Class<R> returnType) {
		R result = null;
	
		try (StringReader stringReader = new StringReader(xml);) {
			final Unmarshaller unMarshaller = context.createUnmarshaller();
		
			result = unMarshaller.unmarshal(new StreamSource(stringReader), returnType).getValue();
		} catch (JAXBException e) {
			throw new JAXBRuntimeException("Error while converting XML to Object " + e.getMessage() + " xml=" + xml);
		} 
		return result;
	}
	
}


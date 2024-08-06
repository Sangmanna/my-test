package com.freightcom.clickship.client.exchangerates;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.freightcom.clickship.model.exception.JAXBRuntimeException;
import com.freightcom.clickship.model.exchange.rates.ExchangeRate;

import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Component
public class ExchangeRateClient {
	
	private Logger logger = LogManager.getLogger(ExchangeRateClient.class);

	@Value("${bankofcanada.exchange.rate.url}")
	private String exchangeRateUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ExchangeRate getExchangeRateObject(String date) {
		String url =  exchangeRateUrl + date;
		ExchangeRate response = restTemplate.exchange(url, HttpMethod.GET, getRequest(), ExchangeRate.class).getBody();
		return response;
	}
	
	private HttpEntity<Object> getRequest() {
		return new HttpEntity<>(new HttpHeaders());
	}
	
	private JAXBContext context = null;

	@PostConstruct
	private void initializeContext() throws Exception {
		try {
			context = JAXBContext.newInstance("com.freightcom.clickship.model.exchange.rates");
		} catch (JAXBException e) {
			logger.error("Error creating the FC client JAXB context.", e);
		}
	}
	
	@SuppressWarnings("unused")
	private <T> String toXml(T object) {
		StringWriter sw = new StringWriter();
		Marshaller marshaller;
		try {
			marshaller = context.createMarshaller();
			marshaller.marshal(object, sw);
		} catch (JAXBException e) {
			logger.error("Error while converting Object to XML", e);
			throw new JAXBRuntimeException("Error while converting Object to XML " + e.getMessage());
		}
		return sw.toString();
	}

	@SuppressWarnings("unused")
	private <R> R fromXml(String xml, Class<R> returnType) {
		R result = null;
	
		try {
			StringReader stringReader = new StringReader(xml);
			final Unmarshaller unMarshaller = context.createUnmarshaller();
		
			result = unMarshaller.unmarshal(new StreamSource(stringReader), returnType).getValue();
		} catch (JAXBException e) {
			logger.error("Error while converting XML to Object - xml:{}", xml, e); 
			throw new JAXBRuntimeException("Error while converting XML to Object " + e.getMessage() + " xml=" + xml);
		} 
		return result;
	}
}

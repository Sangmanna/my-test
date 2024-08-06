package com.freightcom.clickship.client.freightcom;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.freightcom.clickship.model.carrier.freightcom.CustomerDetailsRequest;
import com.freightcom.clickship.model.carrier.freightcom.CustomerDetailsResponse;
import com.freightcom.clickship.model.carrier.freightcom.CustomerDetailsResponse_;
import com.freightcom.clickship.model.carrier.freightcom.FCCreditCardRequest;
import com.freightcom.clickship.model.carrier.freightcom.FCRateRequest;
import com.freightcom.clickship.model.carrier.freightcom.FCRateResponse;
import com.freightcom.clickship.model.carrier.freightcom.FreightcomError;
import com.freightcom.clickship.model.carrier.freightcom.RegisterCustomerRequest;
import com.freightcom.clickship.model.carrier.freightcom.RegisterCustomerResponse;
import com.freightcom.clickship.model.carrier.freightcom.RegisterCustomerResponse_;
import com.freightcom.clickship.model.carrier.freightcom.UpdateCustomerRequest;
import com.freightcom.clickship.model.carrier.freightcom.UpdatePasswordRequest;
import com.freightcom.clickship.model.carrier.freightcom.UpdatePasswordResponse;
import com.freightcom.clickship.model.carrier.freightcom.UpdatePasswordResponse_;
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.exception.FreightcomException;
import com.freightcom.clickship.model.exception.JAXBRuntimeException;
import com.freightcom.clickship.model.exception.http.ClickshipHttpRestException;

import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Component
public class FreightcomClient {

	private Logger logger = LogManager.getLogger(FreightcomClient.class);

	@Value("${freightcom.scheme}")
	private String scheme;

	@Value("${freightcom.host}")
	private String host;

	@Value("${freightcom.port}")
	private int port;

	@Value("${freightcom.register.path}")
	private String registerURI;

	@Value("${freightcom.uri.rpc2}")
	private String uriRpc2;
	
	@Value("${freightcom.uri.fcrpc}")
	private String uriFcrpc;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public RegisterCustomerResponse registerAccount(RegisterCustomerRequest request) {
		try {
			String response = callFC(registerURI, request, true, "");
			return fromXml(response, RegisterCustomerResponse_.class).getResponse();
		} catch(ClickshipHttpRestException e) {
			FreightcomError error = handleError(e.getResponseBodyAsString());
			throw new FreightcomException(error.getErrorReply().getError().getMessage());
		}
	}
	
	public CustomerDetailsResponse getCustomerDetails(CustomerDetailsRequest request) {
		try {
			String response = callFC(uriFcrpc, request, true, "");
			return fromXml(response, CustomerDetailsResponse_.class).getResponse();
		} catch(ClickshipHttpRestException e) {
			FreightcomError error = handleError(e.getResponseBodyAsString());
			throw new FreightcomException(error.getErrorReply().getError().getMessage());
		}
	}

	public void updateCreditCard(FCCreditCardRequest creditCard) {
		callFC(uriFcrpc, creditCard, false, "");
	}
	
	public void updateFreightcomCustomer(UpdateCustomerRequest fcAddressReq) {
		callFC(uriFcrpc, fcAddressReq, true, "");
	}
	
	public void updateFCSignUpSource(UpdateCustomerRequest request) {
		callFC(uriFcrpc, request, true, "");
	}
	
	public UpdatePasswordResponse updatePassword(UpdatePasswordRequest request) {
		String response = callFC(uriFcrpc, request, true, "");
		return fromXml(response, UpdatePasswordResponse_.class).getResponse();
	}
	
	public FCRateResponse getRates(FCRateRequest request, String reqId) {
		String response = callFC(uriRpc2, request, true, reqId);
		return fromXml(response, FCRateResponse.class);
	}
	
	public String retrieveInvoices(String xmlRequest) {
		return restTemplate.exchange(getUrl(uriRpc2), HttpMethod.POST, getRequestEntity(xmlRequest, null), String.class).getBody();
	}
	
	public String trackShipment(String xmlRequest) {
		return restTemplate.exchange(getUrl(uriRpc2), HttpMethod.POST, getRequestEntity(xmlRequest, null), String.class).getBody();
	}
	
	public String trackShipment(String xmlRequest, String customerId) {
		return trackShipment(xmlRequest);
	}
	
	private String callFC(String path, Object request, boolean printResponse, String reqId) {
		try {
			String xmlRequest = toXml(request);			
			
			if(printResponse) {
				String printString = xmlRequest.replaceAll("password=\\\"([^\\\"]*)\\\"", "password=\"*****\"").replaceAll("newPassword=\\\"([^\\\"]*)\\\"", "newPassword=\"*****\"");
				logger.info("[{}] - Path: [{}], Request: [{}]", reqId, path, printString);
			}
			
			String responseStr = restTemplate.exchange(getUrl(path), HttpMethod.POST, getRequestEntity(xmlRequest, reqId), String.class).getBody();
			
			if(printResponse && responseStr != null)
				logger.info("[{}] - Response: [{}]", reqId, responseStr.length()>2000? responseStr.substring(0, 2000) : responseStr);
			
			return responseStr;
		} catch(ClickshipHttpRestException e) {
			logger.error("Exception while calling FC - response-{}", e.getResponseBodyAsString());
			
			FreightcomError error = handleError(e.getResponseBodyAsString());
			throw new FreightcomException(error.getErrorReply().getError().getMessage());
		}
	}
	
	private FreightcomError handleError(String errorMessage) {
		return fromXml(errorMessage, FreightcomError.class);
	}
	
	private URI getUrl(String path) {
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme(scheme);
		uriBuilder.setHost(host);
		
		if (port != -1) {
			uriBuilder.setPort(port);
		}
		
		uriBuilder.setPath(path);
		
		try {
			return uriBuilder.build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(String.format("Error while constructing url:%s, path:%s", host, path));
		}
	}
	
	private HttpEntity<Object> getRequestEntity(Object requestBody, String reqId){
        HttpHeaders requestHeaders = getHeadersWithContentType(reqId);
        
        if(requestBody != null ) {
        	return new HttpEntity<>(requestBody, requestHeaders); 	
        }else {
        	return new HttpEntity<>(requestHeaders);
        }
	}
	
	private HttpHeaders getHeadersWithContentType(String reqId) {
		String requestId = StringUtils.isEmpty(reqId) ? UUID.randomUUID().toString() : reqId;
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.TEXT_XML);
        requestHeaders.set(ClickShipConstants.HEADER_REQUEST_ID, requestId);
        
        logger.info("RequestId '{}'", requestId);
        
        return requestHeaders;
	}
	
	private JAXBContext context = null;

	@PostConstruct
	private void initializeContext() {
		try {
			context = JAXBContext.newInstance("com.freightcom.clickship.model.carrier.freightcom");
		} catch (JAXBException e) {
			logger.error("Error creating the FC client JAXB context.", e);
		}
	}
	
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

	public void setRTRRestTemplate(RestTemplate rtrRestTemplate) {
		this.restTemplate = rtrRestTemplate;
	}
}

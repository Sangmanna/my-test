package com.freightcom.clickship.client.ups;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.freightcom.clickship.model.carrier.CarrierAccountDTO;
import com.freightcom.clickship.model.carrier.ups.UPSEndpoints;
import com.freightcom.clickship.model.carrier.ups.UpsRestRequest;
import com.freightcom.clickship.model.carrier.ups.UpsRestResponse;
import com.freightcom.clickship.model.exception.http.ClickshipHttpRestException;

@Component
public class UpsRatesRestClient {
	private Logger logger = LogManager.getLogger(this.getClass());

	private static final String ACCEPT = "Accept";

	@Value("${ups.rest.url:https://wwwcie.ups.com}")
	private String upsRestUrl;

	@Autowired
	private RestTemplate restTemplate;

	public UpsRestResponse getRates(CarrierAccountDTO dto, UpsRestRequest req, String transactionRef) {
		try {
			String url = upsRestUrl + UPSEndpoints.RATE.getValue();
			url = replaceEndPoint(url, dto);

			HttpEntity<Object> requestEntity = getRequestEntity(dto, req, transactionRef);
			logRequest(url, requestEntity);
			return restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(dto, req, transactionRef), UpsRestResponse.class).getBody();
		} catch (ClickshipHttpRestException e) {
			throw new RuntimeException(e.getResponseBodyAsString());
		}
	}

	private void logRequest(String url, HttpEntity<Object> requestEntity) {
		logger.debug("UPS endpoint: {}", url);
		// Log the headers, except for 'Authorization', 'Username', 'Password'
		requestEntity.getHeaders().entrySet().stream()
		.filter(entry -> !entry.getKey().equalsIgnoreCase("Authorization") &&
						!entry.getKey().equalsIgnoreCase("Username") &&
						!entry.getKey().equalsIgnoreCase("Password"))
		.forEach(entry -> logger.debug("Header: {} = {}", entry.getKey(), entry.getValue()));
	}
	
	public UpsRestResponse getTimeInTransit(UpsRestRequest req, String transactionRef) {
		String url = upsRestUrl + UPSEndpoints.TIME_IN_TRANSIT.getValue();
		return restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(null, req, transactionRef), UpsRestResponse.class).getBody();
	}
	
	public UpsRestResponse getTrackingInfo(CarrierAccountDTO dto, String trackingNumber) {
		String txRef = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String url = upsRestUrl + UPSEndpoints.TRACKING.getValue() + trackingNumber;
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(dto, null, txRef), UpsRestResponse.class).getBody();
	}

	private HttpEntity<Object> getRequestEntity(CarrierAccountDTO carrier, Object postRequestBody, String transactionRef) {
		HttpHeaders requestHeaders = getHeaders(carrier, transactionRef);
		return postRequestBody != null ? new HttpEntity<>(postRequestBody, requestHeaders) : new HttpEntity<>(requestHeaders);
	}
	
	protected HttpHeaders getHeaders(CarrierAccountDTO dto, String transactionRef) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add(ACCEPT, MediaType.APPLICATION_JSON_VALUE);

		if(dto != null) {
			headers.add("Username", dto.getCarrierUsername());
			headers.add("Password", dto.getCarrierPassword());
			headers.add("AccessLicenseNumber", dto.getCarrierToken());			
		}

		headers.add("transId", transactionRef);
		headers.add("transactionSrc", "ClickShip");

		return headers;
	}
	
	public String replaceEndPoint(String url, CarrierAccountDTO dto) {
		return url;
	}
}

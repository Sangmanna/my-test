package com.freightcom.clickship.client.canadapost;

import java.io.StringReader;
import java.util.Base64;

import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang3.StringUtils;
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
import com.freightcom.clickship.model.carrier.canadapost.MailingScenario;
import com.freightcom.clickship.model.carrier.canadapost.TrackingSummary;
import com.freightcom.clickship.model.carrier.canadapost.tracking.TrackingDetail;
import com.freightcom.clickship.model.exception.http.ClickshipHttpRestException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

@Component("CanadaPostRestClientV2")
public class CanadaPostRestClient {
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Value("${canadapost.host}")
	private String canadapostHost;
	
	@Value("${canadapost.rs.rate:https://%s/rs/ship/price}")
	private String ratesRestAPI;
	
	@Value("${canadapost.rs.tracking:https://%s/vis/track/pin/%s/summary}")
	private String trackingRestAPI;
	
	@Value("${canadapost.rs.trackingDetail:https://%s/vis/track/pin/%s/detail}")
	private String trackingDetailRestAPI;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getRates(CarrierAccountDTO account, MailingScenario mailingScenario) {
		String URL = String.format(ratesRestAPI, canadapostHost);
		
		try {
			return restTemplate.exchange(URL, HttpMethod.POST, getRatesRequestEntity(account, mailingScenario), String.class).getBody();	
		} catch(ClickshipHttpRestException e) {
			throw new RuntimeException(e.getResponseBodyAsString());
		}
	}
	
	public TrackingDetail getShipmentTrackDetail(CarrierAccountDTO account, String trackingNumber) throws Exception {
		try {
			String URL = String.format(trackingDetailRestAPI, canadapostHost, trackingNumber);
			String xmlString = restTemplate.exchange(URL, HttpMethod.GET, getTrackingRequestEntity(account), String.class).getBody();

			if (StringUtils.contains(xmlString, "No Pin History")) {
				return new TrackingDetail(); // return empty
			}
			
			return (TrackingDetail) JAXBContext.newInstance(TrackingDetail.class).createUnmarshaller().unmarshal(new StringReader(xmlString));
		} catch (Exception e) {
			logger.error("Error while getting CanadaPost tracking details - account:{}, tracking:{}", account.getCarrierAccountNumber(), trackingNumber, e);
			throw e;
		}
	}
	
	public TrackingSummary getShipmentTrackSummary(CarrierAccountDTO account, String trackingNumber) {
		try {
			String URL = String.format(trackingRestAPI, canadapostHost, trackingNumber);
			String resp = restTemplate.exchange(URL, HttpMethod.GET, getTrackingRequestEntity(account), String.class).getBody();

			Unmarshaller jaxb = JAXBContext.newInstance(TrackingSummary.class).createUnmarshaller();
			return jaxb.unmarshal(new StreamSource(new StringReader(resp)), TrackingSummary.class).getValue();
		} catch (JAXBException e) {
			String error = String.format("JAXB error while extracting tracking summary response for pin:%s", trackingNumber);
			throw new RuntimeException(error, e);
		} catch (Exception e) {
			String error = String.format("CandaPost API error while retrieving tracking summary for pin:%s", trackingNumber);
			throw new RuntimeException(error, e);
		}	
	}
	
	private HttpEntity<Object> getTrackingRequestEntity(CarrierAccountDTO account){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        return getRequestEntity(account, requestHeaders, null);
	}
	
	private HttpEntity<Object> getRatesRequestEntity(CarrierAccountDTO account, Object requestBody) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set("Accept-language", "en-CA");
		requestHeaders.set("Accept", "application/vnd.cpc.ship.rate-v4+xml");
		requestHeaders.set("Content-Type", "application/vnd.cpc.ship.rate-v4+xml");		
		
		return getRequestEntity(account, requestHeaders, requestBody);
	}
	
	private HttpEntity<Object> getRequestEntity(CarrierAccountDTO account, HttpHeaders requestHeaders, Object requestBody) {
		requestHeaders.set("Authorization", getBasicAuthConfig(account));

		if (requestBody != null) {
			return new HttpEntity<>(requestBody, requestHeaders);
		} else {
			return new HttpEntity<>(requestHeaders);
		}
	}
	
	private String getBasicAuthConfig(CarrierAccountDTO account) {
		String token = account.getCarrierUsername() +":"+ account.getCarrierPassword();
        return "Basic " + Base64.getEncoder().encodeToString(token.getBytes());
	}
}

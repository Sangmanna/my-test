package com.freightcom.clickship.client.midland;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freightcom.clickship.model.carrier.CarrierAccountDTO;
import com.freightcom.clickship.model.carrier.midland.CancelPickupResponse;
import com.freightcom.clickship.model.carrier.midland.CancelPickupResponseWrapper;
import com.freightcom.clickship.model.carrier.midland.CancelShipmentResponse;
import com.freightcom.clickship.model.carrier.midland.CancelShipmentWrapper;
import com.freightcom.clickship.model.carrier.midland.MidlandProbill;
import com.freightcom.clickship.model.carrier.midland.PickupRequestWrapper;
import com.freightcom.clickship.model.carrier.midland.PickupResponse;
import com.freightcom.clickship.model.carrier.midland.PickupResponseWrapper;
import com.freightcom.clickship.model.carrier.midland.RequestWrapper;
import com.freightcom.clickship.model.carrier.midland.ResponseWrapper;
import com.freightcom.clickship.model.carrier.midland.ShipmentRequestWrapper;
import com.freightcom.clickship.model.carrier.midland.ShipmentResponse;
import com.freightcom.clickship.model.carrier.midland.ShipmentResponseWrapper;
import com.freightcom.clickship.model.carrier.midland.TrackingResponse;

@Component
public class MidlandRestClient {

    private Logger logger = LogManager.getLogger(this.getClass());
    
    @Value("${midland.rest.url:https://testapigateway.jdirving.com/gateway/}")
    private String URL;
    
	@Autowired
	private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

	public ResponseWrapper getRates(CarrierAccountDTO account, RequestWrapper req) {
		ResponseEntity<?> response = midlandPostApi(account, URL + MidlandEndpoint.GET_RATES.getValue(), req, getType(ResponseWrapper.class));
		logger.info(toJson(response));
		
		return (ResponseWrapper) response.getBody();
	}
    
    public ShipmentResponse processShipment(CarrierAccountDTO carrier, ShipmentRequestWrapper req) {
        ResponseEntity<?> response = midlandPostApi(carrier, URL+MidlandEndpoint.CREATE_SHIPMENT.getValue(), req, shipmentResponseWrapper);
        logger.info(toJson(response));
        ShipmentResponseWrapper shipmentResponse = (ShipmentResponseWrapper) response.getBody();
        return shipmentResponse.getShipmentResponse();
    }

    public CancelShipmentResponse voidShipment(CarrierAccountDTO carrier, String bolNumber){
        HttpHeaders requestHeaders = getHeaders(carrier);
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestHeaders);
        logger.info("Midland Cancel Shipment - Carrier Account:{},BOL Number:{}, req:{} ", carrier.getCarrierAccountNumber(), bolNumber, toJson(requestEntity));

        ResponseEntity<?> response = restTemplate.exchange(URL+MidlandEndpoint.CANCEL_SHIPMENT.getValue()+bolNumber, HttpMethod.GET, requestEntity, cancelShipmentRespWrapper);
        return ((CancelShipmentWrapper) response.getBody()).getCancelShipmentResponse();
    }

    public List<MidlandProbill> trackShipment(CarrierAccountDTO carrier, String bolNumber){
        HttpHeaders requestHeaders = getHeaders(carrier);
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestHeaders);
        logger.info("Midland Track Shipment - Carrier Account:{}, BOL Number:{} ", carrier.getCarrierAccountNumber(), bolNumber, toJson(requestEntity));

        ResponseEntity<?> response = restTemplate.exchange(URL+MidlandEndpoint.TRACK_AND_TRACE.getValue()+bolNumber, HttpMethod.GET, requestEntity, trackingResponse);
        return ((TrackingResponse) response.getBody()).getMidlandProbills();
    }

    public PickupResponse schedulePickup(CarrierAccountDTO carrier, PickupRequestWrapper pickupRequestWrapper){
        ResponseEntity<?> response = midlandPostApi(carrier, URL+MidlandEndpoint.PICKUP.getValue(), pickupRequestWrapper, pickupResponseWrapper);
        logger.info(toJson(response));

        return ((PickupResponseWrapper) response.getBody()).getPickupResponse();
    }

    public CancelPickupResponse cancelPickup(CarrierAccountDTO carrier, String pickupConfirmationNumber, String proNumber){
        HttpHeaders requestHeaders = getHeaders(carrier);
        Map<String, String> params = new HashMap<>();
        params.put("PickupNumber",pickupConfirmationNumber);
        params.put("pronumber",proNumber);
        
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestHeaders);
        logger.info(toJson(requestEntity));
        
        UriComponentsBuilder uri = UriComponentsBuilder.fromUriString(URL+MidlandEndpoint.CANCEL_PICKUP.getValue());
        ResponseEntity<?> response = restTemplate.exchange(uri.buildAndExpand(params).toUri(), HttpMethod.DELETE, requestEntity, cancelPickupResponseWrapper);
        
        logger.info(toJson(response));
        
        return ((CancelPickupResponseWrapper) response.getBody()).getCancelPickupResponse();
    }
    
    private ResponseEntity<?> midlandPostApi(CarrierAccountDTO carrier, String endPointUri, Object requestBody, ParameterizedTypeReference<?> returnType) {
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestBody, getHeaders(carrier));
        logger.info(toJson(requestEntity));
        
        return restTemplate.exchange(endPointUri, HttpMethod.POST, requestEntity, returnType);
    }

//    private static final ParameterizedTypeReference<ResponseWrapper> ratesResponse = new ParameterizedTypeReference<ResponseWrapper>() {
//    };

    private static final ParameterizedTypeReference<ShipmentResponseWrapper> shipmentResponseWrapper = new ParameterizedTypeReference<ShipmentResponseWrapper>() {
    };

    private static final ParameterizedTypeReference<CancelShipmentWrapper> cancelShipmentRespWrapper = new ParameterizedTypeReference<CancelShipmentWrapper>() {
    };

    private static final ParameterizedTypeReference<TrackingResponse> trackingResponse = new ParameterizedTypeReference<TrackingResponse>() {
    };

    private static final ParameterizedTypeReference<PickupResponseWrapper> pickupResponseWrapper = new ParameterizedTypeReference<PickupResponseWrapper>() {
    };

    private static final ParameterizedTypeReference<CancelPickupResponseWrapper> cancelPickupResponseWrapper = new ParameterizedTypeReference<CancelPickupResponseWrapper>() {
    };
    
	private <T> String toJson(T object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			String msg = String.format("Exception while converting string to Entity. Error: %s", e.getMessage());
			throw new RuntimeException(msg, e);
		}
	}
	
	private HttpHeaders getHeaders(CarrierAccountDTO carrier) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        requestHeaders.add("x-Gateway-APIKey", carrier.getCarrierKey());
        return requestHeaders;
    }
	
	private <T> ParameterizedTypeReference<T> getType(Type type) {
		return ParameterizedTypeReference.forType(type);
	}
}

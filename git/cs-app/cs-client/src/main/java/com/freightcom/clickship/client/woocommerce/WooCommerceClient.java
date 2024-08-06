package com.freightcom.clickship.client.woocommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.freightcom.clickship.client.auth.BasicAuthConfig;
import com.freightcom.clickship.client.auth.OAuthConfig;
import com.freightcom.clickship.client.auth.OAuthSignature;
import com.freightcom.clickship.client.auth.SpecialSymbol;
import com.freightcom.clickship.client.woocommerce.auth.WooCommerceAuth;
import com.freightcom.clickship.model.exception.http.UnauthorizedException;
import com.freightcom.clickship.model.marketplace.woocommerce.GeneralSetting;
import com.freightcom.clickship.model.marketplace.woocommerce.ProductSetting;
import com.freightcom.clickship.model.marketplace.woocommerce.WcEndpoint;
import com.freightcom.clickship.model.marketplace.woocommerce.WooCommerceOrder;
import com.freightcom.clickship.model.marketplace.woocommerce.WooCommerceProduct;
import com.freightcom.clickship.model.marketplace.woocommerce.WooCommerceStoreAddress;
import com.freightcom.clickship.model.marketplace.woocommerce.WooCommerceStoreMeasurements;
import com.freightcom.clickship.model.marketplace.woocommerce.WooCommerceSystemStatus;
import com.freightcom.clickship.model.marketplace.woocommerce.WooCommerceTracking;
import com.freightcom.clickship.model.marketplace.woocommerce.WooCommerceWebhookBatchRequest;
import com.freightcom.clickship.model.marketplace.woocommerce.WooCommerceWebhookBatchResponse;
import com.freightcom.clickship.model.marketplace.woocommerce.WooCommerceWebhookRequest;
import com.freightcom.clickship.model.marketplace.woocommerce.WooCommerceWebhookResponse;

@Component
public class WooCommerceClient {
	
	private Integer OFF_SET = 1;
	
	private static final String OFF_SET_STRING = "page";
	private static final String PER_PAGE_STRING = "per_page";
	private static final String URL_SECURED_FORMAT = "%s?%s";
	private static final String TOTAL_PAGES = "X-WP-TotalPages";
	private static final String API_URL_FORMAT_V1 = "%s/wp-json/wc/v1/%s";
	private static final String API_URL_FORMAT_V3 = "%s/wp-json/wc/v3/%s";
	
	private static final String STATUS = "status";
	private static final String PROCESSING = "processing";
	
//	private static final String API_URL_ONE_ENTITY_FORMAT = "%s/wp-json/wc/v3/%s/%d";

	private static final ParameterizedTypeReference<WooCommerceOrder> order 
					= new ParameterizedTypeReference<WooCommerceOrder>() { };
					
	private static final ParameterizedTypeReference<WooCommerceProduct> product 
					= new ParameterizedTypeReference<WooCommerceProduct>() { };

	private static final ParameterizedTypeReference<WooCommerceTracking> tracking 
					= new ParameterizedTypeReference<WooCommerceTracking>() { };
					
	private static final ParameterizedTypeReference<List<WooCommerceOrder>> orders 
					= new ParameterizedTypeReference<List<WooCommerceOrder>>() { };
	
	private static final ParameterizedTypeReference<List<WooCommerceProduct>> products 
					= new ParameterizedTypeReference<List<WooCommerceProduct>>() { };
	
	private static final ParameterizedTypeReference<WooCommerceWebhookResponse> webhook 
					= new ParameterizedTypeReference<WooCommerceWebhookResponse>() { };
					
	private static final ParameterizedTypeReference<List<WooCommerceWebhookResponse>> webhooks 
					= new ParameterizedTypeReference<List<WooCommerceWebhookResponse>>() { };					

	private static final ParameterizedTypeReference<List<GeneralSetting>> generalSettings 
					= new ParameterizedTypeReference<List<GeneralSetting>>() { };
					
	private static final ParameterizedTypeReference<List<ProductSetting>> productSettings 
					= new ParameterizedTypeReference<List<ProductSetting>>() { };

	private static final ParameterizedTypeReference<WooCommerceWebhookBatchResponse> batchWebhooks 
					= new ParameterizedTypeReference<WooCommerceWebhookBatchResponse>() { };
					
	private static final ParameterizedTypeReference<WooCommerceSystemStatus> systemStatus 
					= new ParameterizedTypeReference<WooCommerceSystemStatus>() { };
	
	@Autowired
	private RestTemplate restTemplate;

	public WooCommerceSystemStatus getSystemStatus(WooCommerceAuth config) {
		return (WooCommerceSystemStatus) wcGetV3(config, WcEndpoint.SYSTEM_STATUS.getValue(), null, null, systemStatus).getBody();
	}
	
	public WooCommerceStoreAddress getStoreWrhAddress(WooCommerceAuth config) {
		return getWooCommerceStoreAddress(wcGetV3(config, WcEndpoint.SETTINGS_GENERAL.getValue(), null, null, generalSettings).getBody());
	}
	
	public WooCommerceStoreMeasurements getStoreMeasurements(WooCommerceAuth config) {
		return getStoreMessurment(wcGetV3(config, WcEndpoint.SETTINGS_PRODUCT.getValue(), null, null, productSettings).getBody());
	}
	
	public WooCommerceWebhookBatchResponse webhooksBatchRegistration(WooCommerceAuth config, WooCommerceWebhookBatchRequest request) {
        ResponseEntity<?> responseEntity = wcPostV3(config, WcEndpoint.WEBHOOKS_BATCH.getValue(), null, request, batchWebhooks);
        return responseEntity.getStatusCode().is2xxSuccessful() ? (WooCommerceWebhookBatchResponse) responseEntity.getBody() : null;
	}
	
	public boolean registerForWebhooks(WooCommerceAuth config, WooCommerceWebhookRequest request) {
		ResponseEntity<?> responseEntity = wcPostV3(config, WcEndpoint.WEBHOOKS_CREATE.getValue(), null, request, webhook);
		return responseEntity.getStatusCode().is2xxSuccessful() ? true : false;
	}
	
	@SuppressWarnings("unchecked")
	public List<WooCommerceWebhookResponse> getRegisteredWebhooks(WooCommerceAuth config, Integer pageSize) {
		Map<String, String> params = new HashMap<>();
		params.put(OFF_SET_STRING, OFF_SET.toString());
		params.put(PER_PAGE_STRING, pageSize.toString());
		
		return (List<WooCommerceWebhookResponse>) wcGetV3(config, WcEndpoint.WEBHOOKS_CREATE.getValue(), params, null, webhooks).getBody();
	}
	
	public List<WooCommerceProduct> getAllProducts(WooCommerceAuth config, Integer pageSize, String status) {
		
		Map<String, String> params = new HashMap<>();
		params.put(STATUS, status);
		params.put(OFF_SET_STRING, OFF_SET.toString());
		params.put(PER_PAGE_STRING, pageSize.toString());
		
		//Fetch the products with default SIZE 100  
		ResponseEntity<?> responseEntity = wcGetV3(config, WcEndpoint.PRODUCTS.getValue(), params, null, products);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        @SuppressWarnings("unchecked")
		List<WooCommerceProduct> list = (List<WooCommerceProduct>) responseEntity.getBody();

        int totalPages = Integer.parseInt(responseHeaders.get(TOTAL_PAGES).get(0));
        
        //Check if more products are available
        if(totalPages > 1) {
        	list.addAll(getTheRemainingProducts(config, status, pageSize, totalPages));
        }
		
		return list;
	}
	
	public List<WooCommerceOrder> getAllOrders(WooCommerceAuth config, Integer pageSize) {
		
		Map<String, String> params = new HashMap<>();
		params.put(STATUS, PROCESSING);
		params.put(OFF_SET_STRING, OFF_SET.toString());
		params.put(PER_PAGE_STRING, pageSize.toString());
		
		
		//Fetch the products with default SIZE 100  
		ResponseEntity<?> responseEntity = wcGetV3(config, WcEndpoint.ORDERS.getValue(), params, null, orders);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        @SuppressWarnings("unchecked")
		List<WooCommerceOrder> list = (List<WooCommerceOrder>) responseEntity.getBody();

        int totalPages = Integer.parseInt(responseHeaders.get(TOTAL_PAGES).get(0));
        
        //Check if more orders are available
        if(totalPages > 1) {
        	list.addAll(getTheRemainingOrders(config, pageSize, totalPages));
        }
		
		return list;
	}
	
	public WooCommerceTracking createShipmentTracking(WooCommerceAuth config, String orderId, WooCommerceTracking wcOrder ) {
		String uri = StringUtils.replace(WcEndpoint.TRACKING.getValue(), "{orderId}", orderId);
	    return (WooCommerceTracking) wcPostV1(config, uri, null, wcOrder, tracking).getBody();
	}
	
	public void deleteShipmentTracking(WooCommerceAuth config, String orderId, String trackingId) {
		StringBuilder uri =  new StringBuilder(StringUtils.replace(WcEndpoint.TRACKING.getValue(), "{orderId}", orderId));
		uri.append("/").append(trackingId);
		
		wcDeleteV1(config, uri.toString(), null, null);
	}
	
	public WooCommerceOrder getOrder(WooCommerceAuth config, String orderId) {
		StringBuilder uri =  new StringBuilder(WcEndpoint.ORDERS.getValue()).append("/").append(orderId);
		return (WooCommerceOrder) wcGetV3(config, uri.toString(), null, null, order).getBody();
	}
	
	public WooCommerceProduct getProduct(WooCommerceAuth config, String productId) {
		StringBuilder uri =  new StringBuilder(WcEndpoint.PRODUCTS.getValue()).append("/").append(productId);
		return (WooCommerceProduct) wcGetV3(config, uri.toString(), null, null, product).getBody();
	}
	
	public WooCommerceOrder updateOrder(WooCommerceAuth config, String orderId, WooCommerceOrder wcOrder ) {
		StringBuilder uri =  new StringBuilder(WcEndpoint.ORDERS.getValue()).append("/").append(orderId);
		return (WooCommerceOrder) wcPutV3(config, uri.toString(), null, wcOrder, order).getBody();
	}
	
	@SuppressWarnings("unchecked")
	private List<WooCommerceProduct> getTheRemainingProducts(WooCommerceAuth config, String status, Integer pageSize, int totalPages){
		
		Map<String, String> params = new HashMap<>();
		List<WooCommerceProduct> productsList = new ArrayList<>();
		
		for(Integer page=2; page <= totalPages; page++) {
			params.put(OFF_SET_STRING, page.toString());
			params.put(PER_PAGE_STRING, pageSize.toString());
			params.put(STATUS, status);
			
			productsList.addAll((List<WooCommerceProduct>) wcGetV3(config, WcEndpoint.PRODUCTS.getValue(), params, null, products).getBody());
		}
		
		return productsList;
	}
	
	@SuppressWarnings("unchecked")
	private List<WooCommerceOrder> getTheRemainingOrders(WooCommerceAuth config, Integer pageSize, int totalPages){
		
		Map<String, String> params = new HashMap<>();
		List<WooCommerceOrder> orderList = new ArrayList<>();
		
		for(Integer page=2; page <= totalPages; page++) {
			params.put(OFF_SET_STRING, page.toString());
			params.put(PER_PAGE_STRING, pageSize.toString());
			params.put(STATUS, PROCESSING);
			
			orderList.addAll((List<WooCommerceOrder>) wcGetV3(config, WcEndpoint.ORDERS.getValue(), params, null, orders).getBody());
		}
		
		return orderList;
	}
	
//	private ResponseEntity<?> wcGetV1(WooCommerceAuth config, String uri, Map<String, String> params, Object requestBody, ParameterizedTypeReference<?> returnType) {
//		return callWC(getV1URL(config, uri, HttpMethod.GET, params), HttpMethod.GET, getRequestEntity(config, requestBody), returnType);
//	}
	
	private ResponseEntity<?> wcGetV3(WooCommerceAuth config, String uri, Map<String, String> params, Object requestBody, ParameterizedTypeReference<?> returnType) {
		return callWC(config, getV3URL(config, uri, HttpMethod.GET, params), HttpMethod.GET, getRequestEntity(config, requestBody), returnType);
	}

	private ResponseEntity<?> wcPostV1(WooCommerceAuth config, String uri, Map<String, String> params, Object requestBody, ParameterizedTypeReference<?> returnType) {
		return callWC(config, getV1URL(config, uri, HttpMethod.POST, params), HttpMethod.POST, getRequestEntity(config, requestBody), returnType);
	}
	
	private ResponseEntity<?> wcPostV3(WooCommerceAuth config, String uri, Map<String, String> params, Object requestBody, ParameterizedTypeReference<?> returnType) {
		return callWC(config, getV3URL(config, uri, HttpMethod.POST, params), HttpMethod.POST, getRequestEntity(config, requestBody), returnType);
	}
	
//	private ResponseEntity<?> wcPutV1(WooCommerceAuth config, String uri, Map<String, String> params, Object requestBody, ParameterizedTypeReference<?> returnType) {
//		return callWC(getV1URL(config, uri, HttpMethod.PUT, params), HttpMethod.PUT, getRequestEntity(config, requestBody), returnType);
//	}
	
	private ResponseEntity<?> wcPutV3(WooCommerceAuth config, String uri, Map<String, String> params, Object requestBody, ParameterizedTypeReference<?> returnType) {
		return callWC(config, getV3URL(config, uri, HttpMethod.PUT, params), HttpMethod.PUT, getRequestEntity(config, requestBody), returnType);
	}
	
	private ResponseEntity<?> wcDeleteV1(WooCommerceAuth config, String uri, Map<String, String> params, Object requestBody) {
		return restTemplate.exchange(getV1URL(config, uri, HttpMethod.DELETE, params), HttpMethod.DELETE, getRequestEntity(config, requestBody), Void.class, 1);
	}
	
//	private ResponseEntity<?> wcDeleteV3(WooCommerceAuth config, String uri, Map<String, String> params, Object requestBody) {
//		return restTemplate.exchange(getV3URL(config, uri, HttpMethod.DELETE, params), HttpMethod.DELETE, getRequestEntity(config, requestBody), Void.class, 1);
//	}
	
	private ResponseEntity<?> callWC(WooCommerceAuth config, String URL, HttpMethod method, HttpEntity<Object> entity, ParameterizedTypeReference<?> returnType) {
		try {
			return restTemplate.exchange(URL, method, entity, returnType);	
		} catch (UnauthorizedException e) {
			// Occasionally some servers may not parse the Basic Authorization header
			// correctly In this case, we need check 401 got while we tried using BasicAuth
			// then provide the consumer key and secret as query string parameters instead

			if(config.getBasicAuthConfig() == null) {
				// If BasicAuth is null then some issue with consumer key and secret. Lets throw same exception. 
				throw new UnauthorizedException(e.getMessage());
			}
			
			Map<String, String> map = new HashMap<>();
			map.put("consumer_key", config.getBasicAuthConfig().getConsumerKey());
			map.put("consumer_secret", config.getBasicAuthConfig().getConsumerSecret());
			
			StringBuilder builder = new StringBuilder(URL);
			builder.append(StringUtils.contains(URL, '?') ? "&" : "?");
			builder.append(getMaptoString(map));
			
			return restTemplate.exchange(builder.toString(), method, entity, returnType);
		}
	}
	
	private HttpEntity<Object> getRequestEntity(WooCommerceAuth authConfig, Object requestBody){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        
        if(authConfig.getBasicAuthConfig() != null) {
        	requestHeaders.set("Authorization", authConfig.getBasicAuthConfig().getBasicAuth());
        }
        
        if(requestBody != null ) {
        	return new HttpEntity<>(requestBody, requestHeaders); 	
        }else {
        	return new HttpEntity<>(requestHeaders);
        }
	}
	
	private String getV1URL(WooCommerceAuth authConfig, String uri, HttpMethod httpMethod, Map<String, String> params) {
		return authConfig.getBasicAuthConfig() != null ? getV1BasicAuthURL(authConfig.getBasicAuthConfig(), uri, params)
				: getV1OauthSecuredURL(authConfig.getoAuthConfig(), uri, httpMethod, params);
	}

	private String getV3URL(WooCommerceAuth authConfig, String uri, HttpMethod httpMethod, Map<String, String> params) {
		return authConfig.getBasicAuthConfig() != null ? getV3BasicAuthURL(authConfig.getBasicAuthConfig(), uri, params)
				: getV3OauthSecuredURL(authConfig.getoAuthConfig(), uri, httpMethod, params);
	}
	
	private String getV1BasicAuthURL(BasicAuthConfig auth, String uri, Map<String, String> params) {
	    return getBasicAuthURL(String.format(API_URL_FORMAT_V1, auth.getUrl(), uri), params);
	}
	
	private String getV3BasicAuthURL(BasicAuthConfig auth, String uri, Map<String, String> params) {
	    return getBasicAuthURL(String.format(API_URL_FORMAT_V3, auth.getUrl(), uri), params);		
	}
	
	private String getBasicAuthURL(String url, Map<String, String> params) {
		return params != null ? String.format(URL_SECURED_FORMAT, url, getMaptoString(params)) : url; 
	}

	private String getV1OauthSecuredURL(OAuthConfig oAuth, String uri, HttpMethod httpMethod, Map<String, String> params) {
	    String URL = String.format(API_URL_FORMAT_V1, oAuth.getUrl(), uri);
        return getOauthSecuredURL(oAuth, URL, httpMethod, params);		
	}
	
	private String getV3OauthSecuredURL(OAuthConfig oAuth, String uri, HttpMethod httpMethod, Map<String, String> params) {
	    String URL = String.format(API_URL_FORMAT_V3, oAuth.getUrl(), uri);
        return getOauthSecuredURL(oAuth, URL, httpMethod, params);		
	}
	
	private String getOauthSecuredURL(OAuthConfig oAuth, String url, HttpMethod httpMethod, Map<String, String> params) {
		Map<String, String> defaultParams = new HashMap<>();
		
		if(params != null) {
			defaultParams.putAll(params);
		}
		
        String signature = OAuthSignature.getAsQueryString(oAuth, url, httpMethod, defaultParams);
        return String.format(URL_SECURED_FORMAT, url, signature);		
	}
	
	private String getMaptoString(Map<String, String> params) {
		return OAuthSignature.mapToString(params, SpecialSymbol.EQUAL.getPlain(), SpecialSymbol.AMP.getPlain());
	}
	
	@SuppressWarnings("unchecked")
	private WooCommerceStoreAddress getWooCommerceStoreAddress(Object data) {
		WooCommerceStoreAddress address = new WooCommerceStoreAddress();
		
 		for(GeneralSetting setting : (List<GeneralSetting>) data) {
 			if(setting.getLabel() != null) {
 				switch(setting.getLabel()) {
 					case CITY:
						address.setCity(setting.getValue().toString());
						break;
					case ADDRESS_LINE_1:
						address.setAddressLine1(setting.getValue().toString());
						break;
					case ADDRESS_LINE_2:
						address.setAddressLine2(setting.getValue().toString());
						break;
					case COUNTRY_OR_STATE:
						String[] strings = StringUtils.split(setting.getValue().toString(), ":");
						address.setCountry(strings[0]);
						address.setState(strings[1]);
						break;
					case CURRENCY:
						address.setCurrency(setting.getValue().toString());
						break;
					case POSTCODE_OR_ZIP:
						address.setZipCode(setting.getValue().toString());
						break;
					default:
 				}	
 			}
		}
		
		return address;
	}
	
	@SuppressWarnings("unchecked")
	private WooCommerceStoreMeasurements getStoreMessurment(Object data) {
		
		WooCommerceStoreMeasurements messurements = new WooCommerceStoreMeasurements(); 
		
		for(ProductSetting setting : (List<ProductSetting>) data) {
			if(setting.getLabel() != null) {
				switch(setting.getLabel()) {
					case WEIGHT_UNIT:
						messurements.setWeigthUnit(setting.getValue().toString());
						break;
					case DIMENSION_UNIT:
						messurements.setDimensionsUnit(setting.getValue().toString());
						break;
					default:
				}
			}
		}
		
		return messurements;
	}
	
	public void replaceRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}

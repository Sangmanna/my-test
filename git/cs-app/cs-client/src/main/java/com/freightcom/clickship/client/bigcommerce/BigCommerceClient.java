package com.freightcom.clickship.client.bigcommerce;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freightcom.clickship.model.KeyValue;
import com.freightcom.clickship.model.exception.http.TooManyRequestsRestException;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceCreateShipment;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceEndpoint;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceOrder;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceOrderline;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceProduct;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceRestResponse;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceShipment;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceShippingAddress;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceShippingMethod;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceShippingQuote;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceShippingZone;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceStore;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceTokenRequest;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceTokenResponse;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceUpdateOrderReq;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceWebhook;

@Component
public class BigCommerceClient {
	
	private Logger logger = LogManager.getLogger(BigCommerceClient.class);
	
	private static final String PAGE = "page";
	private static final String LIMIT = "limit";
	private static final String INCLUDE = "include";
	private static final String VARIANTS_IMAGES = "variants, images";

	@Value("${bigcommerce.domain:api.bigcommerce.com}")
	private String domain;
	
	@Value("${bigcommerce.oauth.domain:login.bigcommerce.com}")
	private String oAauthDomain;
	
	@Value("${bigcommerce.api.version:1.0}")
	private String version;
	
	@Value("${bigcommerce.client.id:myuevqa1pmwo0il2ed7b2fqewd68wkw}")
	private String bigCommerceClientId;

	@Value("${bigcommerce.client.secret:2cc8d6043dc1c339e9031916d9677074210cc8cff71b7f36e4a536c7c6824a15}")
	private String bigCommerceClientSecret;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;

	public BigCommerceTokenResponse getAccessTokenForStore(BigCommerceTokenRequest req) {
		URI url = getUrl(BigCommerceEndpoint.AUTH_URL.getValue(), null, oAauthDomain);
		logger.info(toJson(req));
		
		return getResponse(url, HttpMethod.POST, getRequestEntity(null, req), BigCommerceTokenResponse.class).getBody();
	}
	
	public BigCommerceStore getStore(String token, String storeHash) {
		URI url = getUrl(BigCommerceEndpoint.STORE.getValue(), null, domain, storeHash);
		return getResponse(url, HttpMethod.GET, getRequestEntity(token, null), BigCommerceStore.class).getBody();
	}
	
	public BigCommerceProduct getProduct(String token, String storeHash, long productId) {
		List<KeyValue> params = Arrays.asList(new KeyValue(INCLUDE, VARIANTS_IMAGES));
		URI url = getUrl(BigCommerceEndpoint.GET_PRODUCT_BY_ID.getValue(), params, domain, storeHash, productId);
		
		return getResponse(url, HttpMethod.GET, getRequestEntity(token, null), product).getBody().getData();
	}
	
	public BigCommerceOrder getOrder(String token, String storeHash, long orderId) {
		URI url = getUrl(BigCommerceEndpoint.GET_ORDER_BY_ID.getValue(), null, domain, storeHash, orderId);
		return getResponse(url, HttpMethod.GET, getRequestEntity(token, null), order).getBody();
	}
	
	public List<BigCommerceProduct> getProducts(String token, String storeHash, int limit) {
		List<BigCommerceProduct> list = new ArrayList<>();
		List<KeyValue> params = Arrays.asList(new KeyValue(PAGE, 1), new KeyValue(LIMIT, limit), new KeyValue(INCLUDE, VARIANTS_IMAGES));
		URI url = getUrl(BigCommerceEndpoint.GET_PRODUCTS.getValue(), params, domain, storeHash);
		
		BigCommerceRestResponse<List<BigCommerceProduct>> response = getResponse(url, HttpMethod.GET, getRequestEntity(token, null), products).getBody();
		
		if(response != null) {
			list.addAll(response.getData());
			
			if(response.getMeta() != null && response.getMeta().getPagintaion().getTotalPages() > 1) {
				for(int i = 2; i<=response.getMeta().getPagintaion().getTotalPages(); i++) {
					params = Arrays.asList(new KeyValue(PAGE, i), new KeyValue(LIMIT, limit), new KeyValue(INCLUDE, VARIANTS_IMAGES));
					url = getUrl(BigCommerceEndpoint.GET_PRODUCTS.getValue(), params, domain, storeHash);
					list.addAll(getResponse(url, HttpMethod.GET, getRequestEntity(token, null), products).getBody().getData());
				}
			}
		}
		return list;
	}
	
	public List<BigCommerceOrder> getOrders(String token, String storeHash, int statusId, int limit) {
		int page = 1;
		List<BigCommerceOrder> list = new ArrayList<>();
		
		while(true) {
			List<KeyValue> params = Arrays.asList(new KeyValue(PAGE, page++), new KeyValue(LIMIT, limit), new KeyValue("status_id", statusId));
			URI url = getUrl(BigCommerceEndpoint.GET_ORDERS.getValue(), params, domain, storeHash);
			
			ResponseEntity<List<BigCommerceOrder>> responseEntity = getResponse(url, HttpMethod.GET, getRequestEntity(token, null), orders);
			
			if(responseEntity.getStatusCode() != HttpStatus.OK) {
				break;
			}	
			
			list.addAll(responseEntity.getBody());	
		}
		return list;
	}
	
	public BigCommerceOrder updateOrderStatus(String token, String storeHash, String orderId, int statusId) {
		String url = String.format(BigCommerceEndpoint.GET_ORDER_BY_ID.getValue(), domain, storeHash, orderId);
		return restTemplate.exchange(getUrl(url), HttpMethod.PUT, getRequestEntity(token, new BigCommerceUpdateOrderReq().setStatusId(statusId)), order).getBody();
	}
	
	public BigCommerceShipment addShipment(String token, String storeHash, String orderId, BigCommerceCreateShipment obj) {
		String url = String.format(BigCommerceEndpoint.GET_SHIPMENTS.getValue(), domain, storeHash, orderId);
		return restTemplate.exchange(getUrl(url), HttpMethod.POST, getRequestEntity(token, obj), shipment).getBody();
	}
	
	public void deleteShipment(String token, String storeHash, String orderId, String shipmentId) {
		String url = String.format(BigCommerceEndpoint.DELETE_SHIPMENT.getValue(), domain, storeHash, orderId, shipmentId);
		restTemplate.exchange(getUrl(url), HttpMethod.DELETE, getRequestEntity(token, null), String.class);
	}
	
	public List<BigCommerceShipment> getShipments(String token, String storeHash, String orderId) {
		String url = String.format(BigCommerceEndpoint.GET_SHIPMENTS.getValue(), domain, storeHash, orderId);
		return getResponse(getUrl(url), HttpMethod.GET, getRequestEntity(token, null), shipments).getBody();
	}
	
	public List<BigCommerceShippingAddress> getShippingAddress(String token, String storeHash, String orderId) {
		String url = String.format(BigCommerceEndpoint.GET_ORDERLINE.getValue(), domain, storeHash, orderId);
		return getShippingAddress(url, token);
	}
	
	public List<BigCommerceShippingAddress> getShippingAddress(String path, String token) {
		return getResponse(getUrl(path), HttpMethod.GET, getRequestEntity(token, null), address).getBody();
	}
	
	public List<BigCommerceOrderline> getOrderlines(String token, String storeHash, String orderId) {
		String url = String.format(BigCommerceEndpoint.GET_SHIPPINGADDRESS.getValue(), domain, storeHash, orderId);
		return getOrderlines(url, token);
	}
	
	public List<BigCommerceOrderline> getOrderlines(String path, String token) {
		return getResponse(getUrl(path), HttpMethod.GET, getRequestEntity(token, null), orderLines).getBody();
	}
	
	public BigCommerceShippingQuote getShippingQuote(String path, String token) {
		return getResponse(getUrl(path), HttpMethod.GET, getRequestEntity(token, null), BigCommerceShippingQuote.class).getBody();
	}
	
	public List<BigCommerceWebhook> getWebhooks(String token, String storeHash) {
		URI url = getUrl(BigCommerceEndpoint.GET_WEBHOOK.getValue(), null, domain, storeHash);
		return getResponse(url, HttpMethod.GET, getRequestEntity(token, null), webhooks).getBody().getData();
	}
	
	public void deleteWebhook(String token, String storeHash, String webhookId) {
		URI url = getUrl(BigCommerceEndpoint.GET_WEBHOOK.getValue() + "/" +  webhookId, null, domain, storeHash);
		restTemplate.exchange(url, HttpMethod.DELETE, getRequestEntity(token, null), String.class);
	}
	
	public void createWebhook(String token, String storeHash, BigCommerceWebhook webhook) {
		URI url = getUrl(BigCommerceEndpoint.GET_WEBHOOK.getValue(), null, domain, storeHash);
		restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(token, webhook), String.class);
	}
	
	public List<BigCommerceShippingZone> getZones(String token, String storeHash) {
		URI url = getUrl(BigCommerceEndpoint.ZONES.getValue(), null, domain, storeHash);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(token, null), zones).getBody();
	}
	
	public List<BigCommerceShippingMethod> getShippingMethods(String token, String storeHash, String zoneId) {
		URI url = getUrl(BigCommerceEndpoint.SHIPPING_METHOD.getValue(), null, domain, storeHash, zoneId);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(token, null), methods).getBody();
	}
	
	public BigCommerceShippingMethod createShippingMethod(String token, String storeHash, String zoneId, BigCommerceShippingMethod obj) {
		URI url = getUrl(BigCommerceEndpoint.SHIPPING_METHOD.getValue(), null, domain, storeHash, zoneId);
		return restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(token, obj), BigCommerceShippingMethod.class).getBody();
	}
	
	public void deleteShippingMethod(String token, String storeHash, String zoneId, String methodId) {
		URI url = getUrl(BigCommerceEndpoint.DELETE_SHIPPING_METHOD.getValue(), null, domain, storeHash, zoneId, methodId);
		restTemplate.exchange(url, HttpMethod.DELETE, getRequestEntity(token, null), String.class);
	}
	
	private <T> ResponseEntity<T> getResponse(final URI url, HttpMethod method, HttpEntity<Object> request, Class<T> clazz) {
		return restTemplate.exchange(url, method, request, clazz);
	}
	
	private <T> ResponseEntity<T> getResponse(final URI url, HttpMethod method, HttpEntity<Object> request, ParameterizedTypeReference<T> type) {
		int retryCount = 0;
		boolean retry = false;
		ResponseEntity<T> responseEntity = null;
		do {
			try {
				return restTemplate.exchange(url, method, request, type);
			} catch (TooManyRequestsRestException e) {
				retryCount++;
				retry = handleTooManyRequestsRestException(e, retryCount);
			}
		} while (retry && retryCount <= 11);
		
		return responseEntity;
	}
	
	private boolean handleTooManyRequestsRestException(TooManyRequestsRestException e, int retryCount) {
		boolean retry = false;
		HttpHeaders responseHeaders = e.getResponseHeaders();

		if(responseHeaders != null)  {
			List<String> list = responseHeaders.get("X-Rate-Limit-Time-Reset-Ms");
			if(CollectionUtils.isNotEmpty(list)) {
				long retryAfter = Long.parseLong(list.get(0));
				try {
					logger.info("Too Many Requests - BIGCOMMERCE rest api call sleep for {} seconds.", retryAfter / 1000);
					if (retryAfter > 0) {
						Thread.sleep(retryAfter);
					}
					retry = true;
				} catch (Exception ee) {
					logger.error("Exception while retrying attempt {} BIGCOMMERCE rest api call", retryCount ,ee);
				}
			}			
		}

		return retry;
	}

	private HttpEntity<Object> getRequestEntity(String accessToken, Object requestBody) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		if(accessToken != null) {
			headers.set("X-Auth-Token", accessToken);
		}

		if (requestBody != null) {
			return new HttpEntity<>(requestBody, headers);
		} else {
			return new HttpEntity<>(headers);
		}
	}
	
	private URI getUrl(String path) {
		return getUrl(path, new ArrayList<>());
	}
	
	private URI getUrl(String path, List<KeyValue> requestParams, Object... pair) {
		String urlPath = String.format(path, pair);
		return getUrl(urlPath, requestParams);
	}
	
	private URI getUrl(String path, List<KeyValue> requestParams) {
		try {
			URIBuilder uriBuilder = new URIBuilder(path);

			if (CollectionUtils.isNotEmpty(requestParams)) {
				requestParams.forEach(p -> uriBuilder.setParameter(p.getKey(), String.valueOf(p.getValue())));
			}

			return uriBuilder.build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(String.format("Error while constructing url:%s", path));
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

	private static final ParameterizedTypeReference<List<BigCommerceOrder>> orders 
							= new ParameterizedTypeReference<List<BigCommerceOrder>>() { };
							
	private static final ParameterizedTypeReference<BigCommerceOrder> order 
							= new ParameterizedTypeReference<BigCommerceOrder>() { };							
							
	private static final ParameterizedTypeReference<List<BigCommerceShipment>> shipments 
							= new ParameterizedTypeReference<List<BigCommerceShipment>>() { };
							
	private static final ParameterizedTypeReference<BigCommerceShipment> shipment 
							= new ParameterizedTypeReference<BigCommerceShipment>() { };

	private static final ParameterizedTypeReference<List<BigCommerceOrderline>> orderLines 
							= new ParameterizedTypeReference<List<BigCommerceOrderline>>() { };
							
	private static final ParameterizedTypeReference<List<BigCommerceShippingAddress>> address 
							= new ParameterizedTypeReference<List<BigCommerceShippingAddress>>() { };
							
	private static final ParameterizedTypeReference<BigCommerceRestResponse<BigCommerceProduct>> product 
							= new ParameterizedTypeReference<BigCommerceRestResponse<BigCommerceProduct>>() { };
							
	private static final ParameterizedTypeReference<BigCommerceRestResponse<List<BigCommerceProduct>>> products 
							= new ParameterizedTypeReference<BigCommerceRestResponse<List<BigCommerceProduct>>>() { };

	private static final ParameterizedTypeReference<BigCommerceRestResponse<List<BigCommerceWebhook>>> webhooks 
							= new ParameterizedTypeReference<BigCommerceRestResponse<List<BigCommerceWebhook>>>() { };

	private static final ParameterizedTypeReference<List<BigCommerceShippingZone>> zones 
							= new ParameterizedTypeReference<List<BigCommerceShippingZone>>() { };
							
	private static final ParameterizedTypeReference<List<BigCommerceShippingMethod>> methods 
							= new ParameterizedTypeReference<List<BigCommerceShippingMethod>>() { };
}

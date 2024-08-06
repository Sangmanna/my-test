package com.freightcom.clickship.client.wix;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freightcom.clickship.model.exception.http.ClickshipHttpRestException;
import com.freightcom.clickship.model.exception.http.TooManyRequestsRestException;
import com.freightcom.clickship.model.exception.http.UnauthorizedException;
import com.freightcom.clickship.model.marketplace.wix.WixAccessTokenResponse;
import com.freightcom.clickship.model.marketplace.wix.WixConstants;
import com.freightcom.clickship.model.marketplace.wix.WixOrderFulfillmentRequest;
import com.freightcom.clickship.model.marketplace.wix.WixOrderQuery;
import com.freightcom.clickship.model.marketplace.wix.WixPaging;
import com.freightcom.clickship.model.marketplace.wix.WixProduct;
import com.freightcom.clickship.model.marketplace.wix.WixProductQuery;
import com.freightcom.clickship.model.marketplace.wix.WixQueryParams;
import com.freightcom.clickship.model.marketplace.wix.WixResponse;
import com.freightcom.clickship.model.marketplace.wix.WixSiteProperties;
import com.freightcom.clickship.model.marketplace.wix.ecom.WixEcomCancelOrderReq;
import com.freightcom.clickship.model.marketplace.wix.ecom.WixEcomFulfillments;
import com.freightcom.clickship.model.marketplace.wix.ecom.WixEcomMetadata;
import com.freightcom.clickship.model.marketplace.wix.ecom.WixEcomOrder;
import com.freightcom.clickship.model.marketplace.wix.ecom.WixEcomResponse;
import com.freightcom.clickship.model.marketplace.wix.ecom.WixEcomSearch;
import com.freightcom.clickship.model.marketplace.wix.ecom.WixEcomSearch.CursorPaging;

@Component
public class WixRestClient {

	private Logger logger = LogManager.getLogger(WixRestClient.class);
	
	private static final String ORDER_ID = "orderId";
	private static final String PRODUCT_ID = "productId";
	private static final String FULFILLMENT_ID = "fulfillmentId";

	@Value("${wix.api.domain:www.wix.com}")
	private String wixDomain;
	
	@Value("${wix.api.domain:www.wixapis.com}")
	private String wixApiDomain;
	
    @Value("${wix.client_id:a2bf8d9d-2487-407c-a965-6cb64c688f84}")
    private String clientId;

    @Value("${wix.client_secret:2188e0e9-c38c-41e5-aa85-54f458a2b948}")
    private String clientSecret;
    
	@Autowired
	private ObjectMapper objectMapper;	 

	@Autowired
	private RestTemplate restTemplate;

	public WixAccessTokenResponse getAccessToken(String accessToken) {
		URI uri = getUrl(wixApiDomain, WixEndPoint.WIX_AUTH_EXCHANGE, null);
		return restTemplate.postForObject(uri, getRequest(accessToken, WixConstants.AUTHORIZATION_CODE, null), WixAccessTokenResponse.class);
	}
	
	public WixAccessTokenResponse refreshAccessToken(String refreshToken) {
		URI uri = getUrl(wixApiDomain, WixEndPoint.WIX_AUTH_EXCHANGE, null);
		return restTemplate.postForObject(uri, getRequest(refreshToken, WixConstants.REFRESH_TOKEN, null), WixAccessTokenResponse.class);
	}
	
	public void completeAuth(String accessToken) {
		URI uri = getUrl(wixDomain, WixEndPoint.WIX_COMPLETE_AUTH, null);
		restTemplate.postForObject(uri, getRequest(accessToken, null, null), Void.class);
	}
	
	public WixResponse getAppInstance(String accessToken) {
		URI uri = getUrl(wixApiDomain, WixEndPoint.GET_INSTANCE, null);
		return (WixResponse) getResponse(uri, HttpMethod.GET, getRequest(accessToken, null, null), WixResponse.class).getBody();
	}
	
	public WixSiteProperties importAddress(String accessToken) {
		URI uri = getUrl(wixDomain, WixEndPoint.GET_ADDRESS, null);
		WixResponse res = (WixResponse) getResponse(uri, HttpMethod.GET, getRequest(accessToken, null, null),
				WixResponse.class).getBody();
		return res.getProperties();
	}

	public WixResponse importProducts(String accessToken, Map<String, Object> filters, Integer offset, Integer limit) {
		WixProductQuery query = new WixProductQuery();
		query.setQuery(getWixQueryParams(filters, offset, limit));
		
		URI uri = getUrl(wixApiDomain, WixEndPoint.GET_PRODUCTS, null);
		return (WixResponse) getResponse(uri, HttpMethod.POST, getRequest(accessToken, null, query), WixResponse.class)
				.getBody();
	}

	public WixResponse importOrders(String accessToken, Map<String, Object> filters, Integer offset, Integer limit) {
		WixOrderQuery query = new WixOrderQuery();
		query.setQuery(getWixQueryParams(filters, offset, limit));
		
		URI uri = getUrl(wixApiDomain, WixEndPoint.GET_ORDERS, null);
		return (WixResponse) getResponse(uri, HttpMethod.POST, getRequest(accessToken, null, query), WixResponse.class)
				.getBody();
	}

	public List<WixEcomOrder> getAllOrders(String token, WixEcomSearch ecomSearch, List<WixEcomOrder> allOrders) {
		while (true) {
			WixEcomResponse wixEcomResponse = importEcomOrders(token, ecomSearch);

			if (wixEcomResponse != null && wixEcomResponse.getMetadata() != null) {
				setWixEcomMetaData(ecomSearch, wixEcomResponse.getMetadata());
				allOrders.addAll(wixEcomResponse.getOrders());

				if (!wixEcomResponse.getMetadata().getHasNext()) {
					break;
				}

				if (CollectionUtils.isEmpty(wixEcomResponse.getOrders())) {
					break;
				}
			}
		}
		return allOrders;
	}
	
	public WixEcomResponse importEcomOrders(String accessToken, WixEcomSearch search) {
		URI uri = getUrl(wixApiDomain, WixEndPoint.SEARCH_ECOM_ORDERS, null);
		WixEcomResponse res = (WixEcomResponse) getResponse(uri, HttpMethod.POST, getRequest(accessToken, null, search),
				WixEcomResponse.class).getBody();
		return res;
	}

	public WixProduct getProduct(String productId, String accessToken) {
		Map<String, String> params = new HashMap<>();
		params.put(PRODUCT_ID, productId);

		URI uri = getUrl(wixApiDomain, WixEndPoint.GET_PRODUCT, params);
		WixResponse res = (WixResponse) getResponse(uri, HttpMethod.GET, getRequest(accessToken, null, null),
				WixResponse.class).getBody();
		return res.getProduct();
	}
	
//	public WixOrder getOrder(String orderId, String accessToken) {
//		Map<String, String> params = new HashMap<>();
//		params.put(ORDER_ID, orderId);
//
//		URI uri = getUrl(wixApiDomain, WixEndPoint.GET_ORDER, params);
//		return getResponse(uri, HttpMethod.GET, getRequest(accessToken, null, null), WixResponse.class).getBody().getOrder();
//	}
	
	public WixEcomOrder getEcomOrderById(String orderId, String accessToken) {
		Map<String, String> params = new HashMap<>();
		params.put(ORDER_ID, orderId);

		URI uri = getUrl(wixApiDomain, WixEndPoint.GET_ECOM_ORDER_BY_ID, params);
		WixEcomResponse response = (WixEcomResponse) getResponse(uri, HttpMethod.GET,
				getRequest(accessToken, null, null), WixEcomResponse.class).getBody();

		return response.getOrder();
	}
	
//	public WixResponse getVariants(String productId, String accessToken, Map<String, Object> filters, Integer offset, Integer limit) {
//		WixOrderQuery query = new WixOrderQuery();
//		query.setQuery(getWixQueryParams(filters, offset, limit));
//		
//		Map<String, String> params = new HashMap<>();
//		params.put(PRODUCT_ID, productId);
//		
//		URI uri = getUrl(wixApiDomain, WixEndPoint.GET_VARIANTS, params);
//		return restTemplate.postForObject(uri, getRequest(accessToken, null, query), WixResponse.class);
//	}
	
	public String createFulfillment(String orderId, WixOrderFulfillmentRequest body, String accessToken) {
		Map<String, String> params = new HashMap<>();
		params.put(ORDER_ID, orderId);

		URI uri = getUrl(wixApiDomain, WixEndPoint.CREATE_FULFILLMENT, params);
		WixResponse response = (WixResponse) getResponse(uri, HttpMethod.POST, getRequest(accessToken, null, body),
				WixResponse.class).getBody();
		return response.getId();
	}
	
	public String createEcomFulfillment(String orderId, WixEcomFulfillments req, String accessToken) {
		Map<String, String> params = new HashMap<>();
		params.put(ORDER_ID, orderId);

		URI uri = getUrl(wixApiDomain, WixEndPoint.CREATE_ECOM_FULFILLMENT, params);
		WixEcomResponse response = (WixEcomResponse) getResponse(uri, HttpMethod.POST,
				getRequest(accessToken, null, req), WixEcomResponse.class).getBody();
		return response.getFulfillmentId();
	}

//	public WixOrder cancelFulfillment(String orderId, String fulfillmentId, String accessToken) {
//		Map<String, String> params = new HashMap<>();
//		params.put(ORDER_ID, orderId);
//		params.put(FULFILLMENT_ID, fulfillmentId);
//
//		URI uri = getUrl(wixApiDomain, WixEndPoint.CANCEL_FULFILLMENT, params);
//		return getResponse(uri, HttpMethod.DELETE, getRequest(accessToken, null, null), WixResponse.class).getBody().getOrder();
//	}

	public void cancelEcomFulfillment(String orderId, String fulfillmentId, String token) {
		Map<String, String> params = new HashMap<>();
		params.put(ORDER_ID, orderId);
		params.put(FULFILLMENT_ID, fulfillmentId);

		URI uri = getUrl(wixApiDomain, WixEndPoint.CANCEL_ECOM_FULFILLMENT, params);
		getResponse(uri, HttpMethod.DELETE, getRequest(token, null, null), WixEcomResponse.class);
	}

	public void cancelOrder(String orderId, WixEcomCancelOrderReq req, String token) {
		Map<String, String> params = new HashMap<>();
		params.put(ORDER_ID, orderId);

		URI uri = getUrl(wixApiDomain, WixEndPoint.CANCEL_ECOM_ORDERS, params);
		getResponse(uri, HttpMethod.POST, getRequest(token, null, req), WixEcomResponse.class);
	}

	private void setWixEcomMetaData(WixEcomSearch ecomSearch, WixEcomMetadata metadata) {
		if (metadata.getCursors() != null) {
			CursorPaging cursorPaging = ecomSearch.getSearch().getCursorPaging();
			cursorPaging.setCursor(metadata.getCursors().getNext());
			ecomSearch.getSearch().setCursorPaging(cursorPaging);
		}
	}

	private URI getUrl(String serverUrl, WixEndPoint wixEndPoint, Map<String, String> params) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(WixConstants.HTTPS_PROTOCALL + serverUrl + wixEndPoint.getValue());
		
		if(params == null) {
			return builder.build().toUri();
		} else {
			return builder.buildAndExpand(params).toUri();
		}
	}

	private ResponseEntity<?> getResponse(final URI uri, final HttpMethod method, final HttpEntity<?> request,
			Class<?> clazz) {
		int retryCount = 0;
		boolean retry = false;
		ResponseEntity<?> response = null;
		do {
			try {
				response = restTemplate.exchange(uri, method, request, clazz);
				break;
			} catch (TooManyRequestsRestException e) {
				logger.error("Too Many Requests - Wix rest api call sleep for 1 minute.");
				
				if (e.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS) {
					retryCount++;
					try {
						TimeUnit.MINUTES.sleep(1);
						retry = true;
					} catch (Exception ee) {
						logger.error("Exception while thread sleep attempt {} Wix rest api call", retryCount, ee);
					}
				}
			} catch (UnauthorizedException e) {
				throw e;
			} catch (ClickshipHttpRestException e) {
				throw e;
			}
		} while (retry && retryCount <= 11);
		
		if(response == null) {
			throw new RuntimeException("Unable to get response from WIX");
		}

		return response;
	}

    private HttpEntity<Object> getRequest(String accessToken, String grantType, Object obj) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        
        if (StringUtils.isNotBlank(grantType)) {
        	Map<String, Object> parms = getAuthParms(accessToken, grantType);
            return new HttpEntity<>(parms, requestHeaders);
        } else {
        	requestHeaders.set(WixConstants.AUTHORIZATION, accessToken);
            return obj != null ? new HttpEntity<>(obj, requestHeaders) : new HttpEntity<>(requestHeaders);
        }
    }
    
	private Map<String, Object> getAuthParms(String accessToken, String grantType) {
		Map<String, Object> map = new HashMap<>();
		map.put(WixConstants.CLIENT_ID, clientId);
		map.put(WixConstants.CLIENT_SECRET, clientSecret);
		
		map.put(WixConstants.GRANT_TYPE, grantType);

		if(StringUtils.equals(WixConstants.AUTHORIZATION_CODE, grantType)) {
			map.put(WixConstants.CODE, accessToken);
		}
		
		if(StringUtils.equals(WixConstants.REFRESH_TOKEN, grantType)) {
			map.put(WixConstants.REFRESH_TOKEN, accessToken);
		} 

		return map;
	}
	
	private WixQueryParams getWixQueryParams(Map<String, Object> filters, Integer offset, Integer limit) {
		Map<String, Object> map = new HashMap<>();

		if (filters != null) {
			map.putAll(filters);
		}

		WixQueryParams params = new WixQueryParams();
		params.setSort("[{\"numericId\": \"asc\"}]");
		params.setFilter(toJson(map));

		if (offset != null || limit != null) {
			WixPaging paging = new WixPaging();

			if (offset != null) {
				paging.setOffset(offset);
			}

			if (limit != null) {
				paging.setLimit(limit);
			}

			params.setPaging(paging);
		}
		
		return params;
	}
	
	private <T> String toJson(T object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			String msg = String.format("Exception while converting string to Entity. Error: %s", e.getMessage());
			throw new RuntimeException(msg, e);
		}
	}
	
}

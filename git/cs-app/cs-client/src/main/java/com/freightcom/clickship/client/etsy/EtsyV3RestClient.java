package com.freightcom.clickship.client.etsy;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.freightcom.clickship.client.etsy.auth.EtsyAuth;
import com.freightcom.clickship.model.KeyValue;
import com.freightcom.clickship.model.exception.http.ClickshipHttpRestException;
import com.freightcom.clickship.model.exception.http.TooManyRequestsRestException;
import com.freightcom.clickship.model.exception.marketplace.MarketplaceDoesNotExistException;
import com.freightcom.clickship.model.marketplace.etsy.EtsyShop;
import com.freightcom.clickship.model.marketplace.etsy.Response;
import com.freightcom.clickship.model.marketplace.etsy.SubmitTracking;
import com.freightcom.clickship.model.marketplace.etsy.v3.EtsyEndpointV3;
import com.freightcom.clickship.model.marketplace.etsy.v3.EtsyListing;
import com.freightcom.clickship.model.marketplace.etsy.v3.EtsyListingState;
import com.freightcom.clickship.model.marketplace.etsy.v3.EtsyReceipt;
import com.freightcom.clickship.model.marketplace.etsy.v3.EtsyToken;
import com.freightcom.clickship.model.marketplace.etsy.v3.EtsyUserAddress;

@Component
public class EtsyV3RestClient {
	
	private final Logger logger = LogManager.getLogger(EtsyV3RestClient.class);

	private static final String STATE = "state";
	private static final String LIMIT = "limit";
	private static final String OFFSET = "offset";
	private static final String INCLUDES = "includes";
	private static final String CLIENT_ID = "client_id";
	private static final String GRANT_TYPE = "grant_type";
	private static final String WAS_SHIPPED = "was_shipped";
	private static final String LEGACY_TOKEN = "legacy_token";
	private static final String REFRESH_TOKEN = "refresh_token";
	private static final String AUTH_CODE = "authorization_code";
	private static final String TOKEN_EXCHANGE = "token_exchange";
	private static final String IMAGES_INVENTORY = "Images,Inventory";
	private static final String MIN_LAST_MODIFIED = "min_last_modified";
	private static final String MAX_LAST_MODIFIED = "max_last_modified";
	private static final String INVALID_STORE_NAME = "We are unable to find the etsy store name with '%s'. Please provide valid name.";

	@Value("${etsy.client_id}")
	private String clientId;

	@Autowired
	private RestTemplate restTemplate;

	public EtsyAuth refreshToken(String refreshToken) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add(CLIENT_ID, clientId);
		map.add(GRANT_TYPE, REFRESH_TOKEN);
		map.add(REFRESH_TOKEN, refreshToken);

		return postURLEncoded(EtsyEndpointV3.OAUTH_TOKEN.getValue(), map, EtsyAuth.class);
	}
	
	public EtsyShop getShopDetails(String storeName) {
		try {
			List<KeyValue> params = new ArrayList<>();
			params.add(new KeyValue("shop_name", storeName));
			
			Response<List<EtsyShop>> response = get(null, EtsyEndpointV3.GET_SHOP_DETAILS.getValue(), params, shopType());
			
			if(response == null) {
				throw new MarketplaceDoesNotExistException(String.format(INVALID_STORE_NAME, storeName));
			}
			
			return getEstyShopFromResponse(response, storeName);
		} catch (ClickshipHttpRestException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new MarketplaceDoesNotExistException(String.format(INVALID_STORE_NAME, storeName));
			}

			throw e;
		}
	}
	
	public EtsyToken getAuthToken(String accessToken, String privateKey, String callBack) {
		EtsyToken etsyToken = new EtsyToken();
		etsyToken.setClientId(clientId).setGrantType(AUTH_CODE).setCode(accessToken).setCodeVerifier(privateKey).setRedirectUrl(callBack);

		return restTemplate.exchange(EtsyEndpointV3.OAUTH_TOKEN.getValue(), HttpMethod.POST, getRequestEntity(null, etsyToken), EtsyToken.class).getBody();
	}

	public EtsyAuth migrateToOauth2(String legacyToken) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add(CLIENT_ID, clientId);
		map.add(LEGACY_TOKEN, legacyToken);
		map.add(GRANT_TYPE, TOKEN_EXCHANGE);

		return postURLEncoded(EtsyEndpointV3.OAUTH_TOKEN.getValue(), map, EtsyAuth.class);
	}
	
	public List<EtsyUserAddress> getUserAddresses(String token) {
		return getPaginationResponse(token, EtsyEndpointV3.USER_ADDRESS.getValue(), null, addressType());
	}
	
	public List<EtsyListing> getListings(String token, String shopId, EtsyListingState state) {
		List<KeyValue> params = new ArrayList<>();
		params.add(new KeyValue(STATE, state.getState()));
		params.add(new KeyValue(INCLUDES, IMAGES_INVENTORY));
		
		return getPaginationResponse(token, String.format(EtsyEndpointV3.GET_LISTINGS.getValue(), shopId), params, listings());
	}
	
	public EtsyListing getListingById(String token, String listingId, EtsyListingState state) {
		String url = String.format(EtsyEndpointV3.GET_LISTING_BY_ID.getValue(), listingId);
		
		List<KeyValue> params = new ArrayList<>();
		params.add(new KeyValue(STATE, state.getState()));
		params.add(new KeyValue(INCLUDES, IMAGES_INVENTORY));
		
		return get(token, url, params, listing());
	}
	
	public EtsyReceipt submitTracking(String accessToken, String shopId, String receiptId,
			SubmitTracking submitTracking) {
		String url = String.format(EtsyEndpointV3.TRACKING.getValue(), shopId, receiptId);
		return post(accessToken, url, null, submitTracking, etsyReceiptType());
	}
	
	public List<EtsyReceipt> getReceipts(String token, String shopId) {
		List<KeyValue> params = new ArrayList<>();
		params.add(new KeyValue(WAS_SHIPPED, "false"));
		
		return getPaginationResponse(token, String.format(EtsyEndpointV3.GET_RECEIPTS.getValue(), shopId), params, receipts());
	}
	
	public EtsyReceipt getReceiptById(String token, String shopId, String receiptId) {
		String url = String.format(EtsyEndpointV3.GET_RECEIPT_BY_ID.getValue(), shopId, receiptId);
		return get(token, url, null, receipt());
	}
	
	public List<EtsyReceipt> getReceiptUpdates(String token, String shopId, long fromDate, long toDate) {
		List<KeyValue> params = new ArrayList<>();
		params.add(new KeyValue(MAX_LAST_MODIFIED, "" + toDate));
		params.add(new KeyValue(MIN_LAST_MODIFIED, "" + fromDate));
		
		return getPaginationResponse(token, String.format(EtsyEndpointV3.GET_RECEIPTS.getValue(), shopId), params, receipts());	
	}

	private <T> List<T> getPaginationResponse(String token, String url, List<KeyValue> params, ParameterizedTypeReference<Response<List<T>>> responseType) {
		int count = 0;
		Integer offset = 0;
		List<T> allLists = new ArrayList<>();

		do {
			List<KeyValue> list = new ArrayList<>();
			list.addAll(Arrays.asList(new KeyValue(LIMIT, "" + 100), new KeyValue(OFFSET, "" + offset++)));	
			
			if (params != null) {
				list.addAll(params);	
			}
			
			Response<List<T>> response = getResponse(token, url, list, responseType);

			if (response == null) {
				throw new RuntimeException("Empty response received");
			}
			
			if(CollectionUtils.isEmpty(response.getResults())) {
				break;
			}

			count = response.getCount();
			allLists.addAll(response.getResults());
		} while (allLists.size() < count);

		return allLists;
	}
	
	private <T> Response<T> getResponse(String token, String uri, List<KeyValue> params, ParameterizedTypeReference<Response<T>> type) {
		return callEtsy(getURL(uri, params), HttpMethod.GET, getRequestEntity(token, null), type).getBody();
	}

	private <T> T get(String token, String uri, List<KeyValue> params, ParameterizedTypeReference<T> type) {
		return callEtsy(getURL(uri, params), HttpMethod.GET, getRequestEntity(token, null), type).getBody();
	}

	private <T> T post(String token, String uri, List<KeyValue> params, Object req, ParameterizedTypeReference<T> type) {
		return callEtsy(getURL(uri, params), HttpMethod.POST, getRequestEntity(token, req), type).getBody();
	}
	
	private <T> T postURLEncoded(String url, Object requestBody, Class<T> clazz) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(requestBody, headers), clazz).getBody();
	}

	private <T> ResponseEntity<T> callEtsy(URI url, HttpMethod httpMethod, HttpEntity<Object> entity, ParameterizedTypeReference<T> responseType) {
		int retryCount = 0;

		do {
			try {
				return restTemplate.exchange(url, httpMethod, entity, responseType);
			} catch (TooManyRequestsRestException e) {
				logger.info("{} - Etsy Too Many Requests error. Sleep for 1000 seconds.", retryCount++);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					logger.error("Exception while retrying attempt {} for ETSY", retryCount, ie);
					throw e;
				}
			}
		} while (retryCount <= 11);

		throw new RuntimeException("ETSY rest api exception - " + url.toString());
	}

	private HttpEntity<Object> getRequestEntity(String accessToken, Object requestBody) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		if (StringUtils.isNotBlank(accessToken)) {
			requestHeaders.set("x-api-key", clientId);
			requestHeaders.set("Authorization", "Bearer " + accessToken);
		}else {
			requestHeaders.set("x-api-key", clientId);
		}

		if (requestBody != null) {
			return new HttpEntity<>(requestBody, requestHeaders);
		} else {
			return new HttpEntity<>(requestHeaders);
		}
	}

	private URI getURL(String path, List<KeyValue> requestParams) {
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
	
	private EtsyShop getEstyShopFromResponse(Response<List<EtsyShop>> response, String storeName) {
		List<EtsyShop> shops = response.getResults();
		if (CollectionUtils.isEmpty(shops)) {
			throw new MarketplaceDoesNotExistException(String.format(INVALID_STORE_NAME, storeName));
		}
		Optional<EtsyShop> shop = shops.stream().filter(i -> i.getShopName().equalsIgnoreCase(storeName.trim()))
				.findAny();
		if (!shop.isPresent()) {
			throw new MarketplaceDoesNotExistException(String.format(INVALID_STORE_NAME, storeName));
		}
		return shop.get();
	}

	private ParameterizedTypeReference<Response<List<EtsyUserAddress>>> addressType() {
		return new ParameterizedTypeReference<Response<List<EtsyUserAddress>>>() {
		};
	}
	
	private ParameterizedTypeReference<Response<List<EtsyListing>>> listings() {
		return new ParameterizedTypeReference<Response<List<EtsyListing>>>() {
		};
	}
	
	private ParameterizedTypeReference<Response<List<EtsyReceipt>>> receipts() {
		return new ParameterizedTypeReference<Response<List<EtsyReceipt>>>() {
		};
	}
	
	private ParameterizedTypeReference<EtsyListing> listing() {
		return new ParameterizedTypeReference<EtsyListing>() {
		};
	}
	
	private ParameterizedTypeReference<EtsyReceipt> receipt() {
		return new ParameterizedTypeReference<EtsyReceipt>() {
		};
	}
	
    private ParameterizedTypeReference<Response<List<EtsyShop>>> shopType() {
    	return new ParameterizedTypeReference<Response<List<EtsyShop>>>() {};
    }

    private ParameterizedTypeReference<EtsyReceipt> etsyReceiptType() {
		return new ParameterizedTypeReference<EtsyReceipt>() {
		};
	}
}

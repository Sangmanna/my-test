package com.freightcom.clickship.client.etsy;

import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.freightcom.clickship.client.auth.OAuthConfig;
import com.freightcom.clickship.client.auth.OAuthSignature;
import com.freightcom.clickship.client.etsy.auth.EtsyAuth;
import com.freightcom.clickship.model.exception.http.ClickshipHttpRestException;
import com.freightcom.clickship.model.exception.http.UnauthorizedException;
import com.freightcom.clickship.model.exception.marketplace.MarketplaceDoesNotExistException;
import com.freightcom.clickship.model.marketplace.etsy.EtsyEndpoint;
import com.freightcom.clickship.model.marketplace.etsy.EtsyOrder;
import com.freightcom.clickship.model.marketplace.etsy.EtsyOrderDetail;
import com.freightcom.clickship.model.marketplace.etsy.EtsyShop;
import com.freightcom.clickship.model.marketplace.etsy.Receipt;
import com.freightcom.clickship.model.marketplace.etsy.Response;
import com.freightcom.clickship.model.marketplace.etsy.SubmitTracking;

@Component
public class EtsyRestClient {

	private final Logger logger = LogManager.getLogger(EtsyRestClient.class);

	private static final String PAGE = "page";
	private static final String LIMIT = "limit";
	public static final String SEND_BCC = "send_bcc";
	public static final String WAS_SHIPPED = "was_shipped";
	public static final String CARRIER_NAME = "carrier_name";
	public static final String TRACKING_CODE = "tracking_code";

	private static final String URL_SECURED_FORMAT = "%s?%s";
	private static final String INVALID_STORE_NAME = "We are unable to find the etsy store name with '%s'. Please provide valid name.";

	@Autowired
	private RestTemplate restTemplate;

	public EtsyAuth getLoginUrl(EtsyAuth etsyAuth, String scope, String callBack) throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("scope", scope);
		params.put("oauth_callback", URLEncoder.encode(callBack, StandardCharsets.UTF_8.toString()));

		String response = get(etsyAuth, EtsyEndpoint.REQUEST_TOKEN.getValue(), params, stringType());
		return getLoginUrl(response);
	}

	public EtsyAuth getPermanantTokenByVerifier(EtsyAuth etsyAuth, String verifier) {
		Map<String, String> params = new HashMap<>();
		params.put("oauth_verifier", verifier);

		String response = get(etsyAuth, EtsyEndpoint.ACCESS_TOKEN.getValue(), params, stringType());
		return getEtsyToken(String.format(URL_SECURED_FORMAT, EtsyEndpoint.ACCESS_TOKEN.getValue(), response));
	}

	public EtsyShop getShopDetails(String consumerKey, String storeName) {
		String url = String.format(EtsyEndpoint.GET_SHOP_DETAILS.getValue(), storeName, consumerKey);
		try {
			Response<List<EtsyShop>> response = restTemplate
					.exchange(url, HttpMethod.GET, getRequestEntity(null), shopType()).getBody();
			return getEstyShopFromResponse(response, storeName);
		} catch (ClickshipHttpRestException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new MarketplaceDoesNotExistException(String.format(INVALID_STORE_NAME, storeName));
			}

			throw e;
		}
	}

/*	public Map<Long, EtsyCountry> findAllCountries(String consumerKey) {
		String url = String.format(EtsyEndpoint.COUNTRIES.getValue(), consumerKey);
		Response<List<EtsyCountry>> response = restTemplate
				.exchange(url, HttpMethod.GET, getRequestEntity(null), countryType()).getBody();
		return response.getResults().stream().collect(Collectors.toMap(e -> e.getCountryId(), e -> e));
	}

	public List<UserAddress> findAllAddressByUserId(EtsyAuth etsyAuth, String userId, int limit) {
		// ETSY have strict rate limiting for API calls. To handle this make only one
		// call and pull
		// 100 addresses with max size limit. Most of the cases a customer will not have
		// more than 100 addresses
		// Pagination can be implement based on feed back from customers - 2020-09-18
		Map<String, String> params = new HashMap<>();
		params.put(LIMIT, "" + limit);

		return getResponse(etsyAuth, String.format(EtsyEndpoint.GET_USER_ADDRESSES.getValue(), userId), params, addressType()).getResults();
	}

	public List<Listing> getProductById(EtsyAuth etsyAuth, String productId) {
		return getResponse(etsyAuth, String.format(EtsyEndpoint.GET_PRODUCT.getValue(), productId), null, productType())
				.getResults();
	}

	public List<Listing> getAllProducts(EtsyAuth etsyAuth, String shopId, String status, int limit) {
		String url = String.format(EtsyEndpoint.GET_PRODUCTS.getValue(), shopId, status);

		Map<String, String> params = new HashMap<>();
		params.put(LIMIT, "" + limit);

		return getPaginationResponse(etsyAuth, url, params, productType());
	}

	public List<ListingImage> getAllProductImages(EtsyAuth etsyAuth, String productId, int limit) {
		String url = String.format(EtsyEndpoint.GET_PRODUCT_IMAGES.getValue(), productId);

		Map<String, String> params = new HashMap<>();
		params.put(LIMIT, "" + limit);

		return getPaginationResponse(etsyAuth, url, params, producImageType());
	}

	public ListingInventory getAllProductVariants(EtsyAuth etsyAuth, String productId) {
		String url = String.format(EtsyEndpoint.GET_PRODUCT_VARIANTS.getValue(), productId);
		return getResponse(etsyAuth, url, null, productVarinatType()).getResults();
	} */

	public EtsyOrder getOrderById(EtsyAuth etsyAuth, String orderId) {
		String url = String.format(EtsyEndpoint.GET_ORDER.getValue(), orderId);

		List<EtsyOrder> results = getResponse(etsyAuth, url, null, orderType()).getResults();
		return CollectionUtils.isNotEmpty(results) ? results.get(0) : null;
	}

	public List<EtsyOrder> getAllOrders(EtsyAuth etsyAuth, String shopId, Integer limit, Map<String, String> params) {
		params.put(LIMIT, "" + limit);
		return getPaginationResponse(etsyAuth, String.format(EtsyEndpoint.GET_ORDERS.getValue(), shopId), params,
				orderType());
	}

	public List<EtsyOrderDetail> findOrderLinesByOrderId(EtsyAuth etsyAuth, String orderId, Integer limit) {
		String url = String.format(EtsyEndpoint.GET_ORDERLINES.getValue(), orderId);

		Map<String, String> params = new HashMap<>();
		params.put(LIMIT, "" + limit);

		return getPaginationResponse(etsyAuth, url, params, orderLineType());
	}

	public List<Receipt> submitTracking(EtsyAuth etsyAuth, String shopId, String receiptId,
			SubmitTracking submitTracking) {
		String url = String.format(EtsyEndpoint.TRAKCING.getValue(), shopId, receiptId);

		Map<String, String> params = new HashMap<>();
		params.put(SEND_BCC, "" + submitTracking.isSendBcc());
		params.put(CARRIER_NAME, submitTracking.getCarrierName());
		params.put(TRACKING_CODE, submitTracking.getTrackingCode());

		return post(etsyAuth, url, params, null, receiptType()).getResults();
	}

	/*
	 * public List<Receipt> fulfilledOrder(EtsyAuth etsyAuth, String orderId) {
	 * String url = String.format(EtsyEndpoint.GET_ORDER.getValue(), orderId);
	 * 
	 * Map<String, String> params = new HashMap<>(); params.put(WAS_SHIPPED,
	 * "true");
	 * 
	 * return post(etsyAuth, url, params, null, receiptType()).getResults(); }
	 */
	
	private <T> List<T> getPaginationResponse(EtsyAuth config, String url, Map<String, String> params, ParameterizedTypeReference<Response<List<T>>> responseType) {
		Integer page = 1;
		List<T> allLists = new ArrayList<>();

		do {
			params.put(PAGE, "" + page);
			Response<List<T>> response = getResponse(config, url, params, responseType);

			allLists.addAll(response.getResults());
			page = response.getPagination().getNextPage();
		} while (page != null);

		return allLists;
	}
	
	private <T> Response<T> getResponse(EtsyAuth config, String uri, Map<String, String> params, ParameterizedTypeReference<Response<T>> responseType) {
		return callEtsy(getURL(config, uri, HttpMethod.GET, params), HttpMethod.GET, getRequestEntity(null), responseType).getBody();
	}

	private String get(EtsyAuth config, String uri, Map<String, String> params, ParameterizedTypeReference<String> responseType) {
		return callEtsy(getURL(config, uri, HttpMethod.GET, params), HttpMethod.GET, getRequestEntity(null), responseType).getBody();
	}

	private <T> Response<T> post(EtsyAuth config, String uri, Map<String, String> params, Object requestBody, ParameterizedTypeReference<Response<T>> responseType) {
		return callEtsy(getURL(config, uri, HttpMethod.POST, params), HttpMethod.POST, getRequestEntity(requestBody), responseType).getBody();
	}

	private <T> ResponseEntity<T> callEtsy(String url, HttpMethod httpMethod, HttpEntity<Object> entity,
			ParameterizedTypeReference<T> responseType) {
		try {
			return restTemplate.exchange(URI.create(url), httpMethod, entity, responseType);
		} catch (UnauthorizedException e) {
			throw e;
		} catch (HttpClientErrorException e) {
			HttpHeaders httpHeaders = e.getResponseHeaders();
			String errorDetail = (httpHeaders.get("X-Error-Detail") != null)
					? String.join(", ", httpHeaders.get("X-Error-Detail"))
					: null;
			logger.error("Error from etsy server: {}", errorDetail, e);

			if (e.getStatusCode() == HttpStatus.FORBIDDEN || e.getStatusCode() == HttpStatus.BAD_REQUEST) {
				try {
					Thread.sleep(500);
					return restTemplate.exchange(url, httpMethod, entity, responseType);
				} catch (Exception exception) {
					logger.error("Etsy retry failed ", exception);
					throw e;
				}
			}

			throw e;
		}
	}

	private String getURL(EtsyAuth authConfig, String uri, HttpMethod httpMethod, Map<String, String> params) {
		return getauthSecuredURL(authConfig, uri, httpMethod, params);
	}

	private String getauthSecuredURL(EtsyAuth oAuth, String uri, HttpMethod httpMethod, Map<String, String> params) {
		Map<String, String> defaultParams = new HashMap<>();
		OAuthConfig oAuthConfig = null;

		if (oAuth.getAccessToken() == null || oAuth.getTokenSecret() == null) {
			oAuthConfig = new OAuthConfig(uri, oAuth.getConsumerKey(), oAuth.getConsumerSecret());
		} else {
			oAuthConfig = new OAuthConfig(uri, oAuth.getConsumerKey(), oAuth.getConsumerSecret(), oAuth.getAccessToken(), oAuth.getTokenSecret());
		}

		if (params != null) {
			defaultParams.putAll(params);
		}

		String signature = OAuthSignature.getAsQueryString(oAuthConfig, uri, httpMethod, defaultParams);
		return String.format(URL_SECURED_FORMAT, uri, signature);
	}

	private HttpEntity<Object> getRequestEntity(Object requestBody) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		if (requestBody != null) {
			return new HttpEntity<>(requestBody, requestHeaders);
		} else {
			return new HttpEntity<>(requestHeaders);
		}
	}

	private EtsyAuth getLoginUrl(String response) throws Exception {
		String[] split = URLDecoder.decode(response, "UTF-8").split("login_url=");

		EtsyAuth etsyAuth = getEtsyToken(split[1]);
		etsyAuth.setAuthUrl(split[1]);

		return etsyAuth;
	}

	private EtsyAuth getEtsyToken(String url) {
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url).build(true);
		MultiValueMap<String, String> queryParams = uriComponents.getQueryParams();

		EtsyAuth etsyAuth = new EtsyAuth();

		etsyAuth.setAccessToken(queryParams.get("oauth_token").get(0));
		etsyAuth.setTokenSecret(queryParams.get("oauth_token_secret").get(0));

		return etsyAuth;
	}

	private EtsyShop getEstyShopFromResponse(Response<List<EtsyShop>> response, String storeName) {
		List<EtsyShop> shops = response.getResults();
		if (CollectionUtils.isEmpty(shops)) {
			throw new MarketplaceDoesNotExistException(String.format(INVALID_STORE_NAME, storeName));
		}

		// As per Etsy documentation store name is unique if more than one store found
		// throw an exception
		if (shops.size() > 1) {
			throw new MarketplaceDoesNotExistException(String.format(INVALID_STORE_NAME, storeName));
		}

		if (StringUtils.equalsIgnoreCase(shops.get(0).getShopName(), storeName.trim())) {
			return shops.get(0);
		}

		throw new MarketplaceDoesNotExistException(String.format(INVALID_STORE_NAME, storeName));
	}

	private ParameterizedTypeReference<String> stringType() {
		return new ParameterizedTypeReference<String>() {
		};
	}

	private ParameterizedTypeReference<Response<List<EtsyShop>>> shopType() {
		return new ParameterizedTypeReference<Response<List<EtsyShop>>>() {
		};
	}

	private ParameterizedTypeReference<Response<List<Receipt>>> receiptType() {
		return new ParameterizedTypeReference<Response<List<Receipt>>>() {
		};
	}

	private ParameterizedTypeReference<Response<List<EtsyOrder>>> orderType() {
		return new ParameterizedTypeReference<Response<List<EtsyOrder>>>() {
		};
	}

/**	private ParameterizedTypeReference<Response<List<Listing>>> productType() {
		return new ParameterizedTypeReference<Response<List<Listing>>>() {
		};
	}

	private ParameterizedTypeReference<Response<List<EtsyCountry>>> countryType() {
		return new ParameterizedTypeReference<Response<List<EtsyCountry>>>() {
		};
	}

	private ParameterizedTypeReference<Response<List<UserAddress>>> addressType() {
		return new ParameterizedTypeReference<Response<List<UserAddress>>>() {
		};
	}

	private ParameterizedTypeReference<Response<List<ListingImage>>> producImageType() {
		return new ParameterizedTypeReference<Response<List<ListingImage>>>() {
		};
	}

	private ParameterizedTypeReference<Response<ListingInventory>> productVarinatType() {
		return new ParameterizedTypeReference<Response<ListingInventory>>() {
		};
	} */

	private ParameterizedTypeReference<Response<List<EtsyOrderDetail>>> orderLineType() {
		return new ParameterizedTypeReference<Response<List<EtsyOrderDetail>>>() {
		};
	}

}

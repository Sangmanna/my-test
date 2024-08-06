package com.freightcom.clickship.client.reverb;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.freightcom.clickship.model.KeyValue;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyCancelShipment;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyCancelShipmentResponse;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyEndpoint;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyOffers;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyOrder;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyOrders;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyShipmentResponse;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyShippingFulfillmentDetails;
import com.freightcom.clickship.model.marketplace.reverb.ReverbAuthTokenRequest;
import com.freightcom.clickship.model.marketplace.reverb.ReverbAuthTokenResponce;
import com.freightcom.clickship.model.marketplace.reverb.ReverbEndpoint;
import com.freightcom.clickship.model.marketplace.reverb.ReverbListing;
import com.freightcom.clickship.model.marketplace.reverb.ReverbOrder;
import com.freightcom.clickship.model.marketplace.reverb.ReverbOrders;
import com.freightcom.clickship.model.marketplace.reverb.ReverbProduct;
import com.freightcom.clickship.model.marketplace.reverb.ReverbTracking;
import com.freightcom.clickship.model.marketplace.reverb.ReverbUser;

@Component
public class ReverbClient {

    @Value("${reverb.server.url}")
	private String reverbServerUrl;

	@Autowired
	private RestTemplate restTemplate;

	public ReverbUser getUserStatus(String privateKey) {
		URI url = getUrl("api/my/account", null);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(privateKey, null), ReverbUser.class)
				.getBody();

	}
	
	public BestBuyCancelShipmentResponse cancelFulfillment(String accessToken, BestBuyCancelShipment cancelShipment) {
		URI url = getUrl(BestBuyEndpoint.CANCEL_FULFILLMENT.getValue(), null);
		return restTemplate
				.exchange(url, HttpMethod.PUT, getRequestEntity(accessToken, cancelShipment), BestBuyCancelShipmentResponse.class)
				.getBody();

	}

	public ReverbOrder importOrders(String accessToken, String orderStatus, int offset, int max) {
		URI url = getUrl(ReverbEndpoint.GET_ORDERS.getValue(),null);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(accessToken, null), ReverbOrder.class)
				.getBody();

	}
	
	public BestBuyOrders importOrdersById(String accessToken, String orderId) {
		List<NameValuePair> keyValueList = Arrays.asList(new BasicNameValuePair("order_ids", orderId));
		URI url = getUrl(BestBuyEndpoint.GET_ORDERS.getValue(), keyValueList);
		return restTemplate
				.exchange(url, HttpMethod.GET, getRequestEntity(accessToken, null), BestBuyOrder.class)
				.getBody().getOrders().get(0);

	}

	public BestBuyOffers getProductByOffer(String accessToken, int offerId) {
		URI url = getUrl(String.format(BestBuyEndpoint.GET_OFFER.getValue(), offerId), null);
		return restTemplate.exchange(url, HttpMethod.GET,
				getRequestEntity(accessToken, null), BestBuyOffers.class).getBody();
	}

	public BestBuyShipmentResponse createFulfillment(String accessToken, BestBuyShippingFulfillmentDetails req) {

		URI url = getUrl(BestBuyEndpoint.SHIPMENT_URL.getValue(), null);
		
		return restTemplate.exchange(url, HttpMethod.POST,
				getRequestEntity(accessToken, req), BestBuyShipmentResponse.class).getBody();
		
	}

	public BestBuyOrder importOrderUpdates(String accessToken, String lastModifedDate, int offset, int max) {
		List<NameValuePair> keyValueList = Arrays.asList(new BasicNameValuePair("start_update_date", lastModifedDate),
				new BasicNameValuePair("offset", String.valueOf(offset)),
				new BasicNameValuePair("max", String.valueOf(max)));
		URI url = getUrl(BestBuyEndpoint.GET_ORDERS.getValue(), keyValueList);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(accessToken, null), BestBuyOrder.class)
				.getBody();
	}

	private URI getUrl(String path, List<NameValuePair> requestParams) {
		try {
			URIBuilder uriBuilder = new URIBuilder().setScheme("https").setHost(reverbServerUrl).setPath(path);

			if (CollectionUtils.isNotEmpty(requestParams)) {
				uriBuilder.addParameters(requestParams);
			}

			return uriBuilder.build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(
					String.format("Error while constructing url:%s, path:%s", reverbServerUrl, path));
		}
	}
	
	private URI getUrlWithQueryParams(String path, List<KeyValue> requestParams) {
		try {
			URIBuilder uriBuilder = new URIBuilder().setScheme("https").setHost(reverbServerUrl).setPath(path);

			if (CollectionUtils.isNotEmpty(requestParams)) {
	            requestParams.forEach(pair -> uriBuilder.setParameter(pair.getKey(), String.valueOf(pair.getValue())));
	        }

			return uriBuilder.build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(
					String.format("Error while constructing url:%s, path:%s", reverbServerUrl, path));
		}
	}
	
	private HttpEntity<Object> getRequestEntity(String accessToken, Object requestBody) {
		HttpHeaders requestHeaders = getHeadersWithContentType();
		requestHeaders.set("Authorization", "Bearer "+accessToken);
		requestHeaders.set("Content-Type", "application/hal+json");
		requestHeaders.set("Accept", "application/hal+json");
		requestHeaders.set("Accept-Version", "3.0");

		if (requestBody != null) {
			return new HttpEntity<>(requestBody, requestHeaders);
		} else {
			return new HttpEntity<>(requestHeaders);
		}
	}

	private HttpHeaders getHeadersWithContentType() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		return requestHeaders;
	}

	public ReverbOrders getAllOrders(String token, String username, Integer pageSize) {
		
		Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("per_page", pageSize.toString());

        List<KeyValue> keyValueList = new ArrayList<>();
        for (Map.Entry<String, String> entrySet : queryParams.entrySet()) {
            keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
        }
        
		URI url = getUrlWithQueryParams(ReverbEndpoint.GET_ORDERS.getValue(), keyValueList);
		ReverbOrders reverbOrders = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(token, null), ReverbOrders.class)
				.getBody();
		if(reverbOrders.getCurrentPage() < reverbOrders.getTotalPages()) {
			getOrdersByPagination(reverbOrders,reverbOrders.getCurrentPage()+1,token,pageSize);
		}
		return reverbOrders;
	}
	
	private void getOrdersByPagination(ReverbOrders reverbOrders, int currentPage, String token, Integer pageSize) {
		Map<String, String> queryParams = new TreeMap<>();
		queryParams.put("per_page", pageSize.toString());
		queryParams.put("page", currentPage + "");
		List<KeyValue> keyValueList = new ArrayList<>();
		for (Map.Entry<String, String> entrySet : queryParams.entrySet()) {
			keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
		}

		URI url = getUrlWithQueryParams(ReverbEndpoint.GET_ORDERS.getValue(), keyValueList);
		ReverbOrders orders = restTemplate
				.exchange(url, HttpMethod.GET, getRequestEntity(token, null), ReverbOrders.class).getBody();
		reverbOrders.getOrders().addAll(orders.getOrders());
		if (orders.getCurrentPage() < orders.getTotalPages()) {
			getOrdersByPagination(reverbOrders, orders.getCurrentPage() + 1, token, pageSize);
		}
	}

	public ReverbOrder getMissingOrders(String token, String orderId) {
		URI url = getUrl(String.format(ReverbEndpoint.GET_ORDERS_ID.getValue(),orderId),null);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(token, null), ReverbOrder.class)
				.getBody();
	}

	public ReverbProduct getAllProducts(String token, String username, String status, Integer pageSize) {
		// state=all
		
		Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("state", "all");
        queryParams.put("per_page", pageSize.toString());

        List<KeyValue> keyValueList = new ArrayList<>();
        for (Map.Entry<String, String> entrySet : queryParams.entrySet()) {
            keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
        }
        
		URI url = getUrlWithQueryParams(ReverbEndpoint.GET_PRODUCTS.getValue(), keyValueList);
		ReverbProduct reverbProduct = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(token, null), ReverbProduct.class)
				.getBody();
		int currentPage = Integer.parseInt(reverbProduct.getCurrentPage());
		int totalPages = Integer.parseInt(reverbProduct.getTotalPages());
		if(currentPage < totalPages) {
			loadProductsPagination(reverbProduct,currentPage+1,token,username,pageSize);
		}
		return reverbProduct;
	}
	
	private void loadProductsPagination(ReverbProduct reverbProduct, int pageNumber, String token, String username,
			Integer pageSize) {
		Map<String, String> queryParams = new TreeMap<>();
		queryParams.put("state", "all");
		queryParams.put("per_page", pageSize.toString());
		queryParams.put("page", pageNumber + "");

		List<KeyValue> keyValueList = new ArrayList<>();
		for (Map.Entry<String, String> entrySet : queryParams.entrySet()) {
			keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
		}

		URI url = getUrlWithQueryParams(ReverbEndpoint.GET_PRODUCTS.getValue(), keyValueList);
		ReverbProduct product = restTemplate
				.exchange(url, HttpMethod.GET, getRequestEntity(token, null), ReverbProduct.class).getBody();
		reverbProduct.getReverbListings().addAll(product.getReverbListings());
		int currentPage = Integer.parseInt(product.getCurrentPage());
		int totalPages = Integer.parseInt(product.getTotalPages());
		if (currentPage < totalPages) {
			loadProductsPagination(reverbProduct, currentPage+1, token, username, pageSize);
		}
	}

	public ReverbListing updateProduct(String token, ReverbListing listing,String productId) {
		URI url = getUrl(String.format(ReverbEndpoint.UPDATE_PRODUCT.getValue(), productId), null);
		return restTemplate.exchange(url, HttpMethod.PUT, getRequestEntity(token, listing), ReverbListing.class)
				.getBody();
	}

	public ReverbOrder submitTracking(String token, String orderNumber, ReverbTracking submitTracking) {
		URI url = getUrl(String.format(ReverbEndpoint.SHIPMENT_URL.getValue(), orderNumber), null);
		return restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(token, submitTracking), ReverbOrder.class)
				.getBody();
	}

	public ReverbProduct getProductUpdates(String token, String fromDate, String toDateString,
			Integer pageSize) {
		return null;
	}

	public ReverbOrders getOrderUpdates(String token, String fromDate, String toDateString, Integer pageSize) {
		Map<String, String> queryParams = new TreeMap<>();
		queryParams.put("updated_start_date", fromDate);
		queryParams.put("updated_end_date", toDateString);
		queryParams.put("per_page", pageSize.toString());
		List<KeyValue> keyValueList = new ArrayList<>();
		for (Map.Entry<String, String> entrySet : queryParams.entrySet()) {
			keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
		}

		URI url = getUrlWithQueryParams(ReverbEndpoint.GET_ORDERS.getValue(), keyValueList);
		ReverbOrders reverbOrders = restTemplate
				.exchange(url, HttpMethod.GET, getRequestEntity(token, null), ReverbOrders.class).getBody();
		if (reverbOrders.getCurrentPage() < reverbOrders.getTotalPages()) {
			getOrdersByPagination(reverbOrders, reverbOrders.getCurrentPage() + 1, token, pageSize);
		}
		return reverbOrders;
	}

	public ReverbProduct getProductBySku(String token, String sku) {
		Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("sku", sku);
        queryParams.put("state", "all");

        List<KeyValue> keyValueList = new ArrayList<>();
        for (Map.Entry<String, String> entrySet : queryParams.entrySet()) {
            keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
        }
        
		URI url = getUrlWithQueryParams(ReverbEndpoint.GET_PRODUCTS.getValue(), keyValueList);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(token, null), ReverbProduct.class)
				.getBody();
	}

	public ReverbListing getProductByListingId(String token, String productId) {
		URI url = getUrlWithQueryParams(String.format(ReverbEndpoint.GET_PRODUCTS_LISTING.getValue(),productId), null);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(token, null), ReverbListing.class)
				.getBody();
	}

	public ReverbAuthTokenResponce getSecretToken(ReverbAuthTokenRequest authTokenRequest) {
		URI url = getUrlWithQueryParams(ReverbEndpoint.GET_SECRET_TOKEN.getValue(), null);
		return restTemplate.exchange(url, HttpMethod.POST, getRequestEntityForToken(authTokenRequest), ReverbAuthTokenResponce.class)
				.getBody();
	}

	private HttpEntity<Object> getRequestEntityForToken(ReverbAuthTokenRequest authTokenRequest) {
		HttpHeaders requestHeaders = getHeadersWithContentType();
		if (authTokenRequest != null) {
			return new HttpEntity<>(authTokenRequest, requestHeaders);
		} else {
			return new HttpEntity<>(requestHeaders);
		}
	}
}

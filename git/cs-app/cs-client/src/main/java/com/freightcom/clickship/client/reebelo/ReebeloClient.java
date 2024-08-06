package com.freightcom.clickship.client.reebelo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.freightcom.clickship.model.KeyValue;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloEndpoint;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloOrders;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloTracking;
import com.freightcom.clickship.model.marketplace.reverb.ReverbEndpoint;

@Component
public class ReebeloClient {

	private Logger logger = LogManager.getLogger(ReebeloClient.class);
	
	@Value("${reebelo.server.url}")
	private String reebeloServerUrl;

	@Autowired
	private RestTemplate restTemplate;

	public Boolean getUserStatus(String privateKey) {
		Map<String, Integer> queryParams = new TreeMap<>();
		queryParams.put("page", 1);
		queryParams.put("pageSize", 20);

		List<KeyValue> keyValueList = new ArrayList<>();
		for (Map.Entry<String, Integer> entrySet : queryParams.entrySet()) {
			keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
		}
		URI url = getUrlWithQueryParams("/sockets/orders", keyValueList);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(privateKey, null), Object.class).getStatusCode() == HttpStatus.OK;
	}

	public ReebeloOrders importOrdersById(MarketplaceDTO marketplaceDto, String orderId) {
		Map<String, String> queryParams = new TreeMap<>();
		queryParams.put("search", orderId);

		List<KeyValue> keyValueList = new ArrayList<>();
		for (Map.Entry<String, String> entrySet : queryParams.entrySet()) {
			keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
		}

		URI url = getUrlWithQueryParams(ReebeloEndpoint.GET_ORDERS.getValue(), keyValueList);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplaceDto.getAccessToken(), null), ReebeloOrders.class).getBody();
	}

	private URI getUrl(String path, List<NameValuePair> requestParams) {
		try {
			URIBuilder uriBuilder = new URIBuilder().setScheme("https").setHost(reebeloServerUrl).setPath(path);

			if (CollectionUtils.isNotEmpty(requestParams)) {
				uriBuilder.addParameters(requestParams);
			}

			return uriBuilder.build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(
					String.format("Error while constructing url:%s, path:%s", reebeloServerUrl, path));
		}
	}

	private URI getUrlWithQueryParams(String path, List<KeyValue> requestParams) {
		try {
			URIBuilder uriBuilder = new URIBuilder().setScheme("https").setHost(reebeloServerUrl).setPath(path);

			if (CollectionUtils.isNotEmpty(requestParams)) {
				requestParams.forEach(pair -> uriBuilder.setParameter(pair.getKey(), String.valueOf(pair.getValue())));
			}

			return uriBuilder.build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(
					String.format("Error while constructing url:%s, path:%s", reebeloServerUrl, path));
		}
	}

	private HttpEntity<Object> getRequestEntity(String accessToken, Object requestBody) {
		HttpHeaders requestHeaders = getHeadersWithContentType();
		requestHeaders.set("x-api-key", accessToken);
		requestHeaders.set("Content-Type", "application/json");

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

	public ReebeloOrders getAllOrders(String token, String marketplaceId, Integer pageSize) {

		Map<String, String> queryParams = new TreeMap<>();
		queryParams.put("pageSize", pageSize.toString());

		List<KeyValue> keyValueList = new ArrayList<>();
		for (Map.Entry<String, String> entrySet : queryParams.entrySet()) {
			keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
		}

		URI url = getUrlWithQueryParams(ReebeloEndpoint.GET_ORDERS.getValue(), keyValueList);
		logger.info("Reebelo store initial import - orders import started - for marketplaceId:[{}], pageSIze:[{}]", marketplaceId,
				pageSize);
		ReebeloOrders reebeloOrders = restTemplate
				.exchange(url, HttpMethod.GET, getRequestEntity(token, null), ReebeloOrders.class).getBody();
		
		if (reebeloOrders != null && reebeloOrders.isHasNextPage()) {
			getOrdersByPagination(reebeloOrders, 1 + 1, token, pageSize);
		}
		
		return reebeloOrders;
	}

	private void getOrdersByPagination(ReebeloOrders reebeloOrders, int currentPage, String token, Integer pageSize) {
		Map<String, String> queryParams = new TreeMap<>();
		queryParams.put("pageSize", pageSize.toString());
		queryParams.put("page", currentPage + "");
		List<KeyValue> keyValueList = new ArrayList<>();
		
		for (Map.Entry<String, String> entrySet : queryParams.entrySet()) {
			keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
		}

		URI url = getUrlWithQueryParams(ReebeloEndpoint.GET_ORDERS.getValue(), keyValueList);
		logger.info("Reebelo Orders import via Pagination - for Token:[{}], pageSize:[{}], currentPage:[{}]", token, pageSize, currentPage);
		
		ReebeloOrders orders = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(token, null), ReebeloOrders.class).getBody();
		
		reebeloOrders.getOrders().addAll(orders.getOrders());
		
		if (orders.isHasNextPage()) {
			getOrdersByPagination(reebeloOrders, currentPage + 1, token, pageSize);
		}
	}

	public ReebeloOrders getMissingOrders(String token, String orderId) {
		URI url = getUrl(String.format(ReverbEndpoint.GET_ORDERS_ID.getValue(), orderId), null);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(token, null), ReebeloOrders.class).getBody();
	}

	public int submitTracking(String token, String orderNumber, ReebeloTracking submitTracking) {
		URI url = getUrl(String.format(ReebeloEndpoint.SHIPMENT_URL.getValue(), orderNumber), null);
		return restTemplate.exchange(url, HttpMethod.PUT, getRequestEntity(token, submitTracking), Object.class).getStatusCode().value();
	}

	public ReebeloOrders getOrderUpdates(String token, String fromDate, String toDateString, Integer pageSize) {
		Map<String, String> queryParams = new TreeMap<>();
		queryParams.put("from", fromDate);
		queryParams.put("until", toDateString);
		queryParams.put("pageSize", pageSize.toString());
		/** queryParams.put("status", "trackingUploaded");*/
		queryParams.put("page", "1");
		
		List<KeyValue> keyValueList = new ArrayList<>();
		for (Map.Entry<String, String> entrySet : queryParams.entrySet()) {
			keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
		}

		URI url = getUrlWithQueryParams(ReebeloEndpoint.GET_ORDERS.getValue(), keyValueList);
		
		logger.info("Reebelo orders updateing - Url is - [{}]", url);
		
		ReebeloOrders reebeloOrders = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(token, null), ReebeloOrders.class).getBody();
		
		logger.info("Reebelo orders updating completed - size is - [{}]", reebeloOrders.getCount());
		
		if (reebeloOrders.isHasNextPage()) {
			getOrdersByPagination(reebeloOrders, 2, token, pageSize);
		}
		
		return reebeloOrders;
	}
}

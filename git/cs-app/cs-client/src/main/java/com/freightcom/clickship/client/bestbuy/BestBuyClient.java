package com.freightcom.clickship.client.bestbuy;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

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

import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyCancelShipment;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyCancelShipmentResponse;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyEndpoint;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyOffers;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyOrder;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyOrders;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyResponse;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyShipmentResponse;
import com.freightcom.clickship.model.marketplace.bestbuy.BestBuyShippingFulfillmentDetails;

@Component
public class BestBuyClient {

	@Value("${bestbuy.server_url:bby-dev.mirakl.net}")
	private String bestbuyServerUrl;

	@Autowired
	private RestTemplate restTemplate;

	public BestBuyResponse getUserStatus(String privateKey) {
		URI url = getUrl(BestBuyEndpoint.GET_SHOP_ACCOUNT.getValue(), null);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(privateKey, null), BestBuyResponse.class)
				.getBody();

	}
	
	public BestBuyCancelShipmentResponse cancelFulfillment(String accessToken, BestBuyCancelShipment cancelShipment) {
		URI url = getUrl(BestBuyEndpoint.CANCEL_FULFILLMENT.getValue(), null);
		return restTemplate
				.exchange(url, HttpMethod.PUT, getRequestEntity(accessToken, cancelShipment), BestBuyCancelShipmentResponse.class)
				.getBody();

	}

	public BestBuyOrder importOrders(String accessToken, String orderStatus, int offset, int max) {
		List<NameValuePair> keyValueList = Arrays.asList(new BasicNameValuePair("order_state_codes", orderStatus),
				new BasicNameValuePair("offset", String.valueOf(offset)),
				new BasicNameValuePair("max", String.valueOf(max)));
		URI url = getUrl(BestBuyEndpoint.GET_ORDERS.getValue(), keyValueList);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(accessToken, null), BestBuyOrder.class)
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
			URIBuilder uriBuilder = new URIBuilder().setScheme("https").setHost(bestbuyServerUrl).setPath(path);

			if (CollectionUtils.isNotEmpty(requestParams)) {
				uriBuilder.addParameters(requestParams);
			}

			return uriBuilder.build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(
					String.format("Error while constructing url:%s, path:%s", bestbuyServerUrl, path));
		}
	}
	
	private HttpEntity<Object> getRequestEntity(String accessToken, Object requestBody) {
		HttpHeaders requestHeaders = getHeadersWithContentType();
		requestHeaders.set("Authorization", accessToken);

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
	
	
}

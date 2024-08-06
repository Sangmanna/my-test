package com.freightcom.clickship.client.walmart;


import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.freightcom.clickship.client.util.XmlTransformer;
import com.freightcom.clickship.model.KeyValue;
import com.freightcom.clickship.model.exception.http.ClickshipHttpRestNotFoundException;
import com.freightcom.clickship.model.exception.http.UnauthorizedException;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.walmart.Inventory;
import com.freightcom.clickship.model.marketplace.walmart.OrderCancellation_;
import com.freightcom.clickship.model.marketplace.walmart.OrderShipment_;
import com.freightcom.clickship.model.marketplace.walmart.OrdersListType;
import com.freightcom.clickship.model.marketplace.walmart.WalmartEndPoint;
import com.freightcom.clickship.model.marketplace.walmart.WalmartItemResponse;
import com.freightcom.clickship.model.marketplace.walmart.items.ItemResponse;
import com.freightcom.clickship.model.marketplace.walmart.orders.WalmartOrder;

@Component
public class WalmartClient {

	private Logger logger = LogManager.getLogger(WalmartClient.class);

	private static final String SIGNATURE_GENERATION = "Exception while generating the signature for Walmart API call. Error:[%s]";

	@Value("${walmart.server_url:marketplace.walmartapis.com}")
	private String walmartServerUrl;

	@Value("${walmart.api_version:v3}")
	private String version;

	// Setting the value of header as per email from Walmart support, channel type value for ClickShip
	@Value("${walmart.consumer_channel_type:ac0baa21-466b-4d55-8f99-039224be4293}")
	private String consumerChannelType;

	@Autowired
	private RestTemplate restTemplate;

	public void getUserStatus(String consumerId, String privateKey) {
		URI getFeedStatusUrl = getUrl(String.format(WalmartEndPoint.GET_FEED_STATUS.getValue(), version), null);
		HttpHeaders httpHeaders = getHttpHeadersForRequest(consumerId);

		addRequiredParameters(getFeedStatusUrl.toString(), httpHeaders, HttpMethod.GET, consumerId, privateKey);
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

		ResponseEntity<String> responseEntity = restTemplate.exchange(getFeedStatusUrl, HttpMethod.GET, httpEntity, String.class);

		if (!responseEntity.getStatusCode().is2xxSuccessful()) {
			throw new RuntimeException("The provided user does not exist in Walmart");
		}
	}

	public List<WalmartOrder> importWalmartOrders(MarketplaceDTO marketplace, Date createdDate, String walmartOrderStatus, int limit) {
		List<WalmartOrder> walmartOrders = new ArrayList<>();
		List<KeyValue> keyValueList = new ArrayList<>();

		keyValueList.add(new KeyValue("limit", limit));
		keyValueList.add(new KeyValue("createdStartDate", getTimeStamp(createdDate)));
		if (walmartOrderStatus != null) {
			keyValueList.add(new KeyValue("status", walmartOrderStatus));
		}

		URI orderUrl = getUrl(String.format(WalmartEndPoint.ORDERS.getValue(), version), keyValueList);
		String xmlResponse = restTemplate.exchange(orderUrl, HttpMethod.GET, getRequestEntity(marketplace, orderUrl, HttpMethod.GET, null), String.class).getBody();
		OrdersListType ordersListType = XmlTransformer.fromXml(xmlResponse, OrdersListType.class);
		if(ordersListType != null) {
			walmartOrders.addAll(ordersListType.getElements().getOrder());
	
			if (ordersListType.getMeta().getNextCursor() != null) {
				walmartOrders.addAll(getPaginationOrderResponse(marketplace, ordersListType.getMeta().getNextCursor()));
			}
		}

		return walmartOrders;
	}

	public List<ItemResponse> importWalmartItems(MarketplaceDTO marketplace) {
		int offset = 0;
		int limit = 20;
		List<ItemResponse> list = new ArrayList<>();

		while (true) {
			try {
				List<KeyValue> keyValueList = Arrays.asList(new KeyValue("offset", offset), new KeyValue("limit", limit));
				URI itemsUrl = getUrl(String.format(WalmartEndPoint.ITEMS.getValue(), version), keyValueList);

				String xmlResponse = restTemplate.exchange(itemsUrl, HttpMethod.GET, getRequestEntity(marketplace, itemsUrl, HttpMethod.GET, null), String.class).getBody();

				WalmartItemResponse response = XmlTransformer.fromXml(xmlResponse, WalmartItemResponse.class);
				if (CollectionUtils.isNotEmpty(response.getItemResponse())) {
					list.addAll(response.getItemResponse());
					offset += limit;
				} else {
					break;
				}

			} catch (ClickshipHttpRestNotFoundException e) {
				// WALMART throws 404 error if the items does not exist with the offset and limit which we tried. Pull the products until 404 error.
				break;
			}
		}

		return list;
	}

    public void createFulfillment(MarketplaceDTO marketplace, String orderId, OrderShipment_ req) {
        URI fulfillmentUrl = getUrl(String.format(WalmartEndPoint.FULFILLMENT.getValue(), version, orderId), null);
        restTemplate.exchange(fulfillmentUrl, HttpMethod.POST, getRequestEntity(marketplace, fulfillmentUrl, HttpMethod.POST, req), String.class);
    }

    public void cancelOrderByPurchaseId(MarketplaceDTO marketplace, String orderId, OrderCancellation_ req) {
        URI cancelOrderUrl = getUrl(String.format(WalmartEndPoint.CANCEL_ORDER.getValue(), version, orderId), null);
        restTemplate.exchange(cancelOrderUrl, HttpMethod.POST, getRequestEntity(marketplace, cancelOrderUrl, HttpMethod.POST, req), String.class);
    }

    public Inventory getWalmartInventoryBySku(MarketplaceDTO marketplace, String sku) {
        List<KeyValue> keyValueList = new ArrayList<>();
        keyValueList.add(new KeyValue("sku", sku));

        URI getInventoryUrl = getUrl(String.format(WalmartEndPoint.GET_INVENTORY.getValue(), version), keyValueList);
        String xmlResponse = restTemplate.exchange(getInventoryUrl, HttpMethod.GET, getRequestEntity(marketplace, getInventoryUrl, HttpMethod.GET, null), String.class).getBody();
        return XmlTransformer.fromXml(xmlResponse, Inventory.class);
    }

    public void updateInventoryBySku(MarketplaceDTO marketplace, String sku, Inventory req) {
        List<KeyValue> keyValueList = new ArrayList<>();
        keyValueList.add(new KeyValue("sku", sku));

        URI getInventoryUrl = getUrl(String.format(WalmartEndPoint.UPDATE_INVENTORY.getValue(), version), keyValueList);
        restTemplate.exchange(getInventoryUrl, HttpMethod.PUT, getRequestEntity(marketplace, getInventoryUrl, HttpMethod.PUT, req), String.class);
    }

	public WalmartOrder getOrderById(MarketplaceDTO marketplace, String orderId) {
		URI getWalmartOrderUrl = getUrl(String.format(WalmartEndPoint.GET_ORDER.getValue(), version, orderId), null);
		String xmlResponse = restTemplate.exchange(getWalmartOrderUrl, HttpMethod.GET, getRequestEntity(marketplace, getWalmartOrderUrl, HttpMethod.GET, null), String.class).getBody();
		return XmlTransformer.fromXml(xmlResponse, WalmartOrder.class);
	}

	public WalmartItemResponse getItemById(MarketplaceDTO marketplace, String sku) {
		URI getWalmartItemUrl = getUrl(String.format(WalmartEndPoint.GET_ITEM.getValue(), version, sku), null);
		String xmlResponse = restTemplate.exchange(getWalmartItemUrl, HttpMethod.GET, getRequestEntity(marketplace, getWalmartItemUrl, HttpMethod.GET, null), String.class).getBody();
		return XmlTransformer.fromXml(xmlResponse, WalmartItemResponse.class);
	}
	
	private List<WalmartOrder> getPaginationOrderResponse(MarketplaceDTO marketplace, String nextCursor) {
		OrdersListType ordersListType = new OrdersListType();
		List<KeyValue> keyValueList = new ArrayList<>();
		List<WalmartOrder> walmartOrders = new ArrayList<>();

		do {
			Map<String, String> map = getPaginationParams(nextCursor);
			map.forEach((k, v) -> keyValueList.add(new KeyValue(k, map.get(k))));

			URI orderUrl = getUrl(String.format(WalmartEndPoint.ORDERS.getValue(), version), keyValueList);
			String xmlResponse = restTemplate.exchange(orderUrl, HttpMethod.GET, getRequestEntity(marketplace, orderUrl, HttpMethod.GET, null), String.class).getBody();
			ordersListType = XmlTransformer.fromXml(xmlResponse, OrdersListType.class);
			walmartOrders.addAll(ordersListType.getElements().getOrder());
			nextCursor = ordersListType.getMeta().getNextCursor();
		} while (ordersListType.getMeta().getNextCursor() != null);

		return walmartOrders;
	}

	private Map<String, String> getPaginationParams(String nextCursor) {
		String[] params = nextCursor.substring(1).split("&");
		Map<String, String> map = new HashMap<>();

		for (String param : params) {
			String name = param.split("=")[0];
			String value = param.split("=")[1];
			map.put(name, value);
		}
		return map;
	}

    private HttpEntity<Object> getRequestEntity(MarketplaceDTO marketplace, URI url, HttpMethod requestMethod, Object requestBody) {
        HttpHeaders requestHeaders = getHttpHeadersForRequest(marketplace.getUrl());
        addRequiredParameters(url.toString(), requestHeaders, requestMethod, marketplace.getUrl(), marketplace.getAccessToken());

        if (requestBody == null) {
        	return new HttpEntity<>(requestHeaders);
        } else {
        	return new HttpEntity<>(requestBody, requestHeaders);
        }
    }
    
	private HttpHeaders getHttpHeadersForRequest(String consumerId) {
		HttpHeaders httpHeaders = new HttpHeaders();
		
		httpHeaders.set("WM_LOCALE_ID", "en_CA");
		httpHeaders.set("Accept", "application/xml");
		httpHeaders.set("WM_CONSUMER.ID", consumerId);
		httpHeaders.set("WM_SVC.NAME", "Walmart Marketplace API");
		httpHeaders.set("WM_CONSUMER.CHANNEL.TYPE", consumerChannelType);
		httpHeaders.set("WM_QOS.CORRELATION_ID", UUID.randomUUID().toString());
		
		return httpHeaders;
	}

	private void addRequiredParameters(String requestUrl, HttpHeaders httpHeaders, HttpMethod requestMethod, String consumerId, String privateKey) {
		try {
			String timestamp = String.valueOf(Instant.now().toEpochMilli());
			String stringToSign = consumerId + "\n" + requestUrl + "\n" + requestMethod + "\n" + timestamp + "\n";
			String signedString = signData(stringToSign, privateKey);

			httpHeaders.set("WM_SEC.AUTH_SIGNATURE", signedString);
			httpHeaders.set("WM_SEC.TIMESTAMP", timestamp);
		} catch(UnauthorizedException e) {
			throw e;
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	private String getTimeStamp(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(date);
	}
	
	private URI getUrl(String path, List<KeyValue> requestParams) {
		try {
			URIBuilder uriBuilder = new URIBuilder().setScheme("https").setHost(walmartServerUrl).setPath(path);

			if (CollectionUtils.isNotEmpty(requestParams)) {
				requestParams.forEach(pair -> uriBuilder.setParameter(pair.getKey(), String.valueOf(pair.getValue())));
			}

			return uriBuilder.build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(String.format("Error while constructing url:%s, path:%s", walmartServerUrl, path));
		}
	}

	private String signData(String stringToBeSigned, String encodedPrivateKey) {
		try {
			KeyFactory kf = KeyFactory.getInstance("RSA");
			PrivateKey myPrivateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(Base64.decodeBase64(encodedPrivateKey)));

			Signature signature = Signature.getInstance("SHA256withRSA");
			signature.initSign(myPrivateKey);
			signature.update(stringToBeSigned.getBytes("UTF-8"));

			byte[] signedBytes = signature.sign();
			return Base64.encodeBase64String(signedBytes);
		} catch (Exception e) {
			String message = String.format(SIGNATURE_GENERATION, e.getLocalizedMessage());
			logger.error(message, e);
			throw new UnauthorizedException(message);
		}
	}
    
	/**
	 * 
	 * WALMART API requires UUID, signatureString, time stamp on every request. 
	 * Use this main() to generate UUID, signatureString, time stamp for postman.  
	 * 
	 */
    public static void main(String[] args) {
    	String signatureString = null;
    	
    	String consumeId = "2de1619f-c96a-4d47-adea-21dbd52e0f30";
    	String timestamp = String.valueOf(Instant.now().toEpochMilli());
    	String encodedPrivateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJ48TAE2/QvPOzKYaUlh6bdvkBlLHxjgDDqOO2TkbWycmtLriNB2kZkWPraGSAM+vNgFCfH3e6ud6UhaSWL5PyBFFACLtBeVBNAtCVONBiRqgYK4rd4IhBW1pIOMPv8gkbx8Lq4V6n9hc1T4MeEUi5QB1BlqR5HztQJPufQZWDSZAgMBAAECgYAt391JHOAP5GyNJpKfq7tOaxGjw5uoYowpDcM6ZN80ddKNA6wOg9GCSGi2EggeqLmnBw7zD4TTJFzVlRdhklEyWt2gdLAe6eFFas0k3hysEPsw/LGLcPNF0dT7MtBrDl2fWp3DzICSSBUthQFq6D0m2NS8/nVNs26LduLDAN0fYQJBAPT/5PnI2DL6t/HATLSOhfUBmK2zFJL/O9q1T9jwlLmIffJVBV0aLYeRAUrzHYekAth6sl59I14+YGvT7IdgqTcCQQClVxulh2LRmVs4xYct0NbdT5kYNCEO67Lf2t6oQ1eOQyhwPDMza1ZelIkAy9yJBfnaLvZ4hPWiV0fQFtUvA7ivAkEAvzslrNpZ9qDABxDEToKYiL6wP5RyULKsM3AmXPyb+Z1SQV6fiyYtt401Zx0QRZl9Jx/OLfabLqqddEy8aIbITQJBAKLw53QHqmE5KucV8xQ5vaY4rX1m0jVsHsnxXoCgbQbsNEv3Z9YCsAlhhGrefSYkV4inw4oeLhygu0rdVZaRqk0CQDwykAlD0/IU8I5bHP71Awl9hMDmDE5lFHxP8IPHjR5wuNkLwhvBBIGyFtCxXfwmRXTNA6Lv2rBRwDBNgE0n5sA=";
    	
//      String requestUrl = "https://marketplace.walmartapis.com/v3/ca/orders?createdStartDate=2021-04-28T14:00:00Z&status=Created&limit=100";
    	String requestUrl = "https://marketplace.walmartapis.com/v3/ca/items?offset=40&limit=10";
    	
    	

    	try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(kf.generatePrivate(new PKCS8EncodedKeySpec(Base64.decodeBase64(encodedPrivateKey))));
            
            String stringToBeSigned = consumeId + "\n" + requestUrl + "\n" + HttpMethod.GET + "\n" + timestamp + "\n";
            byte[] data = stringToBeSigned.getBytes("UTF-8");
            signature.update(data);
            
            byte[] signedBytes = signature.sign();
            signatureString = Base64.encodeBase64String(signedBytes);
        } catch (Exception e) {
            System.err.print(e);
        }
    	
    	System.out.println("Time stamp -> " + timestamp);
    	System.out.println("signature -> " +  signatureString);
    	System.out.println("UUID -> " + UUID.randomUUID().toString());
	}
}


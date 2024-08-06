package com.freightcom.clickship.client.shopify;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
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
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.freightcom.clickship.client.shopify.auth.ShopifyOAuthRequest;
import com.freightcom.clickship.client.shopify.auth.ShopifyToken;
import com.freightcom.clickship.model.KeyValue;
import com.freightcom.clickship.model.exception.http.ClickshipHttpRestException;
import com.freightcom.clickship.model.exception.http.TooManyRequestsRestException;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyAddress;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyCarrierService;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyCarrierService_;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyEndpoint;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyFulfillment;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyFulfillmentOrder;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyFulfillmentOrderWebhook;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyFulfillmentV2_;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyFulfillment_;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyOrder;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyPaginationResponse;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyProduct;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyRecurringCharge;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyStore;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyVariant;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyWebhook;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyWebhook_;
import com.freightcom.clickship.model.util.Security;

@Component
public class ShopifyRestClient {
	
	private Logger logger = LogManager.getLogger(ShopifyRestClient.class);
	
	@Value("${shopify.api.version}")
	private String version;

	private static final String CLICKSHIP_RATES = "Clickship Rates";
	private static final ParameterizedTypeReference<ShopifyPaginationResponse> returnType
							= new ParameterizedTypeReference<ShopifyPaginationResponse>() { };
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ShopifyStore getStore(MarketplaceDTO marketplace)  {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.SHOP.getValue(), version), null);

		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), returnType);
		return ((ShopifyPaginationResponse) responseEntity.getBody()).getShop();
	}
	
	public ShopifyProduct importProduct(MarketplaceDTO marketplace, String productId) throws Exception {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.PRODUCT.getValue(), version, productId), null);
		
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), returnType);
		return ((ShopifyPaginationResponse) responseEntity.getBody()).getProduct();
	}
	
	public ShopifyVariant getVariant(MarketplaceDTO marketplace, String variantId) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.VARIANT.getValue(), version, variantId), null);
		
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), returnType);
		return ((ShopifyPaginationResponse) responseEntity.getBody()).getVariant();
	}

	public List<ShopifyProduct> importProducts(MarketplaceDTO marketplace, Integer limit) throws Exception {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.PRODUCTS.getValue(), version), getRequestParams("limit", limit));
		
		ResponseEntity<?> responseEntity = getPaginationResponse(url, marketplace, HttpMethod.GET, returnType);
		List<ShopifyProduct> list = ((ShopifyPaginationResponse) responseEntity.getBody()).getProducts();
		String pageLink = getNextPageLink(responseEntity.getHeaders());
		
		final AtomicInteger counter = new AtomicInteger(1);
		while(StringUtils.isNotBlank(pageLink)) {
			logger.debug("Shopify importing products - page no:[{}]", counter.getAndIncrement());
			List<KeyValue> requestParams = getRequestParams("limit", limit);
			requestParams.add(new KeyValue("page_info", pageLink));
			
			url = getUrl(marketplace, String.format(ShopifyEndpoint.PRODUCTS.getValue(), version), requestParams);
			responseEntity = getPaginationResponse(url, marketplace, HttpMethod.GET, returnType);
			list.addAll(((ShopifyPaginationResponse) responseEntity.getBody()).getProducts());
			
			pageLink = getNextPageLink(responseEntity.getHeaders());
		}
		
		return list;
	}
	
	public ShopifyOrder importOrder(MarketplaceDTO marketplace, String orderId) throws Exception {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.ORDER.getValue(), version, orderId), null);
		
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), returnType);
		return ((ShopifyPaginationResponse) responseEntity.getBody()).getOrder();
	}
	
	public List<ShopifyOrder> importOrderByNumber(MarketplaceDTO marketplace, String orderId) throws Exception {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.ORDERS.getValue(), version, orderId), getRequestParams("name", orderId));
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), returnType);
		return ((ShopifyPaginationResponse) responseEntity.getBody()).getOrders();
	}
	
	public List<ShopifyOrder> importOrders(MarketplaceDTO marketplace, String financialStatus, String fulfillmentStatus, Integer limit) {
		List<KeyValue> params = getRequestParams("limit", limit);
		params.add(new KeyValue("financial_status", financialStatus));
		params.add(new KeyValue("fulfillment_status", fulfillmentStatus));
		
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.ORDERS.getValue(), version), params);
		
		ResponseEntity<?> responseEntity = getPaginationResponse(url, marketplace, HttpMethod.GET, returnType);
		List<ShopifyOrder> list = ((ShopifyPaginationResponse) responseEntity.getBody()).getOrders();
		String pageLink = getNextPageLink(responseEntity.getHeaders());
		
		final AtomicInteger counter = new AtomicInteger(1);
		while(StringUtils.isNotBlank(pageLink)) {
			logger.debug("Shopify importing orders - page no:[{}]", counter.getAndIncrement());
			List<KeyValue> requestParams = getRequestParams("limit", limit);
			requestParams.add(new KeyValue("page_info", pageLink));
			
			url = getUrl(marketplace, String.format(ShopifyEndpoint.ORDERS.getValue(), version), requestParams);
			responseEntity = getPaginationResponse(url, marketplace, HttpMethod.GET, returnType);
			list.addAll(((ShopifyPaginationResponse) responseEntity.getBody()).getOrders());
			
			pageLink = getNextPageLink(responseEntity.getHeaders());
		}
		
		return list;
	}
	
	/**
	 * By default SHOPIFY PLUS accounts can have max 20 locations. So pagination is not required
	 * Also as of JUN-2020 SHOPIFY location API does not have pagination feature
	 * 
	 */
	public List<ShopifyAddress> getLocations(MarketplaceDTO marketplace) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.LOCATIONS.getValue(), version), null);
		
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), returnType);
		return ((ShopifyPaginationResponse) responseEntity.getBody()).getLocations();
	}
	
	public ShopifyAddress getLocation(MarketplaceDTO marketplace, Long locationId) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.LOCATIONS.getValue(), version, locationId), null);
		
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), returnType);
		return ((ShopifyPaginationResponse) responseEntity.getBody()).getLocation();
	}
	
	public List<ShopifyFulfillmentOrder> getFulfillmentOrders(MarketplaceDTO marketplace, String orderId) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.FULFILLMENT_ORDERS.getValue(), version, orderId), null);
		
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), returnType);
		return ((ShopifyPaginationResponse) responseEntity.getBody()).getFulfillmentOrders();
	}
	
	public ShopifyFulfillmentOrder getFulfillmentOrderById(MarketplaceDTO marketplace, String fulfillmentOrderId) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.FULFILLMENT_ORDER.getValue(), version, fulfillmentOrderId), null);
		
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), returnType);
		return ((ShopifyPaginationResponse) responseEntity.getBody()).getShopifyFulfillmentOrder();
	}
	
	public ShopifyFulfillmentOrder moveFulfillmentOrder(MarketplaceDTO marketplace, ShopifyFulfillmentOrderWebhook sfo, String fulfillmentOrderId) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.FULFILLMENT_ORDER_MOVE.getValue(), version, fulfillmentOrderId), null);
		
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(marketplace, sfo), returnType);
		return ((ShopifyPaginationResponse) responseEntity.getBody()).getShopifyFulfillmentOrder();
	}
	
	public ShopifyOrder cancelOrder(MarketplaceDTO marketplace, String orderId) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.ORDER_CANCEL.getValue(), version, orderId), null);
		return (ShopifyOrder) makeRestCallAndHandleIoError(url, HttpMethod.POST, getRequestEntity(marketplace), ShopifyOrder.class, "cancelling shopify order").getBody();
	}
	
	public ShopifyFulfillment cancelFulfillment(MarketplaceDTO marketplace, String orderId, String fulfillmentId) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.FULFILLMENT_CANCEL.getValue(), version, orderId, fulfillmentId), null);
		return (ShopifyFulfillment) makeRestCallAndHandleIoError(url, HttpMethod.POST, getRequestEntity(marketplace), ShopifyFulfillment.class, "cancelling shopify order fulfilment").getBody();
	}
	
	public ShopifyFulfillment cancelFulfillment(MarketplaceDTO marketplace, String fulfillmentId) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.FULFILLMENT_CANCEL_V2.getValue(), version, fulfillmentId), null);
		return (ShopifyFulfillment) makeRestCallAndHandleIoError(url, HttpMethod.POST, getRequestEntity(marketplace), ShopifyFulfillment.class, "cancelling shopify order fulfilment").getBody();
	}
	
	public ShopifyFulfillment createFulfillment(MarketplaceDTO marketplace, String orderId, ShopifyFulfillment_ req) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.FULFILLMENT_CREATE.getValue(), version, orderId), null);
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(marketplace, req), returnType);
		return ((ShopifyPaginationResponse) responseEntity.getBody()).getFulfillment();
	}
	
	public ShopifyFulfillment createFulfillmentV2(MarketplaceDTO marketplace, ShopifyFulfillmentV2_ req) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.FULFILLMENT_CREATE_V2.getValue(), version), null);
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(marketplace, req), returnType);
		return ((ShopifyPaginationResponse) responseEntity.getBody()).getFulfillment();
	}
	
	public List<ShopifyWebhook> getWebhooks(MarketplaceDTO marketplace) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.WEBHOOKS.getValue(), version), null);
		
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), returnType);
		return ((ShopifyPaginationResponse) responseEntity.getBody()).getWebhooks();
	}
	
	public ShopifyWebhook_ createWebhook(MarketplaceDTO marketplace, ShopifyWebhook_ webhook) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.WEBHOOKS.getValue(), version), null);
		return restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(marketplace, webhook), ShopifyWebhook_.class).getBody();
	}
	
	public void deleteWebhookById(MarketplaceDTO marketplace, String webhookId) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.WEBHOOK.getValue(), version, webhookId), null);
		restTemplate.exchange(url, HttpMethod.DELETE, getRequestEntity(marketplace), String.class).getBody();
	}
	
	public ShopifyCarrierService getClickshipCarrierService(MarketplaceDTO marketplace) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.CARRIER_SERVICES.getValue(), version), null);
		
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), returnType);
		List<ShopifyCarrierService> list = ((ShopifyPaginationResponse) responseEntity.getBody()).getCarrierServices();
		
		if(CollectionUtils.isNotEmpty(list)) {
			for(ShopifyCarrierService service : list) {
				if(StringUtils.equals(CLICKSHIP_RATES, service.getName()) && StringUtils.isNotBlank(service.getCallbackUrl())) {
					return service;
				}
			}			
		}
		
		return null;
	}
	
	public ShopifyCarrierService createClickshipCarrierService(MarketplaceDTO marketplace, ShopifyCarrierService_ service) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.CARRIER_SERVICES.getValue(), version), null);
		return restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(marketplace, service), ShopifyCarrierService_.class).getBody().getService();
	}
	
	public void deleteClickshipCarrierService(MarketplaceDTO marketplace, ShopifyCarrierService service) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.CARRIER_SERVICE.getValue(), version, service.getId()), null);
		restTemplate.exchange(url, HttpMethod.DELETE, getRequestEntity(marketplace), String.class).getBody();
	}
	
	public ShopifyToken generateAccessToken(String marketplaceUrl, ShopifyOAuthRequest oAuthReq) {
		URI url = getUrl(marketplaceUrl, ShopifyEndpoint.GENERATE_TOKEN.getValue(), null);
		
		HttpHeaders requestHeaders = getHeadersWithContentType();
		HttpEntity<ShopifyOAuthRequest> entity = new HttpEntity<>(oAuthReq, requestHeaders);
		
		return restTemplate.exchange(url, HttpMethod.POST, entity, ShopifyToken.class).getBody();
	}
	
	public String uninstallStore(MarketplaceDTO marketplace) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.UNINTALL_STORE.getValue(), version), null);
		return restTemplate.exchange(url, HttpMethod.DELETE, getRequestEntity(marketplace), String.class).getBody();
	}
	
	public ShopifyRecurringCharge getRecurringCharge(MarketplaceDTO marketplace, String chargeId) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.RECURRING_CHARGE.getValue(), version, chargeId), null);
		return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace, null), ShopifyRecurringCharge.class).getBody();
	}
	
/**	public ShopifyRecurringCharge_ createRecurringCharge(MarketplaceDTO marketplace, ShopifyRecurringCharge_ charges) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.RECURRING_CHARGE_CREATE.getValue(), version), null);
		return restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(marketplace, charges), ShopifyRecurringCharge_.class).getBody();
	}

	public void cancelRecurringCharges(MarketplaceDTO marketplace, String chargeId) {
		URI url = getUrl(marketplace, String.format(ShopifyEndpoint.RECURRING_CHARGE_CANCEL.getValue(), version, chargeId), null);
		restTemplate.exchange(url, HttpMethod.DELETE, getRequestEntity(marketplace), String.class).getBody();
	}*/
	
	private ResponseEntity<?> makeRestCallAndHandleIoError(URI url, final HttpMethod method, HttpEntity<Object> entity, Class<?> clazz, String apiCall) {
		int count = 1;
		
		do {
			try {
				return restTemplate.exchange(url, method, entity, clazz);
			} catch (ResourceAccessException e) {
				String message = e.getMessage();

				if (StringUtils.containsAny(message, "I/O error", "Connection reset")) {
					sleep(500);
					logger.error("{} - I/O error - connection reset while {}", count++, apiCall);
				} else {
					throw e;
				}
			}
		} while (count <= 2);
		
		return restTemplate.exchange(url, method, entity, clazz);
	}
	
	private ResponseEntity<?> getPaginationResponse(final URI url, final MarketplaceDTO marketplace, final HttpMethod method, final ParameterizedTypeReference<?> returnType) {
		int retryCount = 0;
		boolean retry = false;
		ResponseEntity<?> responseEntity = null;
		do {
			try {
				responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), returnType);
				break;
			} catch (TooManyRequestsRestException e) {
				retryCount++;
				HttpHeaders responseHeaders = e.getResponseHeaders();
				
				// SHOPIFY throws 422 if too many request made then extract Retry-After  
				// from response headers. Wait for the specified time and retry. 
				List<String> list = responseHeaders.get("Retry-After");
				if(CollectionUtils.isNotEmpty(list)) {
					String retryAfterStr = list.get(0);
					try {
						logger.info("Too Many Requests - Shopify rest api call sleep for " + retryAfterStr + " seconds. ");
						long retryAfter = (long) Math.ceil(Double.parseDouble(retryAfterStr) * 1000);
						if (retryAfter > 0) {
							Thread.sleep(retryAfter);
						}
						retry = true;
					} catch (Exception ee) {
						logger.error("Exception while retrying attempt {} SHOPIFY rest api call", retryCount ,ee);
					}
				}
			} catch (ClickshipHttpRestException e) {
				retry = false;
				break;
			}
		} while (retry && retryCount <= 11);
		
		return responseEntity;
	}
	
	private URI getUrl(MarketplaceDTO marketplace, String path, List<KeyValue> requestParams) {
		return getUrl(marketplace.getUrl(), path, requestParams);
	}
	
	private URI getUrl(String host, String path, List<KeyValue> requestParams) {
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme("https");
		uriBuilder.setHost(host);
		uriBuilder.setPath(path);
		
		if (CollectionUtils.isNotEmpty(requestParams)) {
			requestParams.forEach(pair -> uriBuilder.setParameter(pair.getKey(), String.valueOf(pair.getValue())));
		}

		try {
			return uriBuilder.build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(String.format("Error while constructing url:%s, path:%s", host, path));
		}
	}
	
	private HttpEntity<Object> getRequestEntity(MarketplaceDTO marketplace, Object requestBody){
        HttpHeaders requestHeaders = getHeadersWithContentType();
        requestHeaders.set("X-Shopify-Access-Token", Security.decryptPII(marketplace.getAccessToken()));
        
        if(requestBody != null ) {
        	return new HttpEntity<>(requestBody, requestHeaders); 	
		} else {
        	return new HttpEntity<>(requestHeaders);
        }
	}
	
	private HttpEntity<Object> getRequestEntity(MarketplaceDTO MarketplaceDTO){
        return getRequestEntity(MarketplaceDTO, null);
	}
	
	private HttpHeaders getHeadersWithContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return requestHeaders;
	}
	
	private List<KeyValue> getRequestParams(String key, Object value) {
		ArrayList<KeyValue> requestParams = new ArrayList<>();
		requestParams.add(new KeyValue(key, value));
		return requestParams;
	}
	
	private String getNextPageLink(HttpHeaders headers) {
		List<String> list = headers.get(HttpHeaders.LINK);

		String link = "";
		//List may contains both next and previous. or either one. Get the next Link
		if(CollectionUtils.isNotEmpty(list)) {
			for(String l : list) {
				String[] split = l.split(",");
				
				for(String ll : split) {
					if(StringUtils.contains(ll, "rel=\"next\"")) {
						link=ll;
						break;
					}
				}
				
				if(StringUtils.isNotBlank(link)) {
					break;
				}
			}
		}
		
		//If next link is available then extract the page_info to get next page data  
		if(StringUtils.isNotBlank(link)) {
			int beginIndex = link.indexOf('<');
			int endIndex = link.indexOf('>');
			
			try {
				URIBuilder uriBuilder = new URIBuilder(link.substring(beginIndex+1, endIndex));
				List<NameValuePair> queryParams = uriBuilder.getQueryParams();
				
				for(NameValuePair param : queryParams) {
					if(StringUtils.equals(param.getName(), "page_info")) {
						return param.getValue();
					}				
				}
			} catch (URISyntaxException e) {
				logger.error("Error while getting next page link - {}", list, e);
				return "";
			}
		}
		return "";
	}
	
	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
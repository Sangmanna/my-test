package com.freightcom.clickship.client.squarespace;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import org.springframework.web.client.RestTemplate;

import com.freightcom.clickship.model.KeyValue;
import com.freightcom.clickship.model.exception.http.ClickshipHttpRestException;
import com.freightcom.clickship.model.exception.http.TooManyRequestsRestException;
import com.freightcom.clickship.model.exception.http.UnauthorizedException;
import com.freightcom.clickship.model.marketplace.squarespace.SquareSpaceEndPoint;
import com.freightcom.clickship.model.marketplace.squarespace.SquareSpaceInventoryRequest;
import com.freightcom.clickship.model.marketplace.squarespace.SquareSpaceOrder;
import com.freightcom.clickship.model.marketplace.squarespace.SquareSpaceOrderStatus;
import com.freightcom.clickship.model.marketplace.squarespace.SquareSpaceProduct;
import com.freightcom.clickship.model.marketplace.squarespace.SquareSpaceResponse;
import com.freightcom.clickship.model.marketplace.squarespace.SquareSpaceShipmentRequest;
import com.freightcom.clickship.model.marketplace.squarespace.SquareSpaceTokenGenerationRequest;
import com.freightcom.clickship.model.marketplace.squarespace.SquareSpaceTokenGenerationResponse;
import com.freightcom.clickship.model.marketplace.squarespace.SquareSpaceWebhookRequest;
import com.freightcom.clickship.model.marketplace.squarespace.SquareSpaceWebsite;

@Component
public class SquareSpaceClient {
    private Logger logger = LogManager.getLogger(SquareSpaceClient.class);

    private static final String BASIC = "Basic ";
    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer ";

    @Value("${squarespace.client_id:2JpQrLMp10YA2QREn8OtqETWmUGa4NL6}")
    private String squareSpaceClientId;

    @Value("${squarespace.client_secret:c+Km5a07gF9a8iryCGOrH7jpBe7cqHHIq1dfQYgJHxo=}")
    private String squareSpaceClientSecret;

    @Value("${squarespace.domain:api.squarespace.com}")
    private String squareSpaceDomain;

    @Value("${squarespace.oauth.domain:login.squarespace.com}")
    private String squareSpaceOauthDomain;

    @Value("${squarespace.api.version:1.0}")
    private String squareSpaceApiVersion;

    @Autowired
    private RestTemplate restTemplate;

    public SquareSpaceTokenGenerationResponse getAccessTokenForStore(SquareSpaceTokenGenerationRequest authCodeRequest) {
        URI getAccessTokenUrl = getUrl(SquareSpaceEndPoint.AUTH_URL.getValue(), null, true);
        return getResponse(getAccessTokenUrl, HttpMethod.POST, getRequestEntity(null, authCodeRequest), authCodeExchange()).getBody();
    }

    public SquareSpaceWebsite getUserWebsiteInfo(String accessToken) {
        URI getUserStatusUrl = getUrl(String.format(SquareSpaceEndPoint.WEBSITE_INFO.getValue(), squareSpaceApiVersion), null, false);
        return getResponse(getUserStatusUrl, HttpMethod.GET, getRequestEntity(accessToken, null), websiteInfo()).getBody();
    }

	public List<SquareSpaceOrder> getOrders(String accessToken) {
		List<SquareSpaceOrder> ordersList = new ArrayList<>();
		List<KeyValue> keyValueList = Arrays.asList(new KeyValue("fulfillmentStatus", SquareSpaceOrderStatus.PENDING.getValue()));
		URI getOrdersUrl = getUrl(String.format(SquareSpaceEndPoint.ORDERS.getValue(), squareSpaceApiVersion), keyValueList, false);
		
		SquareSpaceResponse response = restTemplate.exchange(getOrdersUrl, HttpMethod.GET, getRequestEntity(accessToken, null), response()).getBody();
		ordersList.addAll(response.getOrders());

		while (response.getPagination().getHasNextPage()) {
			sleepForOneSecond();
			response = getPaginationResponse(response, accessToken, SquareSpaceEndPoint.ORDERS.getValue());
			ordersList.addAll(response.getOrders());
		}
		return ordersList;
	}

    public List<SquareSpaceProduct> getProducts(String accessToken, String fromDate, String toDate) {
    	List<KeyValue> keyValueList = null;
    	List<SquareSpaceProduct> productList = new ArrayList<>();
        
        if (fromDate != null && toDate != null) {
            keyValueList = Arrays.asList(new KeyValue("modifiedAfter", fromDate), new KeyValue("modifiedBefore", toDate));
        }
        
        URI getProductsUrl = getUrl(String.format(SquareSpaceEndPoint.PRODUCTS.getValue(), squareSpaceApiVersion), keyValueList, false);

        SquareSpaceResponse response = restTemplate.exchange(getProductsUrl, HttpMethod.GET, getRequestEntity(accessToken, null), response()).getBody();
        productList.addAll(response.getProducts());

        while (response.getPagination().getHasNextPage()) {
        	sleepForOneSecond();
            response = getPaginationResponse(response, accessToken, SquareSpaceEndPoint.PRODUCTS.getValue());
            productList.addAll(response.getProducts());
        }
        
        return productList;
    }

    public void createWebhook(String accessToken, SquareSpaceWebhookRequest webhook) {
        URI createWebhookUrl = getUrl(String.format(SquareSpaceEndPoint.WEBHOOKS.getValue(), squareSpaceApiVersion), null, false);
        getResponse(createWebhookUrl, HttpMethod.POST, getRequestEntity(accessToken, webhook), response()).getBody().getWebhooks();
    }

    public void deleteWebhooks (String accessToken, String marketplaceId) {
        URI createWebhookUrl = getUrl(String.format(SquareSpaceEndPoint.WEBHOOKS.getValue(), squareSpaceApiVersion), null, false);
        SquareSpaceResponse response = getResponse(createWebhookUrl, HttpMethod.GET, getRequestEntity(accessToken, null), response()).getBody();

        //deleting webhooks
        if (CollectionUtils.isNotEmpty(response.getWebhooks())) {
            for (SquareSpaceWebhookRequest webhook : response.getWebhooks()) {
                if (StringUtils.containsAny(webhook.getEndpointUrl(), marketplaceId, "webhooks/squarespace")) {
                    deleteCsWebhook(accessToken, webhook.getId());
                }
            }
        }
    }

    public void deleteCsWebhook(String accessToken, String webhookId) {
        URI deleteWebhookUrl = getUrl(String.format(SquareSpaceEndPoint.WEBHOOK.getValue(), squareSpaceApiVersion, webhookId), null, false);
        getResponse(deleteWebhookUrl, HttpMethod.DELETE, getRequestEntity(accessToken, null), stringType());
    }

    private SquareSpaceResponse getPaginationResponse(SquareSpaceResponse response, String accessToken, String urlEndPoint) {
        List<KeyValue> keyValueList = Arrays.asList(new KeyValue("cursor", response.getPagination().getNextPageCursor()));
        URI url = getUrl(String.format(urlEndPoint, squareSpaceApiVersion), keyValueList, false);
       
        return restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(accessToken, null), response()).getBody();
    }

    public List<SquareSpaceProduct> getProductById(String productId, String accessToken) {
        URI getProductUrl = getUrl(String.format(SquareSpaceEndPoint.GET_PRODUCT.getValue(), squareSpaceApiVersion, productId), null, false);
        return restTemplate.exchange(getProductUrl, HttpMethod.GET, getRequestEntity(accessToken, null), response()).getBody().getProducts();
    }

    public SquareSpaceOrder getOrderById(String productId, String accessToken) {
        URI getOrderUrl = getUrl(String.format(SquareSpaceEndPoint.GET_ORDER.getValue(), squareSpaceApiVersion, productId), null, false);
        return restTemplate.exchange(getOrderUrl, HttpMethod.GET, getRequestEntity(accessToken, null), getOrder()).getBody();
    }

    public void createSquareSpaceShipment(String orderId, String accessToken, SquareSpaceShipmentRequest req) {
        URI url = getUrl(String.format(SquareSpaceEndPoint.CREATE_SHIPMENT.getValue(), squareSpaceApiVersion, orderId), null, false);
        restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(accessToken, req), stringType());
    }

    public void updateSquareSpaceInventory(String accessToken, SquareSpaceInventoryRequest req) {
        URI updateInventoryUrl = getUrl(String.format(SquareSpaceEndPoint.UPDATE_INVENTORY.getValue(), squareSpaceApiVersion), null, false);
        getResponse(updateInventoryUrl, HttpMethod.POST, getRequestEntity(accessToken, req), stringType());
    }

    private URI getUrl(String path, List<KeyValue> requestParams, boolean isAccessTokenRequest) {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        if (isAccessTokenRequest) {
            uriBuilder.setHost(squareSpaceOauthDomain);
        } else {
            uriBuilder.setHost(squareSpaceDomain);
        }
        uriBuilder.setPath(path);

        if (CollectionUtils.isNotEmpty(requestParams)) {
            requestParams.forEach(pair -> uriBuilder.setParameter(pair.getKey(), String.valueOf(pair.getValue())));
        }

        try {
            return uriBuilder.build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(
                    String.format("Error while constructing url:%s, path:%s", squareSpaceDomain, path));
        }
    }

    private <T> ResponseEntity<T> getResponse(final URI url, HttpMethod method, HttpEntity<Object> request, ParameterizedTypeReference<T> responseType) {
        int retryCount = 0;
        boolean retry = false;
        ResponseEntity<T> response = null;

        do {
            try {
                response = restTemplate.exchange(url, method, request, responseType);
                break;
            } catch (TooManyRequestsRestException e) {
                logger.error("Too Many Requests - SquareSpace rest api call sleep for 1 minute.");

                if (e.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS) {
                    retryCount++;
                    try {
                        TimeUnit.MINUTES.sleep(1);
                        retry = true;
                    } catch (Exception ee) {
                        logger.error("Exception while thread sleep attempt {} SquareSpace rest api call", retryCount, ee);
                    }
                }
            } catch (UnauthorizedException e) {
                throw e;
            } catch (ClickshipHttpRestException e) {
                throw e;
            }
        } while (retry && retryCount <= 11);

        if(response == null) {
            throw new RuntimeException("Unable to get response from SquareSpace");
        }

        return response;
    }

    private HttpEntity<Object> getRequestEntity(String accessToken, Object requestBody) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (accessToken != null) {
            requestHeaders.set(AUTHORIZATION, BEARER + accessToken);
        } else {
            String token = squareSpaceClientId + ":" + squareSpaceClientSecret;
            String authToken = Base64.getEncoder().encodeToString(token.getBytes());
            requestHeaders.set(AUTHORIZATION, BASIC + authToken);
        }

        if (requestBody != null) {
            return new HttpEntity<>(requestBody, requestHeaders);
        } else {
            return new HttpEntity<>(requestHeaders);
        }
    }

    private ParameterizedTypeReference<String> stringType() {
        return new ParameterizedTypeReference<String>() {};
    }

    private ParameterizedTypeReference<SquareSpaceWebsite> websiteInfo() {
        return new ParameterizedTypeReference<SquareSpaceWebsite>() {};
    }

    private ParameterizedTypeReference<SquareSpaceTokenGenerationResponse> authCodeExchange() {
        return new ParameterizedTypeReference<SquareSpaceTokenGenerationResponse>() {};
    }

    private ParameterizedTypeReference<SquareSpaceResponse> response() {
        return new ParameterizedTypeReference<SquareSpaceResponse>() {};
    }

    private ParameterizedTypeReference<SquareSpaceOrder> getOrder() {
        return new ParameterizedTypeReference<SquareSpaceOrder>() {};
    }
    
    private void sleepForOneSecond() {
    	try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			throw new RuntimeException("Exception while sleeping for one second");
		}    	
    }
}

package com.freightcom.clickship.client.amazon.v2;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;
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
import com.freightcom.clickship.model.exception.marketplace.MarketplaceImportException;
import com.freightcom.clickship.model.marketplace.amazon.v2.AWSRequestBuilder;
import com.freightcom.clickship.model.marketplace.amazon.v2.AWSTempCredentials;
import com.freightcom.clickship.model.marketplace.amazon.v2.AWSTempCredentials_;
import com.freightcom.clickship.model.marketplace.amazon.v2.AmazonError;
import com.freightcom.clickship.model.marketplace.amazon.v2.AmazonV2EndPoint;
import com.freightcom.clickship.model.marketplace.amazon.v2.AmazonV2Order;
import com.freightcom.clickship.model.marketplace.amazon.v2.AmazonV2Report;
import com.freightcom.clickship.model.marketplace.amazon.v2.AmazonV2TokenGenerationRequest;
import com.freightcom.clickship.model.marketplace.amazon.v2.AmazonV2TokenGenerationResponse;
import com.freightcom.clickship.model.marketplace.amazon.v2.ConfirmShipmentErrorResponse;
import com.freightcom.clickship.model.marketplace.amazon.v2.ConfirmShipmentRequest;
import com.freightcom.clickship.model.marketplace.amazon.v2.CreateFeedDocumentResponse;
import com.freightcom.clickship.model.marketplace.amazon.v2.CreateFeedDocumentSpecification;
import com.freightcom.clickship.model.marketplace.amazon.v2.CreateFeedResponse;
import com.freightcom.clickship.model.marketplace.amazon.v2.CreateFeedSpecification;
import com.freightcom.clickship.model.marketplace.amazon.v2.CreateReportResponse;
import com.freightcom.clickship.model.marketplace.amazon.v2.CreateReportSpecification;
import com.freightcom.clickship.model.marketplace.amazon.v2.CreateRestrictedDataTokenRequest;
import com.freightcom.clickship.model.marketplace.amazon.v2.GetCatalogItemResponse;
import com.freightcom.clickship.model.marketplace.amazon.v2.GetOrderItemsResponse;
import com.freightcom.clickship.model.marketplace.amazon.v2.GetOrderResponse;
import com.freightcom.clickship.model.marketplace.amazon.v2.GetOrdersResponse;
import com.freightcom.clickship.model.marketplace.amazon.v2.RDTPayload;

@Component
public class AmazonV2Client {

    private Logger logger = LogManager.getLogger(AmazonV2Client.class);

    @Value("${amazonV2.domain:sellingpartnerapi-na.amazon.com}")
    private String amazonV2Domain;

    @Value("${amazonV2.oauth.domain:api.amazon.com}")
    private String amazonV2OauthDomain;

    @Value("${amazonV2.sts.domain:sts.amazonaws.com}")
    private String amazonV2StsDomain;
    
    @Value("${amazon.oauth_uri:https://api.amazon.com/auth/o2/token}")
    private String oauthUrl;

    @Autowired
    private AmazonSignatureUtil amazonSignatureUtil;

    @Autowired
    private RestTemplate restTemplate;
    
	public AmazonV2TokenGenerationResponse exchangeAuthCode(AmazonV2TokenGenerationRequest req) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		return restTemplate.exchange(oauthUrl, HttpMethod.POST, new HttpEntity<>(req, requestHeaders), AmazonV2TokenGenerationResponse.class).getBody();
	}

    public AmazonV2TokenGenerationResponse getAccessTokenForStore(AmazonV2TokenGenerationRequest authCodeRequest) {
        URI getAccessTokenUrl = getUrl(AmazonV2EndPoint.AUTH_URL.getValue(), null, true, false);
        return getResponse(getAccessTokenUrl, HttpMethod.POST, getRequestEntity(authCodeRequest, true), authCodeExchange()).getBody();
    }

    public AWSTempCredentials_ getAWSTemporaryCredentials() {
        AWSRequestBuilder requestBuilder = amazonSignatureUtil.getTemporaryAwsSessionToken();

        List<KeyValue> keyValueList = new ArrayList<>();
        for (Map.Entry<String, String> entrySet : requestBuilder.getQueryParameters().entrySet()) {
            keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
        }

        URI getAWSSessionUrl = getUrl(AmazonV2EndPoint.GET_TEMP_CREDENTIALS.getValue(), keyValueList, false, true);
        return getResponse(getAWSSessionUrl, HttpMethod.GET, getRequestEntity(requestBuilder.getAwsHeaders(), null), awsTempCredentials()).getBody();
    }

    public RDTPayload createRestrictedDataToken(AWSTempCredentials credentials, CreateRestrictedDataTokenRequest request, String payload,
                                                                       String accessToken) {
        AWSRequestBuilder requestBuilder = amazonSignatureUtil.buildRequest(credentials, null, payload, accessToken,
                "POST", AmazonV2EndPoint.CREATE_RDT.getValue());

        URI getRDTUrl = getUrl(AmazonV2EndPoint.CREATE_RDT.getValue(), null, false, false);
        return getResponse(getRDTUrl, HttpMethod.POST, getRequestEntity(requestBuilder.getAwsHeaders(), request), rdtToken()).getBody();
    }

    public CreateReportResponse createAmazonReport(AWSRequestBuilder requestBuilder, CreateReportSpecification payload) {
        URI createReportUrl = getUrl(AmazonV2EndPoint.CREATE_REPORT.getValue(), null, false, false);
        return getResponse(createReportUrl, HttpMethod.POST, getRequestEntity(requestBuilder.getAwsHeaders(), payload), reportId()).getBody();
    }

    public AmazonV2Report getAmazonReportStatus(AWSRequestBuilder requestBuilder, String reportId) {
        URI getReportUrl = getUrl(String.format(AmazonV2EndPoint.GET_REPORT.getValue(), reportId), null, false, false);
        return getResponse(getReportUrl, HttpMethod.GET, getRequestEntity(requestBuilder.getAwsHeaders(), null), amazonReport()).getBody();
    }

    public List<AmazonV2Order> getOrders(Map<String, String> queryParams, AWSTempCredentials credentials, String rdtToken, String marketplaceId) {
        AWSRequestBuilder requestBuilder = amazonSignatureUtil.buildRequest(credentials, queryParams, null, rdtToken,
                "GET", AmazonV2EndPoint.GET_ORDERS.getValue());

        List<AmazonV2Order> amazonOrderList = new ArrayList<>();
        List<KeyValue> keyValueList = new ArrayList<>();
        for (Map.Entry<String, String> entrySet : queryParams.entrySet()) {
            keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
        }

        URI getOrdersUrl = getUrl(AmazonV2EndPoint.GET_ORDERS.getValue(), keyValueList, false, false);
        GetOrdersResponse response = getResponse(getOrdersUrl, HttpMethod.GET, getRequestEntity(requestBuilder.getAwsHeaders(), null), orders()).getBody();
        if (response != null && CollectionUtils.isNotEmpty(response.getPayload().getOrders())) {
            amazonOrderList.addAll(response.getPayload().getOrders());
            String nextToken = response.getPayload().getNextToken();

            while (StringUtils.isNotEmpty(nextToken)) {
                response = getPaginationResponse(nextToken, credentials, rdtToken, marketplaceId);                
                if (response != null && response.getPayload() != null && CollectionUtils.isNotEmpty(response.getPayload().getOrders())) {
                	nextToken = response.getPayload().getNextToken();
                    amazonOrderList.addAll(response.getPayload().getOrders());
                }
                if(response != null && response.getErrors() !=null && !response.getErrors().isEmpty()) {
                	for(AmazonError amazonError: response.getErrors()) {
                		logger.error("Exception while fetching Next Page orders; Code : {}; Error Message: {}, Details: {}",amazonError.getCode(),amazonError.getMessage(),amazonError.getDetails());
                	}
                	throw new MarketplaceImportException("Failed to fetch orders");
                }
            }
            
            return amazonOrderList;
        }        
        if(response != null && response.getErrors() !=null && !response.getErrors().isEmpty()) {
        	for(AmazonError amazonError: response.getErrors()) {
        		logger.error("Exception while fetching orders; Code : {}; Error Message: {}, Details: {}",amazonError.getCode(),amazonError.getMessage(),amazonError.getDetails());
        	}
        	throw new MarketplaceImportException("Failed to fetch orders");
        }

        return amazonOrderList;
    }

    public GetOrderItemsResponse getOrderItemsResponse(AWSTempCredentials credentials, String rdtToken, String canonicalPath, String orderId) {
        AWSRequestBuilder requestBuilder = amazonSignatureUtil.buildRequest(credentials, null, null, rdtToken,
                "GET", canonicalPath);

        URI getItemsUrl = getUrl(String.format(AmazonV2EndPoint.GET_ORDER_ITEMS.getValue(), orderId), null, false, false);
        return getResponse(getItemsUrl, HttpMethod.GET, getRequestEntity(requestBuilder.getAwsHeaders(), null), items()).getBody();
    }

    public GetCatalogItemResponse getCatalogItem(AWSTempCredentials credentials, Map<String, String> queryParams,
                                                 String accessToken, String asin) {
        AWSRequestBuilder requestBuilder = amazonSignatureUtil.buildRequest(credentials, queryParams, null, accessToken,
                "GET", String.format(AmazonV2EndPoint.GET_PRODUCT.getValue(), asin));
        List<KeyValue> keyValueList = new ArrayList<>();
        for (Map.Entry<String, String> entrySet : queryParams.entrySet()) {
            keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
        }
        URI getProductUrl = getUrl(String.format(AmazonV2EndPoint.GET_PRODUCT.getValue(), asin), keyValueList, false, false);
        return getResponse(getProductUrl, HttpMethod.GET, getRequestEntity(requestBuilder.getAwsHeaders(), null), product()).getBody();
    }

    public GetOrderResponse getOrderById(AWSTempCredentials credentials, String rdtToken, String orderId) {
        AWSRequestBuilder requestBuilder = amazonSignatureUtil.buildRequest(credentials, null, null, rdtToken,
                "GET", String.format(AmazonV2EndPoint.GET_ORDER.getValue(), orderId));

        URI getOrderUrl = getUrl(String.format(AmazonV2EndPoint.GET_ORDER.getValue(), orderId), null, false, false);
        return getResponse(getOrderUrl, HttpMethod.GET, getRequestEntity(requestBuilder.getAwsHeaders(), null), order()).getBody();
    }

    private GetOrdersResponse getPaginationResponse(String nextToken, AWSTempCredentials credentials,String rdtToken, String marketplaceId) {
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("NextToken", nextToken);
        queryParams.put("MarketplaceIds", marketplaceId);
        AWSRequestBuilder requestBuilder = amazonSignatureUtil.buildRequest(credentials, queryParams, null, rdtToken, "GET", AmazonV2EndPoint.GET_ORDERS.getValue());
        List<KeyValue> keyValueList = new ArrayList<>();
        for (Map.Entry<String, String> entrySet : queryParams.entrySet()) {
            keyValueList.add(new KeyValue(entrySet.getKey(), entrySet.getValue()));
        }
        URI getOrdersUrl = getUrl(AmazonV2EndPoint.GET_ORDERS.getValue(), keyValueList, false, false);
        return getResponse(getOrdersUrl, HttpMethod.GET, getRequestEntity(requestBuilder.getAwsHeaders(), null), orders()).getBody();
    }

    public CreateFeedDocumentResponse createFeedDocument(AWSTempCredentials credentials, CreateFeedDocumentSpecification request, String payload,
                                                         String accessToken) {
        AWSRequestBuilder requestBuilder = amazonSignatureUtil.buildRequest(credentials, null, payload, accessToken, "POST",
                AmazonV2EndPoint.FEED_DOCUMENTS.getValue());

        URI createFeedUrl = getUrl(AmazonV2EndPoint.FEED_DOCUMENTS.getValue(), null, false, false);
        return getResponse(createFeedUrl, HttpMethod.POST, getRequestEntity(requestBuilder.getAwsHeaders(), request), feedDocument()).getBody();
    }

    public void uploadFeedData(String url, String sourceData) {
        URI uploadFeedUrl = URI.create(url);
        restTemplate.put(uploadFeedUrl, getRequestEntity(sourceData, false));
    }
    
    public ConfirmShipmentErrorResponse confirmShipment(AWSTempCredentials credentials, String orderId, ConfirmShipmentRequest request,String payload,
            String accessToken) {
		AWSRequestBuilder requestBuilder = amazonSignatureUtil.buildRequest(credentials, null, payload, accessToken,
		"POST", String.format(AmazonV2EndPoint.CONFIRM_SHIPMENT.getValue(),	orderId));
		
		URI confirmShipmentUrl = getUrl(String.format(AmazonV2EndPoint.CONFIRM_SHIPMENT.getValue(), orderId), null, false, false);
		return getResponse(confirmShipmentUrl, HttpMethod.POST, getRequestEntity(requestBuilder.getAwsHeaders(), request), confirmShipmentErrorResponse()).getBody();
	}

    public CreateFeedResponse createFeed(AWSTempCredentials credentials, CreateFeedSpecification payload, String feedJson,
                                         String accessToken) {
        AWSRequestBuilder requestBuilder = amazonSignatureUtil.buildRequest(credentials, null, feedJson, accessToken,
                "POST", AmazonV2EndPoint.FEEDS.getValue());

        URI createFeedUrl = getUrl(AmazonV2EndPoint.FEEDS.getValue(), null, false, false);
        return getResponse(createFeedUrl, HttpMethod.POST, getRequestEntity(requestBuilder.getAwsHeaders(), payload), feedResponse()).getBody();
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
                logger.error("Too Many Requests - Amazon rest api call sleep for 35 seconds, Retry Attempt: {}",retryCount);

                if (e.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS) {
                    retryCount++;
                    try {
                        TimeUnit.SECONDS.sleep(35);
                        retry = true;
                    } catch (Exception ee) {
                        logger.error("Exception while thread sleep attempt {} Amazon rest api call", retryCount, ee);
                    }
                }
            } catch (UnauthorizedException | ClickshipHttpRestException e) {
                throw e;
            }
        } while (retry && retryCount <= 11);
       
        return response;
    }

    private URI getUrl(String path, List<KeyValue> requestParams, boolean isAccessTokenRequest, boolean isTempCredentialsRequest) {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        if (isAccessTokenRequest) {
            uriBuilder.setHost(amazonV2OauthDomain);
        } else if (isTempCredentialsRequest) {
            uriBuilder.setHost(amazonV2StsDomain);
        } else {
            uriBuilder.setHost(amazonV2Domain);
        }
        uriBuilder.setPath(path);

        if (CollectionUtils.isNotEmpty(requestParams)) {
            requestParams.forEach(pair -> uriBuilder.setParameter(pair.getKey(), String.valueOf(pair.getValue())));
        }

        try {
            return uriBuilder.build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(
                    String.format("Error while constructing url:%s, path:%s", amazonV2Domain, path));
        }
    }

    private HttpEntity<Object> getRequestEntity(Object requestBody, boolean isAuthCodeRequest) {
        HttpHeaders requestHeaders = new HttpHeaders();
        if (isAuthCodeRequest) {
            requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        } else {
            requestHeaders.setContentType(MediaType.valueOf(String.format("text/xml; charset=%s", StandardCharsets.UTF_8)));
        }

        if (requestBody != null) {
            return new HttpEntity<>(requestBody, requestHeaders);
        } else {
            return new HttpEntity<>(requestHeaders);
        }
    }

    private HttpEntity<Object> getRequestEntity(Map<String, String> headersMap, Object requestBody) {
        HttpHeaders requestHeaders = new HttpHeaders();
        for (Map.Entry<String, String> entrySet : headersMap.entrySet()) {
            requestHeaders.add(entrySet.getKey(), entrySet.getValue());
        }

        if (requestBody != null) {
            return new HttpEntity<>(requestBody, requestHeaders);
        } else {
            return new HttpEntity<>(requestHeaders);
        }
    }

    private ParameterizedTypeReference<GetOrdersResponse> orders() {
        return new ParameterizedTypeReference<GetOrdersResponse>() {};
    }

    private ParameterizedTypeReference<GetOrderResponse> order() {
        return new ParameterizedTypeReference<GetOrderResponse>() {};
    }

    private ParameterizedTypeReference<GetOrderItemsResponse> items() {
        return new ParameterizedTypeReference<GetOrderItemsResponse>() {};
    }

    private ParameterizedTypeReference<GetCatalogItemResponse> product() {
        return new ParameterizedTypeReference<GetCatalogItemResponse>() {};
    }

    private ParameterizedTypeReference<AmazonV2TokenGenerationResponse> authCodeExchange() {
        return new ParameterizedTypeReference<AmazonV2TokenGenerationResponse>() {};
    }

    private ParameterizedTypeReference<AWSTempCredentials_> awsTempCredentials() {
        return new ParameterizedTypeReference<AWSTempCredentials_>() {};
    }

    private ParameterizedTypeReference<RDTPayload> rdtToken() {
        return new ParameterizedTypeReference<RDTPayload>() {};
    }

    private ParameterizedTypeReference<AmazonV2Report> amazonReport() {
        return new ParameterizedTypeReference<AmazonV2Report>() {};
    }

    private ParameterizedTypeReference<CreateReportResponse> reportId() {
        return new ParameterizedTypeReference<CreateReportResponse>() {};
    }

    private ParameterizedTypeReference<CreateFeedDocumentResponse> feedDocument() {
        return new ParameterizedTypeReference<CreateFeedDocumentResponse>() {};
    }

    private ParameterizedTypeReference<CreateFeedResponse> feedResponse() {
        return new ParameterizedTypeReference<CreateFeedResponse>() {};
    }
    
    private ParameterizedTypeReference<ConfirmShipmentErrorResponse> confirmShipmentErrorResponse() {
        return new ParameterizedTypeReference<ConfirmShipmentErrorResponse>() {};
    }
}

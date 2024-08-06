package com.freightcom.clickship.client.ebay;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.stream.StreamSource;

import org.apache.commons.collections4.map.LRUMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.freightcom.clickship.client.ebay.auth.AuthCodeExchangeRequest;
import com.freightcom.clickship.client.ebay.auth.RefreshAccessTokenRequest;
import com.freightcom.clickship.client.ebay.auth.TokenGenerationResponse;
import com.freightcom.clickship.client.ebay.digitalSignature.EbayDigitalSignatureComponent;
import com.freightcom.clickship.client.ebay.digitalSignature.EbayDigitalSignatureConfig;
import com.freightcom.clickship.client.ebay.digitalSignature.EbayDigitalSignatureConstant;
import com.freightcom.clickship.client.ebay.digitalSignature.EbayDigitalSignatureService;
import com.freightcom.clickship.model.exception.JAXBRuntimeException;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.ebay.CreateCancelRequest;
import com.freightcom.clickship.model.marketplace.ebay.CreateCancelResponse;
import com.freightcom.clickship.model.marketplace.ebay.EbayEndpoint;
import com.freightcom.clickship.model.marketplace.ebay.EbayOrder;
import com.freightcom.clickship.model.marketplace.ebay.EbayOrderPagination;
import com.freightcom.clickship.model.marketplace.ebay.EbayPublicKey;
import com.freightcom.clickship.model.marketplace.ebay.ShippingFulfillmentDetails;
import com.freightcom.clickship.model.marketplace.ebay.UserResponse;
import com.freightcom.clickship.model.marketplace.ebay.user.GetUserProfileRequest;
import com.freightcom.clickship.model.marketplace.ebay.user.GetUserProfileResponse;
import com.freightcom.clickship.model.marketplace.ebay.user.GetUserRequest;
import com.freightcom.clickship.model.marketplace.ebay.user.GetUserResponse;

import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Component
public class EbayRestClient {
	private Logger logger = LogManager.getLogger(EbayRestClient.class);

	@Value("${ebay.api.client-id}")
	private String ebayApiKey;

	@Value("${ebay.api.scope}")
	private String ebayApiScope;

	@Value("${ebay.api.client-secret}")
	private String ebayApiSecret;

	@Value("${ebay.api.redirect.uri}")
	private String ebayRedirectUri;

	@Value("${ebay.api.resource.server.url}")
	private String ebayResourceServerUrl;

	@Value("${ebay.api.identity.resource.url}")
	private String ebayIdentityResourceServerUrl;

	@Value("${ebay.open.api.server.url}")
	private String ebayOpenApiServerUrl;

	@Value("${ebay.api.client_credentials_scope}")
	private String clientCredentialsScope;

	@Value("${ebay.latest.api.schema.version.id}")
	private String ebayLatestApiSchemaVersionId;
	
	@Value("${ebay.keymgmt.signingkey.endpoint}")
	private String ebayKeymgmtSigningkeyEndpoint;
	
	private final LRUMap<String, EbayPublicKey> map = new LRUMap<>();
	
	private JAXBContext context = null;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EbayDigitalSignatureConfig ebayDigitalSignatureConfig;
	
	@Autowired
	private EbayDigitalSignatureService ebayDigitalSignatureService;
	
	@PostConstruct
	private void initializeContext() throws Exception {
		try {
			context = JAXBContext.newInstance("com.freightcom.clickship.model.marketplace.ebay.user");
		} catch (JAXBException e) {
			throw new JAXBRuntimeException("Error creating the eBay client JAXB context.");
		}
	}

	public TokenGenerationResponse fetchApplicationAccessToken() {
		String getUserStatusUrl = getUrl(ebayResourceServerUrl, EbayEndpoint.AUTH_EXCHANGE);
		HttpHeaders httpHeaders = getHttpHeadersForAuthExchange();

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("grant_type", "client_credentials");
		map.add("scope", clientCredentialsScope);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, httpHeaders);
		return restTemplate.postForObject(getUserStatusUrl, request, TokenGenerationResponse.class);
	}

	public GetUserProfileResponse getUserProfile(String token, GetUserProfileRequest userProfileRequest)  {
		String userProfileUrl = getUrl(ebayOpenApiServerUrl, EbayEndpoint.GET_USER_PROFILE);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("X-EBAY-API-IAF-TOKEN", token);
		httpHeaders.set("X-EBAY-API-CALL-NAME", "GetUserProfile");
		httpHeaders.set("X-EBAY-API-VERSION", ebayLatestApiSchemaVersionId);
		httpHeaders.set("X-EBAY-API-REQUEST-ENCODING", "XML");
		httpHeaders.setContentType(MediaType.TEXT_XML);
		String xmlRequest = toXml(userProfileRequest);	

		HttpEntity<Object> request = new HttpEntity<>(xmlRequest, httpHeaders);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(userProfileUrl);
		String responseStr = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, request, String.class).getBody();		
		return fromXml(responseStr, GetUserProfileResponse.class);
	}
	
	public TokenGenerationResponse exchangeAuthCode(AuthCodeExchangeRequest authCodeExchangeRequest) {
		String oauthAccessTokenUrl = getUrl(ebayResourceServerUrl, EbayEndpoint.AUTH_EXCHANGE);
		HttpHeaders headers = getHttpHeadersForAuthExchange();

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("code", authCodeExchangeRequest.getAuthCode());
		map.add("grant_type", "authorization_code");
		map.add("redirect_uri", ebayRedirectUri);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
		return restTemplate.postForObject(oauthAccessTokenUrl, request, TokenGenerationResponse.class);
	}

	public TokenGenerationResponse refreshMarketplaceAccessToken(RefreshAccessTokenRequest refreshAccessTokenRequest) {
		String oauthRefreshTokenUrl = getUrl(ebayResourceServerUrl, EbayEndpoint.AUTH_EXCHANGE);
		HttpHeaders headers = getHttpHeadersForAuthExchange();

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("refresh_token", refreshAccessTokenRequest.getRefreshToken());
		map.add("grant_type", refreshAccessTokenRequest.getGrantType());
		map.add("scope", ebayApiScope);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
		return restTemplate.postForObject(oauthRefreshTokenUrl, request, TokenGenerationResponse.class);
	}

	public UserResponse getStoreInfo(MarketplaceDTO marketplace) {
		String identityUrl = getUrl(ebayIdentityResourceServerUrl, EbayEndpoint.PROFILE);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(identityUrl);

		ResponseEntity<UserResponse> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, getRequestEntity(marketplace), UserResponse.class);
		return responseEntity.getBody();
	}

	public GetUserResponse getUserStatus(GetUserRequest userRequest)  {
		String userProfileUrl = getUrl(ebayResourceServerUrl, EbayEndpoint.GET_USER_STATUS);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("X-EBAY-API-CALL-NAME", "GetUser");
		httpHeaders.set("X-EBAY-API-COMPATIBILITY-LEVEL", ebayLatestApiSchemaVersionId);
		httpHeaders.set("X-EBAY-API-SITEID", "2");
		httpHeaders.setContentType(MediaType.TEXT_XML);

		HttpEntity<Object> request = new HttpEntity<>(userRequest, httpHeaders);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(userProfileUrl);

		return restTemplate.exchange(builder.toUriString(), HttpMethod.POST, request, GetUserResponse.class).getBody();
	}

	public List<EbayOrder> importOrders(MarketplaceDTO marketplace, String ebayOrderStatus, Integer limit) {
		return processEbayOrdersRequest(marketplace, ebayOrderStatus, limit);
	}

	public List<EbayOrder> importOrderUpdates(MarketplaceDTO marketplace, String lastModifiedDateFilter,
			Integer limit) {
		return processEbayOrdersRequest(marketplace, lastModifiedDateFilter, limit);
	}

	public List<EbayOrder> processEbayOrdersRequest(MarketplaceDTO marketplace, String filter, Integer limit) {
		String orderUrl = getUrl(ebayResourceServerUrl, EbayEndpoint.ORDERS);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(orderUrl).queryParam("limit", limit)
				.queryParam("filter", filter);

		URI url = builder.build().encode().toUri();
		ResponseEntity<EbayOrderPagination> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
				getRequestEntity(marketplace), EbayOrderPagination.class);
		return responseEntity.getBody().getOrders();
	}

	public EbayOrder getOrderById(MarketplaceDTO marketplace, String orderId) {
		Map<String, String> urlParams = new HashMap<>();
		urlParams.put("orderId", orderId);

		String orderUrl = getUrl(ebayResourceServerUrl, EbayEndpoint.GET_ORDER);
		UriComponentsBuilder uriComponents = UriComponentsBuilder.fromUriString(orderUrl);
		URI url = uriComponents.buildAndExpand(urlParams).toUri();

		ResponseEntity<EbayOrder> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), EbayOrder.class);
		return responseEntity.getBody();
	}

	public void createFulfillment(MarketplaceDTO marketplace, String orderId, ShippingFulfillmentDetails req) {
		Map<String, String> urlParams = new HashMap<>();
		urlParams.put("orderId", orderId);

		String fulfillmentReq = getUrl(ebayResourceServerUrl, EbayEndpoint.CREATE_SHIPMENT);
		UriComponentsBuilder uriComponents = UriComponentsBuilder.fromUriString(fulfillmentReq);
		URI url = uriComponents.buildAndExpand(urlParams).toUri();

		restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(marketplace, req), String.class);
	}

	public void cancelOrder(MarketplaceDTO marketplace, CreateCancelRequest createCancelRequest, boolean digitalSignature) throws Exception {
		String cancelReq = getUrl(ebayResourceServerUrl, EbayEndpoint.CANCEL_ORDER);
		UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(cancelReq);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(createCancelRequest);
		
		try {
			HttpEntity<Object> request = getRequestEntityForCancel(marketplace, json, digitalSignature);
			ResponseEntity<CreateCancelResponse> ress = restTemplate.exchange(url.toUriString(), HttpMethod.POST, request, CreateCancelResponse.class);
			CreateCancelResponse res = ress.getBody();
			logger.debug(res);
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
	
	/**
	 * eBay recommends maintain a cache for public key API. Call eBay only if with new public key request came.
	 * 
	 */
	public EbayPublicKey getPublicKey(MarketplaceDTO marketplace, String publicKeyId) {
		if(publicKeyId == null) {
			return null;
		}
		
		EbayPublicKey publicKey = (EbayPublicKey) map.get(publicKeyId);
		
		if (publicKey != null) {
			return publicKey;
		}
	
		return getPublicKey(marketplace, publicKeyId, null);
	}
	
	private synchronized EbayPublicKey getPublicKey(MarketplaceDTO marketplace, String publicKeyId, String dummy) {
		Map<String, String> urlParams = new HashMap<>();
		urlParams.put("public_key_id", publicKeyId);
		
		String publicKeyUrl = getUrl(ebayResourceServerUrl, EbayEndpoint.GET_PUBLIC_KEY);
		UriComponentsBuilder uriComponents = UriComponentsBuilder.fromUriString(publicKeyUrl);
		URI url = uriComponents.buildAndExpand(urlParams).toUri();
		
		EbayPublicKey publicKey = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(marketplace), EbayPublicKey.class).getBody();
		map.putIfAbsent(publicKeyId, publicKey);
		
		return publicKey;
	}

	private HttpEntity<Object> getRequestEntity(MarketplaceDTO marketplace) {
		return getRequestEntity(marketplace, null);
	}

	private HttpEntity<Object> getRequestEntity(MarketplaceDTO marketplace, Object requestBody) {
		HttpHeaders requestHeaders = getHeadersWithContentType();
		requestHeaders.set("Authorization", "Bearer " + marketplace.getAccessToken());

		if (requestBody != null) {
			return new HttpEntity<>(requestBody, requestHeaders);
		} else {
			return new HttpEntity<>(requestHeaders);
		}
	}

	private HttpEntity<Object> getRequestEntityForCancel(MarketplaceDTO marketplace, String requestStr, boolean digitalSignature) throws Exception {
		HttpHeaders requestHeaders = getHeadersWithContentType();
		requestHeaders.set("Authorization", "IAF " + marketplace.getAccessToken());

		if (Arrays.asList("EBAY_CA", "EBAY_US").contains(marketplace.getPassword())) {
			requestHeaders.set("X-EBAY-C-MARKETPLACE-ID", marketplace.getPassword());
		}
		
		addDigitalSignalHeader(requestHeaders, requestStr, digitalSignature);

		if (requestStr != null) {
			return new HttpEntity<>(requestStr, requestHeaders);
		} else {
			return new HttpEntity<>(requestHeaders);
		}
	}
	
	private void addDigitalSignalHeader(HttpHeaders requestHeaders, String requestStr, boolean digitalSignature) throws Exception {
		if (digitalSignature) {
			initEbayDigitalSignature();

			Map<String, String> signatureHeaders = new HashMap<>();

			String contentDigest = ebayDigitalSignatureService.generateContentDigest(requestStr);
			String signatureInput = EbayDigitalSignatureConstant.SIGNATURE_INPUT_PREFIX + ebayDigitalSignatureService.getSignatureInput(contentDigest);

			signatureHeaders.put(EbayDigitalSignatureConstant.X_EBAY_SIGNATURE_HEADER, ebayDigitalSignatureConfig.getJwe());
			signatureHeaders.put(EbayDigitalSignatureConstant.CONTENT_DIGEST, contentDigest);
			signatureHeaders.put(EbayDigitalSignatureConstant.SIGNATURE_INPUT_HEADER, signatureInput);
			signatureHeaders.put(EbayDigitalSignatureConstant.X_EBAY_ENFORCE_SIGNATURE, "true");

			// this should be the last. signature comes from 4 other header parameters
			signatureHeaders.put(EbayDigitalSignatureConstant.SIGNATURE_HEADER, ebayDigitalSignatureService.getSignature(signatureHeaders));

			signatureHeaders.forEach((key, value) -> requestHeaders.set(key, value));
		}
	}

	private HttpHeaders getHttpHeadersForAuthExchange() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		String authStr = ebayApiKey + ":" + ebayApiSecret;
		String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
		
		requestHeaders.add("Authorization", "Basic " + base64Creds);
		return requestHeaders;
	}
	
	private void initEbayDigitalSignature() {
		if (StringUtils.isEmpty(ebayDigitalSignatureConfig.getMasterKey())) {
			TokenGenerationResponse res = fetchApplicationAccessToken();
			
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			header.set("Authorization", "Bearer " + res.getAccessToken());
			
			// will use 'ED25519' instead of 'RSA' for smaller payload and better performance
			HttpEntity<Object> request = new HttpEntity<>("{\"signingKeyCipher\": \"ED25519\"}", header);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ebayKeymgmtSigningkeyEndpoint);
			String jsonStr = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, request, String.class).getBody();
			
			JSONObject json = new JSONObject(jsonStr);
			
			ebayDigitalSignatureConfig.setJwe(json.getString("jwe"));
			ebayDigitalSignatureConfig.setMasterKey(json.getString("jwe"));
			ebayDigitalSignatureConfig.setPublicKeyStr(json.getString("publicKey"));
			ebayDigitalSignatureConfig.setPrivateKeyStr(json.getString("privateKey"));
			
			EbayDigitalSignatureComponent comp = ebayDigitalSignatureConfig.getSignatureComponents();
			comp.setMethod("POST");
			comp.setAuthority(ebayResourceServerUrl);
			comp.setPath(EbayEndpoint.CANCEL_ORDER.toString());
			ebayDigitalSignatureConfig.setSignatureComponents(comp);
		}
	}

	private HttpHeaders getHeadersWithContentType() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		return requestHeaders;
	}

	private String getUrl(String serverUrl, EbayEndpoint ebayEndpoint) {
		return "https://" + serverUrl + ebayEndpoint.getValue();
	}
	
	private <T> String toXml(T object) {
		StringWriter sw = new StringWriter();
		Marshaller marshaller;
		try {
			marshaller = context.createMarshaller();
			marshaller.marshal(object, sw);
		} catch (JAXBException e) {
			throw new JAXBRuntimeException("Error while converting Object to XML " + e.getMessage());
		}
		return sw.toString();
	}
	
	private <R> R fromXml(String xml, Class<R> returnType) {
		R result = null;
	
		try {
			StringReader stringReader = new StringReader(xml);
			final Unmarshaller unMarshaller = context.createUnmarshaller();
		
			result = unMarshaller.unmarshal(new StreamSource(stringReader), returnType).getValue();
		} catch (JAXBException e) {
			throw new JAXBRuntimeException("Error while converting XML to Object " + e.getMessage() + " xml=" + xml);
		} 
		return result;
	}
}

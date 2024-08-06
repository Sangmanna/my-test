package com.freightcom.clickship.client.lightspeed;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.freightcom.clickship.model.KeyValue;
import com.freightcom.clickship.model.exception.http.ClickshipHttpRestException;
import com.freightcom.clickship.model.exception.http.TooManyRequestsRestException;
import com.freightcom.clickship.model.exception.http.UnauthorizedException;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.lightspeed.EmbeddedResource;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedCancelRequest;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedCompany;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedEndPoint;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedExternalService;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedExternalServiceRequest;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedOrder;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedProduct;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedRequest;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedResource;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedResponse;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedShipment;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedShipmentRequest;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedShop;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedVariant;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedWebhooks;
import com.freightcom.clickship.model.marketplace.lightspeed.PaymentStatus;
import com.freightcom.clickship.model.marketplace.lightspeed.ShipmentStatus;

@Component
public class LightSpeedClient {

	private Logger logger = LogManager.getLogger(LightSpeedClient.class);

	private static final String BASIC = "Basic ";
	private static final String AUTHORIZATION = "Authorization";

	private static final String PAGE = "page";
	private static final String LIMIT = "limit";
	
	private static final int DEFAULT_LIMIT = 250;

	private static final String BACK_SLASH = "/";

	private static final String CLICKSHIP_RATES = "Clickship Rates";

	@Value("${lightspeed.domain:api.shoplightspeed.com}")
	private String lightspeedDomain;

	@Value("${lightspeed.app.key:195e88f6bc6f03113dd673448713e463}")
	private String lightSpeedAppKey;

	@Value("${lightspeed.app.secret:e30e1a7f05f8365068b4afb94e678d5c}")
	private String lightSpeedAppSecret;

	@Autowired
	private RestTemplate restTemplate;

	public LightSpeedShop getUserStatus(String userToken, String language) {
		URI getUserStatusUrl = getUrl(String.format(LightSpeedEndPoint.SHOP.getValue(), language), null);

		return getResponse(getUserStatusUrl, HttpMethod.GET, getRequestEntity(userToken, null)).getBody()
				.getLightSpeedShop();
	}
	
	public LightSpeedCompany getLightSpeedCompany(String userToken, String language) {
		URI shopCompanyUrl = getUrl(String.format(LightSpeedEndPoint.COMPANY.getValue(), language), null);
		return getResponse(shopCompanyUrl, HttpMethod.GET, getRequestEntity(userToken, null)).getBody()
				.getShopCompany();
	}

	public void deleteWebhooks(MarketplaceDTO marketplace) {
		List<LightSpeedWebhooks> lsWebhooks = new ArrayList<>();
		Integer page = 1;
		while (true) {
			List<KeyValue> keyValueList = Arrays.asList(new KeyValue(PAGE, page), new KeyValue(LIMIT, DEFAULT_LIMIT));
			URI getWebhookUrl = getUrl(String.format(LightSpeedEndPoint.WEBHOOKS.getValue(), marketplace.getUsername()), keyValueList);
			
			List<LightSpeedWebhooks> itrlist = getResponse(getWebhookUrl, HttpMethod.GET, getRequestEntity(marketplace.getAccessToken(), null)).getBody().getWebhooks();

			if (CollectionUtils.isEmpty(itrlist)) {
				break;
			}
			lsWebhooks.addAll(itrlist);
			page += 1;
		}

		//deleting webhooks
		for (LightSpeedWebhooks webhook : lsWebhooks) {
			if (StringUtils.contains(webhook.getAddress(), marketplace.getId())) {
				deleteCsWebhook(marketplace, webhook.getId());
			}
		}
	}

	public LightSpeedWebhooks createWebhooks(MarketplaceDTO marketplace, LightSpeedRequest lsRequest) {
		URI webhookUrl = getUrl(String.format(LightSpeedEndPoint.WEBHOOKS.getValue(), marketplace.getUsername()), null);
		return getResponse(webhookUrl, HttpMethod.POST, getRequestEntity(marketplace.getAccessToken(), lsRequest)).getBody().getWebhook();
	}

	public void deleteCsWebhook(MarketplaceDTO marketplace, String webhookId) {
		URI deleteWebhookUrl = getUrl(String.format(LightSpeedEndPoint.WEBHOOK.getValue(), marketplace.getUsername(), webhookId), null);
		getResponse(deleteWebhookUrl, HttpMethod.DELETE, getRequestEntity(marketplace.getAccessToken(), null));
	}

	public LightSpeedProduct getProduct(MarketplaceDTO marketplace, String productId) {
		URI getProductUrl = getUrl(
				String.format(LightSpeedEndPoint.PRODUCT.getValue(), marketplace.getUsername(), productId), null);

		LightSpeedProduct product = getResponse(getProductUrl, HttpMethod.GET,
				getRequestEntity(marketplace.getAccessToken(), null)).getBody().getProduct();

		// Getting product Variants
		if (product != null) {
			product.setVariantsList(getVariants(product, marketplace));
		}
		return product;
	}

	public List<LightSpeedProduct> getProducts(MarketplaceDTO marketplace, int limit) {
		List<LightSpeedProduct> lsProducts = new ArrayList<>();

		Integer page = 1;
		while (true) {
			List<KeyValue> keyValueList = Arrays.asList(new KeyValue(PAGE, page), new KeyValue(LIMIT, limit));
			URI getProductsUrl = getUrl(String.format(LightSpeedEndPoint.PRODUCTS.getValue(), marketplace.getUsername()), keyValueList);
			
			List<LightSpeedProduct> itrlist = getResponse(getProductsUrl, HttpMethod.GET,
					getRequestEntity(marketplace.getAccessToken(), null)).getBody().getProducts();

			if (CollectionUtils.isEmpty(itrlist)) {
				break;
			}
			lsProducts.addAll(itrlist);
			page += 1;
		}
		return lsProducts;
	}

	public List<LightSpeedVariant> getStoreVariants(MarketplaceDTO marketplace, int limit) {
		List<LightSpeedVariant> lsVariants = new ArrayList<>();

		Integer page = 1;
		while (true) {
			List<KeyValue> keyValueList = Arrays.asList(new KeyValue(PAGE, page), new KeyValue(LIMIT, limit));
			URI getVariantsUrl = getUrl(String.format(LightSpeedEndPoint.VARIANTS.getValue(), marketplace.getUsername()), keyValueList);

			List<LightSpeedVariant> itrlist = getResponse(getVariantsUrl, HttpMethod.GET,
					getRequestEntity(marketplace.getAccessToken(), null)).getBody().getVariants();

			if (CollectionUtils.isEmpty(itrlist)) {
				break;
			}
			lsVariants.addAll(itrlist);
			page += 1;
		}
		return lsVariants;
	}
	
	public List<LightSpeedVariant> getVariants(LightSpeedProduct product, MarketplaceDTO marketplace) {
		List<LightSpeedVariant> lightSpeedVariants = new ArrayList<>();
		LightSpeedVariant variants = product.getVariants();

		if (variants != null) {
			LightSpeedResource lightSpeedResource = product.getVariants().getResource();
			if (lightSpeedResource != null && lightSpeedResource.getLink() != null) {
				lightSpeedVariants = getResponse(URI.create(lightSpeedResource.getLink()), HttpMethod.GET,
						getRequestEntity(marketplace.getAccessToken(), null)).getBody().getVariants();
			}
		}
		return lightSpeedVariants;
	}
	
	public LightSpeedVariant getVariant(MarketplaceDTO dto, String id) {
		URI url = getUrl(String.format(LightSpeedEndPoint.VARIANT.getValue(), dto.getUsername(), id), null);
		return getResponse(url, HttpMethod.GET, getRequestEntity(dto.getAccessToken(), null)).getBody().getVariant();
	}

	public List<LightSpeedOrder> getOrders(MarketplaceDTO marketplace, int limit) {
		List<LightSpeedOrder> lsOrders = new ArrayList<>();
		Integer page = 1;
		
		while (true) {
			List<KeyValue> keyValueList = Arrays.asList(new KeyValue(PAGE, page), new KeyValue(LIMIT, limit),
					new KeyValue("paymentStatus", PaymentStatus.PAID.getValue()),
					new KeyValue("shipmentStatus", ShipmentStatus.NOT_SHIPPED.getValue()));

			URI getOrdersUrl = getUrl(String.format(LightSpeedEndPoint.ORDERS.getValue(), marketplace.getUsername()),keyValueList);

			List<LightSpeedOrder> itrlist = getResponse(getOrdersUrl, HttpMethod.GET,
					getRequestEntity(marketplace.getAccessToken(), null)).getBody().getOrders();

			if (CollectionUtils.isEmpty(itrlist)) {
				break;
			}
			lsOrders.addAll(itrlist);
			page += 1;
		}

		// Getting orderlines
		for (LightSpeedOrder lightSpeedOrder: lsOrders) {
			lightSpeedOrder.getProducts().getResource().setEmbeddedResources(findOrderLinesByOrderId(marketplace, lightSpeedOrder.getId()));
		}

		return lsOrders;
	}

	public List<EmbeddedResource> findOrderLinesByOrderId(MarketplaceDTO marketplace, String orderId) {
		URI getOrderLinesUrl = getUrl(String.format(LightSpeedEndPoint.ORDERLINES.getValue(), marketplace.getUsername(), orderId), null);
		return getResponse(getOrderLinesUrl, HttpMethod.GET, getRequestEntity(marketplace.getAccessToken(), null)).getBody().getOrderProducts();
	}

	public List<LightSpeedOrder> getOrderByOrderNumber (MarketplaceDTO marketplace, String orderNumber) {
		List<KeyValue> keyValueList = Arrays.asList(new KeyValue("number", orderNumber));
		URI getOrderUrl = getUrl(String.format(LightSpeedEndPoint.ORDERS.getValue(), marketplace.getUsername()), keyValueList);

		List<LightSpeedOrder> lsOrders = getResponse(getOrderUrl, HttpMethod.GET, getRequestEntity(marketplace.getAccessToken(), null)).getBody().getOrders();

		// Getting orderlines
		for (LightSpeedOrder lightSpeedOrder : lsOrders) {
			lightSpeedOrder.getProducts().getResource().setEmbeddedResources(findOrderLinesByOrderId(marketplace, lightSpeedOrder.getId()));
		}
		return lsOrders;
	}

	public List<LightSpeedShipment> getOrderShipments(MarketplaceDTO marketplace, String orderId) {
		List<KeyValue> keyValueList = Arrays.asList(new KeyValue("order", orderId));
		URI getShipmentsUrl = getUrl(String.format(LightSpeedEndPoint.GET_SHIPMENT.getValue(), marketplace.getUsername()), keyValueList);
		return getResponse(getShipmentsUrl, HttpMethod.GET, getRequestEntity(marketplace.getAccessToken(), null)).getBody().getShipments();
	}

	public LightSpeedShipment createOrCancelLightSpeedShipment(MarketplaceDTO marketplace, LightSpeedShipmentRequest lsShipmentRequest, String shipmentId) {
		URI createShipmentUrl = getUrl(String.format(LightSpeedEndPoint.CREATE_OR_CANCEL_SHIPMENT.getValue(), marketplace.getUsername(), shipmentId), null);
		return getResponse(createShipmentUrl, HttpMethod.PUT, getRequestEntity(marketplace.getAccessToken(), lsShipmentRequest)).getBody().getShipment();
	}

	public void cancelLightSpeedOrder(MarketplaceDTO marketplace, LightSpeedCancelRequest lsCancelRequest, String orderId) {
		URI cancelOrderUrl = getUrl( String.format(LightSpeedEndPoint.ORDER.getValue(), marketplace.getUsername(), orderId), null);
		getResponse(cancelOrderUrl, HttpMethod.PUT, getRequestEntity(marketplace.getAccessToken(), lsCancelRequest));
	}

	public LightSpeedExternalService createExternalService(MarketplaceDTO marketplace, LightSpeedExternalServiceRequest lsExternalServiceRequest) {
		URI createExternalServiceUrl = getUrl(String.format(LightSpeedEndPoint.CREATE_EXTERNAL_SERVICE.getValue(), marketplace.getUsername()), null);
		return  getResponse(createExternalServiceUrl, HttpMethod.POST, getRequestEntity(marketplace.getAccessToken(), lsExternalServiceRequest)).getBody().getExternalService();
	}

	public List<LightSpeedExternalService> getClickShipExternalServices(MarketplaceDTO marketplace) {
		URI url = getUrl(String.format(LightSpeedEndPoint.CREATE_EXTERNAL_SERVICE.getValue(), marketplace.getUsername()), null);

		List<LightSpeedExternalService> serviceList =  getResponse(url, HttpMethod.GET, getRequestEntity(marketplace.getAccessToken(), null)).getBody().getExternalServices();

		if(CollectionUtils.isNotEmpty(serviceList)) {
			return serviceList.stream().filter(s -> StringUtils.equals(CLICKSHIP_RATES, s.getName()) && StringUtils.isNotBlank(s.getUrlEndpoint())).collect(Collectors.toList());
		}
		
		return null;
	}

	public void deleteClickShipExternalService(MarketplaceDTO marketplace, String lsExternalServiceId) {
		URI url = getUrl(String.format(LightSpeedEndPoint.DELETE_EXTERNAL_SERVICE.getValue(), marketplace.getUsername(), lsExternalServiceId), null);

		getResponse(url, HttpMethod.DELETE, getRequestEntity(marketplace.getAccessToken(), null));
	}
	
	private ResponseEntity<LightSpeedResponse> getResponse(final URI url, HttpMethod method, HttpEntity<Object> request) {
		ResponseEntity<LightSpeedResponse> responseEntity = null;
		int retryCount = 0;
		boolean retry = false;

		do {
			try {
				responseEntity = restTemplate.exchange(url, method, request, LightSpeedResponse.class);
				break;
			} catch (TooManyRequestsRestException e) {
				retryCount++;
				HttpHeaders responseHeaders = e.getResponseHeaders();

				List<String> rateRemaining = responseHeaders.get("X-RateLimit-Remaining");
				List<String> rateReset = responseHeaders.get("X-RateLimit-Reset");

				if (CollectionUtils.isNotEmpty(rateRemaining)) {
					logger.info("Too Many Requests Exception - From LightSpeed REST API: rateRemaining:{}, rateReset:{}", rateRemaining, rateReset);

					String rateRemainingStr = rateRemaining.get(0);
					String[] rateLimits = rateRemainingStr.split(BACK_SLASH);
					Integer fiveMinRateRemain = Integer.parseInt(rateLimits[0]);
					Integer hourRateRemain = Integer.parseInt(rateLimits[1]);
					Integer dayRateRemain = Integer.parseInt(rateLimits[2]);

					String rateResetStr = rateReset.get(0);
					String[] rateResets = rateResetStr.split(BACK_SLASH);
					Integer fiveMinRestInterval = Integer.parseInt(rateResets[0]);

					if (fiveMinRateRemain < 1 || hourRateRemain < 1 || dayRateRemain < 1) {
						if (dayRateRemain < 1) {
							logger.error("Too Many Requests Exception, hourly/daily API limit exhausted for LightSpeed store", e);
							throw e;
						}
						sleep(fiveMinRestInterval);
					}
				} else {
					throw e;
				}

				retry = true;
			} catch (UnauthorizedException e) {
				throw e;
			} catch (ClickshipHttpRestException e) {
				throw e;
			}

		} while (retry && retryCount <= 11);
		
		if(responseEntity == null) {
			throw new RuntimeException("Unable to get response from LightSpeed");
		}

		return responseEntity;
	}

	private HttpEntity<Object> getRequestEntity(String userToken, Object requestBody) {
		String appSecretAndToken = userToken + lightSpeedAppSecret;
		String secretKey = DigestUtils.md5Hex(appSecretAndToken);

		String token = lightSpeedAppKey + ":" + secretKey;
		String authToken = Base64.getEncoder().encodeToString(token.getBytes());

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.set(AUTHORIZATION, BASIC + authToken);

		if (requestBody != null) {
			return new HttpEntity<>(requestBody, requestHeaders);
		} else {
			return new HttpEntity<>(requestHeaders);
		}
	}

	private URI getUrl(String path, List<KeyValue> requestParams) {
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme("https");
		uriBuilder.setHost(lightspeedDomain);
		uriBuilder.setPath(path);

		if (CollectionUtils.isNotEmpty(requestParams)) {
			requestParams.forEach(pair -> uriBuilder.setParameter(pair.getKey(), String.valueOf(pair.getValue())));
		}

		try {
			return uriBuilder.build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(
					String.format("Error while constructing url:%s, path:%s", lightspeedDomain, path));
		}
	}

	private void sleep(Integer fiveMinRateRemain) {
		try {
			if (fiveMinRateRemain > 0) {
				logger.info("Sleep LightSpeed API Call for [{}] seconds", fiveMinRateRemain);
				TimeUnit.SECONDS.sleep(fiveMinRateRemain);
			}
		} catch (Exception ee) {
			logger.error("LightSpeed, Thread sleep exception while processing too many request", ee);
		}
	}
	
	public static void main(String[] args) {
		String appSecretAndToken = "dec695642b901cf1cbdcddb8b31a8ecb" + "4d77529ebd8764a2d18362fe7eb0c167";
		String secretKey = DigestUtils.md5Hex(appSecretAndToken);

		String token = "d1981928024e6c195f168782f5a6d74a" + ":" + secretKey;
		String authToken = Base64.getEncoder().encodeToString(token.getBytes());
		
		System.out.println(authToken);
	}
	
}

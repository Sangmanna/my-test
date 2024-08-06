package com.freightcom.clickship.client.magento;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;

import com.freightcom.clickship.client.auth.TokenConfig;
import com.freightcom.clickship.model.marketplace.magento.MagentoEndpoint;
import com.freightcom.clickship.model.marketplace.magento.MagentoEntity;
import com.freightcom.clickship.model.marketplace.magento.MagentoInvoice;
import com.freightcom.clickship.model.marketplace.magento.MagentoOrder;
import com.freightcom.clickship.model.marketplace.magento.MagentoOrderResponse;
import com.freightcom.clickship.model.marketplace.magento.MagentoProduct;
import com.freightcom.clickship.model.marketplace.magento.MagentoProductResponse;
import com.freightcom.clickship.model.marketplace.magento.MagentoShipmentTracking;
import com.freightcom.clickship.model.marketplace.magento.MagentoShipping;
import com.freightcom.clickship.model.marketplace.magento.MagentoStoreConfig;
import com.freightcom.clickship.model.marketplace.magento.ShippingAssignments;

@Component
public class MagentoClient {

	private static final String BATCH_SEARCH_CRITERIA = "?"
			+ "searchCriteria[filter_groups][0][filters][0][field]=updated_at&"
			+ "searchCriteria[filter_groups][0][filters][0][value]=%s&"
			+ "searchCriteria[filter_groups][0][filters][0][condition_type]=from&"
			+ "searchCriteria[filter_groups][1][filters][1][field]=updated_at&"
			+ "searchCriteria[filter_groups][1][filters][1][value]=%s&"
			+ "searchCriteria[filter_groups][1][filters][1][condition_type]=to&"
			+ "searchCriteria[sortOrders][0][direction]=ASC&"
			+ "searchCriteria[pageSize]=%s&searchCriteria[currentPage]=%s";
	
	private static final String IMPORT_SEARCH_CRITERIA = "?"
			+ "searchCriteria[sortOrders][0][field]=created_at&"
			+ "searchCriteria[sortOrders][0][direction]=ASC&"
			+ "searchCriteria[pageSize]=%s&searchCriteria[currentPage]=%s";

	private static final String IMPORT_ORDERS = "?"
			+ "searchCriteria[filter_groups][0][filters][0][field]=state&"
			+ "searchCriteria[filter_groups][0][filters][0][value]=new,processing&"
			+ "searchCriteria[filter_groups][0][filters][0][condition_type]=in&"
			+ "searchCriteria[sortOrders][0][field]=created_at&"
			+ "searchCriteria[sortOrders][0][direction]=ASC&"
			+ "searchCriteria[pageSize]=%s&searchCriteria[currentPage]=%s";
	
	private static final String SHIPMENT_SEARCH_CRITERIA = "?"
			+ "searchCriteria[filter_groups][0][filters][0][field]=order_Id&"
			+ "searchCriteria[filter_groups][0][filters][0][value]=%s&"
			+ "searchCriteria[filter_groups][0][filters][0][condition_type]=eq&";
//			+ "&fields=items[entity_id, order_id]";
	
	private static final String IMPORT_PRODUCT = "?"
			+ "searchCriteria[filter_groups][0][filters][0][field]=sku&"
			+ "searchCriteria[filter_groups][0][filters][0][value]={sku}&"
			+ "searchCriteria[filter_groups][0][filters][0][condition_type]=eq";
	
	@Autowired
	private RestTemplate restTemplate;

	public List<MagentoProduct> getProduct(TokenConfig config, String sku) {
	    DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory();
	    factory.setEncodingMode(EncodingMode.NONE);
	    URI uri = factory.uriString(getUrl(config, MagentoEndpoint.PRODUCTS, IMPORT_PRODUCT)).build(encodeParamsValue(sku));
	    
	    return restTemplate.exchange(uri, HttpMethod.GET, getAuthHeaders(config), MagentoProductResponse.class).getBody().getItems();
	}
	
	public List<MagentoProduct> importProducts(TokenConfig config, int pageSize) throws InterruptedException {
		MagentoProductResponse response = importProducts(config, String.format(IMPORT_SEARCH_CRITERIA, pageSize, 1));
		
		int totalCount = response.getTotalCount();
		List<MagentoProduct> list = response.getItems();
				
		int i=2;
		while (list.size() < totalCount) {
			list.addAll(importProducts(config, String.format(IMPORT_SEARCH_CRITERIA, pageSize, i++)).getItems());
		}

		return list;
	}
	
	public List<MagentoOrder> importOrders(TokenConfig config, int pageSize) throws InterruptedException {
		MagentoOrderResponse response = importOrders(config, String.format(IMPORT_ORDERS, pageSize, 1));
		
		int totalCount = response.getTotalCount();
		List<MagentoOrder> list = response.getItems();
		
		int i=2;
		while (list.size() < totalCount) {
			list.addAll(importOrders(config, String.format(IMPORT_ORDERS, pageSize, i++)).getItems());	
		}

		return list;
	}
	
	public List<MagentoProduct> getProductUpdates(TokenConfig config, String fromDate, String toDate, int pageSize) {
		MagentoProductResponse response = importProducts(config, String.format(BATCH_SEARCH_CRITERIA, fromDate, toDate, pageSize, 1));
		
		int totalCount = response.getTotalCount();
		List<MagentoProduct> list = response.getItems();
		
		int i=2;
		while (list.size() < totalCount) {
			list.addAll(importProducts(config, String.format(BATCH_SEARCH_CRITERIA, fromDate, toDate, pageSize, i++)).getItems());
		}
		
		return list;
	} 
	
	public List<MagentoOrder> getOrderUpdates(TokenConfig config, String fromDate, String toDate, int pageSize) {
		MagentoOrderResponse response = importOrders(config, String.format(BATCH_SEARCH_CRITERIA, fromDate, toDate, pageSize, 1));
		
		int totalCount = response.getTotalCount();
		List<MagentoOrder> list = response.getItems();
		
		int i=2;
		while (list.size() < totalCount) {
			list.addAll(importOrders(config, String.format(BATCH_SEARCH_CRITERIA, fromDate, toDate, pageSize, i++)).getItems());	
		}
		
		return list;
	}
	
	public MagentoOrder getOrder(TokenConfig config, String orderId) {
		String URL = String.format(getUrl(config, MagentoEndpoint.GET_ORDER, null), orderId);
		return restTemplate.exchange(URL, HttpMethod.GET, getAuthHeaders(config), MagentoOrder.class).getBody();
	}
	
	public ShippingAssignments getShipmentIdsByOrder(TokenConfig config, String orderId) {
		String URL = String.format(getUrl(config, MagentoEndpoint.SHIPMENTS, SHIPMENT_SEARCH_CRITERIA), orderId);
		return restTemplate.exchange(URL, HttpMethod.GET, getAuthHeaders(config), ShippingAssignments.class).getBody();
	}
	
	public MagentoShipping getShipment(TokenConfig config, String shipmentId) {
		String URL = String.format(getUrl(config, MagentoEndpoint.GET_SHIPMENT, null), shipmentId);
		return restTemplate.exchange(URL, HttpMethod.GET, getAuthHeaders(config), MagentoShipping.class).getBody();
	}
	
	public String addShipment(TokenConfig config, String magentoOrderId, MagentoShipping shipping) {
		String URL = String.format(getUrl(config, MagentoEndpoint.ADD_SHIPMENT, null), magentoOrderId);
		
        HttpHeaders requestHeaders = getHeadersWithContentType();
        requestHeaders.set("Authorization", "Bearer "+config.getToken());
        HttpEntity<Object> requestEntity = new HttpEntity<>(shipping, requestHeaders);

        String shipmentId = restTemplate.exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody();
        return StringUtils.strip(shipmentId, "\"");
	}
	
	public MagentoShipmentTracking addTrackingToShipment(TokenConfig config, MagentoEntity entity) {
		String URL = String.format(getUrl(config, MagentoEndpoint.ADD_TRACKING_TO_SHIPMENT, null));
		
        HttpHeaders requestHeaders = getHeadersWithContentType();
        requestHeaders.set("Authorization", "Bearer "+config.getToken());
        HttpEntity<Object> requestEntity = new HttpEntity<>(entity, requestHeaders);

       return restTemplate.exchange(URL, HttpMethod.POST, requestEntity, MagentoShipmentTracking.class).getBody();
	}
	
	public String createInvoiceToOrder(TokenConfig config, MagentoInvoice invoice, String orderId) {
		String URL = String.format(getUrl(config, MagentoEndpoint.CREATE_INVOICE, null), orderId);
		
        HttpHeaders requestHeaders = getHeadersWithContentType();
        requestHeaders.set("Authorization", "Bearer "+config.getToken());
        HttpEntity<Object> requestEntity = new HttpEntity<>(invoice, requestHeaders);

        return StringUtils.strip(restTemplate.exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody(), "\"");
	}
	
	public boolean deleteTrackingFromShipment(TokenConfig config, String trackingId) {
		String URL = String.format(getUrl(config, MagentoEndpoint.DELETE_TRACKING_FROM_SHIPMENT, null), trackingId);
		return restTemplate.exchange(URL, HttpMethod.DELETE, getAuthHeaders(config), Boolean.class).getBody();
	}
	
	public boolean cancelOrder(TokenConfig config, String magentoOrderId) {
		String URL = String.format(getUrl(config, MagentoEndpoint.ORDER_CANCEL, null), magentoOrderId);
		return restTemplate.postForEntity(URL, getAuthHeaders(config), Boolean.class).getBody();
	}
	
	public String genrateToken(TokenConfig config) {
        String URL = getUrl(config, MagentoEndpoint.GENERATE_TOKEN, null);
        HttpHeaders requestHeaders = getHeadersWithContentType();
        HttpEntity<Object> requestEntity = new HttpEntity<>(config, requestHeaders);
        
        return StringUtils.strip(restTemplate.exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody(), "\"");
	}
	
	public List<MagentoStoreConfig> getStoreConfigs(TokenConfig config) {
		ParameterizedTypeReference<List<MagentoStoreConfig>> 
			storeConfigs = new ParameterizedTypeReference<List<MagentoStoreConfig>>() { };
		
		String URL = getUrl(config, MagentoEndpoint.CONFIG, null);
		return restTemplate.exchange(URL, HttpMethod.GET, getAuthHeaders(config), storeConfigs).getBody();
	}
	
	private MagentoOrderResponse importOrders(TokenConfig config, String searchCriteria) {
		String URL = getUrl(config, MagentoEndpoint.ORDERS, searchCriteria);
		return restTemplate.exchange(URL, HttpMethod.GET, getAuthHeaders(config), MagentoOrderResponse.class).getBody();
	}
	
	private MagentoProductResponse importProducts(TokenConfig config, String searchCriteria) {
		String URL = getUrl(config, MagentoEndpoint.PRODUCTS, searchCriteria);
		return restTemplate.exchange(URL, HttpMethod.GET, getAuthHeaders(config), MagentoProductResponse.class).getBody();
	}
	
	private String getUrl(TokenConfig config, MagentoEndpoint uri, String searchCriteria) {
		StringBuilder builder = new StringBuilder(config.getUrl()).append(uri.getValue());
				
		if(StringUtils.isNotBlank(searchCriteria)) {
			builder.append(searchCriteria);
		}
		
		return builder.toString();
	}
	
	private HttpEntity<Object> getAuthHeaders(TokenConfig config){
        HttpHeaders requestHeaders = getHeadersWithContentType();
        requestHeaders.set("Authorization", "Bearer "+config.getToken());
        return new HttpEntity<>(requestHeaders);
	}
	
/*	private static int getTotalPages(int totalCount, int pageSize) {
		return totalCount/pageSize + (totalCount%pageSize > 0 ? 1 : 0);
	} */
	
	private HttpHeaders getHeadersWithContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return requestHeaders;
	}
	
	private static String encodeParamsValue(String parmsValue) {
		try {
			return URLEncoder.encode(parmsValue, StandardCharsets.UTF_8.displayName());
		} catch (UnsupportedEncodingException e) {
			return parmsValue;
		}
	}
	
	public void replaceRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}

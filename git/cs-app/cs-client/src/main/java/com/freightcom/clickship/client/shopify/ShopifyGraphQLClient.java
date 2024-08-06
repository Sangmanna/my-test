
package com.freightcom.clickship.client.shopify;

/**import java.io.IOException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.http.HttpHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;

import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freightcom.clickship.model.exception.marketplace.MarketplaceRuntimeException;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyRecurringCharge;
import com.freightcom.clickship.model.marketplace.shopify.graphql.AppPlanInput;
import com.freightcom.clickship.model.marketplace.shopify.graphql.AppPricingInterval;
import com.freightcom.clickship.model.marketplace.shopify.graphql.AppRecurringPricingInput;
import com.freightcom.clickship.model.marketplace.shopify.graphql.AppSubscriptionCancelGraphQLQuery;
import com.freightcom.clickship.model.marketplace.shopify.graphql.AppSubscriptionCreateGraphQLQuery;
import com.freightcom.clickship.model.marketplace.shopify.graphql.AppSubscriptionLineItemInput;
import com.freightcom.clickship.model.marketplace.shopify.graphql.CurrencyCode;
import com.freightcom.clickship.model.marketplace.shopify.graphql.MoneyInput; **/

import org.springframework.stereotype.Component;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyRecurringCharge;
//import com.freightcom.clickship.model.marketplace.shopify.graphql.ShopifyGraphQLResponse;
/** import com.freightcom.clickship.model.util.Security;
import com.netflix.graphql.dgs.client.GraphQLResponse;
import com.netflix.graphql.dgs.client.MonoGraphQLClient;
//import com.netflix.graphql.dgs.client.WebClientGraphQLClient;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;**/

@Component
public class ShopifyGraphQLClient {
	
/**	private Logger logger = LogManager.getLogger(this.getClass());
	
	private static final String GRAPHQL_URL = "https://%s/admin/api/%s/graphql.json";

	@Value("${shopify.api.version}")
	private String version;

	private ObjectMapper objectMapper;
	
	@Autowired
	public ShopifyGraphQLClient(ObjectMapper objectMapper) {
		super();
		this.objectMapper = objectMapper;
	} */
	
//	public ShopifyGraphQLResponse createRecurringChargeDGSClient(MarketplaceDTO marketplace, ShopifyRecurringCharge charges) {
/**		WebClientGraphQLClient client = getClient(marketplace);

		AppSubscriptionCreateGraphQLQuery graphQLQuery = AppSubscriptionCreateGraphQLQuery.newRequest()
				.name(charges.getName()).test(charges.getTest())
				.returnUrl(charges.getReturnUrl()).trialDays(charges.getTrialDays())
				.lineItems(Arrays.asList(getSubscriptionLineItem(charges.getPrice(), charges.getCurrency()))).build();

		// Due to JAVA version dependency Projections are constructing in OLD string style. 
		// Once java 21 migration is completed we need to delete the OLD style use 
		// *Projection*.java class directly. 
		String query = new GraphQLQueryRequest(graphQLQuery, null).serialize();
		String finalQuery = appendProjection(query);

		logger.info("SHOPIFY Request: {}", finalQuery);
		
		// The GraphQLResponse contains data and errors.
		GraphQLResponse graphQLResponse = client.reactiveExecuteQuery(finalQuery).block();

		if (graphQLResponse == null) {
			throw new MarketplaceRuntimeException("NO RESPONSE FROM SHOPIFY");
		}
		
		logger.info("SHOPIFY Response: {}", graphQLResponse.getJson());
		
		return fromJson(graphQLResponse.getJson(), ShopifyGraphQLResponse.class);*/
		
//		return null;
//	}
	
//	public ShopifyGraphQLResponse cancelRecurringChargeDGSClient(MarketplaceDTO marketplace, String id) {
/**		WebClientGraphQLClient client = getClient(marketplace);

		AppSubscriptionCancelGraphQLQuery graphQLQuery = AppSubscriptionCancelGraphQLQuery.newRequest().id(id).build();
		
		// Due to JAVA version dependency Projections are constructing in OLD string style. 
		// Once java 21 migration is completed we need to delete the OLD style use 
		// *Projection*.java class directly. 
		String query = new GraphQLQueryRequest(graphQLQuery, null).serialize();
		String finalQuery = appendCancelProjection(query);
		
		logger.info("SHOPIFY Request: {}", finalQuery);

		// The GraphQLResponse contains data and errors.
		GraphQLResponse graphQLResponse = client.reactiveExecuteQuery(finalQuery).block();

		if(graphQLResponse == null) {
			throw new MarketplaceRuntimeException("NO RESPONSE FROM SHOPIFY");
		}
		
		logger.info("SHOPIFY Response: {}", graphQLResponse.getJson());
		
		return fromJson(graphQLResponse.getJson(), ShopifyGraphQLResponse.class);*/
		
//		return null;
//	}

/**	private static AppSubscriptionLineItemInput getSubscriptionLineItem(double amount, String currency) {
		AppPlanInput planInput = AppPlanInput.newBuilder().appRecurringPricingDetails(getRecurringPricingInput(amount, currency)).build();
		return AppSubscriptionLineItemInput.newBuilder().plan(planInput).build();
	}
	
	private static AppRecurringPricingInput getRecurringPricingInput(double amount, String currency) {
		// Using CAD currency by default.  
		MoneyInput moneyInput = MoneyInput.newBuilder().amount(amount).currencyCode(CurrencyCode.valueOf(currency)).build();
		return AppRecurringPricingInput.newBuilder().price(moneyInput).interval(AppPricingInterval.EVERY_30_DAYS).build();
	}
	
	// Once java 21 migration is completed we need to delete this OLD style and use 
	// *Projection*.java class directly.
	private String appendProjection(String query) {
		String projection = "{\r\n"
				+ "        confirmationUrl \r\n"
				+ "        userErrors {\r\n"
				+ "            field\r\n"
				+ "            message\r\n"
				+ "        }\r\n"
				+ "        appSubscription {\r\n"
				+ "            createdAt\r\n"
				+ "            currentPeriodEnd\r\n"
				+ "            id\r\n"
				+ "            name\r\n"
				+ "            returnUrl\r\n"
				+ "            status\r\n"
				+ "            test\r\n"
				+ "            trialDays\r\n"
				+ "            lineItems {\r\n"
				+ "                id\r\n"
				+ "            }\r\n"
				+ "        }\r\n"
				+ "    }";
		
		char characterToFind = '}';
		
        // Find the last index of the specified character
        int lastIndex = query.lastIndexOf(characterToFind);

        // If the character is found, append the substring after it
        if (lastIndex != -1) {
        	String queryOrMutation = query.substring(0, lastIndex - 1);
        	String closeBraces = query.substring(lastIndex - 1);
        	
            return queryOrMutation + projection + closeBraces;
        } 
        
        return query;
    }
	
	// Once java 21 migration is completed we need to delete this OLD style and use 
	// *Projection*.java class directly.
	private String appendCancelProjection(String query) {
		String projection = "{\r\n"
				+ "    userErrors {\r\n"
				+ "      field\r\n"
				+ "      message\r\n"
				+ "    }\r\n"
				+ "    appSubscription {\r\n"
				+ "      id\r\n"
				+ "      status\r\n"
				+ "    }\r\n"
				+ "}";
		
		char characterToFind = '}';
		
        // Find the last index of the specified character
        int lastIndex = query.lastIndexOf(characterToFind);

        // If the character is found, append the substring after it
        if (lastIndex != -1) {
        	String queryOrMutation = query.substring(0, lastIndex - 1);
        	String closeBraces = query.substring(lastIndex - 1);
        	
            return queryOrMutation + projection + closeBraces;
        } 
        
        return query;
    }
	
	private WebClientGraphQLClient getClient(MarketplaceDTO marketplace) {
    	String baseURL = String.format(GRAPHQL_URL, marketplace.getUrl(), version);
		
		WebClient webClient = WebClient.builder().baseUrl(baseURL)
				.defaultHeader(HttpHeader.CONTENT_TYPE.asString(), MediaType.APPLICATION_JSON.toString())
				.defaultHeader("X-Shopify-Access-Token", Security.decryptPII(marketplace.getAccessToken()))
				.build();
		
	    return MonoGraphQLClient.createWithWebClient(webClient);
	}
	
	private <R> R fromJson(String json, Class<R> returnType) {
		try {
			return objectMapper.readValue(json, returnType);
		} catch (IOException e) {
			String msg = String.format("Exception while converting string to Entity. Error: %s", e.getMessage());
			throw new RuntimeException(msg, e);
		}
	} **/

}
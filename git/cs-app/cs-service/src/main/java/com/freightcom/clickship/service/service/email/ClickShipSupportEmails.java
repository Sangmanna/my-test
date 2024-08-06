package com.freightcom.clickship.service.service.email;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.model.carrier.NewCarrierRequestDTO;

@Component
public class ClickShipSupportEmails {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	private static final String SEMI_COLON = ";";
	private static final String GENERIC_ID = "genericId";
	private static final String STACK_TRACE = "stackTrace";
	private static final String SUPPORT = "email to support team";
	private static final String DEVELOPERS = "email to developers";
	private static final String EMAIL_ERROR = "Email error - Unable to send";
	private static final String CUSTOMER_EXCEPTION = " customer exception notification";
	private static final String SUBJECT_NET_TERM_REQUEST = "Net Term customer - %s - %s - %s ";
	private static final String SHOPIFY_GDPR_WEBHOOK_REQUEST = " shopify webhook GDPR webhook request ";
	private static final String SHOPIFY_WEBHOOK_PROCESS_FAILURE = " shopify webhook event processing failure notification ";
	private static final String ORDER_LATEST_ORDER_UPDATE_FAILURE = " marketplace import latest order failure notification ";
	private static final String EBAY_DELETE_STORE_REQUEST_PROCESS_FAILURE = " eBay delete store request process failure notification ";
	
	@Value("${internal.email.developers}")
	public String developersEmails;
	
	@Value("${server.domain}")
	private String clickshipDomain;

	@Value("${clickship.support.toemail.address}")
	private String supportToEmail;
	
	@Value("${mailchimp.mandrill.netterms.customer.email.template}")
	private String netTermCustomerTemplate;
	
	@Value("${customer.new.carrier.request.template}")
	private String customerNewCarrierRequestTemplate;
	
	@Value("${customer.exception.notification.template}")
	private String customerExceptionNotificationTemplate;
	
	@Value("${delete.marketplace.request.notification.template:customer-received-exception}")
	private String deleteMarketplaceRequestNotificationTemplate;
	
	@Autowired
	private MailChimpEmailUtil emailUtil;

	public void sendNettermsRequestEmail(String...strings) {
		String subject = String.format(SUBJECT_NET_TERM_REQUEST, strings[0], strings[1], strings[2]);

		Map<String, Object> param = new HashMap<>();
		param.put("name", strings[0]);
		param.put("email", strings[1]);
		param.put("phone", strings[2]);

		emailUtil.sendEmail(supportToEmail, subject, netTermCustomerTemplate, false, param, null);
	}
	
	public void newCarrierRequestEmail(Customer customer, NewCarrierRequestDTO dto, String newCarrierRequested, String toEmail) {
		try {
			String[] toEmails = new StringBuilder(toEmail).toString().split(SEMI_COLON);

			Map<String, Object> content = new HashMap<>();
			
			content.put("email", dto.getEmail());
			content.put("salesRepName", dto.getName());
			content.put("requestedCarrier", newCarrierRequested);
			content.put("businessName", customer.getBusinessName()); 

			emailUtil.sendEmail(toEmails, null, customerNewCarrierRequestTemplate, true, content, null);
		} catch (Exception e){
			String message = String.format(
					EMAIL_ERROR + SUPPORT + " - Sending ICS Carrier Request email for customer:[{}] to Sales rep:[{}], Error: [%s]",
					customer.getBusinessName(), dto.getName(), e.getMessage());
			logger.error(message, e);
		}
	}
	
	public void sendEmailToDevelopersForExceptionRecievedByCustomer(String genericId, Exception exception) {
		try {
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			exception.printStackTrace(printWriter);
			String stackTrace = stringWriter.toString();

			String subject = clickshipDomain + "- An exception for the ID: " + genericId;

			Map<String, Object> content = new HashMap<>();
			content.put(GENERIC_ID, genericId);
			content.put(STACK_TRACE, stackTrace);

			emailUtil.sendEmail(developersEmails.split(SEMI_COLON), subject, customerExceptionNotificationTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + CUSTOMER_EXCEPTION + DEVELOPERS + " genericId:[{}] ", genericId, e);
		}
	}
	
	public void sendEmailToDevelopersDeleteMarketplaceRequestReceied(Marketplace marketplace) {
		try {
			String subject = clickshipDomain + "Received marketplace delete request - store: '" + marketplace.getStoreUrl() + "'";
		
			Map<String, Object> content = new HashMap<>();
			content.put(GENERIC_ID, marketplace.getId());
			content.put(STACK_TRACE, marketplace.getAliasName() +" --> "+marketplace.getStoreUrl());

			String[] toEmails = developersEmails.split(SEMI_COLON);
			emailUtil.sendEmail(toEmails, subject, deleteMarketplaceRequestNotificationTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	public void sendEmailToDevelopersForMissingImportJobStatus(Marketplace marketplace, String request, List<String> ids) {
		try {
			String subject = "Import missing " + request +" request completed - " + marketplace.getMarketplaceType().getName() + " store: '" + marketplace.getStoreUrl() + "'";
			
			Map<String, Object> content = new HashMap<>();
			content.put(GENERIC_ID, marketplace.getId());
			content.put(STACK_TRACE, ids.toString());

			emailUtil.sendEmail(developersEmails.split(SEMI_COLON), subject, deleteMarketplaceRequestNotificationTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + ORDER_LATEST_ORDER_UPDATE_FAILURE + DEVELOPERS + " - marketplaceUrl:[{}] ", marketplace.getStoreUrl(), e);
		}
	}
	
	public void sendEmailToDevelopersForEbayDeleteStoreRequestFailure(String ebaySignature, String payload, Exception exception) {
		try {
			String subject = clickshipDomain + "- An exception while processing eBay delete store request";
			
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			exception.printStackTrace(printWriter);
			String stackTrace = stringWriter.toString();

			Map<String, Object> content = new HashMap<>();
			content.put(GENERIC_ID, ebaySignature +  " -> " + payload);
			content.put(STACK_TRACE, stackTrace);

			emailUtil.sendEmail(developersEmails.split(SEMI_COLON), subject, customerExceptionNotificationTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + EBAY_DELETE_STORE_REQUEST_PROCESS_FAILURE + DEVELOPERS, e);
		}
	}
	
	public void sendEmailToDevelopersForShopifyWebhookFailure(Map<String, Object> content) {
		try {
			String subject = clickshipDomain + "- Unable to process shopify web hook event";
			emailUtil.sendEmail(developersEmails.split(SEMI_COLON), subject, customerExceptionNotificationTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + SHOPIFY_WEBHOOK_PROCESS_FAILURE + DEVELOPERS + " content:[{}] ", content, e);
		}
	}
	
	public void sendEmailToDevelopersWithShopifyGDPRCustomerDataRequestWebhookDetails(String action, String storeUrl, String json) {
		try {
			String subject = clickshipDomain + "- Received "+ action + " shopify GDPR webhook request";
			
			Map<String, Object> content = new HashMap<>();
			content.put(GENERIC_ID, storeUrl);
			content.put(STACK_TRACE, json);

			emailUtil.sendEmail(developersEmails.split(SEMI_COLON), subject, customerExceptionNotificationTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + SHOPIFY_GDPR_WEBHOOK_REQUEST + DEVELOPERS + " content:[{}] ", json, e);
		}
	}
	
	public void sendEmailToDevelopersForShopifyGDPTRequestFailure(String requestType, String storeUrl, Exception exception) {
		try {
			String subject = clickshipDomain + "- An exception while processing Shopify store " + requestType;
			
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			exception.printStackTrace(printWriter);
			String stackTrace = stringWriter.toString();

			Map<String, Object> content = new HashMap<>();
			content.put(GENERIC_ID, storeUrl);
			content.put(STACK_TRACE, stackTrace);

			emailUtil.sendEmail(developersEmails.split(SEMI_COLON), subject, customerExceptionNotificationTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + SHOPIFY_GDPR_WEBHOOK_REQUEST + DEVELOPERS, e);
		}
	}
	
}

package com.freightcom.clickship.service.service.email;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Code;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceProduct;
import com.freightcom.clickship.data.entity.MarketplaceSetting;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Orderline;
import com.freightcom.clickship.data.entity.Package;
import com.freightcom.clickship.data.entity.Shipment;
import com.freightcom.clickship.data.rep.CustomerAddressRepository;
import com.freightcom.clickship.data.rep.MarketplaceSettingRepository;
import com.freightcom.clickship.model.NMFCCodeRequestDTO;
import com.freightcom.clickship.model.box.BoxDTO;
import com.freightcom.clickship.model.carrier.NewCarrierRequestDTO;
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.enums.AddressType;
import com.freightcom.clickship.model.enums.InsuranceType;
import com.freightcom.clickship.model.mandrill.MandrillOrderline;
import com.freightcom.clickship.model.mandrill.MandrillPackage;
import com.freightcom.clickship.model.mandrill.MandrillPackageDetails;
import com.freightcom.clickship.model.order.OrderDTO;
import com.freightcom.clickship.model.util.ClickshipStringUtil;
import com.freightcom.clickship.model.util.CopyUtil;
import com.freightcom.clickship.service.service.CustomBrandingService;
import com.freightcom.clickship.service.service.MarketplaceSettingService;
import com.freightcom.clickship.service.service.impl.CodeServiceImpl;

@Component
public class SendEmailUtil {

	private Logger logger = LogManager.getLogger(SendEmailUtil.class);

	private static final String SEMI_COLON = ";";

	private static final String EMAIL_ERROR = "Email error - Unable to send";

	private static final String SHIPMENT_DETAILS = " shipment details ";
	private static final String STORE_DELETE = " marketplace delete notification ";
	private static final String FULFILL_FAILURE = " order fulfilment failure notification ";
	private static final String SPLIT_ORDER_UPDATE_NOTIFICATION = " split order update notitication ";
	private static final String INTEGRATION_SUCCESS = " marketplace integration success notification ";
	private static final String INTEGRATION_FAILURE = " marketplace integration failure notification ";
	
	private static final String COMBINE_ORDER_UPDATE_NOTIFICATION = " combine order update notitication ";
	private static final String COMBINE_ORDER_CANCEL_NOTIFICATION = " combine order cancel notitication ";
	private static final String PROCESSING_UNBILLED_CHARGES_FAILURE = " chargebee unbilled process failure notification ";
	
	private static final String ORDER_LATEST_ORDER_UPDATE_FAILURE = " marketplace import latest order failure notification ";

	private static final String OWNER = "email to store owner";
	private static final String SUPPORT = "email to support team";
	private static final String DEVELOPERS = "email to developers";
	
	@Value("${internal.email.ceo}")
	public String ceo;

	@Value("${internal.email.sales}")
	public String sales;
	
	@Value("${internal.email.cc}")
	public String ccEmails;
	
	@Value("${internal.email.developers}")
	public String developers;
	
	@Value("${internal.email.accounting}")
	private String accounting;
	
	@Value("${internal.email.tech.support}")
	public String techSupport;
	
	@Value("${internal.email.customer.service}")
	public String customerService;
	
	@Value("${internal.email.new.notification}")
	public String newNotification;

	@Value("${new.order.imported.tmpl.name}")
	private String newOrderImportedTemplate;

	@Value("${mailchip.mandrill.integration.failure.template}")
	private String integrationFailureTemplate;

	@Value("${shipment.unsuccessful.tmpl.name}")
	private String unSuccessfulShipmentTemplate;

	@Value("${shop.interface.end.template.name}")
	private String integrationSuccessEmailTemplate;
	
	@Value("${shop.delete.template.name:delete-marketplace-notification-to-customer}")
	private String integrationDeleteEmailTemplate;

	@Value("${shipment.details.store.owner.template}")
	private String shipmentDetailsStoreOwnerTemplate;

	@Value("${marketplace.integration.failure.notification.support.template}")
	private String integrationFailureSupportTemplate;

	@Value("${customer.exception.notification.template}")
	private String customerExceptionNotificationTemplate;
	
	@Value("${marketplace.integration.success.notification.support.template}")
	private String integrationSuccessSupportEmailTemplate;

//	@Value("${mailchimp.mandrill.order.shipped.email.template}")
//	private String mailChimpMandrillOrderShippedEmailTemplate;

	@Value("${shipment.details.store.owner.customer.template}")
	private String shipmentDetailsStoreOwnerCustomerTemplate;

	@Value("${clickship.new.user.registration.notification.template}")
	private String clickshipNewUserRegistrationNotificationTemplate;
	
	@Value("${split.order.update.review.notification.template}")
	private String splitOrderUpdateReviewNotificationTemplate;
	
	@Value("${combine.order.update.review.notification.template}")
	private String combineOrderUpdateReviewNotificationTemplate;
	
	@Value("${combine.order.deleted.notification.template}")
	private String combineOrderCancelNotificationTemplate;
	
	@Value("${ics.request.volume.shipping.template}")
	private String requestIcsHighVolumeShippingTemplate;

	@Value("${v2.manual.shipment.quote.request.template}")
	private String quoteRequestTemplate;
	
	@Value("${nmfc-code-request-email.template}")
	private String nmfcCodeRequestTemplate;
	
	@Value("${server.domain}")
	private String clickshipDomain;
	
	@Autowired
	private CodeServiceImpl codeService;

	@Autowired
	private MailChimpEmailUtil mailChipEmailUtil;
	
	@Autowired
	private MarketplaceSettingService settingService;

	@Autowired
	private CustomBrandingService customerPreferencesService;
	
	@Autowired
	private MarketplaceSettingRepository marketplaceSettingRepository;
	
	@Autowired
	private CustomerAddressRepository customerAddressRepository;

	public void sendEmailForOrderFulfill(boolean isSuccess, Order order, Marketplace marketplace) {

		if (isSuccess) {
			sendSuccessfullOrderEmail(order, marketplace);
		} else {
			sendUnsuccessfullOrderEmail(order, marketplace);
		}
	}

	private void sendSuccessfullOrderEmail(Order order, Marketplace marketplace) {
		MarketplaceSetting marketplaceSetting = settingService.getMarketplaceSettingByMarketplace(marketplace);

		if (marketplaceSetting != null) {
			String successfullShipmentEmail = marketplaceSetting.getEmailAddressSuccessfulOrder();

			if (StringUtils.isNotEmpty(successfullShipmentEmail)) {
				sendShipmentDetailsToStoreOwner(order, marketplace, marketplaceSetting);
			}

			if (marketplaceSetting.isAutoSendShippingToCustomer()) {
				sendShipmentDetailsToStoreOwnerCustomer(order);
			}
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public void sendShipmentDetailsToStoreOwnerCustomer(Order order) {
		
		Customer customer = order.getCustomer();
		Shipment shipment = order.getShipment();
		String orderNumber = order.getOrderNumber();

		if (shipment != null) {
			String email = shipment.getShiptoEmail();
			String uom = ClickShipConstants.UNIT_IMPERIAL;
			
			if (order.getMarketplace() != null) {
				uom = settingService.getMarketplaceSettingByMarketplace(order.getMarketplace()).getUnitOfMeasure();
			}

			Map<String, Object> content = new HashMap<String, Object>();

			content.put("orderNumber", order.getOrderNumber());
			List<MandrillPackage> list = getMandrillPackages(shipment, uom);
			content.put("packages", list);
			content.put("packageCount", "" + list.size());
			
			if(order.getMarketplace() != null) {
				content.put("orderUrl", getOrderUrl(order.getOrderNumber()));
				content.put("storeUrl", order.getMarketplace().getStoreUrl());
				List<MandrillOrderline> oList = getMandrillOrderlines(order);
				List<MandrillOrderline> firstThree = oList.stream().limit(3).collect(Collectors.toList());
				content.put("orderLines", oList.stream().limit(3).collect(Collectors.toList()));
				
				if (oList.size() - firstThree.size() > 0) {
					content.put("additionalCount", oList.size() - firstThree.size());
				}
			}
			
			content.put("customerAddress", getCustomerFullRegistrationAddress(customer));
			content.put("shipfromEmail", shipment.getShipfromEmail());
			content.put("shipfromPhone", shipment.getShipfromPhone());
			content.put("businessName", customer.getBusinessName());
			content.put("trackingURL", shipment.getTrackingURL());

			content.put("clickshipDomain", clickshipDomain);
			content.putAll(customerPreferencesService.getBrandingEmbeddedDetails(shipment.getCustomer()));
			
			String subject = (String) content.get("subject");
			if (StringUtils.isBlank(subject)) {
				subject = String.format("Order #%s: Thank you for your order!", order.getOrderNumber());
			}			
			
			if (StringUtils.isNotBlank(email)) {
				try {
					//mailChipEmailUtil.sendEmail(email, subject, mailChimpMandrillOrderShippedEmailTemplate, true,	content, null);
					 mailChipEmailUtil.sendEmail(email, subject, shipmentDetailsStoreOwnerCustomerTemplate, true, content, null);
				} catch (Exception e) {
					logger.error("{} {} {} customer:[{}], order:[{}]",
							EMAIL_ERROR, SHIPMENT_DETAILS, OWNER, customer.getBusinessName(), orderNumber, e);
				}
			}
		} else {
			logger.error("{} {} {} due to shipment details not available - customer:[{}], order:[{}]",
					EMAIL_ERROR, SHIPMENT_DETAILS, OWNER, customer.getBusinessName(), orderNumber);
		}
	}

	private String getCustomerFullRegistrationAddress(Customer customer) {
	    CustomerAddress customerAddress = customerAddressRepository.findAllByCustomerAndAddressType(customer, AddressType.REG.toString()).get(0);

	    StringBuilder addressBuilder = new StringBuilder();
	    addressBuilder.append(customerAddress.getAddress1()).append(", ");

	    if (customerAddress.getAddress2() != null && !customerAddress.getAddress2().isEmpty()) {
	        addressBuilder.append(customerAddress.getAddress2()).append(", ");
	    }

	    addressBuilder.append(customerAddress.getCity()).append(", ");
	    addressBuilder.append(customerAddress.getProvinceState()).append(", ");
	    addressBuilder.append(customerAddress.getCountry()).append(", ");
	    addressBuilder.append(customerAddress.getPostalCode());

	    return addressBuilder.toString();
	}


	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	private void sendShipmentDetailsToStoreOwner(Order order, Marketplace marketplace, MarketplaceSetting marketplaceSetting) {
		String type = marketplace.getMarketplaceType().getName();
		
		String orderNumber = order.getOrderNumber();
		String storeUrl = marketplace.getStoreUrl();
		String storeOwnerEmail = marketplaceSetting.getEmailAddressSuccessfulOrder();
		String subject = String.format("%s Order #%s: Shipping Details", marketplace.getAliasName(), orderNumber);
		
		Map<String, Object> content = new HashMap<String, Object>();
		
		content.put("storeUrl", storeUrl);
		content.put("orderNumber", orderNumber);
		content.put("orderLines", getMandrillOrderlines(order));
		content.put("marketplaceName", marketplace.getAliasName());
		content.put("orderUrl", getOrderUrl(order.getOrderNumber()));
		content.put("marketplaceType", StringUtils.contains(type, "Amazon") ? "Amazon" : type);
		content.put("packages", getMandrillPackages(order.getShipment(), marketplaceSetting.getUnitOfMeasure()));
		content.put("orderTotal", "$" + String.format("%.2f", order.getTotal()) + " " + order.getCostCurrency());
		content.put("shippingCost", "$" + String.format("%.2f", order.getShippingCost()) + " " + order.getShippingCurrency());
		
		if (ClickshipStringUtil.isNotEmpty(order.getShipment().getFreightcomOrderId())) {
			content.put("freightcomOrderId", order.getShipment().getFreightcomOrderId());
		}

		content.putAll(customerPreferencesService.getBrandingEmbeddedDetails(marketplace.getCustomer()));

		String[] emails = storeOwnerEmail.split(SEMI_COLON);

		if (emails.length > 0) {
			try {
				mailChipEmailUtil.sendEmail(emails, subject, shipmentDetailsStoreOwnerTemplate, true, content, null);
			} catch (Exception e) {
				logger.error(EMAIL_ERROR + SHIPMENT_DETAILS + OWNER + " - marketplace:[{}], order:[{}]", storeUrl, orderNumber, e);
			}
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	private void sendUnsuccessfullOrderEmail(Order order, Marketplace marketplace) {
		MarketplaceSetting marketplaceSetting = settingService.getMarketplaceSettingByMarketplace(marketplace);

		if (marketplaceSetting != null) {
			String failureEmail = marketplaceSetting.getEmailAddressUnsuccessfulOrder();

			if (StringUtils.isNotEmpty(failureEmail)) {
				String subject = String.format("Fulfillment failed for order#%s", order.getOrderNumber());

				Map<String, Object> param = new HashMap<String, Object>();
				
				param.put("orderNumber", order.getOrderNumber());
				param.put("marketplaceName", marketplace.getAliasName());
				param.put("orderUrl", getOrderUrl(order.getOrderNumber()));
				
				param.putAll(customerPreferencesService.getBrandingEmbeddedDetails(marketplace.getCustomer()));
				
				try {
					mailChipEmailUtil.sendEmail(failureEmail, subject, unSuccessfulShipmentTemplate, true, param, null);
				} catch (Exception e) {
					logger.error(EMAIL_ERROR + FULFILL_FAILURE + " - marketplace:[{}], order:[{}]",
							marketplace.getStoreUrl(), order.getOrderNumber(), e);
				}
			}
		}
	}

	public void sendEmailToUserForIntegrationSuccess(Marketplace marketplace) {
		String userEmail = null;

		try {
			String subject = "ClickShip integration for " + marketplace.getAliasName() + " successful!";
			userEmail = marketplace.getCustomer().getEmail();
			
			Map<String, Object> content = new HashMap<String, Object>();
			getMarketplaceContent(marketplace, content);
			content.putAll(customerPreferencesService.getBrandingEmbeddedDetails(marketplace.getCustomer()));
			
			mailChipEmailUtil.sendEmail(userEmail, subject, integrationSuccessEmailTemplate, true, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + INTEGRATION_SUCCESS + " - marketplaceUrl:[{}], email:[{}]", marketplace.getStoreUrl(), userEmail, e);
		}

		sendEmailToSupportForIntegrationSuccess(marketplace);
	}
	
	public void sendDeleteMarketplaceSuccessEmailToUser(String aliasName, String storeUrl, String email) {
		try {
			String subject ="Your " + aliasName + " store delete request processed successfully!";
			
			Map<String, Object> content = new HashMap<String, Object>();
			content.put("storeUrl", storeUrl);
			content.put("aliasName", aliasName);
						
			mailChipEmailUtil.sendEmail(email, subject, integrationDeleteEmailTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + STORE_DELETE + " - marketplaceUrl:[{}], email:[{}]", storeUrl, email, e);
		}
	}

	public void sendEmailToSupportForIntegrationSuccess(Marketplace marketplace) {
		try {
			Map<String, Object> content = new HashMap<String, Object>();
			getMarketplaceContent(marketplace, content);
			getCustomerContent(marketplace.getCustomer(), content);
			content.put("userName", marketplace.getCreatedBy());

			mailChipEmailUtil.sendEmail(newNotification.split(SEMI_COLON), null, integrationSuccessSupportEmailTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + INTEGRATION_SUCCESS + SUPPORT + " - marketplaceUrl:[{}], Error: [{}]", marketplace.getStoreUrl(), e.getMessage(), e);
		}
	}

	public void sendEmailForIntegrationFailure(String userName, Marketplace marketplace, String exception) {
		String email = marketplace.getCustomer().getEmail();
		try {
			Map<String, Object> content = new HashMap<>();
			getMarketplaceContent(marketplace, content);
			
			mailChipEmailUtil.sendEmail(email, null, integrationFailureTemplate, true, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + INTEGRATION_FAILURE + " - marketplaceUrl:[{}], email:[{}]", marketplace.getStoreUrl(), email, e);
		}

		sendEmailToSupportForIntegrationFailure(userName, marketplace, exception);
	}

	public void sendEmailToSupportForIntegrationFailure(String userName, Marketplace marketplace, String exception) {
		try {
			Customer customer = marketplace.getCustomer();
			StringBuilder emails = new StringBuilder(newNotification).append(SEMI_COLON).append(techSupport);
			String subject = clickshipDomain + "ClickShip integration failed for " + marketplace.getMarketplaceType().getName() + " store: '" + marketplace.getStoreUrl() + "'";

			Map<String, Object> content = new HashMap<String, Object>();
			getMarketplaceContent(marketplace, content);
			getCustomerContent(customer, content);
			content.put("userName", userName);

			// Send email to support team
			mailChipEmailUtil.sendEmail(emails.toString().split(SEMI_COLON), subject, integrationFailureSupportTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + INTEGRATION_FAILURE + SUPPORT + " - marketplaceUrl:[{}], userName:[{}] ", marketplace.getStoreUrl(), userName, e);
		}

		sendEmailToDevelopersForIntegrationFailure(userName, marketplace, exception);
	}

	public void sendEmailToDevelopersForIntegrationFailure(String userName, Marketplace marketplace, String exception) {
		try {
			Customer customer = marketplace.getCustomer();
			String subject = clickshipDomain + "ClickShip integration failed for " + marketplace.getMarketplaceType().getName() + " store: '" + marketplace.getStoreUrl() + "'";

			Map<String, Object> content = new HashMap<String, Object>();
			getMarketplaceContent(marketplace, content);
			getCustomerContent(customer, content);
			content.put("userName", userName);
			content.put("exception", exception);

			// Send email to developers
			mailChipEmailUtil.sendEmail(developers.split(SEMI_COLON), subject, integrationFailureSupportTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + INTEGRATION_FAILURE + DEVELOPERS + " - marketplaceUrl:[{}], userName:[{}] ", marketplace.getStoreUrl(), userName, e);
		}
	}
	
	public void sendEmailToDevelopersForImportLatestOrdersFailure(Marketplace marketplace, String requestType, Exception exception) {
		try {
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			exception.printStackTrace(printWriter);
			String stackTrace = stringWriter.toString();

			String subject = clickshipDomain + requestType +" request failed for " + marketplace.getMarketplaceType().getName() + " store: '" + marketplace.getStoreUrl() + "'";
			
			Map<String, Object> content = new HashMap<String, Object>();
			content.put("genericId", marketplace.getId());
			content.put("stackTrace", stackTrace);

			mailChipEmailUtil.sendEmail(developers.split(SEMI_COLON), subject, customerExceptionNotificationTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + ORDER_LATEST_ORDER_UPDATE_FAILURE + DEVELOPERS + " - marketplaceUrl:[{}] ", marketplace.getStoreUrl(), e);
		}
	}
	
	public void sendEmailToDevelopersForFoundUnbilledCharges(int count) {
		try {
			String subject = "Found the chargebee unbilled charges in FEE table";
			
			Map<String, Object> content = new HashMap<String, Object>();
			content.put("genericId", "Triggered from Unbilled Chargebee charges JOB ");
			content.put("stackTrace", "Found the unbilled charges in FEE table. Total count: " + count);
	
			mailChipEmailUtil.sendEmail(developers.split(SEMI_COLON), subject, customerExceptionNotificationTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + PROCESSING_UNBILLED_CHARGES_FAILURE + DEVELOPERS, e);
		}
	}
	
	public void sendEmailToDevelopersForProcessingUnbilledChargesFailure(String businessName, String type, String ref, Exception exception) {
		try {
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			exception.printStackTrace(printWriter);
			String stackTrace = stringWriter.toString();
						
			String format = "%s - Exception while processing [%s] unbilled %s charges.";
			String subject = String.format(format, clickshipDomain, businessName, type);
			
			Map<String, Object> content = new HashMap<String, Object>();
			content.put("genericId", ref);
			content.put("stackTrace", stackTrace);

			mailChipEmailUtil.sendEmail(developers.split(SEMI_COLON), subject, customerExceptionNotificationTemplate, false, content, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + PROCESSING_UNBILLED_CHARGES_FAILURE + DEVELOPERS + " - customer:[{}], type:[{}], ref:[{}] ",
					businessName, type, ref, e);
		}
	}
	
	public void sendSplitOrderUpdateNotificationEmail(Marketplace marketplace, Order order) {
		try {
			Customer customer = marketplace.getCustomer();
			
			String email = customer.getEmail();
			String subject = "Please review your unfulfilled split order";
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("marketplaceName", marketplace.getAliasName());
			param.put("orderNumber", order.getOrderNumber());
			
			mailChipEmailUtil.sendEmail(email, subject, splitOrderUpdateReviewNotificationTemplate, false, param, null);
			
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + SPLIT_ORDER_UPDATE_NOTIFICATION + OWNER + " - marketplace:[{}], order:[{}]",
					marketplace.getStoreUrl(), order.getOrderNumber(), e);
		}
	}
	
	public void sendCombineOrderUpdateNotificationEmail(Marketplace marketplace, Order order) {
		try {
			Customer customer = marketplace.getCustomer();
			
			String email = customer.getEmail();
			String orderNumber = order.getParentOrder().getOrderNumber();
			String subject = "Combined Order – Notification";
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("orderNumber", orderNumber);
			param.put("updatedOrder", order.getOrderNumber());
			param.put("marketplaceName", marketplace.getAliasName());
			param.put("orderUrl", getOrderUrl(orderNumber));
			
			mailChipEmailUtil.sendEmail(email, subject, combineOrderUpdateReviewNotificationTemplate, false, param, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + COMBINE_ORDER_UPDATE_NOTIFICATION + OWNER + " - marketplace:[{}], order:[{}]",
					marketplace.getStoreUrl(), order.getOrderNumber(), e);
		}
	}
	
	public void sendCancelCombineOrderNotificationEmail(Marketplace marketplace, Map<String, Object> param) {
		try {
			Customer customer = marketplace.getCustomer();

			String email = customer.getEmail();
			String subject = "Your combine order was uncombined";
			
			mailChipEmailUtil.sendEmail(email, subject, combineOrderCancelNotificationTemplate, false, param, null);
		} catch (Exception e) {
			logger.error(EMAIL_ERROR + COMBINE_ORDER_CANCEL_NOTIFICATION + OWNER + " - marketplace:[{}], order:[{}]",
					marketplace.getStoreUrl(), param.get("orderNumber"), e);
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String getCarrierLabelUrl(Shipment shipment) {
		return "https://app.clickship.com/clickship/assets/images/" + shipment.getCarrier().getShortName().toLowerCase() + ".png";
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void sendNewOrderImportEmail(Marketplace marketplace, Order order) {
		try {
			MarketplaceSetting marketplaceSetting = marketplaceSettingRepository.findByMarketplace(marketplace);
			
			if (marketplaceSetting != null) {
				String email = marketplaceSetting.getEmailAddressNewOrderImported();
				
				if (StringUtils.isNotEmpty(email)) {
					String subject = "New Order - Imported " +  marketplace.getAliasName() + " Order #" + order.getOrderNumber();
					
					Code shipToCountryCode = codeService.getCodeByValue("COUNTRY", order.getShiptoCountry());
					
					Map<String, String> orderMap = CopyUtil.copyObjectToMap(order);
					orderMap.put("shiptoCountryName", shipToCountryCode != null ? shipToCountryCode.getName() : order.getShiptoCountry());
					
					Map<String, Object> param = new HashMap<String, Object>();
					
					

					param.put("order", orderMap);
					
					param.put("deliveryMethod", order.getCarrier() != null ? order.getCarrier().getService() : "Not yet.");
					param.put("marketplace", CopyUtil.copyObjectToMap(order.getMarketplace()));
					param.put("orderUrl", getOrderUrl(order.getOrderNumber()));
					
					setProductsForNewOrderEmail(order, param);
					param.putAll(customerPreferencesService.getBrandingEmbeddedDetails(marketplace.getCustomer()));
					
					
					mailChipEmailUtil.sendEmail(email, subject, newOrderImportedTemplate, true, param, null);
				}
			}
		} catch (Exception e) { 
			logger.error("Error while sending new order import email - marketplace:[{}], order:[{}]", marketplace.getStoreUrl(), order.getOrderNumber(), e);
		}
	}
	
	public void icsRequestAcknowledgementEmail(Customer customer, NewCarrierRequestDTO dto) {
		try {
			mailChipEmailUtil.sendEmail(dto.getEmail(), null, requestIcsHighVolumeShippingTemplate, false, new HashMap<>(), null);
		} catch (Exception e) {
			String message = String.format(
					EMAIL_ERROR + SUPPORT + " - Sending ICS Carrier Request acknowledgement email for customer:[{}], Error: [%s]",
					customer.getBusinessName(), e.getMessage());
			logger.error(message, e);
		}
	}
	
	public void sendQuoteRequestEmail(Customer customer, OrderDTO dto, String subject) {
		Map<String, Object> content = new HashMap<>();
		content.put("additionalService", getNotNull(dto.getMarketplaceType()));
		
		content.put("customerName", getNotNull(customer.getContactName()) );
		content.put("businessName", getNotNull(customer.getBusinessName()));
		content.put("email", getNotNull(customer.getEmail()));
		content.put("phone", getNotNull(customer.getPhone()));
		content.put("date", new Date());
		
		content.put("shipfromCompany", getNotNull(dto.getShipfromCompany()));
		content.put("shipfromAttention", getNotNull(dto.getShipfromAttention()));
		content.put("shipfromAddress1", getNotNull(dto.getShipfromAddress1()));
		content.put("shipfromAddress2", getNotNull(dto.getShipfromAddress2()));
		content.put("shipfromCity", getNotNull(dto.getShipfromCity()));
		content.put("shipfromZip", getNotNull(dto.getShipfromZip()));
		content.put("shipfromProvinceState", getNotNull(dto.getShipfromProvinceState()));
		content.put("shipfromCountry", getNotNull(dto.getShipfromCountry()));
		content.put("pickupInstructions", getNotNull(dto.getPickupInstructions()));
		content.put("shipfromOpensAt", getNotNull(dto.getShipfromOpensAt()));
		content.put("shipfromClosesAt", getNotNull(dto.getShipfromClosesAt()));
		content.put("residentialPickup", dto.getResidentialPickup());
		content.put("pickupTailgate", dto.getPickupTailgate());
		
		content.put("shiptoCompany", getNotNull(dto.getShiptoCompany()));
		content.put("shiptoContact", getNotNull(dto.getShiptoContact()));
		content.put("shiptoAddress1", getNotNull(dto.getShiptoAddress1()));
		content.put("shiptpAddress2", getNotNull(dto.getShiptoAddress2()));
		content.put("shiptoCity", getNotNull(dto.getShiptoCity()));
		content.put("shiptoZip", getNotNull(dto.getShiptoZip()));
		content.put("shiptoProvinceState", getNotNull(dto.getShiptoProvinceState()));
		content.put("shiptoCountry", getNotNull(dto.getShiptoCountry()));
		content.put("deliveryInstructions", getNotNull(dto.getDeliveryInstructions()));
		content.put("shiptoOpensAt", getNotNull(dto.getShiptoOpensAt()));
		content.put("shiptoClosesAt", getNotNull(dto.getShiptoClosesAt()));
		content.put("residentialDelivery", dto.getResidentialDelivery());
		content.put("deliveryTailgate", dto.getDeliveryTailgate());
		
		content.put("expectedShipDate", getNotNull(dto.getExpectedShipDate()));
		content.put("referenceCode", getNotNull(dto.getReferenceCode()));
		
		content.put("insidePickup", dto.getPalletServices().getInsidePickup());
		content.put("insideDelivery", dto.getPalletServices().getInsideDelivery());
		content.put("stackable", dto.getPalletServices().getStackable());
		content.put("dangerousGoods", dto.getPalletServices().getDangerousGoods());
		
		content.put("packages", getMandrillPackages(dto.getPackages(), dto.getUnitOfMeasure()));
		
		content.put("noPackages", dto.getPackages().size());
		content.put("insuranceAmount", dto.getInsuranceAmount() != null ? dto.getInsuranceAmount() : 0);
		content.put("insuranceCurrency", getNotNull(dto.getInsuranceCurrency()));
		content.put("insuranceType", dto.getInsuranceType() == InsuranceType.FREIGHTCOM.getValue() ? InsuranceType.FREIGHTCOM.name(): InsuranceType.OWN_CARRIER.name());
	
		try {
			String[] emails = sales.split(SEMI_COLON);

			mailChipEmailUtil.sendEmail(emails, subject, quoteRequestTemplate, true, content, null);
		} catch (Exception e) {
			String message = String.format(
					EMAIL_ERROR + SUPPORT + " - Sending quote request email for customer: [{}], Error: [%s]",
					customer.getBusinessName(), e.getMessage());
			logger.error(message, e);
		}
	}

	public void sendNMFCCodeRequestEmail(Customer customer, NMFCCodeRequestDTO dto) {
		Map<String, Object> content = new HashMap<>();
		
		content.put("businessName", getNotNull(customer.getBusinessName()) );
		content.put("fcCustomerId", getNotNull(customer.getFcCustomerId()));
		content.put("customerName", getNotNull(customer.getContactName()));
		content.put("email", getNotNull(customer.getEmail()));
		content.put("phone", getNotNull(customer.getPhone()));
		
		content.put("requestingUserName", getNotNull(dto.getName()) );
		content.put("requestingUserId", getNotNull(dto.getCompany()));
		content.put("requestingUserEmail", getNotNull(dto.getEmailAddress()));
		
		content.put("lenghtUOM",StringUtils.equalsIgnoreCase(dto.getUnitOfMeasure(), "Metric") ? "in": "cm");
		content.put("weightUOM",StringUtils.equalsIgnoreCase(dto.getUnitOfMeasure(), "Metric") ? "lbs": "kgs");
		
		content.put("preferredLanguage", "English");
		
		content.put("packages", dto.getItems());
		
		String subject = "NMFC Code Request";
		
		try {
			String[] emails = sales.split(SEMI_COLON);

			mailChipEmailUtil.sendEmail(emails, subject, nmfcCodeRequestTemplate, true, content, null);
		} catch (Exception e) {
			String message = String.format(
					EMAIL_ERROR + SUPPORT + " - Sending quote request email for customer: [{}], Error: [%s]",
					customer.getBusinessName(), e.getMessage());
			logger.error(message, e);
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	private List<MandrillOrderline> getMandrillOrderlines(Order order) {
		if (CollectionUtils.isNotEmpty(order.getOrderlines())) {
			return order.getOrderlines().stream().map(ol -> {
				MandrillOrderline mOl = new MandrillOrderline();
				MarketplaceProduct product = ol.getMarketplaceProduct();
				if(product != null) {
					mOl.setProductSku(StringUtils.isNotEmpty(ol.getSku()) ? ol.getSku() : "");
					mOl.setProductTitle(StringUtils.isNotEmpty(ol.getTitle()) ? ol.getTitle() : "");
					mOl.setProductImageUrl(StringUtils.isNotEmpty(product.getImageUrl()) ? product.getImageUrl() : "");
					mOl.setQuantity(ol.getQuantity() != null ? ol.getQuantity() : 0);
					mOl.setPrice(ol.getUnitPrice() == null ? "0" : "" + ol.getUnitPrice());
					mOl.setCurrency(order.getMarketplace().getCurrency());
				}

				return mOl;
			}).collect(Collectors.toList());
		} else {
			return Collections.emptyList();
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	private List<MandrillPackage> getMandrillPackages(Shipment shipment, String uom) {
		List<Package> packages = shipment.getPackages();

		if (packages != null) {
			AtomicInteger atomicInteger = new AtomicInteger(1);

			return packages.stream().map(p -> {
				return new MandrillPackage().setBoxNumber(atomicInteger.getAndIncrement())
						.setBoxWeight(getPackageWeight(p, uom)).setBoxDimensions(getPackageDimensions(p, uom))
						.setTrackingURL(shipment.getTrackingURL()).setTrackingNumber(shipment.getTrackingNumber())
						.setCarrierLabelUrl(getCarrierLabelUrl(shipment))
						.setImageAltName(shipment.getCarrier().getShortName().toLowerCase());
			}).collect(Collectors.toList());
		} else {
			return Collections.emptyList();
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	private String getPackageDimensions(Package pack, String unitOfMessaure) {
		if (StringUtils.endsWithIgnoreCase(ClickShipConstants.UNIT_METRIC, unitOfMessaure)) {
			// Metric
			return String.format("%.2f", pack.getLengthMetric()) + " x " + String.format("%.2f", pack.getWidthMetric())
					+ " x " + String.format("%.2f", pack.getHeightMetric()) + " cm";
		} else {
			// Imperial
			return String.format("%.2f", pack.getLengthImperial()) + " x "
					+ String.format("%.2f", pack.getWidthImperial()) + " x "
					+ String.format("%.2f", pack.getHeightImperial()) + " in";
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	private String getPackageWeight(Package pack, String unitOfMessaure) {
		if (StringUtils.endsWithIgnoreCase(ClickShipConstants.UNIT_METRIC, unitOfMessaure)) {
			// Metric
			return String.format("%.2f", (pack.getEmptyWeightMetric() + pack.getProductWeightMetric())) + " kg(s)";
		} else {
			// Imperial
			return String.format("%.2f", (pack.getEmptyWeightImperial() + pack.getProductWeightImperial())) + " lb(s)";
		}
	}

	private void getMarketplaceContent(Marketplace marketplace, Map<String, Object> content) {
		String type = marketplace.getMarketplaceType().getName();
		
		content.put("marketplaceType", StringUtils.contains(type, "Amazon") ? "Amazon" : type);
		content.put("marketplaceName", marketplace.getAliasName());
		content.put("marketplaceUrl", marketplace.getStoreUrl());
		content.put("storeUrl", marketplace.getStoreUrl());
	}

	private void getCustomerContent(Customer customer, Map<String, Object> content) {
		content.put("businessName", customer.getBusinessName());
		content.put("customerName", customer.getContactName());
		content.put("phone", customer.getPhone());
		content.put("email", customer.getEmail());
		content.put("customerId", customer.getId());
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	private void setProductsForNewOrderEmail(Order order, Map<String, Object> param) {
		List<Map<String, String>> list = new ArrayList<>();
		List<Orderline> orderlines = order.getOrderlines();
		for (int i = 0; i < orderlines.size(); i++) {
			Orderline orderline = orderlines.get(i);
			Map<String, String> map = new HashMap<String, String>();
			map.put("quantity", String.valueOf(orderline.getQuantity()));
			map.put("productName", orderline.getTitle());
			map.put("sku", orderline.getSku());
			map.put("unitPrice", String.valueOf(orderline.getUnitPrice()));
			map.put("imgUrl", orderline.getMarketplaceProduct().getImageUrl());
			list.add(map);
		}
		
		param.put("products", list);
	}
	
	private String getOrderUrl(String orderNumber) {
		return clickshipDomain + "/app-frame/my-orders?searchKey=" + orderNumber;
	}

	private List<MandrillPackageDetails> getMandrillPackages(List<BoxDTO> packages, String unitOfMeasure) {
		String lom = StringUtils.equalsIgnoreCase(unitOfMeasure, ClickShipConstants.UNIT_IMPERIAL) ? "in" : "cm";
		String wuom = StringUtils.equalsIgnoreCase(unitOfMeasure, ClickShipConstants.UNIT_IMPERIAL) ? "lbs" : "kgs";

		if (packages != null) {
			return packages.stream().map(p -> {
				return new MandrillPackageDetails().setLength(getStringValue(p.getLength(), lom))
						.setWidth(getStringValue(p.getWidth(), lom)).setHeight(getStringValue(p.getHeight(), lom))
						.setWeight(getStringValue(p.getHeight(), wuom)).setFreightClass(getNotNull(p.getFreightClass()))
						.setNmfcCode(getNotNull(p.getNmfcCode())).setType(getNotNull(p.getType()))
						.setPieces(getNotNull(p.getPieces())).setDescription(getNotNull(p.getDescription()));
			}).collect(Collectors.toList());
		} else {
			return Collections.emptyList();
		}
	}

	private String getStringValue(Double value, String uom) {
		return String.format("%s %s", value, uom);
	}
	
	private String getNotNull(String value) {
		return StringUtils.isNoneBlank(value)? value : StringUtils.EMPTY;
	}

}

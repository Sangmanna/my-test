package com.freightcom.clickship.service.service.impl;

import static com.freightcom.clickship.model.enums.MarketplaceImportingStage.EMAIL_REPORT;
import static com.freightcom.clickship.model.enums.MarketplaceImportingStage.IMPORT_ADDRESS;
import static com.freightcom.clickship.model.enums.MarketplaceImportingStage.IMPORT_INVENTORY;
import static com.freightcom.clickship.model.enums.MarketplaceImportingStage.IMPORT_ORDER;
import static com.freightcom.clickship.model.enums.MarketplaceImportingStage.IMPORT_PRODUCT;
import static com.freightcom.clickship.model.enums.MarketplaceImportingStage.INITIAL_IMPORT;
import static com.freightcom.clickship.model.enums.MarketplaceImportingStage.INVALID_METRICS;
import static com.freightcom.clickship.model.enums.MarketplaceImportingStage.REGISTER_WEBHOOK;
import static com.freightcom.clickship.model.enums.MarketplaceImportingStage.WEBHOOK_REQUEST;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.ClientAnchor.AnchorType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.chargebee.dto.ChargeBeePlanName;
import com.freightcom.clickship.client.bigcommerce.BigCommerceClient;
import com.freightcom.clickship.client.lightspeed.LightSpeedClient;
import com.freightcom.clickship.client.squarespace.SquareSpaceClient;
import com.freightcom.clickship.data.entity.Code;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.CustomerPreferences;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceProcessFailure;
import com.freightcom.clickship.data.entity.MarketplaceSetting;
import com.freightcom.clickship.data.entity.MarketplaceType;
import com.freightcom.clickship.data.rep.MarketplaceProcessFailuresRepository;
import com.freightcom.clickship.data.rep.MarketplaceRepository;
import com.freightcom.clickship.data.rep.MarketplaceSettingRepository;
import com.freightcom.clickship.model.admin.dashboard.stores.MarketplaceTableDTO;
import com.freightcom.clickship.model.admin.dashboard.stores.StoreCountsByWeekOrMonth;
import com.freightcom.clickship.model.constants.ClickShipJMS;
import com.freightcom.clickship.model.constants.MarketplaceConstants;
import com.freightcom.clickship.model.enums.ProductExcelHeaders;
import com.freightcom.clickship.model.exception.http.UnauthorizedException;
import com.freightcom.clickship.model.exception.marketplace.MarketplaceDoesNotExistException;
import com.freightcom.clickship.model.mandrill.MailAttachment;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.MarketplaceTypeDTO;
import com.freightcom.clickship.model.marketplace.bigcommerce.BigCommerceWebhook;
import com.freightcom.clickship.model.marketplace.lightspeed.LightSpeedExternalService;
import com.freightcom.clickship.model.marketplace.squarespace.SquareSpaceTokenGenerationRequest;
import com.freightcom.clickship.model.marketplace.squarespace.SquareSpaceTokenGenerationResponse;
import com.freightcom.clickship.model.product.ProductUpdateDTO;
import com.freightcom.clickship.model.util.ClickshipStringUtil;
import com.freightcom.clickship.service.dao.MarketplaceDao;
import com.freightcom.clickship.service.dao.MarketplaceProductDao;
import com.freightcom.clickship.service.service.CodeService;
import com.freightcom.clickship.service.service.CustomerDataService;
import com.freightcom.clickship.service.service.CustomerPreferencesService;
import com.freightcom.clickship.service.service.MarketplaceService;
import com.freightcom.clickship.service.service.NotificationService;
import com.freightcom.clickship.service.service.email.ClickShipSupportEmails;
import com.freightcom.clickship.service.service.email.MailChimpEmailUtil;
import com.freightcom.clickship.service.service.email.SendEmailUtil;
import com.freightcom.clickship.service.service.integrations.shopify.ShopifyService;
import com.freightcom.clickship.service.service.integrations.woocommerce.WooCommerceService;
import com.freightcom.clickship.service.service.jms.JMSService;

@Service
public class MarketplaceServiceImpl implements MarketplaceService {
	
	private Logger logger = LogManager.getLogger(MarketplaceServiceImpl.class);

	private static final String SEMI_COLON = ";";
	private static final String EXCEL_MIME_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	private static final String CLICKSHIP = "ClickShip";
	public static final double INVALID_NUMBER_FORMAT = -1;
	private static final String COUNTRY_GROUP = "COUNTRY";
	public static final String NULL_PRODUCT_ID = "NULL_PRODUCT_ID";
	public static final String VALIDATION_ERROR_CNT = "VALIDATION_ERROR_CNT";

	private static final String[] BOOLEAN_VALUES = new String[] { "TRUE", "FALSE" };
	private static final String[] UNIT_OF_MEASURES = new String[] { "Imperial", "Metric" };
	private static final String[] MULTI_BOX_HEADERS = {"Box-%s Length", "Box-%s Width", "Box-%s Height", "Box-%s Weight", "Box-%s Description"};
	
	@Value("${internal.email.tech.support}")
	private String techsupportEmail;
	
	@Value("${subscription.free.plan.marketplace.number:0}")
	private int marketplaceCount;

	@Value("${squarespace.client_id:2JpQrLMp10YA2QREn8OtqETWmUGa4NL6}")
	private String squareSpaceClientId;
	
	@Value("${clickship.delete.marketplace.products.export:clickship-delete-marketplace-products-export}")
	private String deleteMarketplaceRequestNotificationTemplate;
	
	@Autowired
	private JMSService jmsService;
	
	@Autowired
	private CodeService codeService;
	
	@Autowired
	private SendEmailUtil sendEmailUtil;
	
	@Autowired
	private MailChimpEmailUtil mailChipEmailUtil;
	
	@Autowired
	private MarketplaceDao marketplaceDao;
	
	@Autowired
	private ShopifyService shopifyService;
	
	@Autowired
	private LightSpeedClient lightSpeedClient;

	@Autowired
	private SquareSpaceClient squareSpaceClient;
	
	@Autowired
	private BigCommerceClient bigCommerceClient;
	
	@Autowired
	private CustomerDataService customerService;

	@Autowired
	private WooCommerceService wooCommerceService;
	
	@Autowired
	private ClickShipSupportEmails supportEmailUtil;
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private MarketplaceProductDao marketplaceProductDao;
	
	@Autowired
	private MarketplaceRepository marketplaceRepository;
	
	@Autowired
	private MarketplaceSettingRepository marketplaceSettingRepository;
	
	@Autowired
	private MarketplaceProcessFailuresRepository integrationFailuresRepository;
	
	@Autowired
	private CustomerPreferencesService customerPreferencesService;

	@Override
	@Transactional
	public void save(Marketplace marketplace) {
		marketplaceRepository.save(marketplace);
	}
	
	@Override
	public Marketplace findByStoreUrl(String url) {
		return marketplaceRepository.findByStoreUrl(url);
	}
	
	@Override
	public Marketplace findById(String marketplaceId) {
		Optional<Marketplace> optional = marketplaceRepository.findById(marketplaceId);

		if(optional.isPresent()) {
			return optional.get();	
		}
		
		throw new MarketplaceDoesNotExistException(String.format("Invalid marketplaceId:%s provided", marketplaceId));
	}
	
	@Override
	public Marketplace findById(Customer customer, String marketplaceId) {
		Marketplace marketplace = marketplaceRepository.findByCustomerAndId(customer, marketplaceId);

		if (marketplace != null) {
			return marketplace;
		}

		throw new MarketplaceDoesNotExistException(String.format("Invalid marketplaceId:%s provided", marketplaceId));
	}

	@Override
	public Marketplace findByMarketplaceTypeAndUsername(MarketplaceType marketplaceType, String instanceId) {
		return marketplaceRepository.findByMarketplaceTypeAndUsername(marketplaceType, instanceId);
	}
	
	@Override
	public List<Marketplace> findAllActiveMarketplaces(Customer customer) {
		return marketplaceRepository.findAllByCustomer(customer).stream().filter(m -> Boolean.TRUE.equals(m.getActive())).collect(Collectors.toList());
	}
	
	@Override
	public List<MarketplaceDTO> getMarketplacesByCustomer(Customer customer) {
		return marketplaceRepository.findByCustomerAndIntegrationSuccessTrue(customer).stream()
				.map(this::getMarketplaceDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<MarketplaceDTO> getMarketplacesByCustomerId(String customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		return getMarketplacesByCustomer(customer);
	}
	
	@Override
	public Marketplace getIntegratedMarketplaceByStoreUrl(String url) {
		return marketplaceRepository.findByStoreUrlAndIntegrationSuccessTrue(url);
	}

	@Override
	public List<MarketplaceDTO> getActiveMarketplaces(Customer loginCustomer) {
		List<MarketplaceDTO> marketplaceTypes = new ArrayList<>();
		
		if (loginCustomer == null) {
			return marketplaceTypes;
		}
		
		return marketplaceRepository.findByCustomerAndActiveTrue(loginCustomer).stream()
				.map(this::getMarketplaceDto).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public void disableMarketplaceIfNecessary(Marketplace marketplace) {
		try {
			if (marketplaceCount <= getActiveMarketplaces(marketplace.getCustomer()).size() &&
				StringUtils.equalsIgnoreCase(marketplace.getCustomer().getSubTier(), ChargeBeePlanName.CLICKSHIP_LITE.toString())) {
				disableStore(marketplace.getId());
			}
		} catch (Exception e) {
			logger.error("Error during check & disable marketplace. Marketplace:{}", marketplace.getStoreUrl(), e);
		}
	}
	
	@Override
	@Transactional
	public MarketplaceDTO disableStore(String marketplaceId) {
		return disableStore(findById(marketplaceId));
	}
	
	@Override
	public MarketplaceDTO enableStore(Customer customer, String marketplaceId) {
		return enableStore(findById(customer, marketplaceId));
	}

	@Override
	@Transactional
	public MarketplaceDTO disableStore(Customer customer, String marketplaceId) {
		return disableStore(findById(customer, marketplaceId));
	}

	@Override
	public void deleteStore(String marketplaceId, boolean processOnMarketplaceEnd) throws Exception {
		try {
			Marketplace marketplace = findById(marketplaceId);
			Customer customer = marketplace.getCustomer();
			
			logger.info("Processing delete store request - id:[{}], storeUrl:[{}]", marketplace.getId(), marketplace.getStoreUrl());

			if(processOnMarketplaceEnd) {
				try {
					switch(marketplace.getMarketplaceType().getName()) {
						case MarketplaceConstants.MARKETPLACE_TYPE_WOOCOMMERCE:
							wooCommerceService.deleteWebhooks(marketplaceId);
						break;
					
						case MarketplaceConstants.MARKETPLACE_TYPE_SHOPIFY:
							shopifyService.uninstallStore(marketplace);
						break;

						case MarketplaceConstants.MARKETPLACE_TYPE_LIGHTSPEED:
							try {
								lightSpeedClient.deleteWebhooks(getMarketplaceDto(marketplace));
								List<LightSpeedExternalService> list = lightSpeedClient.getClickShipExternalServices(getMarketplaceDto(marketplace));

								if(CollectionUtils.isNotEmpty(list)) {
									for (LightSpeedExternalService lsExternalService: list) {
										lightSpeedClient.deleteClickShipExternalService(getMarketplaceDto(marketplace), lsExternalService.getId());
									}
								}
							} catch (Exception e) {
								throw new Exception(String.format("Unable to delete LightSpeed store due to %s", e.getMessage()));
							}
							break;

						case MarketplaceConstants.MARKETPLACE_TYPE_SQUARESPACE:
							try {
								squareSpaceClient.deleteWebhooks(marketplace.getToken(), marketplace.getId());
							} catch (UnauthorizedException e) {
								SquareSpaceTokenGenerationRequest request = new SquareSpaceTokenGenerationRequest();
								request.setGrantType("refresh_token");
								request.setClientId(squareSpaceClientId);
								request.setRefreshToken(marketplace.getPrivateKey());

								SquareSpaceTokenGenerationResponse response = squareSpaceClient.getAccessTokenForStore(request);
								squareSpaceClient.deleteWebhooks(response.getAccessToken(), marketplace.getId());
							}
							break;
						case MarketplaceConstants.MARKETPLACE_TYPE_BIGCOMMERCE:
							try {
								List<BigCommerceWebhook> webhooks = bigCommerceClient.getWebhooks(marketplace.getToken(), marketplace.getUsername());
								
								for(BigCommerceWebhook webhook : webhooks) {
									if (StringUtils.contains(webhook.getDestination(), marketplace.getId())) {
										bigCommerceClient.deleteWebhook(marketplace.getToken(), marketplace.getUsername(), String.valueOf(webhook.getId()));
									}
								}
							} catch (Exception e) {
								throw new Exception(String.format("Unable to delete BigCommerce store due to %s", e.getMessage()));
							}
							break;
						default:
							// Nothing to do 
					}
				} catch (Exception e) {
					// Ignore the exception and continue to the delete marketplace on CS
				}
			}
			
			String storeUrl = marketplace.getStoreUrl();
			String aliasName = marketplace.getAliasName();
			String email = marketplace.getCustomer().getEmail();
			
			sendEmailToTechnicalSupport(marketplace);

			marketplaceDao.deleteMarketplace(marketplace.getId());
			
			CustomerPreferences preferences = customerPreferencesService.getCustomerPreferencesByCustomer(customer);
			
			if (StringUtils.equalsAnyIgnoreCase(preferences.getSubscriptionBillingChannel(), "Shopify")) {
				List<Marketplace> list = marketplaceRepository.findByCustomerAndIntegrationSuccessTrue(customer);
				boolean noShopifyIntegrationExistInHisAccount = list.stream().noneMatch(m -> Objects.equals(m.getMarketplaceType().getName(), MarketplaceConstants.MARKETPLACE_TYPE_SHOPIFY));
				
				if (noShopifyIntegrationExistInHisAccount) {
					preferences.setSubscriptionBillingChannel("ChargeBee");
					
					customerPreferencesService.save(preferences);
				}				
			}
			
			logger.info("Processing delete store request completed - id:[{}], storeUrl:[{}]", marketplaceId, storeUrl);

			sendEmailUtil.sendDeleteMarketplaceSuccessEmailToUser(aliasName, storeUrl, email);
		} catch (MarketplaceDoesNotExistException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception while executing delete marketplace store proc - marketplace:[{}]", marketplaceId, e);
			supportEmailUtil.sendEmailToDevelopersForExceptionRecievedByCustomer(marketplaceId, e);
		}
	}
	
	@Override
	@Transactional
	public void recordFailure(String marketplaceId, Exception e, String...strings) {
		recordFailure(marketplaceId, strings[0], strings[1], ClickshipStringUtil.truncateString(e, 255));
	}
	
	@Override
	@Transactional
	public void recordFailure(Marketplace marketplace, Exception e, String...strings) {
		recordFailure(marketplace, strings[0], strings[1], ClickshipStringUtil.truncateString(e, 255));
	}
	
	@Override
	@Transactional
	public void recordFailure(String marketplaceId, String...strings) {
		Marketplace marketplace = findById(marketplaceId);
		recordFailure(marketplace, strings);
	}
	
	/*
	 * 
	 * String args 
	 * string[0] - MarketplaceImportingStage
	 * string[1] - reference id based on the error type, Can be markerplaceId, externalProductId, externalOrderId.
	 * string[2] - error description. 
	 *  
	 */
	@Override
	@Transactional
	public void recordFailure(Marketplace marketplace, String...strings) {
		try {
			MarketplaceProcessFailure failure = new MarketplaceProcessFailure();
			
			failure.setMarketplace(marketplace)
				.setFailureType(strings[0])
				.setReferenceId(strings[1])
				.setErrorMessage(strings[2]);
			
			integrationFailuresRepository.save(failure);
			
			notificationService.saveImportMarketplaceErrorNotification(marketplace, String.format("An error was found %s. ", getPhaseString(strings[0], strings[1])));
		} catch (Exception e) {
			logger.error("Error during recordFailure, marketplaceId: {}", marketplace != null ? marketplace.getId() : "", e);
		}
	}
	
	@Override
	@Async
	public void recordFailureWithoutNotification(String marketplaceId, String failureType, String referenceId, String errorMessage) {
		try {
			errorMessage = ClickshipStringUtil.truncateString(errorMessage, 250);
			integrationFailuresRepository.save(new MarketplaceProcessFailure().setMarketplace(findById(marketplaceId)).setFailureType(failureType)
					.setReferenceId(referenceId).setErrorMessage(errorMessage));

		} catch (Exception e) {
			logger.error("Error during recordFailure, marketplaceId: {}", marketplaceId, e);
		}
	}
	
	@Override
	public List<MarketplaceTableDTO> getMarketplaceTable(String from, String to, String agentName) {
		return marketplaceDao.getMarketplaceTables(from, to, agentName);
	}
	
	@Override
	public List<MarketplaceDTO> getActiveMarketplacesByType(List<MarketplaceType> list) {
		List<Marketplace> marketplaces = marketplaceRepository.getByMarketplaceTypeInAndIntegrationSuccessTrueAndActiveTrueAndPrevJobExecDateIsNotNull(list);
		return marketplaces.stream().map(this::getMarketplaceDto).collect(Collectors.toList());
	}

	@Override
	public List<String> getListOfStoreTypesAndCounts(Customer customer) {
		//TODO you can achieve this by below simple query instead of having two iterations and multiple if conditions
		// Please refactor this method
		// SELECT mt.name, count(*) FROM marketplace_type mt JOIN marketplace m on mt.id = m.marketplace_type_id WHERE m.integration_success is true group by marketplace_type_id;
		
		List<Marketplace> marketplaces = marketplaceRepository.findAllByCustomer(customer);
		
		Map<String, Long> map = marketplaces.stream().filter(m -> m.getIntegrationSuccess()).map(o -> {
			return o.getMarketplaceType().getName();
		}).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		List<String> list = new ArrayList<>();
		
		map.entrySet().forEach(o -> {
			if (o.getValue() > 1) {
				list.add(o.getKey() + " (" + o.getValue().intValue() + ")");
			} else {
				list.add(o.getKey());
			}
		});
		
		if (list.isEmpty()) {
			list.add("No Stores integrated");
		}
		
		return list;
	}
	
	@Override
	public List<StoreCountsByWeekOrMonth> getStoreIntegratedInDay(String from, String to, String agentName) {
		return marketplaceDao.getStoresIntegratedInDay(from, to, agentName);
	}
	
	@Override
	public List<StoreCountsByWeekOrMonth> getStoreIntegratedCountsByWeekOrMonth(String from, String to, String agentName) {
		return marketplaceDao.getStoresIntegratedInWeekOrMonth(from, to, agentName);
	}
	
	@Override
	public List<StoreCountsByWeekOrMonth> getStoreIntegratedCountsBySixMonths(String from, String to, String agentName) {
		return marketplaceDao.getStoresIntegratedInSixMonths(from, to, agentName);
	}
	
	@Override
	public List<StoreCountsByWeekOrMonth> getStoreIntegratedByDateRange(String from, String to, String agentName) {
		return marketplaceDao.getStoresIntegratedByDateRange(from, to, agentName);
	}
	
	@Override
	public MarketplaceDTO getMarketplaceDto(String marketplaceId) {
		Marketplace marketplace = findById(marketplaceId);
		return getMarketplaceDto(marketplace);
	}
	
	@Override
	public MarketplaceDTO getMarketplaceDto(Marketplace marketplace) {
		MarketplaceSetting marketplaceSetting = marketplaceSettingRepository.findByMarketplace(marketplace);
		
		return new MarketplaceDTO().setId(marketplace.getId())
				.setUrl(marketplace.getStoreUrl())
				.setCurrency(marketplace.getCurrency())
				.setType(marketplace.getMarketplaceType().getName())
				.setTypeDTO(getTypeDTO(marketplace))
				.setName(marketplace.getAliasName())
				.setActive(marketplace.getActive())
				.setAccessToken(marketplace.getToken())
				.setPrivateKey(marketplace.getPrivateKey())
				.setSecret(marketplace.getSecret())
				.setUsername(marketplace.getUsername())
				.setIsImporting(marketplace.getIsImporting())
				.setIntegrationSuccess(marketplace.getIntegrationSuccess())
				.setImportSuccess(marketplace.isImportSuccess())
				.setProductIdentifier(marketplaceSetting == null? "" : marketplaceSetting.getProductIdentifier())
				.setLocationSplitAllowed(marketplaceSetting != null && marketplaceSetting.isLocationSplit())
				.setPassword(marketplace.getPassword());
	}
	
	@Override
	public List<Marketplace> getMarketplacesByMarketplaceType(MarketplaceType marketplaceType) {
		return marketplaceRepository.findAllByMarketplaceType(marketplaceType);
	}
	
	@Override
	public List<List<String>> getIntegrationsByMarketplaces(String fromDate, String toDate, String agentName) {
		return marketplaceDao.getCountsByMarketplaceType(fromDate, toDate, agentName);
	}
	
	@Override
	public List<Marketplace> findByDefaultAddressAndCustomer(CustomerAddress defaultAddress, Customer customer) {
		return marketplaceRepository.findByCustomerAndDefaultAddress(customer, defaultAddress);
	}
	
	private Object getPhaseString(String phase, String referenceId) {
		String result = "during ";
		if (phase.equals(INITIAL_IMPORT.toString())) {
			result += "initial marketplace setup.";
		} else if (phase.equals(IMPORT_ADDRESS.toString())) {
			result += "saving address details.";
		} else if (phase.equals(IMPORT_PRODUCT.toString())) {
			result += "saving product.";
		} else if (phase.equals(IMPORT_ORDER.toString())) {
			result += "saving order.";
		} else if (phase.equals(IMPORT_INVENTORY.toString())) {
			result += "saving inventory.";
		} else if (phase.equals(EMAIL_REPORT.toString())) {
			result = "sending email.";
		} else if (phase.equals(REGISTER_WEBHOOK.toString())) {
			result = "registering webhooks.";
		} else if (phase.equals(WEBHOOK_REQUEST.toString())) {
			result += "processing webhook.";
		} else if (phase.equals(INVALID_METRICS.toString())) {
			result += "saving metrics settings. ";
		}
		result += " ReferenceId:- [%s]. Please contact customer care.";
		
		result = String.format(result, referenceId);
		
		return result;
	}
	
	private MarketplaceDTO disableStore(Marketplace marketplace) {
		switch (marketplace.getMarketplaceType().getName()) {
			case MarketplaceConstants.MARKETPLACE_TYPE_WOOCOMMERCE:
				wooCommerceService.disableStore(marketplace.getId());
				marketplace.setPrevJobExecDate(new Date());
				break;
	
			case MarketplaceConstants.MARKETPLACE_TYPE_MAGENTO:
				// Nothing to do for MAGENTO. Simply update active status to false then import
				// job doesn't run.
				// Don't change the prev_import_job_exec_datetime or else it may loose some data
				// when enable store.
				break;
	
			case MarketplaceConstants.MARKETPLACE_TYPE_SHOPIFY:
				// TODO disable webhooks and real time rates plug-in too?
				break;
	
			case MarketplaceConstants.MARKETPLACE_TYPE_AMAZON:
				// Nothing to do for MAGENTO.
				break;
	
			case MarketplaceConstants.MARKETPLACE_TYPE_ETSY:
				// Nothing to do for MAGENTO.
				break;
				
			default:
		}

		marketplace.setActive(false);
		save(marketplace);

		return getMarketplaceDto(marketplace);
	}
	
	private MarketplaceDTO enableStore(Marketplace obj) {
		switch(obj.getMarketplaceType().getName()) {
			case MarketplaceConstants.MARKETPLACE_TYPE_WOOCOMMERCE:
				wooCommerceService.enableStore(obj.getId());
				break;
	
			case MarketplaceConstants.MARKETPLACE_TYPE_LIGHTSPEED:
			case MarketplaceConstants.MARKETPLACE_TYPE_WIX:
			case MarketplaceConstants.MARKETPLACE_TYPE_SHOPIFY:
			case MarketplaceConstants.MARKETPLACE_TYPE_BIGCOMMERCE:
				//TODO get updates from last disable date
				//TODO enable webhooks
				break;
	
			case MarketplaceConstants.MARKETPLACE_TYPE_AMAZON:
			case MarketplaceConstants.MARKETPLACE_TYPE_AMAZON_MWS:
			case MarketplaceConstants.MARKETPLACE_TYPE_MAGENTO:
			case MarketplaceConstants.MARKETPLACE_TYPE_ETSY:
			case MarketplaceConstants.MARKETPLACE_TYPE_WALMART:
			case MarketplaceConstants.MARKETPLACE_TYPE_EBAY:
			case MarketplaceConstants.MARKETPLACE_TYPE_BESTBUY:	
				try {
					jmsService.send(ClickShipJMS.MARKETPLACE_IMPORT_LATEST_ORDER_UPDATES, obj.getId());
				} catch (Exception e) {
					logger.error("Exception while requesting magento on demand import request - name:[{}], Url:[{}]", obj.getAliasName(), obj.getStoreUrl(), e);
				}
				break;
			
			default:
	
		}
	
		obj.setActive(true);
		save(obj);

		return getMarketplaceDto(obj);
	}
	
	private MarketplaceTypeDTO getTypeDTO(Marketplace marketplace) {
		MarketplaceTypeDTO dto = new MarketplaceTypeDTO();
		BeanUtils.copyProperties(marketplace.getMarketplaceType(), dto);
		
		dto.setLocationSplitAllowed(marketplace.getMarketplaceType().isLocationSplitAllowed());
		
		return dto;
	}

	private void sendEmailToTechnicalSupport(Marketplace marketplace) {
		try {
			if (marketplace != null) {
				List<ProductUpdateDTO> products = marketplaceProductDao
						.getMarketplaceProducts(marketplace.getCustomer().getId(), marketplace.getId());
				
				if (CollectionUtils.isNotEmpty(products)) {
					byte[] file = getMarketplaceProductsBytes(products, false);

					Map<String, Object> map = new HashMap<>();
					map.put("businessName", marketplace.getCustomer().getBusinessName().trim());
					map.put("aliasName", marketplace.getAliasName().trim());
					map.put("storeUrl", marketplace.getStoreUrl().trim());
					
					String fileName = marketplace.getId().trim() + "_products_export.xlsx";
					String[] toEmails = techsupportEmail.split(SEMI_COLON);

					mailChipEmailUtil.sendEmail(toEmails,
							marketplace.getCustomer().getBusinessName().trim() + " - Marketplace Delete Request",
							deleteMarketplaceRequestNotificationTemplate, true, map,
							getMailAttachments(file, fileName));
				}
			}
		} catch (Exception e) {
			logger.error("Error while export marketplace products, while delete marketplace - id:[{}], storeUrl:[{}]",
					marketplace.getId(), marketplace.getStoreUrl());
		}
	}

	private byte[] getMarketplaceProductsBytes(List<ProductUpdateDTO> products, boolean populateProductId) throws IOException {
		Workbook wb = new XSSFWorkbook();

		Sheet sheet = wb.createSheet("products");

		Header header = sheet.getHeader();
		header.setCenter(products.size() + " Products");
		header.setLeft(CLICKSHIP);

		addHeaderRowForProducts(sheet);
		
		for (int i = 0; products.size() > i; i++) {
			Row row = sheet.createRow((i + 1));
			ProductUpdateDTO prod = products.get(i);
			if (populateProductId) {
				addExcelCellFromObjects(row, prod.getId(), prod.getSku(), prod.getTitle(), prod.getUnitOfMeasure());
			} else {
				addExcelCellFromObjects(row, "", prod.getSku(), prod.getTitle(), prod.getUnitOfMeasure());
			}
			

			if ("metric".equalsIgnoreCase(prod.getUnitOfMeasure())) {
				addExcelCellFromObjects(row, prod.getLengthMetric(), prod.getWidthMetric(), prod.getHeightMetric(), prod.getWeightMetric());
			} else {
				addExcelCellFromObjects(row, prod.getLength(), prod.getWidth(), prod.getHeight(), prod.getWeight());
			}
			addExcelCellFromObjects(row, prod.getHsCode(), prod.getCustomDescription(), getCountryName(prod.getCountryOfOrigin()), prod.getCustomBox(), prod.getStackable(), prod.getCanRotate(), prod.getMultiBox(), prod.getMultiBoxQuantity());
			
			if(Boolean.TRUE.equals(prod.getMultiBox())) {
				prod.getMultiBoxList().stream().forEach(mb -> {
					if ("metric".equalsIgnoreCase(prod.getUnitOfMeasure())) {
						addExcelCellFromObjects(row, mb.getLengthMetric(), mb.getWidthMetric(), mb.getHeightMetric(), mb.getWeightMetric());
					} else {
						addExcelCellFromObjects(row, mb.getLengthImperial(), mb.getWidthImperial(), mb.getHeightImperial(), mb.getWeightImperial());
					}
				});
			}
		}
		
		// add comments
		addComment(wb, sheet, 0, 1, CLICKSHIP, "Enter Product SKU:\n Example: TSM01-S");
		addComment(wb, sheet, 0, 2, CLICKSHIP, "Enter Product Description:\n Example: T-Shirt");
		addComment(wb, sheet, 0, 10, CLICKSHIP, "Enter Product Country of Origin:\n Example: Canada, USA, China etc..");
		addComment(wb, sheet, 0, 14, CLICKSHIP, "If you have multiple boxes for a particular SKU then make it TRUE and update dimensions from O row. \n\n Please note this row considered only if the Custom_Box value is TRUE.");

		// add DROPDOWN value for UOM, Custom_Box, STACKABALE, Can_Rotate, Is_MultiBox_Product
		addDropdownValues(sheet, UNIT_OF_MEASURES, 1, products.size(), 3, 3);
		addDropdownValues(sheet, BOOLEAN_VALUES, 1, products.size(), 11, 14);
		
		// add 0 - 35 list DROPDOWN value for Multi_box_Quantity
		String[] strArray = Arrays.stream(IntStream.iterate(0, i -> i + 1).limit(36).toArray()).mapToObj(String::valueOf).toArray(String[]::new);
		addDropdownValues(sheet, strArray, 1, products.size(), 15, 15);

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			wb.write(bos);
		} finally {
			bos.close();
			wb.close();
		}
		
		return bos.toByteArray();
	}
	
	private void addHeaderRowForProducts(Sheet sheet) {
		final Row headerRow = sheet.createRow(0);
		String[] finalHeaders = getFinalHeadersForProducts();
		
		IntStream.range(0, finalHeaders.length).forEach(idx -> headerRow.createCell(idx).setCellValue(finalHeaders[idx]));
		IntStream.range(0, finalHeaders.length).forEach(sheet::autoSizeColumn);
	}
	
	private String[] getFinalHeadersForProducts() {
		String[] productHeaders = ProductExcelHeaders.getHeaders();
		String[] finalHeaders = new String[productHeaders.length + (35*5)];
		
		AtomicInteger counter = new AtomicInteger(productHeaders.length);
		IntStream.range(0, productHeaders.length).forEach(idx -> finalHeaders[idx] = productHeaders[idx]);
		IntStream.range(1, 36).forEach(i -> IntStream.range(0, 5).forEach(j -> finalHeaders[counter.getAndIncrement()] = String.format(MULTI_BOX_HEADERS[j], i)));
		
		return finalHeaders;
	}

	private void addExcelCellFromObjects(Row row, Object... data) {
		Arrays.stream(data).forEach(val -> addExcelCell(row, val));
	}
	
	private String getCountryName(String countryCode) {
		Code code = codeService.getCodeByValue(COUNTRY_GROUP, countryCode);
		return code != null ? code.getName() : StringUtils.EMPTY;
	}

	private void addExcelCell(Row row, Object val) {
		Cell cell = row.createCell(row.getLastCellNum() == -1 ? 0 : row.getLastCellNum());

		if (val instanceof String) {
			cell.setCellValue((String) val);

		} else if (val instanceof Double) {
			cell.setCellValue((Double) val);

		} else if (val instanceof Boolean) {
			cell.setCellValue((Boolean) val);

		} else if (val instanceof Date) {
			cell.setCellValue(val.toString());

		} else if (val instanceof Calendar) {
			cell.setCellValue((Calendar) val);

		} else if (val instanceof Float) {
			cell.setCellValue((Float) val);

		} else if (val instanceof BigDecimal) { // boolean comes here
			cell.setCellValue(((BigDecimal) val).doubleValue() == 1);

		} else if (val instanceof Integer) {
			cell.setCellValue((Integer) val);
		}
	}
	
	private void addComment(Workbook workbook, Sheet sheet, int rowIdx, int colIdx, String author, String commentText) {
		CreationHelper factory = workbook.getCreationHelper();
		// get an existing cell or create it otherwise:
		Cell cell = getOrCreateCell(sheet, rowIdx, colIdx);

		ClientAnchor anchor = factory.createClientAnchor();
		// i found it useful to show the comment box at the bottom right corner
		anchor.setCol1(cell.getColumnIndex() + 1); // the box of the comment starts at this given column
		anchor.setCol2(cell.getColumnIndex() + 5); // ...and ends at that given column
		anchor.setRow1(rowIdx + 1); // one row below the cell
		anchor.setRow2(rowIdx + 7); // ...and 5 rows high
		anchor.setAnchorType(AnchorType.MOVE_AND_RESIZE);

		Drawing<?> drawing = sheet.createDrawingPatriarch();
		Comment comment = drawing.createCellComment(anchor);
		// set the comment text and author
		comment.setString(factory.createRichTextString(commentText));
		comment.setAuthor(author);

		cell.setCellComment(comment);
	}

	private Cell getOrCreateCell(Sheet sheet, int rowIdx, int colIdx) {
		Row row = sheet.getRow(rowIdx);
		if (row == null) {
			row = sheet.createRow(rowIdx);
		}
		Cell cell = row.getCell(colIdx);
		if (cell == null) {
			cell = row.createCell(colIdx);
		}
		return cell;
	}
	
	private void addDropdownValues(Sheet sheet, String[] values, int firstRow, int lastRow, int firstColumn, int lastColumn) {
		DataValidationHelper helper = sheet.getDataValidationHelper();
		CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstColumn, lastColumn);
		DataValidationConstraint dvConstraint = helper.createExplicitListConstraint(values);
		DataValidation dataValidation = helper.createValidation(dvConstraint, addressList);
		dataValidation.setSuppressDropDownArrow(true);
		sheet.addValidationData(dataValidation);
	}
	
	private List<MailAttachment> getMailAttachments(byte[] bytes,String fileName) {
		List<MailAttachment> attachments = new ArrayList<>();
		MailAttachment attachment = new MailAttachment();
		attachment.setContent(Base64.encodeBase64String(bytes));
		attachment.setType(EXCEL_MIME_TYPE);
		attachment.setName(fileName);
		attachments.add(attachment);
		return attachments;
	}
	
}

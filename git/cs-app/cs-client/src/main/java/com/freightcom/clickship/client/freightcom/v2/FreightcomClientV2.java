package com.freightcom.clickship.client.freightcom.v2;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.freightcom.clickship.model.carrier.freightcom.v2.FCConvertCurrency;
import com.freightcom.clickship.model.carrier.freightcom.v2.FreightcomApiEndpoints;
import com.freightcom.clickship.model.carrier.freightcom.v2.FreightcomCustomer;
import com.freightcom.clickship.model.v2.CartBookingRequest;
import com.freightcom.clickship.model.v2.CartBookingResponse;
import com.freightcom.clickship.model.v2.CartBookingStatus;
import com.freightcom.clickship.model.v2.CartResponse;
import com.freightcom.clickship.model.v2.CartShipmentRequest;
import com.freightcom.clickship.model.v2.CartWithShipments;
import com.freightcom.clickship.model.v2.CustomerResponseDTO;
import com.freightcom.clickship.model.v2.DocumentForEntityResponseDTO;
import com.freightcom.clickship.model.v2.FcSchedulePickupResponse;
import com.freightcom.clickship.model.v2.FcV2customer;
import com.freightcom.clickship.model.v2.InvoiceResponse;
import com.freightcom.clickship.model.v2.PackageDropOffLocations;
import com.freightcom.clickship.model.v2.PaymentMethodsPostRequestV2;
import com.freightcom.clickship.model.v2.PaymentMethodsReponseV2;
import com.freightcom.clickship.model.v2.PickupAvailability;
import com.freightcom.clickship.model.v2.PickupAvailabilityReq;
import com.freightcom.clickship.model.v2.PostRatesResponseDTO;
import com.freightcom.clickship.model.v2.RateBody;
import com.freightcom.clickship.model.v2.RateCardResponseDTO;
import com.freightcom.clickship.model.v2.SaveDocumentResponseDTO;
import com.freightcom.clickship.model.v2.SendDocumentEmailRequestDTO;
import com.freightcom.clickship.model.v2.SendDocumentEmailResponseDTO;
import com.freightcom.clickship.model.v2.ShipmentBody;
import com.freightcom.clickship.model.v2.ShipmentIdScheduleBody;
import com.freightcom.clickship.model.v2.ShipmentResponse;
import com.freightcom.clickship.model.v2.ShipmentResponseV2;
import com.freightcom.clickship.model.v2.UserPasswordDTO;
import com.freightcom.clickship.model.v2.claim.CSClaimDTO;
import com.freightcom.clickship.model.v2.claim.ClaimDTO;
import com.freightcom.clickship.model.v2.claim.ClaimDashBoardSettledSummaryDTO;
import com.freightcom.clickship.model.v2.claim.ClaimDashboardLastViewedAtDTO;
import com.freightcom.clickship.model.v2.claim.ClaimIDResponseDTO;
import com.freightcom.clickship.model.v2.claim.ClaimPaymentDTO;
import com.freightcom.clickship.model.v2.claim.ClaimSearchResponseDTO;
import com.freightcom.clickship.model.v2.claim.ConversationResponse;
import com.freightcom.clickship.model.v2.claim.CreateThreadRequest;
import com.freightcom.clickship.model.v2.claim.CreateThreadResponse;
import com.freightcom.clickship.model.v2.claim.DateRange;
import com.freightcom.clickship.model.v2.claim.File;
import com.freightcom.clickship.model.v2.claim.FinancialDocumentResponse;
import com.freightcom.clickship.model.v2.claim.GetDownloadURLRequestDTO;
import com.freightcom.clickship.model.v2.claim.GetDownloadURLResponseDTO;
import com.freightcom.clickship.model.v2.claim.GetFCPreferenceResponse;
import com.freightcom.clickship.model.v2.claim.GetUploadURLResponseDTO;
import com.freightcom.clickship.model.v2.claim.PaymentMethodResponse;
import com.freightcom.clickship.model.v2.claim.PostMessageRequest;
import com.freightcom.clickship.model.v2.claim.PostPreferenceRequest;
import com.freightcom.clickship.model.v2.claim.SearchClaimRequest;
import com.freightcom.clickship.model.v2.claim.SearchClaimResponse;
import com.freightcom.clickship.model.v2.claim.SettledSummaryResponse;
import com.freightcom.clickship.model.v2.claim.SimpleClaimDashboardLastViewedAtDTO;
import com.freightcom.clickship.model.v2.claim.StaticSummaryResponse;
import com.freightcom.clickship.model.v2.claim.TerminatedSummaryResponse;
import com.freightcom.clickship.model.v2.claim.ThreadReadRequest;
import com.freightcom.clickship.model.v2.invoice.FinancialDocumentRequest;
import com.freightcom.clickship.model.v2.invoice.GenerateReport;
import com.freightcom.clickship.model.v2.invoice.GenerateReportResponse;
import com.freightcom.clickship.model.v2.invoice.InvoiceDocument;
import com.freightcom.clickship.model.v2.invoice.InvoicePaidSummary;
import com.freightcom.clickship.model.v2.invoice.InvoiceStaticSummary;
import com.freightcom.clickship.model.v2.invoice.OriginalInvoiceResponse;
import com.freightcom.clickship.model.v2.invoice.OutstandingBalances;
import com.freightcom.clickship.model.v2.invoice.PackagingItems;
import com.freightcom.clickship.model.v2.invoice.PayInvoicesRequest;
import com.freightcom.clickship.model.v2.invoice.PayInvoicesResponse;
import com.freightcom.clickship.model.v2.invoice.PostReportResponse;
import com.freightcom.clickship.model.v2.invoice.SearchInvoiceResponse;
import com.freightcom.clickship.model.v2.invoice.SearchInvoicesRequest;
import com.freightcom.clickship.model.v2.invoice.SearchShipmentResponse;
import com.freightcom.clickship.model.v2.invoice.ShipmentLineItems;

@Component
public class FreightcomClientV2 {

	private static final String SHIPMENT = "/shipment/";
	private static final String CUSTOMER = "/customer/";
	private static final String SCHEDULE = "/schedule";
	private static final String X_ADMIN_USER_ID = "x-admin-user-id";
	private static final String FINANCE_DOCUMENT = "/finance/document/";

	private Logger logger = LogManager.getLogger(FreightcomClientV2.class);
	
	@Value("${freightcomv2.url}")
	private String v2URL;
	
	@Value("${freightcomv2.apikey}")
	private String internalApiKey;
	
	@Autowired
	private RestTemplate restTemplate;

	private ObjectMapper mapper = new ObjectMapper();

	private HttpHeaders getHeaders(String apiKey, String fcUserId) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		headers.set(HttpHeaders.AUTHORIZATION, apiKey);
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		if (StringUtils.isNotEmpty(fcUserId)) {
			headers.set(X_ADMIN_USER_ID, fcUserId);
		}
		return headers;
	}

	public PostRatesResponseDTO postRate(RateBody rateCardRequest, String customerId) {
		return postRate(rateCardRequest, customerId, false, "");
	}

	public RateCardResponseDTO getRates(String rateId, String customerId, String reqId) {
		return getRates(rateId, customerId, reqId, false);
	}

	public PostRatesResponseDTO postRate(RateBody rateCardRequest, String customerId, boolean isEncryptedOrder, String reqId) {
		return call("/rate/" + customerId, HttpMethod.POST, rateCardRequest, PostRatesResponseDTO.class, true, isEncryptedOrder, reqId);
	}

	public RateCardResponseDTO getRates(String rateId, String customerId, String reqId, boolean isEncryptedOrder) {
		return call("/rate/" + customerId + "/" + rateId, HttpMethod.GET, null, RateCardResponseDTO.class, false, isEncryptedOrder, reqId);
	}

	public void cancelPickupOrder(String shipmentID, String customerId, String fcUserId) {
		callWithFcUserId(SHIPMENT + customerId + "/" + shipmentID + SCHEDULE, HttpMethod.DELETE, null, Void.class, true, false, "", fcUserId);
	}

	public void cancelShipment(String shipmentID, String customerId, String fcUserId) {
		callWithFcUserId(SHIPMENT + customerId + "/" + shipmentID, HttpMethod.DELETE, null, Void.class, true, false, "", fcUserId);
	}
	
	public void approveCustomer(String customerId) {
		call(CUSTOMER + customerId + "/approve", HttpMethod.POST, null, Void.class, true);
	}
	
	public void emailVerified(String customerId, String userId) {
		call("/user/" + customerId + "/" + userId + "/verify-email", HttpMethod.POST, null, Void.class, true);
	}

	public CustomerResponseDTO registerAccount(FcV2customer fcV2Customer) {
		return call("/customer", HttpMethod.POST, fcV2Customer, CustomerResponseDTO.class, true);
	}
	
	public CustomerResponseDTO getCustomer(String fcCustomerId) {
		return call(CUSTOMER + fcCustomerId, HttpMethod.GET, null, CustomerResponseDTO.class, true);
	}
	
	public FreightcomCustomer getFreightcomCustomer(String fcCustomerId) {
		return call(CUSTOMER + fcCustomerId, HttpMethod.GET, null, FreightcomCustomer.class, true);
	}

	public CustomerResponseDTO getCustomerDetails(FcV2customer fcV2Customer) {
		return call("/customer/details", HttpMethod.POST, fcV2Customer, CustomerResponseDTO.class, true);
	}

	public CustomerResponseDTO updateCustomer(FcV2customer fcV2Customer, String customerId) {
		return call(CUSTOMER + customerId, HttpMethod.POST, fcV2Customer, CustomerResponseDTO.class, true);
	}
	
	public void updatePassword(UserPasswordDTO userPasswordDTO, String userId,String customerId) {
		call("/user/" + customerId + "/" + userId + "/password", HttpMethod.POST, userPasswordDTO, CustomerResponseDTO.class, true);
	}

	public void schedulePickup(String shipmentID, String customerId, ShipmentIdScheduleBody shipmentSchedule, String fcUserId) {
		callWithFcUserId(SHIPMENT + customerId + "/" + shipmentID + SCHEDULE, HttpMethod.POST, shipmentSchedule, Void.class, true, false, "", fcUserId);
	}

	public FcSchedulePickupResponse getPickup(String shipmentId, String customerId) {
		return call(SHIPMENT + customerId + "/" + shipmentId + SCHEDULE, HttpMethod.GET, null, FcSchedulePickupResponse.class, true);
	}

	public String shipOrder(ShipmentBody shipmentBody, String customerId) {
		return shipOrder(shipmentBody, customerId, false, "");
	}

	public String shipOrder(ShipmentBody shipmentBody, String customerId, boolean isEncryptedOrder, String fcUserId) {
		ShipmentResponseV2 res = callWithFcUserId(SHIPMENT + customerId, HttpMethod.POST, shipmentBody, ShipmentResponseV2.class, true, isEncryptedOrder, "", fcUserId);
		return res != null ? res.getId() : null;
	}

	public ShipmentResponse getShipment(String shipmentId, String customerId, boolean isEncryptedOrder) {
		return call(SHIPMENT + customerId + "/" + shipmentId, HttpMethod.GET, null, ShipmentResponse.class, false, isEncryptedOrder, "");
	}

	public ShipmentResponse getBulkShipment(String shipmentId, String customerId, boolean printLog, boolean isEncryptedOrder) {
		return call(SHIPMENT + customerId + "/" + shipmentId, HttpMethod.GET, null, ShipmentResponse.class, printLog, isEncryptedOrder, "");
	}

	public PaymentMethodsReponseV2 postPaymentMethods(PaymentMethodsPostRequestV2 paymentMethods, String customerId) {
		return call("/finance/" + customerId + "/payment-methods", HttpMethod.POST, paymentMethods, PaymentMethodsReponseV2.class, true);
	}
	
	public PaymentMethodsReponseV2[] getPaymentMethods(String customerId) {
		return call("/finance/" + customerId + "/payment-methods", HttpMethod.GET, null, PaymentMethodsReponseV2[].class, true);
	}

	public InvoiceResponse[] getFreightcomV2Invoice(String customerId, String shipmentId) {
		return call("/finance/" + customerId + "/invoices-for-shipment-id/" + shipmentId, HttpMethod.GET, null, InvoiceResponse[].class, false);
	}

	public PickupAvailability schedulingValidate(String customerId, PickupAvailabilityReq req) {
		return call("/shipment/" + customerId + "/scheduling-validate", HttpMethod.POST, req, PickupAvailability.class, true);
	}

	public String createShipment(ShipmentBody shipmentBody, String customerId, boolean isEncryptedOrder, String fcUserId) {
		ShipmentResponseV2 res = callWithFcUserId("/shipment/" + customerId +"/create", HttpMethod.POST, shipmentBody, ShipmentResponseV2.class, true, isEncryptedOrder,"", fcUserId);
		return res.getId();
	}
	
	public void addShipmentsToCart(String customerId, String cartId, CartShipmentRequest cartShipments, String fcUserId) {
		callWithFcUserId("/customer/" + customerId + "/cart/"+cartId+"/shipments", HttpMethod.POST, cartShipments, Void.class, true, false, "", fcUserId);
	}
	
	public PaymentMethodResponse getPaymentMethod(String customerId) {
		return call(CUSTOMER + customerId + "/payment/method-for-claim-payout", HttpMethod.GET, null, PaymentMethodResponse.class, true);
	}
	
	public String createCart(String customerId) {
		CartResponse cartResponse =  call("/customer/" + customerId + "/carts", HttpMethod.POST, null, CartResponse.class, false);
		return cartResponse !=null ? cartResponse.getCartId() : null;
	}
	
	public CartWithShipments getCartWithShipments(String customerId, String cartId ) {
		return call("/customer/" + customerId + "/cart/"+cartId+"/with-shipments", HttpMethod.GET, null, CartWithShipments.class, true);
	}
	
	public String cartBookingInitiate(String customerId, String cartId, CartBookingRequest cartBookingRequest,
			String fcUserId) {
		CartBookingResponse cartBookingResponse = callWithFcUserId(
				"/customer/" + customerId + "/cart/" + cartId + "/booking-request", HttpMethod.POST, cartBookingRequest,
				CartBookingResponse.class, true, false, "", fcUserId);
		return cartBookingResponse != null ? cartBookingResponse.getBookingRequestId() : null;
	}
	
	public CartBookingStatus cartBookingStatus(String customerId, String cartId) {
		return call("/customer/" + customerId + "/cart/"+cartId+"/booking-request", HttpMethod.GET, null, CartBookingStatus.class, true);
	}
	
	public FCConvertCurrency convertCurrency(FCConvertCurrency dto) {
		return call(FreightcomApiEndpoints.CONVERT_CURRENCY.getValue(), HttpMethod.POST, dto, FCConvertCurrency.class,
				true);
	}

	public PackageDropOffLocations getPickupDropOffLocations(String country, String postalCode, String searchRadius,
			String unitOfMeasurement) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/address/ups/depots");
		builder.queryParam("country", country);
		builder.queryParam("postal_code", postalCode);
		builder.queryParam("search_radius", searchRadius);
		builder.queryParam("unit_of_measurement", unitOfMeasurement);

		String url = builder.toUriString();

		return call(url, HttpMethod.GET, null, PackageDropOffLocations.class, false);
	}
	
	public String trackShipment(String freightcomOrderId, String customerId, boolean isEncryptedOrder) {
		ShipmentResponse shipmentResponse = getShipment(freightcomOrderId, customerId, isEncryptedOrder);
		return shipmentResponse.getShipmentResponseDto().getState();
	}

	public void saveFCCustomerPreference(String fcUserId, String customerId, String key, PostPreferenceRequest request) {
		callWithFcUserId("/customer/" + customerId + "/preference/" + key, HttpMethod.POST, request, Void.class, true, false, null, fcUserId);
	}
	
	public GetFCPreferenceResponse getFCCustomerPreference(String fcUserId, String customerId) {
		return callWithFcUserId("/customer/" + customerId + "/preferences", HttpMethod.GET, null, GetFCPreferenceResponse.class, true, false, null, fcUserId);
	}
	
	public SearchClaimResponse getClaims(String fcUserId, String customerId, SearchClaimRequest request) {
		return callWithFcUserId("/claim/customer/" + customerId + "/claims/filter", HttpMethod.POST, request, SearchClaimResponse.class, false, false, null, fcUserId);
	}

	public CSClaimDTO getClaim(String fcUserId, String customerId, String claimId) {
		return callWithFcUserId(CUSTOMER + customerId + "/claim/" + claimId, HttpMethod.GET, null, CSClaimDTO.class, true, false, null, fcUserId);
	}
	
	public ClaimSearchResponseDTO getClaimForShipment(String fcUserId, String customerId, String shipmentId) {
		return callWithFcUserId(CUSTOMER + customerId + "/claims/for-shipment/" + shipmentId, HttpMethod.GET, null, ClaimSearchResponseDTO.class, true, false, null, fcUserId);
	}

	public void readClaim(String fcUserId, String customerId, String claimId) {
		callWithFcUserId(CUSTOMER + customerId + "/claim/" + claimId + "/read", HttpMethod.POST, null, Void.class, true, false, null, fcUserId);
	}

	public void submitClaim(String fcUserId, String customerId, String claimId) {
		callWithFcUserId(CUSTOMER + customerId + "/claim/" + claimId + "/submit", HttpMethod.POST, null, Void.class, true, false, null, fcUserId);
	}

	public void cancelClaim(String fcUserId, String customerId, String claimId) {
		callWithFcUserId(CUSTOMER + customerId + "/claim/" + claimId + "/cancel", HttpMethod.POST, null, Void.class, true, false, null, fcUserId);
	}

	public ClaimDashBoardSettledSummaryDTO getClaimDashboard(String fcUserId, String customerId, String summaryType, ClaimDashboardLastViewedAtDTO dto) {
		return callWithFcUserId(CUSTOMER + customerId + "/dashboard" + "/claim/" + summaryType, HttpMethod.GET, dto, ClaimDashBoardSettledSummaryDTO.class, true, false, null, fcUserId);
	}

	public ClaimDashboardLastViewedAtDTO getClaimDashboardLastViewedAt(String fcUserId, String customerId) {
		String uString = CUSTOMER + customerId + "/dashboard/last-viewed-at/customer-portal-claim";
		return callWithFcUserId(uString, HttpMethod.GET, null, ClaimDashboardLastViewedAtDTO.class, true, false, null, fcUserId);
	}

	public void updateClaimDashboardLastViewdAt(String fcUserId, String customerId, SimpleClaimDashboardLastViewedAtDTO dto) {
		String uString = CUSTOMER + customerId + "/dashboard/last-viewed-at/customer-portal-claim";
		callWithFcUserId(uString, HttpMethod.POST, dto, Void.class, true, false, null, fcUserId);
	}

	public SendDocumentEmailResponseDTO sendEmailForEntity(String fcUserId, String customerId, SendDocumentEmailRequestDTO dto) {
		String uString = CUSTOMER + customerId + "/documents/archive/send-email-for-entity";
		return callWithFcUserId(uString, HttpMethod.POST, dto, SendDocumentEmailResponseDTO.class, true, false, null, fcUserId);
	}

	public GetDownloadURLResponseDTO getDownloadURL(String fcUserId, String customerId, GetDownloadURLRequestDTO dto) {
		String uString = CUSTOMER + customerId + "/documents/download-url";
		return callWithFcUserId(uString, HttpMethod.POST, dto, GetDownloadURLResponseDTO.class, true, false, null, fcUserId);
	}
	
	public SaveDocumentResponseDTO saveDocument(String fcUserId, String customerId, GetDownloadURLRequestDTO dto) {
		String uString = CUSTOMER + customerId + "/documents";
		return callWithFcUserId(uString, HttpMethod.POST, dto, SaveDocumentResponseDTO.class, true, false, null, fcUserId);
	}
	
	public void deleteDocument(String fcUserId, String customerId, String documentId) {
		callWithFcUserId(CUSTOMER + customerId + "/document/" + documentId, HttpMethod.DELETE, null, Void.class, true, false, null, fcUserId);
	}

	public DocumentForEntityResponseDTO getDocumentEntityId(String fcUserId, String customerId, String documentEntityId, String documentEntityType) {
		String uString = CUSTOMER + customerId + "/documents/for-entity?document_entity_id=" + documentEntityId + "&document_entity_type=" + documentEntityType;
		return callWithFcUserId(uString, HttpMethod.GET, null, DocumentForEntityResponseDTO.class, true, false, null, fcUserId);
	}
	
	public DocumentForEntityResponseDTO getInvoiceForClaim(String fcUserId, String customerId, String claimId) {
		String uString = CUSTOMER + customerId + "/finance/invoices-for-claim-payout/" + claimId;
		return callWithFcUserId(uString, HttpMethod.GET, null, DocumentForEntityResponseDTO.class, true, false, null, fcUserId);
	}
	
	public FinancialDocumentResponse getFinancialDocument(String fcUserId, String customerId, String documentId) {
		String uString = CUSTOMER + customerId + FINANCE_DOCUMENT + documentId + "/file-request";
		return callWithFcUserId(uString, HttpMethod.GET, null, FinancialDocumentResponse.class, true, false, null, fcUserId);
	}
	
	public GetUploadURLResponseDTO getUploadURL(String fcUserId, String customerId, String documentEntityType, String documentEntityId, String fileName) {
		String uString = CUSTOMER + customerId + "/documents/upload-url?document_entity_id=" + documentEntityId + "&document_entity_type=" + documentEntityType + "&file_name=" + fileName;
		return callWithFcUserId(uString, HttpMethod.GET, null, GetUploadURLResponseDTO.class, true, false, null, fcUserId);
	}
	
	public ClaimIDResponseDTO createClaim(String fcUserId, String customerId, CSClaimDTO dto) {
		String uString = CUSTOMER + customerId + "/claims";
		return callWithFcUserId(uString, HttpMethod.POST, dto, ClaimIDResponseDTO.class, true, false, null, fcUserId);
	}
	
	public void updateClaim(String fcUserId, String customerId, CSClaimDTO dto) {
		callWithFcUserId(CUSTOMER + customerId + "/claim/" + dto.getClaimDto().getId(), HttpMethod.POST, dto, ClaimDTO.class, true, false, null, fcUserId);
	}
	
	public SendDocumentEmailResponseDTO downloadAllDocuments(String fcUserId, String customerId, SendDocumentEmailRequestDTO request) {
		String uString = CUSTOMER + customerId + "/documents/archive/download-for-entity";
		return callWithFcUserId(uString, HttpMethod.POST, request, SendDocumentEmailResponseDTO.class, true, false, null, fcUserId);
	}
	
	public ConversationResponse getConversation(String fcUserId, String customerId, String claimId) {
		String uString = CUSTOMER + customerId + "/threads/for-entity?entity_id=" + claimId + "&entity_type=claim";
		return callWithFcUserId(uString, HttpMethod.GET, null, ConversationResponse.class, true, false, null, fcUserId);
	}
	
	public File postMessage(String fcUserId, String threadId, PostMessageRequest request) {
		String uString = "/thread/" + threadId + "/messages";
		return callWithFcUserId(uString, HttpMethod.POST, request, File.class, true, false, null, fcUserId);
	}
	
	public CreateThreadResponse createThread(String fcUserId, String customerId, CreateThreadRequest request) {
		String uString = CUSTOMER + customerId + "/threads";
		return callWithFcUserId(uString, HttpMethod.POST, request, CreateThreadResponse.class, true, false, null, fcUserId);
	}
	
	/**
	 * This endpoint has an error 'bad or missing data', 'is not a user', asked Mahesh to check on 2023-08-24
	 * 
	 * @param fcUserId
	 * @param fcCustomerId
	 * @param threadId
	 */
	public void readThread(String fcUserId, String fcCustomerId, String threadId) {
		String uString = "/thread/" + threadId + "/read";
		callWithFcUserId(uString, HttpMethod.POST, new ThreadReadRequest(), Void.class, true, false, null, fcUserId);
	}
	
	public StaticSummaryResponse staticSummary(String fcUserId, String customerId, SimpleClaimDashboardLastViewedAtDTO dto) {
		String uString = CUSTOMER + customerId + "/dashboard/claim/static-summary";
		return callWithFcUserId(uString, HttpMethod.POST, dto, StaticSummaryResponse.class, true, false, null, fcUserId);
	}
	
	public TerminatedSummaryResponse terminatedSummary(String fcUserId, String customerId, SimpleClaimDashboardLastViewedAtDTO dto) {
		String uString = CUSTOMER + customerId + "/dashboard/claim/terminated-summary";
		return callWithFcUserId(uString, HttpMethod.POST, dto, TerminatedSummaryResponse.class, true, false, null, fcUserId);
	}

	public CSClaimDTO acceptPayout(String fcUserId, String claimId, ClaimPaymentDTO claimPaymentDTO) {
		Map<String, Object> map = new HashMap<>();
		map.put("payout", claimPaymentDTO);
		String uString = "/claim/" + claimId + "/accept-payout";
		return callWithFcUserId(uString, HttpMethod.POST, map, CSClaimDTO.class, true, false, null, fcUserId);
	}
	
	public SettledSummaryResponse settledSummary(String fcUserId, String customerId, SimpleClaimDashboardLastViewedAtDTO dto) {
		String uString = CUSTOMER + customerId + "/dashboard/claim/settled-summary";
		return callWithFcUserId(uString, HttpMethod.POST, dto, SettledSummaryResponse.class, true, false, null, fcUserId);
	}

	public InvoiceStaticSummary invoiceStaticSummary(String fcUserId, String customerId) {
		String uString = CUSTOMER + customerId + "/dashboard/invoice/static-summary";
		return callWithFcUserId(uString, HttpMethod.GET, null, InvoiceStaticSummary.class, true, false, null, fcUserId);
	}
	
	public InvoicePaidSummary invoicePaidSummary(String fcUserId, String customerId, DateRange dto) {
		String uString = CUSTOMER + customerId + "/dashboard/invoice/paid-summary";
		return callWithFcUserId(uString, HttpMethod.POST, dto, InvoicePaidSummary.class, true, false, null, fcUserId);
	}
	
	public SearchInvoiceResponse filterInvoices(String fcUserId, String customerId, SearchInvoicesRequest dto) {
		String uString = CUSTOMER + customerId + "/finance/filter-invoices";
		return callWithFcUserId(uString, HttpMethod.POST, dto, SearchInvoiceResponse.class, true, false, null, fcUserId);
	}
	
	public OutstandingBalances invoiceOutstandingBalances(String fcUserId, String customerId) {
		String uString = CUSTOMER + customerId + "/finance/outstanding-balances";
		return callWithFcUserId(uString, HttpMethod.GET, null, OutstandingBalances.class, true, false, null, fcUserId);
	}

	public PayInvoicesResponse[] payInvoices(String fcUserId, String customerId, PayInvoicesRequest dto) {
		String uString = CUSTOMER + customerId + "/payment/method/pay-invoices";
		return callWithFcUserId(uString, HttpMethod.POST, dto, PayInvoicesResponse[].class, true, false, null, fcUserId);
	}

	public PostRatesResponseDTO getArchiveDocumentRequestId(String fcUserId, String customerId,
			FinancialDocumentRequest dto) {
		String uString = CUSTOMER + customerId + "/finance/documents/archive/start";
		return callWithFcUserId(uString, HttpMethod.POST, dto, PostRatesResponseDTO.class, true, false, null, fcUserId);
	}

	public SendDocumentEmailResponseDTO getArchiveDocument(String fcUserId, String customerId, String requestID) {
		String uString = CUSTOMER + customerId + "/finance/documents/archive/download/" + requestID;
		return callWithFcUserId(uString, HttpMethod.GET, null, SendDocumentEmailResponseDTO.class, true, false, null,
				fcUserId);
	}

	public InvoiceDocument getFinancialDocumentById(String fcUserId, String customerId, String documentId) {
		String uString = CUSTOMER + customerId + FINANCE_DOCUMENT + documentId;
		return callWithFcUserId(uString, HttpMethod.GET, null, InvoiceDocument.class, true, false, null, fcUserId);
	}

	public SearchShipmentResponse getShipmentFinancialdDocument(String fcUserId, String customerId, String documentId,
			SearchInvoicesRequest dto) {
		String uString = CUSTOMER + customerId + "/shipments/for-financial-document/" + documentId;
		return callWithFcUserId(uString, HttpMethod.POST, dto, SearchShipmentResponse.class, true, false, null,
				fcUserId);
	}

	public InvoiceDocument getFinancialdDocumentsByShipmentId(String fcUserId, String customerId, String shipmentId) {
		String uString = CUSTOMER + customerId + "/shipment/" + shipmentId + "/financial-documents";
		return callWithFcUserId(uString, HttpMethod.GET, null, InvoiceDocument.class, true, false, null, fcUserId);
	}

	public ShipmentLineItems getShipmentLineItems(String fcUserId, String customerId, String documentId,
			String shipmentId) {
		String uString = CUSTOMER + customerId + FINANCE_DOCUMENT + documentId + "/line-items-for-shipment/"
				+ shipmentId;
		return callWithFcUserId(uString, HttpMethod.GET, null, ShipmentLineItems.class, true, false, null, fcUserId);
	}

	public PackagingItems getPackagingItems(String fcUserId, String customerId, String documentId) {
		String uString = CUSTOMER + customerId + FINANCE_DOCUMENT + documentId + "/packaging-items";
		return callWithFcUserId(uString, HttpMethod.GET, null, PackagingItems.class, true, false, null, fcUserId);
	}

	public PostReportResponse getGenerateReportRequestId(String fcUserId, String customerId, GenerateReport dto) {
		String uString = CUSTOMER + customerId + "/reports/generate-request/start";
		return callWithFcUserId(uString, HttpMethod.POST, dto, PostReportResponse.class, true, false, null, fcUserId);
	}

	public GenerateReportResponse generateReport(String fcUserId, String customerId, String requestID) {
		String uString = CUSTOMER + customerId + "/report/" + requestID + "/generate-request";
		return callWithFcUserId(uString, HttpMethod.GET, null, GenerateReportResponse.class, true, false, null,
				fcUserId);
	}

	public GenerateReportResponse getShipmentLabelRequest(String fcUserId, String customerId, String shipmentId) {
		String uString = CUSTOMER + customerId + SHIPMENT + shipmentId + "/label-request";
		return callWithFcUserId(uString, HttpMethod.GET, null, GenerateReportResponse.class, true, false, null,
				fcUserId);
	}

	public OriginalInvoiceResponse filterOriginalInvoices(String fcUserId, String customerId, String documentId,
			SearchInvoicesRequest dto) {
		String uString = CUSTOMER + customerId + FINANCE_DOCUMENT + documentId + "/filter-original-invoices";
		return callWithFcUserId(uString, HttpMethod.POST, dto, OriginalInvoiceResponse.class, true, false, null,
				fcUserId);
	}
		
	private <T> T call(String url, HttpMethod method, Object req, Class<?> cls, boolean printLog) {
		return call(url, method, req, cls, printLog, false, "");
	}

	private <T> T call(String url, HttpMethod method, Object req, Class<?> cls, boolean printLog, boolean isEncryptedOrder, String reqId) {
		return callWithFcUserId(url, method, req, cls, printLog, isEncryptedOrder, reqId, null);
	}
	
	@SuppressWarnings("unchecked")
	private <T> T callWithFcUserId(String url, HttpMethod method, Object req, Class<?> cls, boolean printLog, boolean isEncryptedOrder, String reqId, String fcUserId) {
		if (printLog) {
			logObject(v2URL + url, req, reqId, isEncryptedOrder, true, method);
		}

		@SuppressWarnings("rawtypes")
		ResponseEntity entity = getResponseEntity(url, method, req, cls, fcUserId);
		Object res = entity.getBody();

		if (printLog) {
			logObject(v2URL + url, res, reqId, isEncryptedOrder, false, method);
		}

		return (T) res;
	}

	private ResponseEntity<?> getResponseEntity(String url, HttpMethod method, Object req, Class<?> cls, String fcUserId) {
		HttpHeaders headers = getHeaders(internalApiKey, fcUserId);
		return restTemplate.exchange(v2URL + url, method, req == null ? new HttpEntity<>(headers) : new HttpEntity<>(req, headers), cls);
	}

	public void logObject(String url, Object object, String reqId, boolean isEncryptedOrder, boolean isRequest, HttpMethod method) {
		String log = "";
		try {
			if (isEncryptedOrder) {
				ObjectMapper mixMapper = new ObjectMapper();
				mixMapper.addMixIn(Object.class, PropertyFilterMixIn.class);
				String[] ignorableFieldNames = { "contact_name", "name", "phone_number", "address_line1", "postal_code" };
				FilterProvider filters = new SimpleFilterProvider().addFilter("filter properties by name",
						SimpleBeanPropertyFilter.serializeAllExcept(ignorableFieldNames));
				ObjectWriter writer = mixMapper.writer(filters);
				log = writer.writeValueAsString(object);
			} else {
				log = mapper.writeValueAsString(object);
			}
			logger.info("[{}] - {} {} ; {} : {}", reqId, method, StringUtils.isNotEmpty(url) ? url : "", isRequest ? "Req" : "Res", log);

		} catch (Exception e) {
			logger.error("[{}] - Error while logging request object : Error {}", reqId,e);
		}
	}

	@JsonFilter("filter properties by name")
	class PropertyFilterMixIn {
	}

}

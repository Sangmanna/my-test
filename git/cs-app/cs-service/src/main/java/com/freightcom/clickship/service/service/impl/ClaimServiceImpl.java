package com.freightcom.clickship.service.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.freightcom.clickship.client.freightcom.v2.FreightcomClientV2;
import com.freightcom.clickship.data.entity.Carrier;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Shipment;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.rep.OrderRepository;
import com.freightcom.clickship.data.rep.ShipmentRepository;
import com.freightcom.clickship.model.enums.PackageType;
import com.freightcom.clickship.model.util.ClickshipStringUtil;
import com.freightcom.clickship.model.v2.DocumentForEntityResponseDTO;
import com.freightcom.clickship.model.v2.EntityIdDTO;
import com.freightcom.clickship.model.v2.SaveDocumentResponseDTO;
import com.freightcom.clickship.model.v2.SendDocumentEmailRequestDTO;
import com.freightcom.clickship.model.v2.SendDocumentEmailResponseDTO;
import com.freightcom.clickship.model.v2.claim.CSClaimDTO;
import com.freightcom.clickship.model.v2.claim.ClaimDTO;
import com.freightcom.clickship.model.v2.claim.ClaimDashBoardSettledSummaryDTO;
import com.freightcom.clickship.model.v2.claim.ClaimDashboardLastViewedAtDTO;
import com.freightcom.clickship.model.v2.claim.ClaimIDResponseDTO;
import com.freightcom.clickship.model.v2.claim.ClaimPaymentDTO;
import com.freightcom.clickship.model.v2.claim.ConversationResponse;
import com.freightcom.clickship.model.v2.claim.ConversationResponse.Thread;
import com.freightcom.clickship.model.v2.claim.ConversationResponse.Thread.Message;
import com.freightcom.clickship.model.v2.claim.CreateThreadRequest;
import com.freightcom.clickship.model.v2.claim.CreateThreadResponse;
import com.freightcom.clickship.model.v2.claim.CreditCardRefundProperties;
import com.freightcom.clickship.model.v2.claim.File;
import com.freightcom.clickship.model.v2.claim.FinancialDocumentResponse;
import com.freightcom.clickship.model.v2.claim.GetDownloadURLRequestDTO;
import com.freightcom.clickship.model.v2.claim.GetDownloadURLResponseDTO;
import com.freightcom.clickship.model.v2.claim.GetFCPreferenceResponse;
import com.freightcom.clickship.model.v2.claim.GetUploadURLResponseDTO;
import com.freightcom.clickship.model.v2.claim.PostMessageRequest;
import com.freightcom.clickship.model.v2.claim.PostPreferenceRequest;
import com.freightcom.clickship.model.v2.claim.SearchClaimRequest;
import com.freightcom.clickship.model.v2.claim.SearchClaimRequest.CarrierService;
import com.freightcom.clickship.model.v2.claim.SearchClaimResponse;
import com.freightcom.clickship.model.v2.claim.SettledSummaryResponse;
import com.freightcom.clickship.model.v2.claim.SimpleClaimDashboardLastViewedAtDTO;
import com.freightcom.clickship.model.v2.claim.StaticSummaryResponse;
import com.freightcom.clickship.model.v2.claim.TerminatedSummaryResponse;
import com.freightcom.clickship.service.service.ClaimService;
import com.freightcom.clickship.service.service.ICheckAccess;
import com.freightcom.clickship.service.service.ShipmentService;
import com.freightcom.clickship.service.service.UserDetailsService;

import jakarta.transaction.Transactional;

@Service
public class ClaimServiceImpl implements ClaimService, ICheckAccess {
	@Value("${server.domain}")
	private String clickshipDomain;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ShipmentService shipmentService;
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	
	@Autowired
	private FreightcomClientV2 freightcomClientV2;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	
	@Autowired
	com.freightcom.clickship.service.service.CarrierService carrierService;

	@Override
	public SearchClaimResponse getClaims(String fcUserId, String fcCustomerId, SearchClaimRequest request) {
		List<CarrierService> ids = request.getCriteria().getCarrier_service_ids_array();
		if (!CollectionUtils.isEmpty(ids) && ids.stream().map(x -> x.getCarrierId()).anyMatch(x -> StringUtils.equals(x, "Freightcom Pallet Carriers"))) {
			ids.clear();
			List<Carrier> carriers = carrierService.getPalletCarriers();

			Map<String, List<Carrier>> carrierMap = carriers.stream().filter(carrier -> carrier.getV2ServiceId() != null && !carrier.getV2ServiceId().isEmpty())
					.collect(Collectors.groupingBy(carrier -> {
						String[] parts = carrier.getV2ServiceId().split("\\.");
						return parts[0];
					}));
			carrierMap.keySet().forEach(key -> {
				List<Carrier> carrierList = carrierMap.get(key);
				CarrierService palletCarrierService = new CarrierService();
				palletCarrierService.setCarrierId(key);
				palletCarrierService.setServiceIds(carrierList.stream().map(carrier -> carrier.getV2ServiceId().split("\\.")[1]).collect(Collectors.toList()));
				ids.add(palletCarrierService);
			});
		}
		return freightcomClientV2.getClaims(fcUserId, fcCustomerId, request);
	}

	@Override
	public CSClaimDTO getClaim(User user, String id, String claimId) {
		Optional<Order> oOrder = orderRepository.findById(id);

		// order id
		if (oOrder.isPresent()) {
			Order order = oOrder.get();
			checkAccess(user, order);
			return getClaimDTOByOrder(user, order, claimId);
		}
		
		// claim fc_v2_order_id
		return getClaimFromFC(user, id, claimId);
	}

	private CSClaimDTO getClaimFromFC(User user, String id, String claimId) {
		Customer customer = user.getCustomer();
		String fcCustomerId = customer.getFcCustomerId();
		
		ClaimDTO[] claims = freightcomClientV2.getClaimForShipment(userDetailsService.findByCustomer(user.getCustomer()).getFcUserId(), fcCustomerId, id).getClaims();
		
		CSClaimDTO csClaimDTO = new CSClaimDTO();
		if (claims != null && claims.length > 0) {
			if (claims.length == 1) { // came from fc_v2_shipment_id with only one claim
				// if only one claim is cancelled one, and claimId para is 'openNewClaim' return null so that it create new from UI
				if (StringUtils.equalsAnyIgnoreCase("openNewClaim", claimId) && StringUtils.equalsAnyIgnoreCase(claims[0].getState(), "cancelled")) {
					return null;
					
				} else { // simply returns one claim data. either valid or cancelled.
					csClaimDTO.setClaimDto(claims[0]);
				}
				
			} else if (StringUtils.isNotEmpty(claimId) && !StringUtils.equalsAnyIgnoreCase("openNewClaim", claimId)){ // came from claim list with claim ID
				Optional<ClaimDTO> optional = Arrays.stream(claims).filter(c -> StringUtils.equalsAnyIgnoreCase(c.getId(), claimId)).findFirst();
				if (optional.isPresent()) {
					csClaimDTO.setClaimDto(optional.get());
				}
				
			} else { // came from fc_v2_shipment_id with multiple claims including cancelled one
				Optional<ClaimDTO> optional = Arrays.stream(claims).filter(c -> !StringUtils.equalsAnyIgnoreCase(c.getState(), "cancelled")).findFirst();
				if (optional.isPresent()) {
					csClaimDTO.setClaimDto(optional.get());
				}
			}
			
			// all claims are cancelled, then create new one.
			if (csClaimDTO.getClaimDto() == null) {
				return null;
			}
		} else {
			return null;
		}
		
		Shipment shipment = shipmentService.findByFreightcomOrderIdByCustomer(id, user.getCustomer());
		if (shipment != null && shipment.getOrder() != null) {
			Order order = shipment.getOrder();
			setClaimInfoFromClickShip(user, order, shipment, csClaimDTO);
		}
		
		saveClaimStatusFromFC(id, claimId, csClaimDTO, user);
		
		return csClaimDTO;
	}

	private void saveClaimStatusFromFC(String id, String claimId, CSClaimDTO csClaimDTO, User user) {
		if (csClaimDTO.getClaimDto() != null && StringUtils.isNotEmpty(csClaimDTO.getClaimDto().getState())) {
			Shipment claimShipment = shipmentService.findByFreightcomOrderIdByCustomer(id, user.getCustomer());
			if (claimShipment != null && claimShipment.getOrder() != null) {
				shipmentService.updateClaimStatus(claimShipment.getOrder().getId(), claimId, csClaimDTO.getClaimDto().getState());
			}
		}
	}
	
	private CSClaimDTO getClaimDTOByOrder(User user, Order order, String claimId) {
		Shipment shipment = order.getShipment();

		CSClaimDTO csClaimDTO = getClaimFromFC(user, getShipmentId(shipment), claimId);
		if (csClaimDTO == null) {
			CSClaimDTO dto = new CSClaimDTO();
			setClaimInfoFromClickShip(user, order, shipment, dto);
			
			csClaimDTO = dto;
		}
		
		return csClaimDTO;
	}

	private void setClaimInfoFromClickShip(User user, Order order, Shipment shipment, CSClaimDTO dto) {
		CSClaimDTO.Order inOrder = new CSClaimDTO.Order();
		inOrder.setOrderId(order.getId());
		inOrder.setOrderNumber(order.getOrderNumber());
		inOrder.setTrackingNumber(shipment.getTrackingNumber());
		inOrder.setTrackingUrl(shipment.getTrackingURL());
		inOrder.setShipmentState(shipment.getStatus());
		inOrder.setShipDate(order.getShipDate());
		inOrder.setTotalPrice(order.getShippingCost());
		inOrder.setTotalPriceCurrency(order.getShippingCurrency());
		inOrder.setShipmentState(shipment.getStatus());
		inOrder.setPackageType(shipment.getPackageType());
		inOrder.setShipmentId(getShipmentId(shipment));
		
		Carrier carrier = shipment.getCarrier();
		if (carrier != null) {
			inOrder.setCarrier(carrier.getShortName());
			inOrder.setService(carrier.getService());
		}
		
		Marketplace mk = order.getMarketplace();
		if (mk != null) {
			inOrder.setStoreName(mk.getAliasName());
		}
		
		if (shipment.getInsuranceType() != null) {
			inOrder.setInsuranceType(shipment.getInsuranceType());
		}
		inOrder.setInsuranceAmount(shipment.getPackages().stream().mapToDouble(x -> x.getInsuranceAmount()).sum());
		
		inOrder.setBookedBy(ClickshipStringUtil.nvl(user.getFirstName()) + " " + ClickshipStringUtil.nvl(user.getLastName()));
		dto.setOrder(inOrder);
	}

	private String getShipmentId(Shipment shipment) {
		return shipment.getFreightcomV2OrderId();
	}
	
	@Override
	public void readClaim(String fcUserId, String fcCustomerId, String claimId) {
		freightcomClientV2.readClaim(fcUserId, fcCustomerId, claimId);
	}

	@Override
	public void submitClaim(String orderId, String fcUserId, String fcCustomerId, String claimId) {
		freightcomClientV2.submitClaim(fcUserId, fcCustomerId, claimId);
		shipmentService.updateClaimStatus(fcCustomerId, claimId, "pending-review");
	}

	@Override
	@Transactional
	public void cancelClaim(String fcUserId, String customerId, String claimId, String orderId) {
		freightcomClientV2.cancelClaim(fcUserId, customerId, claimId);

		if (StringUtils.isNotEmpty(orderId)) {
			Optional<Order> oOrder = orderRepository.findById(orderId);
			oOrder.ifPresent(order -> {
				Shipment shipment = order.getShipment();
				if (shipment != null) {
					shipment.setIsClaimsRaised(false);
					shipmentService.save(shipment);
				}
			});
		}
	}

	@Override
	public ClaimDashBoardSettledSummaryDTO getClaimDashboard(String fcUserId, String customerId, String summaryType, ClaimDashboardLastViewedAtDTO dto) {
		return freightcomClientV2.getClaimDashboard(fcUserId, customerId, summaryType, dto);
	}

	@Override
	public ClaimDashboardLastViewedAtDTO getClaimDashboardLastViewedAt(String fcUserId, String customerId) {
		return freightcomClientV2.getClaimDashboardLastViewedAt(fcUserId, customerId);
	}

	@Override
	public void updateClaimDashboardLastViewdAt(String fcUserId, String customerId, SimpleClaimDashboardLastViewedAtDTO dto) {
		freightcomClientV2.updateClaimDashboardLastViewdAt(fcUserId, customerId, dto);
	}

	@Override
	public SendDocumentEmailResponseDTO sendEmailForEntity(String fcUserId, String customerId, SendDocumentEmailRequestDTO dto) {
		return freightcomClientV2.sendEmailForEntity(fcUserId, customerId, dto);
	}

	@Override
	public GetDownloadURLResponseDTO getDownloadURL(String fcUserId, String customerId, GetDownloadURLRequestDTO dto) {
		return freightcomClientV2.getDownloadURL(fcUserId, customerId, dto);
	}

	@Override
	public DocumentForEntityResponseDTO getDocumentEntityId(String fcUserId, String customerId, String documentEntityId, String documentEntityType) {
		return freightcomClientV2.getDocumentEntityId(fcUserId, customerId, documentEntityId, documentEntityType);
	}

	@Override
	public ClaimIDResponseDTO createClaim(String fcUserId, String customerId, CSClaimDTO dto) {
		ClaimIDResponseDTO result = freightcomClientV2.createClaim(fcUserId, customerId, dto);
		shipmentService.setClaimRaised(dto.getClaimDto().getCsOrderId(), result.getId());
		return result;
	}

	@Override
	public void updateClaim(String fcUserId, String customerId, CSClaimDTO dto) {
		freightcomClientV2.updateClaim(fcUserId, customerId, dto);
	}
	
	@Override
	public GetUploadURLResponseDTO getUploadUrl(String fcUserId, String customerId, String documentEntityType, String documentEntityId, String fileName) {
		return freightcomClientV2.getUploadURL(fcUserId, customerId, documentEntityType, documentEntityId, fileName);		
	}
	
	@Override
	public SaveDocumentResponseDTO saveDocument(String fcUserId, String customerId, GetDownloadURLRequestDTO dto) {
		return freightcomClientV2.saveDocument(fcUserId, customerId, dto);
	}
	
	@Override
	public void deleteDocument(String fcUserId, String customerId, String documentId) {
		freightcomClientV2.deleteDocument(fcUserId, customerId, documentId);
	}
	
	@Override
	public SendDocumentEmailResponseDTO downloadAllDocuments(String fcUserId, String customerId, String claimId) {
		SendDocumentEmailRequestDTO request = new SendDocumentEmailRequestDTO();
		
		EntityIdDTO entityId = new EntityIdDTO();
		entityId.setId(claimId);
		entityId.setType("claim");
		request.setDocumentEntityId(entityId);
		
		return freightcomClientV2.downloadAllDocuments(fcUserId, customerId, request);
	}
	
	@Override
	public SendDocumentEmailResponseDTO sendDocumentsToEmail(String fcUserId, String customerId, String claimId, String email) {
		SendDocumentEmailRequestDTO request = new SendDocumentEmailRequestDTO();
		
		EntityIdDTO entityId = new EntityIdDTO();
		entityId.setId(claimId);
		entityId.setType("claim");
		request.setDocumentEntityId(entityId);
		
		request.setEmailAddresses(Arrays.asList(email.split(",")));
		
		return freightcomClientV2.sendEmailForEntity(fcUserId, customerId, request);
	}

	@Override
	public ConversationResponse getConversation(String fcUserId, String customerId, String claimId) {
		ConversationResponse response = freightcomClientV2.getConversation(fcUserId, customerId, claimId);

		// FC response does not have sorted result
		if (!CollectionUtils.isEmpty(response.getThreads())) {
			Thread claimThread = response.getThreads().get(0);
			List<Message> messages = claimThread.getMessages();
			claimThread.setMessages(messages.stream().sorted((x, y) -> x.getCreated_at().compareTo(y.getCreated_at())).collect(Collectors.toList()));
		}

		return response;
	}
	
	@Override
	public File postMessage(String fcUserId, String threadId, PostMessageRequest request) {
		return freightcomClientV2.postMessage(fcUserId, threadId, request);
	}
	
	@Override
	public DocumentForEntityResponseDTO getInvoiceForClaim(String fcUserId, String customerId, String claimId) {
		return freightcomClientV2.getInvoiceForClaim(fcUserId, customerId, claimId);
	}
	
	@Override
	public FinancialDocumentResponse getFinancialDocument(String fcUserId, String customerId, String documentId) {
		return freightcomClientV2.getFinancialDocument(fcUserId, customerId, documentId);
	}
	
	@Override
	public CreateThreadResponse createThread(String fcUserId, String customerId, CreateThreadRequest request) {
		return freightcomClientV2.createThread(fcUserId, customerId, request);
	}
	
	@Override
	public StaticSummaryResponse staticSummary(String fcUserId, String customerId, SimpleClaimDashboardLastViewedAtDTO dto) {
		return freightcomClientV2.staticSummary(fcUserId, customerId, dto);
	}
	
	@Override
	public TerminatedSummaryResponse terminatedSummary(String fcUserId, String customerId, SimpleClaimDashboardLastViewedAtDTO dto) {
		return freightcomClientV2.terminatedSummary(fcUserId, customerId, dto);
	}
	
	@Override
	public SettledSummaryResponse settledSummary(String fcUserId, String customerId, SimpleClaimDashboardLastViewedAtDTO dto) {
		return freightcomClientV2.settledSummary(fcUserId, customerId, dto);
	}
	
	@Override
	public GetFCPreferenceResponse getFCCustomerPreference(String fcUserId, String customerId) {
		return freightcomClientV2.getFCCustomerPreference(fcUserId, customerId);
	}
	
	@Override
	public void saveFCCustomerPreference(String fcUserId, String customerId, String key, PostPreferenceRequest request) {
		freightcomClientV2.saveFCCustomerPreference(fcUserId, customerId, key, request);
	}
	
	@Override
	public CSClaimDTO acceptPayout(String fcUserId, Customer customer, String claimId, ClaimPaymentDTO claimPaymentDTO) {
		if (StringUtils.equalsAnyIgnoreCase(claimPaymentDTO.getPrimary_method(), "credit-card-refund")) {
			CreditCardRefundProperties creditCardRefundProperties = new CreditCardRefundProperties();
			creditCardRefundProperties.setPayment_method_id(customer.getFcPaymentMethodId());
			claimPaymentDTO.setCredit_card_refund_properties(creditCardRefundProperties);
		}
		return freightcomClientV2.acceptPayout(fcUserId, claimId, claimPaymentDTO);
	}
	
	@Override
	public boolean checkShipment(String customerId, String fcShipmentId) {
		return shipmentRepository.existsByCustomerIdAndFreightcomV2OrderId(customerId, fcShipmentId);
	}
	
	@Override
	public void readThread(String fcUserId, String fcCustomerId, String threadId) {
		freightcomClientV2.readThread(fcUserId, fcCustomerId, threadId);
	}
	
	public boolean checkPalletShipment(Customer customer) {
		return shipmentRepository.existsByCustomerIdAndPackageType(customer.getId(), PackageType.PALLET.toString());
	}
	
	// not sure if this is required or not. let me just use freightcom tracking page for now, as claim module relies on fc api
//	private String getClickshipTrackingUrl(String orderId) {
//		return clickshipDomain + "/shipment-tracking?id=" + orderId;
//	}
}

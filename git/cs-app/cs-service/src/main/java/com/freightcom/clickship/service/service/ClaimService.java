package com.freightcom.clickship.service.service;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.model.v2.DocumentForEntityResponseDTO;
import com.freightcom.clickship.model.v2.SaveDocumentResponseDTO;
import com.freightcom.clickship.model.v2.SendDocumentEmailRequestDTO;
import com.freightcom.clickship.model.v2.SendDocumentEmailResponseDTO;
import com.freightcom.clickship.model.v2.claim.CSClaimDTO;
import com.freightcom.clickship.model.v2.claim.ClaimDashBoardSettledSummaryDTO;
import com.freightcom.clickship.model.v2.claim.ClaimDashboardLastViewedAtDTO;
import com.freightcom.clickship.model.v2.claim.ClaimIDResponseDTO;
import com.freightcom.clickship.model.v2.claim.ClaimPaymentDTO;
import com.freightcom.clickship.model.v2.claim.ConversationResponse;
import com.freightcom.clickship.model.v2.claim.CreateThreadRequest;
import com.freightcom.clickship.model.v2.claim.CreateThreadResponse;
import com.freightcom.clickship.model.v2.claim.File;
import com.freightcom.clickship.model.v2.claim.FinancialDocumentResponse;
import com.freightcom.clickship.model.v2.claim.GetDownloadURLRequestDTO;
import com.freightcom.clickship.model.v2.claim.GetDownloadURLResponseDTO;
import com.freightcom.clickship.model.v2.claim.GetFCPreferenceResponse;
import com.freightcom.clickship.model.v2.claim.GetUploadURLResponseDTO;
import com.freightcom.clickship.model.v2.claim.PostMessageRequest;
import com.freightcom.clickship.model.v2.claim.PostPreferenceRequest;
import com.freightcom.clickship.model.v2.claim.SearchClaimRequest;
import com.freightcom.clickship.model.v2.claim.SearchClaimResponse;
import com.freightcom.clickship.model.v2.claim.SettledSummaryResponse;
import com.freightcom.clickship.model.v2.claim.SimpleClaimDashboardLastViewedAtDTO;
import com.freightcom.clickship.model.v2.claim.StaticSummaryResponse;
import com.freightcom.clickship.model.v2.claim.TerminatedSummaryResponse;

public interface ClaimService {

	SearchClaimResponse getClaims(String fcUserId, String fcCustomerId, SearchClaimRequest request);
	
	CSClaimDTO getClaim(User user, String id, String claimId);

	void readClaim(String fcUserId, String fcCustomerId, String claimId);

	void submitClaim(String orderId, String fcUserId, String fcCustomerId, String claimId);

	void cancelClaim(String fcUserId, String customerId, String claimId, String orderId);

	ClaimDashBoardSettledSummaryDTO getClaimDashboard(String fcUserId, String customerId, String summaryType, ClaimDashboardLastViewedAtDTO dto);

	ClaimDashboardLastViewedAtDTO getClaimDashboardLastViewedAt(String fcUserId, String customerId);

	void updateClaimDashboardLastViewdAt(String fcUserId, String customerId, SimpleClaimDashboardLastViewedAtDTO dto);

	SendDocumentEmailResponseDTO sendEmailForEntity(String fcUserId, String customerId, SendDocumentEmailRequestDTO dto);

	GetDownloadURLResponseDTO getDownloadURL(String fcUserId, String customerId, GetDownloadURLRequestDTO dto);

	DocumentForEntityResponseDTO getDocumentEntityId(String fcUserId, String customerId, String documentEntityId, String documentEntityType);

	ClaimIDResponseDTO createClaim(String fcUserId, String customerId, CSClaimDTO dto);

	void updateClaim(String fcUserId, String customerId, CSClaimDTO dto);
	
	GetUploadURLResponseDTO getUploadUrl(String fcUserId, String customerId, String documentEntityType, String documentEntityId, String fileName);
	
	SaveDocumentResponseDTO saveDocument(String fcUserId, String customerId, GetDownloadURLRequestDTO dto);
	
	void deleteDocument(String fcUserId, String customerId, String documentId);

	SendDocumentEmailResponseDTO downloadAllDocuments(String fcUserId, String customerId, String claimId);
	
	SendDocumentEmailResponseDTO sendDocumentsToEmail(String fcUserId, String customerId, String claimId, String email);
	
	ConversationResponse getConversation(String fcUserId, String customerId, String claimId);
	
	File postMessage(String fcUserId, String threadId, PostMessageRequest request);
	
	DocumentForEntityResponseDTO getInvoiceForClaim(String fcUserId, String customerId, String claimId);

	FinancialDocumentResponse getFinancialDocument(String fcUserId, String customerId, String documentId);
	
	CreateThreadResponse createThread(String fcUserId, String customerId, CreateThreadRequest request);
	
	StaticSummaryResponse staticSummary(String fcUserId, String customerId, SimpleClaimDashboardLastViewedAtDTO dto);
	
	TerminatedSummaryResponse terminatedSummary(String fcUserId, String customerId, SimpleClaimDashboardLastViewedAtDTO dto);
	
	SettledSummaryResponse settledSummary(String fcUserId, String customerId, SimpleClaimDashboardLastViewedAtDTO dto);
	
	GetFCPreferenceResponse getFCCustomerPreference(String fcUserId, String customerId);
	
	void saveFCCustomerPreference(String fcUserId, String customerId, String key, PostPreferenceRequest request);
	
	CSClaimDTO acceptPayout(String fcUserId, Customer customer, String claimId, ClaimPaymentDTO claimPaymentDTO);
	
	boolean checkShipment(String customerId, String fcShipmentId);
	
	void readThread(String fcUserId, String fcCustomerId, String threadId);
	
	boolean checkPalletShipment(Customer customer);
}

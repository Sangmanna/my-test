package com.freightcom.clickship.service.service.email;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.UserAccountCreateReq;

@Component
public class UserRoleEmails {
	
	@Value("${server.domain}")
	private String clickshipDomain;
	
	@Value("${user.role.ui.endpoint:create/collaborator}")
	private String clickshipUserCreateEndpoint;
	
	@Value("${user.role.invitation.email.template:clickship-user-role-invitation}")
	private String invitationEmailTemplate;
	
	@Autowired
	private MailChimpEmailUtil emailUtil;

	public void sendInvitationEmailToUser(Customer customer, UserAccountCreateReq req) {
		String subject ="You've Been Invited to ClickShip / Vous avez été invité à ClickShip";
			
		Map<String, Object> content = new HashMap<>();
		content.put("name", String.format("%s %s", customer.getFirstName(), customer.getLastName()));
		content.put("businessName", req.getCustomer().getBusinessName());
		content.put("invitationUrl", getInvitationUrl(req));
						
		emailUtil.sendEmail(req.getEmail(), subject, invitationEmailTemplate, true, content, null);
	}
	
	private String getInvitationUrl(UserAccountCreateReq req) {
		String token = String.format("%s|%s|%s", req.getId(), req.getEmail(), req.getUuid());
		String encodedToken = Base64.getEncoder().withoutPadding().encodeToString(token.getBytes());

		return String.format("%s/%s/%s", clickshipDomain, clickshipUserCreateEndpoint, encodedToken);
	}
	
}

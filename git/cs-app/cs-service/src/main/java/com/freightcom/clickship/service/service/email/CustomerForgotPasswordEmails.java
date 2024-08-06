package com.freightcom.clickship.service.service.email;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.freightcom.clickship.data.entity.User;

@Component
public class CustomerForgotPasswordEmails {
	
	@Value("${server.domain}")
	private String clickshipDomain;
	
	@Value("${clickship.canpar.url}")
	private String clickshipCanparUrl;
	
	@Value("${clickship.mailchimp.logo}")
	private String clickshipMailChimpLogo;
	
	@Value("${mailchimp.mandrill.forget.password.email.template}")
	private String forgetPasswordTemplate;
	
	@Value("${clickship.canpar.mailchimp.logo}")
	private String clickshipCanparMailChimpLogo;
	
	@Value("${forget.password.email.subject}")
	private String forgetPasswordEmailSubject;
	
	@Autowired
	private MailChimpEmailUtil emailUtil;

	public void sendResetPassword(User user, String token) { 
		String source = user.getCustomer().getRegistrationSource();
		boolean canpar = StringUtils.equals(source, "canpar");

		Map<String, Object> param = new HashMap<>();
		param.put("username", user.getUsername());
		param.put("clickshipSourceUrl", clickshipCanparUrl);
		param.put("clickshipLogo", canpar? clickshipCanparMailChimpLogo : clickshipMailChimpLogo);
		param.put("forgotpwdurl", clickshipDomain + "/set-password/" + token + (canpar? "?q=canpar" : ""));
		param.put("returnURL", clickshipDomain + "/set-password/" + token + (canpar? "?q=canpar" : ""));

		emailUtil.sendEmail(user.getEmail(), forgetPasswordEmailSubject, forgetPasswordTemplate, false, param, null);
	}
	
}

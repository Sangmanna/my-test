package com.freightcom.clickship.service.service.email;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.freightcom.clickship.model.constants.ClickShipJMS;
import com.freightcom.clickship.model.mandrill.AddToList;
import com.freightcom.clickship.model.mandrill.MailAttachment;
import com.freightcom.clickship.model.mandrill.MailChimpRequest;
import com.freightcom.clickship.model.mandrill.MailContent;
import com.freightcom.clickship.model.mandrill.MailRecipient;
import com.freightcom.clickship.service.service.jms.JMSService;

@Component
public class MailChimpEmailUtil {
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Value("${mailchimp.mandrill.apikey}")
	private String mandrillApiKey;

	@Value("${clickship.app.url}")
	private String clickshipAppUrl;
	
	@Value("${validation.welcome.email.list}")
	private String welcomeEmailList;
	
	@Value("${clickship.url.login}")
	private String clickshipLoginUrl;
	
	@Value("${clickship.canpar.url}")
	private String clickshipCanparUrl;
	
	@Value("${clickship.from.email}")
	private String clickshipFromEmail;
	
	@Value("${clickship.app.login.url}")
	private String clickshipAppLoginUrl;
	
	@Value("${clickship.canpar.url.login}")
	private String clickshipCanparLoginUrl;
	
	@Value("${clickship.mailchimp.logo}")
	private String clickshipMailChimpLogo;
	
	@Value("${clickship.email.from.name}")
	private String clickshipEmailFromName;
	
	@Value("${clickship.canpar.mailchimp.logo}")
	private String clickshipCanparMailChimpLogo;
	
	@Value("${mandrill.email.template.render.api}")
	private String mandrillEmailTemplateRenderApi;
	
	@Autowired
	private JMSService jmsService;
	
	public void sendEmail(String email, String subject, String template) {
		sendEmail(email, subject, template, true, new HashMap<>(), new ArrayList<>());
	}
	
	public void sendEmail(String email, String subject, String template, boolean dynamicContent, Map<String, Object> param, List<MailAttachment> attachments) {
		MailChimpRequest sendMailRequest = new MailChimpRequest();
		
		MailContent sendMail = new MailContent().setFrom(new MailRecipient(clickshipFromEmail, clickshipEmailFromName))
				.setSubject(subject).addToRecipient(email).setTemplate(template).setDynamicContent(dynamicContent)
				.setAttachments(attachments);

		setCommonParams(param);
		
		param.forEach(sendMail::addTemplateValue);
		sendMailRequest.setSendMail(sendMail);
		
		jmsService.send(ClickShipJMS.MAIL_QUEUE, sendMailRequest);
	}

	public void sendEmail(String[] emails, String subject, String template, boolean dynamicContent, Map<String, Object> param, List<MailAttachment> attachments) {
		MailChimpRequest sendMailRequest = new MailChimpRequest();
		
		MailContent sendMail = new MailContent().setFrom(new MailRecipient(clickshipFromEmail, clickshipEmailFromName))
				.setSubject(subject).addToRecipient(emails).setTemplate(template).setDynamicContent(dynamicContent)
				.setAttachments(attachments);	
		
		setCommonParams(param);
		
		param.forEach(sendMail::addTemplateValue);
		sendMailRequest.setSendMail(sendMail);
		
		jmsService.send(ClickShipJMS.MAIL_QUEUE, sendMailRequest);
	}
	
	public void sendEmail(String[] emails, String subject, String template, boolean dynamicContent, Map<String, Object> param, List<MailAttachment> attachments,String fromEmail) {
		MailChimpRequest sendMailRequest = new MailChimpRequest();
		
		MailContent sendMail = new MailContent().setFrom(new MailRecipient(fromEmail, clickshipEmailFromName))
				.setSubject(subject).addToRecipient(emails).setTemplate(template).setDynamicContent(dynamicContent)
				.setAttachments(attachments);	
		
		setCommonParams(param);
		
		param.forEach(sendMail::addTemplateValue);
		sendMailRequest.setSendMail(sendMail);
		
		jmsService.send(ClickShipJMS.MAIL_QUEUE, sendMailRequest);
	}
	
	public void addSubscribe(String userEmail) {
		MailChimpRequest addSubscriptionRequest = new MailChimpRequest();
		
		AddToList list = new AddToList()
				.setEmail(userEmail)
				.setListId(welcomeEmailList);

		addSubscriptionRequest.setAddToList(list);
		jmsService.send(ClickShipJMS.MAIL_QUEUE, addSubscriptionRequest);
	}
	
	public String getEmailTemplateHtml(String templateName, JSONArray mergeVars) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JSONObject obj = new JSONObject();
		obj.put("merge_vars", mergeVars);
		obj.put("key", mandrillApiKey);
		obj.put("template_content", new JSONArray());
		obj.put("template_name", templateName);

		HttpEntity<String> entity = new HttpEntity<>(obj.toString(), headers);
		String result = restTemplate.postForObject(mandrillEmailTemplateRenderApi, entity, String.class);

		JSONObject json = new JSONObject(result);
		if (json.has("html")) {
			return json.getString("html");
		} else {
			logger.error(json);
		}
		throw new Exception("Fail to pull email template from mandrill");
	}
	
	private void setCommonParams(Map<String, Object> param) {
		// Set year dynamically
		param.put("year", Calendar.getInstance().get(Calendar.YEAR));
		
		if(!param.containsKey("clickshipSourceUrl")) {
			param.put("clickshipSourceUrl", clickshipAppUrl);
		}
		
		if (!param.containsKey("clickshipSourceLoginUrl")) {
			param.put("clickshipSourceLoginUrl", clickshipAppLoginUrl);
		}

		if(!param.containsKey("clickshipCanpar")) {
			param.put("clickshipCanpar", false);
		}
			
		if(!param.containsKey("clickshipLogo")) {
			param.put("clickshipLogo", clickshipMailChimpLogo);
		}	
	}
}

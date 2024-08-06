package com.freightcom.clickship.service.service.email;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.freightcom.clickship.data.entity.Code;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Onboarding;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.model.util.CopyUtil;
import com.freightcom.clickship.service.service.CodeService;
import com.freightcom.clickship.service.util.JsonTransformer;

@Component
public class OnboardingEmails {

	private static final String FIELD_EMAIL = "email";
	private static final String FIELD_MEETING_LINK = "link";
	private static final String FIELD_SALES_PHOTO = "photo";
	private static final String FIELD_SALES_NAME = "salesName";

	private static final String NO_PHOTO = "no_photo.png";
	private static final String OTHER_CARRIER = "OTHER_CARRIER";
	private static final String OTHER_REFERAL = "OTHER_REFERAL";
	private static final String INVALID_OR_EMPTY = "INVALID_OR_EMPTY";
	private static final String OTHER_MARKETPLACE = "OTHER_MARKETPLACE";

	private static final String SUBJECT_WELCOME_EMAIL = "Welcome to ClickShip / Réinitialiser votre mot de passe"; 
	private static final String SUBJECT_CC_EMAIL = "%s has signed up for ClickShip. ";
	private static final String SUBJECT_SALES_EMAIL = "A New ClickShip Account has been Created";
	private static final String SUBJECT_SALES_2ND_EMAIL = "%s has Completed Their Onboarding Setup";
	private static final String SUBJECT_SETP_AWAY_EMAIL = "You're Just a Few Steps Away from Using ClickShip";
	private static final String SUBJECT_SALES_PROMO_EMAIL = "Congratulations! A New User Signed Up With Your Promo Code";

	@Value("${internal.email.cc}")
	public String ccEmails;
	
	@Value("${internal.email.sales}")
	private String internalEmailSales;
	
	@Value("${clickship-onboarding-with-address-info}")
	private String onboardingNoticeToCC;
	
	@Value("${step-away-onboarding-complete-email}")
	private String stepawayTemplate;
	
	@Value("${welcome.mail.template.name}")
	private String welcomeEmailTemplate;

	@Value("${onboarding.notice.to.sales}")
	private String onboardingSalesTemplate;
	
	@Value("${onboarding.notice.to.sales.promo}")
	private String onboardingSalesPromoTemplate;
	
	@Value("${onboarding.notice.to.sales2}")
	private String onboardingNoticeToSalesTemplate2;

	@Autowired
	private CodeService codeService;

	@Autowired
	private JsonTransformer transformer;

	@Autowired
	private MailChimpEmailUtil emailUtil;
	
	public void sendNewOnboaridngEmail(Onboarding onboarding, Customer customer, User user) {
		Map<String, Object> param = getCommonEmailParam(onboarding, customer, user);

		emailUtil.addSubscribe(customer.getEmail());
		sendDynamicContentEmail(customer.getEmail(), SUBJECT_WELCOME_EMAIL, welcomeEmailTemplate, param);
	}

	public void sendStepAwayEmail(Onboarding onboarding) {
		emailUtil.sendEmail(onboarding.getEmailAddress(), SUBJECT_SETP_AWAY_EMAIL, stepawayTemplate);
	}

	public void sendTheFirstEmailToSales(Onboarding onboarding, Customer customer, User user) {
		Map<String, Object> param = getCommonEmailParam(onboarding, customer, user);
		setSalesInformationFromCode(onboarding.getPromoCode(), param);

		sendDynamicContentEmail(getInternalEmailSales(), SUBJECT_SALES_EMAIL, onboardingSalesTemplate, param);
	}

	// Send email to promo code sales when customer get start
	public void sendTheFirstEmailToSalesPromoCode(Onboarding onboarding, Customer customer, User user) {
		Map<String, Object> param = getCommonEmailParam(onboarding, customer, user);
		List<String> salesEmails = setSalesInformationFromCode(onboarding.getPromoCode(), param);

		if (!salesEmails.isEmpty()) {
			sendDynamicContentEmail(salesEmails.toArray(new String[0]), SUBJECT_SALES_PROMO_EMAIL, onboardingSalesPromoTemplate, param);
		}
	}
	
	public void sendEmailToCC(Onboarding onboarding, Customer customer, User user) {
		String[] toEmails = getCCEmails().toArray(new String[0]);
		String subject = String.format(SUBJECT_CC_EMAIL, customer.getBusinessName());
		
		if (toEmails.length > 0) {
			Map<String, Object> param = getCommonEmailParam(onboarding, customer, user);
			param.putAll(addAddressParam(onboarding, customer));

			sendDynamicContentEmail(toEmails, subject, onboardingNoticeToCC, param);
		}
	}
	
	// Send email to sales again when customer complete on-boarding
	public void sendTheSecondEmailToSales(Onboarding onboarding, Customer customer, User user) {
		Map<String, Object> param = getCommonEmailParam(onboarding, customer, user);
		List<String> salesEmails = setSalesInformationFromCode(onboarding.getPromoCode(), param);
		
		addInternalSalesEmails(salesEmails);
		
		salesEmails = removeDuplicateEmails(salesEmails);
		String subject = String.format(SUBJECT_SALES_2ND_EMAIL, customer.getBusinessName());
		
		sendDynamicContentEmail(salesEmails.toArray(new String[0]), subject, onboardingNoticeToSalesTemplate2, param);
	}
	
	private void sendDynamicContentEmail(String email, String subject, String template, Map<String, Object> param) {
		emailUtil.sendEmail(email, subject, template, true, param, null);
	}

	private void sendDynamicContentEmail(String[] toEmail, String subject, String template, Map<String, Object> param) {
		emailUtil.sendEmail(toEmail, subject, template, true, param, null);
	}

	private Map<String, Object> getCommonEmailParam(Onboarding onboarding, Customer customer, User user) {
		Map<String, Object> param = new HashMap<>();
		addOnboardingData(onboarding, param);

		param.put("promoCode", onboarding.getPromoCode());
		param.put("firstName", customer.getFirstName());
		param.put("lastName", customer.getLastName());
		param.put("businessName", customer.getBusinessName());
		param.put(FIELD_EMAIL, onboarding.getEmailAddress());
		param.put("phone", onboarding.getPhone());
		param.put("username", user.getUsername());

		// for the second sales email
		param.put("optInForEmails", onboarding.isOptInForEmails() ? "Yes" : "No");

		if (StringUtils.isNoneEmpty(onboarding.getHasAccounts())) {
			param.put("hasAccounts", onboarding.getHasAccounts().replace(":", " - ").replace(",", "<br>"));
		}

		return param;
	}
	
	private Map<String, Object> addAddressParam(Onboarding onboarding, Customer customer) {
		Map<String, Object> map = new HashMap<>();
		map.put("fullName", customer.getFirstName() + " " + customer.getLastName());
		map.put("businessName", customer.getBusinessName());
		map.put(FIELD_EMAIL, customer.getEmail());
		map.put("phone", customer.getPhone());
		
		map.put("addressLine1", onboarding.getAddress1());
		map.put("addressLine2", onboarding.getAddress2());
		map.put("postalZipCode", onboarding.getPostalCode());
		map.put("city", onboarding.getCity());
		map.put("provinceState", onboarding.getProvinceState());
		map.put("country", onboarding.getCountry());
		
		return map;
	}

	@SuppressWarnings("unchecked")
	private List<String> setSalesInformationFromCode(String promoCode, Map<String, Object> param) {
		List<Code> codes = codeService.getCodes("PROMO_CODE");
		Optional<Code> optionalPromoCode = codes.stream()
				.filter(code -> StringUtils.equalsAnyIgnoreCase(promoCode, code.getName())).findAny();
		Code promoCodeFound = null;

		if (optionalPromoCode.isPresent()) {
			promoCodeFound = optionalPromoCode.get();
		} else {
			Optional<Code> code = codes.stream().filter(c -> StringUtils.equals(c.getName(), INVALID_OR_EMPTY))
					.findAny();
			if (code.isPresent()) {
				promoCodeFound = code.get();
			}
		}

		if (promoCodeFound != null) {
			Map<String, String> map = transformer.fromJson(promoCodeFound.getValue(), Map.class);

			if (map.get(FIELD_SALES_NAME) != null) {
				param.put(FIELD_SALES_NAME, map.get(FIELD_SALES_NAME));
			}

			List<String> salesEmails = new ArrayList<>();
			IntStream.range(1, 4).forEach(i -> {
				String email = map.get(FIELD_EMAIL + i);
				if (StringUtils.isNotEmpty(email)) {
					salesEmails.add(email.toLowerCase());
				}
			});

			param.put("meetingLink", map.get(FIELD_MEETING_LINK));
			param.put("photoLink", map.get(FIELD_SALES_PHOTO) == null ? NO_PHOTO : map.get(FIELD_SALES_PHOTO));

			return salesEmails;
		}

		return new ArrayList<>();
	}

	private void addOnboardingData(Onboarding onboarding, Map<String, Object> param) {
		Map<String, String> newMap = new HashMap<>();
		Map<String, String> map = CopyUtil.copyObjectToMap(onboarding);
		map.forEach((key, val) -> {
			if (val != null && val.indexOf(',') >= 0) {
				val = changeData(val, onboarding.getOtherMarketplaces(), OTHER_MARKETPLACE);
				val = changeData(val, onboarding.getOtherCarriers(), OTHER_CARRIER);
				val = changeData(val, onboarding.getOtherHowKnowUs(), OTHER_REFERAL);

				if (val.startsWith(",")) {
					val = val.substring(1, val.length());
				}
				if (val.endsWith(",")) {
					val = val.substring(0, val.length() - 1);
				}
				if (val.indexOf(',') >= 0) {
					val = Arrays.stream(val.split(",")).map(String::trim).filter(StringUtils::isNotBlank)
							.collect(Collectors.joining(", "));
				}

				val = val.replace("CanadaPost", "Canada Post");
			}
			newMap.put(key, val);
		});

		param.putAll(newMap);
	}
	
	private String changeData(String val, String alternative, String check) {
		if (val.indexOf(check) >= 0) {
			String[] pieces = val.split(",");
			val = Arrays.stream(pieces).filter(x -> !check.equals(x) && StringUtils.isNotBlank(x))
					.collect(Collectors.joining(", "));
			val += (pieces.length >= 2 ? ", " : "") + alternative + " (Other)";
		}

		return val;
	}

	private String[] getInternalEmailSales() {
		if (StringUtils.isNotBlank(internalEmailSales)) {
			return internalEmailSales.split(";");
		} else {
			return new String[0];
		}
	}
	
	private List<String> getCCEmails() {
		return Arrays.stream(ccEmails.split(";")).map(StringUtils::trim).filter(StringUtils::isNotEmpty)
				.collect(Collectors.toList());
	}
	
	private void addInternalSalesEmails(List<String> salesEmails) {
		Arrays.stream(getInternalEmailSales()).forEach(email -> {
			if (StringUtils.isNotEmpty(email) && !salesEmails.contains(email.toLowerCase())) {
				salesEmails.add(email);
			}
		});
	}
	
	private List<String> removeDuplicateEmails(List<String> salesEmails) {
		return salesEmails.stream().map(StringUtils::trim).distinct().collect(Collectors.toList());
	}
	
}

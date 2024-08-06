package com.freightcom.clickship.service.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClient;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Translation;
import com.freightcom.clickship.data.entity.projection.customer.CustomerLanguageProjection;
import com.freightcom.clickship.data.rep.CustomerPreferencesRepository;
import com.freightcom.clickship.data.rep.TranslationRepository;
import com.freightcom.clickship.data.util.PropertyUtil;
import com.freightcom.clickship.model.system.TranslationDTO;
import com.freightcom.clickship.model.util.ClickshipStringUtil;
import com.freightcom.clickship.model.util.CopyUtil;
import com.freightcom.clickship.model.util.Security;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class TranslationService {
	
	private Logger logger = LogManager.getLogger(TranslationService.class);
	
	private static final String DEFUALT_LANGUAGE_EN = "en";
	
	@Value("${aws.region}")
	private String awsRegion;

	@Autowired
	private Security security;
	
	@PersistenceContext
	protected EntityManager em;

	@Autowired
	private PropertyUtil propertyUtil;
	
	@Autowired
	private TranslationRepository translationRepository;
	
	@Autowired
	private CustomerPreferencesRepository customerPreferencesRepository; 

	@SuppressWarnings("unchecked")
	public Map<String, String> getList() throws Exception {
		Map<String, String> map = new HashMap<>();
		String query = "select en, fr from translation";
		List<Object[]> list = em.createNativeQuery(query).getResultList();

		list.forEach((obj) -> {
			map.put((String) obj[0], (String) obj[1]);
		});

		return map;
	}
	
	@Transactional
	public Translation getTranslation(String en) throws Exception {
		Optional<Translation> oTranslation = translationRepository.findByEn(en).stream().findAny();
		
		if (oTranslation.isPresent()) {
			return oTranslation.get();
			
		} else {
			Map<String, Object> map  = new HashMap<>();
			map.put("url", "backend-message");
			map.put("data", Arrays.asList(en));
			save(map);
			
			oTranslation = translationRepository.findByEn(en).stream().findAny();
			
			if (oTranslation.isPresent()) {
				return oTranslation.get();
				
			} else {
				// the logic here for the safe. It should not come here for any reason.
				Translation translation = new Translation();
				translation.setEn(en);
				translation.setEn(en);
				return translation;
			}
		}
	}
	
	@Transactional
	public String getTranslation(String en, Customer customer) {
		if (isEN(customer)) {
			return en;
		}
		
		Optional<Translation> oTranslation = translationRepository.findByEn(en).stream().findAny();
		
		if (oTranslation.isPresent()) {
			return oTranslation.get().getFr();
			
		} else {
			Map<String, Object> map  = new HashMap<>();
			map.put("url", "backend-message");
			map.put("data", Arrays.asList(en));
			try {
				save(map);
			} catch (Exception e) {
				// I do not want to propagate the exception to the business logic. so no throwing
				logger.error("error", e);
			}
			
			oTranslation = translationRepository.findByEn(en).stream().findAny();
			
			if (oTranslation.isPresent()) {
				return oTranslation.get().getFr();
				
			} else {
				// the logic here for the safe. It should not come here for any reason.
				return en;
			}
		}
	}
	
	/**
	 * This method is used to check if the customer's language preference is English.
	 * IMPORTANT: When using this method, always use the @ClearThreadContext annotation to clear the ThreadContext after execution.
	 *            And make sure if @ClearThreadContext is called properly.
	 *            Refer this. com.freightcom.clickship.integrations.service.impl.ImportOrdersCSVService.importOrders()
	 * 
	 * @param customer The customer to check.
	 * @return true if the customer's language preference is English, false
	 *         otherwise.
	 */
	public boolean isEN(Customer customer) {
		return StringUtils.equalsIgnoreCase(DEFUALT_LANGUAGE_EN, getLanguageFromCustomerPreference(customer));
	}
	
	private String getLanguageFromCustomerPreference(Customer customer) {
		String language = ThreadContext.get("language");
		
		if (StringUtils.isEmpty(language)) {
			CustomerLanguageProjection customerLanguageProjection = customerPreferencesRepository.getLanguageByCustomer(customer);
			language = customerLanguageProjection != null ? customerLanguageProjection.getLanguage() : DEFUALT_LANGUAGE_EN;
			ThreadContext.put("language", language);
		}
		return language;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void save(Map<String, Object> data) throws Exception {
		String enabled = propertyUtil.readPropertiesInRealtime("ft.auto.translation.collect");
		
		if (StringUtils.equalsAnyIgnoreCase(enabled, "true")) {
			String url = (String) data.get("url");
			List<String> labels = (List<String>) data.get("data");
			List<String> existingEns = translationRepository.findAllEnText();
			List<String> newLabels = labels.parallelStream().filter(t -> !existingEns.contains(t)).filter(StringUtils::isNotBlank).distinct().collect(Collectors.toList());

			List<Translation> list = getNewTranslatedAWS(newLabels, url);
			translationRepository.saveAll(list);
		}
	}

	private List<Translation> getNewTranslatedAWS(List<String> labels, String url) {
		AmazonTranslate translate = AmazonTranslateClient.builder().withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(security.getAWSAccessKeyId(), security.getAWSSecretAccessKey()))).withRegion(awsRegion).build();

		TranslateTextRequest request = new TranslateTextRequest().withSourceLanguageCode(DEFUALT_LANGUAGE_EN).withTargetLanguageCode("fr");

		return labels.stream().map(label -> {
			Translation translation = new Translation();
			request.withText(label);
			translation.setEn(label);
			translation.setFr(translate.translateText(request).getTranslatedText());
			translation.setUrl(ClickshipStringUtil.truncateString(url, 99));
			return translation;
		}).collect(Collectors.toList());
	}
	
	public List<TranslationDTO> getDTOList() throws Exception {
		return translationRepository.findAllByOrderByUpdateDatetime().stream().map(t -> {
			TranslationDTO dto = new TranslationDTO();
			CopyUtil.copyProperties(t, dto);
			dto.setUpdatedDatetime(t.getUpdateDatetime());
			return dto;
		}).collect(Collectors.toList());
	}

	@Transactional("csTransactionManager")
	public boolean update(List<TranslationDTO> list) {
		try {
			List<String> ids = list.stream().map(TranslationDTO::getId).collect(Collectors.toList());
			List<Translation> dbList = translationRepository.findAllById(ids);
			
			Map<String, TranslationDTO> translationMap = list.stream().collect(Collectors.toMap(TranslationDTO::getId, translation -> translation));
			dbList.stream().forEach(x -> CopyUtil.copyProperties(translationMap.get(x.getId()), x));
			
			translationRepository.saveAll(dbList);
			
		} catch (Exception e) {
			logger.error("Error", e);
			return false;
		}
		return true;
	}
}

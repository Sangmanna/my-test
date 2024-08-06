package com.freightcom.clickship.client.slimcd;

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

import com.freightcom.clickship.model.slimcd.SlimcdRequest;
import com.freightcom.clickship.model.slimcd.SlimcdResponse;

@Component
public class SlimcdClient {

	private Logger logger = LogManager.getLogger(SlimcdClient.class);

	@Value("${slimcd.url}")
	private String url;

	@Value("${slimcd.userName}")
	private String userName;

	@Value("${slimcd.password}")
	private String password;

	@Value("${slimcd.clientId}")
	private String clientId;

	@Value("${slimcd.siteId}")
	private String siteId;

	@Value("${slimcd.priceId}")
	private String priceId;

	@Value("${slimcd.product}")
	private String product;

	@Value("${slimcd.transtype}")
	private String transtype;

	@Value("${slimcd.test.preAuthAmount}")
	private String preAuthAmount;

	@Autowired
	private RestTemplate restTemplate;

	public SlimcdResponse addCard(SlimcdRequest dto, String businessName) {
		try {
			setCredentials(dto);

			SlimcdResponse res = (SlimcdResponse) post(url, dto, SlimcdResponse.class).getBody();

			if (res != null && res.getReply() != null) {
				if (!StringUtils.equalsIgnoreCase(res.getReply().getResponse(), "Success")
						|| !StringUtils.equalsIgnoreCase(res.getReply().getResponsecode(), "0")
						|| !StringUtils.equalsIgnoreCase(res.getReply().getDatablock().getApproved(), "Y")) {
					logger.error(
							"Slim CD add card - not successful - businessname:[{}], response:[{}], responsecode: [{}], description: [{}] ",
							businessName, res.getReply().getResponse(), res.getReply().getResponsecode(),
							res.getReply().getDescription());
				//	throw new PaymentMethodException("An error occurred while adding your credit card. Please try again.");
				}

				logger.info(
						"Slim CD add card request completed - businessname:[{}], response:[{}], responsecode: [{}], description: [{}] ",
						businessName, res.getReply().getResponse(), res.getReply().getResponsecode(),
						res.getReply().getDescription());
				return res;
			}

		} catch (Exception e) {
			logger.info("Exception while Slim CD Add Card - businessname:[{}], error: [{}]", businessName,
					e.getMessage(), e);
			throw e;
		}
		return null;
	}

	private ResponseEntity<?> post(String url, Object req, Class<?> clazz) {
		return call(url, HttpMethod.POST, req, clazz);
	}

	private ResponseEntity<?> call(String url, HttpMethod method, Object req, Class<?> clazz) {
		return restTemplate.exchange(url, method, getRequestEntity(req), clazz);
	}

	private HttpEntity<Object> getRequestEntity(Object requestBody) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		if (requestBody != null) {
			return new HttpEntity<>(requestBody, headers);
		} else {
			return new HttpEntity<>(headers);
		}
	}

	private void setCredentials(SlimcdRequest request) {
		request.setUsername(userName);
		request.setPassword(password);
		request.setClientid(clientId);
		request.setSiteid(siteId);
		request.setPriceid(priceId);
		request.setTranstype(transtype);
		request.setProduct(product);
		request.setAmount(preAuthAmount);

		request.setAllowDuplicates("yes");
	}

}

package com.freightcom.clickship.client.smartystreets;

import java.util.List;

import com.freightcom.clickship.model.address.AddressValidationDTO;
import com.freightcom.clickship.model.address.response.international.AddressValidationResponse;
import com.freightcom.clickship.model.address.response.usa.AddressValidationUsaResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SmartyStreetsRestClient {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Value("${smartystreets.api.id}")
	private String apiId;
	
	@Value("${smartystreets.api.token}")
	private String apiToken;
	
	@Value("${smartystreets.api.international.url}")
	private String apiInternationalUrl;

	@Value("${smartystreets.api.usa.url}")
	private String apiUsaUrl;

	private static final ParameterizedTypeReference<List<AddressValidationResponse>> addressValidationResponse = new ParameterizedTypeReference<List<AddressValidationResponse>>() { };

	private static final ParameterizedTypeReference<List<AddressValidationUsaResponse>> addressValidationUsaResponse = new ParameterizedTypeReference<List<AddressValidationUsaResponse>>() { };

	@Autowired
	private RestTemplate restTemplate;

	public HttpHeaders getHeaders(String api) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		requestHeaders.add("Host", api.replace("https://", "").replace("/", ""));
		requestHeaders.add("Connection", "keep-alive");
		return requestHeaders;
	}

	public ResponseEntity<?> getSmartyStreetsResponse(String api, String endPointUri, ParameterizedTypeReference<?> returnType) {
		HttpEntity<Object> requestEntity = new HttpEntity<>(getHeaders(api));
		return restTemplate.exchange(endPointUri, HttpMethod.GET, requestEntity, returnType);
	}

	@SuppressWarnings("unchecked")
	public List<?> getAddressValidationResponse(AddressValidationDTO address, Boolean geocodeRequired) throws Exception {
		List<AddressValidationResponse> avr = null;
		List<AddressValidationUsaResponse> avur = null ;
		String uri = "";
		ResponseEntity<?> response = null;
		if("us".equalsIgnoreCase(address.getCountry()) || "usa".equalsIgnoreCase(address.getCountry())) {
			logger.info("USA Address Validation");
			uri = buildAddressValidationUri(apiUsaUrl, address, geocodeRequired, true);
			response = getSmartyStreetsResponse(apiUsaUrl, uri, addressValidationUsaResponse);
			avur = (List<AddressValidationUsaResponse>) response.getBody();;
		}else{
			logger.info("International Address Validation");
			uri = buildAddressValidationUri(apiInternationalUrl, address, geocodeRequired, false);
			response = getSmartyStreetsResponse(apiInternationalUrl, uri, addressValidationResponse);
			avr = (List<AddressValidationResponse>) response.getBody();
		}
		logger.debug("Response: {}",response.getBody());

		return (avr != null) ? avr : avur;
	}

	private String buildAddressValidationUri(String api, AddressValidationDTO address, Boolean geocodeRequired, Boolean usAddress) throws Exception {
		String uri = api + ((usAddress)?"street-address?":"verify?") + getAuthGet();
		Boolean isValidRequest = false;
		logger.info("Building URI for address validation.");
		if (address.getAddress1() != null) {
			int i = 1;
			if (address.getCountry() != null || usAddress) {
				uri += ((usAddress)?"":"&country=" + address.getCountry());
				uri += (usAddress)?"&street=" + address.getAddress1().replace(" ", "+"):"&address" + i + "=" + address.getAddress1().replace(" ", "+");
				if(address.getAddress2()!=null) {uri += (usAddress)?"&secondary=" + address.getAddress2().replace(" ", "+"):"&address2=" + address.getAddress2().replace(" ", "+");}

				if (address.getPostalCode() != null) {
					uri += ((usAddress)?"&zipcode=":"&postal_code=") + address.getPostalCode().replace(" ", "");
					isValidRequest = true;
				}
				if (address.getProvinceState() != null
						&& (address.getPostalCode() != null || address.getCity() != null)) {
					if (address.getCity() != null) {
						uri += ((usAddress)?"&city=":"&locality=") + address.getCity().replace(" ", "+");
					}
					if (address.getProvinceState() != null) {
						uri += ((usAddress)?"&state=":"&administrative_area=")
								+ address.getProvinceState().replace(" ", "+");
					}
					if(usAddress) {
						if(address.getContactName() != null){
							uri += "&addressee=" + address.getContactName().replace(" ", "+");
						}

						//uri += "&candidates=10";
					}
					if (geocodeRequired && !usAddress) {
						uri += "&geocode=true";
					}
					logger.info("URI: {}", uri);
				} else {
					if (!isValidRequest) {
						throw new Exception("Either a Postal Code OR City and Province/State is required.");
					}
				}
			} else {
				throw new Exception("Country is required for address validation.");
			}
		} else {
			throw new Exception("At least one address line is required.");
		}
		return uri;
	}

	private String getAuthGet() {
		return "auth-id=" + apiId + "&auth-token=" + apiToken;
	}
}

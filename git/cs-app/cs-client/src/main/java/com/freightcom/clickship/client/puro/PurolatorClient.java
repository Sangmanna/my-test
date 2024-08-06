package com.freightcom.clickship.client.puro;

import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.axis2.client.Options;
import org.apache.axis2.kernel.http.HTTPConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.freightcom.clickship.model.carrier.puro.ZipDto;
import com.freightcom.clickship.model.exception.AddressNotFoundException;
import com.freightcom.clickship.purolator.ServiceAvailabilityServiceContract_ValidateCityPostalCodeZip_ValidationFaultFault_FaultMessage;
import com.freightcom.clickship.purolator.ServiceAvailabilityServiceStub;
import com.freightcom.clickship.purolator.ServiceAvailabilityServiceStub.ArrayOfShortAddress;
import com.freightcom.clickship.purolator.ServiceAvailabilityServiceStub.Language;
import com.freightcom.clickship.purolator.ServiceAvailabilityServiceStub.RequestContext;
import com.freightcom.clickship.purolator.ServiceAvailabilityServiceStub.RequestContextE;
import com.freightcom.clickship.purolator.ServiceAvailabilityServiceStub.ShortAddress;
import com.freightcom.clickship.purolator.ServiceAvailabilityServiceStub.SuggestedAddress;
import com.freightcom.clickship.purolator.ServiceAvailabilityServiceStub.ValidateCityPostalCodeZipRequest;
import com.freightcom.clickship.purolator.ServiceAvailabilityServiceStub.ValidateCityPostalCodeZipRequestContainer;
import com.freightcom.clickship.purolator.ServiceAvailabilityServiceStub.ValidateCityPostalCodeZipResponse;
import com.freightcom.clickship.purolator.ServiceAvailabilityServiceStub.ValidateCityPostalCodeZipResponseContainer;

@Component
public class PurolatorClient {

	@Value("${purolator.zipcode.url}")
	private String zipCodeURL;

	@Value("${purolator.zipcode.username}")
	private String puroUsername;

	@Value("${purolator.zipcode.password}")
	private String puroPassword;

	@Value("${purolator.zipcode.version}")
	private String puroVersion;

	private static final String Request_Reference_Name = "RequestReference";

	public ZipDto getZipDetails(ZipDto dto) throws RemoteException, ServiceAvailabilityServiceContract_ValidateCityPostalCodeZip_ValidationFaultFault_FaultMessage {
		ServiceAvailabilityServiceStub stub = new ServiceAvailabilityServiceStub(zipCodeURL);
		
		Options options = stub._getServiceClient().getOptions();
		options.setProperty(HTTPConstants.HTTP_HEADERS, getAuthenticator());

		ValidateCityPostalCodeZipRequestContainer requestContainer = new ValidateCityPostalCodeZipRequestContainer();
		requestContainer.setAddresses(getArrayOfShortAddress(dto, 1));

		ValidateCityPostalCodeZipRequest validateCityPostalCodeZipRequest = new ValidateCityPostalCodeZipRequest();
		validateCityPostalCodeZipRequest.setValidateCityPostalCodeZipRequest(requestContainer);

		RequestContextE requestContext = getRequestContextE();

		ValidateCityPostalCodeZipResponse zipResponse = stub.validateCityPostalCodeZip(validateCityPostalCodeZipRequest, requestContext);
		ValidateCityPostalCodeZipResponseContainer zipResponseContainer = zipResponse.getValidateCityPostalCodeZipResponse();

		SuggestedAddress[] suggestedAddress = zipResponseContainer.getSuggestedAddresses().getSuggestedAddress();

		if (suggestedAddress == null || suggestedAddress.length == 0) {
			throw new AddressNotFoundException(
					String.format("No address found - country:%s, zipcode:%s", dto.getCountry(), dto.getPostalCode()));
		}

		if (suggestedAddress.length > 1) {
			throw new AddressNotFoundException("Found multiple addresses");
		}

		ZipDto zipDTO = new ZipDto();
		zipDTO.setCity(suggestedAddress[0].getAddress().getCity());
		zipDTO.setCountry(suggestedAddress[0].getAddress().getCountry());
		zipDTO.setPostalCode(suggestedAddress[0].getAddress().getPostalCode());
		zipDTO.setProvinceState(suggestedAddress[0].getAddress().getProvince());

		return zipDTO;
	}

	private RequestContextE getRequestContextE() {

		RequestContext requestContextBody = new RequestContext();
		requestContextBody.setVersion(puroVersion);
		requestContextBody.setLanguage(Language.en);
		requestContextBody.setRequestReference(Request_Reference_Name);
		requestContextBody.setGroupID("");

		RequestContextE requestContext = new RequestContextE();
		requestContext.setRequestContext(requestContextBody);
		return requestContext;

	}

	private Map<String, String> getAuthenticator() {
		String credentials = puroUsername + ":" + puroPassword;
		String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
		String authorizationHeader = "Basic " + encodedCredentials;

		Map<String, String> property = new HashMap<>();
		property.put("Authorization", authorizationHeader);

		return property;
	}

	private ArrayOfShortAddress getArrayOfShortAddress(ZipDto dto, int arraySize) {
		ShortAddress[] array = new ShortAddress[arraySize];

		ShortAddress shortAddress = new ShortAddress();
		shortAddress.setCity(dto.getCity());
		shortAddress.setCountry(dto.getCountry());
		shortAddress.setPostalCode(dto.getPostalCode());
		shortAddress.setProvince(dto.getProvinceState());
		array[0] = shortAddress;

		ArrayOfShortAddress arrayAddress = new ArrayOfShortAddress();
		arrayAddress.setShortAddress(array);
		return arrayAddress;

	}

}

package com.freightcom.clickship.client.puro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.freightcom.clickship.model.carrier.puro.ZipDto;

@Component
public class HereMapClient {

	@Value("${heremaps.url}")
	private String hereMapURL;

	@Value("${heremaps.app_id}")
	private String app_id;

	@Value("${heremaps.app_code}")
	private String app_code;

	private static Logger logger = LogManager.getLogger(HereMapClient.class);

	public ZipDto getZipDetails(ZipDto dto) throws IOException {

		String city = "";
		String state = "";
		String country = "";
		String postalCode = "";

		String postalCodeVal = dto.getPostalCode();

		ZipDto suggestedAddress = new ZipDto();

		boolean zipCodeIsCanadian = validateCanadianZipCode(postalCodeVal);
		String url = new StringBuffer().append(hereMapURL + "?" + "app_id=" + app_id + "&" + "app_code=" + app_code + "&" + "searchtext=").toString();

		if (zipCodeIsCanadian) {

			url = url + postalCodeVal;

		} else {

			url = url + postalCodeVal + "+US";
		}

		URL obj = URI.create(url).toURL();
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF8"));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		reader.close();

		Document doc = convertStringToXMLDocument(response.toString());

		if (doc != null) {
			NodeList nodeListResults = doc.getElementsByTagName("Address");
			if (nodeListResults != null) {
				NodeList childNodes = nodeListResults.item(0).getChildNodes();
				for (int k = 0; k < childNodes.getLength(); k++) {
					Element childEle = (Element) childNodes.item(k);
					if (childEle.getNodeName().equalsIgnoreCase("Country")) {
						country = childEle.getTextContent();

					} else if (childEle.getNodeName().equalsIgnoreCase("State")) {
						state = childEle.getTextContent();

					} else if (childEle.getNodeName().equalsIgnoreCase("City")) {
						city = childEle.getTextContent();

					} else if (childEle.getNodeName().equalsIgnoreCase("PostalCode")) {
						postalCode = childEle.getTextContent();

					} else {
						continue;
					}
				}

				if ("QC".toUpperCase().equals(state)) {
					state = "PQ";
				} else if ("NL".toUpperCase().equals(state)) {
					state = "NF";
				}

				// The postal code returned by Here Maps has a space
				// after 3 characters
				if (!StringUtils.isEmpty(postalCode)) {
					postalCode = postalCode.trim().replace(" ", "");
				}

				/**
				 * Verifying if the user-entered postal code and the postal code
				 * returned by Here Maps API are same. This is done due to the
				 * reason that Here Maps API returns the nearest zip code if the
				 * actual code is not found.
				 **/
				if (StringUtils.equalsAnyIgnoreCase(postalCode, postalCodeVal)) {

					/**
					 * Replace accented and umlaut alphabets with English
					 * alphabets since current database collation type does not
					 * support UTF-8
					 */

					char[] accentedCharacters = { 'Ç', 'é', 'â', 'ê', 'î', 'ô', 'û', 'à', 'è', 'ù', 'ë', 'ï', 'ü' };
					char[] replacedChars = { 'C', 'e', 'a', 'e', 'i', 'o', 'u', 'a', 'e', 'u', 'e', 'i', 'u' };

					for (int m = 0; m < accentedCharacters.length; m++) {
						city = city.replace(accentedCharacters[m], replacedChars[m]);
					}

					if (country.equalsIgnoreCase("CAN")) {
						suggestedAddress.setCountry("CA");
					} else {
						suggestedAddress.setCountry("US");

					}

					suggestedAddress.setProvinceState(state.toUpperCase());
					suggestedAddress.setCity(city.toUpperCase());

					if (postalCode == null) {

						suggestedAddress.setPostalCode(postalCodeVal.toUpperCase());
					} else {
						suggestedAddress.setPostalCode(postalCode.toUpperCase());
					}
				} else {
					// Condition when zip code is not found in the US as well as
					// Canada
					suggestedAddress.setPostalCode(postalCodeVal.toUpperCase());
					suggestedAddress.setCity("");
					suggestedAddress.setCountry("US");
					suggestedAddress.setProvinceState("");
				}
			}

		} else {
			logger.debug("Here Maps API did not respond with a valid xml.");
		}

		return suggestedAddress;

	}

	private static Document convertStringToXMLDocument(String xmlString) {
		// Parser that produces DOM object trees from XML content
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// API to obtain DOM Document instance

		try {
			// Create DocumentBuilder with default configuration
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Parse the string content to Document object
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			logger.debug("Error in string to xml conversion ", e);
		}
		return null;
	}

	private boolean validateCanadianZipCode(String postalCode) {
		char[] arrPostalCode = postalCode.toCharArray();
		if ((Character.isLetter(arrPostalCode[0])) && (Character.isLetter(arrPostalCode[2]))
				&& (Character.isLetter(arrPostalCode[4])) && (Character.isDigit(arrPostalCode[1]))
				&& (Character.isDigit(arrPostalCode[3])) && (Character.isDigit(arrPostalCode[5]))) {
			return true;
		}

		return false;
	}

}

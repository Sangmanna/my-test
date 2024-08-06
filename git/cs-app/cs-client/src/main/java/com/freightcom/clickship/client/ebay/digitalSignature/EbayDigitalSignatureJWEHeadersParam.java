package com.freightcom.clickship.client.ebay.digitalSignature;

public class EbayDigitalSignatureJWEHeadersParam {
	private String alg;
	private String enc;
	private String zip;

	/**
	 * Get Algorithm
	 * 
	 * @return algo algorithm
	 */
	public String getAlg() {
		return alg;
	}

	/**
	 * Set Algorithm
	 * 
	 * @param alg algorithm
	 */
	public void setAlg(String alg) {
		this.alg = alg;
	}

	/**
	 * Get Encryption
	 * 
	 * @return encryption encryption method
	 */
	public String getEnc() {
		return enc;
	}

	/**
	 * Set Encryption
	 * 
	 * @param enc encryption method
	 */
	public void setEnc(String enc) {
		this.enc = enc;
	}

	/**
	 * Get Compression method
	 * 
	 * @return compression compression method
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Set Compression method
	 * 
	 * @param zip compression method
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "JWEHeadersParam{" + "alg='" + alg + '\'' + ", enc='" + enc + '\'' + ", zip='" + zip + '\'' + '}';
	}
}
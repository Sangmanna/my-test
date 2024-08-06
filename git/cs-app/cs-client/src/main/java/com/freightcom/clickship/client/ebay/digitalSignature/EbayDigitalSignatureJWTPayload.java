package com.freightcom.clickship.client.ebay.digitalSignature;

public class EbayDigitalSignatureJWTPayload {
	private String pkey;

    /**
     * Get Public Key
     * @return public key
     */
    public String getPkey() {
        return pkey;
    }

    /**
     * Set Public Key
     * @param pkey public key
     */
    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    @Override
    public String toString() {
        return "JWTPayload{" + "pkey='" + pkey + '\'' + '}';
    }
}
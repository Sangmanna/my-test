package com.freightcom.clickship.client.ebay.digitalSignature;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Signature Config used for load config details
 */
@Component
public class EbayDigitalSignatureConfig {
	private final String PRIVATE_KEY_PREFIX = "-----BEGIN PRIVATE KEY-----";
	private final String PRIVATE_KEY_SUFFIX = "-----END PRIVATE KEY";
	
	// Algorithm used for generating content digest
    private String digestAlgorithm = "sha-256";

    // Algorithm used for signature
    private String algorithm = "Ed25519";

    // The symmetric key used for JWE encryption and decryption
    private String masterKey;

    // Private key generated using Key Management API
    private String privateKeyStr;

    // Public key generated using Key Management API
    private String publicKeyStr;

    private String jwe;

    // The JWT expiration in years
    private String jwtExpiration = "3";

    // The JWT payload params
    private EbayDigitalSignatureJWTPayload jwtPayload;

    // List of signature params
    private List<String> signatureParams = Arrays.asList("content-digest", "x-ebay-signature-key", "@method", "@path", "@authority");

    // Signature components for generating the base string
    private EbayDigitalSignatureComponent signatureComponents = new EbayDigitalSignatureComponent();

    // The JWE header params
    private EbayDigitalSignatureJWEHeadersParam jweHeadersParam;

    private PublicKey publicKey;

    private PrivateKey privateKey;

    public EbayDigitalSignatureConfig() {
        Security.addProvider(new BouncyCastleProvider());
    }

    public String getDigestAlgorithm() {
        return digestAlgorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public List<String> getSignatureParams() {
        return signatureParams;
    }

    public String getJwtExpiration() {
        return jwtExpiration;
    }

    public EbayDigitalSignatureJWTPayload getJwtPayload() {
        return jwtPayload;
    }

    public String getMasterKey() {
        return masterKey;
    }

    public String getJwe() {
        return jwe;
    }

    public EbayDigitalSignatureComponent getSignatureComponents() {
        return signatureComponents;
    }
    
    public void setSignatureComponents(EbayDigitalSignatureComponent comp) {
        signatureComponents = comp;
    }

    public EbayDigitalSignatureJWEHeadersParam getJweHeadersParam() {
        return jweHeadersParam;
    }
    
    public String getPrivateKeyStr() {
		return privateKeyStr;
	}

	public void setPrivateKeyStr(String privateKeyStr) {
		if(StringUtils.startsWith(privateKeyStr, PRIVATE_KEY_PREFIX)) {
			this.privateKeyStr = privateKeyStr;
		}else {
			this.privateKeyStr = PRIVATE_KEY_PREFIX + "\n" + privateKeyStr + "\n" + PRIVATE_KEY_SUFFIX;
		}
		
	}

	public String getPublicKeyStr() {
		return publicKeyStr;
	}

	public void setPublicKeyStr(String publicKeyStr) {
		this.publicKeyStr = publicKeyStr;
	}

	public void setMasterKey(String masterKey) {
		this.masterKey = masterKey;
	}

	public void setJwe(String jwe) {
		this.jwe = jwe;
	}

	/**
     * Extract JWT expiration year value from Config
     *
     * @return JWT expiration year value
     */
    @JsonIgnore
    public int getJwtExpirationYear() {
        if (jwtExpiration != null) {
            return Integer.parseInt(jwtExpiration);
        }
        //default to 3 Years
        return 3;
    }

    @Override
    public String toString() {
        return "SignatureConfig{" + "digestAlgorithm='" + digestAlgorithm + '\''
            + ", algorithm='" + algorithm + '\'' + ", masterKey='" + masterKey
            + '\'' + ", privateKeyStr='" + privateKeyStr + '\''
            + ", publicKeyStr='" + publicKeyStr + '\'' + ", jwe='" + jwe + '\''
            + ", jwtExpiration='" + jwtExpiration + '\'' + ", jwtPayload="
            + jwtPayload + ", signatureParams=" + signatureParams
            + ", signatureComponents=" + signatureComponents
            + ", jweHeadersParam=" + jweHeadersParam + ", publicKey="
            + publicKey + ", privateKey=" + privateKey + '}';
    }

    /**
     * Get public key value as a file or as a string value
     *
     * @return publicKey public key
     * @throws EbayDigitalSignatureException signature exception
     */
    public PublicKey getPublicKey() throws EbayDigitalSignatureException {
        if (publicKey != null) {
            return publicKey;
        }

        Reader reader = null;
        if (publicKeyStr.contains("-----BEGIN PUBLIC KEY-----")) {
            reader = new StringReader(publicKeyStr);
        } else {
            try {
                reader = new FileReader(publicKeyStr);
            } catch (FileNotFoundException e) {
                throw new EbayDigitalSignatureException(
                    "Error loading public file: " + e.getMessage(), e);
            }
        }
        publicKey = getPublic(reader);
        return publicKey;
    }

    /**
     * Get private key value as a file or as a string value
     *
     * @return privateKey private key
     * @throws EbayDigitalSignatureException signature exception
     */
    public PrivateKey getPrivateKey() throws EbayDigitalSignatureException {
        if (privateKey != null) {
            return privateKey;
        }

        Reader reader = null;
        if (privateKeyStr.contains("-----BEGIN PRIVATE KEY-----")) {
            reader = new StringReader(privateKeyStr);
        } else {
            try {
                reader = new FileReader(privateKeyStr);
            } catch (FileNotFoundException e) {
                throw new EbayDigitalSignatureException(
                    "Error loading private file: " + e.getMessage(), e);
            }
        }
        privateKey = getPrivate(reader);
        return privateKey;
    }

    /**
     * Extract Private key from reader(string or file)
     *
     * @param reader IO reader
     * @return privateKey private key
     * @throws EbayDigitalSignatureException signature exception
     */
    private PrivateKey getPrivate(Reader reader) throws EbayDigitalSignatureException {
		PEMParser pemParser = null;

		try {
			pemParser = new PEMParser(reader);
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
            PrivateKeyInfo privateKeyInfo = PrivateKeyInfo.getInstance(pemParser.readObject());
            return converter.getPrivateKey(privateKeyInfo);
        } catch (PEMException ex) {
            throw new EbayDigitalSignatureException(
                "Error parsing private key: " + ex.getMessage(), ex);
        } catch (IOException e) {
            throw new EbayDigitalSignatureException(
                "Error loading private file: " + e.getMessage(), e);
        } finally {
        	closePerParser(pemParser);
        }
        
    }

    /**
     * Extract Public key from reader(string or file)
     *
     * @param reader IO reader
     * @return publicKey public key
     * @throws EbayDigitalSignatureException signature exception
     */
    private PublicKey getPublic(Reader reader) throws EbayDigitalSignatureException {
		PEMParser pemParser = null;

		try {
			pemParser = new PEMParser(reader);
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
            SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfo
                .getInstance(pemParser.readObject());
            return converter.getPublicKey(publicKeyInfo);
        } catch (PEMException ex) {
            throw new EbayDigitalSignatureException(
                "Error parsing public key: " + ex.getMessage(), ex);
        } catch (IOException e) {
            throw new EbayDigitalSignatureException(
                "Error loading public file: " + e.getMessage(), e);
		} finally {
			closePerParser(pemParser);
		}
    }
    
	private void closePerParser(PEMParser pemParser) {
		if (pemParser != null) {
			try {
				pemParser.close();
			} catch (IOException e) {
			}
		}
	}
}
package com.freightcom.clickship.client.ebay.digitalSignature;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.bouncycastle.crypto.signers.RSADigestSigner;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.CompressionAlgorithm;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.AESEncrypter;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;

@Service
public class EbayDigitalSignatureService {
	
	@Autowired
	EbayDigitalSignatureConfig ebayDigitalSignatureConfig;

    /**
     * Generate Content Digest
     *
     * @param body request body
     * @param ebayDigitalSignatureConfig signature config
     * @return contentDigest content digest
     * @throws EbayDigitalSignatureException signature exception
     */
    public String generateContentDigest(String body) throws EbayDigitalSignatureException {

        if(StringUtils.isBlank(body)){
            return null;
        }

        String contentDigest = "";
        String cipher = ebayDigitalSignatureConfig.getDigestAlgorithm();
        try {
            MessageDigest messageDigest = MessageDigest
                .getInstance(cipher.toUpperCase());
            String digest = new String(Base64.encode(
                messageDigest.digest(body.getBytes(StandardCharsets.UTF_8))));
            if (StringUtils.isNotBlank(digest)) {
                contentDigest = new StringBuilder().append(cipher).append("=:")
                    .append(digest).append(":").toString();
            }

        } catch (Exception ex) {
            throw new EbayDigitalSignatureException(
                "Error generating Content-Digest header: " + ex.getMessage(),
                ex);
        }
        return contentDigest;

    }

    /**
     * Generate Signature Key Header
     *
     * @param ebayDigitalSignatureConfig signature config
     * @return signature key
     * @throws EbayDigitalSignatureException signature exception
     */
    public String generateSignatureKeyHeader()
        throws EbayDigitalSignatureException {
        return getJWE();
    }

    /**
     * Generate Signature Input header
     *
     * @param contentDigest content digest
     * @param signatureParams signature params
     * @return signatureInputHeader
     */
    public String getSignatureInput(String contentDigest) {
        StringBuilder signatureInputBuf = new StringBuilder();
        signatureInputBuf.append("(");
        List<String> signatureParams = ebayDigitalSignatureConfig.getSignatureParams();
        for (int i = 0; i < signatureParams.size(); i++) {
            String param = signatureParams.get(i);
            if(param.equalsIgnoreCase(EbayDigitalSignatureConstant.CONTENT_DIGEST) && contentDigest==null){
                continue;
            }
            signatureInputBuf.append("\"");
            signatureInputBuf.append(param);
            signatureInputBuf.append("\"");
            if (i < signatureParams.size() - 1) {
                signatureInputBuf.append(" ");
            }
        }

        signatureInputBuf.append(");created=");
        signatureInputBuf.append(Instant.now().getEpochSecond());
        return signatureInputBuf.toString();
    }

    /**
     * Get 'Signature' header value
     *
     * @param headers request headers
     * @param ebayDigitalSignatureConfig signature config
     * @return signature signature
     * @throws EbayDigitalSignatureException signature exception
     */
    public String getSignature(Map<String, String> headers) throws EbayDigitalSignatureException {
        try {
            String baseString = calculateBase(headers);
            byte[] base = baseString.getBytes(StandardCharsets.UTF_8);

            Signer signer;
            if (ebayDigitalSignatureConfig.getAlgorithm().equals(EbayDigitalSignatureConstant.ALGORITHM_Ed25519)) {
                signer = new Ed25519Signer();
            } else {
            	signer = new RSADigestSigner(new SHA256Digest());
            }
            AsymmetricKeyParameter privateKeyParameters = PrivateKeyFactory
                .createKey(ebayDigitalSignatureConfig.getPrivateKey().getEncoded());
            signer.init(true, privateKeyParameters);
            signer.update(base, 0, base.length);
            byte[] signature = signer.generateSignature();

            String signatureStr = new String(Base64.encode(signature));
            return new StringBuilder().append(EbayDigitalSignatureConstant.SIGNATURE_PREFIX).append(signatureStr)
                .append(":").toString();
        } catch (CryptoException | IOException ex) {
            throw new EbayDigitalSignatureException(
                "Error creating value for signature: " + ex.getMessage(), ex);
        }
    }

    /**
     * Get JWE value
     * @param ebayDigitalSignatureConfig signature config
     * @return JWE JWE value
     * @throws EbayDigitalSignatureException
     */
    String getJWE() throws EbayDigitalSignatureException {
        try {

            if(StringUtils.isNotBlank(ebayDigitalSignatureConfig.getJwe())){
                return ebayDigitalSignatureConfig.getJwe();
            }
            // Compose the JWT claims set
            Date now = new Date();

            JWTClaimsSet jwtClaims = new JWTClaimsSet.Builder()
                .expirationTime(new Date(now.getTime() + 1000L * 60 * 60 * 24 * 365 * ebayDigitalSignatureConfig.getJwtExpirationYear())) // expires in 3 years
                .notBeforeTime(now)
                .issueTime(now)
                .jwtID(UUID.randomUUID().toString())
                .claim("pkey", ebayDigitalSignatureConfig.getJwtPayload().getPkey()) // public ed25519 key
                .build();


            // Request JWT encrypted with DIR and 256-bit AES/GCM
            JWEHeader header = new JWEHeader.Builder(JWEAlgorithm.parse(ebayDigitalSignatureConfig.getJweHeadersParam().getAlg()), EncryptionMethod
                .parse(ebayDigitalSignatureConfig.getJweHeadersParam().getEnc()))
                .compressionAlgorithm(new CompressionAlgorithm(ebayDigitalSignatureConfig.getJweHeadersParam().getZip()))
                .build();

            String secretKeyBase64 = ebayDigitalSignatureConfig.getMasterKey();
            final byte[] secretKey = Base64.decode(secretKeyBase64);
            JWEEncrypter jweEncrypter = new AESEncrypter(secretKey);

            // Create the encrypted JWT object
            EncryptedJWT jwt = new EncryptedJWT(header, jwtClaims);

            // Do the actual encryption
            jwt.encrypt(jweEncrypter);

            // Serialise to JWT compact form
            String jwtString = jwt.serialize();

            return jwtString;
        } catch (JOSEException ex) {
            throw new EbayDigitalSignatureException("Error creating JWE: " + ex.getMessage(), ex);
        }

    }

    /**
     * Method to calculate base string value
     *
     * @param headers request headers
     * @param ebayDigitalSignatureConfig signature config
     * @return calculatedBase base string
     * @throws EbayDigitalSignatureException
     */
     String calculateBase(Map<String, String> headers) throws EbayDigitalSignatureException {
        try {
            StringBuilder buf = new StringBuilder();
            EbayDigitalSignatureComponent signatureComponent = ebayDigitalSignatureConfig
                .getSignatureComponents();
            List<String> signatureParams = ebayDigitalSignatureConfig.getSignatureParams();
            for (String header : signatureParams) {
                if (header.equalsIgnoreCase(EbayDigitalSignatureConstant.CONTENT_DIGEST)
                    && headers.get(EbayDigitalSignatureConstant.CONTENT_DIGEST) == null) {
                    continue;
                }
                buf.append("\"");
                buf.append(header.toLowerCase());
                buf.append("\": ");

                if (header.startsWith("@")) {
                    switch (header.toLowerCase()) {
                    case "@method":
                        buf.append(signatureComponent.getMethod());
                        break;
                    case "@authority":
                    	String auth = signatureComponent.getAuthority();
                    	auth = auth.endsWith(":80") ? auth : auth + ":80";
                        buf.append(auth);
                        break;
                    case "@target-uri":
                        buf.append(signatureComponent.getTargetUri());
                        break;
                    case "@path":
                        buf.append(signatureComponent.getPath());
                        break;
                    case "@scheme":
                        buf.append(signatureComponent.getScheme());
                        break;
                    case "@request-target":
                        buf.append(signatureComponent.getRequestTarget());
                        break;
                    default:
                        throw new EbayDigitalSignatureException(
                            "Unknown pseudo header " + header);
                    }
                } else {
                    if (!headers.containsKey(header)) {
                        throw new EbayDigitalSignatureException(
                            "Header " + header + " not included in message");
                    }

                    buf.append(headers.get(header));
                }

                buf.append("\n");
            }

            buf.append("\"@signature-params\": ");
            buf.append(getSignatureInput(headers.get(EbayDigitalSignatureConstant.CONTENT_DIGEST)));
            return buf.toString();
        } catch (Exception ex) {
            throw new EbayDigitalSignatureException(
                "Error calculating signature base: " + ex.getMessage(), ex);
        }
    }

}
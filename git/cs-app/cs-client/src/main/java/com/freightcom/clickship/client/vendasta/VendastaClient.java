package com.freightcom.clickship.client.vendasta;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.LRUMap;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.freightcom.clickship.model.KeyValue;
import com.freightcom.clickship.model.marketplace.vendasta.VendastaActivationReq;
import com.freightcom.clickship.model.marketplace.vendasta.VendastaActivity;
import com.freightcom.clickship.model.marketplace.vendasta.VendastaEndPoint;
import com.freightcom.clickship.model.marketplace.vendasta.VendastaPublicKey;
import com.freightcom.clickship.model.marketplace.vendasta.VendastaPublicKey_;
import com.freightcom.clickship.model.marketplace.vendasta.VendastaTokenRequest;
import com.freightcom.clickship.model.marketplace.vendasta.VendastaTokenResponse;
import com.freightcom.clickship.model.marketplace.vendasta.VendastaUser;

@Component
public class VendastaClient {
    
	@Value("${server.domain}")
    private String clickshipDomain;

    @Value("${vendasta.auth_url:sso-api-prod.apigateway.co}")
    private String vendastaAuthUrl;

    @Value("${vendasta.issuer_url:iam-prod.apigateway.co}")
    private String vendastaIssuerUrl;

    @Value("${vendasta.app.client_id:e304ef51-aefe-4729-9c1c-c5ab1a2eab99}")
    private String vendastaAppClientId;

    @Value("${vendasta.app.client_secret:eSL8nCRtb2bEnGBkq7bRBetVDK8hdMAOofnqYInSVM}")
    private String vendastaAppClientSecret;

    @Value("${vendasta.app.redirect-uri:/external-registration-token}")
    private String vendastaRedirectUri;

    @Value("${vendasta.developer_url:developers.vendasta.com}")
    private String vendastaDeveloperUrl;

    @Autowired
    private RestTemplate restTemplate;

    private final LRUMap<String, VendastaPublicKey> map = new LRUMap<>();

    public VendastaTokenResponse fetchAccessAndIdToken (String accessCode) {
        URI fetchAccessTokenUrl = getUrl(VendastaEndPoint.GET_ACCESS_ID_TOKEN.getValue(), vendastaAuthUrl, null);

        HttpHeaders httpHeaders = getHttpHeadersForAuthExchange();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "authorization_code");
        map.add("code", accessCode);
        map.add("redirect_uri", new StringBuilder(clickshipDomain).append(vendastaRedirectUri).toString());
        map.add("client_id", vendastaAppClientId);
        map.add("client_secret", vendastaAppClientSecret);
        map.add("scope", "openid");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, httpHeaders);

        return restTemplate.exchange(fetchAccessTokenUrl, HttpMethod.POST, request, VendastaTokenResponse.class).getBody();
    }

    public String fetchAccessBearerToken (VendastaTokenRequest vendastaTokenRequest) {
        URI fetchAccessTokenUrl = getUrl(VendastaEndPoint.GET_ACCESS_BEARER_TOKEN.getValue(), vendastaDeveloperUrl, null);

        return restTemplate.exchange(fetchAccessTokenUrl, HttpMethod.POST, getRequestEntity(null, vendastaTokenRequest), String.class).getBody();
    }

    public void activateOrDeactivatePendingVendastaAccount (String accessToken, VendastaActivationReq req) {
        URI activatePendingAccountUrl = getUrl(VendastaEndPoint.ACTIVATE_ACCOUNT.getValue(), vendastaDeveloperUrl, null);
        restTemplate.exchange(activatePendingAccountUrl, HttpMethod.POST, getRequestEntity(accessToken, req), String.class).getStatusCode();
    }

    public VendastaUser fetchVendastaUserInfo (String accessToken) {
        URI getUserInfoUrl = getUrl(VendastaEndPoint.USER_INFO.getValue(), vendastaAuthUrl, null);
        return restTemplate.exchange(getUserInfoUrl, HttpMethod.GET, getRequestEntity(accessToken, null), VendastaUser.class).getBody();
    }

    public HttpStatusCode verifyUserAccessToAccount (String accessToken, String userId, String accountId) {
        URI getUserAccessUrl = getUrl(String.format(VendastaEndPoint.USER_ACCESS.getValue(), userId, accountId), vendastaDeveloperUrl, null);

        return restTemplate.exchange(getUserAccessUrl, HttpMethod.HEAD, getRequestEntity(accessToken, null), String.class).getStatusCode();
    }

    public void sendVendastaActivityNotification (String accessToken, VendastaActivity req) {
        URI activityStreamUrl = getUrl(VendastaEndPoint.ACTIVITY_STREAM.getValue(), vendastaDeveloperUrl, null);
        restTemplate.exchange(activityStreamUrl, HttpMethod.POST, getRequestEntity(accessToken, req), String.class).getStatusCode();
    }

    private HttpEntity<Object> getRequestEntity(String authToken, Object requestBody) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (authToken !=null) {
            requestHeaders.set("Authorization", "Bearer " + authToken);
        }

        if (requestBody != null) {
            return new HttpEntity<>(requestBody, requestHeaders);
        } else {
            return new HttpEntity<>(requestHeaders);
        }
    }

    public VendastaPublicKey getPublicKey(String publicKeyId) {
        if(publicKeyId == null) {
            return null;
        }

        VendastaPublicKey publicKey = map.get(publicKeyId);

        if (publicKey != null) {
            return publicKey;
        }

        return getVendastaPublicKey(publicKeyId);
    }


    private synchronized VendastaPublicKey getVendastaPublicKey(String publicKeyId) {
        URI publicKeyUrl = getUrl(VendastaEndPoint.GET_CERTS.getValue(), vendastaIssuerUrl, null);

        VendastaPublicKey_ publicKey = restTemplate.exchange(publicKeyUrl, HttpMethod.GET, null, VendastaPublicKey_.class).getBody();

        if (publicKey !=null) {
            List<VendastaPublicKey> publicKeys = publicKey.getVendastaPublicKey();
            Optional<VendastaPublicKey> key = null;
            if (CollectionUtils.isNotEmpty(publicKeys)) {
                key = publicKeys.stream().filter(k -> k.getKid().equalsIgnoreCase(publicKeyId)).findFirst();
                
                if (key.isPresent()) {
                    map.putIfAbsent(publicKeyId, key.get());

                    return key.get();
                }
            }
        }
        return null;
    }

    private HttpHeaders getHttpHeadersForAuthExchange() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return requestHeaders;
    }

    private URI getUrl(String path, String host, List<KeyValue> requestParams) {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost(host);
        uriBuilder.setPath(path);

        if (CollectionUtils.isNotEmpty(requestParams)) {
            requestParams.forEach(pair -> uriBuilder.setParameter(pair.getKey(), String.valueOf(pair.getValue())));
        }

        try {
            return uriBuilder.build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(
                    String.format("Error while constructing url:%s, path:%s", vendastaAuthUrl, path));
        }
    }

}

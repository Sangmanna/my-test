package com.freightcom.clickship.service.service;

import com.freightcom.clickship.client.ebay.EbayRestClient;
import com.freightcom.clickship.client.ebay.auth.RefreshAccessTokenRequest;
import com.freightcom.clickship.client.ebay.auth.TokenGenerationResponse;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.rep.MarketplaceRepository;

public interface IEbayRefreshTokenService {
	
	/**
	 * This replaces the attribute 'token' of the marketplace passed from caller. 
	 * 
	 * @param marketplace
	 * @return
	 */
	public default void refreshAccessToken(Marketplace marketplace) {
        // as per eBay documentation, access token is only valid for 2 hours and we can exchange refresh token with access token which is valid for more than 500+ days
        // once the refresh token expires, user has to login again and authenticate.
		RefreshAccessTokenRequest refreshAccessTokenRequest = new RefreshAccessTokenRequest();
		refreshAccessTokenRequest.setGrantType("refresh_token");
		refreshAccessTokenRequest.setRefreshToken(marketplace.getPrivateKey());

		TokenGenerationResponse tokenGenerationResponse = getEbayClient().refreshMarketplaceAccessToken(refreshAccessTokenRequest);

		marketplace.setToken(tokenGenerationResponse.getAccessToken());
		getMarketplaceRepository().save(marketplace);
	}

	public EbayRestClient getEbayClient();

	public MarketplaceRepository getMarketplaceRepository();
}

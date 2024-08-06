package com.freightcom.clickship.service.service.integrations.woocommerce;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WooCommerceService {
	
//	@Autowired
//	private MarketplaceRepository marketplaceRepository;
	
//	@Autowired
//	private MarketplaceWebhooksRepository marketplaceWebhooksRepository;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void disableStore(String marketplaceId) {
		//TODO due to time constrain not able to implement the api call to get the updates
		// from the previous last update. So for now not deleting the webhooks for when disabling store
		// once complete the get upates api call to get the from specific date disable webhooks
		// once disable store.
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void enableStore(String marketplaceId) {
		// TODO Enable webhooks once starting deleting webhooks task completes when disabling store.  
	}
	
	public void deleteWebhooks(String marketplaceId) throws Exception {
		//TODO WooCoomerce client
		try {
/*			Marketplace marketplace = getMarketplace(marketplaceId);
			List<MarketplaceWebhooks> webhooks = marketplaceWebhooksRepository.findAllByMarketplace(marketplace);
			
			if(CollectionUtils.isNotEmpty(webhooks)) {
				List<String> deleteRequests = webhooks.stream()
						.filter(wh -> wh.getExternalWebhooksId() != null)
						.map(wh -> { return wh.getExternalWebhooksId(); }).collect(Collectors.toList());
				
				
				WooCommerceWebhookBatchRequest batchRequest = new WooCommerceWebhookBatchRequest(null, deleteRequests);
 			    client.webhooksBatchRegistration(getWooCommerceAuth(marketplace), batchRequest);
			}
			*/
		} catch (Exception e) {
			String message = String.format("Exception while deleting webhooks, Error: [%s]", e.getMessage());
			throw new Exception(message);
		}
	}

}

package com.freightcom.clickship.service.service.integrations;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceType;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.rep.MarketplaceTypeRepository;
import com.freightcom.clickship.model.exception.marketplace.LocationSplitException;
import com.freightcom.clickship.model.exception.marketplace.MarketplaceRuntimeException;
import com.freightcom.clickship.model.order.MoveLocationOrderDTO;
import com.freightcom.clickship.service.service.LocationSplitOrderService;

@Component
public abstract class AbstractLocationSplitOrderService implements LocationSplitOrderService {

	private static final String ERROR_MSG = "This feature is only available for %s orders";
	private static final String MOVE_ERROR_MSG = "Location move is only available for %s orders.";
	private static final String SPLIT_UI_ERROR_MSG = "Location Split is only available for %s orders. Please choose %s orders when splitting them based on location.";
	
	@Autowired
	protected MarketplaceTypeRepository marketplaceTypeRepository;
	
	@Override
	public void processLocationSplitUiRequest(Marketplace marketplace, String orderId, User user) {
		String names = getLocationSplitEnabledMarketplaceNames();
		throw new LocationSplitException(String.format(SPLIT_UI_ERROR_MSG, names, names));
	}
	
	@Override
	public void moveOrderToNewLocation(Marketplace marketplace, MoveLocationOrderDTO dto) {
		String names = getLocationSplitEnabledMarketplaceNames();
		throw new LocationSplitException(String.format(MOVE_ERROR_MSG, names));
	}
	
	@Override
	public void processOrderUpdateRequest(Marketplace marketplace, String externalOrderId) {
		String names = getLocationSplitEnabledMarketplaceNames();
		throw new MarketplaceRuntimeException(String.format(ERROR_MSG, names));
	}
	
	@Override
	public void processLocationSplitWebhookRequest(Marketplace marketplace, Map<String, Object> map) {
		String names = getLocationSplitEnabledMarketplaceNames();
		throw new MarketplaceRuntimeException(String.format(ERROR_MSG, names));
	}
	
	private String getLocationSplitEnabledMarketplaceNames() {
		List<MarketplaceType> list = marketplaceTypeRepository.findAll();
		return list.stream().filter(MarketplaceType::isLocationSplitAllowed).map(mt -> mt.getName()).collect(Collectors.joining(", "));
	}
		
}

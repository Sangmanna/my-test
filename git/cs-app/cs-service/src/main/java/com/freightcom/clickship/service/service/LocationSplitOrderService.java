package com.freightcom.clickship.service.service;

import java.util.Map;

import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.model.order.MoveLocationOrderDTO;

public interface LocationSplitOrderService extends ICheckAccess {
	
	public void processLocationSplitUiRequest(Marketplace marketplace, String orderId, User user);
	
	public void moveOrderToNewLocation(Marketplace marketplace, MoveLocationOrderDTO dto);
	
	public void processOrderUpdateRequest(Marketplace marketplace, String externalOrderId);
	
	public void processLocationSplitWebhookRequest(Marketplace marketplace, Map<String, Object> map);
	
}

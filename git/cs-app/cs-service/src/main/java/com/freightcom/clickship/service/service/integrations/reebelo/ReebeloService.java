package com.freightcom.clickship.service.service.integrations.reebelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.rep.OrderRepository;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloOrder;

@Service
public class ReebeloService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ReebeloTransformer reebeloTransformer;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Order saveOrder(Marketplace marketplace, ReebeloOrder reebeloOrder) {
		Order order = reebeloTransformer.getCsOrder(marketplace, reebeloOrder);
		orderRepository.save(order);
		order.setDiscounts(reebeloTransformer.getDiscountsFromReebeloOrder(reebeloOrder, order));
		order.setTaxList(reebeloTransformer.getTaxesFromReebeloOrder(reebeloOrder, order));
		order.setOrderlines(reebeloTransformer.getLineItems(reebeloOrder, order));
		orderRepository.save(order);
		return order;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateAndSaveExistingOrder(Order order, ReebeloOrder reebeloOrder) {
		order.setDiscounts(reebeloTransformer.getDiscountsFromReebeloOrder(reebeloOrder, order));
		order.setTaxList(reebeloTransformer.getTaxesFromReebeloOrder(reebeloOrder, order));
		order.setOrderlines(reebeloTransformer.getLineItems(reebeloOrder, order));
		orderRepository.save(order);
	}
}

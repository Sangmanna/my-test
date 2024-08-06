package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.MarketplaceProduct;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Orderline;

@Repository
public interface OrderlineRepository extends JpaRepository<Orderline, String> {
	
	public List<Orderline> findAllByOrder(Order order);

	public Orderline findByExternalLineIdAndOrder(String externalLineId, Order order);
	
	public Orderline findByExternalLineId(String externalLineId);
	
	public List<Orderline> findAllByMarketplaceProduct(MarketplaceProduct marketplaceProduct);
	
}